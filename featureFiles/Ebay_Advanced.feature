Feature: Ebay Advanced Page scenario

  @P3
  Scenario: Advanced Search link
    Given I am on Ebay homepage
    When I click on Advanced link
    Then I navigate to Advanced search page

  @P4
  Scenario: Advanced search page
    Given I am on Ebay Advanced page
    When I advanced search an item
      | keyword   | exclude     | min | max |
      | iPhone 11 | refurbished | 300 | 400 |
