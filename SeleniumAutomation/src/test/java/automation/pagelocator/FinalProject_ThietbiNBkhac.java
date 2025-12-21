package automation.pagelocator;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class FinalProject_ThietbiNBkhac extends CommonBase {
    private WebDriver driver;
    @FindBy(xpath = "(//a[@href='/danh-muc/thiet-bi-nha-bep-khac'])[2]") WebElement menuThietBiKhac;
    @FindBy(xpath = "//img[@src='https://static.bepantoan.vn/userfiles/images/logo bosch.jpg?w=100']") WebElement btnBosch;
    @FindBy(xpath = "//img[@alt='Bosch']") private List<WebElement> boschLabels;
  //  @FindBy(xpath = "(//h4[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'bosch')]/ancestor::a)[1]")
 //   WebElement firstBosch;
    By firstBosch = By.xpath("(//h4[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'bosch')]/ancestor::a)[1]");
    By firstBosch_Name = By.xpath("(//h4[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'bosch')])[1]");
    @FindBy(xpath = "(//span[text()='Mua ngay']/ancestor::a)[1]") WebElement btnMuaNgay;
    @FindBy(xpath = "//div[text()='Giỏ hàng']//ancestor::a") WebElement btnGioHang;
    By tenSPtrongGioHang = By.xpath("//td//h4[contains(translate(text()," + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'bosch')]");

    public FinalProject_ThietbiNBkhac (WebDriver driverTest){
        this.driver = driverTest;
        PageFactory.initElements(driverTest, this);
    }
    public void clickMenuThietBiKhac() {
        menuThietBiKhac.click();
    }

    public void chonHangBosch()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnBosch));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnBosch);
    }
    public boolean tatCaSanPhamLaBosch()
    {
        return boschLabels.size() > 0;
    }
    public int soLuongSanPhamBosch()
    {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return boschLabels.size();
    }
    public void moSanPhamBoschDauTien()
    {
        click(firstBosch);
    }
    public String layTenSanPhamDangChon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement tenSP = wait.until(ExpectedConditions.visibilityOfElementLocated(firstBosch_Name));
        return tenSP.getText().trim();
    }

    public void ClickMuaNgay()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnMuaNgay));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnMuaNgay);
    }
    public void ClickGioHang()
    {
        btnGioHang.click();
    }
    public String layTenSPtrongGioHang()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement tenSPtrongGio = wait.until(ExpectedConditions.visibilityOfElementLocated(tenSPtrongGioHang));
        return tenSPtrongGio.getText().trim();
    }

    }


