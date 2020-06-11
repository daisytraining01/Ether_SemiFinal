@Vineeth
Feature: DeleteRecipientDetail
  

  @Test
  Scenario: Delete Recipient
    Given Launch url
    And login with myuserName and mypassword 
    And enable rememberme option 
    Then verify the Home Page
    When user clicks the Transfer tab AddEdit Reciepient option
    Then verify Recipient Information page
    And user clicks on delete button
    