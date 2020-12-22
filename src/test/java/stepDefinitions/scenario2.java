package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.testBase;
import pageObject.homePage;
import pageObject.proviode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class scenario2  {
/*	
@Given("^open the chrome browser and start application$")
public void open_the_chrome_browser_and_start_application() throws Throwable {

	testBase.initialization();
   
}

@Then("^verify the welcome text with logged in user$")
public void verify_the_welcome_text_with_logged_in_user() throws Throwable {

	homePage.verifyElements();
}
*/
@When("^navigate to the list of all orders$")
public void navigate_to_the_list_of_all_orders() throws Throwable {
   
	proviode.navigate();
}

@Then("^edit the order zip code and city$")
public void edit_the_yamini_order_zip_code_and_city() throws Throwable {

   proviode.edit();
}

@Then("^click the update button$")
public void click_the_update_button() throws Throwable {
  
	proviode.update();
}


@Then("^verify the update details correctly displayed or not in view all orders$")
public void verify_the_update_details_correctly_displayed_or_not_in_view_all_orders() throws Throwable {
 
	proviode.verify_update();
}

@Then("^click on logout$")
public void click_on_logout() throws Throwable {
	
	proviode.logout();
    
}

@And("^Verify and validating Logout successful or not$")
public void verify_and_validating_Logout_successful_or_not() throws Throwable {
    
	proviode.verify_validate();
	
	
	testBase.closingDriver();
}




}
