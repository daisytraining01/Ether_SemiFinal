@Salma
Feature: List of scenarios
  



@Test
   Scenario Outline: Validation of profile
     Given Launch the url
    And login with userName1 and password1
    When Click on me
    When you are in home page
    Then Click on profile
    And validate firstName
    And validate lastName
    And Validate phone number
    And Validate email
    And validate userName
    
    Examples:
    | id |
    | 1 |
    | 2 |
    
    
    
    
  
    
    
   

