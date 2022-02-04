package Pages;

import Testbase.PageInitializer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageInitializer {

@FindBy (xpath="//img[@alt='Google']")
public WebElement googleLogo;

    @FindBy (xpath="(//input[@class='gNO89b'])[1]")
    public WebElement googleSearchBox;

@FindBy (xpath = "//input[@class='gLFyf gsfi']")
public WebElement googleSearchBar;

@FindBy (xpath = "(//input[@class = 'gNO89b'])[1]")
    public WebElement googleSearchBtn;

    //*************************GOOGLE RESULTS PAGE************************//

    @FindBy (partialLinkText = "Stack Overflow")
    public WebElement StackOverflowLink;




    public HomePage(){
        PageFactory.initElements(driver, this);
    }

}
