package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Day12_radio extends CommonBase {
    @Test
    public void clicktoRadio()
    {
        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
        // Kiểm tra giá trị mặc định is Selected = false
        WebElement maleRadio = driver.findElement(By.id("gender-radio-1"));
        WebElement feMaleRadio = driver.findElement(By.id("gender-radio-2"));
        WebElement otherRadio = driver.findElement(By.id("gender-radio-3"));
        boolean male = maleRadio.isSelected();
        //Mong đợi rằng male chưa được bấm = False
        assertFalse(male);
        //Mong đợi rằng male chưa được bấm = False
        assertFalse(feMaleRadio.isSelected());
        //Mong đợi rằng male chưa được bấm = False
        assertFalse(otherRadio.isSelected());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feMaleRadio);


        //Click Female
       // feMaleRadio.click();
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        assertTrue(feMaleRadio.isSelected());

    }
}
