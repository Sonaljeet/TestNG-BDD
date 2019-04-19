/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;

public class WebPage {
	
	private WebDriver driver;
	private WebElement element;
	
	public WebPage() {
		this.driver = driver;
		this.element = element;
	}
	
	/**
<<<<<<< HEAD
	 * Scroll to bottom of A page.
=======
	 * Scrolls to bottom of A page.
>>>>>>> master
	 *
	 * @param driver {@link WebDriver}
	 */
	public static void scrollingToBottomOfAPage(WebDriver driver) {
		 ((JavascriptExecutor) driver)
         .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	/**
	 * Scroll to element.
	 *
	 * @param driver {@link WebDriver}
	 * @param element {@link WebElement}
	 */
	public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        
    }
	
	/**
	 * Search text on web page. This method can be used to search for a 
	 * message which populates at runtime. 
	 * Ex : Error message that is shown on login page for incorrect credentials
	 *
	 * @param driver  {@link WebDriver}
	 * @param textToSearch the text to search
	 * @return true if text is found, otherwise false
	 * @throws ElementNotFoundException : the element not found exception
	 * @throws ElementNotVisibleException : the element not visible exception
	 */
	public static Boolean searchTextOnWebPage(WebDriver driver, String textToSearch) throws ElementNotFoundException, ElementNotVisibleException{
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		
		Boolean textStatus = bodyText.contains(textToSearch);
		//Boolean textStatus = driver.getPageSource().contains(textToSearch);
		
		if (textStatus) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Wait for page load.
	 *
	 * @param driver the driver
	 */
	public static void waitForPageLoad(WebDriver driver) {

	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver_) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver_).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver_).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
		
	/**
	 * Wait for Javascript and JQuery to load.
	 *
	 * @param driver the driver
	 * @return true, if successful
	 */
	public static boolean waitForJSandJQueryToLoad(WebDriver driver) {

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
}