/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

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
