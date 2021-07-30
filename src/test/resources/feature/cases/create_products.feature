Feature: Create Product

  @DeleteProduct
  Scenario: Create a product with just required fields
    Given I login to salesforce as an admin user
    When I navigate to PRODUCTS page
    When I create a new Product with fields
      | Name | product to test |
    Then A successful message is displayed
    And Check product fields matches
    And Check The title matches
    And Check The created date matches

  Scenario: Create a product with all fields
    Given I login to salesforce as an admin user
    When I navigate to PRODUCTS page
    When I create a new Product with fields
      | Name        | product to test        |
      | ProductCode | product code           |
      | Family      | None                   |
      | Description | Product description    |
    Then A successful message is displayed
    And Check product fields matches
    And Check The title matches
    And Check The created date matches