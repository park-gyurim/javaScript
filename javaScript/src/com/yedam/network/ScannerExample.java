package com.yedam.network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
	private String firstName;
	private int salary;

	public Employee() {
	}

	public Employee(String firstName, int salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;

	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", salary=" + salary + "]";
	}

}

public class ScannerExample {
	static List<Employee> list = new ArrayList<>();

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void inputEmp(Employee emp) {
		// list.add(emp);
		Connection con = getConnection();
		String sql = "insert into emps values(?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setInt(2, emp.getSalary());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력돰");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Employee> getEmpList() {
		Connection con = getConnection();
		String sql = "select first_name, salary from emps";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getString("first_name"), rs.getInt("salary")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return list;
		return list;
	}

	public static void delEmpList(String name) {
		Connection con = getConnection();
		String sql = "delete from emps where first_name = ? ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			int r = pstmt.executeUpdate();
			System.out.println("삭제됨");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) {
		Employee emp = new Employee("Hwang", 1000);
		list.add(emp);
		list.add(new Employee("Hwang", 2000));

		Scanner scn = new Scanner(System.in);
		int menu;
		while (true) {
			System.out.println("1:입력, 2:출력, 3:삭제, 4:종료");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("이름입력: ");
				String name = scn.nextLine();
				System.out.println("연봉입력: ");
				int salary = scn.nextInt();
				Employee emps = new Employee(name, salary);
				inputEmp(emps);
			} else if (menu == 2) {
				List<Employee> returnList = getEmpList();
				for (Employee emps : returnList) {
					System.out.println(emps);
				}
			} else if (menu == 3) {
				System.out.println("삭제할 이름?>");
				String name = scn.nextLine();
				delEmpList(name);
			} else if (menu == 4) {
				break;
			}
		}
	}
}