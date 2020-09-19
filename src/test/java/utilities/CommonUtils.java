package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import static utilities.constants.BROWSER;

public class CommonUtils {

    public  static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
       e.printStackTrace();
        }
    }
    public static void takeScreenshot(WebDriver driver, String testName) throws IOException {
        //Taking a screenshot
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //define the destination where to store the screenshot
        String destination="screenshots/"+testName+".getName()+System.currentTimeMillis()"+".png";
        File destScreenshot= new File(destination);

        //copy the original screen to as screenshot package
        FileUtils.copyFile(screenshot, destScreenshot);


    }

    public  static Properties readPropertyFile(String pathToPropertyFile) throws IOException {
        Properties properties= new Properties(); // this helps to read the properties by calling properties class from Java
        //passing out credential to file location
        File propFile= new File(pathToPropertyFile); // we are getting this from resources File by copying frn content root
        FileInputStream fileInputStream= new FileInputStream(propFile);
        properties.load(fileInputStream);

        return properties;
    }

    public static String getProperty(String key) {
        try {


           Properties properties= readPropertyFile("src/test/resources/Config/configurations.properties");
            String value = properties.getProperty(key);
            return value;
        }catch(IOException ex){
            ex.printStackTrace();
            throw  new RuntimeException("could not read properties file");
        }

    }


    public static WebElement fluentWait(int duration, int pollingTime, By locator){

        Wait<WebDriver> wait= new FluentWait<>(Driver.getDriver(getProperty(BROWSER)))
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element=wait.until(driver-> driver.findElement(locator));
        return element;
    }
      public static WebElement visibilityOfElement(int timeout, By locator){
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(getProperty(BROWSER)),timeout);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static WebElement elementToBeClickable(int timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(getProperty(BROWSER)), timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }
    public static void waitForTitle(int timeout, String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(getProperty(BROWSER)), timeout);
        wait.until(ExpectedConditions.titleIs(title));
    }
}
