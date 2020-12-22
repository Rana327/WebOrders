package pageObject;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import framework.testBase;

public class viewTable extends testBase {

	
	static By sel_ViewAllProd  = By.xpath("//ul[@id='ctl00_menu']/li[2]/a[@href='Products.aspx']");
	static By mymoney_price    = By.xpath("//td[text()='$100']");
	static By mymoney_discount = By.xpath("//td[text()='8%']");
	static By familyAlbum_price= By.xpath("//td[text()='$80']");
	static By familyAlbum_discount = By.xpath("//td[text()='15%']");
	static By screenSaver_price    = By.xpath("//td[text()='$20']");
	static By screenSaver_discount = By.xpath("//td[text()='10%']");
	
	static SoftAssert Assert=new SoftAssert();
	
	
	public static void viewAllProduct() throws Exception
	{
	    try
	    {
	     Actions all = new Actions(driver);
	     WebElement element=driver.findElement(sel_ViewAllProd);
	     all.moveToElement(element).build().perform();
	     element.click();
	     System.out.println("button opened  succsessfully");
	    }
	    catch(Exception e)
	    {
	          System.out.println("button not opened "  +e.getMessage());
	    }
	}

	 

	public static boolean MONEYPrice() throws IOException     
	{   
	    boolean price; 
	    String P = "$100";
	    String P1 = driver.findElement(mymoney_price).getText();             //Attribute("value");
	    price=(P1.equals(P));
	    return price;
	}
	public static  boolean MONEYDiscount( ) throws IOException     
	{
	     boolean disc;
	     String D = "8%";
	     String D1 = driver.findElement(mymoney_discount).getText();            
	     disc=(D1.equals(D));
	     return disc ;
	}   
	public static  void MONEY_Price_Discount() throws Exception 
	{ 
	  boolean price = false,disc = false;
	  try 
	   {
		  
	     Assert.assertTrue((price && disc)?true:false);
	     System.out.println("price and discount values of MONEY displayed correctly");
	   }
	  catch(Exception e) 
	   {
	     // Screenshot.pic(1);
	     System.out.println("price and discount values of MONEY displayed incorrectly"  +e.getMessage());
	   }
	}

	 

	public static boolean FAMILYPrice() throws IOException     
	{   
	    boolean price2; 
	    String P2 = "$80";
	    String P3 = driver.findElement(familyAlbum_price).getText();             
	    price2=(P3.equals(P2));
	    return price2;
	}
	public static  boolean FAMILYDiscount( ) throws IOException     
	{
	     boolean disc2;
	     String D2 = "15%";
	     String D3 = driver.findElement(familyAlbum_discount).getText();           
	     disc2=(D3.equals(D2));
	     return disc2 ;
	}   
	public static  void FAMILY_Price_Discount() throws Exception 
	{ 
	  boolean price2 = false,disc2 = false;
	  try 
	   {
	     Assert.assertTrue((price2 && disc2)?true:false);
	     System.out.println("price and discount values of FAMILYALBUM displayed correctly");
	   }
	  catch(Exception e) 
	   {
	     // Screenshot.pic(1);
	     System.out.println("price and discount values of FAMILYALBUM displayed incorrectly"  +e.getMessage());
	   }
	}
	public static boolean SCREENPrice() throws IOException     
	{   
	    boolean price3; 
	    String P4 = "$20";
	    String P5 = driver.findElement(screenSaver_price).getText();             
	    price3=(P5.equals(P4));
	    return price3;
	}
	public static  boolean SCREENDiscount( ) throws IOException     
	{
	     boolean disc3;
	     String D4 = "10%";
	     String D5 = driver.findElement(screenSaver_discount).getText();            
	     disc3=(D5.equals(D4));
	     return disc3 ;
	}   
	public static  void SCREEN_Price_Discount() throws Exception 
	{ 
	  boolean price3 = false,disc3 = false;
	  try 
	   {
	     Assert.assertTrue((price3 && disc3)?true:false);
	     System.out.println("price and discount values of SCREENSAVER displayed correctly");
	   }
	  catch(Exception e) 
	   {
	     // Screenshot.pic(1);
	     System.out.println("price and discount values of SCREENSAVER displayed incorrectly"  +e.getMessage());
	   }
	}
}
