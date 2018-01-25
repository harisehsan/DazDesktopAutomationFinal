package pages.wishlist;

import browser.Browser;
import global.Global;
import model.ProductDetailInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Base_Page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Pdp_Page extends Base_Page {

    private static final String page_url = "https://pdp-p.lazada.sg/166912069.html";
    private Browser browser;

    @FindBy(css = ".wishlist-icon") private WebElement wishlist_element;
    @FindBy(css = ".wishlist-icon.active") private WebElement wishlistActive_element;
    @FindBy(css = ".pdp-Cart_Page-concern button") private WebElement addToCart_element;
    @FindBy(css = ".pdp-product-title") private WebElement productTitle_element;

    public static void visit(){
        Global.browser.goTo(page_url);
    }

    public Pdp_Page(){
        PageFactory.initElements(Global.browser.getWebDriver(), this);
        this.browser = Global.browser;
    }


    public ProductDetailInfo getProductInfo(){
        String productTitle = browser.textOf(productTitle_element);
        return new ProductDetailInfo(productTitle);
    }


    public void addToWishlist(){
        browser.waitUntilVisible(wishlist_element);
        browser.click(wishlist_element);
        browser.waitUntilVisible(wishlistActive_element);
    }


    public boolean has_message(String message){
        return true;
    }
}
