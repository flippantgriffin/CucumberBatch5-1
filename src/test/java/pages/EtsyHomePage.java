package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyHomePage {

    WebDriver driver = Driver.getDriver("browser");

    public EtsyHomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='catnav-primary-link-10855']/parent::a")
    public WebElement jewelryAccessoriesLink;
    @FindBy(xpath = "//span[@id='catnav-primary-link-10923']/parent::a")
    public WebElement clothingShoesLink;
    @FindBy(xpath = "//span[@id='catnav-primary-link-891']/parent::a")
    public WebElement homeLivingLink;
    @FindBy(xpath = "//span[@id='catnav-primary-link-10983']/parent::a")
    public WebElement weddingPartyLink;
    @FindBy(xpath = "//span[@id='catnav-primary-link-11049']/parent::a")
    public WebElement toysEntertainmentLink;
    @FindBy(xpath = "//span[@id='catnav-primary-link-66']/parent::a")
    public WebElement artCollectiblesLink;

    @FindBy(css="#global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy(xpath="//h3[@class='text-gray text-truncate mb-xs-0 text-body ']")
    public List<WebElement> items;

    @FindBy(xpath = "//a[@href='https://www.etsy.com/search?q=carpet&explicit=1&min=1000&max=&price_bucket=1']")
    public WebElement radioButton;

    @FindBy(xpath = "//span[@class='wt-hide-xs wt-show-md filter-expander']")
    public WebElement filtersButton;

    @FindBy(xpath = "//span[@class='currency-value']")
    public List<WebElement> prices;

}