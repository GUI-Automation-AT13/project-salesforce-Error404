package salesforce.ui.pages.legalentity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegalEntitiesLightningVersion extends LegalEntitiesPageAbstract {

    @FindBy(xpath = "//li[contains(@class, \'slds-button--neutral\')]//a")
    private WebElement newEntityBtn;

    private String legalEntityNumberCellXpath = "//table//*[@title='%s']";

    /**
     * Gets the locator of the new entity button.
     *
     * @return a WebElement.
     */
    @Override
    protected WebElement getLocator() {
        return newEntityBtn;
    }

    /**
     * Gets the legal entity id.
     *
     * @param name a string with the name of the entity.
     * @return a string with the id.
     */
    @Override
    public String getLegalEntityId(final String name) {
        return getWebElementAction().getAttributeFromWebElement(getWebElementAction()
                        .getWebElementByXpathAndValue(legalEntityNumberCellXpath, name),
                "href").substring(1);
    }
}
