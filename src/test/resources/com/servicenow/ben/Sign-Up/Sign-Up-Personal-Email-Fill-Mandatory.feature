@default-webdriver
Feature: Sign Up Personal Email Fill Mandatory

  Scenario: As a new user, having a personal e-mail address, I should not be able to sign up
    Given the user browsed to "https://www.vicarius.io/sign/up"

    And the user enters "Test" to "cssSelector:[placeholder='First Name']"
    And the user enters "Test" to "cssSelector:[placeholder='Last Name']"
    And the user enters "${PERSONAL_EMAIL}" to "cssSelector:[placeholder='Work e-mail']"
    And the user enters "Test" to "cssSelector:[placeholder='Company']"
    And clicks "cssSelector:[type='submit']"
    Then the user should see "xpath://*[contains(text(), 'Let’s try again...')]"


