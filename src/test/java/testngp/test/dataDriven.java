package testngp.test;

import java.awt.Window.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	//public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	
	public ArrayList<String> getData() throws IOException {
		
		FileInputStream fs=new FileInputStream("C:\\Users\\Radhakrishna\\Downloads\\Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		Integer sheets=  workbook.getNumberOfSheets();
		ArrayList<String> dataout=new ArrayList<>();
		
		 for(int i=0;i<sheets;i++) {
			 
			 if(workbook.getSheetName(i).equalsIgnoreCase("demodata")) {
				XSSFSheet sheet=  workbook.getSheetAt(i);
				
				Iterator<Row>  rows = sheet.iterator();//collection of rows
			    Row firstrow=rows.next();
			    Iterator<Cell> ce= firstrow.cellIterator();//collection of cell
			    int k=0;
			    int column=0;
			    while(ce.hasNext()) {
			    	Cell value= ce.next();
			    	if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
			    		//desired column
			    		column=k;
			    	}
			    	k++;
			    	
			    }System.out.println("index " + column);
			    
			   while(rows.hasNext()) {
				   
				 Row r=   rows.next();
				 if(r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase")) {
					 Iterator<Cell> rc= r.cellIterator();
					 while (rc.hasNext()) {
					Cell value	=rc.next();
					if(value.getCellType()==CellType.STRING) {
						dataout.add(value.getStringCellValue());
					}
					else {
				dataout.add(	NumberToTextConverter.toText(value.getNumericCellValue()));
					}
				//	System.out.println( rc.next().getStringCellValue());
				//	dataout.add(rc.next().getStringCellValue());
					
						
					}
				 }
			   }
			    
			  
			 }
		 }
		 return dataout;

	}

}
