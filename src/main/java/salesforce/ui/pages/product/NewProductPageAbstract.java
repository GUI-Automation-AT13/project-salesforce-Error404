package salesforce.ui.pages.product;

import salesforce.entities.Product;
import salesforce.ui.pages.BasePage;
import java.util.HashMap;
import java.util.Set;

public abstract class NewProductPageAbstract extends BasePage {

    public NewProductPageAbstract() {
        waitForPageToLoad();
    }

    @Override
    protected void waitForPageToLoad() {
    }

    protected abstract ProductPageAbstract clickSaveBtn();

    protected abstract HashMap<String, Runnable> buildMap(Product product);

    /**
     * Creates the product map.
     *
     * @param fields      Set<string> with the keys.
     * @param product to obtain the values to be set.
     * @return ProductPageAbstract.
     */
    public ProductPageAbstract createProduct(final Set<String> fields, final Product product) {
        HashMap<String, Runnable> map = buildMap(product);
        fields.forEach(field -> map.get(field).run());
        return clickSaveBtn();
    }

}
