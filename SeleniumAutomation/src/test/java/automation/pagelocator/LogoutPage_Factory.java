package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LogoutPage_Factory {
    private WebDriver driver;
    @FindBy(id="dropdownMenuLink") WebElement adminDropdown;
    @FindBy(xpath = "//button[contains(@class,'dropdown-item') and normalize-space(text())='Đăng xuất']") WebElement btnDangXuat;
    @FindBy(xpath = "//button[contains(@class,'btn-success') and normalize-space()='Đăng xuất']") WebElement btnConfirmDangXuat;
    public LogoutPage_Factory (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void LogoutFunction ()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        adminDropdown.click();
        btnDangXuat.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        btnConfirmDangXuat.click();



    }
}
