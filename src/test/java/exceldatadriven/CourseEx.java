package exceldatadriven;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.RowId;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.IFactoryAnnotation;
import org.apache.poi.ss.usermodel.DataFormatter;

public class CourseEx {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		//Thread.sleep(2000);
		driver.findElement(By.id("downloadButton")).click();*/
		
		FileInputStream fs=new FileInputStream("C:\\Users\\Radhakrishna\\Downloads\\download.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fs);
		DataFormatter formatter = new DataFormatter();
		XSSFSheet sheet= book.getSheet("Sheet1");
		Iterator<Row> row =sheet.rowIterator();
		Row firstRow=row.next();
		Iterator<Cell> cells	=firstRow.cellIterator();
		int k=0;
		int column=0;
		while(cells.hasNext()) {
		Cell cellValue=	cells.next();
			if(cellValue.getStringCellValue().equalsIgnoreCase("Price")) {
				column=k;
			}
			k++;
		}
		System.out.println("Column Number :" + column);
		int j=1;
		while(row.hasNext()) {
			Row r= row.next();
			Iterator<Cell>  c= r.cellIterator();
			while(c.hasNext()) {
			String val	= formatter.formatCellValue(
				c.next());
			if(val.  equalsIgnoreCase("Apple")) {
					System.out.println("Row Number :" + j + val +r.getRowNum());
				}
			}
			j++;
			
			 
		}
		
		
		
		
		
		
		/******************************
		
		//upload
		WebElement upload=driver.findElement(By.id("fileinput"));
		upload.sendKeys("C:\\Users\\Radhakrishna\\Downloads\\download.xlsx");
		//toast message
		By toaster=By.cssSelector(".Toastify__toast-body div:nth-child(2");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toaster));
		//verifying message
		String toastMessage =driver.findElement(toaster).getText();
		System.out.println(toastMessage);
		Assert.assertEquals("Updated Excel Data Successfully.",toastMessage);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toaster));
		
	//  String priceC=	driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		
		String priceValue= driver.findElement(By.xpath("//div[contains(text(),'Apple')]/parent::div/parent::div/div[@id='cell-4-undefined']")).getText();
		System.out.println(priceValue);
		Assert.assertEquals("345", priceValue);
*/
	}

}
