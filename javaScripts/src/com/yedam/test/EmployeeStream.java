package com.yedam.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.yedam.dev.Employee;

public class EmployeeStream {
	public static void main(String[] args) {
		Connection conn = null;

		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 List<Employee> list = new ArrayList<>();
	      try {
	         PreparedStatement pstmt = conn.prepareStatement("SELECT first_name, salary FROM Employees");
	         ResultSet rs = pstmt.executeQuery();
	         while (rs.next()) {
	            list.add(new Employee(rs.getString("first_name"), rs.getInt("salary")));
	         }
	      } catch (SQLException e) {
	         System.out.println("SQL문을 확인해보세요.");
	      }
	      Stream<Employee> stream = list.stream();
	      stream.forEach((s) -> System.out.println(s.getFirstName() + ", " + s.getSalary()));
	   }
	}