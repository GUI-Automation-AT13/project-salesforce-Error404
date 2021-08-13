/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import salesforce.ui.pages.legalentity.*;
import salesforce.ui.pages.product.*;

import static core.config.LoadEnvironmentFile.getTheSalesforceVersion;

public class AppPageFactory {

    private static String skin = getTheSalesforceVersion();

    /**
     * Gets the legal entities page.
     *
     * @return the correct legal entities page instance.
     */
    public static LegalEntitiesPageAbstract getLegalEntitiesPage() {
        if (skin.equals("classic")) {
            return new LegalEntitiesClassicSkin();
        }
        return new LegalEntitiesLightningSkin();
    }

    /**
     * Gets the new legal entity page.
     *
     * @return the correct new legal entities page instance.
     */
    public static NewLegalEntityPageAbstract getNewLegalEntityPage() {
        if (skin.equals("classic")) {
            return new NewLegalEntityClassicSkin();
        }
        return new NewLegalEntityLightningSkin();
    }

    /**
     * Gets the legal entity page.
     *
     * @return the correct legal entity page instance.
     */
    public static LegalEntityPageAbstract getLegalEntityPage() {
        if (skin.equals("classic")) {
            return new LegalEntityClassicSkin();
        }
        return new LegalEntityLightningSkin();
    }

    /**
     * Gets the products page.
     *
     * @return the correct products page instance.
     */
    public static ProductsPageAbstract getProductsPage() {
        if (skin.equals("classic")) {
            return new ProductsClassicSkin();
        }
        return new ProductsLightningSkin();
    }

    /**
     * Gets the legal entity page.
     *
     * @return the correct legal entity page instance.
     */
    public static NewProductPageAbstract getNewProductPage() {
        if (skin.equals("classic")) {
            return new NewProductClassicSkin();
        }
        return new NewProductLightningSkin();
    }

    /**
     * Gets the product page.
     *
     * @return the correct product page instance.
     */
    public static ProductPageAbstract getProductPage() {
        if (skin.equals("classic")) {
            return new ProductClassicSkin();
        }
        return new ProductLightningSkin();
    }

}
