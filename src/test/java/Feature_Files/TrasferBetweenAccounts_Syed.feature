@Syed
Feature: Transfer amount between accounts
	To Check after every transaction that the correct account has been transfered
  
  @TransferBetWeenAccount
  Scenario Outline: To veriy the amount transferred between same account
    Given logged with the  "<url>" , "<username>" and "<password>" in Browser
    And A fund transer of rupees "<amount>" has been done betweeb the same account
    When The user opens the primary statement page
    And The Statement is sorted in the descending order
    Then User verifies that the last transaction "<amount>"
    And Logs out of the application

    Examples: 
      | url                                        | username | password   | amount  |
      | http://elastic.rapidtestpro.com:8086/index | labuser  | labuser@01 | 1000    |
    
  #@TransferSomeoneAccount    
  #Scenario Outline: To veriy the amount transferred between same account
    #Given logged with the  "http://elastic.rapidtestpro.com:8086/index" , "labuser" and "labuser@01" in Browser
    #And A fund transer of rupees "<amount>" has been done betweeb the recipient account
    #When The user opens the secondary statement page
    #And The Statement is sorted in the descending order
    #Then User verifies that the last transaction "<amount>"
    #And Logs out of the application
#
    #Examples: 
      #| amount  |
      #|   1     |
      #|   2     |
      #|   3     |
      #|   4     |
      #|   5     |



