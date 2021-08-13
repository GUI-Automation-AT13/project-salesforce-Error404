package salesforce.ui.pages.product;

import org.openqa.selenium.By;

public class ProductsClassicSkin extends ProductsPageAbstract {

    private By newProductBtn = By.xpath("//input[@name='new']");
    private By dialogWindow = By.xpath("(//div[@class='topLeft']//a[@class='dialogClose'])[last()]");
    private final int time = 2000;

    /**
     * Gets the locator of the new product button.
     *
     * @return a WebElement.
     */
    @Override
    protected By getLocator() {
        if (getWebElementAction().isElementPresent(dialogWindow, time)) {
            closeWindow();
        }
        return newProductBtn;
    }

    /**
     * Closes the add window.
     */
    private void closeWindow() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(dialogWindow));
    }
}
