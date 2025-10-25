package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TS_PracticeLocateElementjava_Bai1 extends CommonBase {
    @Test
    public void getElementById() {
        driver = initChromeDriver(CT_PageURL.SELECTORHUB_URL);

        WebElement user_email = driver.findElement(By.name("email"));
        System.out.println("User Email element: " + user_email);

//        WebElement user_email_id = driver.findElement(By.id("shub53")); ID thay đổi mỗi lần load
//        System.out.println("User Email Id element: " + user_email_id);

        WebElement password = driver.findElement(By.id("pass"));
        System.out.println("Password element is: " + password);

        WebElement mobile_number = driver.findElement(By.name("mobile number"));
        System.out.println("Mobile number element is " + mobile_number);
    }
    @Test
    public void getElementByClass_TagName()
    {
        driver = initChromeDriver(CT_PageURL.SELECTORHUB_URL);

        WebElement password = driver.findElement(By.className("selectors-input"));
        System.out.println("Password className element is " + password);

        WebElement company = driver.findElement(By.className("form-control"));
        System.out.println("Company element is " + company);
    }
}
