package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccEdit_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile#/profile/edit";

    @FindBy(css = ".mod-input-name input")
    private WebElement editName_txtField;
    @FindBy(className = "mod-input-close-icon")
    private WebElement clearOldName_btn;
    @FindBy(css = ".next-btn-large")
    private WebElement saveChanges_btn;

    public void clearOldName(){
        waitUntilPageReady();
        waitUntilVisible(clearOldName_btn);
        this.clearOldName_btn.click();
    }

    public void editName(String newName) {
        waitUntilPageReady();
        waitUntilVisible(editName_txtField);
        this.editName_txtField.sendKeys(newName);
    }

    public void saveChangesBtn() {
        waitUntilPageReady();
        waitUntilVisible(saveChanges_btn);
        this.saveChanges_btn.click();
    }
}