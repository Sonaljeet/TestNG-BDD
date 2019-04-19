/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebInputTextBox {
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;

	
	private WebDriver driver;
	private WebElement webEleemnt;
		
	/**
	 * Constructor.
	 *
	 * @param driver the driver
	 * @param webelement the webelement
	 */
	public WebInputTextBox(WebDriver driver, WebElement webelement, ExtentTest logger) {
		this.driver = driver;
		this.webEleemnt = webelement;
		this.logger= logger;
	}
	
	/**
	 * Check expected watermarked text is displayed.
	 *
	 * @param Field watermarked the user name
	 * 
	 * @return True or False
	 */
	public static boolean watermarkedTextMatch (WebDriver driver,
			                             ExtentTest logger,
			                             WebElement element, 
			                             String expectedWatermarkedText) {
		boolean watermarkedTextMatched = false;
		if(element!= null){
			 String actualWatermarkedText;
			 actualWatermarkedText = WebElementCommon.getElementAttributeValue(driver, logger, element, "placeholder");
			 if (actualWatermarkedText.equals(expectedWatermarkedText)){
	         watermarkedTextMatched = true;
			 logger.log(LogStatus.PASS, "Expected watermarked text "+ actualWatermarkedText +" IS present in the input field.");  
		    }			
		}
		else{
			logger.log(LogStatus.FAIL, "Expected watermarked text is NOT present in the input field");   
		}
		return watermarkedTextMatched;
	}

	/**
	 * Send input text box.
	 *
	 * @param driver the driver
	 * @param webelement the webelement
	 * @param textToEntered the text to entered
	 * @return true, if successful
	 */
	public static boolean SendInputTextBox(WebDriver driver, 
											WebElement webelement, 
											String textToEntered) {	
		boolean exists = false;

		try {
			webelement.sendKeys(textToEntered);
			exists = true;
		} catch (Exception e) {
			// nothing to do.
		}
		return exists;
	}
	
	

	  /**
	   * to check whether textbox is blank or not with logger 
	 * @param element
	 * @param Message
	 * @param logger
	 * @throws Exception
	 */
	public static void checkBlankTextboxWithLogger(WebElement element,String Message,ExtentTest logger) throws Exception{
	      boolean checkobox_status=false;
	      if((element.getAttribute("value").equalsIgnoreCase(""))){
	    	  logger.log(LogStatus.PASS, Message+" textbox is cleared succesfully"); 
	      }else{
	    	  logger.log(LogStatus.FAIL, Message+" textbox is not cleared"); 
	    	  throw new Exception("Element not found");
	      }
	     
	  }
	
	
	  /**
	   * Send input to the textbox with logger
	 * @param element
	 * @param Message
	 * @param text
	 * @param logger
	 * @throws Exception
	 */
	public static void sendInputTextBoxWithLogger(WebDriver driver,WebElement element,String Message,String text,ExtentTest logger) throws Exception{
		  if(element!= null){
				if((element.isDisplayed()) && (element.isEnabled())){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, text);
					logger.log(LogStatus.PASS, Message+ " Entered succesfully to "+Message+ "WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for "+Message+" Field Failed");  
				throw new Exception("Element not found");
			}
	  }
	
}
