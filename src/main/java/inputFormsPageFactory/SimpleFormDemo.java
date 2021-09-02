package inputFormsPageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by norah on 7/27/2021.
 */
public class SimpleFormDemo {
    //SIngle Input Field
    @FindBy(xpath = "//div[@class='panel-heading' and text()='Single Input Field']")
    public WebElement singleInputFieldHeading;

    @FindBy(xpath = "//div[@id='image-darkener']")
    public  WebElement imageDarkener;

    @FindBy(xpath = "//a[@id='at-cv-lightbox-close']")
    public WebElement imageCloseButton;

    @FindBy(xpath = "//label[@for='message' and text()='Enter message']")
    public WebElement enterMessageLabel;

    @FindBy(xpath = "//input[@id='user-message']")
    public WebElement inputMessageBox;

    @FindBy(xpath = "//button[@onclick='showInput();']")
    public WebElement showMessageButton;

    @FindBy(xpath = "//div[@id='user-message']/label")
    public WebElement yourMessageLabel;

    @FindBy(xpath = "//div[@id='user-message']/span[@id='display']")
    public WebElement messageDisplay;

    //Two Input Field
    @FindBy(xpath = "//label[@for='value1']")
    public WebElement enterALabel;

    @FindBy(xpath = "//label[@for='value2']")
    public WebElement enterBLabel;

    @FindBy(xpath = "//label[text()=' Total a + b = ']")
    public WebElement totalLabel;

    @FindBy(xpath = "//input[@id= 'sum1']")
    public WebElement inputA;

    @FindBy(xpath = "//input[@id= 'sum2']")
    public WebElement inputB;

    @FindBy(xpath = "//button[@onclick='return total()']")
    public WebElement getTotalButton;

    @FindBy(xpath = "//span[@id='displayValue']")
    public WebElement displayValue;

}
