package RFQaproval;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RFQ.step1;

public class aprooval {
	WebDriver driver=new ChromeDriver();
	@BeforeClass
	void setup()
	{
		
		driver.get("https://training1.effigo.in/upeg/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void Login()
	{
		driver.findElement(By.xpath("//input[@id=\"userNameId\"]")).sendKeys("Janu123");
		driver.findElement(By.xpath("//input[@id=\"passwordId\"]")).sendKeys("Bob@1234");
		driver.findElement(By.xpath("//input[@id=\"sighInId\"]")).click();
		
	}
	
	@Test(priority=2)
	void sourcing()  
	{
		driver.findElement(By.cssSelector("a[href='getTenderCreatorHomePage']")).click();
	}
	
	@Test(priority=3)
	void createRFQ()
	{
		driver.findElement(By.xpath("//b[normalize-space()='CREATE RFQ']")).click();
	}
	
	@Test(priority=4)
	void basicInfo()
	{
		driver.findElement(By.xpath("//input[@name='tenderTitle']")).sendKeys("jagu");
		driver.findElement(By.xpath("//select[@name='tenderCurrency']")).click();//to select currency
		driver.findElement(By.xpath("//option[ @value='CURRENCY-1e6518-04-02-2025-01']")).click();//selecting INR
		driver.findElement(By.xpath("//select[@name='departmentId']")).click();//selecting business unit
		driver.findElement(By.xpath("//option[text()='Construction']")).click();//selecting construction
		WebElement location=driver.findElement(By.xpath("//select[@name='locations']"));
		Select op=new Select(location);
		List<WebElement> options=op.getOptions();
		for(int i=0;i<options.size();i++)
		{
			if(options.get(i).getText().equals("Danapur"))
			{
				options.get(i).click();
			}
		}
//		driver.findElement(By.xpath("//option[text()='Danapur']")).click();//selecting donapur
		driver.findElement(By.xpath("//button[text()='Proceed to Add Work Item']")).click();//proceed to add to work item
	}
	
	@Test(priority=5)
	void iteminfo() throws InterruptedException
	{
		driver.findElement(By.xpath("//label[text()='Only Commercial']")).click();//selecting only commercial
		driver.findElement(By.xpath("//input[@name='estimateValue']")).sendKeys("10000");
		driver.findElement(By.xpath("//button[text()='Add Items']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Please enter item code']")).sendKeys("%");
		driver.findElement(By.xpath("//button[@id='itemsSearch']")).click();
		driver.findElement(By.xpath("//input[@value='IT-acdd9d-24-02-2025-09']")).click();//selecting items
		driver.findElement(By.xpath("//input[@value='IT-0497af-10-02-2025-04']")).click();
		driver.findElement(By.xpath("//button[@onclick='addItemsTemporarily()']")).click();//click add
		driver.findElement(By.xpath("//button[@onclick=\"closeModal()\"]")).click();//click close
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"subItemQuantity_1\"]")).sendKeys("100");
		driver.findElement(By.xpath("//textarea[@id=\"descriptions_1\"]")).sendKeys("Item1");
		driver.findElement(By.xpath("//input[@id=\"subItemQuantity_2\"]")).sendKeys("200");
		driver.findElement(By.xpath("//textarea[@id=\"descriptions_2\"]")).sendKeys("Item2");
		driver.findElement(By.xpath("//button[@onclick=\"goToFee();\"]")).click();
	}
	@Test(priority=6)
	void priceLabels() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()=\"Add Template\"]")).click();
		Alert al=driver.switchTo().alert();
		al.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"PR_COMP_US_TMP_ID-79ab-10-04-2025-68\"]")).click();//adding template
		
		driver.findElement(By.xpath("//button[@id=\"price_template_save\"]")).click();
		
		driver.findElement(By.xpath("//button[@id=\"savePriceLable\"]")).click();
		driver.findElement(By.xpath("//button[text()=\" Search Suppliers \"]")).click();
		driver.findElement(By.xpath("//input[@name=\"searchedString\"]")).sendKeys("ABC123");
		driver.findElement(By.xpath("//button[text()=\" Search\"]")).click();
		driver.findElement(By.xpath("//a[@id=\"anchorTag_0\"]")).click();
		driver.findElement(By.xpath("//a[@id=\"anchorTag_1\"]")).click();
		driver.findElement(By.xpath("//button[@onclick=\"addSupplier();\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement cl=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Close')])[8]")));
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()", cl);
		cl.click();
				
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary SaveAndAddBtn\"]")).click();
		
		driver.findElement(By.xpath("//input[@onclick=\"return getDates();\"]")).click();
	}
	
	@Test(priority=7)
	void dates()
	{
		driver.findElement(By.xpath("//input[@name=\"startBidSubmissionDate\"]")).sendKeys("11-04-2025 12:14:00");
		driver.findElement(By.xpath("//input[@name=\"endBidSubmissionDate\"]")).sendKeys("11-04-2025 12:15:00");
		driver.findElement(By.xpath("(//button[text()='Submit'])[4]")).click();
		
	}
	@Test(priority=8)
	
	void summary()
	{
		driver.findElement(By.xpath("//textarea[@id=\"comments\"]")).sendKeys("finished");
		driver.findElement(By.xpath("(//button[text()='Submit'])")).click();
		Alert al1=driver.switchTo().alert();
		al1.accept();
	}
