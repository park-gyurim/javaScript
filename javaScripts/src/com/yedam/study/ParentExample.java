package com.yedam.study;

public class ParentExample {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.name = "hong";
		showInfo(new Parent() {
			int age;

			int getAge() {
				return age;
			}

			@Override
			String getName() {
				// TODO Auto-generated method stub
				String setName = ("Hwnag");
				return super.getName();
			}
		});
		EmpService empService = new EmpService() {
			@Override
			public void getEmployee(int empId) {
				System.out.println("empId: " + empId);
			}
		};
		getEmp(empService);
//	getEmp(new EmpService() {
//		@Override
//		public void getEmployee(int empId) {
//			
//		}
//	
//	});
}

	static void getEmp(EmpService emp) {
		emp.getEmployee(101);
	}

	static void showInfo(Parent p) {
		System.out.println(p.getName());
	}
}
