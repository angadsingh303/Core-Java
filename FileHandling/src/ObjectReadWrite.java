import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ITEmployee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private transient double salary; // It will not persist in the file
	ITEmployee(int id, String name, double salary){
		this.id=id;
		this.name=name;
		this.salary=salary;
		
	}
	@Override
public	String toString(){
		return "id "+id+" Name "+name+" Salary "+salary;
	}
}
public class ObjectReadWrite {

	public static void main(String[] args) throws IOException , ClassNotFoundException{
		// TODO Auto-generated method stub
		ITEmployee ram = new ITEmployee(1001, "Ram", 50000);
	//	System.out.println(ram);
		String path = "/home/angad/Documents/FileHandling/emp.dat";
		/*FileOutputStream fs = new FileOutputStream(path);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(ram);
		os.close();
		fs.close();
		System.out.println("Object Stored in File...");*/
		
		
		FileInputStream fi = new FileInputStream(path);
		ObjectInputStream oi = new ObjectInputStream(fi);
		ITEmployee emp =(ITEmployee)oi.readObject();
		System.out.println(emp);
		oi.close();
		fi.close();
	}

}
