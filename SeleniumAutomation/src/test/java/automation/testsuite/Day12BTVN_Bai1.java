package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day12BTVN_Bai1 extends CommonBase {
    @Test
    public void selectCountryDropdown()  {
        driver = initChromeDriver(CT_PageURL.GLOBALQA_URL);
        WebElement selectCountry = driver.findElement(By.xpath("//strong[contains(text(),'Select country')]/ancestor::div/following-sibling::p/select"));
        Select countryDropdown = new Select(selectCountry);
        // Chọn option
        countryDropdown.selectByVisibleText("Viet Nam");

    }

}
