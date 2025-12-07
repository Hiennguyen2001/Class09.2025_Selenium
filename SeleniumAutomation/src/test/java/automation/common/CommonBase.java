package automation.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
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

    //1. Exlicit wait
    public WebElement findElement_Ex( By locator)
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      return driver.findElement(locator);
    }

    // 2. Fluent wait
    public WebElement findElement_fluent(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)) // Maximum time to wait
                .pollingEvery(Duration.ofMillis(200)) // Interval between each poll
                .ignoring(java.util.NoSuchElementException.class);
        // Exceptions to ignore
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    // Wrap click method
    public void click(By locator) {
        WebElement element = findElement_fluent(locator);
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)) // Maximum time to wait
                .pollingEvery(Duration.ofMillis(200)) // Interval between each poll
                .ignoring(java.util.NoSuchElementException.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    //Wrap sendkey method
    public void type (By locator, String value)
    {
        WebElement element = findElement_Ex(locator);
        element.clear();
        element.sendKeys(value);
    }
    //click by Javascript
    public void clickByJS(By locator)
    {
        WebElement element = findElement_Ex(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }
    public boolean isDisplay_fluent (By locator)
    {
        try {
            WebElement element = findElement_fluent(locator);
            return element.isDisplayed(); // true
        }
        catch(NoSuchElementException ex1)
        {
            return false; //element is not displayed , error in findElement_Fluent
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    public void scrollToElement( By locator)
    {
        WebElement element = findElement_fluent(locator);
        JavascriptExecutor js = (JavascriptExecutor)  driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void closeDriver()
    {
        if(driver != null)
        driver.close();
    }


}


