package salesforce.ui.pages.legalentity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Interacts with the Legal Entity elements.
 */
public class LegalEntitiesPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, \'slds-button--neutral\')]//a")
    private WebElement newEntityBtn;

    @FindBy(css = "table.slds-table")
    private WebElement entitiesTable;

    @FindBy(css = "//li[@class=\"oneActionsDropDown\"]//div/a")
    private WebElement arrowMenuIcon;

    @FindBy(xpath = "//div[contains(@class, 'popupTargetContainer')]//a[@title=\"Delete\"]")
    private WebElement deleteOption;

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    private static final String TABLE_ENTITY = "//div[contains(@class, 'slds-table--edit_container')]//a[@title='%s']";
    private String legalEntityNumberCellXpath = "//table//*[@title='%s']";

    /**
     * Waits for the visibility of a web element.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(entitiesTable));
    }

    /**
     * Clicks on the new button.
     *
     * @return the salesforce.cases form site
     */
    public NewLegalEntityPage clickOnNew() {
        getWebElementAction().clickOnWebElement(newEntityBtn);
        return new NewLegalEntityPage();
    }

    /**
     * Gets the name of a legal entity from the table of entities.
     *
     * @param tableEntityName the name of the legal entity.
     * @return a string with the name of the legal entity.
     */
    public String getTableEntity(final String tableEntityName) {
        return getWebElementAction().getTextOnWebElement(getWebElementAction()
                .getWebElementByXpathAndValue(TABLE_ENTITY, tableEntityName));
    }

    /**
     * Gets the legal entity id.
     *
     * @param name a String with the value
     * @return the case id
     */
    public String getLegalEntityId(final String name) {
        return getWebElementAction().getAttributeFromWebElement(getWebElementAction()
                        .getWebElementByXpathAndValue(legalEntityNumberCellXpath, name),
                "data-recordid");
    }

}
