package com.yedam.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.board.Board;

public class EmpDAO {
	Connection conn = null;

	public EmpDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("정상적으로 연결됬음");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("연결중 에러발생!");
			e.printStackTrace();
		}

	}
}

	public List<Student> getEmpList() {
		String sql = "select first_name, salary, email from emp";
		List<Student> list = new ArrayList<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Student s1 = new Student(rs.getString("first_name"), rs.getInt("salary"), rs.getString("email"));
				list.add(s1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public employee getEmpDaoInfo(int ) {
	String sql = "select empno,ename,phone_number,department_name,email from emp";
	EmpDAO ed = new EmpDAO();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			ed.setempno(rs.getInt("board_no"));
			ed.setContent(rs.getString("content"));
			ed.setDate(rs.getString("create_date"));
			ed.setWriter(rs.getString("Writer"));
			
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return ed;
}
