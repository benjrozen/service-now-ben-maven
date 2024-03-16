@default-webdriver
Feature: Sign Up Company Email Don't Fill Name Fields

  Scenario: As a new user, having a company e-mail address, if I don't fill in first name and last name I shouldn't be able to sign up
    Given the user browsed to "https://www.vicarius.io/sign/up"
    And the user enters "${VALID_COMPANY_EMAIL}" to "cssSelector:[placeholder='Work e-mail']"
    And the user enters "Test" to "cssSelector:[placeholder='Company']"
    And clicks "cssSelector:[type='submit']"
    Then the user should see "xpath://*[contains(text(), 'Let’s try again...')]"

