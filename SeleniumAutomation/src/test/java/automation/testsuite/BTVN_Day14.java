package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage_Factory;
import automation.pagelocator.Login_Factory_BTVNDay14;
import automation.pagelocator.LogoutPage_Factory;
import automation.pagelocator.Logout_Factory_BTVNDay14;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVN_Day14 extends CommonBase {
    @BeforeMethod
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.VIBLO_ASIS_URL);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void loginSucessfully()
    {
        Login_Factory_BTVNDay14 login = new Login_Factory_BTVNDay14(driver);
        login.LoginFunction("halanhien@gmail.com", "20012203");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Trang Chủ']")).isDisplayed());

    }
    @Test
    public void loginFail_IncorrectEmail()
    {
        Login_Factory_BTVNDay14 login = new Login_Factory_BTVNDay14(driver);
        login.LoginFunction("halanhien123@gmail.com", "22032001");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertTrue(driver.findElement(By.xpath("//div[@class='login-form']")).isDisplayed());

    }
    @Test
    public void logoutSucessfully(){
        loginSucessfully();
        Logout_Factory_BTVNDay14 logout = new Logout_Factory_BTVNDay14(driver);
        logout.LogoutFunction();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      //  assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Đăng nhập/Đăng ký']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//div[@class='login-form']")).isDisplayed());
    }
    @Test
    public void changePassword_Sucessfully()
    {
        loginSucessfully();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Login_Factory_BTVNDay14 login = new Login_Factory_BTVNDay14(driver);
        login.ChangePassword("22032001","22032001");
        assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Đổi mật khẩu']")).isDisplayed());

    }
    @Test
    public void loginSucessfully_ByNewPass()
    {
        Login_Factory_BTVNDay14 login = new Login_Factory_BTVNDay14(driver);
        login.LoginFunction("halanhien@gmail.com", "22032001");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Trang Chủ']")).isDisplayed());
    }
}
