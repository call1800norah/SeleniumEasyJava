package UnitTestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by norah on 7/22/2021.
 */
public class UnitTestBaseFactory {
    @FindBy(xpath = "//div[@class='col-md-3 sidenav']//div[@class='panel-heading']")
    public WebElement MenuListHeader;

    @FindBy(xpath = "//ul[@id='treemenu']//a[@href='#' and text()='All Examples']")
    public WebElement AllExamplesNavBar;

    @FindBy(xpath = "//ul[@id='treemenu']//a[@href='#' and text()='Input Forms']")
    public  WebElement InputFormsNavBar;

    @FindBy(xpath = "//li[@class='tree-branch']//a[@href='#' and text()='Input Forms']//following::ul//li[@style='display: list-item;']/a")
    public List<WebElement> InputFormsItems;
}
