package co.yedam.app.model;

import javafx.beans.property.SimpleStringProperty;

public class OpservEmpDO {
	public SimpleStringProperty employeeId = new SimpleStringProperty();
	public SimpleStringProperty lastName = new SimpleStringProperty();
	public SimpleStringProperty email = new SimpleStringProperty();
	public SimpleStringProperty hireDate = new SimpleStringProperty();
	public SimpleStringProperty jobId = new SimpleStringProperty();
	
	public String getEmployeeId() {
	      return employeeId.get();
	   }

	   public void setEmployeeId(String employeeId) {
	      this.employeeId.set(employeeId);

	   }

	   public String getlastName() {
	      return lastName.get();
	   }

	   public void setlastName(String lastName) {
	      this.lastName.set(lastName);

	   }

	   public String getemail() {
	      return email.get();
	   }

	   public void setemail(String email) {
	      this.email.set(email);

	   }

	   public String gethireDate() {
	      return hireDate.get();
	   }

	   public void sethireDate(String hireDate) {
	      this.hireDate.set(hireDate);

	   }

	   public String getjobId() {
	      return jobId.get();
	   }

	   public void setjobId(String jobId) {
	      this.jobId.set(jobId);

	   }
}
