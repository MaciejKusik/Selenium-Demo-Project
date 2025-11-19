package com.example.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "cart_item")
    List<WebElement> allItems;

    @FindBy (className = "checkout_button")
    private WebElement checkoutButton;

    @FindBy (className = "title")
    private WebElement checkoutTitle;

    public List<WebElement> getAllItems() {
        List<WebElement> allItemsInCart = new ArrayList<>();
        for (WebElement item : allItems) {
            allItemsInCart.add(item);
        }
        return allItemsInCart;
    }

    public List<String> getAllItemsTitles() {
        List<String> allNames = new ArrayList<>();
        for (WebElement name: getAllItems()) {
            allNames.add(name.findElement(By.className("inventory_item_name")).getText());
        }
        return allNames;
    }

    public List<WebElement> getAllRemoveButtons() {
        List<WebElement> allRemoveButtons = new ArrayList<>();
        for (WebElement removeButton: getAllItems()) {
            allRemoveButtons.add(removeButton.findElement(By.className("cart_button")));
        }
        return allRemoveButtons;
    }

    public void goToCheckout() {
        checkoutButton.click();
    }

    public String getCheckoutTitle() {
        return checkoutTitle.getText();
    }
}
