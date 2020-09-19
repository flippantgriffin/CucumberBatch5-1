$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/WebOrderTest/OrderCreationFunctionality.feature");
formatter.feature({
  "name": "Order Creation Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regressiontest"
    },
    {
      "name": "@TEC-1002"
    }
  ]
});
formatter.background({
  "name": "Creating Multiple Order",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to webOrder application",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_nagivates_to_web_order_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides username \"Tester\" and the password \"test\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_provides_username_and_the_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validates that application \"is\" logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_validates_that_application_logged_in(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Order part",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_clicks_on_order_part()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating order with valid data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regressiontest"
    },
    {
      "name": "@TEC-1002"
    },
    {
      "name": "@TEC-2003"
    },
    {
      "name": "@ui"
    }
  ]
});
formatter.step({
  "name": "User clicks on Order part",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_clicks_on_order_part()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User adds new order with data",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_adds_new_order_with_data(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Process button and validates \"New order has been successfully added.\" message",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_click_on_process_button_and_validates_message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click View All Orders part",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_click_view_all_orders_part()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User created order is added to list with data",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_created_order_is_added_to_list_with_data(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Creating Multiple Order",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to webOrder application",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_nagivates_to_web_order_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides username \"Tester\" and the password \"test\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_provides_username_and_the_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validates that application \"is\" logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_validates_that_application_logged_in(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Order part",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_clicks_on_order_part()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating multiple order",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regressiontest"
    },
    {
      "name": "@TEC-1002"
    },
    {
      "name": "@TEC-2050"
    },
    {
      "name": "@ui"
    }
  ]
});
formatter.step({
  "name": "User creates all orders from \"TestData1\" excel file",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_creates_all_orders_from_excel_file(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.StringIndexOutOfBoundsException: begin 0, end -1, length 7\n\tat java.base/java.lang.String.checkBoundsBeginEnd(String.java:3756)\n\tat java.base/java.lang.String.substring(String.java:1902)\n\tat StepDefinition.WebOrdersAppSteps.user_creates_all_orders_from_excel_file(WebOrdersAppSteps.java:170)\n\tat ✽.User creates all orders from \"TestData1\" excel file(file:///Users/ridvanbolgi/IdeaProjects/CucumberBatch5/src/test/resources/WebOrderTest/OrderCreationFunctionality.feature:28)\n",
  "status": "failed"
});
formatter.step({
  "name": "User click on Process button and validates \"New order has been successfully added.\" message",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_click_on_process_button_and_validates_message(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User click View All Orders part",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_click_view_all_orders_part()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User validates that orders from \"TestData1\" excel file is created",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.WebOrdersAppSteps.user_validates_that_orders_from_excel_file_is_created(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});