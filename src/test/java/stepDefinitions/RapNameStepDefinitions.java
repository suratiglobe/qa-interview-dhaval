package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.RapNameSteps;
import io.cucumber.java.en.Given;

public class RapNameStepDefinitions {

    @Steps
    RapNameSteps rapNameSteps;

    @Given("^I am on (.*) homePage$")
    public void i_am_on_homePage(String pageName) {
        rapNameSteps.loadPage(pageName);
    }

    @Then("^I see Input Fields$")
    public void i_Should_See_Input_Fields() {
        rapNameSteps.verifyInputFields();
    }

    @When("^I enter my first name '(.*)'$")
    public void i_Enter_My_First_Name(String firstName) {
        rapNameSteps.enterFirstName(firstName);
    }

    @And("^I click (.*)$")
    public void i_Click_Button_or_link_Rap_page(String ctaName) {
        rapNameSteps.clickCTA(ctaName);
    }

    @Then("^I should see my Rap name$")
    public void i_Should_See_My_Rap_Name() {
        rapNameSteps.verifyRapNameTextDisplayed();
    }

    @When("^I unselect nick name$")
    public void i_Unselect_Nick_Name() {
        rapNameSteps.unSelectNickName();
    }

    @When("^I select nick name$")
    public void i_Select_Nick_Name() {
        rapNameSteps.selectNickName();
    }

    @Then("^I should see new Rap name prepended$")
    public void i_Should_See_New_RapName() {
        rapNameSteps.verifyNewRapNamePrepended();
    }

    @And("I enter my last initial '(.*)'$")
    public void i_Enter_My_Last_Initial(String lastInitial) {
        rapNameSteps.enterLastInitial(lastInitial);
    }

    @Then("^I should see error '(.*)'$")
    public void i_Should_See_Error(String errorText) {
        rapNameSteps.verifyErrorText(errorText);
    }
}
