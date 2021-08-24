package inputFormsPageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by norah on 7/27/2021.
 */
public class SimpleFormDemo {
    //SIngle Input Field
    @FindBy(xpath = "//div[@class='panel-heading' and text()='Single Input Field']")
    public WebElement SingleInputFieldHeading;

    @FindBy(xpath = "//div[@id='image-darkener']")
    public  WebElement ImageDarkener;

    @FindBy(xpath = "//a[@id='at-cv-lightbox-close']")
    public WebElement ImageCloseButton;

    @FindBy(xpath = "//label[@for='message' and text()='Enter message']")
    public WebElement EnterMessageLabel;

    @FindBy(xpath = "//input[@id='user-message']")
    public WebElement InputMessageBox;

    @FindBy(xpath = "//button[@onclick='showInput();']")
    public WebElement ShowMessageButton;

    @FindBy(xpath = "//div[@id='user-message']/label")
    public WebElement YourMessageLabel;

    @FindBy(xpath = "//div[@id='user-message']/span[@id='display']")
    public WebElement MessageDisplay;

    //Two Input Field
    @FindBy(xpath = "//label[@for='value1']")
    public WebElement EnterALabel;

    @FindBy(xpath = "//label[@for='value2']")
    public WebElement EnterBLabel;

    @FindBy(xpath = "//label[text()=' Total a + b = ']")
    public WebElement TotalLabel;

    @FindBy(xpath = "//input[@id= 'sum1']")
    public WebElement InputA;

    @FindBy(xpath = "//input[@id= 'sum2']")
    public WebElement InputB;

    @FindBy(xpath = "//button[@onclick='return total()']")
    public WebElement GetTotalButton;

    @FindBy(xpath = "//span[@id='displayvalue']")
    public WebElement DisplayValue;

}
