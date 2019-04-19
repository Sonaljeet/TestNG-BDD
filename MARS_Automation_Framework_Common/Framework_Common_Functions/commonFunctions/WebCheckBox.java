/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebCheckBox {
	private WebDriver driver;
	private WebElement element;
	
	public WebCheckBox() {
		this.driver = driver;
		this.element = element;
	}
	
	public WebCheckBox(int a) {
		this.driver = driver;
		this.element = element;
	}
	
	//Select Checkbox for webelement.
	public static void Select_The_Checkbox(WebElement element, ExtentTest logger) {
		try {
            if (element.isSelected()) {
            	logger.log(LogStatus.INFO, "Checkbox: " + element + "is already selected");
               //logger.info("Checkbox: " + element + "is already selected");
            } else {
            	// Select the checkbox
            	logger.log(LogStatus.INFO, "Successfully checked the checkbox");
                element.click();
            }
        } catch (Exception e) {
        	//logger.info("Unable to select the checkbox: " + element);
        	logger.log(LogStatus.ERROR, "Unable to select the checkbox: " + element);
        }
		
	}
	
	//Deselect Checkbox for webelement
	public static void DeSelect_The_Checkbox(WebElement element, ExtentTest logger) {
		try {
            if (element.isSelected()) {
                element.click();
                logger.log(LogStatus.INFO, "Checkbox: " + element + " is deselected successfully");
            } else {
            	logger.log(LogStatus.INFO,"Checkbox: "+element+" is already deselected");
            }
        } catch (Exception e) {
        	logger.log(LogStatus.ERROR, "Unable to deselect the checkbox: " + element);
        }
    }	
	
	
	
	// Check check Box selected or not	
		public static boolean isChecked(WebElement element, ExtentTest logger) {
			boolean bValue = false;
			if (element != null && element.isSelected() == false) {
				element.click();
				bValue = true;
				//logger.log(LogStatus.INFO, "Checkbox: " + element + " is checked successfully.");
			} else if (element != null && element.isSelected() == true) {
				bValue = true;
				//logger.log(LogStatus.INFO, "Checkbox: " + element + " is already checked.");
			} 
			return bValue;
		}
		
		
		
	//Method is used to select the CheckBox with the specified value from multiple CheckBoxes.
	public static void Select_The_CheckBox_from_List(WebElement element, String valueToSelect, Logger logger) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			   System.out.println("Option value "+option.getText());
			        if (valueToSelect.equals(option.getText())) {
			            option.click();
			            logger.info("CheckBox selected from multiple CheckBoxes");
			            break;
			        }
			    }
	}
	
}
