package com.yedam.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.dev.Employee;

public class BoardDao {
	Connection conn = null;

	public BoardDao() {// 생성자만들기(생성자는 클래스랑 이름이 같아야한다)
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
	}

	public List<Board> getBoardList() {
		String sql = "select * from board";
		List<Board> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board brd = new Board();
				brd.setBoardNo(rs.getInt("Board_No"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("Writer"));
				brd.setDate(rs.getString("Create_date"));
				list.add(brd);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Board getBoardInfo(int boardNo) {
		String sql = "select board_no, content, writer, create_date from board where board_no = ?";
		Board brd = new Board();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setContent(rs.getString("content"));
				brd.setDate(rs.getString("create_date"));
				brd.setWriter(rs.getString("Writer"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return brd;
	}

	public void insertBoard(Board brd) {
		String sql = "insert into board values((select nvl(max(board_no),0)+1 from board), ?, ?, sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brd.getContent());
			pstmt.setString(2, brd.getWriter());
			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
