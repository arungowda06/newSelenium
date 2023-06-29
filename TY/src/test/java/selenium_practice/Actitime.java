package selenium_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Actitime {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		Actions act=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']/div[contains(.,'Login ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='addTasksLink']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='emptySelection' and text()='- Select Customer -']")).click();
		//driver.findElement(By.xpath("(//div[@class='itemRow cpItemRow '])[1]")).click();
		//driver.findElement(By.xpath("//div[@class='emptySelection']")).click();
		
		driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[1]")).sendKeys("abhi proj");
		driver.findElement(By.xpath("(//td[@class='estimateCell']/input[@class='inputFieldWithPlaceholder'])[1]")).sendKeys("1000000");
		driver.findElement(By.xpath("(//td[@class='deadlineCell deadlineNotSet']//button[@class='x-btn-text'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='ext-gen91']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Nov']")).click();
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tr[@class='x-date-mp-btns']//button[contains(text(),'OK')]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='29']")).click();
		driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
		
	}
	

}
