/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static core.selenium.MyWebDriverManager.getWebDriverManager;

public class PopUpMessage {
    private String messageXpath = "//span[contains(@class,'toastMessage')]";

    /**
     * Gets the pop up message.
     *
     * @return a String with the message
     */
    public String getPopUpMessage() {
        WebElement webElement = getWebDriverManager().getDriver()
                .findElement(By.xpath(messageXpath));
        getWebDriverManager().getWebDriverWait()
                .until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
}
