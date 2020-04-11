package com.pymidol.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pymidol.utility.BrowserFactory;
import com.pymidol.utility.ConfigDataProvider;
import com.pymidol.utility.ExcelDataProvider;
import com.pymidol.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up Reports and Test is getting ready", true); //by logs we can identify where issue happned
		
		excel=new ExcelDataProvider(); //create object of ExcelDataProvider
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Pymidol_"+Helper.getCurrentDateTime() +".html"));
		report=new ExtentReports();  //create object
		report.attachReporter(extent); //attach report
		
		Reporter.log("Setting done - Test can be Started", true);
	}
	
	
	
	//public void setup()
	//below line is used to take the browser at run time from cmd
	//@Parameters({"browser","urlToBeTested"})
	//public void setup(String browser, String urlToBeTested)
	@BeforeClass
	public void setup() //take the browser from configuration file
	
	{
		
		Reporter.log("Trying to start browser and getting application ready", true);
		
	
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL()); //if something gets wrong, it will not generate log, it will stop here
		
		//below line is used to take the browser and url from command prompt
		//driver=BrowserFactory.startApplication(driver, browser, urlToBeTested);
		
		Reporter.log("Browser and Application is up and Running", true);
	}
	
	@AfterClass
	public void tearDown(){
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			//in case test fail attach screenshot and attach in report
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			//in case test pass attach screenshot and attach in report
		}
		
		report.flush();
		
		Reporter.log("Test completed >>> Reports Generated", true);
	}
	
}
