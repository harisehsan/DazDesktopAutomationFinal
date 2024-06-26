@checkoutCOD @911
  Feature: Checkout with COD method

    @17847731 @checkout_regression @checkout_smoke @smoke
    Scenario: User (login by email and password) can checkout with COD successfully
      Given I login by api with email for checkout
      And I empty cart
      When I go to a test COD pdp page
      And I click on Add to cart button
      And I click Checkout button on Cart popup
      And I click Place Order button on Checkout Shipping page
      And I place order with COD payment method
      Then I should be on Checkout Success page

    @17847772 @checkout @checkout_smoke @smoke @no_lzd @no_id @no_my
    Scenario: Product exists on cart after user added successfully.
      Given I login by api with email for checkout
      When I go to a normal COD pdp page
      And I get the product title
      And I click on Add to cart button
      And I click Go To Cart button on Cart popup
      Then I should see the product title in the Cart



