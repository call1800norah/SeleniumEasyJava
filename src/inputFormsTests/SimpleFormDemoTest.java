package inputFormsTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBaseMethods;
import inputFormsPageFactory.SimpleFormDemo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by norah on 7/27/2021.
 */
public class SimpleFormDemoTest extends TestBaseMethods {
    public SimpleFormDemo simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);

    @Test
    public void SingleInputFieldUnitTest(){
        //simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        List<WebElement> labelsElementList = new ArrayList<WebElement>();
        labelsElementList.add( simpleFormDemo.EnterMessageLabel);
        labelsElementList.add(simpleFormDemo.YourMessageLabel);

        List<String> labelListString = new ArrayList<String>();
        labelListString.add("Enter message");
        labelListString.add("Your Message:");

        //Verify message headers and texts displayed
        VerifyElementList(labelsElementList, labelListString);

        //Method for closing Image popup
        ImageCloseMethod("Input Forms");

        InputMesssage("Hello Selenium");


    }
    private void InputMesssage(String message)
    {
        //simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        simpleFormDemo.InputMessageBox.sendKeys(message);
        simpleFormDemo.ShowMessageButton.click();
        String formattedMessage = String.format("%s was not displayed.",message);
        Assert.assertEquals(message, simpleFormDemo.MessageDisplay.getText(),formattedMessage);

    }

}
