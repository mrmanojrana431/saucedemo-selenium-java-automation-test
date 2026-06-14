package web.testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import web.helper.LaunchHelper;
import web.pages.HomePage;
import web.pages.LaunchAndLoginPage;
import java.awt.*;

class LoginTestCases {
    private WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            { "standard_user", "secret_sauce"},
            { "problem_user","secret_sauce"},
            { "performance_glitch_user","secret_sauce"},
            { "error_user","secret_sauce"},
            { "visual_user","secret_sauce"}
        };
    }

    @BeforeMethod
    public void setupBrowser() {
        String browser = System.getProperty("browser", "chrome");
        driver = LaunchHelper.launchBrowser(browser);
    }

    @Test(dataProvider = "loginData")
    public void testLoginWithValidUsers(String username, String password) throws Exception {
        LaunchHelper.launchBaseUrl(driver);
        LaunchAndLoginPage launchAndLoginPage = new LaunchAndLoginPage();
        String urlText = launchAndLoginPage.getCurrentUrl(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(urlText.contains("saucedemo"), "Page URL verification failed");
        softAssert.assertTrue(launchAndLoginPage.isAppLogoDisplayed(driver), "App logo verification failed");
        softAssert.assertAll();
        Assert.assertTrue(launchAndLoginPage.isLoginButtonDisplayed(driver), "Login button verification failed");
        Assert.assertTrue(launchAndLoginPage.isUserNameDisplayed(driver), "Username verification failed");
        Assert.assertTrue(launchAndLoginPage.isPasswordFieldDisplayed(driver), "Password verification failed");
        launchAndLoginPage.enterUsername(driver,username);
        launchAndLoginPage.enterPassword(driver,password);
        launchAndLoginPage.clickLoginButton(driver);
        Thread.sleep(2000);
        HomePage homePage = new HomePage();
        softAssert.assertTrue(homePage.getProductTitle(driver).contains("Products"),"Product title verification failed");
        softAssert.assertTrue(homePage.getActiveOption(driver).contains("Name (A to Z)"),"Product title verification failed");
        softAssert.assertAll();

    }

    @AfterMethod
    public void closeBrowser() {
        LaunchHelper.closeBrowser(driver);
    }

    public static void dismissAlertAppleScript(WebDriver driver) throws Exception {
        try {
            Thread.sleep(500);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(200);
            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("No password manager popup detected");
        }

    }
}
