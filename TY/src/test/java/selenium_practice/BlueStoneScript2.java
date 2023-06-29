package selenium_practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BlueStoneScript2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		String window=driver.getWindowHandle();
		Actions action=new Actions(driver);
		SoftAssert ast=new SoftAssert();
		driver.navigate().to("https://www.bluestone.com");
		
		driver.findElement(By.xpath("//span[@class='deny-btn']")).click();
		
		WebElement ring=driver.findElement(By.xpath("//ul[@class='wh-main-menu']/li/a[@title='Rings']"));
		action.moveToElement(ring).build().perform();
		
		driver.findElement(By.xpath("//div[text()='Popular Ring Types ']/../ul/li//a[text()='Engagement']")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.id("Price-form"))));
		WebElement price=driver.findElement(By.id("Price-form"));
		action.moveToElement(price).build().perform();
		
		WebElement f1=driver.findElement(By.xpath("//form[@id='price']/div/div/span[@data-displayname='rs 10000 to rs 20000']"));
		String fs1=f1.getText();
		f1.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Metal-form")));
		WebElement metal=driver.findElement(By.id("Metal-form"));
		action.moveToElement(metal).build().perform();
		
		WebElement f2=driver.findElement(By.xpath("//section[@id='Metal-form']//span[@data-displayname='gold']"));
		String fs2=f2.getText();
		f2.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Gold Purity']")));
		WebElement GoldPurity=driver.findElement(By.xpath("//span[text()='Gold Purity']"));
		action.moveToElement(GoldPurity).build().perform();
		
		WebElement f3=driver.findElement(By.xpath("//span[@data-displayname='18k']"));
		String fs3=f3.getText();
		f3.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hidden selectedTagCategory' and text()='Price']/following-sibling::span")));
		String f1s=driver.findElement(By.xpath("//span[@class='hidden selectedTagCategory' and text()='Price']/following-sibling::span")).getText();
		String f2s=driver.findElement(By.xpath("//span[@class='hidden selectedTagCategory' and text()='Metal']/following-sibling::span")).getText();
		String f3s=driver.findElement(By.xpath("//span[@class='hidden selectedTagCategory' and text()='Gold Purity']/following-sibling::span")).getText();
		
		ast.assertTrue(fs1.contains(f1s),"filter1");
		ast.assertTrue(fs2.contains(f2s), "filter2");
		ast.assertTrue(fs3.contains(f3s), "filter3");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-view-result']//div//div/div/a/img")));
		List<WebElement> products=driver.findElements(By.xpath("//div[@id='grid-view-result']//div//div/div/a/img"));
		
		System.out.println("****Products list****");
		for(WebElement p:products) {
			System.out.println(p.getAttribute("alt"));
		}
		
		WebElement product=driver.findElement(By.xpath("(//div[@id='grid-view-result']//li/div/div)[1]//img"));
		String pName=product.getAttribute("alt");
		String pPrice=driver.findElement(By.xpath("(//div[@id='grid-view-result']//li/div/div)[1]//span[@class='new-price']")).getText();
		
		product.click();
		
		Set<String> windows=driver.getWindowHandles();
		
		for(String w:windows) {
			if(!w.equalsIgnoreCase(window)) {
			driver.switchTo().window(w);
			}
		}
		
		
		String pName1=driver.findElement(By.xpath("//form[@id='buy_block']/h1[@class='title-5']")).getText();
		String pPrice1=driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();
		
		ast.assertTrue(pName.equalsIgnoreCase(pName1), "product name");
		ast.assertTrue(pPrice.contains(pPrice1), "price");
		
		
		driver.findElement(By.xpath("//span[@class='size-box-overlay']")).click();
		
		driver.findElement(By.xpath("//span[@class='size'][1]")).click();
		
		String pPrice2=driver.findElement(By.id("our_price_display")).getText();
		
		driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
		
		String pName3=driver.findElement(By.xpath("//div[@class='product-title col-xs-6']/a")).getText();
		String pPrice3=driver.findElement(By.xpath("//div[@class='new-price']")).getText();
		
		ast.assertTrue(pName1.equalsIgnoreCase(pName3), "Product Name");
		ast.assertTrue(pPrice3.contains(pPrice2), "Price"); 
		
		
		Select select=new Select(driver.findElement(By.xpath("//select")));
		select.selectByVisibleText("2");
		
		Thread.sleep(3000);
		String price4=driver.findElement(By.xpath("//div[@class='new-price']")).getText();
		ast.assertTrue(price4.contains("37,136"), "price after increase in QTY");
		
		driver.quit();
		
		ast.assertAll();

	}

}
