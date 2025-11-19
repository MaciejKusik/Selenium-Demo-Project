package com.example.saucedemo.tests;

import com.example.saucedemo.pages.LoginPage;
import com.example.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void AddAndRemoveSomeItems() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToPage("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemsToCart("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie");
        int numberAdding = productsPage.checkNumberOfItemsInCart();
        Assert.assertEquals(numberAdding, 4);
        productsPage.removeItemsFromCart("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt");
        int numberRemoving = productsPage.checkNumberOfItemsInCart();
        Assert.assertEquals(numberRemoving, 2);
    }

    @Test
    public void SortingPricesLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToPage("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectFromDropdown("Price (low to high)");
        List<Double> prices = productsPage.getPrices();
        for(int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) <= prices.get(i + 1), "Prices are not sorted correct at index: " + i);
        }
    }

    @Test
    public void SortingNamesAToZ() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToPage("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectFromDropdown("Name (A to Z)");
        List<String> names = productsPage.getNames();
        for(int i = 0; i < names.size() - 1 ; i++ ) {
            Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) < 0, "This is not sorted alphabetically at index: " + i);
       }
    }
}
