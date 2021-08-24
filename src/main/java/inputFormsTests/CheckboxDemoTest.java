package inputFormsTests;

import TestBase.TestBaseMethods;
import inputFormsPageFactory.CheckboxDemo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by norah on 7/22/2021.
 */
public class CheckboxDemoTest extends TestBaseMethods {
    private CheckboxDemo checkboxDemo;

    @Test
    public void SingleCheckboxDemo(){
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);
        ImageCloseMethod("Checkbox Demo");

        SingleCheckboxDemoMethod();

        checkboxDemo.SingleCheckboxClick.click();
        Assert.assertEquals("Success - Check box is checked", checkboxDemo.CheckboxCheckedMessage.getText());


    }
    public void SingleCheckboxDemoMethod()
    {
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);
        List<WebElement> singleCheckboxHeaderAndMessageElement = new ArrayList<>();
        singleCheckboxHeaderAndMessageElement.add(checkboxDemo.SingleCheckboxHeader);
        singleCheckboxHeaderAndMessageElement.add(checkboxDemo.SingleCheckboxMessage);
        List<String> singleCheckboxHeaderAndMessageString = new ArrayList<>();
        singleCheckboxHeaderAndMessageString.add( "Single Checkbox Demo");
        singleCheckboxHeaderAndMessageString.add("Clicking on the checkbox will display a success message. Keep an eye on it");

        VerifyElementList(singleCheckboxHeaderAndMessageElement, singleCheckboxHeaderAndMessageString);
    }
    @Test
    public void MultiCheckboxDemo()
    {
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);

        //Method for closing Image popup
        ImageCloseMethod("Checkbox Demo");
        MultipleCheckboxDemoMethod();

        //Click Check All button to check all Options
        checkboxDemo.CheckAllButton.click();
        Assert.assertTrue(checkboxDemo.UnCheckAllButton.getAttribute("value").equals("Uncheck All"));
        //Click UnCheck All button to uncheck all Options
        checkboxDemo.UnCheckAllButton.click();
        Assert.assertTrue(checkboxDemo.CheckAllButton.getAttribute("value").equals("Check All"));

    }
    /// <summary>
    ///   Method for verifying if the collection of webelement text and the list of string displayed and texts are matching
    /// </summary>
    public void MultipleCheckboxDemoMethod()
    {
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);
        Assert.assertTrue("Assertion failed: Multicheckbox header returned as null!", checkboxDemo.MultiCheckboxHeader.isDisplayed());
        Assert.assertTrue("Assertion failed: MulticheckboxMessage returned as null!!",checkboxDemo.MultiCheckboxMessage.isDisplayed());
        List<String> checkboxOptionString = new ArrayList<>();
        checkboxOptionString.add("Option 1");
        checkboxOptionString.add("Option 2");
        checkboxOptionString.add("Option 3");
        checkboxOptionString.add("Option 4");

        List<String> multiCheckboxMessagesString = new ArrayList<>();
        multiCheckboxMessagesString.add("Click on 'Check All' to check all checkboxes at once.");
        multiCheckboxMessagesString.add("When you check all the checkboxes, button will change to 'Uncheck All'");
        multiCheckboxMessagesString.add("When you uncheck at least one checkbox, button will change to 'Check All'");

        VerifyElementList(checkboxDemo.CheckboxOptions, checkboxOptionString);
        VerifyElementList(checkboxDemo.MultiCheckboxMessages, multiCheckboxMessagesString);
    }


}
