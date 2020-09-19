@regressiontest @TEC-1002
Feature: Order Creation Functionality

  Background: Creating Multiple Order
    Given User navigates to webOrder application
    When User provides username "Tester" and the password "test"
    Then User validates that application "is" logged in
    When User clicks on Order part


  @TEC-2003 @ui
  Scenario: Creating order with valid data

    When User clicks on Order part
    And User adds new order with data
    |Quantity|Customer name|Street    |City       |Zip  |State   |Card Number|Expire Date|
    |2       |John Doe     |123 Doe St|Des Plaines|60006|Illinois|1234567    |01/20      |
    Then User click on Process button and validates "New order has been successfully added." message
    When User click View All Orders part
    Then User created order is added to list with data
      |Quantity|Customer name|Street    |City       |Zip  |State   |Card Number|Expire Date|
      |2       |John Doe     |123 Doe St|Des Plaines|60006|Illinois|1234567    |01/20      |


    @TEC-2050  @ui

Scenario: Creating multiple order
      And User creates all orders from "TestData1" excel file
      Then User click on Process button and validates "New order has been successfully added." message
      When User click View All Orders part
      Then User validates that orders from "TestData1" excel file is created