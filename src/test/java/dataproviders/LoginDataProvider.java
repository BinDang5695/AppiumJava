package dataproviders;

import constants.ConfigData;
import helpers.ExcelHelpers;
import helpers.JsonHelpers;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "invalidLoginDataJSON")
    public Object[][] invalidLoginDataJSON() {

        JsonNode root = JsonHelpers.getJsonNode(
                "src/test/resources/test_data/loginData.json"
        );

        JsonNode cases = root.get("invalidLoginCases");

        Object[][] data = new Object[cases.size()][4];

        for (int i = 0; i < cases.size(); i++) {
            data[i][0] = cases.get(i).get("email").asText();
            data[i][1] = cases.get(i).get("password").asText();
            data[i][2] = cases.get(i).get("message").asText();
            data[i][3] = cases.get(i).get("name").asText();
        }

        return data;
    }

    @DataProvider(name = "loginExcelData")
    public Object[][] loginExcelData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        return excelHelpers.getDataHashTable(
                ConfigData.EXCEL_DATA_FILE_PATH,
                "Login_MyDemoApp",
                1,
                3
        );
    }
}
