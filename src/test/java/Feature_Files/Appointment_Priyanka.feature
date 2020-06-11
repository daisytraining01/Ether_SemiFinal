@Priyanka
Feature: Schedule an appointment to bank URL

 @appointment @Priya
  Scenario Outline: appointment
    Given Launch url
    And login with userName and password
    When click on appointment
     Then schedule an appointment
     And you store the records in DB
     And Pick a Date and Time
     And Pick a location
     And update Notes
     Then finally click on Submit scheduling
     And Verify the HomePage Landed Successfully
     
    Examples:
    | ID |
    | 1 |
    | 2 |
    | 3 |
    #| 4 |
    #| 5 |
    #
    

     