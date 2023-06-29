package selenium_practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.Equals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaukariFresher {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		Robot robot=new Robot();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		
		if(driver.getTitle().equals("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com")) {
			System.out.println("Home Page displayed");
		}
		else {
			System.out.println("Home page not displayed");
		}
		driver.findElement(By.xpath("//a[@title='Jobseeker Register']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arun85878785@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Arun@123");
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9066650356");
		driver.findElement(By.xpath("//p[contains(text(),'I am a student')]")).click();
		//driver.findElement(By.xpath("//div[@class='textWrap']/p[contains(text(),'I have work experience (excluding internships)')]")).click();
		driver.findElement(By.xpath("//button[@class='uploadResume resman-btn-primary resman-btn-small']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='chip initialLocation-location  ' and text()='Bangalore/Bengaluru']")).click();
		StringSelection stringSelection=new StringSelection("C:\\Users\\Arun\\Downloads\\Resume_Arun M_.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
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
			if(driver.findElement(By.xpath("//h1[@class='global-title-1']")).getText().equals("Mention your education")) {
				System.out.println("Education details page displayed");
			}
		} catch (Exception e) {
			System.out.println("Education details page not displayed");
		}
        
        driver.findElement(By.xpath("//input[@name='course-suggestor']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown ']/li[@value='#2']")).click();
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
