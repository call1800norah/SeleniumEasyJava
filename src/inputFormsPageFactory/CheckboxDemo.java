package inputFormsPageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
