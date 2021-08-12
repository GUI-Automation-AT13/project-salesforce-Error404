package salesforce.ui.pages.legalentity;

import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.LegalEntity;
import salesforce.ui.pages.AppPageFactory;

import java.util.HashMap;

import static salesforce.utils.FileTranslator.translateValue;

public class NewLegalEntityClassicVersion extends NewLegalEntityPageAbstract {

    private WebElementAction webElementAction = new WebElementAction();

    @FindBy(css = "pbBody")
    private WebElement informationSection;

    @FindBy(id = "Name")
    private WebElement inputName;

    @FindBy(id = "CompanyName")
    private WebElement inputCompanyName;

    @FindBy(id = "LegalEntityAddressstreet")
    private WebElement textareaStreet;

    @FindBy(id = "Description")
    private WebElement textareaDescription;

    @FindBy(id = "LegalEntityAddresscity")
    private WebElement inputCity;

    @FindBy(id = "LegalEntityAddressstate")
    private WebElement inputAddressState;

    @FindBy(id = "LegalEntityAddresszip")
    private WebElement inputAddressZip;

    @FindBy(id = "LegalEntityAddresscountry")
    private WebElement inputAddressCountry;

    @FindBy(id = "Status")
    private WebElement selectStatusMenu;

    private static final String MENU_OPTION_XPATH = "//option[text()='%s']";
    private static final HashMap<String, String> OPTION_STATUS_MENU = new HashMap<>();

    static {
        OPTION_STATUS_MENU.put("None", "");
        OPTION_STATUS_MENU.put("Active", "ACTIVE");
        OPTION_STATUS_MENU.put("Inactive", "INACTIVE");
    }

    private By saveButton = By.xpath("//div[@class='pbBottomButtons']//input[@name='save']");

    /**
     * Sets the name.
     *
     * @param name a string with the name.
     */
    public void setInputName(final String name) {
        webElementAction.setTextField(inputName, name);
    }

    /**
     * Sets the company name.
     *
     * @param companyName a string with the company name.
     */
    public void setInputCompanyName(final String companyName) {
        webElementAction.setTextField(inputCompanyName, companyName);
    }

    /**
     * Sets the street.
     *
     * @param street a string with the street.
     */
    public void setTextareaStreet(final String street) {
        webElementAction.setTextField(textareaStreet, street);
    }

    /**
     * Sets the description.
     *
     * @param description a string with the description.
     */
    public void setTextareaDescription(final String description) {
        webElementAction.setTextField(textareaDescription, description);
    }

    /**
     * Sets the city.
     *
     * @param city a string with the city.
     */
    public void setInputCity(final String city) {
        webElementAction.setTextField(inputCity, city);
    }

    /**
     * Sets the address state.
     *
     * @param state a string with the state.
     */
    public void setInputAddressState(final String state) {
        webElementAction.setTextField(inputAddressState, state);
    }

    /**
     * Sets the address postal code.
     *
     * @param postalCode a string with the postal code.
     */
    public void setInputAddressZip(final String postalCode) {
        webElementAction.setTextField(inputAddressZip, postalCode);
    }

    /**
     * Sets the address country.
     *
     * @param country a string with the country.
     */
    public void setInputAddressCountry(final String country) {
        webElementAction.setTextField(inputAddressCountry, country);
    }

    /**
     * Select an option from status dropdown menu.
     *
     * @param status a string with the status.
     */
    public void selectFromDropDown(final String status) {
        webElementAction.clickOnWebElement(selectStatusMenu);
        webElementAction.clickOnWebElement(getDriver().findElement(By.xpath(
                String.format(MENU_OPTION_XPATH, translateValue("LegalEntities", "option.status")))));
    }

    /**
     * Clicks the save button.
     *
     * @return LegalEntityPageAbstract.
     */
    @Override
    protected LegalEntityPageAbstract clickSaveBtn() {
        webElementAction.clickOnWebElement(getDriver().findElement(saveButton));
        return AppPageFactory.getLegalEntityPage();
    }

    /**
     * Builds the map.
     *
     * @param legalEntity to obtain the vañues to set.
     * @return HashMap<String, Runnable>.
     */
    @Override
    protected HashMap<String, Runnable> buildMap(final LegalEntity legalEntity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setInputName(legalEntity.getName()));
        strategyMap.put("CompanyName", () -> setInputCompanyName(legalEntity.getCompanyName()));
        strategyMap.put("LegalEntityState", () -> setInputAddressState(legalEntity.getLegalEntityState()));
        strategyMap.put("LegalEntityCity", () -> setInputCity(legalEntity.getLegalEntityCity()));
        strategyMap.put("LegalEntityPostalCode", () -> setInputAddressZip(legalEntity.getLegalEntityPostalCode()));
        strategyMap.put("LegalEntityCountry", () -> setInputAddressCountry(legalEntity.getLegalEntityCountry()));
        strategyMap.put("LegalEntityStreet", () -> setTextareaStreet(legalEntity.getLegalEntityStreet()));
        strategyMap.put("Description", () -> setTextareaDescription(legalEntity.getDescription()));
        strategyMap.put("Status", () -> selectFromDropDown(legalEntity.getStatus()));
        return strategyMap;
    }
}
