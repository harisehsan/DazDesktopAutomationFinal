package step_definitions.msite.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Global;
import pages.msite.account.Member_AccountSetting_Msite_Page;
import pages.msite.account.Member_Loginemail_Msite_Page;
import step_definitions.BaseSteps;

public class MemberLoginEmailMsiteSteps extends BaseSteps {

    @Given("^I go to login by email on Msite")
    public void openLogin() throws Throwable {
        visit(Member_Loginemail_Msite_Page.class);
    }

    @And("^I input email info on Msite")
    public void inputEmail() throws Throwable {
        String email = Global.config.getString("member.account.mail");
        on(Member_Loginemail_Msite_Page.class).setInputEmail(email);

    }

    @And("^I input password info on Msite")
    public void inputPass() throws Throwable {
        String pass = Global.config.getString("member.account.pass");
        on(Member_Loginemail_Msite_Page.class).setInputPass(pass);

    }

    @And("^I click login button on Msite")
    public void clickLoginButton() throws Throwable {
        on(Member_Loginemail_Msite_Page.class).setClickLoginButton();

    }


    @And("^I go to setting page")
    public void settingOpen() throws Throwable {
        visit(Member_AccountSetting_Msite_Page.class);
    }

    @And("I click Logout button and choose OK button")
    public void logoutAction() throws Throwable {
        on(Member_AccountSetting_Msite_Page.class).setLogout();
        on(Member_AccountSetting_Msite_Page.class).setOkbutton();
    }


    @Then("^I should logout success")
    public void waitUntilVisible() throws Throwable {
        on(Member_Loginemail_Msite_Page.class).waitUnstillVisible();
    }


}
