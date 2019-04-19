/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class WebDropDown {

	private static Select oselect;
	private static boolean status = false;

	/**
	 * Checks if drop down is visible.
	 *
	 * @param WebDriver
	 *            the driver
	 * @param By
	 *            the by
	 * @return true, if drop down is visible, else false
	 * 
	 * @throws NoSuchElementException
	 * 
	 */
	public static boolean isDropDownVisible(WebDriver driver, By by) {
		WebDriverWait zeroWait = new WebDriverWait(driver, 10);
		ExpectedCondition<org.openqa.selenium.WebElement> c = ExpectedConditions.presenceOfElementLocated(by);
		try {
			zeroWait.until(c);
			// logger.debug("Create New Application button is visible");
			return true;
		} catch (TimeoutException e) {
			// logger.debug("Create New Application button is not visible");
			return false;
		}
	}

	/**
	 * Select element by visible text.
	 *
	 * @param element
	 *            the WebElement reference of DropDown
	 * @param textValue
	 *            the String value to be selected from DropDown
	 * @return returns true if value is selected, false otherwise
	 * 
	 * @throws NoSuchElementException
	 * 
	 * @see {@link Selector}
	 * 
	 * 
	 */
	public static Boolean SelectElementByVisibleText(WebElement element, String textValue) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				oselect = new Select(element);
				oselect.selectByVisibleText(textValue);
				status = true;
				return status;
			} else {
				status = false;
				return status;
			}
		} catch (NoSuchElementException nse) {

			System.out.println("Element not found : " + nse.getMessage());
			return false;
		}

	}

	/**
	 * Select element by value tag in HTML.
	 *
	 * @param element
	 *            the WebElement reference of DropDown
	 * @param textValue
	 *            the String value to be selected from DropDown
	 * @return returns true if value is selected, false otherwise
	 * 
	 * @throws NoSuchElementException
	 * 
	 * @see {@link Selector}
	 */
	public static Boolean SelectElementByValue(WebElement element, String textValue) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				oselect = new Select(element);
				oselect.selectByValue(textValue);
				status = true;
				return status;
			} else {
				status = false;
				return status;
			}
		} catch (NoSuchElementException nse) {

			System.out.println("Element not found : " + nse.getMessage());
			return false;
		}

	}

	/**
	 * Select element by Index of dropdown value.
	 *
	 * @param element
	 *            the WebElement reference of DropDown
	 * @param textIndex
	 *            the {@link Integer} index to be selected from DropDown
	 * @return returns true if value is selected, false otherwise
	 * 
	 * @throws NoSuchElementException
	 * 
	 * @see {@link Selector}
	 */
	public static Boolean SelectElementByIndex(WebElement element, int textIndex) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				oselect = new Select(element);
				oselect.selectByIndex(textIndex);
				status = true;
				return status;
			} else {
				status = false;
				return status;
			}
		} catch (NoSuchElementException nse) {

			System.out.println("Element not found : " + nse.getMessage());
			return false;
		}

	}
	
	
	
	  /**
	 * To Select the specified text from the drop Down using the index of the dropdown option values with logger
	 * @param element
	 * @param index
	 * @param logger
	 * @throws Exception
	 */
	public static void selectByDesiredIndex(WebElement element, int index,ExtentTest logger) throws Exception {
	        try {
	               System.out.println("element "+element+"index "+index);
	               new Select(element).selectByIndex(index);
	               System.out.println("Option No."+index+" is Selected");
	             //  logger.log(LogStatus.INFO, "Option No."+index+" is Selected");
	        } catch (Exception e) {
	               logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
	             	throw new Exception("Element not found");
	        }
	  }
	

	  /**
	 * To get all the options values from the dropdown(Dropdown who is having the Select tag) 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public static List<String> getAllOptions(WebElement element) throws Exception{
	      List<String> options = new ArrayList<String>();
	      for (WebElement option : new Select(element).getOptions()) {
	          String txt = option.getText();
	          if (option.getAttribute("value") != "") options.add(option.getText());
	      }
	      return options;
	  }
	 
	  /**
	 * Get Selected Option value From DropDown 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public static String getSelectedOptionFromDropDown(WebElement element) throws Exception{
	    
	        Select sel_element_Val = new Select(element);
	        String element_Val_text = sel_element_Val.getFirstSelectedOption().getText();
	        return element_Val_text;
	  }
	
	
	  /**
	 * check whether dropdown is blank or not
	 * @param element
	 * @param Message
	 * @param logger
	 * @throws Exception
	 */
	public static void checkDropdownBlankOrNot(WebElement element,String Message,ExtentTest logger) throws Exception{
		  if(getSelectedOptionFromDropDown(element).contains("Select")){
				logger.log(LogStatus.PASS, Message+" dropdown is cleared successfully"); 
			}else{
				logger.log(LogStatus.FAIL, Message+" dropdown is not cleared");
				throw new Exception("Element not found");
			}
	  }
	
	  /**
	   * To Select the specified text from the drop Down using the text of the dropdown option values with logger
	 * @param element
	 * @param text
	 * @param logger
	 * @throws Exception
	 */
	public static void selectByVisibleText(WebElement element, String text,ExtentTest logger) throws Exception {
			try {
				System.out.println("element "+element+"text "+text);
				new Select(element).selectByVisibleText(text);
				//System.out.println(text.toUpperCase()+" Option is Selected");
				logger.log(LogStatus.INFO, text.toUpperCase()+" Option is Selected");
			} catch (Exception e) {
				logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
				throw new Exception("Element not found");
			}
		}
	  
	/**
	 * To Select the specified text from the drop Down using the text of the dropdown option values with logger and all webelement enabled,displayed and null conditions handling.
	 * @param element
	 * @param text
	 * @param logger
	 * @throws Exception
	 */
	  public static void selectDropDownWithLogger(WebElement element,String Message,String text,ExtentTest logger) throws Exception{
		  if(element!= null){
			  if((element.isDisplayed()) && (element.isEnabled())){
			  if(checkDropDownOptionsValue(element, text)){
				selectByVisibleText(element, text,logger);//accessfrom common methods
				logger.log(LogStatus.PASS, Message+" Entered succesfully to "+ Message+" WebElement");  
			  }else{
				  logger.log(LogStatus.FAIL, "Specified dropdown value is not present in dropdown"); 
				  throw new Exception("Element not found");
			  }
			}
		}
		  
	  }	  
		
		  /**
		   * To check whether specified dropdown option value is present in dropdown.
		 * @param element
		 * @param dropdownvalue_string
		 * @return
		 * @throws Exception
		 */
		public static boolean checkDropDownOptionsValue(WebElement element,String dropdownvalue_string) throws Exception{
			  List<String> expecteddropdownvalue=new ArrayList<String>();
			  expecteddropdownvalue.add(dropdownvalue_string);
			  return getAllOptions(element).containsAll(expecteddropdownvalue);
		  }
}
