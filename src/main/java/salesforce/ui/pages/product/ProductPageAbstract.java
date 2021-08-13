/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

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
