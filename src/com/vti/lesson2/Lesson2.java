package com.vti.lesson2;

public class Lesson2 {
    public static void main(String[] args) {
        //Ôn lại kiến thức về toán tử trong Java
        //1. Toán tử quan hệ
        int x = 2;
        int y = 3;
        // 1.1 Toán tử !=
        System.out.println(x != y);
        // 1.2 Toán tử <=
        x = 10;
        y = 10;
        System.out.println(x <= y);

        //1.3 Chia lấy phần dư
        tong2So();

        int z = hieu2So();
        System.out.println("Hiệu của 2 số là: " + z); // Do khi khai báo hàm hieu2So, đã gán kqua return = 10

        int c = tich2So(8, 9 );
        System.out.println("Tích của 2 số a và b là: " + c);

        int d = tich2So(20 );
        System.out.println("Tích của 2 số theo hàm mới là: " + d);

    }
    // Hàm không có tham số truyền vào
    public static void tong2So() {
        System.out.println("Tổng 2 số 2 và 3 là: " + (2+3) );
    }

    //Hàm khai báo kiểu dữ liệu gì thì phải return về giá trị của kiểu dữ liệu đó
    public static int hieu2So(){
        return 10;
    }

    // Hàm có tham số truyền vào (parameter)
    public static int tich2So(int a, int b) {
        return a*b;
    }

    public static int tich2So(int c) {
        return c*6;
    }


}
