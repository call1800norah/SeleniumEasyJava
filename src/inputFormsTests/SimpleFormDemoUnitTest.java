package inputFormsTests;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import UnitTestBase.UnitTestBaseMethods;
import inputFormsPageFactory.SimpleFormDemo;

/**
 * Created by norah on 7/27/2021.
 */
public class SimpleFormDemoUnitTest extends UnitTestBaseMethods{
    SimpleFormDemo simpleFormDemo;

    @Test
    public void SingleInputFieldUnitTest(){
        simpleFormDemo = PageFactory.initElements(driver, SimpleFormDemo.class);
        


    }

}
