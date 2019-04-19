/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class WebLink.
 */
public class WebLink {

	/** The driver. */
	private WebDriver driver;
	
	/** The web eleemnt. */
	private WebElement webelement;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;

	/**
	 * Instantiates a new web link.
	 *
	 * @param driver the driver
	 * @param webelement the webelement
	 */
	public WebLink(WebDriver driver, WebElement webelement) {
		this.driver = driver;
		this.webelement = webelement;
	}

	/**
	 * Send click to link.
	 *
	 * @param driver
	 *            {@link WebDriver}
	 * @param webelement
	 *            {@link WebElement}
	 * @return true, if successful, else false
	 */
	public static boolean SendClickToLink(WebDriver driver, WebElement webelement) {
		boolean exists = false;

		try {
			webelement.click();
			exists = true;
		} catch (NoSuchElementException e) {
			// nothing to do.
		}
		return exists;
	}
	
	/**
	 * Gets the all links.
	 *
	 * @param driver the driver
	 * @return the all links
	 */
	public static List<WebElement> getAllLinksByCSSSelector(WebDriver driver, String cssSelector){
		List<WebElement> list= null;
		
		WebElement element=driver.findElement(By.cssSelector("ul[class=sidebar-menu]"));
		list = element.findElements(By.cssSelector(cssSelector));
		return list;
	}

	/**
	 * Send click to link.
	 *
	 * @param driver the driver
	 * @param space the space
	 * @return true, if successful
	 */
	public static boolean SendClickToLink(WebDriver driver, String space) {
		boolean exists = false;
		try {
			if(WebElementCommon.waitForElementPresent(driver, space, logger)){
				driver.findElement(By.linkText(space)).click();
				exists = true;
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return exists;
	}
	
	/**
	 * Send click to link.
	 *
	 * @param driver the driver
	 * @param element the element
	 * @param space the space
	 * @return true, if successful
	 */
	public static boolean SendClickToLink(WebDriver driver, WebElement element, String space) {
		boolean exists = false;
		try {
			if(WebElementCommon.waitForElementPresent(driver, space, logger)){
				if(element!=null){
					element.click();
					exists = true;
				}
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return exists;
	}
}
