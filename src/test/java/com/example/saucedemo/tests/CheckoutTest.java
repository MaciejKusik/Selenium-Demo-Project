package com.example.saucedemo.tests;

import com.example.saucedemo.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CheckoutTest extends BaseTest {
    @Test
    public void FillDataAndFinishTransaction() {
        prepareCheckoutState();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillPersonalData();
        Assert.assertEquals(checkoutPage.getOverviewTitle(), "Checkout: Overview");
        Assert.assertEquals(checkoutPage.getAllProductsNames(), List.of("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"));
        Assert.assertEquals(checkoutPage.getAllProductsPrizes(), List.of("$29.99", "$15.99", "$49.99"));
        checkoutPage.clickFinishButton();
        Assert.assertEquals(checkoutPage.getSummaryText(), "Thank you for your order!");
    }
}
