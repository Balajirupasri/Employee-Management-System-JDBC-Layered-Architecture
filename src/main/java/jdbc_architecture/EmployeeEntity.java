package jdbc_architecture;

public class EmployeeEntity {

	private int empid;
	private String name;
	private String dept;
	private int salary;
	private int age;

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptartment() {
		return dept;
	}
	public void setDeptartment(String deptartment) {
		this.dept = deptartment;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	}
