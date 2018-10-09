package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import java.util.List;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Account_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(css = "#container") private WebElement mainContainer_element;
    @FindBy(id = "lzd_current_logon_user_name") private WebElement name_of_user;


    public Account_Page(){ super();}

    public void untilLoaded(){
        waitUntilVisible(mainContainer_element);
    }

    public boolean hasName(String name) {
        return name_of_user.getText().equals(name);
    }
}
