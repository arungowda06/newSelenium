package selenium_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PepperFry1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.pepperfry.com");
		Actions act=new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='notification-frame-b8a6a54b']")));
		driver.findElement(By.xpath("//a[@class='close']")).click();
		
		List<WebElement> mainMenus=driver.findElements(By.xpath("//div[@class='hd-menu-wrapper']//a"));
		
		
		for(WebElement mainMenu:mainMenus) {
			Thread.sleep(2000);
			System.out.println("Main menu--->"+ mainMenu.getText());
			act.moveToElement(mainMenu).build().perform();
			Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='hd-menu-category-href-item hvr-pg-name cursor-pointer font-heading text-sm']/a")));
		List<WebElement> subMenus=driver.findElements(By.xpath("//li[@class='hd-menu-category-href-item hvr-pg-name cursor-pointer font-heading text-sm']/a"));
		for(WebElement subMenu:subMenus) {
			String sMenuName=subMenu.getText();
			System.out.println("Submenu--->" + sMenuName);
	
			List<WebElement> subSubMenus=driver.findElements(By.xpath("(//a[contains(text(),'"+sMenuName+"')])[1]/../following-sibling::li"));
			for(WebElement subSubMenu:subSubMenus) {
				System.out.println(subSubMenu.getText());
			}
		
		}
		
		}
		
		driver.quit();
	}
	

}
