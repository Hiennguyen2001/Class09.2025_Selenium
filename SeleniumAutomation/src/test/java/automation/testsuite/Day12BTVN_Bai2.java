package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Day12BTVN_Bai2 extends CommonBase {
    @Test
    public void clickRadioButton()  {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement under18Radio = driver.findElement(By.id("under_18"));
        WebElement over18Radio = driver.findElement(By.id("over_18"));
        WebElement disableRadio = driver.findElement(By.id("radio-disabled"));

        //Click Under 18
        under18Radio.click();
        assertTrue(under18Radio.isSelected());

        //Click 18 or older
        over18Radio.click();
        assertTrue(over18Radio.isSelected());

        //Radio disable
        assertFalse(disableRadio.isEnabled());
    }
}
