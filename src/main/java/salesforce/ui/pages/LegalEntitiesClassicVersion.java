package salesforce.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegalEntitiesClassicVersion extends LegalEntitiesPageAbstract {

    @FindBy(xpath = "//input[@name='new']")
    private WebElement newEntityBtn;

    private String legalEntityNumberCellXpath = "//tr[@class='dataRow even first']//a[text()='%s']";
    private By dialogWindow = By.xpath("(//div[@class='topLeft']//a[@class='dialogClose'])[last()]");
    private final int time = 2000;

    /**
     * .
     * @return .
     */
    @Override
    protected WebElement getLocator() {
        if (getWebElementAction().isElementPresent(dialogWindow, time)) {
            closeWindow();
        }
        return newEntityBtn;
    }

    /**
     * .
     * @param name .
     * @return .
     */
    @Override
    public String getLegalEntityId(final String name) {
        return getWebElementAction().getAttributeFromWebElement(getWebElementAction()
                        .getWebElementByXpathAndValue(legalEntityNumberCellXpath, name),
                "href");
    }

    private void closeWindow() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(dialogWindow));
    }
}
