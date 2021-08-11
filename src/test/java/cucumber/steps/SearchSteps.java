package cucumber.steps;

import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.applauncher.AppLauncherModalPage;
import salesforce.ui.pages.applauncher.AppLauncherNavigationPage;
import java.util.List;

public class SearchSteps {
    private Logger logger = LogManager.getLogger(getClass());
    ApiRequestBuilder requestBuilder;
    ApiResponse apiResponse;
    AppLauncherModalPage appLauncherModalPage;
    List<WebElement> list;

    public SearchSteps(ApiRequestBuilder requestBuilder, ApiResponse apiResponse) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
    }

    @When("I open the App Launcher modal")
    public void openAppLauncherModal() {
        logger.info("=================== When I open the App Launcher modal ==========================");
        HomePage homePage = new HomePage();
        AppLauncherNavigationPage appLauncherNavigationPage = homePage.openAppLauncherNavigation();
        appLauncherModalPage = appLauncherNavigationPage.clickView();
    }

    @When("^I enter (.*) into the search box$")
    public void enterTextIntoSearchBox(String textToSearch) {
        logger.info("=================== When I enter a text into the search box ==========================");
        appLauncherModalPage.setSearchTextBox(textToSearch);
    }

    @Then("^(Apps|Items) related to (.*) are shown on its section$")
    public void resultAppsMatch(String type, String textSearched) {
        logger.info("=================== Then Apps and Items related to the searched text are shown on its section ==========================");
        SoftAssert softAssert = new SoftAssert();
        list = appLauncherModalPage.getResult(type);
        softAssert.assertTrue(appLauncherModalPage.containsText(textSearched, list, type));
    }

}
