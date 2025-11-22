package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginTest extends CommonBase {
    @BeforeTest
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.CRMSTAR_URL);

    }
    @Test
    public void loginSuccessfully()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@gmail.com","12345678");
        WebElement textQuanLyND = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
        assertTrue(textQuanLyND.isDisplayed());
    }
    @Test
    public void loginFail_IncorrectPass()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@gmail.com","1234567890");
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertTrue(textDangNhap.isDisplayed());
    }
    @Test
    public void loginFail_IncorrectEmail()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("hien@gmail.com","12345678");
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertTrue(textDangNhap.isDisplayed());
    }
    @Test
    public void loginFail_IncorrectEmailAndPass()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("hien@gmail.com","12345678019");
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertTrue(textDangNhap.isDisplayed());
    }
}
