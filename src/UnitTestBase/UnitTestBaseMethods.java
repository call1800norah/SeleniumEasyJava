package UnitTestBase;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

/**
 * Created by norah on 7/22/2021.
 */
public class UnitTestBaseMethods {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement element;

    @Before
    public  void initialize(){

        //Setting the driver executable
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriber\\bin\\chromedriver.exe");

        //Initiating chrome driver
        driver = new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //Open browser with desired URL
        driver.get(("https://www.seleniumeasy.com/test/basic-first-form-demo.html"));
        assertEquals("Selenium Easy Demo - Simple Form to Automate using Selenium", driver.getTitle());

    }


}
