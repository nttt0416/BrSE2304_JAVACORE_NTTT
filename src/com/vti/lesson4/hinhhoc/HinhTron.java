package com.vti.lesson4.hinhhoc;
import java.util.Scanner;

public class HinhTron {
    public static final float HANG_SO_PI = 3.14F;

    public static void tinhDienTichTron() {
        // Khai báo biến bán kính
        int r;

        // Nhập bán kính
        System.out.println("Vui lòng nhập bán kính R của hình tròn! (Đơn vị cm) ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Bán kính R là: ");
        r = scan.nextInt();

        // Kiểm tra giá trị bán kính
        if (r <= 0) {
            System.out.println("Bán kính của hình tròn phải là nguyên dương. Vui lòng kiểm tra lại!" + "\n");
            return;
        }

        // Tính diện tích
        float dienTichTron = r * r * HANG_SO_PI;

        // Hiển thị diện tích
        System.out.println("Diện tích của hình tròn là: " + dienTichTron + " cm²" + "\n");
    }
}
