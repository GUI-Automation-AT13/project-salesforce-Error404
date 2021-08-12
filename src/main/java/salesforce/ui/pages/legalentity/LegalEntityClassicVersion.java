package salesforce.ui.pages.legalentity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LegalEntityClassicVersion extends LegalEntityPageAbstract {

    @FindBy(id = "Name_ileinner")
    private WebElement name;

    @FindBy(id = "CompanyName_ileinner")
    private WebElement companyName;

    @FindBy(id = "LegalEntityAddress_ileinner")
    private WebElement address;

    @FindBy(id = "Description_ileinner")
    private WebElement description;

    @FindBy(id = "Status_ileinner")
    private WebElement status;

    @FindBy(xpath = "//h2[@class='pageDescription']")
    private WebElement headerName;

    private final int time = 2000;
    private By addressId = By.id("LegalEntityAddress_ileinner");

    /**
     * Builds a map from the ui.
     *
     * @return HashMap<String, String> with the entity map
     */
    @Override
    public HashMap<String, String> entityMap() {
        HashMap<String, String> entityMap = new HashMap<>();
        entityMap.put("Name", getNameText());
        entityMap.put("CompanyName", getCompanyNameText());
        entityMap.put("LegalEntityStreet", getAddressText().get(0));
        entityMap.put("Address", getAddressText().get(1));
        entityMap.put("Country", getAddressText().get(2));
        entityMap.put("Description", getDescriptionText());
        entityMap.put("Status", getStatusText());
        return entityMap;
    }

    /**
     * Gets the entity name text.
     *
     * @return a string with the entity name text.
     */
    @Override
    public String getHeaderEntityNameText() {
        return fixText(getWebElementAction().getTextOnWebElement(headerName));
    }

    /**
     * There is no message in the lightning skin.
     *
     * @return .
     */
    @Override
    public String getSuccessMessage() {
        return "";
    }

    /**
     * Gets the entity or company name text.
     *
     * @return a String with the entity or company name text.
     */
    public String getNameText() {
        return fixText(getWebElementAction().getTextOnWebElement(name));
    }

    /**
     * Gets the company name text.
     *
     * @return a String with company name text.
     */
    public String getCompanyNameText() {
        return fixText(getWebElementAction().getTextOnWebElement(companyName));
    }

    /**
     * Gets the description text.
     *
     * @return a String with the description text.
     */
    public String getDescriptionText() {
        return fixText(getWebElementAction().getTextOnWebElement(description));
    }

    /**
     * Gets the status text.
     *
     * @return a String with the status text.
     */
    public String getStatusText() {
        return fixText(getWebElementAction().getTextOnWebElement(status));
    }

    /**
     * Gets the address text.
     *
     * @return a String with address text.
     */
    public List<String> getAddressText() {
        List<String> separatedAddress = new ArrayList<String>();
        String theAddress = null;
        if (fixAddress()) {
            if (!getDriver().findElement(addressId).getText().isEmpty()) {
                theAddress = getDriver().findElement(addressId).getText();
                System.out.println("entro al if ray =>  " + theAddress);
                separatedAddress.addAll(Arrays.asList(theAddress.split("\n")));
            } else {
                separatedAddress.add(null);
                separatedAddress.add(null);
                separatedAddress.add(null);
            }
        }
        System.out.println(separatedAddress);
        System.out.println(theAddress);
        return separatedAddress;
    }

    /**
     * Verify if a element is present.
     *
     * @return true if the element is present, false otherwise.
     */
    public boolean fixAddress() {
        System.out.println();
        if (getWebElementAction().isElementPresent(addressId, time)) {
            System.out.println("elemento presente");
            return true;
        }
        return false;
    }

    /**
     * Fixes the text if it's empty.
     *
     * @param text the text to fix.
     * @return null is the text is empty, the text otherwise.
     */
    public String fixText(final String text) {
        if (text.equals(" ")) {
            return null;
        }
        return text;
    }

}
