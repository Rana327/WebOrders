package pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import utilities.TestData;
import utilities.screenshots;
import framework.testBase;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class addOrderPage extends testBase{
	

	screenshots shot = new screenshots();
	
	static By quanAdd = By.name("ctl00$MainContent$fmwOrder$txtQuantity");
	static By cal 	  = By.xpath("//input[@type='submit']");
	static By ppu 	  = By.id("ctl00_MainContent_fmwOrder_txtUnitPrice");
	static By total   = By.id("ctl00_MainContent_fmwOrder_txtTotal");
	static By reset   = By.xpath("//input[@value='Reset']");


	static By text_Customername= By.name("ctl00$MainContent$fmwOrder$txtName");
	static By text_Street      = By.name("ctl00$MainContent$fmwOrder$TextBox2");
	static By text_City        = By.id("ctl00_MainContent_fmwOrder_TextBox3");
	static By text_State       = By.xpath("//li/input[@id='ctl00_MainContent_fmwOrder_TextBox4']");
	static By text_Zip         = By.name("ctl00$MainContent$fmwOrder$TextBox5");
	
	static By rad_Visa         = By.xpath("//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td[1]");
	static By rad_Mastercard   = By.xpath("//input[@value='MasterCard']");
	static By rad_Americanex   = By.xpath("//tbody/tr/td[3]/input[@name='ctl00$MainContent$fmwOrder$cardList']");
	static By txt_cardnum      = By.name("ctl00$MainContent$fmwOrder$TextBox6");
	static By txt_Expiredate   = By.xpath("//table[@style='width:100%;border-collapse:collapse;']/tbody/tr/td/ol[3]/li[3]/input");
	static By btn_Process      = By.id("ctl00_MainContent_fmwOrder_InsertButton");
	static By btn_Reset        = By.xpath("//div[@class='buttons_process']/input");
	static By msg_confirm	   = By.xpath("//strong");
	static By viewOrder		   = By.xpath("//a[@href='Default.aspx']");
	static By update			= By.id("ctl00_MainContent_fmwOrder_UpdateButton");
	
	
	public static void quantityAdd(int arg3)
	{
		//driver.findElement(quanAdd).click();
		driver.findElement(quanAdd).clear();
		driver.findElement(quanAdd).sendKeys(String.valueOf(arg3));
		
	}
	
	public static void calculate_verify()
	{
		driver.findElement(cal).click();
		
				
	}
	
	public static void verify_price() throws InterruptedException, IOException
	{
		screenshots.screen(1);
		System.out.println("Screenshot is taken");
		
	}
	
	public static void reset_fun() throws IOException
	{
		driver.findElement(reset).click();
		screenshots.screen(2);
		System.out.println("Screenshot is for reset page is taken");
		
	}
	
	public static void address_details() throws InterruptedException, BiffException, IOException
	{
		String srcfile = "xcelData.xls";
		FileInputStream f1= new FileInputStream(srcfile);
		
	Workbook wb = Workbook.getWorkbook(f1);
		
		Sheet sh = wb.getSheet(0);
		
		
		//String cname=sh.getCell(0,2).getContents();
		//driver.findElement(text_Customername).sendKeys(cname);
		driver.findElement(text_Customername).sendKeys("team1");
		driver.findElement(text_Street).sendKeys("central perk");
		Thread.sleep(1000);
		driver.findElement(text_City).sendKeys("New York");
		Thread.sleep(1000);
		driver.findElement(text_State).sendKeys("New York");
		Thread.sleep(1000);
		driver.findElement(text_Zip).sendKeys("10019");
	}
	
	public static void creditCard_details() throws InterruptedException
	{
		driver.findElement(rad_Mastercard).click();
		driver.findElement(txt_cardnum).sendKeys("1234567898765432");
		Thread.sleep(1000);
		driver.findElement(txt_Expiredate).sendKeys("09/2024");
	}
	
	public static void process()
	{
		driver.findElement(quanAdd).sendKeys("5");
		driver.findElement(btn_Process).click();
	}
	
	public static void message_verify()
	{
		
		String expected = "New order has been successfully added.";
		
		String print_message = driver.findElement(msg_confirm).getText();
		//System.out.println(print_message);
		
		Assert.assertEquals(expected, print_message);
		System.out.println("Message verified"+print_message);
		//Assert.assertSame("the order placed",expected,print_message);
	}
	
	public static void view_orders()
	{
		driver.findElement(viewOrder).click();
	}
	
	public static void update_card(int arg1, int arg2)
	{
		
		driver.findElement(txt_Expiredate).clear();
		driver.findElement(txt_Expiredate).sendKeys(String.valueOf(arg1),"/",String.valueOf(arg2));
		driver.findElement(rad_Visa).click();
		
	}
	
	public static void click_update()
	{
		driver.findElement(update).click();
	}
	}
