package org.cucumber_framework.PageObject;

import java.awt.Checkbox;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By customerMenu = By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li/a/p[contains(text(),'Customers')]");
	By customerOption = By.xpath("//ul[@class='nav nav-treeview']/li/a[@href='/Admin/Customer/List']");
	
	By addNewButton = By.xpath("//a[@href='/Admin/Customer/Create']");
	By txtEmailID = By.id("Email");
	By txtPassword = By.id("Password");
	By txtFirstname = By.id("FirstName");
	By txtLastname = By.id("LastName");
	//gender
	By radMaleGen = By.id("Gender_Male");
	By radFemaleGen = By.id("Gender_Female");
	
	By txtDateOfBirth = By.name("DateOfBirth"); //should pass the parameter format as "11/11/2024"
	By txtCompanyName = By.id("Company");
	By chkTaxExempt = By.id("IsTaxExempt");
	
	//news letter options
	By drpNewsLetter = By.xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds]");
	
	//Customer roles options
	By customerRoleOptions = By.id("SelectedCustomerRoleIds");
	
	//Manager of vendor
	By drpManagerOfVendor = By.id("VendorId");
	
	By txtAdminComment = By.id("AdminComment");
	
	By saveButton = By.cssSelector("body.sidebar-mini.layout-fixed.control-sidebar-slide-open:nth-child(2) div.wrapper:nth-child(3) div.content-wrapper:nth-child(3) form:nth-child(2) div.content-header.clearfix:nth-child(1) div.float-right > button.btn.btn-primary:nth-child(1)");
	
	//Actions methods
	
	public String getPageTitle() {
		String title = ldriver.getTitle();
		return title;
	}
	
	public void setDateOfBirth(String dob) {
		ldriver.findElement(txtDateOfBirth).sendKeys(dob);
	}
	
	public void clickOnCustomerMenu() throws InterruptedException {
		Thread.sleep(2000);
		ldriver.findElement(customerMenu).click();
	}
	public void setCompanyName(String company) throws InterruptedException {
		Thread.sleep(2000);
		ldriver.findElement(txtCompanyName).sendKeys(company);
	}
	public void clickTaxExcept() {
		if(ldriver.findElement(chkTaxExempt).isSelected()==false) {
			ldriver.findElement(chkTaxExempt).click();
		}else {
			ldriver.findElement(chkTaxExempt).clear();
			ldriver.findElement(chkTaxExempt).click();
		}	
	}
	public void clickOnCustomerMenuoption() {
		ldriver.findElement(customerOption).click();
	}
	
	public void clickOnAddNewButton() {
		ldriver.findElement(addNewButton).click();
	}
	
	public void setEmailID(String email) {
		ldriver.findElement(txtEmailID).sendKeys(email);
	}
	
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setNewsLetter(String Store) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(3000);
		Select newsLetter = new Select(ldriver.findElement(drpNewsLetter));
		newsLetter.selectByVisibleText(Store);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		
		Select CustomerRoles = new Select(ldriver.findElement(customerRoleOptions));
		CustomerRoles.selectByVisibleText(role);
		
		
		
	}
	
	public void setManagerOfVendor(String value) {
		Select drp =new Select(ldriver.findElement(drpManagerOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(radMaleGen).click();
		}else if(gender.equals("Female")) {
			ldriver.findElement(radFemaleGen).click();
		}else {
			ldriver.findElement(radMaleGen).click();
		}
	}
	
	public void setFirstname(String fname) {
		ldriver.findElement(txtFirstname).sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		ldriver.findElement(txtLastname).sendKeys(lname);
	}
	
	public void setAdminComment(String comment) {
		ldriver.findElement(txtAdminComment).sendKeys(comment);
	}
	
	public void clickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		ldriver.findElement(saveButton).click();
	}
	

	


}
