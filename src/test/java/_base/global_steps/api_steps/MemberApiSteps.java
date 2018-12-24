package _base.global_steps.api_steps;

import base.BaseSteps;
import cucumber.api.java.en.And;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.*;

public class MemberApiSteps extends BaseSteps {

    private static String commonEmail = Global.config.getString("member.account.mail");
    private static String commonPhone = Global.config.getString("member.registered_phone");
    private static String commonPass = Global.config.getString("member.account.pass");


    @And("^I login by api with email$")
    public void loginApiByEmail(){
        visit(Login_Page.class);
        on(Login_Page.class).loginApi(commonEmail,commonPass);
        Global.map.put("current_mail",commonEmail);
        Global.map.put("current_pass",commonPass);
        Global.browser.refresh();
    }

    @And("^I login by api with phone$")
    public void loginApiByPhone(){
        visit(Login_Page.class);
        on(Login_Page.class).loginApi(commonPhone,commonPass);
        Global.browser.refresh();
    }

    @And("^I sign up by api with email")
    public void signUpEmailByApi(){
        visit(SignUp_Page.class);
        String signupEmail = RandomHelper.randomTestMail();
        on(SignUp_Page.class).signUpApi(signupEmail,commonPass);
        Global.map.put("current_mail",signupEmail);
        Global.map.put("current_pass",commonPass);
        Global.browser.refresh();
    }

    @And("^I create a new member address by api")
    public void createAddressByApi(){
        visit(Account_Page.class);
        String mobilephoneTemplate = Global.config.getString("member.phone_number_template");
        String addressPhone = RandomHelper.randomPhoneNumber(mobilephoneTemplate);
        String addressName = Global.config.getString("member.account.name");
        on(Account_Page.class).createAddressByApi(Global.config.getConfig("member.address"),addressPhone,addressName);
        Global.browser.refresh();
    }
}