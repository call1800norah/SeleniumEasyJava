package inputFormsTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseMethods;
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
    public void singleInputFieldUnitTest(){
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        List<WebElement> labelsElementList = new ArrayList<>();
        labelsElementList.add( simpleFormDemo.enterMessageLabel);
        labelsElementList.add(simpleFormDemo.yourMessageLabel);

        List<String> labelListString = new ArrayList<>();
        labelListString.add("Enter message");
        labelListString.add("Your Message:");

        //Method for closing Image popup
        imageCloseMethod("Input Forms");

        //Verify message headers and texts displayed
        verifyElementList(labelsElementList, labelListString);



        inputMesssage("Hello Selenium");


    }
    private void inputMesssage(String message)
    {
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        simpleFormDemo.inputMessageBox.sendKeys(message);
        simpleFormDemo.showMessageButton.click();
        //String formattedMessage = String.format("%s was not displayed.",message);
        Assert.assertTrue(simpleFormDemo.messageDisplay.getText().contains(message) );

    }
    @Test
    public void twoInputFieldUnitTest()
    {
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        List<WebElement> twoInputLabelsElement = new ArrayList<>();
        twoInputLabelsElement.add(simpleFormDemo.enterALabel);
        twoInputLabelsElement.add( simpleFormDemo.enterBLabel);
        twoInputLabelsElement.add(simpleFormDemo.totalLabel);

        List<String> twoInputLabelsString = new ArrayList<>();
        twoInputLabelsString.add("Enter a");
        twoInputLabelsString.add("Enter b");
        twoInputLabelsString.add("Total a + b =");
        verifyElementList(twoInputLabelsElement, twoInputLabelsString);
        imageCloseMethod("Input Forms");
        sumOfTwoNumbers(5, 6);
    }
    private void sumOfTwoNumbers(int a, int b)
    {
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);

        simpleFormDemo.inputA.sendKeys(Integer.toString(a));
        simpleFormDemo.inputB.sendKeys(Integer.toString(b));
        int sum = a + b;

        clickWhenAble(simpleFormDemo.getTotalButton, 10);
        Assert.assertTrue(" Sum of the two number values does not match the value displayed on the page.",
                Integer.toString(sum).equals(simpleFormDemo.displayValue.getText()));
    }

}
