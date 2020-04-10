package com.pymidol.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshots, Frames, Alerts, Multiple Windows, Sync Issues, JavaScript Executor(Custom Libraries)
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  //TakesScreenshot interface have method getScreenshotAs
		String screenshotPath=System.getProperty("user.dir")+"/Screeoshots/Pymidol_"+ getCurrentDateTime() +".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
			
			System.out.println("Screenshot Captured");
			
		} catch (IOException e) {
			
			System.out.println("Unable to Capture Screenshot"+e.getMessage());
		}
		
		return screenshotPath;

	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		
		Date currentDate=new Date();
		
		return customFormat.format(currentDate);
	}
	
}
