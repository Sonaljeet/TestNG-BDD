@LeftpanelAdmin
Feature: CEP Overview-Left Panel

  Background: Login to the CEP application
    Given user is on CEP login page
    When user enters admin username and password
    And userr entafadsf
    Then user should be able to login
    And CEP homepage should get displayed

  @Geography
  Scenario: Validate the Geography Names in the Left Panel
    Given user is on CSD Overview page
    When user clicks on JCI arrow in the left panel
    Then geography names should displayed
    And API data should match with names in the response message

  #78732&78740
  @TC1
  Scenario: Validate left panel navigation tree for user mapped with more than one geography
    Given user is on Overview page
    When left panel details loaded
    Then user validates the active tab to be displayed for default selected JCI
    And user validate the tree structure in the left panel
    And user validate the page displayed after clicking left panel items
    And db data should match with the UI

  
  @TC2
  Scenario: Verify default selected tab in left panel for more than one geography
    Given user is on Overview page
    When left panel details loaded

  #TC78746
  @TC5
  Scenario: Verify active tab to be displayed on the tab based on the selection made by user
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on each tab in the left panel
    And validate the active tab to be displayed for the selected tab

  #TC78747
  @TC6
  Scenario: Verify state of the left panel navigation tree to be changed to default selected tab after refreshing of page
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on arrow in the left panel
    And user refresh the page
    And left panel state should change to default

  #TC78748
  @TC7
  Scenario: Verify Overview tab to be displayed as default selected when user logged-into the application
    Then user validate if Overview page is the default page or not

  #TC78852
  @TC8
  Scenario: Verify Overview tab displayed when JCI is selected in left panel navigation tree
    Given user is on Overview page
    When left panel details loaded
    Then user validates the widgets in the overview tab
    And all four widgets should get display for chillers

  #TC78854
  @TC10
  Scenario: Verify Overview tab displayed when Country is selected in left panel navigation tree
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on each Geography and Country arrow
    And user validates all four widgets getting displayed for each country

  #TC78855
  @TC11
  Scenario: Verify Overview tab displayed when Branch is selected in left panel navigation tree
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on each Geography, Country arrow and Branch name
    And user validates all four widgets getting displayed for each branch

  #TC78856
  @TC12
  Scenario: Verify Overview tab displayed when Customer is selected in left panel navigation tree
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on each Geography, Country, Branch arrow and Customer name
    And user validates all four widgets getting displayed for each Customer

  #TC78857
  @TC13
  Scenario: Verify Overview tab displayed when site/facility is selected in left panel navigation tree
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on each Geography, Country, Branch, Customer arrow and Project name
    And user validates all four widgets getting displayed for each Project

  #TC78858
  @TC14
  Scenario: Verify Trends page to be displayed when Chiller is selected in left panel navigation tree
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on each Geography, Country, Branch, Customer, Project arrow and Chillers name
    And user validates Trends getting displayed for each Chiller

  #TC78912
  @TC16
  Scenario: Verify breadcrumb sequences in Overview tab
    Given user is on Overview page
    When left panel details loaded
    Then user clicked on each JCI, Geography,Country,Branch,Customer,Site
    And user validates breadcrumb sequences in Overview tab
