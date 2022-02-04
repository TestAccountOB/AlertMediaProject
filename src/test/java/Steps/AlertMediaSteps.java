package Steps;

import Utils.CommonMethods;
import Utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AlertMediaSteps extends CommonMethods {
    public static int largestAmount = 0;


    @Given("user is on Google home page")
    public void user_is_on_home_page() {
        Assert.assertTrue(home.googleSearchBar.isDisplayed());
        System.out.println("Google search page is displayed");
    }

    @When("user types {string} in google search bar")
    public void user_types_in_google_search_bar(String stackoverflow) {
        sendText(home.googleSearchBar, stackoverflow);
        click(home.googleSearchBtn);
    }

    @When("user  clicks on the link of the official stackoverflow")
    public void user_clicks_on_the_link_of_the_official_stackoverflow() {
        Assert.assertTrue(home.StackOverflowLink.isDisplayed());
        if (home.StackOverflowLink.isDisplayed())
            click(home.StackOverflowLink);
    }

    @When("user clicks on the hamburger menu icon")
    public void user_clicks_on_the_hamburger_menu_icon() throws InterruptedException {
        if (stackoverflowPage.cookieAccept.isDisplayed()) {
            click(stackoverflowPage.cookieAccept);
        }
        Thread.sleep(1000);
        click(stackoverflowPage.hamburgerMenu);
        click(stackoverflowPage.tagsInHamburgerMenu);
        Assert.assertTrue(stackoverflowPage.tagsDisplay.isDisplayed());
    }

    @When("user types {string} into the filter by tag search bar")
    public void user_types_into_the_search_bar(String python) {
        sendText(stackoverflowPage.filterSearchBar, python);
    }

    @Then("user selects the link for {string}")
    public void user_selects_the_link_for_python(String input) {
        if (stackoverflowPage.python3.isDisplayed() && stackoverflowPage.python3.isEnabled()) {
            Assert.assertEquals(stackoverflowPage.python3.getText(), input);
            click(stackoverflowPage.python3);
        }

    }

    @Then("user sorts by the most frequent")
    public void user_sorts_by_the_most_frequent() {
        if (stackoverflowPage.mostFrequent.isDisplayed() && stackoverflowPage.mostFrequent.isEnabled()) {
            click(stackoverflowPage.mostFrequent);
            if (stackoverflowPage.moreBtn.isDisplayed() && stackoverflowPage.moreBtn.isEnabled()) {
                click(stackoverflowPage.moreBtn);
            }
            click(stackoverflowPage.scoreInMoreBtn);
        }
    }

    @When("user clicks the question with the highest number of votes")
    public void user_clicks_the_question_with_the_highest_number_of_votes() {
        List<Integer> list = new ArrayList<>();
        for (WebElement v : stackoverflowPage.votes) {
            String voteNumber = v.getText();
            Integer votesNumberActual = Integer.valueOf(voteNumber);
            list.add(votesNumberActual);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > largestAmount) {
                largestAmount = list.get(i);
                System.out.println(largestAmount);
            }
        }
    }

    @Then("user sees the author of the answer with the highest number of votes")
    public void user_sees_the_author_of_the_answer_with_the_highest_number_of_votes() throws InterruptedException {
        String largestAuthor = String.valueOf(largestAmount);
        Assert.assertTrue(stackoverflowPage.summaryBox.getText().contains(largestAuthor));
        if (stackoverflowPage.summaryBox.getText().contains(largestAuthor)) {
            drawRedBorder(stackoverflowPage.authorName);
            Thread.sleep(2000);
            System.out.println("The name of the author of the answer with the highest number of votes is " + stackoverflowPage.authorName.getText());
        }
        Assert.assertTrue(stackoverflowPage.summaryBox.getText().contains(largestAuthor));

    }
}
