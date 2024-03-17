Feature: Product VRX Patchless Protection Learn More

  Scenario: Any given user should be able to open the product page and learn more about VRX Patchless Protection
    Given a "CHROME" browser
    And the user browsed to "https://www.vicarius.io/product"
    When the user clicks learn more button in patchless protection section
    Then the url should contain "product/patchless-protection"

