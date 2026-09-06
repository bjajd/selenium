package exceldatadriven;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;

import org.apache.poi.ss.format.CellFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.DataFormatter;

//to extract data from excel using data provider.
public class DataDrExc {
	
	@Test(dataProvider = "data")
	public void simpleTest(String name,String Data1,String data2,String data3) {
		System.out.println(name + Data1 + data2 + data3);
		System.out.println("output" + "\n");
		
	}
	
	// public static void main(String[] args) throws IOException {
	@DataProvider(name="data")
	public Object[][] getData() throws IOException {
	//FileInputStream fsi=new FileInputStream("C:\\Users\\Radhakrishna\\Downloads\\Book1.xlsx");
		
		DataFormatter formatter = new DataFormatter();
	FileInputStream fsi=new FileInputStream("C:\\Users\\Radhakrishna\\Downloads\\Book1.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(fsi);
	XSSFSheet sheet	=book.getSheetAt(0);
	int rowcount= sheet.getPhysicalNumberOfRows();
	System.out.println(rowcount);
	XSSFRow row1	=sheet.getRow(0);
	int	column= row1.getLastCellNum();
	Object data[][]=new Object[rowcount-1][column];
	for(int i=0;i<rowcount-1;i++) {
		XSSFRow row= sheet.getRow(i+1);
		for(int j=0;j<column;j++) {
		XSSFCell r=	row.getCell(j);
		//formatter.form
		 data[i][j]=formatter.formatCellValue(r);
		 System.out.println(data[i][j]);
		}
	}
	return data;

}}