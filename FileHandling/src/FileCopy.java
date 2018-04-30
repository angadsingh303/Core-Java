import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileCopy {
	
	ArrayList<Character> arr = new ArrayList<>();
	void readFile() throws Exception {
		String path="/home/angad/Documents/FileHandling/demo";
		String path1="/home/angad/Documents/FileHandling/demo1";
		File file = new File(path1);
		file.createNewFile();
		FileOutputStream fo= new FileOutputStream(path1);
		FileInputStream fi = new FileInputStream(path);
		int read = fi.read();
		
		while(read!=-1){
			fo.write(read);
			read= fi.read();
			
		}
		System.out.println("Data Copied");
		fo.close();
		fi.close();
	}
	/*void writeFile() throws Exception{
	
		//String data = arr.toString();
		System.out.println(data);
		
		
		fo.write(data.getBytes());
		
		fo.close();
		System.out.println("Data Copied");
		
		
	}*/
	FileCopy(){
		try{
			readFile();
			/*writeFile();*/

		}
		catch(Exception e){ 
			System.out.println("Error");
		}
		
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	FileCopy f = new FileCopy();
	}

}
