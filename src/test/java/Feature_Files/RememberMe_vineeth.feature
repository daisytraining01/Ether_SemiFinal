@Vineeth
Feature: RememberMe Function
  

  @Test
  Scenario: loginRememberMe
    Given Launch url
    And login with myuserName and mypassword 
    And enable rememberme option 
    Then verify the Home Page
    When user logout from the Home page
    Then verify the login page
    And verify default username content in the username textbox
 


