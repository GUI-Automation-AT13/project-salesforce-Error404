package cucumber.hooks;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import salesforce.entities.Product;

public class ProductHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Product product;

    public ProductHooks(ApiRequestBuilder requestBuilder, ApiResponse apiResponse, Product product) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
        this.product = product;
    }

    @After(value = "@DeleteProduct",order = 2)
    public void deleteACase() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Product2/{productID}")
                .addPathParams("productID", product.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
