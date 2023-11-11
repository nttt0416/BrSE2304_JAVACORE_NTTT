package com.vti.lesson2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        float s = tinhDienTichHinhTron(5.5F);
        System.out.println("Dien tich hinh tron la: " + s);

        int dtcn = tinhDienTichHinhChuNhat(3, 4);
        System.out.println("Diện tích hình chữ nhật là: " + dtcn);

        inRaHoVaTen("Nguyễn Thị Thùy Trang");
        System.out.println("Tuổi hiện tại của bạn là " + tinhSoTuoiHienTai(1995));

        inRaTenVaTuoi(1996);

    }

    public static float tinhDienTichHinhTron(float r) {
        float dienTich = r*r*3.14F;
        return dienTich;
    }

    public static int tinhDienTichHinhChuNhat (int a, int b){
        int dienTichChuNhat = a * b;
        return dienTichChuNhat;
    }
    public static void inRaHoVaTen(String fullName){
        System.out.println("Hello " + fullName);
    }

    public static void customerName() {
        System.out.println("Xin chào bạn Trang Tròn Trịa");
    }

    public static int tinhSoTuoiHienTai (int namSinh) {
        return 2023 - namSinh;
    }

    public static void inRaTenVaTuoi (int namSinh) {
        customerName();
        System.out.println("Tuổi của bạn là: " + tinhSoTuoiHienTai(namSinh));
    }

}
