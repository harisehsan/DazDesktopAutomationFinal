package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Signupemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(css = "div.signup-by-mobile-foot > div > button")
    private WebElement signupMail_btn;
    @FindBy(css = ".mod-input-name input")
    private WebElement name_txtField;
    @FindBy(css = ".mod-input-email input")
    private WebElement email_txtField;
    @FindBy(css = ".mod-input-password input")
    private WebElement password_txtField;
    @FindBy(className = "signup-by-email-btn")
    private WebElement signup_btn;

    public void signUpEmail() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("div.signup-by-mobile-foot > div > button"));
        this.signupMail_btn.click();
    }

    public void inputName(String name) {
        waitUntilPageReady();
        this.name_txtField.sendKeys(name);
    }

    public void inputEmail(String email) {
        waitUntilPageReady();
        this.email_txtField.sendKeys(email);
    }

    public void inputPassword(String pass) {
        waitUntilPageReady();
        this.password_txtField.sendKeys(pass);
    }

    public void signUpButton() {
        waitUntilPageReady();
        waitUntilClickable(By.className("signup-by-email-btn"));
        this.signup_btn.click();
    }

    public void signUpByEmail(String name, String email, String pass) {
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        this.name_txtField.sendKeys(name);
        this.email_txtField.sendKeys(email);
        this.password_txtField.sendKeys(pass);
    }
}