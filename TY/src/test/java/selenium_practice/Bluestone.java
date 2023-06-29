package selenium_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Bluestone {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		driver.navigate().to("https://www.bluestone.com");
		
		driver.findElement(By.xpath("//span[@class='deny-btn']")).click();
		List<WebElement> menus=driver.findElements(By.xpath("//div[@class='bottom-header']//nav/ul/li"));
		for(WebElement menu:menus) {
			System.out.println("Main menu----->" + menu.getText());
			action.moveToElement(menu).build().perform();
			if(menu.getText().equalsIgnoreCase("WATCH JEWELLERY")) {
				List<WebElement> wjsmenus=driver.findElements(By.xpath("//div[@class='wh-submenu single-column-submenu width-auto']//a"));
				for(WebElement wjsmenu:wjsmenus) {
					System.out.println(wjsmenu.getText());
				}
			}
			else if (!menu.getText().equalsIgnoreCase("WATCH JEWELLERY") && !menu.getText().equalsIgnoreCase("10+1 MONTHLY PLAN"))  {
				List<WebElement> submenus=driver.findElements(By.xpath("//ul[@class=\"odd-even-bg\"]"));
				for(WebElement  submenu:submenus) {
					System.out.println(submenu.getText());
				}
			}
		}
		
		driver.quit();
		
		
		
	}

}
