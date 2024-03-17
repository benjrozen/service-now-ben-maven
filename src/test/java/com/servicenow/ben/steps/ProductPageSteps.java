package com.servicenow.ben.steps;

import com.google.inject.Inject;
import com.servicenow.ben.pageObjects.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {

    ProductPage productPage;

    @Inject
    public ProductPageSteps(ProductPage productPage) {
        this.productPage = productPage;
    }

    @And("clicks the watch demo button")
    public void clickWatchDemoButton() {
        productPage.clickWatchDemoButton();
    }

    @Then("the demo video should open")
    public void theDemoVideoShouldOpen() {
        productPage.verifyDemoVideo();
    }

    @Then("the user should see the VRX dashboard gif")
    public void theUserShouldSeeTheVRXDashboardGif() {
        productPage.verifyVRXDashboardGif();
    }

    @When("the user clicks learn more button in patchless protection section")
    public void theUserClicksLearnMoreButtonInPatchlessProtectionSection() {
        productPage.clickLearnMoreButtonInPatchlessProtectionSection();
    }
}
