package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonUtils;
import utilities.Driver;

import java.util.List;

public class WebOrderHomePage {


    WebDriver driver = Driver.getDriver(CommonUtils.getProperty("browser"));

    public WebOrderHomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//td[contains(text(),'02/07')]/following-sibling::td/child::input[@alt='Edit']")
    public WebElement editButton;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_RequiredFieldValidator2")
    public WebElement verifyError;

    @FindBy(xpath = "//h2")
    public WebElement verifyEditOrderTitle;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement CustomerNameBox;

    @FindBy(id= "ctl00_MainContent_fmwOrder_UpdateButton")
    public WebElement updateButton;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement orderPart;

    @FindBy(xpath = "//a[@href='Default.aspx']")
    public WebElement viewAllOrders;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    public List<WebElement> firstColumnListData;


}