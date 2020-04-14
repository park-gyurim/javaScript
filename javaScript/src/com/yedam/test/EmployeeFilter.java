package com.yedam.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeFilter {
	public static void main(String[] args) throws IOException {
		// DB 연결
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
		// Employee 테이블의 salary 1000 이상 사원들 first_name 기준으로 오름차순 정렬
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT first_name, salary FROM Employees ORDER BY first_name");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getString("first_name"), rs.getInt("salary")));
			}
		} catch (SQLException e) {
			System.out.println("SQL문을 확인해보세요.");
		}
		Stream<Employee> stream = list.stream();
		stream.filter(s -> s.getSalary() >= 1000)
				.forEach((s) -> System.out.println(s.getFirst_name() + ", " + s.getSalary()));

	}

}