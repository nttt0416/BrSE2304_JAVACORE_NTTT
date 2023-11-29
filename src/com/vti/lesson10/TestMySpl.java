package com.vti.lesson10;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

public class TestMySpl {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/testing_system";
        String user = "root";
        String password = "Fighting@098";

        Connection myConn = DriverManager.getConnection(dbUrl, user, password);

        if (myConn != null) {
            System.out.println("Kết nối thành công");

        // Sử dụng đối tượng
        Statement myStmt = myConn.createStatement();
        ResultSet result = myStmt.executeQuery("SELECT * FROM account where AccountID = 1");
        while (result.next()) {
            System.out.println(result.getString("username"));
            System.out.println(result.getString("email"));
        }
        String sqlInsert = "INSERT INTO account (Email, UserName, FullName, DepartmentID, PositionID, CreatedDate) " +
                "VALUES ('t6@gmail.com', 'nttt123', 'TRANG NÈ', 2, 1, sysdate())";
        int newRecord = myStmt.executeUpdate(sqlInsert);
            System.out.println("Giá trị của newRecord: " + newRecord);

            //Sử dụng đối tượng PrepareStatement
            String sql = "INSERT INTO account (Email, UserName, FullName, DepartmentID, PositionID, CreatedDate) " +
                    "VALUES (?, ?, ?, ?, ?, sysdate())";
            PreparedStatement preparedStatement = myConn.prepareStatement(sql);
            preparedStatement.setString(1, "m6@gmail.com");
            preparedStatement.setString(2, "user");
            preparedStatement.setString(3, "FULLNAMENE");
            preparedStatement.setInt(4,3);
            preparedStatement.setInt(5,4);

            int newRecordByPrepare = preparedStatement.executeUpdate();
            System.out.println("Giá trị của newRecordByPrepare: " + newRecordByPrepare);

            //Sử dụng đối tượng PrepareStatement và dùng Scanner để nhập thông tin
            String sqlScanner = "INSERT INTO account (Email, UserName, FullName, DepartmentID, PositionID, CreatedDate) " +
                    "VALUES (?, ?, ?, ?, ?, sysdate())";
            PreparedStatement preparedStatement1 = myConn.prepareStatement(sqlScanner);
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

            int newRecordByPrepare1 = preparedStatement.executeUpdate();
            System.out.println("Giá trị của newRecordByPrepare bằng S: " + newRecordByPrepare1);

            //Dùng vòng for/ while để nhập 5 giá trị vào bảng ghi
            // Dùng if- elese để kiểm tra DB nếu đã tồn tại giá trị

            // Tạo 10 file khác nhau
//            Scanner scan1 = new Scanner(System.in);
            // Dùng vòng lặp for để nhập 5 giá trị vào bảng ghi
            // Dùng vòng lặp for để nhập 2 giá trị vào bảng ghi
            for (int i = 1; i <= 2; i++) {
                // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
                Scanner scanner = new Scanner(System.in);

                // Nhập giá trị cho tham số `email`
                System.out.print("Nhập email của người dùng thứ " + i + ": ");
                String email = scanner.nextLine();
                preparedStatement.setString(1, email);

                // Kiểm tra xem giá trị đã tồn tại trong DB hay chưa
                String sqlCheck = "SELECT COUNT(*) AS count FROM account WHERE email = ?";
                PreparedStatement preparedStatementCheck = myConn.prepareStatement(sqlCheck);
                preparedStatementCheck.setString(1, email);
                ResultSet resultSet = preparedStatementCheck.executeQuery();
                resultSet.next();
                int count = resultSet.getInt("count");

                if (count == 0) {
                    // Nếu giá trị chưa tồn tại thì chèn vào bảng ghi
                    System.out.println("Chèn thành công!");
                } else {
                    // Nếu giá trị đã tồn tại thì thông báo ngay và cho nhập lại giá trị khác
                    System.out.println("Email đã tồn tại! Vui lòng nhập lại:");
                    email = scanner.nextLine();
                    preparedStatement.setString(1, email);
                }

                // Nhập giá trị cho tham số `username`
                System.out.print("Nhập username của người dùng thứ " + i + ": ");
                String username = scanner.nextLine();
                preparedStatement.setString(2, username);

                // Nhập giá trị cho tham số `full_name`
                System.out.print("Nhập full name của người dùng thứ " + i + ": ");
                String fullname = scanner.nextLine();
                preparedStatement.setString(3, fullname);

                // Nhập giá trị cho tham số `department_id`
                System.out.print("Nhập department id của người dùng thứ " + i + ": ");
                int departmentId = scanner.nextInt();
                preparedStatement.setInt(4, departmentId);

                // Nhập giá trị cho tham số `position_id`
                System.out.print("Nhập position id của người dùng thứ " + i + ": ");
                int positionId = scanner.nextInt();
                preparedStatement.setInt(5, positionId);
                preparedStatement.executeUpdate();
                }
            }


//        } else {
//            System.out.println("Kết nối thất bại");
//        }
        myConn.close();
    }

    }
