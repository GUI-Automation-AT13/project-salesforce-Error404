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
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;
import salesforce.utils.FileTranslator;

/**
 * This class returns an instance of ProductsPage.
 */
public class ProductsPage extends BasePage {

    @FindBy(css = "a.forceActionLink")
    private WebElement newLink;

    private By newProductButton = By.xpath("//a[@title='"
            + FileTranslator.translateValue("Products", "newProductButton") + "']");

    /**
     * Waits for the page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(newLink));
    }

    /**
     * Clicks on New button and opens the form to create a new product.
     *
     * @return a NewProductPage instance
     */
    public NewProductPage clickNewProductButton() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(newProductButton));
        return new NewProductPage();
    }

}
