@default-webdriver
Feature: Sign In Existing User Correct Credentials

  Scenario: As an existing user, I should be able to login to system
    Given the user browsed to "https://www.vicarius.io/sign/in"
    And enters "${VALID_COMPANY_EMAIL}" in work e-mail field
    And clicks "cssSelector:[type='submit']"
    Then the user should see instructions sent to email toast

