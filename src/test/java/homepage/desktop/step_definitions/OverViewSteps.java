package homepage.desktop.step_definitions;


import cucumber.api.java.en.And;
import base.BaseSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homepage.desktop.pages.Home_Page;
import homepage.desktop.pages.Landing_Page;
import org.testng.Assert;

public class OverViewSteps extends BaseSteps {

    @When("^I go to HomePage")
    public void landInHomePage() throws Throwable
    {
                visit(Home_Page.class);
    }

    @Then("^I click on log in to login page")
    public void landLoginPage()  {
        on(Home_Page.class).clickToLoginPage();
    }

    @And ("I click on Save More on App button")
    public void clickSaveMoreBtn () {
        on(Home_Page.class).clickToAppPopupBtn();
    }

    @Then("^I see pop up is display")
    public void popUpIsDisplay()  {
        Assert.assertTrue(on(Home_Page.class).verifyAppPopUp(),"Pop up can't display");

    }

    @And ("I click on App benefit text")
    public void clickAppBenefitTxt () {
        on(Home_Page.class).clickToAppLandingPage();
    }

    @Then("^I should land on App Page")
    public void vrifyAppLandingPage()  {
        on(Landing_Page.class).verifyAppLandingPage();
    }
}
