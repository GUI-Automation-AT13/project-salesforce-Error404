package salesforce.ui.pages;

import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.LegalEntity;
import java.util.HashMap;

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

    private static final String MENU_OPTION_CSS = "option[value='%s']";
    private static final HashMap<String, String> OPTION_STATUS_MENU = new HashMap<>();

    static {
        OPTION_STATUS_MENU.put("None", "");
        OPTION_STATUS_MENU.put("Active", "ACTIVE");
        OPTION_STATUS_MENU.put("Inactive", "INACTIVE");
    }

    private By saveButton = By.xpath("//div[@class='pbBottomButtons']//input[@name='save']");

    /**
     * .
     *
     * @param name .
     */
    public void setInputName(final String name) {
        webElementAction.setTextField(inputName, name);
    }

    /**
     * .
     *
     * @param companyName .
     */
    public void setInputCompanyName(final String companyName) {
        webElementAction.setTextField(inputCompanyName, companyName);
    }

    /**
     * .
     *
     * @param street .
     */
    public void setTextareaStreet(final String street) {
        webElementAction.setTextField(textareaStreet, street);
    }

    /**
     * .
     *
     * @param description .
     */
    public void setTextareaDescription(final String description) {
        webElementAction.setTextField(textareaDescription, description);
    }

    /**
     * .
     *
     * @param city .
     */
    public void setInputCity(final String city) {
        webElementAction.setTextField(inputCity, city);
    }

    /**
     * .
     *
     * @param state .
     */
    public void setInputAddressState(final String state) {
        webElementAction.setTextField(inputAddressState, state);
    }

    /**
     * .
     *
     * @param postalCode .
     */
    public void setInputAddressZip(final String postalCode) {
        webElementAction.setTextField(inputAddressZip, postalCode);
    }

    /**
     * .
     *
     * @param country .
     */
    public void setInputAddressCountry(final String country) {
        webElementAction.setTextField(inputAddressCountry, country);
    }

    /**
     * .
     *
     * @param status .
     */
    public void selectFromDropDown(final String status) {
        webElementAction.clickOnWebElement(selectStatusMenu);
        webElementAction.clickOnWebElement(getDriver().findElement(By.id(String.format(MENU_OPTION_CSS, status))));
    }

    /**
     * .
     * @return .
     */
    @Override
    protected LegalEntityPageAbstract clickSaveBtn() {
        webElementAction.clickOnWebElement(getDriver().findElement(saveButton));
        return AppPageFactory.getLegalEntityPage();
    }

    /**
     * .
     * @param legalEntity .
     * @return .
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
