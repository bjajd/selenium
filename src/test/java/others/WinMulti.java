package others;

import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WinMulti {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
	 List<WebElement> list	=driver.findElements(By.xpath( "//div[contains(@class,'navFooterLinkCol')][1]//li//a"));
	 String parentwindow=driver.getWindowHandle();
	 
	 /* USING NORMAL FOR LOOP AND NEW WINDOW TYPE
	 for(int i=0;i<list.size();i++) {
		String url= list.get(i).getAttribute("href");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
	//	 list.get(i).click();
		 
		System.out.println( driver.getTitle());
		//driver.navigate().back();
	driver.switchTo().window(parentwindow);
	 }
	 driver.switchTo().window(parentwindow);
	 
	  
	  */
	 
	 
	 //USING ACTIONS
	// Actions a=new Actions(driver);
	 for(WebElement e:list) {
		// a.keyDown(Keys.CONTROL).click(e).keyUp(Keys.CONTROL).perform();
		 e.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
	 }
	 
	 Set<String> w=driver.getWindowHandles();
	 Iterator<String> i=w.iterator();
	 while(i.hasNext()) {
		String id= i.next();
		driver.switchTo().window(id);
	System.out.println(driver.getTitle());
	 }
	 System.out.println(w.size());
	}

}
