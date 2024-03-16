@default-webdriver
Feature: Sign Up Company Email Fill Mandatory

  Scenario: As a new user, having a company e-mail address, I should be able to sign up
    Given the user browsed to "https://www.vicarius.io/sign/up"
    And the user enters "Test" to "cssSelector:[placeholder='First Name']"
    And the user enters "Test" to "cssSelector:[placeholder='Last Name']"
    And the user enters "${VALID_COMPANY_EMAIL}" to "cssSelector:[placeholder='Work e-mail']"
    And the user enters "Test" to "cssSelector:[placeholder='Company']"
    And clicks "cssSelector:[type='submit']"
    When the user sees "cssSelector:[placeholder='Password']"
    And the user enters "${COMPANY_PASSWORD}" to "cssSelector:[placeholder='Password']"
    And the user enters "${COMPANY_PASSWORD}" to "cssSelector:[placeholder='Confirm Password']"
    And clicks "cssSelector:[type='submit']"
    Then the user should see "xpath://h2/*[contains(text(), 'Hooray!')]"

