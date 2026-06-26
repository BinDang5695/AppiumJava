package dataproviders;

import model.Payment;
import helpers.JsonHelpers;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;

public class CheckoutDataProvider {

    @DataProvider(name = "checkoutDataJSON")
    public Object[][] checkoutDataJSON() {

        JsonNode root = JsonHelpers.getJsonNode(
                "src/test/resources/test_data/checkoutData.json"
        );

        JsonNode cases = root.get("checkoutCase");

        Object[][] data = new Object[cases.size()][1];

        for (int i = 0; i < cases.size(); i++) {

            JsonNode node = cases.get(i);

            Payment dataObj = new Payment(
                    node.get("fullName").asText(),
                    node.get("addressLine1").asText(),
                    node.get("addressLine2").asText(),
                    node.get("city").asText(),
                    node.get("zipCode").asText(),
                    node.get("country").asText(),
                    node.get("cardName").asText(),
                    node.get("cardNumber").asText(),
                    node.get("expirationDate").asText(),
                    node.get("securityCode").asText()
            );

            data[i][0] = dataObj;
        }

        return data;
    }
}