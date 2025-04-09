package evaluationAprooval;
import java.time.LocalTime;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RFQ.step1;

public class EvaluateAprooval {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(500));
	@BeforeClass
	void setup1()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://training1.effigo.in/upeg");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void Login()
	{
		main lp=new main(driver);
		lp.setUserName("Jea123");
		lp.setPassword("Bob@1234");
		lp.clickLogin();
		
	}
	
	@Test(priority=2)
	void sourcing1()
	{
		driver.findElement(By.cssSelector("a[href='getTenderCreatorHomePage']")).click();
	}
	
	@Test(priority=3)
	void createRFQ1()
	{
		driver.findElement(By.xpath("//b[normalize-space()='CREATE RFQ']")).click();
	}
	
	@Test(priority=4)
	void basicInfo1()
	{
		driver.findElement(By.xpath("//input[@name='tenderTitle']")).sendKeys("JANHAVI1");
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
		driver.findElement(By.xpath("//label[text()='Evaluation → Approval']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed to Add Work Item']")).click();//proceed to add to work item
	}
	
	@Test(priority=4)
	void iteminfo1() throws InterruptedException
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
	@Test(priority=5)
	void priceLabels1() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()=\"Add Template\"]")).click();
		Alert al=driver.switchTo().alert();
		al.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"PR_COMP_US_TMP_ID-d0ea-26-03-2025-57\"]")).click();//adding template
		
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
	
	@Test(priority=6)
	void dates1()
	{
		driver.findElement(By.xpath("//input[@name=\"startBidSubmissionDate\"]")).sendKeys("09-04-2025 16:34:00");
		driver.findElement(By.xpath("//input[@name=\"endBidSubmissionDate\"]")).sendKeys("09-04-2025 16:35:00");
		driver.findElement(By.xpath("(//button[text()='Submit'])[4]")).click();
		
	}
	@Test(priority=7)
	
	void summary1()
	{
		driver.findElement(By.xpath("//textarea[@name=\"comments\"]")).sendKeys("finished");
		driver.findElement(By.xpath("//button[@onclick=\"submitTender()\"]")).click();
		Alert al1=driver.switchTo().alert();
		al1.accept();
	}
	
@Test(priority=8)
	
	void liverfq() throws InterruptedException
	{
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//a[@title=\"View\"])[1]")).click();
	driver.findElement(By.xpath("//button[text()='Raise Addendum']")).click();
	driver.findElement(By.xpath("//label[@for='Dates']")).click();
	driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	//driver.findElement(By.xpath("//input[@name=\"endClarificationDate\"]")).sendKeys("08-04-2025 23:05:00");
	//driver.findElement(By.xpath("//input[@name=\"endBidSubmissionDate\"]")).sendKeys("08-04-2025 23:20:00");
	//Thread.sleep(3000);
	driver.findElement(By.xpath("//textarea[@id=\"comment\"]")).sendKeys("hehe");
	driver.findElement(By.xpath("//button[text()='Raise Addendum']")).click();
	driver.findElement(By.xpath("//button[text()='Close']")).click();
	}
	
@Test(priority=9)
	
	void aproove() throws InterruptedException
	{
	System.out.println("entered approval");
	Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class=\"fa fa-home\"]")).click();
		driver.findElement(By.xpath("//span[text()='Approve Addendums']")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele1= driver.findElement(By.xpath("//tbody//tr//td[3][contains(text(),\"JANHAVI1\")]"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",ele1);
		WebElement ele= driver.findElement(By.xpath("//tbody//tr//td[3][contains(text(),\"JANHAVI1\")]/..//td[5]//a"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@name=\"comment\"]")).sendKeys("aproove");
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary accept_And_Publish\"]")).click();
		
		
	}

	@Test(priority=10)

	void aprooval()
	{
		driver.findElement(By.xpath("//span[@class=\"fa fa-home\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"box col-hover-2\"])[2]")).click();
		driver.findElement(By.xpath("(//a[@title=\"View\"])[1]")).click();
	}
	@Test(priority=11)
	void setup()
	{
		
		driver.get("https://training1.effigo.in/portal");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(priority=12)
	void Login1()
	{
		main lp=new main(driver);
		lp.setUserName("janhavikp@gmail.com");
		lp.setPassword("Bob@1234");
		lp.clickLogin();
		
	}
	@Test(priority=13)
	void New() throws InterruptedException
	{
		Alert al4=driver.switchTo().alert();
		al4.accept();
		driver.findElement(By.xpath("(//div[@class=\"h5 mb-0 font-weight-bold text-black-50\"])[2]")).click();
		driver.findElement(By.xpath("//tbody//tr//td[text()='JANHAVI1']/../td[4]//a")).click();
		

//		LocalTime targetTime = LocalTime.of(12, 57);
//		while (LocalTime.now().isBefore(targetTime)) {
//		    Thread.sleep(1000); // wait in 1-second intervals
//		}

		WebElement element = driver.findElement(By.xpath("//label[@for=\"check0\"]"));
		element.click();
		driver.findElement(By.xpath("//label[@for=\"terms\"]")).click();
		//driver.findElement(By.xpath("//button[text()='Accept']")).click();//td[@class=\"custumrc\"]//div//input[2]
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept']"))).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed To Price Bid']")).click();
		
	}
	
	@Test(priority=14)
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
		driver.findElement(By.xpath("//button[@id=\"closeBtn\"]")).click();
	}
	@Test(priority=15)
	void upeg() throws InterruptedException
	{
		driver.get("https://training1.effigo.in/upeg/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href=\"getTenderCreatorHomePage\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Live RFQ's\"]")).click();
		driver.findElement(By.xpath("(//a[@title=\"View\"])[1]")).click();
		driver.findElement(By.xpath("//a[@title=\"Add User Team\"]")).click();
		driver.findElement(By.xpath("//tbody//tr//td[text()='JEA John']/../td[3]")).click();
		driver.findElement(By.xpath("//tbody//tr//td[text()='JEA John']/../td[4]")).click();
		driver.findElement(By.xpath("//input[@name=\"minCommercialEvaluators\"]")).sendKeys("1");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//a[@onclick=\"viewEval();\"]")).click();
		driver.findElement(By.xpath("//a[@onclick=\"startCommercial('3');\"]")).click();
		Alert ale=driver.switchTo().alert();
		ale.accept();
		driver.findElement(By.xpath("//a[text()='Evaluation Pending']")).click();
		driver.findElement(By.xpath("//textarea[@name=\"commntBox\"]")).sendKeys("success");
		driver.findElement(By.xpath("//button[@id=\"submitBtn\"]")).click();
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
		driver.quit();////tbody//tr[2]//td[3][contains(text(),"Award")]/..//td[5]
	}*/
}





