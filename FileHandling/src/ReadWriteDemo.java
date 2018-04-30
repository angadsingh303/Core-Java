import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteDemo {

static  void WriteFile(){
	System.out.println("Enter the data to Write in a file");
	Scanner scanner = new Scanner(System.in);
	String data = scanner.nextLine();
	String path="/home/angad/Documents/FileHandling/demo";
	
	try{
		//FileOutputStream fo = new FileOutputStream(path)//writing data 
		FileOutputStream fo = new FileOutputStream(path,true);
		fo.write(data.getBytes());
		fo.close();
		System.out.println("Data Stored in a file");
		scanner.close();
	}
	catch(IOException e){
		e.printStackTrace();
		
	}
}
	
static	void ReadFile(){
		String path= "/home/angad/Documents/FileHandling/demo";
		final int EOF=-1;
		
		try{
			FileInputStream fi = new FileInputStream(path);
			int read = fi.read();//read a file
			while(read!=EOF){
				System.out.print((char)read);
				read=fi.read();
			}
			fi.close();
			//close a file
		}
		catch(IOException e){
			System.out.println("File does not exist"+e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WriteFile();
		ReadFile();
		
	}

}
