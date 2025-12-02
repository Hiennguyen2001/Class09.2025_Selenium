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

public class Day16_BTVN_bai3 extends CommonBase {
    @BeforeMethod
    public void openWebPage()
    {
        driver = initWebDriver(CT_PageURL.automationtesting_URL);
    }
    @Test
    public void alert_withOK()
    {
        click(By.xpath("//button[contains(@class, 'btn-danger')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        assertEquals(actualMessage,"I am an alert box!");
    }
    @Test
    public void alert_withOKandCancel()
    {
        click(By.xpath("//a[@href='#CancelTab']"));
        click(By.xpath("//button[text()='click the button to display a confirm box ']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        assertEquals(actualMessage,"Press a Button !");
    }

    @Test
    public void alert_withTextbox()
    {

        click(By.xpath("//a[@href='#Textbox']"));
        click(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
       // type("");

    }
}
