package com.yedam.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	Connection conn = null;

	public EmpDAO() {
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
	
	public void insertEmp(Employee emp) {
		String sql = "insert into emp1(employee_id, last_name, email, hire_date, job_id)" +
					"values((select max(employee_id)+1 from emp1), "
					+ "?,?,sysdate,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getLastName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getLastName());
			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력.");
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
	

	public List<Employee> getEmpList() {
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
	            emp.setEmployeeId(rs.getInt("employee_id"));
	            emp.setFirstName(rs.getString("first_name"));
	            emp.setEmail(rs.getString("email"));
	            emp.setPhoneNumber(rs.getString("phone_number"));
	            emp.setHireDate(rs.getString("hire_date"));
	            emp.setJobId(rs.getString("job_id"));
	            emp.setSalary(rs.getInt("salary"));
	            emp.setCommissionPct(rs.getDouble("commission_pct"));
	            emp.setManagerId(rs.getInt("manager_id"));
	            emp.setLastName(rs.getString("last_name"));
	            emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
