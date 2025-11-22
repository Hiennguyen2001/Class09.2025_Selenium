package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends CommonBase {
    @BeforeTest
    public void openWebPage() {
        driver = initWebDriver(CT_PageURL.CRMSTAR_URL);
    }

    @Test
    public void logoutSuccessfully() {
        //login
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@gmail.com", "12345678");
        WebElement textQuanLyND = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));

        //Click Admin
        WebElement btnAdmin  = driver.findElement(By.id("dropdownMenuLink"));
        btnAdmin.click();

        //Click Đăng xuất
        WebElement btnDangXuat = driver.findElement(By.xpath("//button[contains(@class,'dropdown-item') and normalize-space(text())='Đăng xuất']"));
        btnDangXuat.click();

        //Click Xác nhận đăng xuất
        WebElement btnXacNhanDangXuat = driver.findElement(By.xpath("//button[contains(@class,'btn-success') and normalize-space()='Đăng xuất']"));
        btnXacNhanDangXuat.click();

        //Kiểm tra quay lại màn hình đăng nhập
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertTrue(textDangNhap.isDisplayed());

    }
}
