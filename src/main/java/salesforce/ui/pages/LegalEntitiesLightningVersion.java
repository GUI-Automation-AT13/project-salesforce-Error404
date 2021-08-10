package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegalEntitiesLightningVersion extends LegalEntitiesPageAbstract {

    @FindBy(xpath = "//li[contains(@class, \'slds-button--neutral\')]//a")
    private WebElement newEntityBtn;

    private String legalEntityNumberCellXpath = "//table//*[@title='%s']";

    /**
     * .
     *
     * @return .
     */
    @Override
    protected WebElement getLocator() {
        return newEntityBtn;
    }

    /**
     * .
     *
     * @param name .
     * @return .
     */
    @Override
    public String getLegalEntityId(final String name) {
        return getWebElementAction().getAttributeFromWebElement(getWebElementAction()
                        .getWebElementByXpathAndValue(legalEntityNumberCellXpath, name),
                "href").substring(1);
    }
}
