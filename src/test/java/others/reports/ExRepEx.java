package others.reports;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExRepEx {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	ExtentReports extentReport;
	ExtentTest extentTest;
	ExtentSparkReporter extentSparkReporter;
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\testing-output\\report.html");
		extentReport=new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void testCreate(Method method) {
		extentTest=extentReport.createTest(method.getName());
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.pass("Test is passed"+  result.getMethod().getMethodName());
		}
		
		else if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.fail("Test is failed" + result.getThrowable());
			File screencapture= addScreenshot(driver);
			extentTest.addScreenCaptureFromPath(screencapture.getAbsolutePath());
			
		}
		
	}
	
	@AfterTest
	public void fin() {
		extentReport.flush();
	}




public File	addScreenshot(WebDriver driver) throws IOException{
	
	//	File fs	=	(TakesScreenshot)driver.get(OutputType<File>);
			File fs=		((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dstFile=new File (System.getProperty("user.dir")+"\\sc\\failure.png");
		FileUtils.copyFile(fs,dstFile );
		return dstFile;
	}

	@Test
	public void getTitle() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
	String title=	driver.getTitle();
	System.out.println(title + "Title");
	//	Assert.assertEquals("Amazon", title);
	Assert.assertTrue(title.contains("Amazontt"));
	}
}