@Test(priority=9)
	
	void liverfq()
	{
	driver.findElement(By.xpath("(//a[text()='View'])[1]")).click();
	driver.findElement(By.xpath("//button[text()='Raise Addendum']")).click();
	driver.findElement(By.xpath("//label[@for='Dates']")).click();
	driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	driver.findElement(By.xpath("//textarea[@id=\"comment\"]")).sendKeys("hehe");
	driver.findElement(By.xpath("//button[text()='Raise Addendum']")).click();
	driver.findElement(By.xpath("//button[text()='Close']")).click();
	}
	
@Test(priority=10)
void Login1()
{
	driver.get("https://training1.effigo.in/portal/");
	driver.findElement(By.xpath("//input[@id=\"userNameId\"]")).sendKeys("janhavikp@gmail.com");
	driver.findElement(By.xpath("//input[@id=\"passwordId\"]")).sendKeys("Bob@1234");
	driver.findElement(By.xpath("//input[@id=\"sighInId\"]")).click();
	
}
@Test(priority=11)
void New() throws InterruptedException
{
	Alert al4=driver.switchTo().alert();
	al4.accept();
	driver.findElement(By.xpath("(//div[@class=\"text-warning small\"])[2]")).click();
	//Thread.sleep(20000);
//	driver.findElement(By.xpath("//tbody//tr//td[text()='jagu']/../td[4]//a")).click();
	
	
	        WebElement elementToClick = driver.findElement(By.xpath("//tbody//tr//td[text()='jagu']/../td[4]//a"));

	        // Set the target time (e.g., 3:15 PM)
	        LocalTime targetTime = LocalTime.of(12, 14); // 3:15 PM

	        // Get current time
	        LocalTime now = LocalTime.now();

	        // If current time is before target time, wait
	        if (now.isBefore(targetTime)) {
	            Duration duration = Duration.between(now, targetTime);
	            long millisToWait = duration.toMillis();

	            System.out.println("Waiting until " + targetTime + " to click the element...");
	            Thread.sleep(millisToWait);
	        }

	        // Now click the element
	        elementToClick.click();
	        System.out.println("Element clicked at: " + LocalTime.now());

	    
	

    driver.findElement(By.xpath("//label[@for=\"check0\"]")).click();
	driver.findElement(By.xpath("//label[@for=\"terms\"]")).click();
	//driver.findElement(By.xpath("//button[text()='Accept']")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept']"))).click();
	driver.findElement(By.xpath("//button[text()='Yes']")).click();
	driver.findElement(By.xpath("//button[text()='Proceed To Price Bid']")).click();
	
}

@Test(priority=12)
void pricebidSubmission() throws InterruptedException
{
	
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("3000");
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("2");
    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("5000");
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("3");
    driver.findElement(By.xpath("//button[@id='calc_total']")).click();
    driver.findElement(By.xpath("//button[@id=\"submit_123\"]")).click();
    driver.findElement(By.xpath("//button[text()='Proceed To Final Bid']")).click();
    driver.findElement(By.xpath("//input[@id='termsConditions']")).click();
    driver.findElement(By.xpath("(//button[text()='Close'])[2]")).click();
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
    driver.findElement(By.xpath("//button[@id='closeBtn']")).click();
}
	@Test(priority=13)
	void upeg() throws InterruptedException
	{
		driver.get("https://training1.effigo.in/upeg/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href=\"getTenderCreatorHomePage\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Live RFQ's\"]")).click();
		driver.findElement(By.xpath("(//a[@title=\"View\"])[1]")).click();
		Thread.sleep(33000);
		driver.findElement(By.xpath("//a[@onclick=\"viewEval();\"]")).click();
		
		driver.findElement(By.xpath("//a[@onclick=\"startCommercial('3');\"]")).click();
		Alert ale=driver.switchTo().alert();
		ale.accept();
		driver.findElement(By.xpath("(//span[@class=\"fa fa-thumbs-up\"])[2]")).click();
		driver.findElement(By.xpath("//textarea[@id=\"priceAcceptComments\"]")).sendKeys("approved");
		driver.findElement(By.xpath("//button[@id=\"priceAcceptBtn\"]")).click();
		Alert ale1=driver.switchTo().alert();
		ale1.accept();
		
	}
	/*
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}*/
}





