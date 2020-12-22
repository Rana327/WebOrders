package stepDefinitions;

import pageObject.viewProducts;
import pageObject.viewTable;
import framework.testBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class scenario3 extends testBase {

	@When("^Navigate to the View all products page$")
	public void navigate_to_the_View_all_products_page() throws Throwable {
	    
		//viewProducts.click_allProducts();
		viewTable.viewAllProduct();
	}

	@And("^Verify the value displayed correctly$")
	public void verify_the_value_displayed_correctly() throws Throwable {
	    
		//viewProducts.verify_table();
		
		viewTable.MONEYPrice();
		Thread.sleep(2000);
		viewTable.MONEYDiscount();
		Thread.sleep(2000);
		viewTable.MONEY_Price_Discount();
		Thread.sleep(2000);
		viewTable.FAMILYPrice();
		Thread.sleep(2000);
		viewTable.FAMILYDiscount();
		Thread.sleep(2000);
		viewTable.FAMILY_Price_Discount();
		Thread.sleep(2000);
		viewTable.SCREENPrice();
		Thread.sleep(2000);
		viewTable.SCREENDiscount();
		Thread.sleep(2000);
		viewTable.SCREEN_Price_Discount();
	}

	@Then("^Click on Logout$")
	public void click_on_Logout() throws Throwable {
	    
		
		viewProducts.logout();
	}

	@And("^Verifying and validating Logout successful or not$")
	public void verifying_and_validate_Logout_successful_or_not() throws Throwable {
	    
		viewProducts.verify_validate();
		
	
		testBase.closingDriver();
	}
}
