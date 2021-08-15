Feature: Search in App Launcher modal

  Scenario: Search "Service" in the App Launcher Modal
    Given I login to salesforce as an admin user
    When I open the App Launcher modal
    And I enter Service into the search box
    Then Apps related to Service are shown on its section
    And Items related to Service are shown on its section