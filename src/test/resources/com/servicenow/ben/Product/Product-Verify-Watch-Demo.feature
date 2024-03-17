Feature: Product Verify Watch Demo

  Scenario: Any given user should be able to open the product page and view the demo
    Given a "CHROME" browser
    And the user browsed to "https://www.vicarius.io/product"
    And clicks the watch demo button
    Then the demo video should open
