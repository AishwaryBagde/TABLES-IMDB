package demo;

import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

    ChromeDriver driver;

    public Table() {
        // 1. Launch Browser (Chrome) :ChromeDriver()
        System.out.println("Constructor");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        // 1.2 Maximize Window :driver.manage().window().maximize();
        driver.manage().window().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() : driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("Ending The Test Case");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
   
    // 2. Load URL :https://www.imdb.com/chart/top
    driver.get("https://www.imdb.com/chart/top");
    Thread.sleep(3000);
    // "3. Locating the dropdown and selecting ""IMDb Rating"" 
    //          :Select select = new Select(driver.findElementByTagName(""select"")); / select.selectByVisibleText(""IMDb Rating"");"
    Select select = new Select(driver.findElementByTagName("select"));
    Thread.sleep(1000);
    select.selectByVisibleText("IMDb Rating");

    // 4. Locating the highest rated movie and Printing it Using Locator "XPath":"(//td[@class='titleColumn'])[1]" / getText();
    WebElement highRatedMovie = driver.findElementByXPath("(//td[@class='titleColumn'])[1]");
    System.out.println("The Highest rated Movie is : " + highRatedMovie.getText());

    // 5. Locating how many movies are present  and Printing it Using Locator "Class" Name:"desc" / getText();
    WebElement moviesPresent = driver.findElementByClassName("desc");
    System.out.println("The Total No of Movies Present are : " + moviesPresent.getText());
    Thread.sleep(1000);
    // "6. Locating the dropdown and selecting ""Release Date"" 
    //          :select.selectByVisibleText(""Release Date"");"
    select.selectByVisibleText("Release Date");
    // 7. Locating the filter option Using Locator "XPath":WebElement filter / "//span[@data-sort='rk:desc']" 
    WebElement filterOption = driver.findElementByXPath("//span[@data-sort='rk:desc']");
    // 8. Checkinng if the filter is Asc or Des id Des click :if(filter.getAttribute("title").equals("Descending order") /  filter.click();
    if(filterOption.getAttribute("title").equals("Descending order")){
        filterOption.click();
    }
    // 9. Locating the oldest movie on the list :"(//td[@class='titleColumn'])[1]" / getText();
    WebElement oldestMovie = driver.findElementByXPath("(//td[@class='titleColumn'])[1]");
    System.out.println("The Oldest Movie is : " + oldestMovie.getText());
    Thread.sleep(1000);
    // 10. Checkinng if the filter is Asc or Des  if Asc click :if(filter.getAttribute("title").equals("Ascending order") / filter.click();
    if(filterOption.getAttribute("title").equals("Ascending order")){
        filterOption.click();
    }
    // 11. Locating the most recent movie on the list and Printing it :"(//td[@class='titleColumn'])[1]" / getText();
    WebElement recentMovie = driver.findElementByXPath("(//td[@class='titleColumn'])[1]");
    System.out.println("The Most Recent Movie is : " + recentMovie.getText());
    Thread.sleep(1000);
    // "12. Locating the dropdown and selecting ""Number of Ratings"":select.selectByVisibleText(""Number of Ratings"");"
    select.selectByVisibleText("Number of Ratings");
    Thread.sleep(1000);
    // 13. Locating the highest rated movie and Printing it Using Locator "XPath":"(//td[@class='titleColumn'])[1]" / getText();
    System.out.println("The Highest rated Movie is : " + highRatedMovie.getText());
    // 14. Locating the ratings and prtnting it :"(//td[@class='ratingColumn imdbRating'])[1]" / getText();
    WebElement ratings = driver.findElementByXPath("(//td[@class='ratingColumn imdbRating'])[1]");
    Thread.sleep(1000);
    System.out.println("The Highest Movie Rating is : " + ratings.getText());
    
    }
}