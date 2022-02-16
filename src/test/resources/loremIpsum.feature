Feature: Smoke Tests from the final task

  Scenario Outline: Part1: Test #1 level Loremipsum
    Given User opens '<homePage>' page
    And User click link Russian Language
    Then Verify the text of the first  element, which is the first paragraph, contains the word '<word>'

    Examples:
      | homePage                | word |
      | https://www.lipsum.com/ | рыба |

  Scenario Outline: Part1: Test #2 level Loremipsum
    Given User opens '<homePage>' page
    And User press “Generate Lorem Ipsum”
    Then Verify that the first paragraph starts with word '<word>'

    Examples:
      | homePage                | word                                                    |
      | https://www.lipsum.com/ | Lorem ipsum dolor sit amet, consectetur adipiscing elit |

  Scenario Outline: Part2: Test #3-a level Loremipsum check generate world
    Given User opens '<homePage>' page
    And User click on label '<label>' word
    And User input meaning '<meaning>' field
    And User press “Generate Lorem Ipsum”
    Then Verify the result has meaning '<meaning>'

    Examples:
      | homePage                | meaning | label |
      | https://www.lipsum.com/ | 10      | words |
      | https://www.lipsum.com/ | -1      | words |
      | https://www.lipsum.com/ | 0       | words |
      | https://www.lipsum.com/ | 5       | words |
      | https://www.lipsum.com/ | 20      | words |

  Scenario Outline: Part2: Test #3-b level Loremipsum check generate byte
    Given User opens '<homePage>' page
    And User click on label '<label>' word
    And User input meaning '<meaning>' field
    And User press “Generate Lorem Ipsum”
    Then Verify the result has meaning '<meaning>'

    Examples:
      | homePage                | meaning | label |
      | https://www.lipsum.com/ | 10      | bytes |
      | https://www.lipsum.com/ | 0       | bytes |
      | https://www.lipsum.com/ | 5       | bytes |
      | https://www.lipsum.com/ | 20      | bytes |

  Scenario Outline: Part2: Test #4 level Loremipsum verify visibility chexbox
    Given User opens '<homePage>' page
    And User click on checkbox start
    And User press “Generate Lorem Ipsum”
    Then Verify that result no longer starts with '<Lorem ipsum>'Lorem ipsum

    Examples:
      | homePage                | Lorem ipsum |
      | https://www.lipsum.com/ | Lorem ipsum |

  Scenario Outline: Part2: Test #5 level Loremipsum
  check that randomly generated text paragraphs contain the word "lorem"
  with probability of more than 40%
    Given User opens '<homePage>' page
    And User press “Generate Lorem Ipsum”
    Then Count the number of paragraphs containing the word - lorem
    And User opens '<homePage>' page
    Then Generate 10 times and count the average number of paragraphs containing the word - lorem and Checking the average

    Examples:
      | homePage                |
      | https://www.lipsum.com/ |

