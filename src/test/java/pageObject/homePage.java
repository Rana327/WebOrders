package pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.TestData;
import framework.testBase;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class homePage extends testBase {
	
	
	

	static By user_name= By.id("ctl00_MainContent_username");
	static By pass_word= By.name("ctl00$MainContent$password");
	static By login_button= By.xpath("//input[@type='submit']");
	
	public static void verifyElements()
	{
		boolean eleuname = driver.findElement(user_name).isDisplayed();
		System.out.println("Username textbox element is present :"+eleuname);
		boolean elepword = driver.findElement(pass_word).isDisplayed();
		System.out.println("Password textbox element is present :"+elepword);
		boolean elelogin = driver.findElement(login_button).isEnabled();
		System.out.println("Login button element is present :"+elelogin);
	}
	
	public static void loginCredentials() throws InterruptedException, BiffException, IOException
	{

		String srcfile = "xcelData.xls";
		FileInputStream f1= new FileInputStream(srcfile);
		
	Workbook wb = Workbook.getWorkbook(f1);
		
		Sheet sh = wb.getSheet(0);
		
		
		String uname=sh.getCell(0,1).getContents();
		driver.findElement(user_name).sendKeys(uname);
		
		
		String pass=sh.getCell(1,1).getContents();
		driver.findElement(pass_word).sendKeys(pass);
		
		f1.close();
		
		//driver.findElement(login_button).click();
		WebElement log = driver.findElement(login_button);
		Actions action = new Actions(driver);

		action.moveToElement(log).click().perform();
		 
		
	}
}
