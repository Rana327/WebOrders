package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.screenshots;
import framework.testBase;
import junit.framework.Assert;

public class loginPage extends testBase {

	static By logininfo = By.xpath("//div[@class='login_info']");
	static By order = By.xpath("//a[text()='Order']");
	static By new_order = By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[2]");
	static By newOrder_card = By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td[11]");
	static By edit			= By.xpath("(//input[@alt='Edit'])[1]");
	
	public static void info_verify()
	{
		String verify_user = driver.findElement(logininfo).getText();
		System.out.println("The Welcome Username text after login is: "+verify_user.substring(0, 17));
	}
	
	public static void order_navigate()
	{
		//driver.findElement(order).click();
		Actions action = new Actions(driver);
		WebElement click_order = driver.findElement(order);
        action.moveToElement(click_order).build().perform();
        click_order.click();
        System.out.println("order page successfully clicked");
        
	}
	public static void verifyNew_order()
	{
		String expected = "team1";
		String actual = driver.findElement(new_order).getText();
		String message = "the name matched";
		Assert.assertEquals(message, expected, actual);
		//Assert.assertSame(message, expected, actual);
		System.out.println(message);
		
		String expected_card = driver.findElement(newOrder_card).getText();
		String actual_card = "1234567898765432";
		String msg = "the card matched";
		Assert.assertEquals(msg, expected_card, actual_card);
		System.out.println(msg);
	}
	
	
	public static void edit_order()
	{
		driver.findElement(edit).click();
	}
	
	public static void confirm_update() throws IOException
	{
		screenshots.screen(3);
		System.out.println("The card and expiry date is updated and can be seen in screenshot taken");
	}
}
