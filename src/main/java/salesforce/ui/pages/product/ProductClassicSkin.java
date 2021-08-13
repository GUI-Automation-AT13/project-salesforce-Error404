package salesforce.ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import static salesforce.config.EnvironmentConfig.getBaseUrlClassic;

public class ProductClassicSkin extends ProductPageAbstract {

    @FindBy(id = "Name_ileinner")
    private WebElement name;

    @FindBy(id = "IsActive_chkbox")
    private WebElement checkboxActive;

    @FindBy(id = "ProductCode_ileinner")
    private WebElement productCode;

    @FindBy(id = "Family_ileinner")
    private WebElement family;

    @FindBy(id = "Description_ileinner")
    private WebElement description;

    @FindBy(xpath = "//h2[@class='pageDescription']")
    private WebElement headerName;

    /**
     * Gets the product name text.
     *
     * @return a String with the product name text.
     */
    public String getNameText() {
        return fixText(getWebElementAction().getTextOnWebElement(name));
    }

    /**
     * Gets the product product code text.
     *
     * @return a String with the product product code text.
     */
    public String getProductCodeText() {
        return fixText(getWebElementAction().getTextOnWebElement(productCode));
    }

    /**
     * Gets the product product family text.
     *
     * @return a String with the product product family text.
     */
    public String getProductFamilyText() {
        return fixText(getWebElementAction().getTextOnWebElement(family));
    }

    /**
     * Gets if product is active.
     *
     * @return true if it is active, false if not
     */
    public boolean isActive() {
        return !checkboxActive.getAttribute("alt").contains("No");
    }

    /**
     * Gets the description of the product.
     *
     * @return the description
     */
    public String getDescription() {
        return getWebElementAction().getTextOnWebElement(description);
    }

    /**
     * There is no message in the lightning skin.
     *
     * @return an empty message.
     */
    @Override
    public String getSuccessMessage() {
        return "";
    }

    /**
     * Gets the product title.
     *
     * @return a String with the title.
     */
    @Override
    public String getProductTitle() {
        return getWebElementAction().getTextOnWebElement(headerName);
    }

    /**
     * Gets the product's id.
     *
     * @return a string with the value
     */
    @Override
    public String getProductId() {
        String url = getWebElementAction().getSiteCurrentUrl();
        return url.substring(getBaseUrlClassic().length() + 1);
    }

    /**
     * Builds a map from the ui.
     *
     * @return HashMap<String, String> with the product map
     */
    @Override
    public HashMap<String, String> theProductMap() {
        HashMap<String, String> productMap = new HashMap<>();
        productMap.put("Name", getNameText());
        productMap.put("IsActive", isActive() + "");
        productMap.put("ProductCode", getProductCodeText());
        productMap.put("Family", getProductFamilyText());
        return productMap;
    }

    /**
     * Fixes the text if it's empty.
     *
     * @param text the text to fix.
     * @return null is the text is empty, the text otherwise.
     */
    public String fixText(final String text) {
        if (text.equals(" ")) {
            return "";
        }
        return text;
    }
}
