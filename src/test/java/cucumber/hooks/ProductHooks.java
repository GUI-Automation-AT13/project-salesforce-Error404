/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package cucumber.hooks;

import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import salesforce.api.petitions.ProductPetition;
import salesforce.entities.Product;

public class ProductHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Product product;
    private ProductPetition productPetition = new ProductPetition();

    public ProductHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                        final Product newProduct) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.product = newProduct;
    }

    @After(value = "@DeleteProduct", order = 2)
    public void deleteAProduct() {
        productPetition.deleteProduct(requestBuilder, product, apiResponse);
    }
}
