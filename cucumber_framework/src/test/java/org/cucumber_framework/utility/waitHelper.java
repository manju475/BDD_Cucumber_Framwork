package org.cucumber_framework.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper {
	public WebDriver driver;
	
	public waitHelper(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void waitForElemet(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
