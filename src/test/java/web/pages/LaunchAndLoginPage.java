package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaunchAndLoginPage {
    // Locators
    private final By appLogo = By.className("login_logo");
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    // Methods
    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public boolean isAppLogoDisplayed(WebDriver driver) {
        return driver.findElement(appLogo).isDisplayed();
    }

    public boolean isLoginButtonDisplayed(WebDriver driver) {
        return driver.findElement(loginButton).isDisplayed();
    }

    public boolean isUserNameDisplayed(WebDriver driver)
    {
        return  driver.findElement(usernameField).isDisplayed();
    }

    public  boolean isPasswordFieldDisplayed(WebDriver driver)
    {
        return driver.findElement(usernameField).isDisplayed();
    }

    public  void enterUsername(WebDriver driver,String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public  void enterPassword(WebDriver driver,String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public   void clickLoginButton(WebDriver driver) {
        driver.findElement(loginButton).click();
    }
}
