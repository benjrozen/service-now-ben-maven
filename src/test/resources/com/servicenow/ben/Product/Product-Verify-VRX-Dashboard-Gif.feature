Feature: Product Verify VRX Dashboard Gif

  Scenario: Any given user should be able to open the product page and view VRX dashboard gif
    Given a "CHROME" browser
    And the user browsed to "https://www.vicarius.io/product"
    Then the user should see the VRX dashboard gif
