Feature: Smoke Tests from the final task

  Scenario Outline: BBC2 Part2 Test#1
    Given  User opens '<homePage>' BBC
    And User click button '<button>' navigation bar
    And Click button Football
    And Click button Scores and Fixtures
    And Select results for a day '<day>'
    And Search for a championship '<championship>'
    Then We determine that two teams '<team1>' and '<team2>' played with a score '<scoreTeam1>' : '<scoreTeam2>'
    And Click link '<team1>'
    And Checking '<team1>' and '<team2>' names and scores '<scoreTeam1>' : '<scoreTeam2>' at the center of the screen



    Examples:
      | homePage             | button | championship             | day    | team1               | team2           | scoreTeam1 | scoreTeam2 |
      | https://www.bbc.com/ | sport  | Champions League         | 15 FEB | Paris Saint Germain | Real Madrid     | 1          | 0          |
      | https://www.bbc.com/ | sport  | Irish Premiership        | 15 FEB | Crusaders           | Glenavon        | 0          | 0          |
      | https://www.bbc.com/ | sport  | Club World Cup           | 12 FEB | Chelsea             | Palmeiras       | 2          | 1          |
      | https://www.bbc.com/ | sport  | Portuguese Primeira Liga | 7 FEB  | Tondela             | Benfica         | 1          | 3          |
      | https://www.bbc.com/ | sport  | Turkish Super Lig        | 11 FEB | Altay               | Caykur Rizespor | 0          | 0          |