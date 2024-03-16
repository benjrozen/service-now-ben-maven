@default-webdriver
Feature: Sign Up Company Email Don't Fill Company Field

  Scenario: As a new user, having a company e-mail address, if I don't fill in the company field, I shouldn't be able to sign up
    Given the user browsed to "https://www.vicarius.io/sign/up"
    And the user enters "Test" to "cssSelector:[placeholder='First Name']"
    And the user enters "Test" to "cssSelector:[placeholder='Last Name']"
    And the user enters "${VALID_COMPANY_EMAIL}" to "cssSelector:[placeholder='Work e-mail']"
    And clicks "cssSelector:[type='submit']"
    Then the user should see "xpath://*[contains(text(), 'Let’s try again...')]"

