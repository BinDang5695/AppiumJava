package testcases.TaurusApp;

import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(priority = 1)
    public void addProduct() {
        loginPage().login("admin", "admin");
        basePage().clickMenuConfig();
        configPage().downloadDataFromServer(4);
        configPage().openProductManagement();
        productPage().addNewProduct();
        productPage().verifyAddedProduct();
    }

    @Test(priority = 2)
    public void updateProduct() {
        loginPage().login("admin", "admin");
        basePage().clickMenuConfig();
        configPage().downloadDataFromServer(4);
        configPage().openProductManagement();
        productPage().addNewProduct();
        productPage().updateProduct();
        productPage().verifyUpdatedProduct();
    }

    @Test(priority = 3)
    public void deleteProduct() {
        loginPage().login("admin", "admin");
        basePage().clickMenuConfig();
        configPage().downloadDataFromServer(4);
        configPage().openProductManagement();
        productPage().addNewProduct();
        productPage().updateProduct();
        productPage().deleteProduct();
        productPage().verifyDeletedProduct();
    }
}