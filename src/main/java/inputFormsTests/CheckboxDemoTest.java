package inputFormsTests;

import testBase.TestBaseMethods;
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
    public void singleCheckboxDemo(){
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);
        imageCloseMethod("Checkbox Demo");

        singleCheckboxDemoMethod();

        checkboxDemo.singleCheckboxClick.click();
        Assert.assertEquals("Success - Check box is checked", checkboxDemo.checkboxCheckedMessage.getText());


    }
    public void singleCheckboxDemoMethod()
    {
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);
        List<WebElement> singleCheckboxHeaderAndMessageElement = new ArrayList<>();
        singleCheckboxHeaderAndMessageElement.add(checkboxDemo.singleCheckboxHeader);
        singleCheckboxHeaderAndMessageElement.add(checkboxDemo.singleCheckboxMessage);
        List<String> singleCheckboxHeaderAndMessageString = new ArrayList<>();
        singleCheckboxHeaderAndMessageString.add( "Single Checkbox Demo");
        singleCheckboxHeaderAndMessageString.add("Clicking on the checkbox will display a success message. Keep an eye on it");

        verifyElementList(singleCheckboxHeaderAndMessageElement, singleCheckboxHeaderAndMessageString);
    }
    @Test
    public void multiCheckboxDemo()
    {
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);

        //Method for closing Image popup
        imageCloseMethod("Checkbox Demo");
        multipleCheckboxDemoMethod();

        //Click Check All button to check all Options
        checkboxDemo.checkAllButton.click();
        Assert.assertTrue(checkboxDemo.uncheckAllButton.getAttribute("value").equals("Uncheck All"));
        //Click UnCheck All button to uncheck all Options
        checkboxDemo.uncheckAllButton.click();
        Assert.assertTrue(checkboxDemo.checkAllButton.getAttribute("value").equals("Check All"));

    }
    /// <summary>
    ///   Method for verifying if the collection of webelement text and the list of string displayed and texts are matching
    /// </summary>
    public void multipleCheckboxDemoMethod()
    {
        checkboxDemo = PageFactory.initElements(driver, CheckboxDemo.class);
        Assert.assertTrue("Assertion failed: Multicheckbox header returned as null!", checkboxDemo.multiCheckboxHeader.isDisplayed());
        Assert.assertTrue("Assertion failed: multiCheckboxMessage returned as null!!",checkboxDemo.multiCheckboxMessage.isDisplayed());
        List<String> checkboxOptionstring = new ArrayList<>();
        checkboxOptionstring.add("Option 1");
        checkboxOptionstring.add("Option 2");
        checkboxOptionstring.add("Option 3");
        checkboxOptionstring.add("Option 4");

        List<String> multiCheckboxMessagesString = new ArrayList<>();
        multiCheckboxMessagesString.add("Click on 'Check All' to check all checkboxes at once.");
        multiCheckboxMessagesString.add("When you check all the checkboxes, button will change to 'Uncheck All'");
        multiCheckboxMessagesString.add("When you uncheck at least one checkbox, button will change to 'Check All'");

        verifyElementList(checkboxDemo.checkboxOptions, checkboxOptionstring);
        verifyElementList(checkboxDemo.multiCheckboxMessages, multiCheckboxMessagesString);
    }


}
