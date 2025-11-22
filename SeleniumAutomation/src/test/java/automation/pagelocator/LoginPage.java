package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void LoginFunction (String email, String pass)
    {
        WebElement textEmail = driver.findElement(By.id("email"));
        if(textEmail.isDisplayed() == true)
        {
            textEmail.sendKeys(email);
        }
        WebElement textPass = driver.findElement(By.id("password"));
        if(textPass.isDisplayed() == true)
        {
            textPass.sendKeys(pass);
        }
        driver.findElement(By.name("signin")).click();
        //Accept alert (if exist)
       driver.switchTo().alert().accept();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
