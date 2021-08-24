package inputFormsTests;
import org.junit.Assert;
import org.junit.Before;
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
    public SimpleFormDemo simpleFormDemo;

    @Test
    public void SingleInputFieldUnitTest(){
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        List<WebElement> labelsElementList = new ArrayList<>();
        labelsElementList.add( simpleFormDemo.EnterMessageLabel);
        labelsElementList.add(simpleFormDemo.YourMessageLabel);

        List<String> labelListString = new ArrayList<>();
        labelListString.add("Enter message");
        labelListString.add("Your Message:");

        //Method for closing Image popup
        ImageCloseMethod("Input Forms");

        //Verify message headers and texts displayed
        VerifyElementList(labelsElementList, labelListString);



        InputMesssage("Hello Selenium");


    }
    private void InputMesssage(String message)
    {
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        simpleFormDemo.InputMessageBox.sendKeys(message);
        simpleFormDemo.ShowMessageButton.click();
        //String formattedMessage = String.format("%s was not displayed.",message);
        Assert.assertTrue(simpleFormDemo.MessageDisplay.getText().contains(message) );

    }
    @Test
    public void TwoInputFieldUnitTest()
    {
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        List<WebElement> twoInputLabelsElement = new ArrayList<>();
        twoInputLabelsElement.add(simpleFormDemo.EnterALabel);
        twoInputLabelsElement.add( simpleFormDemo.EnterBLabel);
        twoInputLabelsElement.add(simpleFormDemo.TotalLabel);

        List<String> twoInputLabelsString = new ArrayList<>();
        twoInputLabelsString.add("Enter a");
        twoInputLabelsString.add("Enter b");
        twoInputLabelsString.add("Total a + b =");
        VerifyElementList(twoInputLabelsElement, twoInputLabelsString);
        ImageCloseMethod("Input Forms");
        SumOfTwoNumbers(5, 6);
    }
    private void SumOfTwoNumbers(int a, int b)
    {
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);

        simpleFormDemo.InputA.sendKeys(Integer.toString(a));
        simpleFormDemo.InputB.sendKeys(Integer.toString(b));
        int sum = a + b;

        ClickWhenAble(simpleFormDemo.GetTotalButton, 10);
        Assert.assertTrue(" Sum of the two number values does not match the value displayed on the page.",
                Integer.toString(sum).equals(simpleFormDemo.DisplayValue.getText()));
    }

}
