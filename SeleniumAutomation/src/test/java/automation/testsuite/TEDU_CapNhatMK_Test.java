package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.TEDU_CapNhatMK_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TEDU_CapNhatMK_Test extends CommonBase {
    @BeforeMethod
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.TEDU_URL);
    }
    @Test
    public void loginSuccessfully()
    {
        TEDU_CapNhatMK_Page tedu = new TEDU_CapNhatMK_Page(driver);
        tedu.loginFunction("halanhien@gmail.com","12345678");
        WebElement avatar = driver.findElement(By.xpath("//a[@title='Tài khoản' and @data-toggle ='dropdown']"));
        assertTrue(avatar.isDisplayed());
    }
   @Test
    public void updatePasswordSuccessfully()
   {
       loginSuccessfully();
       TEDU_CapNhatMK_Page tedu = new TEDU_CapNhatMK_Page(driver);
       tedu.changePassword("12345678","123456789");
       assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());

   }
}
