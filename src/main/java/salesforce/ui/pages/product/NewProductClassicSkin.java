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
import java.util.HashMap;

public class NewProductClassicSkin extends NewProductPageAbstract {

    @FindBy(id = "Name")
    private WebElement inputName;

    @FindBy(id = "IsActive")
    private WebElement inputActive;

    @FindBy(id = "ProductCode")
    private WebElement inputProductCode;

    @FindBy(id = "Family")
    private WebElement selectMenuFamily;

    @FindBy(id = "Description")
    private WebElement textareaDescription;

    private static final String MENU_OPTION_XPATH = "//option[text()='%s']";
    private By saveButton = By.xpath("//div[@class='pbBottomButtons']//input[@name='save']");

    /**
     * Sets input name field.
     *
     * @param name  the name of the field
     */
    public void setNameField(final String name) {
        getWebElementAction().setTextField(inputName, name);
    }

    /**
     * Clicks on active CheckBox.
     */
    public void clickActiveCheckBox() {
        getWebElementAction().clickOnWebElement(inputActive);
    }

    /**
     * Sets input product code field.
     *
     * @param productCode  the name of the field
     */
    public void setProductCodeField(final String productCode) {
        getWebElementAction().setTextField(inputProductCode, productCode);
    }

    /**
     * Selects an option of the productFamily combo box.
     *
     * @param productFamilyOption the option to select
     */
    public void selectProductFamilyOption(final String productFamilyOption) {
        getWebElementAction().clickOnWebElement(selectMenuFamily);
        getDriver().findElement(By.xpath(String.format(MENU_OPTION_XPATH, productFamilyOption))).click();
    }

    /**
     * Sets the productDescription.
     *
     * @param productDescription to set
     */
    public void setProductDescription(final String productDescription) {
        getWebElementAction().setTextField(textareaDescription, productDescription);
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
        strategyMap.put("Name", () -> setNameField(product.getName()));
        strategyMap.put("IsActive", () -> clickActiveCheckBox());
        strategyMap.put("ProductCode", () -> setProductCodeField(product.getProductCode()));
        strategyMap.put("Family", () -> selectProductFamilyOption(product.getFamily()));
        strategyMap.put("Description", () -> setProductDescription(product.getDescription()));
        return strategyMap;
    }
}
