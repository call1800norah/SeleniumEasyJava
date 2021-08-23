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
    public WebElement SingleCheckboxHeader;

    @FindBy(xpath = "//div[@class='panel-body']//p[text()=' Clicking on the checkbox will display a success message. Keep an eye on it']")
    public  WebElement SingleCheckboxMessage;

    @FindBy(xpath = "//input[@id='isAgeSelected']")
    public  WebElement SingleCheckboxClick;

    @FindBy(xpath = "//div[@id='txtAge']")
    public  WebElement CheckboxCheckedMessage;

    //Multiple checkbox Demo
    @FindBy(xpath = "//div[@class='panel-heading' and text()='Multiple Checkbox Demo']")
    public  WebElement MultiCheckboxHeader;

    @FindBy(xpath = "//div[@class='panel-body']//p[text()='Check the below points before automating']")
    public  WebElement MultiCheckboxMessage;

    @FindBy(xpath = "//div[@class='col-md-6 text-left']//ul//li")
    public List<WebElement> MultiCheckboxMessages;

    @FindBy(xpath = "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div/label")
    public List<WebElement> CheckboxOptions;

    @FindBy(xpath = "//input[@id='check1' and @value='Check All']")
    public WebElement CheckAllButton;

    @FindBy(xpath = "//input[@id='check1' and @value='Uncheck All']")
    public WebElement UnCheckAllButton;

}
