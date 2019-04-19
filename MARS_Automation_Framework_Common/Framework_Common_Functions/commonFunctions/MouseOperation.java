/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MouseOperation {
	
	private static WebDriver driver;
	private WebElement element;
	private static Logger logger;
	public MouseOperation() {
		this.driver = driver;
		this.element = element;
		this.logger = logger;
	}
	
	/**
	 * Right click on a WebElement.
	 *
	 * @param element {@link WebElement}
	 */
	public static void rightClick(WebElement element) {
		try {
			Actions action = new Actions(driver).contextClick(element);
			action.build().perform();
			logger.info("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			logger.info("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			logger.info("Element " + element + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			logger.info("Element " + element + " was not clickable "
					+ e.getStackTrace());
		}
	}
	
	public static void hoverMouseToElement(WebDriver driver, ExtentTest logger, WebElement element){
		try {
			Actions action=new Actions(driver);
			action.build().perform();
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Failed to hover mouse over the webelement " + element);
			e.printStackTrace();
		}
	}
}
