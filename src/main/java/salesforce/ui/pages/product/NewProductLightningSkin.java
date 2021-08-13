/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.Product;
import salesforce.ui.pages.AppPageFactory;
import salesforce.utils.FileTranslator;
import java.util.HashMap;

public class NewProductLightningSkin extends NewProductPageAbstract {

    @FindBy(xpath = "//h2[contains(@class,'inlineTitle')]")
    private WebElement formTitle;

    private By productDescriptionTextArea = By.xpath("//label//span[text()='"
            + FileTranslator.translateValue("Products", "productDescription") + "']/../../textarea");
    private By productFamilyComboBox = By.xpath("//span//span[text()='"
            + FileTranslator.translateValue("Products", "productFamily") + "']/../..//a");
    private By activeCheckBox = By.xpath("//label//span[text()='"
            + FileTranslator.translateValue("Products", "active") + "']/../../input");
    private By saveButton = By.xpath("//button[@title='"
            + FileTranslator.translateValue("Products", "saveProduct") + "']");

    private static final String INPUT_XPATH = "//label//span[text()='%s']/../../input";

    /**
     * Sets input fields.
     *
     * @param fieldName the name of the field
     * @param fieldValue the value to set
     */
    public void setInputField(final String fieldName, final String fieldValue) {
        getWebElementAction().setTextField(getDriver()
                .findElement(By.xpath(String.format(INPUT_XPATH, fieldName))), fieldValue);
    }

    /**
     * Clicks on active CheckBox.
     */
    public void clickActiveCheckBox() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(activeCheckBox));
    }

    /**
     * Selects an option of the productFamily combo box.
     *
     * @param productFamilyOption the option to select
     */
    public void selectProductFamilyOption(final String productFamilyOption) {
        getWebElementAction().clickOnWebElement(getDriver().findElement(productFamilyComboBox));
        getDriver().findElement(By.linkText(productFamilyOption)).click();
    }

    /**
     * Sets the productDescription.
     *
     * @param productDescription to set
     */
    public void setProductDescription(final String productDescription) {
        getWebElementAction().setTextField(getDriver().findElement(productDescriptionTextArea), productDescription);
    }

    /**
     * Click the save button.
     *
     * @return ProductPageAbstract.
     */
    @Override
    protected ProductPageAbstract clickSaveBtn() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(saveButton));
        return AppPageFactory.getProductPage();
    }

    /**
     * Builds the map.
     *
     * @param product to obtain the values to be set.
     * @return HashMap<String, Runnable>.
     */
    @Override
    protected HashMap<String, Runnable> buildMap(final Product product) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () ->
                setInputField(FileTranslator.translateValue("Products", "productName"), product.getName()));
        strategyMap.put("IsActive", () -> clickActiveCheckBox());
        strategyMap.put("ProductCode", () ->
                setInputField(FileTranslator.translateValue("Products", "productCode"),
                        product.getProductCode()));
        strategyMap.put("Family", () -> selectProductFamilyOption(product.getFamily()));
        strategyMap.put("Description", () -> setProductDescription(product.getDescription()));
        return strategyMap;
    }
}
