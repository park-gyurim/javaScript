package co.yedam.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO {
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   Connection conn = null;

   // 등록
   public void insert(EmpDO emp) {
      try {
         // 1. connect(DB 연결)
         conn = DriverManager.getConnection(url, "hr", "hr");
         // 2. statement(SQL 구문 준비)
         String sql = "INSERT INTO employees (employee_id, last_name, email, hire_date, job_id)"
               + "VALUES(?,?,?,?,?)";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         // 3. excute(SQL 실행)
         pstmt.setString(1, emp.getEmployeeId());
         pstmt.setString(2, emp.getLastName());
         pstmt.setString(3, emp.getEmail());
         pstmt.setString(4, emp.getHireDate());
         pstmt.setString(5, emp.getJobId());
         pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            // 5. close(연결해제)
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   // 수정

   // 조회

   // 삭제
   public void delete(EmpDO emp) {
	      try {
	         // 1. connect(DB 연결)
	         conn = DriverManager.getConnection(url, "hr", "hr");
	         // 2. statement(SQL 구문 준비)
	         String sql = "delete from employees where employee_id = ?";
	               
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         // 3. excute(SQL 실행)
	         pstmt.setString(1, emp.getEmployeeId());
	         pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            // 5. close(연결해제)
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }
   
   // 단거조회
   public EmpDO SelectOne(EmpDO emp) {
	   EmpDO empDO = new EmpDO();
	      try {
	         // 1. connect(DB 연결)
	         conn = DriverManager.getConnection(url, "hr", "hr");
	         // 2. statement(SQL 구문 준비)
	         String sql = "select * from employees where employee_id = ?";
	               
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         // 3. excute(SQL 실행)
	         pstmt.setString(1, emp.getEmployeeId());
	         ResultSet rs = pstmt.executeQuery();
	         // 4. 결과처리
	         if(rs.next()) {
	        	 empDO.setEmployeeId(rs.getString("EMPLOYEE_ID"));
	        	 empDO.setLastName(rs.getString("last_Name"));
	        	 empDO.setEmail(rs.getString("email"));
	        	 empDO.setHireDate(rs.getString("hire_Date"));
	        	 empDO.setJobId(rs.getString("job_Id"));
	        	 
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            // 5. close(연결해제)
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return empDO;
	   }
   // 전체조회
}