package selenium_practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class FlipkartDay2Script2 {
public static void main(String[] args) throws InterruptedException, AWTException {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/softwares/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Actions action=new Actions(driver);
	Robot robot=new Robot();
	SoftAssert ast=new SoftAssert();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	driver.manage().window().maximize();
	driver.navigate().to("https://www.flipkart.com");
	String window=driver.getWindowHandle();
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	List<WebElement> menus=driver.findElements(By.xpath("//div[@class='eFQ30H']"));
	action.moveToElement(menus.get(2)).build().perform();
	List<WebElement> submenus=driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
	
	for(WebElement sub:submenus) {
		System.out.println("submenu name--->>   "+sub.getText());
		action.moveToElement(sub).build().perform();
		List<WebElement> subsub=driver.findElements(By.xpath("//div[@class='_3XS_gI']//a"));
	for(WebElement subsubs:subsub) { 
		  System.out.println(subsubs.getText()); 
		  }
	  }
	
	for(WebElement sub:submenus) {
		if(sub.getText().equalsIgnoreCase("Bags, Suitcases & Luggage")) {
		action.moveToElement(sub).build().perform();
		}
	}
	List<WebElement> subsub=driver.findElements(By.xpath("//a[.='Suitcases & Trolleys']"));   //div[@class='_2IjXr8']//a //div[@class='_3XS_gI']//a //a[.='Suitcases & Trolleys']
	for(WebElement subsubs:subsub) { 
		  if(subsubs.getText().equalsIgnoreCase("Suitcases & Trolleys")) {
			  action.moveToElement(subsubs).build().perform();
			  subsubs.click();
			 
		  }
		  }

	
	
	WebElement f1=driver.findElement(By.xpath("//div[@class='_3879cV' and text()='AMERICAN TOURISTER']"));
	f1.click();
	
	Thread.sleep(5000);
	
	String f2s="";
	String f3s="";
	
	
	List<WebElement> f=driver.findElements(By.xpath("//div[@class='_2gmUFU _3V8rao']"));
	
	for(WebElement fs:f) {

			if(fs.getText().equalsIgnoreCase("Body Type")) {
			js.executeScript("arguments[0].scrollIntoView(true);", fs);
			js.executeScript("arguments[0].click();", fs);
			WebElement f2=driver.findElement(By.xpath("//div[@class='_3879cV' and contains(.,'Hard Body')]"));
			f2s=f2.getText();
			js.executeScript("arguments[0].click();", f2);
			Thread.sleep(5000);
		}
		
			if(fs.getText().equalsIgnoreCase("Type")) {
			js.executeScript("arguments[0].scrollIntoView(true);", fs);
			js.executeScript("arguments[0].click();", fs);
			WebElement f3=driver.findElement(By.xpath("//div[@class='_3879cV' and contains(.,'Cabin Suitcase')]"));
			f3s=f3.getText();
			js.executeScript("arguments[0].click();", f3);
			Thread.sleep(5000);
			}
		}
	
		
		String fs1="";
		String fs2="";
		String fs3="";
	
		List<WebElement> filterlist=driver.findElements(By.xpath("//div[@class='_3sckoD']"));
		for(WebElement fl:filterlist) {
			if(fl.getText().equalsIgnoreCase("AMERICAN TOURISTER")){
				fs1=fl.getText();
			}
			if(fl.getText().equalsIgnoreCase("Hard Body")){
				fs2=fl.getText();
			}
			if(fl.getText().equalsIgnoreCase("Cabin Suitcase")){
				fs3=fl.getText();
			}
		}
		
		
		ast.assertEquals(fs1, f1.getText(), "filter 1 matches--->> pass");
		ast.assertEquals(fs2, f2s, "filter 2 matches--->> pass");
		ast.assertEquals(fs3, f3s, "filter 3 matches--->> pass");
		ast.assertAll();
		
	List<WebElement> products=driver.findElements(By.xpath("//div[@class='_2WkVRV']/../a[1]"));
		
	for(WebElement product:products) {
		System.out.println(product.getText());
	}
	
	List<WebElement> prices=driver.findElements(By.xpath("//div[@class='_30jeq3']"));
	
	String productName=products.get(5).getText();
	String productPrice=prices.get(5).getText();
	
	products.get(5).click();
	
	Set<String> windows=driver.getWindowHandles();
	
	for (String w : windows) {
		if (!w.equalsIgnoreCase(window)) {
			driver.switchTo().window(w);
		}
	}
	
	String productName1=driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
	String productPrice1=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
	
	System.out.println(productName1);
	System.out.println(productName);
	System.out.println(productPrice1);
	
	
	  ast.assertEquals(productName.contains("Small Cabin Suitcase (56 cm) - AMT HAMILTON PLUS SP55CM"), productName1.contains("Small Cabin Suitcase (56 cm) - AMT HAMILTON PLUS SP55CM"));
	  ast.assertEquals(productPrice, productPrice1, "Price matches--->> pass");
	  ast.assertAll();
	 
	
	driver.findElement(By.xpath("//div[@class='ffYZ17 _3DM78Z col col-12-12'][2]//li[1]")).click();
	driver.findElement(By.xpath("//div[@class=\"ffYZ17 _3DM78Z col col-12-12\"][3]//li")).click();
	
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_SUBTRACT); 
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_SUBTRACT);
	  
	  WebElement cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
	  cart.click();
	  
	  String productName2=driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
	  String productPrice2=driver.findElement(By.xpath("//span[@class=\"_2-ut7f _1WpvJ7\"]")).getText();
	  
	  ast.assertEquals(productName1.contains("BMT HAMILTON PLUS SP55CM"), productName2.contains("AMT HAMILTON PLUS SP55CM"));
	  ast.assertEquals(productPrice1, productPrice2, "Price matches--->> pass");
	  
	  System.out.println(productName2);
	  System.out.println(productPrice2);
	  
	  driver.findElement(By.xpath("//button[@class=\"_23FHuj\"][2]")).click();
	  Thread.sleep(5000);
	  
	  String productPrice3=driver.findElement(By.xpath("//span[@class=\"_2-ut7f _1WpvJ7\"]")).getText();
	  System.out.println(productPrice3);
	  ast.assertEquals(productPrice3.contains("6,798"), true);
	
	  driver.quit();
	  ast.assertAll();
}

}
