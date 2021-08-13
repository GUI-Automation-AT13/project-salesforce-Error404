package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.utils.FileTranslator;

import java.util.HashMap;

public class ProductLightningSkin extends ProductPageAbstract {

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @FindBy(css = ".slds-page-header__title > .uiOutputText")
    private WebElement productTitle;

    private By descriptionTextArea = By.xpath("//div/span[text()='Product Description']/../..//span/span");

    private By createdByDate = By.xpath("//span[text()='"
            + FileTranslator.translateValue("Products", "createdBy")
            + "']/../..//span[contains(@class,'uiOutputDateTime')]");
    private By activeCheckBoxChecked = By.xpath("//span[text()='"
            + FileTranslator.translateValue("Products", "active") + "']/../..//img");

    private final int time = 2000;
    private static final String SPAN_XPATH = "//div/span[text()='%s']/../..//span/span";

    /**
     * Gets the text of spans.
     *
     * @param fieldName the name of the field
     * @return the text of a span
     */
    public String getSpanText(final String fieldName) {
        return getWebElementAction()
                .getTextOnWebElement(getDriver().findElement(By.xpath(String.format(SPAN_XPATH, fieldName))));
    }

    /**
     * Gets if product is active.
     *
     * @return true if it is active, false if not
     */
    public boolean isActive() {
        WebElement checkbox = getDriver().findElement(activeCheckBoxChecked);
        return checkbox.getAttribute("alt").contains("True");
    }

    /**
     * Gets the description of the product.
     *
     * @return the description
     */
    public String getDescription() {
            return getWebElementAction().getTextOnWebElement(getDriver().findElement(descriptionTextArea));
    }

    /**
     * Gets the date in which the product was created.
     *
     * @return a String with the date.
     */
    public String getCreatedByDate() {
        return getWebElementAction().getTextOnWebElement(getDriver().findElement(createdByDate));
    }

    /**
     * Gets the success message.
     *
     * @return a String with the message.
     */
    @Override
    public String getSuccessMessage() {
        return getWebElementAction().getTextOnWebElement(successMessage);
    }

    /**
     * Gets the product title.
     *
     * @return a String with the title.
     */
    @Override
    public String getProductTitle() {
        return getWebElementAction().getTextOnWebElement(productTitle);
    }

    /**
     * Gets the product's id.
     *
     * @return a string with the value
     */
    @Override
    public String getProductId() {
        String url = getWebElementAction().getSiteCurrentUrl();
        String preIdString = "Product2/";
        String posIdString = "/view";
        System.out.println(url.length());
        System.out.println("url   " + url);
        System.out.println(url.indexOf(preIdString));
        System.out.println(preIdString.length());
        System.out.println(url.indexOf(posIdString));
        return url.substring(url.indexOf(preIdString) + preIdString.length(), url.indexOf(posIdString));
    }

    /**
     * Builds a map from the ui.
     *
     * @return HashMap<String, String> with the product map
     */
    @Override
    public HashMap<String, String> theProductMap() {
        HashMap<String, String> productMap = new HashMap<>();
        productMap.put("Name", getSpanText("Product Name"));
        productMap.put("IsActive", isActive() + "");
        productMap.put("ProductCode", getSpanText("Product Code"));
        productMap.put("Family", getSpanText("Product Family"));
        return productMap;
    }
}
