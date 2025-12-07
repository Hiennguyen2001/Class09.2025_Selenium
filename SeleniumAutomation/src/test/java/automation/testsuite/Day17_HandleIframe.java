package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.Day17_GuruPopup;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Day17_HandleIframe extends CommonBase {
    @BeforeMethod
    public void openCodestar2Page()
    {
        driver = initWebDriver(CT_PageURL.CODESTAR2_URL);
    }
    @Test
    public void dangkyTuvan_NotSuccessfully()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("So luong iframe la:" + size);
        scrollToElement(By.xpath("//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
        driver.switchTo().frame(0);
        type(By.id("name"),"Test name");
        type(By.id("phone_number"),"0982415852");
        type(By.id("email"),"testEmail@gmail.com");
        assertTrue(isDisplay_fluent(By.id("name")));
    }
    @Test
    public void followFacebook() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("So luong iframe la:" + size);
        scrollToElement(By.xpath("//p[text()='Về chúng tôi']"));
        driver.switchTo().frame(3);
        String firstWindow = driver.getWindowHandle();
        click(By.xpath("//a[text()='Follow Page']"));
        Set<String> windows = driver.getWindowHandles();
        for(String childWindow: windows)
        {
            if(!childWindow.equals(firstWindow))
            {
                driver.switchTo().window(childWindow);
             //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                Thread.sleep(100000);
                String actualURL = driver.getCurrentUrl();
                System.out.println(actualURL);
                assertTrue(actualURL.equals("https://www.facebook.com/CodeStarAcademy/?ref=embed_page"));

              //  https://www.facebook.com/101976181756213?ref=embed_page
                driver.close();
            }
        }
        driver.switchTo().window(firstWindow);

    }

}
