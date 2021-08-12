/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Product;
import salesforce.ui.pages.product.NewProductPage;
import salesforce.ui.pages.product.ProductPage;
import salesforce.ui.pages.product.ProductsPage;
import salesforce.utils.ConverterToEntity;
import salesforce.utils.FileTranslator;
import java.util.Map;
import java.util.Set;

public class CreateProductSteps {
    private Logger logger = LogManager.getLogger(getClass());
    ProductsPage productsPage;
    Product product;
    ProductPage productPage;
    Set<String> fields;
    ApiRequestBuilder requestBuilder;
    ApiResponse apiResponse;

    public CreateProductSteps(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                              final Product newProduct) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.product = newProduct;
    }

    /**
     * Creates a product with provided values.
     *
     * @param table with the fields and values
     * @throws JsonProcessingException when invalid json provided
     */
    @When("I create a new Product with fields")
    public void iCreateANewProductWithFields(final Map<String, String> table) throws JsonProcessingException {
        logger.info("=================== When I create a new product ==========================");
        productsPage = new ProductsPage();
        NewProductPage newProductPage = productsPage.clickNewProductButton();
        product.setProduct(ConverterToEntity.convertMapToEntity(table, Product.class));
        fields = table.keySet();
        productPage = newProductPage.createProduct(table.keySet(), product);
        product.setId(productPage.getProductId());
    }

    /**
     * Verifies that a success message is displayed after creating a product.
     */
    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productPage.getUserSuccessMessage().contains(product.getName()),
                "Message is incorrect");
        softAssert.assertAll();
    }

    /**
     * Verifies that the product details match the entity.
     */
    @And("Check product fields matches")
    public void allProductFieldsMatches() {
        logger.info("=================== And All the given details fields should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product.getName(), productPage.getSpanText(FileTranslator
                .translateValue("Products", "productName")), "Product name is incorrect");
        softAssert.assertEquals(product.isActive(), productPage.isActive());
        softAssert.assertEquals(product.getProductCode(), productPage.getSpanText(FileTranslator
                .translateValue("Products", "productCode")), "Product code is incorrect");
        softAssert.assertEquals(product.getFamily(), productPage.getSpanText(FileTranslator
                .translateValue("Products", "productFamily")), "Product family is incorrect");
        softAssert.assertAll();
    }

    /**
     * Verifies that the product title matches the entity.
     */
    @And("Check The title matches")
    public void validateTheTitleMatches() {
        logger.info("=================== And The title should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product.getName(), productPage.getProductTitle(), "The title is incorrect");
        softAssert.assertAll();
    }

    /**
     * Verifies the information from table matches the created product.
     */
    @Then("The created product should be displayed on the legal entities table")
    public void theCreatedProductShouldBeDisplayedOnTheLegalEntitiesTable() {
        logger.info("=================== Then The created legal entity should be on table ==========================");
    }
}
