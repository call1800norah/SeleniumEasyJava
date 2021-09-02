package inputFormsPageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by norah on 7/22/2021.
 */
public class CheckboxDemo {

    //Single Checkbox Demo
    @FindBy(xpath = "//div[@class='panel-heading' and text()='Single Checkbox Demo']")
    public WebElement singleCheckboxHeader;

    @FindBy(xpath = "//div[@class='panel-body']//p[text()=' Clicking on the checkbox will display a success message. Keep an eye on it']")
    public  WebElement singleCheckboxMessage;

    @FindBy(xpath = "//input[@id='isAgeSelected']")
    public  WebElement singleCheckboxClick;

    @FindBy(xpath = "//div[@id='txtAge']")
    public  WebElement checkboxCheckedMessage;

    //Multiple checkbox Demo
    @FindBy(xpath = "//div[@class='panel-heading' and text()='Multiple Checkbox Demo']")
    public  WebElement multiCheckboxHeader;

    @FindBy(xpath = "//div[@class='panel-body']//p[text()='Check the below points before automating']")
    public  WebElement multiCheckboxMessage;

    @FindBy(xpath = "//div[@class='col-md-6 text-left']//ul//li")
    public List<WebElement> multiCheckboxMessages;

    @FindBy(xpath = "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div/label")
    public List<WebElement> checkboxOptions;

    @FindBy(xpath = "//input[@id='check1' and @value='Check All']")
    public WebElement checkAllButton;

    @FindBy(xpath = "//input[@id='check1' and @value='Uncheck All']")
    public WebElement uncheckAllButton;

}
