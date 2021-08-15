Feature: create legal entity

  @DeleteLegalEntity
  Scenario: Create an Legal entity with required fields.
    Given I login to salesforce as an admin user
    When I navigate to the "LEGAL_ENTITIES" page
    When I create a new LegalEntity with fields
      | Name | new entity |
    Then A successful message should be displayed
    And The header name should match in the created legal entity page
    And All given details fields should match in the created legal entity page
    When I navigate to the "LEGAL_ENTITIES" page
    Then The created legal entity should be displayed on the legal entities table

  @DeleteLegalEntity
  Scenario Outline: create an Legal entity with all fields.
    Given I login to salesforce as an admin user
    When I navigate to the "LEGAL_ENTITIES" page
    When I create a new LegalEntity with fields
      | Name                  | new complete entity |
      | CompanyName           | new company         |
      | LegalEntityStreet     | S. elm # 557        |
      | Description           | blue door           |
      | LegalEntityCity       | new city            |
      | LegalEntityState      | the state           |
      | LegalEntityPostalCode | 0023                |
      | LegalEntityCountry    | bolivia             |
      | Status                | Active              |
    Then A successful message should be displayed
    And The header name should match in the created legal entity page
    And All given details fields should match in the created legal entity page
    When I navigate to the "LEGAL_ENTITIES" page
    Then The created legal entity should be displayed on the legal entities table
    And The following information should be displayed on the LegalEntities table
      | Name               | <name>         |
      | Last Modified Date | <modifiedDate> |
      | Last Modified By   | <modifiedBy>   |
    Examples:
      | name             | modifiedDate             | modifiedBy             |
      | LEGALENTITY_NAME | LEGALENTITY_MODIFIEDDATE | LEGALENTITY_MODIFIEDBY |