package helpers;

import constants.ConfigData;
import drivers.DriverManager;
import utils.DateUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Base64;

public class CaptureHelpers {

    public static void captureScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

            SystemHelpers.createFolder(SystemHelpers.getCurrentDir() + ConfigData.SCREENSHOT_PATH);
            String filePath = SystemHelpers.getCurrentDir() + ConfigData.SCREENSHOT_PATH + fileName + "_" + Thread.currentThread().getId() + "_" + SystemHelpers.makeSlug(DateUtils.getCurrentDateTime()) + ".png";

            Path targetPath = new File(filePath).toPath();

            Files.copy(srcFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot taken successfully, saved at: " + targetPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error during image file saving: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error during screenshot capture: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void startRecording() {

        if (DriverManager.getDriver() != null) {

            ((CanRecordScreen) DriverManager.getDriver())
                    .startRecordingScreen(
                            new AndroidStartScreenRecordingOptions()
                                    .withBitRate(4000000)
                                    .withVideoSize("1080x2400")
                                    .withTimeLimit(Duration.ofMinutes(10))
                    );

            System.out.println("Start recording video");
        }
    }

    public static void stopRecording(String videoFileName) {
        if (DriverManager.getDriver() != null) {
            try {
                String base64Video = ((CanRecordScreen) ((AndroidDriver) DriverManager.getDriver()))
                        .stopRecordingScreen();

                if (base64Video != null && !base64Video.isEmpty()) {

                    byte[] videoBytes = Base64.getDecoder().decode(base64Video);

                    File file = new File(videoFileName);

                    file.getParentFile().mkdirs();

                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        fos.write(videoBytes);
                    }

                    System.out.println("Saved video: " + file.getAbsolutePath());
                }

            } catch (Exception e) {
                System.err.println("Error stop recording: " + e.getMessage());
            }
        }
    }
}