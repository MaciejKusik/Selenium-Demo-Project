package com.example.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super (driver);
    }

    @FindBy (id = "first-name")
    private WebElement firstNameInput;

    @FindBy (id = "last-name")
    private WebElement lastNameInput;

    @FindBy (id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy (id = "continue")
    private WebElement continueButton;

    @FindBy (className = "title")
    private WebElement checkoutTitle;

    @FindBy (className = "cart_item")
    List<WebElement> allItemsInOverview;

    @FindBy (id = "finish")
    private WebElement finishButton;

    @FindBy (className = "complete-header")
    private WebElement summaryText;

    public void fillPersonalData() {
        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Smith");
        postalCodeInput.sendKeys("11-111");
        continueButton.click();
    }

    public String getOverviewTitle() {
        return checkoutTitle.getText();
    }

    public List<WebElement> getAllProducts() {
        List<WebElement> allItems = new ArrayList<>();
        for (WebElement item: allItemsInOverview) {
            allItems.add(item);
        }
        return allItems;
    }

    public List<String> getAllProductsNames() {
        List<String> allNames = new ArrayList<>();
        for (WebElement name: getAllProducts()) {
            allNames.add(name.findElement(By.className("inventory_item_name")).getText());
        }
        return allNames;
    }

    public List<String> getAllProductsPrizes() {
        List<String> allPrizes = new ArrayList<>();
        for (WebElement prize: getAllProducts()) {
            allPrizes.add(prize.findElement(By.className("inventory_item_price")).getText());
        }
        return allPrizes;
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public String getSummaryText() {
        return summaryText.getText();
    }
}
