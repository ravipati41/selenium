package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	 public static void setExcelFile(String Path,String SheetName) throws Exception{
		 FileInputStream ExcelFile=new FileInputStream(Path);
		 ExcelWBook=new XSSFWorkbook(ExcelFile);
		 ExcelWSheet=ExcelWBook.getSheet(SheetName);
		 
		 
	 }
	 public static String getCellData(int RowNum,int ColNum){
		 Cell=ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData= Cell.getStringCellValue();
		 return CellData;
	 }
public static void setCellData(String result,int RowNum,int ColNum) throws Exception{
	Row=ExcelWSheet.createRow(RowNum);
	Cell=Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
	if(Cell==null){
		Cell=Row.createCell(ColNum);
		Cell.setCellValue(result);
	}
	else{
		Cell.setCellValue(result);
	}
	

FileOutputStream fos=new FileOutputStream(Constant.Path_TestData+Constant.File_TestData);
ExcelWBook.write(fos);
fos.flush();
fos.close();
}
}
