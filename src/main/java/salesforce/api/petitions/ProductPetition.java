/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api.petitions;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import salesforce.entities.Product;

public class ProductPetition {

    /**
     * Deletes a Product.
     *
     * @param requestBuilder the request builder.
     * @param product to delete.
     * @param apiResponse the api response.
     */
    public void deleteProduct(final ApiRequestBuilder requestBuilder, final Product product,
                              final ApiResponse apiResponse) {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Product2/{productID}")
                .addPathParams("productID", product.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
