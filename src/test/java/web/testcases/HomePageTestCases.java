package web.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.helper.LaunchHelper;
import web.pages.HomePage;
import web.pages.LaunchAndLoginPage;
import web.pages.ProductDetailsPage;

public class HomePageTestCases {
    private static WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setupBrowser() {
        String browser = System.getProperty("browser", "chrome");
        driver = LaunchHelper.launchBrowser(browser);
    }

    @Test
    public void BuyProductTestCases()
    {
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
        launchAndLoginPage.enterUsername(driver,"standard_user");
        launchAndLoginPage.enterPassword(driver,"secret_sauce");
        launchAndLoginPage.clickLoginButton(driver);
        HomePage homePage = new HomePage();
        softAssert.assertTrue(homePage.getProductTitle(driver).contains("Products"),"Product title verification failed");
        softAssert.assertTrue(homePage.getActiveOption(driver).contains("Name (A to Z)"),"Product title verification failed");
        softAssert.assertTrue(homePage.isSauceBackpackDisplayed(driver),"Product title verification failed");
        softAssert.assertAll();

        homePage.clickSauceBackpack(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Assert.assertTrue(productDetailsPage.isAddToCartButtonDisplayed(driver),"Add to cart button verification failed");
        productDetailsPage.clickAddToCartButton(driver);

        Assert.assertTrue(productDetailsPage.isCartOptionDisplayed(driver),"Cart option verification failed");
        productDetailsPage.clickCartOption(driver);

        Assert.assertTrue(productDetailsPage.isCheckoutButtonDisplayed(driver),"Checkout button verification failed");
        productDetailsPage.clickCheckoutButton(driver);

        Assert.assertTrue(productDetailsPage.isFirstNameFieldDisplayed(driver),"First name field verification failed");
        Assert.assertTrue(productDetailsPage.isLastNameFieldDisplayed(driver),"Last name field verification failed");
        Assert.assertTrue(productDetailsPage.isZipCodeFieldDisplayed(driver),"Zip code field verification failed");
        Assert.assertTrue(productDetailsPage.isContinueButtonDisplayed(driver),"Continue button verification failed");

        productDetailsPage.enterFirstName(driver,"Manoj");
        productDetailsPage.enterLastName(driver,"Rana");
        productDetailsPage.enterZipCode(driver,"12345");
        productDetailsPage.clickContinueButton(driver);

        Assert.assertEquals(productDetailsPage.getOverviewTitle(driver),"Checkout: Overview","Overview title verification failed");
        Assert.assertTrue(productDetailsPage.isFinishButtonDisplayed(driver),"Finish button verification failed");
        productDetailsPage.clickFinishButton(driver);

        Assert.assertEquals(productDetailsPage.getThankYouTitle(driver),"Thank you for your order!","Thank you title verification failed");

    }

    @AfterMethod
    public void closeBrowser() {
        LaunchHelper.closeBrowser(driver);
    }
}
