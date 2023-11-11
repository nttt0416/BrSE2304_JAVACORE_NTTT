package com.vti.lesson4.homework;

import com.vti.lesson4.hinhhoc.HinhTamGiac;
import com.vti.lesson4.hinhhoc.HinhTron;
import com.vti.lesson4.hinhhoc.HinhVuong;

import java.util.Scanner;

public class Ex1 {
    // Đề bài: tạo menu sử dụng switch case với gía trị nhập vào từ bàn phím để tạo menu tính diện tích các hình
//    Home work ngày 11/11/2023
//    Đề bài: tạo menu sử dụng switch case với giá trị nhập vào từ bàn phím để tạo menu tính diện tích các hình
//     1. Hinh vuông
//     2. Hình tròn
//     3. Hình tam giác
//    Nhập giá trị khác 1,2,3 thì in ra thông báo "Giá trị bạn vừa nhập không đúng. Bạn vui lòng nhập lại"
//    Trong package hinhhoc, sửa lại 3 hàm tính diện tích sao cho phù hợp với từng hình.
//    Kiểm tra giá trị nhập vào đối với từng cạnh của tam giác, hình vuông và bán kính hình tròn phải là nguyên dương
//    Đối với hình tròn, khai báo thêm hằng số Pi = 3.14
//    in ra giá trị diện tích cho từng hình
//    P/S: Diện tích hình vuông: a*a
//    Diện tích hình tam giác: chiều cao * cạnh đáy * 0.5f
//    Diện tích hình tròn: Pi*R*R  (R là bán kính)
    public static void main(String[] args) {
        // Khai báo biến lựa chọn
        int luaChon;

        // Khởi tạo Scanner
        Scanner scan = new Scanner(System.in);

        // Vòng lặp để hiện menu liên tục
        do {
            System.out.println("Đây là menu tính diện tích các hình!");
            System.out.println("Vui lòng nhập số để chọn tính năng tính diện tích tương ứng: ");
            System.out.println("1. Hình vuông");
            System.out.println("2. Hình tròn");
            System.out.println("3. Hình tam giác");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn: ");

            // Nhập lựa chọn
            luaChon = scan.nextInt();

            // Xử lý lựa chọn
            switch (luaChon) {
//                case 1:
//                    // Tính diện tích hình vuông
//                    HinhVuong.tinhDienTichVuong();
//                    break;
                case 1:
                    // Tính diện tích hình vuông
                    HinhVuong.tinhDienTichVuong();
                    break;
                case 2:
                    // Tính diện tích hình tròn
                    HinhTron.tinhDienTichTron();
                    break;
                case 3:
                    // Tính diện tích hình tam giác
                    HinhTamGiac.tinhDienTichTamGiac();
                    break;
                case 0:
                    // Thoát
                    System.out.println("Chương trình đã kết thúc. Xin cám ơn và không hẹn gặp lại!!");
                    break;
                default:
                    // Giá trị lựa chọn không hợp lệ
                    System.out.println("Giá trị bạn vừa nhập không đúng. Bạn vui lòng nhập lại"+ "\n");
            }
        } while (luaChon != 0);

    }
}


