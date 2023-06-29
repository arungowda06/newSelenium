package selenium_practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaukariExperienced {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		Robot robot=new Robot();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions act=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		
		if(driver.getTitle().equals("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com")) {
			System.out.println("Home Page displayed");
		}
		else {
			System.out.println("Home page not displayed");
		}
		driver.findElement(By.xpath("//a[@title='Jobseeker Register']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arun89974657577649@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Arun@123");
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("8247269816");
		driver.findElement(By.xpath("//p[contains(text(),'I am a student')]")).click();
		driver.findElement(By.xpath("//div[@class='textWrap']/p[contains(text(),'I have work experience (excluding internships)')]")).click();
		//driver.findElement(By.xpath("//button[@class='uploadResume resman-btn-primary resman-btn-small']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[@class='chip initialLocation-location  ' and text()='Bangalore/Bengaluru']")).click();
		StringSelection stringSelection=new StringSelection("C:\\Users\\Arun\\Downloads\\Resume_Arun M_.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        try {
			if(driver.findElement(By.xpath("//h1[@class='global-title-1']")).isDisplayed()) {
				System.out.println("OTP verification page displayed");
			}
		} catch (Exception e) {
			System.out.println("OTP verification page not displayed");
		}
        
        Thread.sleep(20000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']")));
        driver.findElement(By.xpath("//button[@type='button']")).click();
        
        Thread.sleep(2000);
        try {
			if(driver.findElement(By.xpath("//h1[@class='global-title-1']")).getText().equals("Add your employment")) {
				System.out.println("Add your employment page displayed");
			}
		} catch (Exception e) {
			System.out.println("Add your employment page not displayed");
		}
        
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='no']")));
        
        driver.findElement(By.xpath("//input[@id='year']")).click();
        driver.findElement(By.xpath("//li[@aria-label='1 Year']")).click();
        driver.findElement(By.xpath("//input[@id='month']")).click();
        driver.findElement(By.xpath("//li[@aria-label='2 Months']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Eg. Amazon']")).sendKeys("Test Yantra");
        act.sendKeys(Keys.ARROW_DOWN).perform();
        act.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//input[@placeholder='Eg. Software Developer']")).sendKeys("Software Engineer");
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_DOWN).perform();
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Bangalore/Bengaluru']")));
        driver.findElement(By.xpath("//input[@id='workingFrom']")).click();
        driver.findElement(By.xpath("//span[text()='Jan']")).click();
        driver.findElement(By.xpath("//span[text()='2021']")).click();
        driver.findElement(By.xpath("//input[@id='workingTill']")).click();
        driver.findElement(By.xpath("//span[text()='Jan']")).click();
        driver.findElement(By.xpath("//span[text()='2023']")).click();
        driver.findElement(By.xpath("//input[@id='salaryInp']")).sendKeys("300000");
        driver.findElement(By.xpath("//a[text()='15 Days or less']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Key skills are crucial for recruiters to hire you']")).sendKeys("Software testing");
        act.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//input[@id='industry']")).sendKeys("it");
        act.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("qa");
        act.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//input[@id='roleCategory']")).sendKeys("quality");
        act.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//input[@id='role']")).sendKeys("automation");
        act.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//button[@class='submitbtn resman-btn-primary resman-btn-regular']")).click();
        
        Thread.sleep(2000);
        
        try {
			if(driver.findElement(By.xpath("//h1[@class='global-title-1']")).getText().equals("Mention your education")) {
				System.out.println("Education details page displayed");
			}
		} catch (Exception e) {
			System.out.println("Education details page not displayed");
		}
        
        driver.findElement(By.xpath("//span[text()='Graduation/Diploma']")).click();
        driver.findElement(By.xpath("//span[text()='B.Tech/B.E.']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/input[@name='course-suggestor']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@value='#2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='institute-suggestor']")).sendKeys("sapthagiri college of engineering");
        act.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='year-input resman-input resman-input-default resman-input-normal resman-input-number']/div/input")).sendKeys("2018");
        driver.findElement(By.xpath("//input[@class=\"suggestor-input \"]")).sendKeys("Software Testing");
        driver.findElement(By.xpath("//div[@title='Software Testing']")).click();
        driver.findElement(By.xpath("//button[text()='Save and continue']")).click();
        
        Thread.sleep(2000);
        try {
			if(driver.findElement(By.xpath("//h1[@class='global-title-1']")).getText().equals("Add headline & preferences")) {
		
				System.out.println("Headline and Preference page displayed");
			}
		} catch (Exception e) {
			System.out.println("Headline and Preference page not displayed");
		}
		
        
        driver.findElement(By.xpath("//textarea[@id=\"resumeHeadline\"]")).sendKeys("A joob seeker in Bangalore");
        driver.findElement(By.xpath("//span[@class='cityTagLabel' and text()='Bangalore/Bengaluru']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Eg. 5,64,000']")).sendKeys("100000");
        driver.findElement(By.xpath("//span[@data-item='M']")).click();
        driver.findElement(By.xpath("//button[@id='additionalDetailSubmit']")).click();
        
        Thread.sleep(2000);
        
        if(driver.getTitle().equals("Home | Mynaukri")) {
			System.out.println("Home Page displayed");
		}
		else {
			System.out.println("Home page not displayed");
		}
        
		
	
	}


}
