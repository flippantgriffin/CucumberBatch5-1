package StepDefinition;

import CukesRunner.Runner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utilities.CommonUtils;
import utilities.Driver;

import java.util.List;
import java.util.NoSuchElementException;

public class EtsySteps {
    WebDriver driver = Driver.getDriver("browser");
    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @Given("User navigates to application")
    public void user_navigates_to_application() {
        driver.get(CommonUtils.getProperty("EtsyURL"));
    }

    @When("User clicks on {string} part")
    public void user_clicks_on_part(String department) {

        if (department.equals("Jewelry & Accessories"))
            etsyHomePage.jewelryAccessoriesLink.click();
        else if (department.equals("Clothing & Shoes"))
            etsyHomePage.clothingShoesLink.click();
        else if (department.equals("Home & Living"))
            etsyHomePage.homeLivingLink.click();
        else if (department.equals("Wedding & Party"))
            etsyHomePage.weddingPartyLink.click();
        else if (department.equals("Toys & Entertainment"))
            etsyHomePage.toysEntertainmentLink.click();
        else if (department.equals("Art & Collectibles"))
            etsyHomePage.artCollectiblesLink.click();
    }

    @Then("User validates that {string} title")
    public void user_validates_that_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @Given("User navigates to Etsy application")
    public void user_navigates_to_etsy_application() {
    driver.get("https://www.etsy.com/");

    }

        @When("User searches for {string}")
    public void user_searches_for(String item) {
        etsyHomePage.searchBox.sendKeys(item + Keys.ENTER);

    }


    @Then("User validates the result contains")
    public void user_validates_the_result_contains(DataTable dataTable) {
     List<String> items=dataTable.asList();
     for(WebElement element: etsyHomePage.items){
         String itemName=element.getText();
         //System.out.println(itemName);
         boolean isFound=false;
          for (String item:items){
            if(itemName.toLowerCase().contains(item)){
              isFound=true;
            }
          }
          Assert.assertTrue(itemName,isFound);
     }
    }

    @When("User select over ${int} option")
    public void user_select_over_$_option(Integer int1) {
        //try {
          //  etsyHomePage.filtersButton.click();
       // }catch(NoSuchElementException e){
           // System.out.println("Filters button was not there");
        //}
        etsyHomePage.radioButton.click();


    }

    @Then("User validates that all prices are over {int}")
    public void user_validates_that_all_prices_are_over(Integer int1) {
        for(WebElement element:etsyHomePage.prices){
            String price= element.getText(); //1,,010.50
            price=price.replace(",","");
            double priceInDouble=Double.parseDouble(price);
            Assert.assertTrue(priceInDouble>int1);


        }

    }

}

