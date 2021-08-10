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

    /**
     * .
     * @return .
     */
    public NewLegalEntityPageAbstract clickOnNew() {
        WebElement locatorNewButton = getLocator();
        getWebElementAction().clickOnWebElement(locatorNewButton);
        return AppPageFactory.getNewLegalEntityPage();
    }

    public abstract String getLegalEntityId(String name);
}
