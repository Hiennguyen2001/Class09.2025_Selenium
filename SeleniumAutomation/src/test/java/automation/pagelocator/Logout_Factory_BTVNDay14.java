package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Logout_Factory_BTVNDay14 {
    private WebDriver driver;
    @FindBy(xpath="//img[@class='avatar avatar--md rounded-circle el-popover__reference']") WebElement adminDropdown;
    @FindBy(xpath = "//a[normalize-space()='Đăng xuất']") WebElement btnDangXuat;
    public Logout_Factory_BTVNDay14 (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void LogoutFunction ()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        adminDropdown.click();
        btnDangXuat.click();



    }
}
