package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Day16_BTVN_Bai1 extends CommonBase {
    @BeforeMethod
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.CRMSTAR_URL);
    }
    @Test
    public void Login_Successfully()
    {
        type(By.id("email"),"admin@gmail.com");
        type(By.id("password"),"12345678");
        click(By.name("signin"));
        driver.switchTo().alert().accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quanlyND = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Quản lý người dùng']")));
        assertTrue(quanlyND.isDisplayed());
    }
    @Test
    public void add_KLV()
    {
        Login_Successfully();
        click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
        click(By.xpath("//button[text()='Thêm mới']"));
        type(By.name("work_areas_code"),"KV22");
        type(By.name("name"),"KVLV thứ 22");
        click(By.xpath("//button[@onclick='submit_new_workarea()']")); // em nhấn lưu không được
    }





}
