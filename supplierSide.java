package RFQ;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class supplierSide {
	WebDriver driver;
	@BeforeClass
	void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://training1.effigo.in/portal");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void Login()
	{
		step1 lp=new step1(driver);
		lp.setUserName("janhavikp@gmail.com");
		lp.setPassword("Bob@1234");
		lp.clickLogin();
		
	}
	@Test(priority=2)
	void New()
	{
		Alert al4=driver.switchTo().alert();
		al4.accept();
		driver.findElement(By.xpath("(//div[@class=\"h5 mb-0 font-weight-bold text-black-50\"])[2]")).click();
		driver.findElement(By.xpath("//a[@title=\"View All Work Items\"]")).click();
		driver.findElement(By.xpath("//label[@for=\"check0\"]")).click();
		driver.findElement(By.xpath("//label[@for=\"terms\"]")).click();
		//driver.findElement(By.xpath("//button[text()='Accept']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept']"))).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed To Price Bid']")).click();
		
	}
	
	@Test(priority=3)
	void pricebidSubmission() throws InterruptedException
	{
		driver.findElement(By.xpath("(//input[@loopindex=\"0\"])[1]")).sendKeys("200");
		driver.findElement(By.xpath("(//input[@loopindex=\"1\"])[1]")).sendKeys("2");
		driver.findElement(By.xpath("(//input[@loopindex=\"1\"])[2]")).sendKeys("20");
		driver.findElement(By.xpath("(//input[@name=\"hsnCodes\"])[1]")).sendKeys("2424");
		
		driver.findElement(By.xpath("(//input[@loopindex=\"0\"])[2]")).sendKeys("250");
		driver.findElement(By.xpath("(//input[@loopindex=\"1\"])[3]")).sendKeys("2");
		driver.findElement(By.xpath("(//input[@loopindex=\"1\"])[4]")).sendKeys("20");
		driver.findElement(By.xpath("(//input[@name=\"hsnCodes\"])[2]")).sendKeys("2424");
		
		driver.findElement(By.xpath("//textarea[@name=\"comments\"]")).sendKeys("item1");
		driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Submit Price Bid']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed To Final Bid']")).click();
		
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("(//button[@class=\"btn btn-default\"])[1]")).click();
		driver.findElement(By.xpath("//button[@id=\"cnfNSubmit\"]")).click();
	}
	
	
}
