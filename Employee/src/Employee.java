import java.util.Scanner;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private float bonus;
	private String COMPANY_NAME;
	private String managerName;
	private String deptName;
	private String email;
	private String phone;
	private int pf;
	private double hra(){
	return 0.30*salary;
	};
	private double da(){
	return 0.20*salary;
	};
	private double ta(){
	return 0.10*salary;
	}
	private float netsalary;
	
	Employee(){
		pf=900;
		
		COMPANY_NAME ="Brain Mentors";
	}
	
	Employee(int id , String firstName, String lastName, double salary){
		this();
		this.id = id;
		this.firstName = firstName;
		this.lastName=lastName;
		this.salary = salary;

	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	private double netSalary(){
		return salary + hra() + ta() + da() - pf;
	}
	void salarySlip(){
		System.out.println("SALARY SLIP !");
		System.out.println("ID "+id);
		System.out.println("Name"+firstName+" "+lastName);
		
		System.out.println();
		System.out.println("HRA of salary is "+hra());
		System.out.println("TA of salary is "+ta());
		System.out.println("DA of salary is "+da());
		System.out.println("Net Salary is "+netSalary());
		
		
	}
	
	

}
