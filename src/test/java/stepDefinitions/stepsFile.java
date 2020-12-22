package stepDefinitions;

import org.openqa.selenium.By;

import pageObject.addOrderPage;
import pageObject.homePage;
import pageObject.loginPage;
import utilities.TestData;
import framework.testBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsFile extends testBase {
	

	//homePage home = new homePage();
	addOrderPage orders = new addOrderPage();
	@Given("^Navigate to the application$")
	public void navigate_to_the_application() throws Throwable {
		
		testBase.initialization();
	    
	}

	@Then("^Verify the textbox for the Username, password and login button$")
	public void verify_the_textbox_for_the_Username_password_and_login_button() throws Throwable {
	    homePage.verifyElements();
	}
	
	@When("^Login using the valid credentials$")
	public void login_using_the_valid_credentials() throws Throwable {
	    
		homePage.loginCredentials();
	}

	@Then("^Verify the welcome text with the logged in user$")
	public void verify_the_welcome_text_with_the_logged_in_user() throws Throwable {
	    
		loginPage.info_verify();
	}
	
	@When("^Navigate to the Orders page$")
	public void navigate_to_the_Orders_page() throws Throwable {
	   
		loginPage.order_navigate();
	}
	
	
	/*@When("^The product from the list is selected$")
	public void the_product_from_the_list_is_selected() throws Throwable {
	   
		
	}*/

	@And("^Enter the quantity as '(\\d+)'$")
	public void enter_the_quantity_as(int arg3) throws Throwable {
	    
		addOrderPage.quantityAdd(arg3);
		
	}

	@And("^Hit the calculate button$")
	public void hit_the_calculate_button() throws Throwable {
	    
		addOrderPage.calculate_verify();
	}

	@Then("^Verify the value displayed correctly for the quantity and price$")
	public void verify_the_value_displayed_correctly_for_the_quantity_and_price() throws Throwable {
		
		addOrderPage.verify_price();
	   
	}

	@And("^Click on Reset button and assert that the quantity and total fields are ‘(\\d+)’$")
	public void click_on_Reset_button_and_assert_that_the_quantity_and_total_fields_are(int check) throws Throwable {
	    
		addOrderPage.reset_fun();
	}

	@When("^Enter the address for the order$")
	public void enter_the_address_for_the_order() throws Throwable {
	    
		addOrderPage.address_details();
	}

	@And("^Enter a dummy credit card details$")
	public void enter_a_dummy_credit_card_details() throws Throwable {
	   
		addOrderPage.creditCard_details();
	}

	@And("^Click Process$")
	public void click_Process() throws Throwable {
	   
		
		addOrderPage.process();
	}

	@Then("^Verify the confirmation message for order placement$")
	public void verify_the_confirmation_message_for_order_placement() throws Throwable {
	   
		addOrderPage.message_verify();
	}

	@When("^Navigate to the View all Order$")
	public void navigate_to_the_View_all_Order() throws Throwable {

		addOrderPage.view_orders();
	}

	@And("^Verify the order is placed or not$")
	public void verify_the_order_is_placed_or_not() throws Throwable {
	    
		loginPage.verifyNew_order();
	}

	@Then("^Edit the order and change the credit card expiry date as '(\\d+)/(\\d+)' and card type as Visa$")
	public void edit_the_order_and_change_the_credit_card_expiry_date_as_and_card_type_as_Visa(int arg1,int arg2) throws Throwable {
	    
		loginPage.edit_order();
		Thread.sleep(2000);
		addOrderPage.update_card(arg1,arg2);
		
	}

	@And("^Click the update button$")
	public void click_the_update_button() throws Throwable {
	    
		addOrderPage.click_update();
	}
	
	@Then("^Verify the presence of the updated order$")
	public void verify_the_presence_of_the_updated_order() throws Throwable {

		loginPage.confirm_update();
		testBase.closingDriver();
	}

}
