package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Product;
import salesforce.ui.pages.BasePage;
import salesforce.utils.Translator;
import java.util.HashMap;
import java.util.Set;

/**
 * This class returns an instance of NewProductForm.
 */
public class NewProductPage extends BasePage {
    @FindBy(css = ".forceActionButton:nth-child(3) > .label")
    private WebElement saveButton;

    private By productDescriptionTextArea = By.xpath("//label//span[text()='"
            + Translator.translateValue("Products", "productDescription") + "']/../../textarea");
    private By productFamilyComboBox = By.xpath("//span//span[text()='"
            + Translator.translateValue("Products", "productFamily") + "']/../..//a");
    private By activeCheckBox = By.xpath("//label//span[text()='"
            + Translator.translateValue("Products", "active") + "']/../../input");

    private static final String INPUT_XPATH = "//label//span[text()='%s']/../../input";

    /**
     * Waits for the page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(saveButton));
    }

    /**
     * Sets input fields.
     *
     * @param fieldName the name of the field
     * @param fieldValue the value to set
     * @return this page
     */
    public NewProductPage setInputField(final String fieldName, final String fieldValue) {
        getWebElementAction().setTextField(getDriver()
                .findElement(By.xpath(String.format(INPUT_XPATH, fieldName))), fieldValue);
        return this;
    }

    /**
     * Clicks on active CheckBox.
     *
     * @return this page
     */
    public NewProductPage clickActiveCheckBox() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(activeCheckBox));
        return this;
    }

    /**
     * Selects an option of the productFamily combo box.
     *
     * @param productFamilyOption the option to select
     * @return this page
     */
    public NewProductPage selectProductFamilyOption(final String productFamilyOption) {
        getWebElementAction().clickOnWebElement(getDriver().findElement(productFamilyComboBox));
        getDriver().findElement(By.linkText(productFamilyOption)).click();
        return this;
    }

    /**
     * Sets the productDescription.
     *
     * @param productDescription to set
     * @return this page
     */
    public NewProductPage setProductDescription(final String productDescription) {
        getWebElementAction().setTextField(getDriver().findElement(productDescriptionTextArea), productDescription);
        return this;
    }

    /**
     * Clicks on Save button.
     *
     * @return a ProductPage
     */
    public ProductPage clickSaveButton() {
        getWebElementAction().clickOnWebElement(saveButton);
        return new ProductPage();
    }

    /**
     * Creates a Product.
     *
     * @param fields fields to get
     * @param product class entity
     * @return a ProductPage
     */
    public ProductPage createProduct(final Set<String> fields, final Product product) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () ->
                setInputField(Translator.translateValue("Products", "productName"), product.getName()));
        strategyMap.put("ProductCode", () ->
                setInputField(Translator.translateValue("Products", "productCode"),
                        product.getProductCode()));
        strategyMap.put("Family", () -> selectProductFamilyOption(product.getFamily()));
        strategyMap.put("Description", () -> setProductDescription(product.getDescription()));
        fields.forEach(field -> strategyMap.get(field).run());
        return clickSaveButton();
    }
}
