package automation.testsuite;

import java.util.Scanner;
import org.testng.annotations.Test;
public class Practice {
    @Test
    public void tinhTongMang(){
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập độ dài của mảng: ");
            int n = sc.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                a[i] = sc.nextInt();
                sum = sum + a[i];
            }
            System.out.println("Tổng của mảng là: " + sum);
        }
    }
}


