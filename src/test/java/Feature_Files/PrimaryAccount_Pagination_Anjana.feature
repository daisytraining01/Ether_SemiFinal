@PrimaryAccount_Pagination @Anjana
Feature: To Verify the Primary Account Pagination and Search

  @Login_Validate_Pagination
  Scenario Outline: Login to the TechFish Bank and verify pagination in primary Account
    Given Launch the url "<URL>"
    And login using the USERNAME and PASSWORD
    When navigate to the primary account page
    And verify if the page has been navigated to the primary account
    Then verify if pagination is working

    Examples: 
      | URL                                        |
      | http://elastic.rapidtestpro.com:8086/index |

  @Login_Validate_Search
  Scenario Outline: To verify the search option in Primary Account details
    Given Launch the url "http://elastic.rapidtestpro.com:8086/index"
    And login using the USERNAME and PASSWORD
    When navigate to the primary account page
    And verify if the page has been navigated to the primary account
    And enter a search value "<search>"
    Then verify if the expected record "<search>" is displayed

    Examples: 
      | search |
      |   2000 |
