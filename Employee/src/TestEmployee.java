import java.util.Scanner;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Id");
			int id=scanner.nextInt();
			System.out.println("Enter First Name");
			String firstName=scanner.next();
			System.out.println("Enter Last Name");
			String lastName=scanner.next();
			System.out.println("Enter Salary");
			double salary=scanner.nextDouble();
			System.out.println("Enter Bonus");
			float bonus=scanner.nextFloat();
			System.out.println("Enter Manager Name");
			String managerName=scanner.next();
			System.out.println("Enter e-mail");
			String email=scanner.next();
			System.out.println("Enter Phone");
			String phone=scanner.next();
			scanner.close();
			
			Employee Angad = new Employee(id,firstName,lastName,salary);
			 
		
	}
		
	

}
