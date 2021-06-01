Feature: Ebay Home Page scenario

  @P1 @setCookies
  Scenario: Searching for iPhone11
    Given I am on Ebay homepage
    When Search for "iPhone 11"
    Then Validate that Save this search option is present

  @P2 @setCookies
  Scenario: Search Item in category
    Given I am on Ebay homepage
    When Search for 'Soap' in 'Baby' category

  @P5
  Scenario Outline: Ebay Home page links
    Given I am on Ebay homepage
    When I click on '<links>'
    Then I validate page navigate to '<url>' and title contains '<title>'

    Examples: 
      | links           | url                                                   | title       |
      | Health & Beauty | https://www.ebay.com/b/Health-Beauty/26395/bn_1865479 | Health      |
      | Fashion         | https://www.ebay.com/b/Fashion/bn_7000259856          | Fashion     |
      | Electronics     | https://www.ebay.com/b/Electronics/bn_7000259124      | Electronics |
