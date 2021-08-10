package salesforce.ui.pages;

import org.openqa.selenium.WebElement;

public abstract class LegalEntitiesPageAbstract extends BasePage {

    public LegalEntitiesPageAbstract() {
        waitForPageToLoad();
    }

    @Override
    protected void waitForPageToLoad() {
    }

    protected abstract WebElement getLocator();

    public abstract String getLegalEntityId(String name);

    /**
     * Clicks on new button.
     *
     * @return a NewLegalEntityPageAbstract with the correct instance.
     */
    public NewLegalEntityPageAbstract clickOnNew() {
        WebElement locatorNewButton = getLocator();
        getWebElementAction().clickOnWebElement(locatorNewButton);
        return AppPageFactory.getNewLegalEntityPage();
    }
}
