package testngp.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Streams;

public class DropdownEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		//Search and Select
		/*
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ap");
		Thread.sleep(2000);
		List<WebElement> items= driver.findElements(By.xpath("//div[contains(@class,'left-pane-results-container')]/div"));
				//div[@class='left-pane-results-container']/div"));
		System.out.println(items.size());
	/*	for(WebElement item:items ) {
			System.out.println(item.getText());
			if(item.getText().equalsIgnoreCase("apple 17")) {
			
				item.click();
				break;
				//item.findElement(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']")).click();
				//div[@class='left-pane-results-container']/div/div[@class='s-suggestion s-suggestion-ellipsis-direction']
			}
		}*/
	/*	int i=1;
		while(i!=0) {
		String nameString=	items.get(i).getText();
		if(nameString.equalsIgnoreCase("apple 17")) {
			items.get(i).click();
			break;
		}
			i++;
		}
		
	//	items.stream().filter(item->item.getText().equalsIgnoreCase("apple 17")).findFirst().ifPresent(item->item.click());
	List<String> stringws=	items.stream().map(item->item.getText()).collect(Collectors.toList());
	System.out.println(stringws);
*/
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.className("icp-nav-link-inner"))).perform();
		List<WebElement> languages =
		        driver.findElements(By.xpath("//span[contains(@class,'a-label')]"));
		System.out.println(languages);
		
}}
