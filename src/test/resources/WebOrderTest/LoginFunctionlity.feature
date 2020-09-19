
@smoketest @regressiontest @TEC-1001
Feature: Testing log in functionality

  @TEC-2001 @TEC-2002
  Scenario Outline: Testing log in functionality with valid credentials
    Given User navigates to webOrder application
    When User provides username "<Username>"and the password "<password>"
    Then User validates that application "<condition>" logged in
    Examples:
    |Username|password|condition|
    |Testers |Test    |is       |
    |Test |Tester     |is not   |



