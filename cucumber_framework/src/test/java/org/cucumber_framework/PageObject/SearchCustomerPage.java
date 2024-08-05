package org.cucumber_framework.PageObject;

import org.cucumber_framework.utility.waitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	public waitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper = new waitHelper(ldriver);
	}

}
