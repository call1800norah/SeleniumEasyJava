package TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by norah on 7/22/2021.
 */
public class TestBaseFactory {
    @FindBy(xpath = "//div[@class='col-md-3 sidenav']//div[@class='panel-heading']")
    public WebElement menuListHeader;

    @FindBy(xpath = "//ul[@id='treemenu']//a[@href='#' and text()='All Examples']")
    public WebElement allExamplesNavBar;

    @FindBy(xpath = "//ul[@id='treemenu']//a[@href='#' and text()='Input Forms']")
    public  WebElement inputFormsNavBar;

    @FindBy(xpath = "//li[@class='tree-branch']//a[@href='#' and text()='Input Forms']//following::ul//li[@style='display: list-item;']/a")
    public List<WebElement> inputFormsItems;
}
