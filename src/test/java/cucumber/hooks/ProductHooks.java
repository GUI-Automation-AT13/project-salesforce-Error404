/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import io.cucumber.java.After;
import salesforce.entities.Product;
import static salesforce.api.petitions.ProductPetition.deleteProduct;

public class ProductHooks {
    private Product product;

    public ProductHooks(final Product newProduct) {
        this.product = newProduct;
    }

    @After(value = "@DeleteProduct", order = 2)
    public void deleteAProduct() {
        deleteProduct(product);
    }
}
