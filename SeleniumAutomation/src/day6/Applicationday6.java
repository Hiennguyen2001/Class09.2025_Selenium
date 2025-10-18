package day6;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Applicationday6 {
    static int luongCB = 10000000;
    public static void main(String[] args) {
        System.out.println("Nhập thông tin nhân viên phòng HCNS");
        HCNS[] hcns = nhapNV();
        System.out.println("Lương của các nhân viên như sau: ");
        inLuongNV(hcns);
        caoHonLuongTB(hcns);
        chiPhiLuong(hcns);

    }
// HAM NHAP VA IN DANH SACH NHAN VIEN
    public static HCNS[] nhapNV() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nhân viên: ");
        int n = sc.nextInt();
        sc.nextLine();
        HCNS[] hcns = new HCNS[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập nhân viên thứ " + (i + 1) + ": ");
            hcns[i] = new HCNS();
            hcns[i].NhapNV();
        }
        System.out.println("Danh sách nhân viên phòng HCNS là: ");
        for (int i = 0; i < n; i++) {
            hcns[i].inNV();
        }
        return hcns;
    }
// HAM TINH LUONG 1 NHAN VIEN
    public static double tinhLuong(HCNS hc) {
        double tongLuong = 0;
            if (hc.getSoNamKN() >= 5)
            {
                tongLuong = luongCB * hc.getSoNamKN() + 0.5 * luongCB;
            }
            else if (hc.getSoNamKN() >= 3 && hc.getSoNamKN() <= 5)
            {
                tongLuong = luongCB * hc.getSoNamKN() + 0.3 * luongCB;
            }
            else
            {
                tongLuong = luongCB * hc.getSoNamKN();
            }
        return tongLuong;
    }
    // HAM IN LUONG NHAN VIEN
    public static void inLuongNV(HCNS[] hcns)
    {
        DecimalFormat formatter = new DecimalFormat("#");
        for (int i = 0; i < hcns.length; i++)
        {
        double luong = tinhLuong(hcns[i]);
        System.out.println("Lương của nhân viên thứ " + hcns[i].getTenNV() + " là: " + formatter.format(luong));
        }
    }
    // HAM IN LUONG NHAN VIEN CAO HON LUONG TB
    public static void caoHonLuongTB(HCNS[] hcns){
        DecimalFormat formatter = new DecimalFormat("#");
        double sum = 0;
        for(int i = 0; i < hcns.length; i ++)
        {
            sum = sum + tinhLuong(hcns[i]);
        }
        System.out.println("Lương trung bình của phòng là: " +  formatter.format(sum/hcns.length));
        System.out.println("Danh sách nhân viên có lương lớn hơn lương TB: ");
        for(int i = 0; i < hcns.length; i ++)
            if(tinhLuong(hcns[i]) > sum/hcns.length)
            {
                System.out.println(hcns[i].getTenNV()  + " có lương  " +  formatter.format(tinhLuong(hcns[i])));
            }
    }
    // HAM TINH CHI PHI TONG LUONG
    public static void chiPhiLuong(HCNS[] hcns){
        DecimalFormat formatter = new DecimalFormat("#");
        double sum = 0;
        for(int i = 0; i < hcns.length; i ++)
        {
            sum = sum + tinhLuong(hcns[i]);
        }
        System.out.println("Tổng chi phí trả lương cho nhân viên là: " + formatter.format(sum * 0.1));
    }

}

