package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailsPage {
    By addToCartButton = By.id("add-to-cart");
    By cartOption = By.cssSelector("[data-test='shopping-cart-link']");
    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By overviewTitle = By.xpath("//span[@data-test='title' and contains(text(), 'Overview')]");
    By finishButton = By.id("finish");
    By ThankYouTitle = By.xpath("//h2[contains(text(), 'Thank you for your order!')]");

    public  boolean isAddToCartButtonDisplayed(WebDriver driver) {
        return driver.findElement(addToCartButton).isDisplayed();
    }

    public void clickAddToCartButton(WebDriver driver) {
        driver.findElement(addToCartButton).click();
    }

    public boolean isCartOptionDisplayed(WebDriver driver) {
        return driver.findElement(cartOption).isDisplayed();
    }

    public void clickCartOption(WebDriver driver) {
        driver.findElement(cartOption).click();
    }

    public boolean isCheckoutButtonDisplayed(WebDriver driver) {
        return driver.findElement(checkoutButton).isDisplayed();
    }

    public void clickCheckoutButton(WebDriver driver) {
        driver.findElement(checkoutButton).click();
    }

    public boolean isFirstNameFieldDisplayed(WebDriver driver) {
        return driver.findElement(firstNameField).isDisplayed();
    }
    public void enterFirstName(WebDriver driver, String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public boolean isLastNameFieldDisplayed(WebDriver driver) {
        return driver.findElement(lastNameField).isDisplayed();
    }

    public  void enterLastName(WebDriver driver, String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public boolean isZipCodeFieldDisplayed(WebDriver driver) {
        return driver.findElement(zipCodeField).isDisplayed();
    }

    public void enterZipCode(WebDriver driver, String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public boolean isContinueButtonDisplayed(WebDriver driver) {
        return driver.findElement(continueButton).isDisplayed();
    }

    public void clickContinueButton(WebDriver driver) {
        driver.findElement(continueButton).click();
    }

    public String getOverviewTitle(WebDriver driver) {
        return driver.findElement(overviewTitle).getText();
    }

    public boolean isFinishButtonDisplayed(WebDriver driver) {
        return driver.findElement(finishButton).isDisplayed();
    }
    public void clickFinishButton(WebDriver driver) {
        driver.findElement(finishButton).click();
    }
    public String getThankYouTitle(WebDriver driver) {
        return driver.findElement(ThankYouTitle).getText();
    }
}
