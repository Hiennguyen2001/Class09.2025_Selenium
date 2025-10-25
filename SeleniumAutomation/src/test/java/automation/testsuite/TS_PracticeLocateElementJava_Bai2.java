package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TS_PracticeLocateElementJava_Bai2 extends CommonBase {
    @Test
    public void getElementById() {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);

        WebElement name = driver.findElement(By.id("name"));
        System.out.println("Name element: " + name);

        WebElement address = driver.findElement(By.id("address"));
        System.out.println("Address element: " + address);

        WebElement email = driver.findElement(By.id("email"));
        System.out.println("Email element: " + email);

        WebElement password = driver.findElement(By.id("password"));
        System.out.println("Password element: " + password);
    }
}
