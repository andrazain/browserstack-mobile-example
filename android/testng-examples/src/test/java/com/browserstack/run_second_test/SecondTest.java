package com.browserstack.run_second_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class SecondTest extends BrowserStackTestNGTest {
	
	
	String usernameFieldId = "test-Username";
	String passwordFieldId = "test-Password";
	String loginButtonId = "test-LOGIN" ;
	
	By productTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
	
	

    @Test
      public void test() throws Exception {
     
    	System.out.println("SauceLab Login");
    	login("standard_user", "secret_sauce");
    	Assert.assertTrue(isOnProductPage());
    	
    }
    
    
    public void login(String user, String pass) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 5);
    	
    	WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(usernameFieldId)));
    	WebElement passwordField = driver.findElementByAccessibilityId(passwordFieldId);
    	WebElement loginButton = driver.findElementByAccessibilityId(loginButtonId);
    	
    	usernameField.sendKeys(user);
    	passwordField.sendKeys(pass);
    	loginButton.click();
    	
    }
    
    
    public boolean isOnProductPage() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 5);
    	
    	try {
			wait.until(ExpectedConditions.visibilityOfElementLocated((productTitle)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
    	return true;
    }
}
