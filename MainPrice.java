package priceTemplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainPrice {
		WebDriver driver;
		
		//constructor-constructor name should be same as main class-to initiate the driver constructor is used
		
		MainPrice(WebDriver driver)
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
		
		@FindBy(xpath = "//td[text()='Base']")WebElement validate;
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
			name.sendKeys("Base");
			Formulate.click();
			save.click();
		}
		
		public void valid()
		{
			validate.isDisplayed();
			System.out.println("template added successfully");
			
		}
}
