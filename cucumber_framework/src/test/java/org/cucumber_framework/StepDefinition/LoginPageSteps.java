package org.cucumber_framework.StepDefinition;

import java.time.Duration;

import org.cucumber_framework.PageObject.AddCustomerPage;
import org.cucumber_framework.PageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseClass{
	
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
	    driver = new ChromeDriver();
	    lp = new LoginPage(driver);
	    driver.manage().window().maximize();

	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setUsername(email);
	    lp.setPassword(password);
	}

	@And("Click on Login")
	public void click_on_login() {
	    lp.clickLoginButton();
	}
	
	@Then("Validate the page title as {string}")
	public void validatePageURL(String landingPageTitle){
		if(driver.getPageSource().contains("Login was unsuccessful.")){
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(landingPageTitle,driver.getTitle());
		}
	}
	
	@When("Click on the logout link")
	public void click_on_logout_link() {
		lp.clickLogoutLink();
	}
	
	@Then("Page title should be {string}")
	public void Validate_Logout(String loginPageTitle) {
		Assert.assertEquals(loginPageTitle, "Your store. Login");
	}
	
	@And("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}
	
	//Step definition steps--------------------------------------------
	
	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User clicks on Customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		addCust.clickOnCustomerMenu();
	}
	@When("Click on Customers menu item")
	public void click_on_customers_menu_item() {
	    addCust.clickOnCustomerMenuoption();
	}
	@When("Click on add new button")
	public void click_on_add_new_button() {
	    addCust.clickOnAddNewButton();
	}
	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    addCust.setEmailID("abcd"+randomString()+"@gmail.com");
	    addCust.setPassword("12345678");
	    addCust.setFirstname("cucumber");
	    addCust.setLastname("testing");
	    addCust.setGender("Male");
	    addCust.setDateOfBirth("11/11/1999");
	    addCust.setCompanyName("Automation testing");
	    addCust.clickTaxExcept();
	    addCust.setCustomerRoles("Administrators");
	    addCust.setManagerOfVendor("Vendor 1");
	    addCust.setAdminComment("testing");
	}
	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
	    addCust.clickOnSave();
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	    
	}
	
	//steps for searching customer by using Email ID-----------------------
	@When("Enter customer Email")
	public void enter_customer_email() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("Click on search button")
	public void click_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	


}
