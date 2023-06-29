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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static void main(String[] args) throws InterruptedException, AWTException {
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/softwares/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("laptop bags");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		List<WebElement> products = driver.findElements(By.xpath("//a[@class='IRpwTa']")); // div[@class='_2WkVRV\']
		System.out.println("***titles of all the products in page 1***");
		for (WebElement bags : products) {
			System.out.println(bags.getText());
		}

		String window = driver.getWindowHandle();

		products.get(9).click();

		Set<String> windows = driver.getWindowHandles();

		for (String w : windows) {
			if (!w.equalsIgnoreCase(window)) {
				driver.switchTo().window(w);
			}
		}

		System.out.println("***title of the selected product***");
		System.out.println(driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText());
		
		System.out.println("***price of the selected product***");
		System.out.println(driver.findElement(By.xpath("//div[@class=\"_30jeq3 _16Jk6d\"]")).getText());
		
		String pin="//input[@placeholder='Enter delivery pincode']";
		String check="//input[@placeholder='Enter delivery pincode']/following-sibling::span";

		driver.findElement(By.xpath(pin)).sendKeys("560119");

		driver.findElement(By.xpath(check)).click();

		WebElement message = driver.findElement(By.xpath("//div[@class='_12cXX4']"));

		System.out.println("***printing error message***");

		System.out.println(message.getText());
		
		message.click();
		
		driver.findElement(By.xpath(pin)).sendKeys("560091");
		driver.findElement(By.xpath(check)).click();

		System.out.println("***printing availability message***");

		WebElement message1=driver.findElement(By.xpath("//div[@class='_3XINqE']"));
		System.out.println(message1.getText());

		WebElement cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		
		
		  Robot robot=new Robot(); 
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_SUBTRACT); 
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_SUBTRACT);
		
		cart.click();

		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		
		driver.quit();
		
	

	}
}
