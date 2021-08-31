package TestBase;

import inputFormsPageFactory.SimpleFormDemo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriverException;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;



/**
 * Created by norah on 7/22/2021.
 */
public class TestBaseMethods {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @Before
    public  void initialize(){

        //Setting the driver executable
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");

        //Initiating chrome driver
        driver = new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //Open browser with desired URL
        driver.get(("https://www.seleniumeasy.com/test/basic-first-form-demo.html"));
        assertEquals("Selenium Easy Demo - Simple Form to Automate using Selenium", driver.getTitle());


    }
    //Test cleanup
    @After
    public void TestClean() {
        driver.quit();
    }

    //Wait for IWebElement to be displayed using WebDriverWait
    public void WaitForDisplayed(WebElement element) {
        Assert.assertNotNull("The element return as null.", element);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        try
        {
            wait.until(e->element.isDisplayed());
            Assert.assertTrue("element was not displayed.", element.isDisplayed());
        }
        catch (TimeoutException e) {
            Assert.assertFalse("WaitForDisplayed timed out in 30seconds", element.isDisplayed());
            System.out.println(e.getMessage());
        }

    }



    //Verify a list of elements are all displayed.
    public void VerifyElementList(List<WebElement> elements, List<String> strElements)
    {
        for(WebElement e:elements) {
            WaitForDisplayed(e);
            CompareListWebElementToListString(elements, strElements);
        }
    }
    public void CompareListWebElementToListString(List<WebElement> elements, List<String> strElements)
    {
        int i = 0;
        for (String str:strElements)
        {
            Assert.assertTrue(str.equals(elements.get(i).getText().trim()));
            i++;
        }
    }

    //wait for the element to be clickable. Retry maxTries times.
    public void ClickWhenAble(WebElement element, long maxTries) {
        for (int retryCount = 1; retryCount <= maxTries; retryCount++) {
            {
                try {

                    element.click();
                    break;

                }catch(WebDriverException e)
                {
                    e.printStackTrace();
                }
                if(retryCount > maxTries)
                {
                    System.out.println("Click reached maximum tries of" + maxTries);
                }
                wait.pollingEvery(Duration.ofMillis(500));
            }

        }
    }
    public void MenuList(String menuName)
    {
        TestBaseFactory testBaseFactory = PageFactory.initElements(driver, TestBaseFactory.class);
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList.add(testBaseFactory.MenuListHeader);
        elementList.add(testBaseFactory.AllExamplesNavBar);
        elementList.add(testBaseFactory.InputFormsNavBar);

       List<String> elementListString = new ArrayList<String>();
       elementListString.add("Menu List");
        elementListString.add("All Examples");
        elementListString.add("Input Forms");

        VerifyElementList(elementList, elementListString);

        testBaseFactory.InputFormsNavBar.click();
        List<String> elementCollectionItems =  new ArrayList<String>();

        elementCollectionItems.add("Simple Form Demo");
        elementCollectionItems.add("Checkbox Demo");
        elementCollectionItems.add("Radio Buttons Demo");
        elementCollectionItems.add("Select Dropdown List");
        elementCollectionItems.add("Input Form Submit");
        elementCollectionItems.add("Ajax Form Submit");
        elementCollectionItems.add("JQuery Select dropdown");

        VerifyElementList(testBaseFactory.InputFormsItems, elementCollectionItems);

        for (WebElement e: testBaseFactory.InputFormsItems)
        {
            if (e.getText().trim().equals(menuName))
            {
                e.click();
                break;
            }
        }
    }

    public void ImageCloseMethod(String menuName) {
        SimpleFormDemo simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        long timeoutInSeconds = 30;
        wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(e->simpleFormDemo.ImageDarkener.isDisplayed());

        if ((timeoutInSeconds <= 30) && (simpleFormDemo.ImageDarkener.isDisplayed()))
        {
            simpleFormDemo.ImageCloseButton.click();
            MenuList(menuName);
        }
        else if ((timeoutInSeconds >= 30) && (!simpleFormDemo.ImageDarkener.isDisplayed()))
        {
            wait.until(e->simpleFormDemo.ImageDarkener.isDisplayed());
            simpleFormDemo.ImageCloseButton.click();
            MenuList(menuName);
        }
        else
        {
            MenuList(menuName);
        }
    }


}
