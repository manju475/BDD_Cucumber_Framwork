package org.cucumber_framework.StepDefinition;

import java.time.Duration;

import org.cucumber_framework.PageObject.AddCustomerPage;
import org.cucumber_framework.PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public WebDriverWait wb;
	
	
	public static String randomString() {
		String generateString = RandomString.make(5).toString().toLowerCase();
		return generateString;
	}

}
