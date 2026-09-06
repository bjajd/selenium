package testngp.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	
	@Test(priority='3',description =" descrition")
	public void Demo() {
		System.out.println("first execution 3");
	}
	
	public void methodWithoutAnnotation() {
		System.out.println("without Annotation");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test 1");
	}
	
	@AfterTest(enabled = false)
	public void afterTest() {
		System.out.println("after Test 5");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method 2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method 4");
	}
	
	
}
