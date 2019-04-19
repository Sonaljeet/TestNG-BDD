/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Component.Functions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ThreadPool {
	private ExtentTest logger;
	
	public static WebDriver invokeBrowser(String url, ExtentTest logger) {
		try {
			//System.out.println("Thread id = " + Thread.currentThread().getId());
			//System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
			LocalDriverManager.getDriver().get(url);
			return LocalDriverManager.getDriver();
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Failed to Invoke Browser");
			return null;
		}
	}
	
	public ThreadPool(ExtentTest logger) {
		this.logger = logger;
		logger.log(LogStatus.INFO, "Succesfully instantiate instance of class.");
	}
	
	public ThreadPool() {
		this.logger = logger;
		logger.log(LogStatus.INFO, "Succesfully instantiate instance of class - "+ this.getClass());
	}
}
