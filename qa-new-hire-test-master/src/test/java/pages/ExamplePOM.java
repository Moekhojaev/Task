package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExamplePOM {

    WebDriver driver;
    By logo = By.xpath("//img[@alt='Header Logo']");
    By searchButton = By.xpath("//div[contains(@class,'tab tab-search')]");
    By addressLocation = By.xpath("//*[@id='search-box-input']");
    By addressSearchButton = By.xpath("//div[@id='map-left-panel']//button[1]");
    By menu = By.xpath("//div[@class='tab tab-tools inactive']");
    By DifferentViews= By.xpath("//div[@class='map-type-button-container']");



    public ExamplePOM(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogo() {
        Assert.assertEquals(driver.findElement(logo).getAttribute("src"), "https://lakelandelectric.com/Portals/_default/Skins/Lakeland/img/banner.PNG");
    }

    public void clicksSearchBox() {
        driver.findElement(searchButton).click();
    }

    public void addressInbox(String address) {
        driver.findElement(addressLocation).sendKeys(address);
    }

    public void clickAddressSearch() {
        driver.findElement(addressSearchButton).click();
    }

    public void clickMenu() {
        driver.findElement(menu).click();
    }
    public void ConvertViews() {

      for(int i=0; i<3; i++) {
          driver.findElement(DifferentViews).click();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          takeScreenshot();
      }

    }


    public void takeScreenshot() {
        //take screenshot of the page
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("src/test/screenshots.png"));
        } catch (IOException e) {

            e.printStackTrace();
        }



    }
}
