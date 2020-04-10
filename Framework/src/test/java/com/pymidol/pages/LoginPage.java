package com.pymidol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)    //constructor
	{
		this.driver=ldriver;
	}

	@FindBy(name="isec_userid") WebElement uname;   //use find by when you are working with page object model, it is alternate way to locate the web element
	
	@FindBy(name="isec_pass") WebElement pass; 
	
	@FindBy(name="login") WebElement loginButton; 
	
	public void loginToPymidol(String usernameApplication, String passwordApplication)  //method
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			
		}
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
	}
	
}
