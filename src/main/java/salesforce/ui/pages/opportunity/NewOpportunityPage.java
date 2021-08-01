package salesforce.ui.pages.opportunity;

import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Opportunity;
import salesforce.ui.pages.BasePage;
import salesforce.utils.Translator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NewOpportunityPage extends BasePage {
    private static final String XPATH_INPUT_NAME = "//input[@name='%s']";
    private static final String XPATH_CHECKBOX = "//input[@name='%s']";
    private static final String XPATH_DESCRIPTION = "//label[text()='%s']/..//textarea";
    private static final String XPATH_DROPDOWN = "//label[text()='%s']/..//input";
    private static final String XPATH_DROPDOWN_OPTION = "//lightning-base-combobox-item[@data-value='%s']";
    private static final String XPATH_SEARCH_OPTION = "//span[@title='%s']";
    private WebElement saveBtn;
    private WebElement saveAndNewBtn = getDriver().findElement(By.xpath("//button[@name='SaveAndNew']"));
    private WebElement cancelBtn = getDriver().findElement(By.xpath("//button[@name='CancelEdit']"));
    private WebElementAction webElementAction  = new WebElementAction();

    /**
     * Override the method for waiting an element.
     */
    @Override
    protected void waitForPageToLoad() {
        saveBtn = getDriver().findElement(By.xpath("//button[@name='SaveEdit']"));
        getWait().until(ExpectedConditions.visibilityOf(saveBtn));
    }

    /**
     * Sets the inputs fields  for the Opportunity form.
     * @param field name of the Input field.
     * @param value of the input.
     * @return The new opportunity page to set again the input.
     */
    public NewOpportunityPage setInputField(final String field, final String value) {
        System.out.println(XPATH_INPUT_NAME + field + value);
        webElementAction.setTextField(webElementAction.getWebElementByXpathAndValue(XPATH_INPUT_NAME, field), value);
        return this;
    }

    /**
     * Sets the fields for generic input dropdown when creating a new opportunity.
     * @param field the field of the dropdown.
     * @param option the option from the dropdown.
     * @return The new opportunity page to set again the input.
     */
    public NewOpportunityPage setDropdown(final String field, final String option) {
        System.out.println(XPATH_INPUT_NAME + field + option);
        webElementAction.clickOnWebElement(webElementAction.getWebElementByXpathAndValue(XPATH_DROPDOWN, field));
        webElementAction.clickOnWebElement(webElementAction.getWebElementByXpathAndValue(XPATH_DROPDOWN_OPTION,
                option));
        return this;
    }

    /**
     * Sets the fields for generic search dropdown when creating a new opportunity.
     * @param field the field of the search dropdown.
     * @param option the option from the search dropdown.
     * @return The new opportunity page to set again the input.
     */
    public NewOpportunityPage setSearchDown(final String field, final String option) {
        System.out.println(XPATH_INPUT_NAME + field + option);
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(XPATH_DROPDOWN, field))));
        webElementAction.clickOnWebElement(webElementAction.getWebElementByXpathAndValue(XPATH_DROPDOWN, field));
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(XPATH_SEARCH_OPTION, option))));
        webElementAction.clickOnWebElement(webElementAction.getWebElementByXpathAndValue(XPATH_SEARCH_OPTION, option));
        return this;
    }

    /**
     * Selects the Private checkbox for Private.
     * @param field field type.
     * @param isPrivate state of private.
     * @return NewOpportunityPage.
     */
    public NewOpportunityPage selectCheckbox(final String field, final boolean isPrivate) {
        WebElement element = getDriver().findElement(By.xpath(String.format(XPATH_CHECKBOX, field)));
        webElementAction.clickCheckBox(element, isPrivate);
        return this;
    }

    /**
     * Sets the description in the opportunity form.
     * @param descriptionText value of the description.
     * @param field field of web element.
     */
    public void setDescription(final String field, final String descriptionText) {
        webElementAction.setTextField(webElementAction.getWebElementByXpathAndValue(XPATH_DESCRIPTION, field),
                descriptionText);
    }

    /**
     * Sets all the parameters set in the Opportunity entity.
     * @param fields the key of Map.
     * @param opportunity entity.
     */
    public void setOpportunityFormFields(final Set<String> fields, final Opportunity opportunity) {
        Map<String, Runnable> mapFields = new HashMap<>();
        mapFields.put("Private", () -> selectCheckbox("IsPrivate", opportunity.isPrivate()));
        mapFields.put("Amount", () -> setInputField("Amount", opportunity.getAmount().toString()));
        mapFields.put("OpportunityName", () -> setInputField("Name", opportunity.getOpportunityName()));
        mapFields.put("CloseDate", () -> setInputField("CloseDate", opportunity.getCloseDate()));
        mapFields.put("NextStep", () -> setInputField("NextStep", opportunity.getNextStep()));
        mapFields.put("Probability", () -> setInputField("Probability", opportunity.getProbability()));
        mapFields.put("OrderNumber", () -> setInputField("OrderNumber__c", opportunity.getOrderNumber()));
        mapFields.put("CurrentGenerator", () -> setInputField("CurrentGenerators__c",
                opportunity.getCurrentGenerator()));
        mapFields.put("TrackingNumber", () -> setInputField("TrackingNumber__c", opportunity.getTrackingNumber()));
        mapFields.put("MainCompetitor", () -> setInputField("MainCompetitors__c", opportunity.getMainComp()));
        mapFields.put("Description", () -> setDescription(Translator.translateValue("Opportunity", "description"),
                opportunity.getDescription()));
        mapFields.put("Stage", () -> setDropdown(Translator.translateValue("Opportunity", "stage"),
                opportunity.getOpportunityStage()));
        mapFields.put("Type", () -> setDropdown(Translator.translateValue("Opportunity", "type"),
                opportunity.getTypeOption()));
        mapFields.put("LeadSource", () -> setDropdown(Translator.translateValue("Opportunity", "leadSource"),
                opportunity.getLeadSource()));
        mapFields.put("Delivery", () -> setDropdown("Delivery/Installation Status", opportunity.getDeliveryOption()));
        mapFields.put("Account", () -> setSearchDown(Translator.translateValue("Opportunity", "accountName"),
                opportunity.getSearchAccount()));
        mapFields.put("Campaign", () -> setSearchDown(Translator.translateValue("Opportunity", "campaignName"),
                opportunity.getSearchCampaign()));
        fields.forEach(field -> mapFields.get(field).run());
    }

    /**
     * Creates a new Opportunity and goes to the details paage.
     * @param fields the keys of the Map.
     * @param opportunity entity of Opportunity.
     * @return created opportunity page.
     */
    public CreatedOpportunityPage createNewOpportunity(final Set<String> fields, final Opportunity opportunity) {
        setOpportunityFormFields(fields, opportunity);
        webElementAction.clickOnWebElement(saveBtn);
        return new CreatedOpportunityPage();
    }

    /**
     * Redirects to the Created Opportunity page when form is saved correctly.
     * @return Created Opportunity page.
     */
    public CreatedOpportunityPage clickSaveOpportunity() {
        webElementAction.clickOnWebElement(saveBtn);
        return new CreatedOpportunityPage();
    }

    /**
     * Saves the Opportunity created and open a new form.
     * @return New Opportunity form page.
     */
    public NewOpportunityPage clickSaveAndNewBtn() {
        webElementAction.clickOnWebElement(saveAndNewBtn);
        return new NewOpportunityPage();
    }

    /**
     * Returns to the Opportunity page when cancel button is selected in the new form.
     * @return Opportunity page.
     */
    public OpportunityPage clickCancelBtn() {
        webElementAction.clickOnWebElement(cancelBtn);
        return new OpportunityPage();
    }
}
