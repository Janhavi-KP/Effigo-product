package randomPriceTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class randpriceTemplate {
		WebDriver driver;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(500));
		@BeforeClass
		void setup1()
		{
			WebDriverManager.chromedriver().setup();

		      ChromeOptions options = new ChromeOptions();
		      Map<String, Object> prefs = new HashMap<>();
		      prefs.put("credentials_enable_service", false);
		      prefs.put("profile.password_manager_enabled", false);
		      options.setExperimentalOption("prefs", prefs);
		      options.addArguments("--disable-blink-features=AutomationControlled");
		      options.addArguments("--disable-infobars");
		      options.addArguments("--no-default-browser-check");
		      options.addArguments("--disable-notifications");
		      options.addArguments("--disable-save-password-bubble");
		      options.addArguments("--incognito");
		      driver = new ChromeDriver(options);
		      driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		      driver.get("https://training1.effigo.in/admin/");
		}
		
		@Test(priority=1)
		void Login()
		{
			mainRand lp=new mainRand(driver);
			lp.login(); 	
		}
		
		@Test(priority=2)
		void addtemp()
		{
			mainRand lp1=new mainRand(driver);
			lp1.price();	
		}
		@Test(priority=3)
		void validate()
		{
			mainRand lp2=new mainRand(driver);
			lp2.name();	
		}

	}


