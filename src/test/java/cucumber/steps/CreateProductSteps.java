package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.utils.EncryptorAES;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Product;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.product.NewProductPage;
import salesforce.ui.pages.product.ProductPage;
import salesforce.ui.pages.product.ProductsPage;
import salesforce.utils.ConverterToEntity;
import salesforce.utils.Translator;
import java.util.Map;
import java.util.Set;
import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

public class CreateProductSteps {
    LoginPage loginPage;
    ProductsPage productsPage;
    Product product;
    ProductPage productPage;
    Set<String> fields;
    EncryptorAES encryptorAES;

    public CreateProductSteps(Product product) {
        this.product = product;
    }

    @Given("^I login to salesforce as an? (.*?) user$")
    public void iLoginToSalesforceAsAnAdminUser(final String userType) {
        encryptorAES = new EncryptorAES();
        loginPage = new LoginPage();
        loginPage.loginSuccessful(getUsername(), getPassword());
        HomePage homePage = new HomePage();
    }

    @When("^I navigate to (.*?) page$")
    public void iNavigateToAFeaturePage(final String pageName) throws Exception {
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.goToPage(pageName);
    }

    @When("I create a new Product with fields")
    public void iCreateANewProductWithFields(final Map<String, String> table) throws JsonProcessingException {
        productsPage = new ProductsPage();
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        product = ConverterToEntity.convertMapToEntity(table, Product.class);
        fields = table.keySet();
        productPage = newProductPage.createProduct(table.keySet(), product);
    }

    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productPage.getUserSuccessMessage().contains(product.getName()), "Message is incorrect");
        softAssert.assertAll();
    }

    @And("Check product fields matches")
    public void allProductFieldsMatches() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product.getName(), productPage.getSpanText(Translator.translateValue("Products", "productName")), "Product name is incorrect");
        softAssert.assertEquals(product.getProductCode(), productPage.getSpanText(Translator.translateValue("Products", "productCode")), "Product code is incorrect");
        softAssert.assertEquals(product.getFamily(), productPage.getSpanText(Translator.translateValue("Products", "productFamily")), "Product family is incorrect");
        softAssert.assertAll();
    }

    @And("Check The title matches")
    public void validateTheTitleMatches() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product.getName(), productPage.getProductTittle(), "The tittle is incorrect");
        softAssert.assertAll();
    }
}
