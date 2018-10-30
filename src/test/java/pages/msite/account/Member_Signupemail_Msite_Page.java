package pages.msite.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_Signupemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/register";

    @FindBy(css = ".signup-by-mobile-foot-btn") private WebElement signupemail;
    @FindBy(css = ".mod-input-name input") private WebElement inputname;
    @FindBy(css = ".mod-input-email input") private WebElement inputemail;
    @FindBy(css = ".mod-input-password input") private WebElement inputpassword;
    @FindBy(className = "signup-by-email-btn") private WebElement signupbutton;


    public void setSignupemail(){
        waitUntilPageReady();
        this.signupemail.click();
    }

    public void setInputname(String n){
        waitUntilPageReady();
        this.inputname.sendKeys(n);
    }

    public void setInputemail(String e) {
        waitUntilPageReady();
        this.inputemail.sendKeys(e);
    }

    public void setInputpassword(String p){
        waitUntilPageReady();
        this.inputpassword.sendKeys(p);
    }

    public void setSignupbutton() {
        waitUntilPageReady();
        this.signupbutton.click();
    }

}