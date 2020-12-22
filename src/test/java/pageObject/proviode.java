package pageObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.testBase;
import junit.framework.Assert;
import utilities.screenshots;

public class proviode extends testBase {
	 
	
	public static void navigate() throws InterruptedException
	{
		/*driver.findElement(By.xpath("//h2"));*/
		driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[2]/td[13]/input")).click();
		 Thread.sleep(2000);
	}
	public static void edit() throws InterruptedException
	{
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).clear();
	    driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Guntur");
	    Thread.sleep(2000);
	   
	    driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).clear();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("583123");
	    Thread.sleep(2000);
	/* driver.findElement(By.name("ctl00_MainContent_fmwOrder_UpdateButton")).click();*/
	
	}
	public static void update() throws InterruptedException
	
	{
		 driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		 Thread.sleep(2000);
    }
	
	public static void verify_update() throws IOException
	{
		
		screenshots.screen(1);
		System.out.println("screenshot is for verify_update");
	   
	    }
		
	
	public static void logout()
	{
     driver.findElement(By.id("ctl00_logout")).click();
	}
	public static void verify_validate()
    {
        String unexpected = "Web Orders";
        String actual = driver.getTitle();
        System.out.println(actual);
        //Assert.assertNotEquals("logout is successfull", unexpected, actual);
       
        if(unexpected.equals(actual))
        {
            System.out.println("The logout is not successful");     
        }
        else
        {
            System.out.println("The logout is successful");
        }   
    }
}

