package Pages;

import Testbase.PageInitializer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class StackoverflowPage extends PageInitializer {
    @FindBy(xpath = "//button[@class='flex--item s-btn s-btn__primary js-accept-cookies js-consent-banner-hide']")
    public WebElement cookieAccept;

    @FindBy(xpath = "//a[@class='left-sidebar-toggle p0 ai-center jc-center js-left-sidebar-toggle']")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//div[contains(text(),'Tags')]")
    public WebElement tagsInHamburgerMenu;

    @FindBy(xpath = "//h1[contains(text(),'Tags')]")
    public WebElement tagsDisplay;

    @FindBy(xpath = "//input[@id='tagfilter']")
    public WebElement filterSearchBar;

    @FindBy(linkText = "python-3.6")
    public WebElement python3;

    @FindBy(linkText = "Newest")
    public WebElement mostFrequent;

    @FindBy(xpath = "//button[@class='s-btn s-btn__muted s-btn__outlined s-btn__sm s-btn__dropdown']")
    public WebElement moreBtn;

    @FindBy(linkText = "Score")
    public WebElement scoreInMoreBtn;

    @FindBy(xpath = "//span[@class='vote-count-post ']")
    public List<WebElement> votes;

    @FindBy(id = "questions")
    public WebElement summaryBox;

    @FindBy(xpath = "//div[@class='user-details']/a")
    public WebElement authorName;

    public StackoverflowPage(){
        PageFactory.initElements(driver, this);
    }
}
