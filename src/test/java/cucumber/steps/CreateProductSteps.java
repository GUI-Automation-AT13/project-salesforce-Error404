package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import salesforce.utils.StringToDate;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;
import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

public class CreateProductSteps {
    private StringToDate stringToDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy H:mm");
    SoftAssert softAssert = new SoftAssert();
    String actualDate;
    ProductsPage productsPage;
    Product product;
    ProductPage productPage;
    Set<String> fields;

    public CreateProductSteps(Product product) {
        this.product = product;
    }

    @Given("^I login to salesforce as an? (.*?) user$")
    public void iLoginToSalesforceAsAnAdminUser(final String userType) {
        //get user credentials
        String username = getUsername();
        String password = getPassword();
        //login
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessful(username, password);
        HomePage homePage = new HomePage();
    }

    @When("^I navigate to (.*?) page$")
    public void iNavigateToAFeaturePage(final String pageName) {
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

        stringToDate = new StringToDate();
        actualDate = dateFormat.format(stringToDate.getTodayDate());
    }

    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        softAssert.assertEquals(productPage.getUserSuccessMessage(), "success\nProduct \"" + product.getName() + "\" was created.\nClose", "Message is incorrect");
    }

    @And("Check product fields matches")
    public void allProductFieldsMatches() {
        softAssert.assertEquals(product.getName(), productPage.getSpanText("Product Name"), "Product name is incorrect");
        softAssert.assertEquals(product.getProductCode(), productPage.getSpanText("Product Code"), "Product code is incorrect");
        softAssert.assertEquals(product.getFamily(), productPage.getSpanText("Product Family"), "Product family is incorrect");

//        softAssert.assertEquals(product.getDescription(), util.productPage.getSpanText("Product Description"), "Product description is incorrect");
//        softAssert.assertEquals(product.getDescription(), util.productPage.getDescription(), "Product description is incorrect");
    }

    @And("Check The title matches")
    public void validateTheTitleMatches() {
        softAssert.assertEquals(product.getName(), productPage.getProductTittle(), "The tittle is incorrect");
    }

    @And("Check The created date matches")
    public void validateTheCreatedDateMatches() {
        softAssert.assertEquals(actualDate, productPage.getCreatedByDate());
        softAssert.assertAll();
    }
}
