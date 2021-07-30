package salesforce.ui.pages.legalentity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Interacts with the Legal Entities elements.
 */
public class LegalEntityPage extends BasePage {

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @FindBy(css = "div.slds-form")
    private WebElement informationSection;

    @FindBy(css = "span.uiOutputTextArea")
    private WebElement description;

    @FindBy(css = "//h1//div//span[@class=\"uiOutputText\"]")
    private WebElement headerEntityName;

    private By statusSpanXpath = By.xpath("//div//span[text()='"
            + ResourceBundle.getBundle("internationalization/i18NLegalEntities",
            new Locale("en")).getString("span.status") + "']/../..//div//span/*");
    private static final String INTERNATIONALIZED_NAME =
            ResourceBundle.getBundle("internationalization/i18NLegalEntities",
                    new Locale("en")).getString("input.name");
    private static final String INTERNATIONALIZED_COMPANY_NAME =
            ResourceBundle.getBundle("internationalization/i18NLegalEntities",
                    new Locale("en")).getString("input.companyname");
    private By descriptionCss = By.cssSelector("span.uiOutputTextArea");

    private final int TIME = 5000;
    private static final String NAMES_XPATH = "//div/div/span[text()='%s']/../..//div//span[@class=\"uiOutputText\"]";
    private static final String ADDRESS_XPATH = "a.forceOutputAddress div:nth-child(%s)";
    private static final String HEADER_ENTITY_NAME = "//h1//div//span[@class=\"uiOutputText\"]";
    private static final HashMap<String, String> SPAN_NAMES = new HashMap<>();

    static {
        SPAN_NAMES.put("Name", INTERNATIONALIZED_NAME);
        SPAN_NAMES.put("CompanyName", INTERNATIONALIZED_COMPANY_NAME);
    }

    private static final HashMap<String, String> DIV_ADDRESS = new HashMap<>();

    static {
        DIV_ADDRESS.put("Street", "1");
        DIV_ADDRESS.put("CityStatePostalCode", "2");
        DIV_ADDRESS.put("Country", "3");
    }

    public LegalEntityPage() {
        super();
    }

    /**
     * Waits for the visibility of a web element.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(informationSection));
    }

    /**
     * Gets the success message.
     *
     * @return a String with the message.
     */
    public String getUserSuccessMessage() {
        return getWebElementAction().getTextOnWebElement(successMessage);
    }

    /**
     * Gets the entity name text.
     *
     * @return a string with the entity name text.
     */
    public String getHeaderEntityNameText() {
        if (getWebElementAction().isElementPresent(By.xpath(HEADER_ENTITY_NAME), TIME)) {
            return getDriver().findElement(By.xpath(HEADER_ENTITY_NAME)).getText();
        }
        return null;
    }

    /**
     * Gets the entity or company name text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with the entity or company name text.
     */
    public String getNamesText(final String fieldName) {
        if (getWebElementAction().isElementPresent(By.xpath(String.format(NAMES_XPATH, SPAN_NAMES.get(fieldName))), TIME)) {
            if (getDriver().findElement(By.xpath(String.format(NAMES_XPATH, SPAN_NAMES.get(fieldName)))).getText().equals("")){
                return null;
            }
            return getDriver().findElement(By.xpath(String.format(NAMES_XPATH, SPAN_NAMES.get(fieldName)))).getText();
        }
        return null;
    }

    /**
     * Gets the address text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with address text.
     */
    public String getAddressNamesText(final String fieldName) {
        if (getWebElementAction().isElementPresent(By.cssSelector(String.format(ADDRESS_XPATH, DIV_ADDRESS.get(fieldName))), TIME)) {
            return getDriver().findElement(By.cssSelector(String.format(ADDRESS_XPATH, DIV_ADDRESS.get(fieldName)))).getText();
        }
        return null;
    }

    /**
     * Gets the description text.
     *
     * @return a String with the description text.
     */
    public String getDescriptionText() {
        if (getWebElementAction().isElementPresent(descriptionCss, TIME)) {
            return getDriver().findElement(descriptionCss).getText();
        }
        return null;
    }

    /**
     * Gets the status text.
     *
     * @return a String with the status text.
     */
    public String getStatusText() {
        if (getWebElementAction().isElementPresent(statusSpanXpath, TIME)) {
            return getDriver().findElement(statusSpanXpath).getText();
        }
        return null;
    }

}
