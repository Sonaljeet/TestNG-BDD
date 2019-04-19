@LeftpanelLocalUser
Feature: CSD Overview-Left Panel

  Background: Login to the CEP application
    Given user is on CEP login page
    When user enters local user username and password
    Then user should be able to login
    And CEP homepage should get displayed

  @TC2 @TC4
  Scenario: Verify left panel navigation tree for user mapped with one geography
    Given user is on local user Overview page
    When left panel details for local user gets loaded
    Then user validates the active tab to be displayed for default selected geography
    And user validate the tree structure for local user in the left panel
    And API data should match with the data in left panel for local user

  #TC78853
  @TC9
  Scenario: Verify Overview tab displayed when Geography is selected in left panel navigation tree
    Given user is on local user Overview page
    When left panel details for local user gets loaded
    Then user validates the widgets in the overview tab for user with one geography
    And all four widgets should get display for chillers under one geography
