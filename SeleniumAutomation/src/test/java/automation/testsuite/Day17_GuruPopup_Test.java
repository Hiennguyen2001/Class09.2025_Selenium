package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.Day17_GuruPopup;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Day17_GuruPopup_Test extends CommonBase {
    @BeforeMethod
    public void openGuruPage()
    {
        driver = initWebDriver(CT_PageURL.GURU_POPUP_URL);
    }
    @Test
    public void getDetailAccess_Successfully()
    {
        //1. Tim window dau tien (main window)
        String firstWindow = driver.getWindowHandle();
        //Click button de mo ra window con
        click(By.xpath("//a[text()='Click Here']"));
        //Lay cac window con roi xu ly tren trang can test
        Set<String> windows = driver.getWindowHandles();
        for(String childWindow:windows)
        {
            if(!childWindow.equals(firstWindow))
            {
                driver.switchTo().window(childWindow);
                Day17_GuruPopup guruPage = new Day17_GuruPopup(driver);
                guruPage.getAccessDetails();
                assertTrue(isDisplay_fluent(By.xpath("//h2[text()='Access details to demo site.']")));
                driver.close();
            }
        }
        //Tro ve window dau tien de thuc hien tiep
        driver.switchTo().window(firstWindow);
        String actualURL = driver.getCurrentUrl();
        //Expected: "https://demo.guru99.com/popup.php"
        assertTrue(actualURL.equals("https://demo.guru99.com/popup.php"));



    }

}
