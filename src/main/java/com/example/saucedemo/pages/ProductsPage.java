package com.example.saucedemo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy (className = "inventory_item")
    private List<WebElement> products;

    @FindBy (className = "shopping_cart_badge")
    private WebElement numberOfItemsInCart;

    @FindBy (className = "product_sort_container")
    private WebElement sortDropdown;

    public void addItemsToCart(String... names) {
        List<String> namesList = List.of(names);

        for(WebElement product : products) {
            String name = product.findElement(By.className("inventory_item_name")).getText();
            if (namesList.contains(name)) {
                product.findElement(By.cssSelector("button[class*='btn_primary']")).click();
            }
        }
    }

    public void removeItemsFromCart(String... names) {
        List<String> namesList = List.of(names);

        for(WebElement product : products) {
            String name = product.findElement(By.className("inventory_item_name")).getText();
            if (namesList.contains(name)) {
                product.findElement(By.cssSelector("button[class*='btn_secondary']")).click();
            }
        }
    }

    public int checkNumberOfItemsInCart() {
        String text = numberOfItemsInCart.getText();
        return Integer.parseInt(text);
    }

    public void goToCart() {
        cartIcon.click();
    }

    public void selectFromDropdown(String visibleText) {
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText(visibleText);
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for(WebElement product : products) {
          String name = product.findElement(By.className("inventory_item_name")).getText();
          names.add(name);
        }
        return names;
    }



    public List<Double> getPrices() {
        List<Double> prices = new ArrayList<>();
        for(WebElement product : products) {
            String textPrice = product.findElement(By.className("inventory_item_price")).getText();
            prices.add(Double.parseDouble(textPrice.replace("$", "")));
        }
        return prices;
    }
}
