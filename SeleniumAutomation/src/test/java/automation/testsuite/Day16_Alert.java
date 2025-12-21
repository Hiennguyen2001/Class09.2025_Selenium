package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Day16_Alert extends CommonBase {
    @BeforeMethod
  //  @Parameters("brower")
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.DELETE_CUST_URL);
    }
    @Test
    public void deleteCustSuccessfully()
    {
        type(By.name("cusid"),"123");
        click(By.name("submit"));
        driver.switchTo().alert().accept();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        assertEquals(actualMessage,"Customer Successfully Delete!");
        driver.switchTo().alert().accept();


    }
}
