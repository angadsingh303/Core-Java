class Employee{
	int x;
	Employee(){
		Dept e = new Dept();
		e.print();
	}
static class Job{
	static void show(){
		System.out.println("Show");
	}
}
	 class Dept{
		 void print(){
			 System.out.println("Dept print....");
		 }
	 }
}


public class ObjectCopyInFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee.Job.show();
		Employee.Dept d = new Employee().new Dept();
		d.print();
		Employee e = new Employee();
		
		
		//e.x=100;
		//Employee.Dept d = e.new Dept();
		//d.print();

	}

}
