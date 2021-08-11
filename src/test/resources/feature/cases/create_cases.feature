Feature: Create Cases

  @CreateAccount @CreateContact @DeleteCase @DeleteContact
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
    Then a case created message should be displayed
    And all header's fields should match the created case
    Then all detail's fields should match the created case
    When I navigate to the "CASES" page
    Then the created case is displayed

  @DeleteCase @CreateAccount
  Scenario Outline: Create a case with caseOrigin and status
    Given I login to salesforce as an admin user
    When I navigate to the "CASES" page
    When I create a case with fields
      | status      | <status>     |
      | caseOrigin  | <caseOrigin> |
      | accountName | Punisher     |
    Then a case created message should be displayed
    And all header's fields should match the created case
    Then all detail's fields should match the created case
    When I navigate to the "CASES" page
    Then the created case is displayed
    Examples:
      | status    | caseOrigin |
      | New       | Phone      |
      | New       | Email      |
      | New       | Web        |
      | Working   | Phone      |
      | Working   | Email      |
      | Working   | Web        |
      | Escalated | Phone      |
      | Escalated | Email      |
      | Escalated | Web        |

  @DeleteCase
  Scenario: Create a case with required fields
    Given I login to salesforce as an admin user
    When I navigate to the "CASES" page
    When I create a case with fields
      | status     | Working |
      | caseOrigin | Phone   |
    Then a case created message should be displayed
    And all header's fields should match the created case
    Then all detail's fields should match the created case
    When I navigate to the "CASES" page
    Then the created case is displayed