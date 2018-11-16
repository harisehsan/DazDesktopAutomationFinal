package checkout.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pdp_Page extends PageObject {

    public static String page_url = "";
    @FindBy(css = ".pdp-button_theme_orange") private WebElement add_to_cart_btn;
    @FindBy(id = "myAccountTrigger") private WebElement myAccountmenu;
    @FindBy(css = ".pdp-product-title") private WebElement productTitle;
    @FindBy(id = "topActionSwitchLang") private WebElement changeLanguageMenu;
    @FindBy(css = ".lzd-switch-icon-en") private WebElement englishVersion;

    public static void setUrl(String url)
    {
        page_url = url;
    }

    public String getProductTitle(){
        return productTitle.getText();
    }

    public void setProductTitle(String title){
        Global.map.put("currentProductTitle", title);
    }

    public void clickAddToCartButton()
    {
        waitUntilVisible(myAccountmenu);
        waitUntilPageReady();
        waitUntilInvisibilityOf(By.cssSelector(".pdp-skeleton__variation-list-wrapper"));
        add_to_cart_btn.click();
    }

    public void switchToEnglish(){
        waitUntilPageReady();
        try{
            if (changeLanguageMenu.isDisplayed()) {
                changeLanguageMenu.click();
                englishVersion.click();
            }
        }catch (NoSuchElementException ex){
            System.out.println("Switch Language is not available");
        }

    }

}