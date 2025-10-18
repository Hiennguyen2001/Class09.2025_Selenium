package day6;

import java.util.Scanner;

public class DSNhanVien {
    private String maNV;
    private String tenNV;
    private String sdt;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void NhapNV()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên: " );
        maNV =  sc.nextLine();
        System.out.print("Nhập họ tên: " );
        tenNV = sc.nextLine();
        System.out.print("Nhập số điện thoại: " );
        sdt = sc.nextLine();

    }
    public void inNV(){
        System.out.println("Nhân viên có mã là: " + maNV + ", họ tên là " + tenNV + ", số điện thoại " + sdt);
    }
}
