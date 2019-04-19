@TimeSeries
Feature: TimeSeries Daily Data Verification

  @DataVerification
  Scenario: Verify and create Data verification checlist on daily basis
    Given user receive all point IDs for verification
    When user hit the server with each point ID for different time intervals
    Then user should receive proper response and data for metric from the server
    And data for the given metric should be validated and details should be updated in excel

  @HistoricalDataVerification
  Scenario: Verify and create Historical Data verification checlist on daily basis
    Given user receive all point IDs for historical verification
    When user hit the server with each point ID for different time intervals
    Then user should receive proper response and data for metric from the server for historical verification
    And historical data for the given metric should be validated and details should be updated in excel

  #CSDvsCEP API
  @DataComparison
  Scenario: Compare prod data with that of API
    Given data from API and prod should be available
    When user compare both data
    Then data should match and status should get updated in the sheet

  #CSD APIvsCEP API
  @DataComparisonAPI
  Scenario: Compare prod API data with that of CEP API
    Given data from prod API and CEP API should be available
    When user compare both data
    Then API data should match and status should get updated in the sheet

  @Hit&GetCEPData
  Scenario: Get CSD Temp value
    Given user hit the api and get the value

  #Get Total Point IDs for each Assets
  @GetPointIDCount
  Scenario: Get point ID count for each asset
    Given user connected to CEP DB
    And user fetched AssetID and ProjectID for all Assets
    When user hit the entity API for each Asset
    Then count of point ID for each assets should return in the response
    And the count should get updated in the excel sheet

  #Get Point ID status and its latest timestamp
  @GetPointLatestTimeStamp
  Scenario: Get latest timestamp for each point IDs for CHWR-T
    Given user hit entity and get all Point IDs
    When user hit timeseries api for each point id
    Then latest timestamp should be avaialable as response
    And details should get updated in the excel

  #Compare data for each points in Assets with model name like '%yk%' for 19 Attributes
  @CompareDataForYK
  Scenario: Compare CEP data with that of CSD for all points in Assets
    Given user hits both CEP and CSD server and fetch data
    When user hits the CEP and CSD timeseries api for each points in the asset
    Then temperature data from both api should be available
    And data should be compared
    And comparison result should get updated in spreadsheet

  #Compare the rules count obtained from Entity with that of the DB data
  @RulesData
  Scenario: Compare rules data of entity and DB
    Given user read data from rules json and update it on DB
    When user hit the CEP prod entity with input as Asset and Project ID
    Then data for each Assets should be available
    And attribute details for each assets should get updated in the DB

  #Insert data into DB
  @AddDataToDB
  Scenario: Add Attributes data to DB
    Given Data available and added to DB

  #Get the Matched and Unmatched Count based on the result of @RulesData
  @RulesDataMatchedUnMatchedCount
  Scenario: Get matched and unmatched rules count
    Given data available in ChillerModel and AssetAttributes table
    Then user triggered query in both tables and get the count
    And the count should get updated in the spreadsheet

  #Get Points status for each status
  @GetPointStatus
  Scenario: Get assetwise point status for each asset.(Status-Active/Forbidden)
    Given assetID and projectID available
    When user hit prod entity for using each assetID
    Then point status should get updated based on response
