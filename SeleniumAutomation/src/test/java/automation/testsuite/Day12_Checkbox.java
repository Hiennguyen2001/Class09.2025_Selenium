package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import  org.testng.*;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Day12_Checkbox extends CommonBase {
    @Test
    public void checkboxHandle(){
        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
        // Case 1: kiểm tra yêu cầu mặc định theo yêu cầu, VD: vào trang web thì checkox chưa đc check
        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
        //Mong đơị cả 3 checkbox đều chưa check
        boolean checkSport =  sportCheckbox.isSelected();
        boolean checkRead =  sportCheckbox.isSelected();
        boolean checkMusic =  sportCheckbox.isSelected();

        assertFalse(checkSport);
        assertFalse(checkRead);
        assertFalse(checkMusic);

    }
    @Test
    public void clickToCheckbox()
    {
        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
//        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
//        WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
//        WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
//
//        if (sportCheckbox.isSelected()==false)
//        {
//            sportCheckbox.click();
//            assertTrue(sportCheckbox.isSelected());
//        }
//        if (musicCheckbox.isSelected()==false)
//        {
//            musicCheckbox.click();
//            assertTrue(musicCheckbox.isSelected());
//        }
//        if (readCheckbox.isSelected()==false)
//        {
//            readCheckbox.click();
//            assertTrue(readCheckbox.isSelected());
//        }
        List<WebElement> listCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling:label"));
        for(WebElement webElement : listCheckbox)
        {
            if(webElement.isSelected() == false)
            {
                webElement.click();
                assertFalse(webElement.isSelected());
            }
        }
    }

    }


