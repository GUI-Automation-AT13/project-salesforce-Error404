package salesforce.ui.pages.product;

import salesforce.ui.pages.BasePage;
import java.util.HashMap;

public abstract class ProductPageAbstract extends BasePage {

    @Override
    protected void waitForPageToLoad() {
    }

    public abstract HashMap<String, String> theProductMap();

    public abstract String getSuccessMessage();

    public abstract String getProductTitle();

    public abstract String getProductId();

}
