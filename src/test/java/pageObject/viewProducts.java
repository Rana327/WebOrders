package pageObject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import utilities.screenshots;
import framework.testBase;

public class viewProducts extends testBase {

	static By allProducts = By.xpath("//a[@href='Products.aspx']");
	static By table = By.xpath("//table[@class='ProductsTable']");
	static By log_out = By.id("ctl00_logout");
	
	
	public static void click_allProducts()
	{
		driver.findElement(allProducts).click();
	}
	
	public static void verify_table() throws IOException
	{
		String table_print=driver.findElement(table).getText();
		System.out.println(table_print);
		screenshots.screen(4);
		System.out.println("The screenshot of table is taken");
	}
	
	public static void logout()
	{
		driver.findElement(log_out).click();
	}
	
	public static void verify_validate()
	{
		String expected = "Web Orders Login";
		String actual = driver.getTitle();
		//System.out.println(actual);
		Assert.assertEquals(expected, actual);
		System.out.println("The logout is successful");
		
		/*if(unexpected.equals(actual))
		{
			System.out.println("The logout is not successful");
			
		}
		else
		{
			System.out.println("The logout is successful");
		}*/
	}
}
