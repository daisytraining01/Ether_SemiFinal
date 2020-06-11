@Vineeth
Feature: Login with Multiple data

@Test
Scenario Outline: Login with Multiple data

Given Launch url 

When I enter Username as "<username>" and Password as "<password>"

Then login should be unsuccessful


Examples:

| username  | password  | 
| vineeth | maveric@123 | 
| ram | Qwerty@63 |