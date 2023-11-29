package com.vti.lesson10;

import java.sql.*;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) throws SQLException {
        //        2. Sử dụng vòng lặp để nhập 10 giá trị.
        //        Sau khi lưu vào database xong, in ra các bản ghi có 5 <id(primary key) < 20.

        // Khai báo và kết nối với cơ sở dữ liệu mySQL
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/testing_system";
        String user = "root";
        String password = "Fighting@098";

        Connection myConn = DriverManager.getConnection(dbUrl, user, password);

        if (myConn != null) {
            System.out.println("Kết nối thành công đến DB mySQL");

            // Tạo đối tượng prepared statement
            String sqlScanner = "INSERT INTO account (Email, UserName, FullName, DepartmentID, PositionID, CreatedDate) " +
                    "VALUES (?, ?, ?, ?, ?, sysdate())";
            PreparedStatement preparedStatement = myConn.prepareStatement(sqlScanner);

        // Dùng vòng lặp để nhập 10 giá trị
        for (int i = 1; i <= 5; i++) {
            Scanner scanner_for = new Scanner(System.in);

            System.out.print("Hãy nhập Email của người dùng thứ " + i + ": ");
            String email_f = scanner_for.nextLine();
            System.out.print("Hãy nhập UserName của người dùng thứ " + i + ": ");
            String uName_f = scanner_for.nextLine();
            System.out.print("Hãy nhập FullName của người dùng thứ " + i + ": ");
            String fName_f = scanner_for.nextLine();
            System.out.print("Hãy nhập DepartmentID của người dùng thứ " + i + ": ");
            int departid_f = scanner_for.nextInt();
            System.out.print("Hãy nhập PositionID của người dùng thứ " + i + ": ");
            int posid_f = scanner_for.nextInt();

            // Gán giá trị cho prepared statement
            preparedStatement.setString(1, email_f);
            preparedStatement.setString(2, uName_f);
            preparedStatement.setString(3, fName_f);
            preparedStatement.setInt(4, departid_f);
            preparedStatement.setInt(5, posid_f);

            // Thực thi câu lệnh vào SQL
            int newRecordByPrepare = preparedStatement.executeUpdate();
            System.out.println("Giá trị của newRecordByPrepare: " + newRecordByPrepare);
        }

            /*============================================================*/
            // In ra các bản ghi có 5 < accountid(primary key) < 20
            String mySql_id = "SELECT * FROM testing_system.account WHERE AccountID > 5 AND AccountID < 20";
            Statement statement = myConn.createStatement();
            ResultSet result = statement.executeQuery(mySql_id);

            while (result.next()) {
                int accId_tb = result.getInt("AccountID");
                String email_tb = result.getString("Email");
                String uname_tb = result.getString("UserName");
                String fname_tb = result.getString("FullName");
                int departid_tb = result.getInt("DepartmentID");
                int posid_tb = result.getInt("PositionID");
                String crdate_tb = result.getString("CreatedDate");

                System.out.println("AccountID: " + accId_tb + ", Email: " + email_tb + ", UserName: " + uname_tb + ", FullName: " + fname_tb
                        + ", DepartmentID: " + departid_tb + ", PositionID: " + posid_tb + ", CreatedDate: " + crdate_tb);
            }

        } else {
            System.out.println("Kết nối thất bại");
        }// Đóng kết nối đến database
        System.out.println("Kết thúc chương trình.");
        myConn.close();

        }
    }
