package com.vti.lesson4.hinhhoc;
import java.util.Scanner;

public class HinhVuong {
    public static void tinhDienTichVuong() {
        // Khai báo biến cạnh hình vuông
        int canhv;

        // Nhập cạnh hình vuông
        System.out.println("Vui lòng nhập cạnh hình vuông! (đơn vị cm) ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Cạnh của hình vuông là: ");
        canhv = scan.nextInt();

        // Kiểm tra giá trị cạnh
        if (canhv <= 0) {
            System.out.println("Cạnh của hình vuông phải là số nguyên dương. Vui lòng kiểm tra lại!" + "\n");
            return;
        }

        // Tính diện tích
        int dienTichV = canhv * canhv;

        // Hiển thị diện tích
        System.out.println("Diện tích của hình vuông là: " + dienTichV + " cm²" + "\n");
    }
}

//    public static void tinhDienTichVuong () {
//        System.out.println("Vui lòng nhập cạnh hình vuông! (đơn vị cm) ");
//        Scanner input = new Scanner(System.in);
//        System.out.print("Cạnh hình vuông = ");
//        float v = input.nextFloat();
//
//        if (v <= 0) {
//            System.out.println("Cạnh của hình vuông phải là số nguyên dương. Vui lòng kiểm tra lại!" + "\n");
//            return;
//        }
//        float sVuong = v * v;
//        System.out.println("Diện tích của hình vuông là: "+sVuong +" cm²" + "\n");
//    }
//}
