Feature: Create Product

  @DeleteProduct
  Scenario: Create a product with just required fields
    Given I login to salesforce as an admin user
    When I navigate to the "PRODUCTS" page
    When I create a new Product with fields
      | Name | product to test |
    Then A successful message is displayed
    And Check product fields matches
    And Check The title matches

  @DeleteProduct
  Scenario Outline: Create a product with all fields
    Given I login to salesforce as an admin user
    When I navigate to the "PRODUCTS" page
    When I create a new Product with fields
      | Name        | product to test     |
      | IsActive    | true                |
      | ProductCode | product code        |
      | Family      | None                |
      | Description | Product description |
    Then A successful message is displayed
    And Check product fields matches
    And Check The title matches
    When I navigate to the "PRODUCTS" page
    Then The created product should be displayed on the legal entities table
    And The following information should be displayed on the Products table
      | Product Name        | <productName>        |
      | Product Code        | <productCode>        |
      | Product Description | <productDescription> |
      | Product Family      | <productFamily>      |
    Examples:
      | productName  | productCode         | productDescription  | productFamily  |
      | PRODUCT_NAME | PRODUCT_PRODUCTCODE | PRODUCT_DESCRIPTION | PRODUCT_FAMILY |