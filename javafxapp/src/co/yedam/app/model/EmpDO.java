package co.yedam.app.model;

public class EmpDO {
	private String employeeId;
	String lastName;
	String email;
	String hireDate;
	String jobId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getHireDate() {
		return hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	@Override
	public String toString() {
		return "EmpDO [employeeId=" + employeeId + ", lastName=" + lastName + ", email=" + email + ", hireDate="
				+ hireDate + ", jobId=" + jobId + "]";
	}
	
	
}
