import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sourcePath = "/home/angad/Documents/FileHandling/HeadFirstJava.pdf";
		String targetPath = "/home/angad/Documents/FileHandling/HeadFirstJavaCopy.pdf";
		 File file = new File(sourcePath);
		 File targetFilePath = new File(targetPath);
		 System.out.println("Copy Start.......");
		 if(file.exists()){
			 // File copy code
			FileInputStream fi = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(fi,20000);//for very much higher transfer rate
			FileOutputStream fo = new FileOutputStream(targetFilePath);
			BufferedOutputStream bout = new BufferedOutputStream(fo,20000);//for very much higher transfer rate
			long startTime= System.currentTimeMillis();
			int readByte = fi.read();
			while(readByte!=-1){
				bout.write(readByte);
				readByte = bin.read(); 
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Total time taken "+(endTime-startTime)+"ms");
			bin.close();
			bout.close();
			fi.close();
			fo.close();
			
		 }
		 else{
			 System.out.println("File not Found");
		 }

	}
	

}
