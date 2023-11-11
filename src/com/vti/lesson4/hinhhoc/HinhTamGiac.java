package com.vti.lesson4.hinhhoc;
import java.util.Scanner;

public class HinhTamGiac {
    public static void tinhDienTichTamGiac() {
        // Khai báo biến chiều rộng và chiều cao
        float rong;
        float cao;

        // Nhập chiều rộng và chiều cao
        System.out.println("Vui lòng nhập chiều rộng cạnh đáy và chiều cao hình tam giác! (đơn vị cm) ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Chiều rộng của hình tam giác là: ");
        rong = scan.nextFloat();
        System.out.print("Chiều cao của hình tam giác là: ");
        cao = scan.nextFloat();

        // Kiểm tra giá trị chiều rộng và chiều cao
        if (rong <= 0 || cao <= 0) {
            System.out.println("Chiều rộng và chiều cao của hình tam giác phải là số nguyên dương. Vui lòng kiểm tra lại!" + "\n");
            return;
        }

        // Tính diện tích
        float dienTichTg = (rong * cao * 0.5F);

        // Hiển thị diện tích
        System.out.println("Diện tích của hình tam giác là: " + dienTichTg + " cm²" + "\n");
    }
}