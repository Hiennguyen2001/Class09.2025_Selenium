package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage_Factory;
import automation.pagelocator.LogoutPage_Factory;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Day14_Test extends CommonBase {
    @BeforeMethod
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.CRMSTAR_URL);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void loginSucessfully()
    {
        LoginPage_Factory login = new LoginPage_Factory(driver);
        login.LoginFunction("admin@gmail.com", "12345678");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());

    }
    @Test
    public void logoutSucessfully(){
        loginSucessfully();
        LogoutPage_Factory logout = new LogoutPage_Factory(driver);
        logout.LogoutFunction();
        assertTrue(driver.findElement(By.id("login")).isDisplayed());
    }
}
