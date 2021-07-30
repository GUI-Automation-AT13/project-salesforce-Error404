Feature: create legal entity

  @DeleteLegalEntity
  Scenario: create an Legal entity with required fields.
    Given I login to Salesforce site as an admin user
    When I navigate to the "LEGALENTITY" page
    When I create a new LegalEntity with fields
      | Name | new entity |
    Then A successful message is displayed
    And The title matches
    And All given details fields matches
    When I navigate to the "LEGALENTITY" page
    Then the created legal entity is displayed

  @DeleteLegalEntity
  Scenario: create an Legal entity with all fields.
    Given I login to Salesforce site as an admin user
    When I navigate to the "LEGALENTITY" page
    When I create a new LegalEntity with fields
      | Name                  | new entity UNIQUE_ID |
      | CompanyName           | new company          |
      | LegalEntityStreet     | S. elm # 557         |
      | Description           | blue door            |
      | LegalEntityCity       | new city             |
      | LegalEntityState      | the state            |
      | LegalEntityPostalCode | 0023                 |
      | LegalEntityCountry    | boolivia             |
      | Status                | Active               |
    Then A successful message is displayed
    And The title matches
    And All given details fields matches
    When I navigate to the "LEGALENTITY" page
    Then the created legal entity is displayed