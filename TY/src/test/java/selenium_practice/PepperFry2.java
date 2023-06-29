package selenium_practice;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PepperFry2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.pepperfry.com");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Scanner sc=new Scanner(System.in);
		Actions act=new Actions(driver);
		SoftAssert ast=new SoftAssert();
		String window=driver.getWindowHandle();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='notification-frame-b8a6a54b']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='close']")));
		
		WebElement furniture=driver.findElement(By.xpath("//a[@class='hd-menu-level-top font-heading' and contains(.,'Furniture' )]"));
		act.moveToElement(furniture).perform();
		
		String sofa3Seater="//li[@data-id='3 Seater Sofas']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sofa3Seater)));
		driver.findElement(By.xpath(sofa3Seater)).click();
		
		String Brand="//span[@class='ng-star-inserted' and text()='Brand']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Brand)));
		driver.findElement(By.xpath(Brand)).click();
		
		WebElement f1=driver.findElement(By.xpath("//label[@for='Casacraft from Pepperfry']"));
		String fs1=f1.getText();
		f1.click();
		
		WebElement material=driver.findElement(By.xpath("//h4[@class='panel-title']/accordion-heading[contains(text(),'Material')]"));
		js.executeScript("arguments[0].scrollIntoView();", material);
		material.click();
		WebElement f2=driver.findElement(By.xpath("//label[@for='Fabric']"));
		String fs2=f2.getText();
		f2.click();
		
		WebElement colorSwatch=driver.findElement(By.xpath("//h4[@class='panel-title']/accordion-heading[contains(text(),'Color Swatch')]"));
		colorSwatch.click();
		WebElement f3=driver.findElement(By.xpath("//label[contains(.,'Grey')]"));
		String fs3=f3.getText();
		f3.click();
		
		WebElement apply=driver.findElement(By.xpath("//span[@class='ng-star-inserted' and text()='APPLY']"));
		apply.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='pf-col xs-12 sm-12']//button/div/span/following-sibling::span[2]/preceding-sibling::span[1]")));
		List<WebElement> filters=driver.findElements(By.xpath("//div[@class='pf-col xs-12 sm-12']//button/div/span/following-sibling::span[2]/preceding-sibling::span[1]"));
		
		String f1s="";
		String f2s="";
		String f3s="";
		
		for(WebElement filter:filters) {
			if(filter.getText().contains("Casacraft from Pepperfry")) {
				String[] f=filter.getText().split(" ",3);
				for(String c:f) {
					if(c.equals("Casacraft from Pepperfry")) {
						f1s=c;
					}
				}
			}
			if(filter.getText().contains("Fabric")) {
				f2s=filter.getText().replace("Material : ", "");
			}
			if(filter.getText().contains("Grey")) {
				f3s=filter.getText().replace("Color Swatch : ", "");
			}
			
		}
		
		ast.assertEquals(fs1.equals(f1s), true);
		ast.assertEquals(fs2.equals(f2s), true);
		ast.assertEquals(fs3.equals(f3s), true);
		
		List<WebElement> products=driver.findElements(By.xpath("//div[@id='scroller']/div//h3"));
		List<WebElement> productsPrice=driver.findElements(By.xpath("//span[@class='product-offer-price font-bold text-xl']"));
		
		for(WebElement product:products) {
			System.out.println(product.getText());
		}
		String product=products.get(22).getText();
		System.out.println(product+"----->product");
		String productPrice=productsPrice.get(22).getText();
		System.out.println(productPrice+"----->productPrice");
		js.executeScript("arguments[0].click();", products.get(22));
		
		Set<String> windows=driver.getWindowHandles();	
		
		for(String w:windows) {
			if(!w.equals(window)) {
				driver.switchTo().window(w);
			}
		}
		Thread.sleep(2000);
		String title=driver.findElement(By.xpath("//h1[@class='color-tertiary text-lg font-medium']")).getText();
		String title00=title.replace(",", "");
		System.out.println(title+"----->title");
		String price=driver.findElement(By.xpath("//span[@class='font-bold text-lg color-primary ng-tns-c155-1']")).getText();
		String price00=driver.findElement(By.xpath("//span[@class='text-xxl font-bold ng-tns-c155-1']")).getText();  
		System.out.println(price+"----->price");
		
		String price000="";
		for(int i=0;i<price.length();i++) {
			if(Character.isDigit(price.charAt(i))) {
				price000+=price.charAt(i);
			}
		}
		int price0000=Integer.parseInt(price000);
		
		ast.assertTrue(product.equals(title00),"title");
		ast.assertTrue(productPrice.equals(price00), "price");
		
		
		System.out.println("***Enter 6 digit Pincode***");
		String pin=sc.next();
		WebElement enterPin=driver.findElement(By.name("pincode"));
		enterPin.sendKeys(pin);
		boolean flag=true;
		
		Thread.sleep(2000);
		while (flag==true) {	
		try {
			WebElement sMsg=driver.findElement(By.xpath("//div[@class='ng-star-inserted']/div[@class='vip-service-delivery']/span"));
			System.out.println(sMsg.getText());
			flag=false;
		}
		catch(Exception e) {
			WebElement errorMsg=driver.findElement(By.xpath("//div[@class='pf-col xs-12 vip-delivery-error-msg text-md font-medium ng-star-inserted']"));  //div[@class='vip-delivery-assembly ng-star-inserted']//div/div/following-sibling::div[@class='pf-col xs-12 vip-delivery-error-msg text-md font-medium ng-star-inserted']
			System.out.println(errorMsg.getText());
			Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Change']")));
		System.out.println("***Enter 6 digit Pincode***");
			pin=sc.next();
			enterPin.sendKeys(pin);
		}
		
		}
		
		driver.findElement(By.xpath("//section[@class='vip-product-feature-container']//div[@class='vip-cta-section-container']//span[text()='BUY NOW']")).click();
		
	    Thread.sleep(2000);
	
		String title1=driver.findElement(By.xpath("//h3[@class='ck-card-name text-md text-truncate']")).getText();
		WebElement pricePath=driver.findElement(By.xpath("(//span[@class='heading-lg'])[2]"));
		String price1=pricePath.getText();
		
		
		String price11="";
		for(int i=0;i<price1.length();i++) {
			if(Character.isDigit(price1.charAt(i))) {
				price11+=price1.charAt(i);
			}
		}
		int price111=Integer.parseInt(price11);
		
		ast.assertTrue(title00.equals(title1), "title 1");
		ast.assertTrue((price0000+949+749)==price111, "price 1");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select-btn text-sm ng-star-inserted']")));
		WebElement qty=driver.findElement(By.xpath("//button[@class='select-btn text-sm ng-star-inserted']"));
		qty.click();
		
		driver.findElement(By.xpath("//li[@data-value='3']")).click();
		Thread.sleep(2000);
		String price2=pricePath.getText();
		String price22="";
		for(int i=0;i<price2.length();i++) {
			if(Character.isDigit(price2.charAt(i))) {
				price22+=price2.charAt(i);
			}
		}
		int price222=Integer.parseInt(price22);
	
		ast.assertTrue(price222==(price111*3),"price 2");
		
		qty.click();
		driver.findElement(By.xpath("//li[@data-value='2']")).click();
		Thread.sleep(2000);
		String price3=pricePath.getText();
		
		String price33="";
		for(int i=0;i<price3.length();i++) {
			if(Character.isDigit(price3.charAt(i))) {
				price33+=price3.charAt(i);
			}
		}
		int price333=Integer.parseInt(price33);
		
		ast.assertTrue(price333==(price111*2),"price 3");
		
		driver.quit();
		
		System.out.println("******Script Finished******");
		
		ast.assertAll();
		
		
	}

}
