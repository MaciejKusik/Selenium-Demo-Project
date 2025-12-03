package com.example.saucedemo.tests;

import com.example.saucedemo.pages.CartPage;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class CartTest extends BaseTest {
    @Test
    public void checkAllItemsInCart() {
        prepareCartState();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getAllItemsTitles().get(0), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getAllItemsTitles().get(1), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getAllItemsTitles().get(2), "Sauce Labs Fleece Jacket");
    }

    @Test
    public void removeFirstItemPlusCheckout() {
        prepareCartState();
        CartPage cartPage = new CartPage(driver);
        cartPage.getAllRemoveButtons().get(0).click();
        Assert.assertEquals(cartPage.getAllItemsTitles().get(0), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getAllItemsTitles().get(1), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(cartPage.getAllItems().size(), 2);
        cartPage.goToCheckout();
        Assert.assertEquals(cartPage.getCheckoutTitle(), "Checkout: Your Information");
    }
}
