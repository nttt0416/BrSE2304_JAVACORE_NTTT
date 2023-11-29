package com.vti.lesson10;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) throws SQLException {
        //        3. Thực hiện update giá trị bất kỳ cho 1 bản ghi. kiểm tra nếu thành công thì in ra bản ghi đó.

        // Khai báo và kết nối với cơ sở dữ liệu mySQL
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/testing_system";
        String user = "root";
        String password = "Fighting@098";

        Connection myConn = DriverManager.getConnection(dbUrl, user, password);

        if (myConn != null) {
            System.out.println("Kết nối thành công đến DB mySQL");

            // Tạo đối tượng prepared statement
//            String sqlScanner = "UPDATE INTO account (Email, UserName, FullName, DepartmentID, PositionID, CreatedDate) " +
//                    "VALUES (?, ?, ?, ?, ?, sysdate())";
            String sqlScanner = "UPDATE testing_system.account WHERE AccountID = ? SET Email = ?, UserName = ?, FullName = ?, DepartmentID = ?, PositionID = ?, CreatedDate = ? ";
            PreparedStatement preparedStatement = myConn.prepareStatement(sqlScanner);

            // Tạo scanner để nhập accountID từ bàn phím
            Scanner scanID = new Scanner(System.in);
            System.out.print("Hãy nhập accountID cần cập nhật: ");
            int accID = scanID.nextInt();

            // Vòng lặp để hiện menu lựa chọn mục cần update thông tin
            int luaChon;
            Scanner scan = new Scanner(System.in);
            do {
                System.out.println("Vui lòng nhập số để chọn mục cần Update thông tin liên quan đến accountID vừa nhập : ");
                System.out.println("1. Email");
                System.out.println("2. UserName");
                System.out.println("3. FullName");
                System.out.println("4. DepartmentID");
                System.out.println("5. PositionID");
                System.out.println("6. CreatedDate");
                System.out.println("0. Thoát");
                System.out.println("Mời bạn nhập lựa chọn: ");

                // Nhập lựa chọn
                luaChon = scan.nextInt();

                // Xử lý lựa chọn
                switch (luaChon) {

                    case 1:
                        System.out.print("Hãy nhập nội dung Email MỚI để được Update: ");
                        String udEmail = scan.nextLine();
                        preparedStatement.setString(1, udEmail);
                        int newRecordByPrepare1 = preparedStatement.executeUpdate();
                        break;
                    case 2:
                        System.out.print("Hãy nhập nội dung UserName MỚI để được Update: ");
                        String udUn = scan.nextLine();
                        preparedStatement.setString(2, udUn);
                        int newRecordByPrepare2 = preparedStatement.executeUpdate();
                        break;
                    case 3:
                        System.out.print("Hãy nhập nội dung FullName MỚI để được Update: ");
                        String udFn = scan.nextLine();
                        preparedStatement.setString(3, udFn);
                        int newRecordByPrepare3 = preparedStatement.executeUpdate();
                        break;
                    case 4:
                        System.out.print("Hãy nhập SỐ DepartmentID MỚI để được Update: ");
                        int ud_deID = scan.nextInt();
                        preparedStatement.setInt(4, ud_deID);
                        int newRecordByPrepare4 = preparedStatement.executeUpdate();
                        break;
                    case 5:
                        System.out.print("Hãy nhập SỐ PositionID MỚI để được Update: ");
                        int ud_poID = scan.nextInt();
                        preparedStatement.setInt(5, ud_poID);
                        int newRecordByPrepare5 = preparedStatement.executeUpdate();
                        break;
                    case 6:
                        System.out.print("Hãy nhập NGÀY CreatedDate MỚI THEO DẠNG: YYYY-MM-dd để được Update: ");
                        String ud_date = scan.next();
                        preparedStatement.setString(6, ud_date);
                        int newRecordByPrepare6 = preparedStatement.executeUpdate();
                        break;
                    case 0:
                        System.out.println("MENU chọn mục cần Update đã kết thúc!");
                        break;
                    default:
                        // Giá trị lựa chọn không hợp lệ
                        System.out.println("Giá trị bạn vừa nhập không đúng. Bạn vui lòng nhập lại" + "\n");
                }
            } while (luaChon != 0);


            } else {
                System.out.println("Kết nối thất bại");
            }// Đóng kết nối đến database
            System.out.println("Kết thúc chương trình.");
            myConn.close();

        }
    }

