package com.example.saucedemo.tests;

import com.example.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToPage("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToPage("invalid_user", "wrong_pass");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match any user in this service"));
    }
}
