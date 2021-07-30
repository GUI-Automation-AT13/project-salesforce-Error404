package salesforce.ui.pages.legalentity;

import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.legalentity.LegalEntity;
import salesforce.ui.pages.BasePage;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Interacts with the New Legal Entity elements.
 */
public class NewLegalEntityPage extends BasePage {

    private WebElementAction webElementAction = new WebElementAction();

    @FindBy(xpath = "//div/textarea[@class=\" textarea\"]")
    private WebElement descriptionTxtBox;

    private By saveBtnXpath = By.xpath("//button[@title='"
            + ResourceBundle.getBundle("internationalization/i18NLegalEntities",
            new Locale("en")).getString("button.save") + "']");
    private By streetTxtBoxXpath = By.xpath("//div/textarea[@placeholder='"
            + ResourceBundle.getBundle("internationalization/i18NLegalEntities",
            new Locale("en")).getString("input.street") + "']");
    private static final String INTERNATIONALIZED_NAME =
            ResourceBundle.getBundle("internationalization/i18NLegalEntities",
                    new Locale("en")).getString("input.name");
    private static final String INTERNATIONALIZED_COMPANY_NAME =
            ResourceBundle.getBundle("internationalization/i18NLegalEntities",
                    new Locale("en")).getString("input.companyname");

    private static final String INPUT_XPATH = "//label/span[text()='%s']/../..//input";
    private static final String INPUT_ADDRESS_CSS = "input.%s";
    private static final String DROPDOWN_XPATH = "//a[@class='%s']";
    private static final String DROPDOWN_OPTION_XPATH = "//div[@class=\"select-options\"]//a[@title='%s']";
    private static final HashMap<String, String> INPUT_FIELDS_NAMES = new HashMap<>();

    static {
        INPUT_FIELDS_NAMES.put("Name", INTERNATIONALIZED_NAME);
        INPUT_FIELDS_NAMES.put("CompanyName", INTERNATIONALIZED_COMPANY_NAME);

    }

    private static final HashMap<String, String> INPUT_ADDRESS_NAMES = new HashMap<>();

    static {
        INPUT_ADDRESS_NAMES.put("City", "city");
        INPUT_ADDRESS_NAMES.put("State", "state");
        INPUT_ADDRESS_NAMES.put("PostalCode", "postalCode");
        INPUT_ADDRESS_NAMES.put("Country", "country");
    }

    /**
     * Waits for the visibility of a web element.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(descriptionTxtBox));
    }

    /**
     * Introduces text to web email text box.
     *
     * @param value a String to input
     */
    public void setInputFieldWithInternationalization(final String fieldName, final String value) {
        webElementAction.setTextField(webElementAction
                .getWebElementByXpathAndValue(INPUT_XPATH, INPUT_FIELDS_NAMES.get(fieldName)), value);
    }

    /**
     * Introduces text to web email text box.
     *
     * @param value a String to input
     */
    public void setInputFieldByClass(final String fieldName, final String value) {
        webElementAction.setTextField(webElementAction
                .getWebElementByCssAndValue(INPUT_ADDRESS_CSS, INPUT_ADDRESS_NAMES.get(fieldName)), value);
    }

    /**
     * Selects an option from a dropdown menu.
     *
     * @param fieldName the name of the menu field.
     * @param option    the option to select.
     * @return a NewLegalEntity.
     */
    public NewLegalEntityPage selectFromDropDown(final String fieldName, final String option) {
        webElementAction.clickOnWebElement(getDriver().findElement(By.xpath(String.format(DROPDOWN_XPATH, fieldName))));
        webElementAction.clickOnWebElement(getDriver().findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH, option))));
        return this;
    }

    /**
     * Sets the street.
     *
     * @param street a String with the street.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setStreetTxtBox(final String street) {
        webElementAction.setTextField(getDriver().findElement(streetTxtBoxXpath), street);
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description a String with the description.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setDescriptionTxtBox(final String description) {
        webElementAction.setTextField(descriptionTxtBox, description);
        return this;
    }

    /**
     * Clicks the save button.
     *
     * @return A LegalEntityPage.
     */
    public LegalEntityPage clickSaveBtn() {
        webElementAction.clickOnWebElement(getDriver().findElement(saveBtnXpath));
        return new LegalEntityPage();
    }

    /**
     * Builds the legal entity map with given fields.
     *
     * @param legalEntity with given fields.
     * @return the built map.
     */
    private HashMap<String, Runnable> buildMap(final LegalEntity legalEntity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setInputFieldWithInternationalization("Name", legalEntity.getName()));
        strategyMap.put("CompanyName", () -> setInputFieldWithInternationalization("CompanyName",
                legalEntity.getCompanyName()));
        strategyMap.put("LegalEntityState", () -> setInputFieldByClass("State", legalEntity.getLegalEntityState()));
        strategyMap.put("LegalEntityCity", () -> setInputFieldByClass("City", legalEntity.getLegalEntityCity()));
        strategyMap.put("LegalEntityPostalCode", () -> setInputFieldByClass("PostalCode",
                legalEntity.getLegalEntityPostalCode()));
        strategyMap.put("LegalEntityCountry", () -> setInputFieldByClass("Country",
                legalEntity.getLegalEntityCountry()));
        strategyMap.put("LegalEntityStreet", () -> setStreetTxtBox(legalEntity.getLegalEntityStreet()));
        strategyMap.put("Description", () -> setDescriptionTxtBox(legalEntity.getDescription()));
        strategyMap.put("Status", () -> selectFromDropDown("select", legalEntity.getStatus()));
        return strategyMap;
    }

    /**
     * Creates a new legal entity.
     *
     * @param fields      key values from entity map.
     * @param legalEntity an entity.
     * @return a legal entity page.
     */
    public LegalEntityPage createLegalEntity(final Set<String> fields, final LegalEntity legalEntity) throws IllegalAccessException {
        // Componer el mapa
        HashMap<String, Runnable> map = buildMap(legalEntity);
        // Llenar el formulario
        fields.forEach(field -> map.get(field).run());
        return clickSaveBtn();
    }

}
