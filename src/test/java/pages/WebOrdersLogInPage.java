package pages;

import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonUtils;
import utilities.Driver;

public class WebOrdersLogInPage {

    WebDriver driver= Driver.getDriver(CommonUtils.getProperty("browser"));

    public WebOrdersLogInPage(){
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "#ctl00_MainContent_username")
    public WebElement username;

    @FindBy (css="#ctl00_MainContent_password")
    public WebElement password;

    @FindBy(css="#ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id="ctl00_MainContent_status")
    public WebElement errorMessage;

    public void logIn(String username, String password){
         this.username.sendKeys(username);
         this.password.sendKeys(password);
         this.loginButton.click();

    }

}
