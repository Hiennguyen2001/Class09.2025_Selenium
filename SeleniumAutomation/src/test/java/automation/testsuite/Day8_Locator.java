package automation.testsuite;

import automation.common.CommonBase; // import class cha vì không cùng package
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.constant.CT_PageURL;

public class Day8_Locator extends CommonBase {
    @Test
    public void getElementById()
    {
       driver =  initChromeDriver(CT_PageURL.RISE_URL);
       WebElement email = driver.findElement(By.id("email"));
        System.out.println("Email element: " + email);

        WebElement password = driver.findElement(By.id("password"));
        System.out.println("Password element is: " + password);
    }
    @Test

    public void getElementByLinkText()
    {
        driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
        WebElement mayHutMuiLink = driver.findElement(By.linkText("Máy Hút Mùi"));
        System.out.println("MayHutMuiLink element is: " + mayHutMuiLink);

        WebElement chauVoiLink = driver.findElement((By.partialLinkText("Chậu Vòi")));
        System.out.println("ChauVoiLink element is: " + chauVoiLink);
    }
    @Test
    public void getElementBllyClass_TagName(){
        driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
        WebElement h1 = driver.findElement(By.className("inline-block"));
        System.out.println("h1 is " + h1);

        WebElement h3 = driver.findElement(By.tagName("h3"));
        System.out.println("h3 is " + h3);
    }
}
