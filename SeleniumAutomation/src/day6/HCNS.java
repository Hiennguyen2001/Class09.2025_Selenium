package day6;

import java.util.Scanner;

public class HCNS extends DSNhanVien{
    private String chucVu;
    private float soNamKN;

    public String getChucVu() {
        return chucVu;
    }

    public float getSoNamKN() {
        return soNamKN;
    }

    public void setSoNamKN(float soNamKN) {
        this.soNamKN = soNamKN;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    @Override
    public void NhapNV()
    {
        super.NhapNV();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chức vụ: " );
        chucVu =  sc.nextLine();
        System.out.print("Nhập số năm kinh nghiệm: " );
        soNamKN =  sc.nextFloat();
    }
    @Override
    public void inNV()
    {
        System.out.println("Nhân viên có mã là: " + getMaNV() + ", họ tên là " + getTenNV() + ", số điện thoại " + getSdt() + ", chức vụ là " + chucVu + ", số năm kinh nghiệm " + getSoNamKN());
    }

}
