package com.servicenow.ben.steps;

import com.google.inject.Inject;
import com.servicenow.ben.pageObjects.SignInPage;
import com.servicenow.ben.selenium.InputParser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SignInPageSteps {


    SignInPage signInPage;

    @Inject
    public SignInPageSteps(SignInPage signInPage) {
        this.signInPage = signInPage;
    }



    @And("enters {string} in work e-mail field")
    public void enterEmailToLoginField(String email) {
        signInPage.enterEmail(InputParser.parse(email));
    }

    @Then("the user should see instructions sent to email toast")
    public void theUserShouldSeeInstructionsSentToEmailToast()  {
        signInPage.signInToastAppeared();
    }
}
