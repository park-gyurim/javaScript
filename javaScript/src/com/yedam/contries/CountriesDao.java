package com.yedam.contries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesDao {
	Connection conn = null;

	public CountriesDao() {
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

	public List<Countries> getCriList() {
		String sql = "select * from contries";
		List<Countries> list = new ArrayList<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Countries s1 = new Countries(rs.getString("countryid"), rs.getString("countryname"),
						rs.getInt("regionId"));
				list.add(s1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

//	public Countries getCounDaoInfo(int) {
//		String sql = "select region_id from countries";
//		CountriesDao ct = new CountriesDAO();
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, boardNo);
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next()) {
//				ed.setempno(rs.getInt("board_no"));
//				ed.setContent(rs.getString("content"));
//				ed.setDate(rs.getString("create_date"));
//				ed.setWriter(rs.getString("Writer"));
//				
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return ed;
//	}

}
