import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Parent implements Serializable{
	int x;
	double y;
	Parent(){
		x=200;
		y=20; 
		System.out.println("Parent class def. cons. called...");
	}
	
}
class E implements Serializable{
	int T = 1000;
}
class Child extends Parent{
	int z;
	
	E obj = new E();// Has-A
	Child(){
		z=9000;
		System.out.println("Child class def cons called...");
	}
	
}
public class ISADemo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		Child child = new Child();
		child.x+=2;
		
		String path = "/home/angad/Documents/FileHandling/HeadFirstJava.pdf";
		FileOutputStream fs = new FileOutputStream(path);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(child);
		os.close();
		fs.close();
		System.out.println("Object stored in file");
		FileInputStream fi = new FileInputStream(path);
		ObjectInputStream oi = new ObjectInputStream(fi);
		Child childObject = (Child)oi.readObject();
		System.out.println(childObject.x+" "+childObject.y+" "+childObject.z);
		oi.close();
		fi.close();
		
		

	}

}
