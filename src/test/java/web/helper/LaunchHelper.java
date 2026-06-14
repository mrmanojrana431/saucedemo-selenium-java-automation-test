package web.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.HashMap;

public class LaunchHelper {
    private static final String BASE_URL = "https://www.saucedemo.com/";

    public static WebDriver launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-session-crashed-bubble");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


    public static WebDriver launchFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver launchBrowser(String browserName) {
        WebDriver driver;
        browserName = browserName.toLowerCase();
        if (browserName.equals("chrome")) {
            driver = launchChrome();
        } else if (browserName.equals("firefox")) {
            driver = launchFirefox();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        return driver;
    }

    public static void launchBaseUrl(WebDriver driver) {
        if (driver != null) {
            driver.navigate().to(BASE_URL);
        }
    }

    public static void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
