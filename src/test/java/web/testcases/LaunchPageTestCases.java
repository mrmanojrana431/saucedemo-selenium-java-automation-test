package web.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import web.helper.LaunchHelper;
import web.pages.LaunchAndLoginPage;

class LaunchPageTestCases {
    private static WebDriver driver;
    private SoftAssert softAssert;

    @BeforeClass
    public void setupBrowser() {
        String browser = System.getProperty("browser", "chrome");
        driver = LaunchHelper.launchBrowser(browser);
        softAssert = new SoftAssert();
    }

    @Test
    public void verifyLaunchPage() {
        LaunchHelper.launchBaseUrl(driver);
        LaunchAndLoginPage launchAndLoginPage = new LaunchAndLoginPage();
        String urlText = launchAndLoginPage.getCurrentUrl(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(urlText.contains("saucedemo"), "Page URL verification failed");
        softAssert.assertTrue(launchAndLoginPage.isAppLogoDisplayed(driver), "App logo verification failed");
        softAssert.assertTrue(launchAndLoginPage.isLoginButtonDisplayed(driver), "Login button verification failed");
        softAssert.assertAll();
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        LaunchHelper.closeBrowser(driver);
    }
}
