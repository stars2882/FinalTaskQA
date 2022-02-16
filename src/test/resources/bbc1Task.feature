Feature: Smoke Tests from the final task

  Scenario Outline: BBC1 Part1 Test#1

    Given User opens '<homePage>' BBC
    And User click button '<button>' navigation bar
    Then Checks the name of the headline article in condition '<condition>'


    Examples:
      | homePage             | button | condition                                        |
      | https://www.bbc.com/ | news   | Nadal makes history with 21st Grand Slam victory |

  Scenario Outline: BBC1 Part1 Test#2
    Given  User opens '<homePage>' BBC
    And User click button '<button>' navigation bar
    And Checks secondary article titles

    Examples:
      | homePage             | button |
      | https://www.bbc.com/ | news   |

  Scenario Outline: BBC1 Part1 Test#3
    Given  User opens '<homePage>' BBC
    And User click button '<button>' navigation bar
    And Stores the text of the Category link of the headline '<headLine>' article
    And Enter this text in the Search bar
    Then Checking the name '<checkNameArticle>' of the first article against a specified value

    Examples:
      | homePage             | button | headLine | checkNameArticle |
      | https://www.bbc.com/ | news   | world    | World            |

  Scenario Outline: BBC1 Part2 Test#1
    Given  User opens '<homePage>' BBC
    And User click button '<button>' navigation bar
    And Click button subtitle '<subtitle>'
    And Click tab Your Coronavirus Stories
    And Click link Your questions answered: What questions do you have?
    And Scrolling to form ask your question
    And Input fields form question '<name>' and  '<email>' and '<phone>' and '<location>' and '<age>'
    And Click button Submit
    Then Checking the form submission for an error

    Examples:
      | homePage             | button | subtitle    | name | email   | phone  | location | age    |
      | https://www.bbc.com/ | news   | coronavirus | Boss |         | null   | 1212     | second |
#      | https://www.bbc.com/ | news   | coronavirus |      | 1@1.com | number | Moon     | 2022   |
