package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Factory_BTVNDay14 {
    private WebDriver driver;
    @FindBy(xpath = "//input[@placeholder='Tên người dùng hoặc email']") WebElement textEmail;
    @FindBy(xpath = "//input[@placeholder='Mật khẩu']") WebElement textPass;
    @FindBy(xpath = "//span[normalize-space()='Đăng nhập']") WebElement btnDangNhap;
    @FindBy(xpath ="//span[normalize-space()='Mật Khẩu']") WebElement btnMatKhau;
    @FindBy(xpath ="(//input[@class='el-input__inner' and @type='password'])[2]") WebElement txtnewPass;
    @FindBy(xpath ="(//input[@class='el-input__inner' and @type='password'])[3]") WebElement txtconfirmPass;
    @FindBy(xpath ="//span[normalize-space()='Đổi mật khẩu']") WebElement btnDoiMatKhau;


    public Login_Factory_BTVNDay14(WebDriver driverTest) {
        this.driver = driverTest;
        PageFactory.initElements(driverTest, this);
    }
    public void LoginFunction(String email, String password)
    {
        textEmail.sendKeys(email);
        textPass.sendKeys(password);
        btnDangNhap.click();
     //   driver.switchTo().alert().accept();
    }
    public void ChangePassword (String newPass, String confirmPass){
        btnMatKhau.click();
        txtnewPass.sendKeys(newPass);
        txtconfirmPass.sendKeys(confirmPass);
        btnDoiMatKhau.click();
    }
}
