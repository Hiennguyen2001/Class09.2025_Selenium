package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Day17_BTVN_iframe extends CommonBase {
    @BeforeMethod
    public void openMedimartURL()
    {
        driver = initWebDriver(CT_PageURL.MEDIAMART_URL);
    }
    @Test
    public void chatwithZalo() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      //  Thread.sleep(50000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("So luong iframe la:" + size);
        driver.switchTo().frame(0);
        // em chưa đóng được chatbot popup Media Mart

        click(By.xpath("//img[@src='/static/images/2.0/Logo.svg']")); // click vào icon zalo
        assertTrue(isDisplay_fluent(By.xpath("//p[text()='Bắt đầu trò chuyện với Siêu thị điện máy MediaMart']")));
    }
}
