package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.FinalProject_ThietbiNBkhac;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FinalProject_TBK_Test extends CommonBase {
    @BeforeMethod
    public void openGuruPage()
    {
        driver = initWebDriver(CT_PageURL.BEPANTOAN_URL);
    }
    @Test
    public void locHangSanXuat()
    {
        FinalProject_ThietbiNBkhac finalTBK = new FinalProject_ThietbiNBkhac(driver);
        finalTBK.clickMenuThietBiKhac();
        finalTBK.chonHangBosch();
        assertTrue(finalTBK.tatCaSanPhamLaBosch(), "Không có sản phẩm Bosch nào hiển thị");
        System.out.println("Số sản phẩm Bosch la:" + finalTBK.soLuongSanPhamBosch());

    }
    @Test
    public void kiemTraGioHang()
    {
        FinalProject_ThietbiNBkhac finalTBK = new FinalProject_ThietbiNBkhac(driver);
        finalTBK.clickMenuThietBiKhac();
        finalTBK.chonHangBosch();
       //Lưu tên sản phẩm sẽ mua
        String tenSanPhamDaChon = finalTBK.layTenSanPhamDangChon();
        System.out.println("Sản phẩm chọn mua: " + tenSanPhamDaChon);
        // Mở sản phẩm đầu tiên + cick mua ngay
        finalTBK.moSanPhamBoschDauTien();
        // thêm thời gian chờ nút mua ngay

        finalTBK.ClickMuaNgay();
        finalTBK.ClickGioHang();

        //Lấy tên sản phẩm trong giỏ
        String tenSanPhamTrongGio = finalTBK.layTenSPtrongGioHang();
        System.out.println("Sản phẩm trong giỏ: " + tenSanPhamTrongGio);
        assertTrue(tenSanPhamTrongGio.contains(tenSanPhamDaChon), "Sản phẩm trong giỏ KHÔNG ĐÚNG sản phẩm đã chọn");
    }

    }



