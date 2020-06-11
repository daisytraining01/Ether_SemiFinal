@Sugan_Samp
Feature: Test to Add/Edit Recipient(Benificiary)
  
  @Test
  Scenario Outline: Case is to add the recipient(Beneficiary)
    	
    	Given Launch url
    	And login with userName and password
    	When Home Page has Launched - Deposit Options are only available in Home Page
    	And Click on Transfer Menu
    	Then Click Add/Edit Recipient from Transfer Menu
    	Then Enter all the inputs
    	And Click on Add/Edit Recipient
    Then Verify the added Recipient
    
    Examples:
    | id |
    | 1 |
    | 2 |
    	
   @Test
   Scenario Outline: Case is to Edit the Recipient(Beneficiary)
   		Given Launch url
   	And login with userName and password
   	When Home Page has Launched - Deposit Options are only available in Home Page
   	And Click on Transfer Menu
   	Then Click Add/Edit Recipient from Transfer Menu
   	And Click the First Entry
   	Then Enter all the inputs
   	And Click on Add/Edit Recipient
   	Then Verify the Edited Recipient
   
   	Examples:
    | id |
    | 1 |
    | 2 |
    	
    	
    	
 


