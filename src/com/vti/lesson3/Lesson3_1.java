package com.vti.lesson3;

import java.util.Scanner;

public class Lesson3_1 {
    public static void main(String[] args) {
        // Câu điều kiện if ... else
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập giá trị biến x cần kiểm tra: ");
        int x = scan.nextInt();
        System.out.println("Giá trị của x là: " + x);
        if (x < 10) {
            System.out.println("x có giá trị nhỏ hơn 10");
        } else {
            System.out.println("x có giá trị lớn hơn hoặc bằng 10");
        }
    }
}

