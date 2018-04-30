import java.io.File;
import java.io.FilenameFilter;

class MyFilter implements FilenameFilter{
 private String ext;
 MyFilter(String ext){
	 this.ext=ext;
 }
 
	@Override
	public boolean accept(File dir, String filename) {
		// TODO Auto-generated method stub
		return filename.toUpperCase().endsWith(ext.toUpperCase());
		
	}
	
}

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="/home/angad/Documents/FileHandling";
		File file = new File(path);
	//	file.mkdir(); //Single Directory
	//	file.mkdirs();//Nested Directory
		System.out.println("Directory Created");
		MyFilter myfilter = new MyFilter(".jpg");
		file.list(myfilter);
		File files [] = file.listFiles(myfilter); 
		for(File f : files){
			System.out.println(f.getName());
		}
		
	}

}
