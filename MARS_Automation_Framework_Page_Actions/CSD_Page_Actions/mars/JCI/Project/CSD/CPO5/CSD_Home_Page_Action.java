/*-------------------------------------------------------------------------------------

(C) Copyright 2016 Johnson Controls, Inc. 
    Use or Copying of all or any part of this program, except as
    permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/
/**
 * @author cdeyso
 *
 */

 package mars.JCI.Project.CSD.CPO5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.Setup.CPO5.CSD_Home_Page_Factory;

public class CSD_Home_Page_Action{


	private WebDriver driver = null;
	private ExtentTest logger = null;
	private WebElement element = null;
	
	public CSD_Home_Page_Action(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.driver = driver;
	}
	
	public boolean isDashboardMenuPresent() {
		boolean isUserMenuPresent = false;
		CSD_Home_Page_Factory homePF = new CSD_Home_Page_Factory(driver, logger);
		waitForPageToLoad();
		element = homePF.get_homeLeftMenuLink();
		if(element!= null){
			isUserMenuPresent = WebElementCommon.isElementPresent(driver, element);
			if(isUserMenuPresent){
				logger.log(LogStatus.PASS, "Succesfully identify Dashboard Menu WebElement");   
			}
		}
		else{
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Identifying WebElement for User Menu Field Failed");   
		}
		return isUserMenuPresent;
	}
	
	public void waitForPageToLoad(){
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}

}
