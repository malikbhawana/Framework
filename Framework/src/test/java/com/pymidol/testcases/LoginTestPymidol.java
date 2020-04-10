package com.pymidol.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.pymidol.pages.BaseClass;
import com.pymidol.pages.LoginPage;


public class LoginTestPymidol extends BaseClass {
	
	@Test(priority=1)
	public void loginApp()
	{	
		
		/* what ever done in below code, like creating library first and using here is called abstraction
		   Abstraction means-showing essential features and hiding background details */
		
		logger=report.createTest("Login To Pymidol");
	
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);  //it will goto login page check all the locators initialise then it will return object of same class
		
		logger.info("Starting Application"); //it will provide information about test or test step
		
		loginPage.loginToPymidol(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login done Success");
	
	}
	
	/* @Test(priority=2)
	public void loginApp2()
	{	
		logger=report.createTest("Logout");
		
		logger.fail("Logout Failed");
	} */

}
