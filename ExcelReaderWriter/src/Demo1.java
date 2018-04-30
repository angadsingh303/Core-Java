import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo1 {
	/*static void readExcel() throws Exception{
		String path = "";
		FileOutputStream fs = new FileOutputStream(path);
	}*/
	static void readExcel() throws FileNotFoundException, IOException{
		String path="/home/angad/Desktop/projects/excelFile.xls";
		FileInputStream fi = new FileInputStream(path);
		HSSFWorkbook wb = new HSSFWorkbook(fi);
		//XSSFWorkbook 
		HSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows= sheet.rowIterator();
		while(rows.hasNext()){
			Row currentRow = rows.next();
			Iterator<Cell> cells = currentRow.cellIterator();
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){
					System.out.print(currentCell.getStringCellValue()+" ");
				}
				else
				if(currentCell.getCellType()==Cell.CELL_TYPE_NUMERIC){
					System.out.print(currentCell.getNumericCellValue()+" ");
					
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			readExcel();
		}
		
		
		catch(Exception e){
			System.out.println("ERROR !!");
		}
	}
	
	

}
