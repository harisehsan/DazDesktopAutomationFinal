package old_module.desktop.step_definitions.desktop.wishlist;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import model.ProductDetailInfo;
import org.testng.Assert;
import old_module.desktop.pages.desktop.wishlist.Wishlist_Page;
import global.Global;
import base.BaseSteps;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class AddSteps extends BaseSteps{

    @Given("^I go to wishlist page")
    public void goToWishlistPage() throws Throwable {
        visit(Wishlist_Page.class);
    }

    @Given("^I add all product to cart")
    public void addAllProductToCart() throws Throwable {
        on(Wishlist_Page.class).addAllToCart();
    }

    @Then("^I should see item displayed in Wishlist$")
    public void hasItem() throws Throwable {
        boolean result = on(Wishlist_Page.class).hasItem((ProductDetailInfo)Global.getMap().get("current_info"));
        Assert.assertTrue(result,"Wishlist item is not match PDP item");
    }


}
