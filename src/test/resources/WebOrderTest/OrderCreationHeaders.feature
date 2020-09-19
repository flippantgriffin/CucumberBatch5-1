@regressiontest @TEC-1010
  Feature: Validating Headers

    @TEC-2012
    Scenario: Validation Product Information headers
      Given User navigates to webOrder application
      When User provides username "username" and the password "password"
      And User clicks on Order part
      Then User validates headers matching with "TestCasses" excel file expected result
      And User updates "TestCasses" with "PASS"

