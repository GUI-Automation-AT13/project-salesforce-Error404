/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Product;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.product.NewProductPageAbstract;
import salesforce.ui.pages.product.ProductPageAbstract;
import salesforce.utils.ConverterToEntity;
import java.util.Map;
import static salesforce.config.EnvironmentConfig.getSalesforceVersion;

public class CreateProductSteps {

    private Logger logger = LogManager.getLogger(getClass());
    private String lightningSkin = "lightning";
    NewProductPageAbstract newProductPage;
    ProductPageAbstract productPage;
    Product product;

    public CreateProductSteps(final Product newProduct) {
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
        product.setProduct(ConverterToEntity.convertMapToEntity(table, Product.class));
        newProductPage = AppPageFactory.getProductsPage().clickNewProductButton();
        productPage = newProductPage.createProduct(table.keySet(), product);
    }

    /**
     * Verifies that a success message is displayed after creating a product.
     */
    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        SoftAssert softAssert = new SoftAssert();
        if (getSalesforceVersion().equals(lightningSkin)) {
            softAssert.assertTrue(productPage.getSuccessMessage().contains(product.getName()),
                    "Message is incorrect");
            softAssert.assertAll();
        }
    }

    /**
     * Verifies that the product details match the entity.
     */
    @And("Check product fields matches")
    public void allProductFieldsMatches() {
        logger.info("=================== And All the given details fields should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product.getProductMap(), AppPageFactory.getProductPage().theProductMap(),
                "Product map is incorrect");
        softAssert.assertAll();
    }

    /**
     * Verifies that the product title matches the entity.
     */
    @And("Check The title matches")
    public void validateTheTitleMatches() {
        logger.info("=================== And The title should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        product.setId(productPage.getProductId());
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
