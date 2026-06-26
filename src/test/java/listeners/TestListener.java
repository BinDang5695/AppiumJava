package listeners;

import constants.ConfigData;
import helpers.SystemHelpers;
import keywords.MobileUI;
import utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ThreadLocal<String> videoFile = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("♻\uFE0F Setup environment: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("\uD83D\uDD06 Test run completed: " + result.getEndDate());
    }

    @Override
    public void onTestStart(ITestResult result) {

        LogUtils.info("START: " + result.getName());

        if (ConfigData.RECORD_VIDEO.equalsIgnoreCase("true")) {

            videoFile.set(result.getName() + "_" + System.currentTimeMillis() + ".mp4");

            //CaptureHelpers.startRecording();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        LogUtils.info("PASS: " + result.getName());

        if (ConfigData.SCREENSHOT_PASS.equalsIgnoreCase("true")) {
            //CaptureHelpers.captureScreenshot(result.getName());
        }

        if (ConfigData.RECORD_VIDEO.equalsIgnoreCase("true")) {

            MobileUI.sleep(1);

            String path = SystemHelpers.getCurrentDir()
                    + ConfigData.RECORD_VIDEO_PATH
                    + videoFile.get();

            //CaptureHelpers.stopRecording(path);

            videoFile.remove();
        }
//        AllureManager.saveTextLog("PASSED: " + result.getName());
//        AllureManager.saveScreenshotPNG("PASSED - " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        LogUtils.info("FAIL: " + result.getName());

        if (ConfigData.SCREENSHOT_FAIL.equalsIgnoreCase("true")) {
            //CaptureHelpers.captureScreenshot(result.getName());
        }

        if (ConfigData.RECORD_VIDEO.equalsIgnoreCase("true")) {

            MobileUI.sleep(1);

            String path = SystemHelpers.getCurrentDir()
                    + ConfigData.RECORD_VIDEO_PATH
                    + videoFile.get();

            //CaptureHelpers.stopRecording(path);

            videoFile.remove();
        }

//        AllureManager.saveTextLog("FAILED: " + result.getName());
//        AllureManager.saveScreenshotPNG("FAILED - " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("SKIP: " + result.getName());
    }

}