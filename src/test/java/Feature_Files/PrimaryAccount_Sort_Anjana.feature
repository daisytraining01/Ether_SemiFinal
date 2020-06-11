@PrimaryAccount_Sort @Anjana
Feature: Login to FishTech site and verify sort operation

  @PrimaryAccount_Sort_Data
  Scenario: Navigate to the primary account and validate the sort option
   Given Launch the url "http://elastic.rapidtestpro.com:8086/index"
    And login using the USERNAME and PASSWORD
    When navigate to the primary account page
    And verify if the page has been navigated to the primary account
    Then verify the sort option
