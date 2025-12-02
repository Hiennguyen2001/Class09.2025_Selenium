package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Day16_BTVN_Bai2 extends CommonBase {
    @BeforeMethod
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.seleniumpractise_URL);
    }
    @Test
    public void tryIt_Alert ()
    {
        click(By.xpath("//button[text()='Try it']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        assertEquals(actualMessage,"Welcome to Selenium WebDriver Tutorials");
    }
}
