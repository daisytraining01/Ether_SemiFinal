@Ajay
Feature: HomePage Accounts View Link Check

@Test
Scenario: Successful Login with Valid Credentials
                Given User Navigate to Login Page
                And User enters UserName and Password
                Then Message displayed Login Successfully
                Then Primary Balance and Savings Balance are displayed

@Test   
Scenario: View Primary Balance
					 Given User Navigate to Login Page
                And User enters UserName and Password              
                Given User clicks on Primary Balance
                Then Primary Balance and Transaction details are displayed    
               

@Test   
Scenario: View Savings Balance
 Given User Navigate to Login Page
                And User enters UserName and Password       
                Given User clicks on Savings Balance
                Then Savings Balance and Transaction details are displayed
                
