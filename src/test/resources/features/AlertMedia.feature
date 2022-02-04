Feature: Validation of the highest number of votes

  @Regression
  Scenario: Finding the author in Stackoverflow of the answer with the highest number of votes
    Given user is on Google home page
    When user types "stackoverflow" in google search bar
    And user  clicks on the link of the official stackoverflow
    And user clicks on the hamburger menu icon
    And user types "python" into the filter by tag search bar
    Then user selects the link for "python-3.6"
    And user sorts by the most frequent
    When user clicks the question with the highest number of votes
    Then user sees the author of the answer with the highest number of votes



