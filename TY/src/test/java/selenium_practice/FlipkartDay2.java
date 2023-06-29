package selenium_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartDay2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		List<WebElement> menus=driver.findElements(By.xpath("//div[@class='eFQ30H']"));  
		
		
		  for(WebElement menu:menus) {
		  System.out.println("menu name-->  "+menu.getText());
		  action.moveToElement(menu).build().perform(); 
		  List<WebElement> submenus=driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		  if(submenus.size()>0) {
		  for(WebElement sub:submenus) { 
			  System.out.println(sub.getText()); 
			  }
		  }
		  
		  }
		 
		System.out.println("****script finished****");
		 
		driver.quit();
		
		
		
	}

}
