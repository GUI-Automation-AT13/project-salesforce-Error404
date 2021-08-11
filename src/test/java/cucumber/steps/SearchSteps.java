package cucumber.steps;

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
    AppLauncherModalPage appLauncherModalPage;
    List<WebElement> list;

    /**
     * Opens the application's launcher modal.
     */
    @When("I open the App Launcher modal")
    public void openAppLauncherModal() {
        logger.info("=================== When I open the App Launcher modal ==========================");
        HomePage homePage = new HomePage();
        AppLauncherNavigationPage appLauncherNavigationPage = homePage.openAppLauncherNavigation();
        appLauncherModalPage = appLauncherNavigationPage.clickView();
    }

    /**
     * Introduces text to the search box.
     *
     * @param textToSearch a String with the text
     */
    @When("^I enter (.*) into the search box$")
    public void enterTextIntoSearchBox(final String textToSearch) {
        logger.info("=================== When I enter a text into the search box ==========================");
        appLauncherModalPage.setSearchTextBox(textToSearch);
    }

    /**
     * Validates that provided text matches the obtained results.
     *
     * @param type a String with the result type
     * @param textSearched a String with the text
     */
    @Then("^(Apps|Items) related to (.*) are shown on its section$")
    public void resultAppsMatch(final String type, final String textSearched) {
        logger.info("================ Then Apps and Items related to ============================");
        logger.info("===========the searched text are shown on its section ======================");
        SoftAssert softAssert = new SoftAssert();
        list = appLauncherModalPage.getResult(type);
        softAssert.assertTrue(appLauncherModalPage.containsText(textSearched, list, type));
    }

}
