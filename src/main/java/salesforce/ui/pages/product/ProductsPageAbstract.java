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
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.BasePage;

public abstract class ProductsPageAbstract extends BasePage {

    @FindBy(css = "a.forceActionLink")
    private WebElement newLink;

    public ProductsPageAbstract() {
        waitForPageToLoad();
    }

    /**
     * Waits for the page to load.
     */
    @Override
    protected void waitForPageToLoad() {
    }

    protected abstract By getLocator();

    /**
     * Clicks on New button and opens the form to create a new product.
     *
     * @return a NewProductPage instance
     */
    public NewProductPageAbstract clickNewProductButton() {
        By locatorNewButton = getLocator();
        getWebElementAction().clickOnWebElement(getDriver().findElement(locatorNewButton));
        return AppPageFactory.getNewProductPage();
    }
}
