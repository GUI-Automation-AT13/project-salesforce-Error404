package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.utils.EncryptorAES;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Product;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.product.NewProductPage;
import salesforce.ui.pages.product.ProductPage;
import salesforce.ui.pages.product.ProductsPage;
import salesforce.utils.ConverterToEntity;
import salesforce.utils.FileTranslator;
import java.util.Map;
import java.util.Set;
import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

public class CreateProductSteps {
    private Logger logger = LogManager.getLogger(getClass());
    ProductsPage productsPage;
    Product product;
    ProductPage productPage;
    Set<String> fields;

    public CreateProductSteps(Product product) {
        this.product = product;
    }

    @When("I create a new Product with fields")
    public void iCreateANewProductWithFields(final Map<String, String> table) throws JsonProcessingException {
        logger.info("=================== When I create a new product ==========================");
        productsPage = new ProductsPage();
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        product = ConverterToEntity.convertMapToEntity(table, Product.class);
        fields = table.keySet();
        productPage = newProductPage.createProduct(table.keySet(), product);
    }

    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productPage.getUserSuccessMessage().contains(product.getName()), "Message is incorrect");
        softAssert.assertAll();
    }

    @And("Check product fields matches")
    public void allProductFieldsMatches() {
        logger.info("=================== And All the given details fields should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product.getName(), productPage.getSpanText(FileTranslator.translateValue("Products", "productName")), "Product name is incorrect");
        softAssert.assertEquals(product.isActive(), productPage.isActive());
        softAssert.assertEquals(product.getProductCode(), productPage.getSpanText(FileTranslator.translateValue("Products", "productCode")), "Product code is incorrect");
        softAssert.assertEquals(product.getFamily(), productPage.getSpanText(FileTranslator.translateValue("Products", "productFamily")), "Product family is incorrect");
        softAssert.assertAll();
    }

    @And("Check The title matches")
    public void validateTheTitleMatches() {
        logger.info("=================== And The title should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product.getName(), productPage.getProductTitle(), "The title is incorrect");
        softAssert.assertAll();
    }
}
