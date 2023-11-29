package com.vti.lesson10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) throws SQLException {
//        1. Sử dụng scanner và prepare statement để nhập giá trị từ bàn phím và lưu vào database.
//        2. Sử dụng vòng lặp để nhập 10 giá trị. Sau khi lưu vào database xong, in ra các bản ghi có 5 <id(primary key) < 20.
//        3. Thực hiện update giá trị bất kỳ cho 1 bản ghi. kiểm tra nếu thành công thì in ra bản ghi đó.

        // Khai báo và kết nối với cơ sở dữ liệu mySQL
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/testing_system";
        String user = "root";
        String password = "Fighting@098";

        Connection myConn = DriverManager.getConnection(dbUrl, user, password);

        if (myConn != null) {
            System.out.println("Kết nối thành công đến DB mySQL");

//        1. Sử dụng scanner và prepare statement để nhập giá trị từ bàn phím và lưu vào database.
        // Tạo đối tượng prepared statement
        String sqlScanner = "INSERT INTO account (Email, UserName, FullName, DepartmentID, PositionID, CreatedDate) " +
                "VALUES (?, ?, ?, ?, ?, sysdate())";
        PreparedStatement preparedStatement = myConn.prepareStatement(sqlScanner);

        // Tạo scanner để nhập dữ liệu từ bàn phím
        Scanner scan = new Scanner(System.in);
        // Nhập dữ liệu từ bàn phím
        System.out.print("Hãy nhập thông tin Email: ");
        String email = scan.nextLine();
        System.out.print("Hãy nhập thông tin UserName: ");
        String username = scan.nextLine();
        System.out.print("Hãy nhập thông tin FullName: ");
        String fullname = scan.nextLine();
        System.out.print("Hãy nhập thông tin DepartmentID: ");
        int depart_id = scan.nextInt();
        System.out.print("Hãy nhập thông tin PositionID: ");
        int pos_id = scan.nextInt();

        // Gán giá trị cho prepared statement
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,username);
        preparedStatement.setString(3,fullname);
        preparedStatement.setInt(4,depart_id);
        preparedStatement.setInt(5,pos_id);

        /* Cách 2: Khai báo biến vào gán giá trị vào prepared statement
            String mail;
            String userName;
            String fullName;
            int depart_id;
            int pos_id;
            Scanner scan = new Scanner(System.in);
            System.out.print("Hãy nhập thông tin Email: ");
            preparedStatement.setString(1, mail = scan.nextLine());
            System.out.print("Hãy nhập thông tin UserName: ");
            preparedStatement.setString(2, userName = scan.nextLine());
            System.out.print("Hãy nhập thông tin FullName: ");
            preparedStatement.setString(3, fullName = scan.nextLine());
            System.out.print("Hãy nhập thông tin DepartmentID: ");
            preparedStatement.setInt(4, depart_id = scan.nextInt());
            System.out.print("Hãy nhập thông tin PositionID: ");
            preparedStatement.setInt(5, pos_id = scan.nextInt());
         */

        // Thực thi câu lệnh vào SQL
        int newRecordByPrepare = preparedStatement.executeUpdate();
        System.out.println("Giá trị của newRecordByPrepare: " + newRecordByPrepare);

    } else {
        System.out.println("Kết nối thất bại");
    }// Đóng kết nối đến database
        System.out.println("Kết thúc chương trình.");
        myConn.close();


    }
}
