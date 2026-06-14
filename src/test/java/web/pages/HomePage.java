package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //locators
    By productTitle = By.cssSelector("[data-test='title']");
    By activeOption = By.cssSelector("[data-test='active-option']");
    By sauceBackPack = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Backpack')]");
    By sauceBikeLight = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Bike Light')]");
    By sauceBoltTShirt = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Bolt T-Shirt')]");
    By sauceFleeceJacket = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Fleece Jacket')]");
    By sauceOnesie = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Onesie')]");
    By sauceTShirt = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs T-Shirt')]");

    //methods
    public String getProductTitle(WebDriver driver) {
        return driver.findElement(productTitle).getText();
    }
    public String getActiveOption(WebDriver driver) {
        return driver.findElement(activeOption).getText();
    }
    public boolean isSauceBackpackDisplayed(WebDriver driver) {
        return driver.findElement(sauceBackPack).isDisplayed();
    }
    public void clickSauceBackpack(WebDriver driver) {
        driver.findElement(sauceBackPack).click();
    }
}
