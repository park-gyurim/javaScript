package com.yedam.test;

public class Employee implements Comparable<Employee>{
	String first_name;
	int salary;

	public Employee(String first_name, int salary) {
		super();
		this.first_name = first_name;
		this.salary = salary;
	}

	public String getFirst_name() {
		return first_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [first_name=" + first_name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		  return this.salary - o.salary;
	}

}
