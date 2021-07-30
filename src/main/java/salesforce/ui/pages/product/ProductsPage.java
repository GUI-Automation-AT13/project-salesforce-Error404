package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class returns an instance of ProductsPage.
 */
public class ProductsPage extends BasePage {

    @FindBy(css = ".forceActionLink > div")
    private WebElement newProductButton;

    @FindBy(xpath = "//div/a[contains(@class, 'rowActionsPlaceHolder')]")
    private WebElement showActionsButton;

    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(newProductButton));
    }

    /**
     * Logs in successfully.
     *
     * @return a ProductPage instance
     */
    public NewProductPage clickNewProductButton() {
        getWebElementAction().clickOnWebElement(newProductButton);
        return new NewProductPage();
    }

    /**
     * Search for a product given the name.
     *
     * @param productName the name of the product
     * @return boolean that indicates if product exists
     */
    public boolean productExist(final String productName) {
        return getDriver().findElement(By.linkText(productName)).getText().equals(productName);
    }
}
