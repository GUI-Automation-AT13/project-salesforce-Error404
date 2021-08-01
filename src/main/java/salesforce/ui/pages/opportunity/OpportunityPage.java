package salesforce.ui.pages.opportunity;

import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;
import salesforce.utils.Translator;

public class OpportunityPage extends BasePage {
    private String newXpath;
    private By btnNew;
    private WebElementAction webElementAction;

    /**
     * Override method for waiting an element.
     */
    @Override
    protected void waitForPageToLoad() {
        newXpath = String.format("//a[@title='%s']", Translator.translateValue("Opportunity", "new"));
        btnNew = By.xpath(String.format(newXpath));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(btnNew));
    }

    /**
     * Clicks the new button for Opportunity form.
     */
    private void clickNewBtnOpportunity() {
        getDriver().findElement(By.xpath(newXpath)).click();
        //webElementAction.clickOnWebElement(getDriver().findElement(By.xpath(newXpath)));
    }

    /**
     * Goes to the New Opportunity page.
     * @return the new Opportunity page.
     */
    public NewOpportunityPage openNewOpportunityForm() {
        clickNewBtnOpportunity();
        return new NewOpportunityPage();
    }
}
