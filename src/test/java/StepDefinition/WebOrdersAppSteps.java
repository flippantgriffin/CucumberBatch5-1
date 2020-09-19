package StepDefinition;

import CukesRunner.Runner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OrderPage;
import pages.WebOrderHomePage;
import pages.WebOrdersLogInPage;
import utilities.CommonUtils;
import utilities.Driver;
import utilities.ExcelUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WebOrdersAppSteps {
    WebDriver driver = Driver.getDriver("chrome");
    WebOrdersLogInPage webOrdersLogInPage = new WebOrdersLogInPage();
    WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
    OrderPage orderPage= new OrderPage();

    @Given("User navigates to webOrder application")
    public void user_nagivates_to_web_order_application() {
        driver.get(CommonUtils.getProperty("WebOrdersURL"));

    }

    @When("User provides username {string} and the password {string}")
    public void user_provides_username_and_the_password(String username, String password) {
        webOrdersLogInPage.logIn(username, password);
    }

    @Then("User validates that application {string} logged in")
    public void user_validates_that_application_logged_in(String condition) {
        if (condition.equalsIgnoreCase("is")) {
            String expectedTitle = "Web Orders";
            String actualTitle = driver.getTitle();
            Assert.assertEquals("Actual title:  " + actualTitle +
                    "Didn't match with expected title" + expectedTitle, expectedTitle, actualTitle);
        } else if (condition.equalsIgnoreCase("is not")) {

            String expectedErrorMessage = "Invalid Login or Password.";
            String actualErrorMessage = webOrdersLogInPage.errorMessage.getText();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }
    }

    @When("click to edit button of the first name {string} on the list of All Orders")
    public void click_to_edit_the_first_name_on_the_list_of_all_orders(String string) {
        webOrderHomePage.editButton.click();

    }

    @Then("User should be able to navigate to Edit Order")
    public void user_should_be_able_to_navigate_to_edit_order() {

      String exceptedTitle="Edit Order";
      String actualTitle=webOrderHomePage.verifyEditOrderTitle.getText();
    Assert.assertEquals(exceptedTitle,actualTitle);
    }
    @Then("verify that mandatory fields can not be empty")
    public void verify_that_mandatory_fields_can_not_be_empty() throws IOException {
        webOrderHomePage.CustomerNameBox.clear();
        webOrderHomePage.updateButton.click();
        Assert.assertTrue(webOrderHomePage.verifyError.getText().equals("Field 'Customer name' cannot be empty."));
        CommonUtils.takeScreenshot(driver, "verifiedBlankField");
    }

    @Then("change the Costumer Name section from {string} to {string} under the Address information")
    public void change_the_costumer_name_section_from_to_under_the_address_information(String string, String string2) {
    webOrderHomePage.CustomerNameBox.sendKeys("Apple Red");
    }

    @Then("Click Update Button to save the changed name")
    public void click_update_button_to_save_the_changed_name() {
        webOrderHomePage.updateButton.click();
    }

    @When("User clicks on Order part")
    public void user_clicks_on_order_part() {
        webOrderHomePage.orderPart.click();

    }

    @When("User adds new order with data")
    public void user_adds_new_order_with_data(DataTable dataTable) {
        List<Map<String, Object>> data=dataTable.asMaps(String.class, Object.class);
        orderPage.quantityTab.clear();
        orderPage.quantityTab.sendKeys(data.get(0).get("Quantity").toString());
        orderPage.customerNameBox.sendKeys(data.get(0).get("Customer name").toString());
        orderPage.stateBox.sendKeys(data.get(0).get("State").toString());
        orderPage.streetBox.sendKeys(data.get(0).get("Street").toString());
        orderPage.cityBox.sendKeys(data.get(0).get("City").toString());
        orderPage.zipBox.sendKeys(data.get(0).get("Zip").toString());
        orderPage.visaCardBox.click();
        orderPage.cardNumBox.sendKeys(data.get(0).get("Card Number").toString());
        orderPage.expireDate.sendKeys(data.get(0).get("Expire Date").toString());

    }
    @Then("User click on Process button and validates {string} message")
    public void user_click_on_process_button_and_validates_message(String success) {
        orderPage.processButton.click();
        String actualMessage = orderPage.verifyOrderCreated.getText();
        Assert.assertEquals(success, actualMessage);
    }
    @When("User click View All Orders part")
    public void user_click_view_all_orders_part() {
        webOrderHomePage.viewAllOrders.click();


    }
    @Then("User created order is added to list with data")
    public void user_created_order_is_added_to_list_with_data(DataTable dataTable) {
        List<Map<String, Object>>data=dataTable.asMaps(String.class, Object.class);

        Assert.assertEquals(data.get(0).get("Customer name"), webOrderHomePage.firstColumnListData.get(1).getText());
        Assert.assertEquals(data.get(0).get("Quantity"),webOrderHomePage.firstColumnListData.get(3).getText());
        Assert.assertEquals(data.get(0).get("Street"),webOrderHomePage.firstColumnListData.get(5).getText());
        Assert.assertEquals(data.get(0).get("City"),webOrderHomePage.firstColumnListData.get(6).getText());
        Assert.assertEquals(data.get(0).get("State"),webOrderHomePage.firstColumnListData.get(7).getText());
        Assert.assertEquals(data.get(0).get("Zip"),webOrderHomePage.firstColumnListData.get(8).getText());
        Assert.assertEquals(data.get(0).get("Card Number"),webOrderHomePage.firstColumnListData.get(10).getText());
        Assert.assertEquals(data.get(0).get("Expire Date"),webOrderHomePage.firstColumnListData.get(11).getText());
    }
    @Then("User validates headers matching with {string} excel file expected result")
    public void user_validates_headers_matching_with_excel_file_expected_result(String excelFile) {
   ExcelUtils.openExcelFile(excelFile,"Sheet1");
   String expectedResult= ExcelUtils.getValue(1,4);
        System.out.println(expectedResult);
        String[] result=expectedResult.split("\n");

        System.out.println(Arrays.toString(result));
        Assert.assertEquals(result[1],orderPage.productLabel.getText());
        Assert.assertEquals(result[2],orderPage.quantityLabel.getText());
        Assert.assertEquals(result[3],orderPage.pricePerUnitLabel.getText());
        Assert.assertEquals(result[4],orderPage.discountLabel.getText());
        Assert.assertEquals(result[5],orderPage.totalLabel.getText());
    }
    @Then("User updates {string} with {string}")
    public void user_updates_with(String string, String string2) {
       ExcelUtils.setValue(1,6,string2);
    }
    @Given("User creates all orders from {string} excel file")
    public void user_creates_all_orders_from_excel_file(String fileName) {
        ExcelUtils.openExcelFile(fileName,"Sheet1");
      int lastRow= ExcelUtils.openExcelFile(fileName,"Sheet1").getLastRowNum(); //getLatRowNum will help us to not to hard code in the loo[

        List<List<String>> excelData= new ArrayList<>();
        for(int i=1;i<8;i++){
       //ExcelUtils.openExcelFile(fileName,"Sheet1");
       List<String>rowData=ExcelUtils.getRowValues(i);
       excelData.add(rowData);

        }
       for(int i=0;i<excelData.size();i++){
           orderPage.quantityTab.clear();
           orderPage.quantityTab.sendKeys(excelData.get(i).get(0));
           orderPage.customerNameBox.sendKeys(excelData.get(i).get(1));
           orderPage.streetBox.sendKeys(excelData.get(i).get(2));
           orderPage.cityBox.sendKeys(excelData.get(i).get(3));
           orderPage.stateBox.sendKeys(excelData.get(i).get(4));
           orderPage.zipBox.sendKeys(excelData.get(i).get(5).substring(0,excelData.get(5).indexOf('.')));
           orderPage.visaCardBox.click();
           orderPage.cardNumBox.sendKeys(excelData.get(i).get(6).substring(0,excelData.get(6).indexOf('.')));
           orderPage.expireDate.sendKeys(excelData.get(i).get(7));
           orderPage.processButton.click();
       }
    }


    @Then("User validates that orders from {string} excel file is created")
    public void user_validates_that_orders_from_excel_file_is_created(String string) {

    }




    }

