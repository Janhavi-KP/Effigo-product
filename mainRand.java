package randomPriceTemplate;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainRand {
	


			WebDriver driver;
			
			//constructor-constructor name should be same as main class-to initiate the driver constructor is used
			
			mainRand(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			//Login
			
			@FindBy(xpath="//input[@id=\"username\"]") WebElement txt_username;
			@FindBy (xpath="//input[@id=\"password\"]")WebElement txt_password;
			@FindBy (xpath="//button[@id=\"login\"]")WebElement button_login;
			@FindBy(xpath="//a[@id=\"getAllPriceComponenetTemplate\"]")WebElement priceTemp;
			@FindBy(xpath="//button[@id=\"add_template\"]")WebElement addtemp; 
			@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")WebElement plus;
			@FindBy(xpath = "(//select[@name=\"priceLabelId\"])[1]")WebElement sel;
			@FindBy(xpath = "//option[text()='GST']")WebElement gst;
			@FindBy(xpath = "//select[@id=\"calculationOn2\"]")WebElement sel1;
			@FindBy(xpath = "(//option[@value=\"CAL01\"])[1]")WebElement bs;
			
			@FindBy(xpath = "//select[@id=\"priceLabelId3\"]") WebElement sel3;
			@FindBy(xpath = "(//option[@value=\"PRICE_COMP-1c309a-06-02-2025-04\"])[2]") WebElement dis;
			@FindBy(xpath = "//select[@id=\"calculationOn3\"]")WebElement sel4;
			@FindBy(xpath = "(//option[@value=\"CAL01\"])[2]")WebElement bs2;
			
			@FindBy(xpath = "//input[@name=\"templateName\"]")WebElement name;
			
			@FindBy(xpath = "//button[@id=\"formulate\"]")WebElement Formulate;
			@FindBy(xpath = "//button[@id=\"addBtn\"]")WebElement save;
			
			//@FindBy(xpath = "//td[text()='Base2345']")WebElement validate;
			
			public void login()
			{
				txt_username.sendKeys("subadmin@bob.com");
				txt_password.sendKeys("Bob@1234");
				button_login.click();
			}
			
			public void price()
			{
				priceTemp.click();
				addtemp.click();
				plus.click();
				plus.click();
				sel.click();
				gst.click();
				sel1.click();
				bs.click();
				sel3.click();
				dis.click();
				sel4.click();
				bs2.click();
			}
			public void name()
			{
				 String randomData = generateRandomString(8); // 8-character random string

			       
			        name.sendKeys(randomData);

			        // Get the value back from the field to validate
			        String valueInField = name.getAttribute("value");

			        // Validation
			        if (randomData.equals(valueInField)) {
			            System.out.println("Validation Passed: " + valueInField);
			        } else {
			            System.out.println(" Validation Failed: Expected " + randomData + " but found " + valueInField);
			        }
				
				Formulate.click();
				save.click();
			
				
			}
			 public static String generateRandomString(int length) {
			        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			        Random rand = new Random();
			        StringBuilder sb = new StringBuilder();

			        for (int i = 0; i < length; i++) {
			            sb.append(characters.charAt(rand.nextInt(characters.length())));
			        }

			        return sb.toString();
			    }
			
	}



