package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day12_DropdownList extends CommonBase {
    @Test
    public void selectDropdownList(){
        driver = initChromeDriver(CT_PageURL.CODESTAR_URL);
        Select dropCourse = new Select(driver.findElement(By.id("product_categories_filter")));
        //Kiem tra size
        int size = dropCourse.getOptions().size();
        System.out.println("Size is: " +size);

        //Chọn aws theo cach 1
        dropCourse.selectByVisibleText("AWS");
        String aws = dropCourse.getFirstSelectedOption().getText();
        System.out.println("Text sau khi chọn aws:" + aws);

        //Chọn lập trình web theo cách 2
        dropCourse.selectByIndex(3);
        String laptrinhWeb = dropCourse.getFirstSelectedOption().getText();
        System.out.println("Text sau khi lap trinh web: " + laptrinhWeb);
    }
}
