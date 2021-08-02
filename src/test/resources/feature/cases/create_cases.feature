Feature: Create Cases

  @DeleteCase
  Scenario: Create a case with required fields
    Given I login to salesforce as an admin user
    When I navigate to the "CASES" page
    When I create a case with fields
      | status     | Working |
      | caseOrigin | Phone   |
    Then a success message is displayed
    When I check on the site's headers
    Then all header's fields match to the created case
    And I check on the site's details
    Then all detail's fields match to the created case
    When I navigate to the "CASES" page
    Then the created case is displayed

  @CreateAccount @CreateContact @DeleteCase @DeleteAccount @DeleteContact
  Scenario: Create a case with all required fields
    Given I login to salesforce as an admin user
    And I navigate to the "CASES" page
    When I create a case with fields
      | status               | New             |
      | caseOrigin           | Phone           |
      | contactName          | Frank Castle    |
      | accountName          | Punisher        |
      | type                 | Mechanical      |
      | caseReason           | Installation    |
      | priority             | Medium          |
      | webEmail             | email@email.com |
      | webName              | my name         |
      | webCompany           | my company      |
      | webPhone             | 1111 2222 4444  |
      | product              | GC1040          |
      | potentialLiability   | No              |
      | sLAViolation         | Yes             |
      | engineeringReqNumber | 5               |
      | subject              | The subject     |
      | description          | The description |
      | internalComments     | The comments    |
    Then a success message is displayed
    When I check on the site's headers
    Then all header's fields match to the created case
    And I check on the site's details
    Then all detail's fields match to the created case
    When I navigate to the "CASES" page
    Then the created case is displayed