package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import salesforce.utils.FileTranslator;

public class ProductsLightningSkin extends ProductsPageAbstract {

    private By newProductButton = By.xpath("//a[@title='"
            + FileTranslator.translateValue("Products", "newProductButton") + "']");

    /**
     * Gets the locator of the new product button.
     *
     * @return a WebElement.
     */
    @Override
    protected By getLocator() {
        return newProductButton;
    }

}
