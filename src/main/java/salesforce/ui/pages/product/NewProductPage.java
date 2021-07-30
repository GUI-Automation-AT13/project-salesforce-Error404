package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Product;
import salesforce.ui.pages.BasePage;
import java.util.HashMap;
import java.util.Set;

/**
 * This class returns an instance of NewProductForm.
 */
public class NewProductPage extends BasePage {
    @FindBy(css = ".forceActionButton:nth-child(3) > .label")
    private WebElement saveButton;

    @FindBy(xpath = "//label//span[text()='Active']/../../input")
    private WebElement activeCheckBox;

    @FindBy(xpath = "//span//span[text()='Product Family']/../..//a")
    private WebElement productFamilyComboBox;

    @FindBy(xpath = "//label//span[text()='Product Description']/../../textarea")
    private WebElement productDescriptionTextArea;

    private static final String INPUT_XPATH = "//label//span[text()='%s']/../../input";

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
        getWebElementAction().setTextField(getDriver().findElement(By.xpath(String.format(INPUT_XPATH, fieldName))), fieldValue);
        return this;
    }

    /**
     * Clicks on active CheckBox.
     *
     * @return this page
     */
    public NewProductPage clickActiveCheckBox() {
        getWebElementAction().clickOnWebElement(activeCheckBox);
        return this;
    }

    /**
     * Selects an option of the productFamily combo box.
     *
     * @param productFamilyOption the option to select
     * @return this page
     */
    public NewProductPage selectProductFamilyOption(final String productFamilyOption) {
        getWebElementAction().clickOnWebElement(productFamilyComboBox);
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
        getWebElementAction().setTextField(productDescriptionTextArea, productDescription);
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
    public ProductPage createProduct(Set<String> fields, Product product) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setInputField("Product Name", product.getName()));
        strategyMap.put("ProductCode", () -> setInputField("Product Code", product.getProductCode()));
        strategyMap.put("Family", () -> selectProductFamilyOption(product.getFamily()));
        strategyMap.put("Description", () -> setProductDescription(product.getDescription()));
        fields.forEach(field -> strategyMap.get(field).run());
        return clickSaveButton();
    }
}
