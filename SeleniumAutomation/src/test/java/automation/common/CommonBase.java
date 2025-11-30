package automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public class CommonBase {

    public WebDriver initWebDriver( String URL)
    {
        System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");

//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        FirefoxProfile firefoxProfile = new FirefoxProfile();
//
//// Disable save-login popup
//        firefoxProfile.setPreference("signon.rememberSignons", false);
//
//// Disable form autofill for passwords
//        firefoxProfile.setPreference("signon.autofillForms", false);
//
//// Disable Firefox password breach alerts
//        firefoxProfile.setPreference("signon.management.page.breach-alerts.enabled", false);
//
//        firefoxOptions.setProfile(firefoxProfile);
//
//        WebDriver driver = new FirefoxDriver(firefoxOptions);
        FirefoxDriver driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver driver;
    public WebDriver initChromeDriver( String URL)

    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();

        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false); // Disables the "save password" prompt
        chromePrefs.put("profile.password_manager_enabled", false); // Disables the password manager
        chromePrefs.put("profile.password_manager_leak_detection", false); // Disables the password leak detection warning
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(URL);

        return driver;
    }
    public void closeDriver()
    {
        if(driver != null)
        driver.close();
    }


}


