package automation.testsuite;

import java.util.Scanner;
import org.testng.annotations.Test;

public class BTVN_Day7 {
    @Test
    public void nhapTenNV(){
        System.out.print("Nhập số lượng nhân viên: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] tenNV = new String[n];
        for(int i = 0; i < n; i++)
        {
            System.out.print("Nhập tên nhân viên thứ " + (i+1) + ": " );
            tenNV[i] = sc.nextLine();
        }
        System.out.println("DANH SÁCH NHÂN VIÊN: ");
        for(int i = 0; i < n; i ++)
        {
            System.out.println("Nhân viên " + (i+1) + ". " + tenNV[i]);
        }

    }
}
