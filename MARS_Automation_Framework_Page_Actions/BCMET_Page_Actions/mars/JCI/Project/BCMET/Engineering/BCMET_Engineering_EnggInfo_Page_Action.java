package mars.JCI.Project.BCMET.Engineering;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;

public class BCMET_Engineering_EnggInfo_Page_Action {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	private static final By IMAGELOADER = By.id("imgLoadingIcon");
	private BCMET_Engineering_EnggInfo_Page_Factory enggInfoFactory = null;
	
	public BCMET_Engineering_EnggInfo_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		enggInfoFactory = new BCMET_Engineering_EnggInfo_Page_Factory(driver, logger);
	}
	
	//Test Methods -- START
	
	public boolean checkAllItems(){
		boolean testStaus = false;
		
		
		
		return testStaus;
		
	}
	//Test Methods -- END
	
	
	
	//WebElement Getters -- START
	
	//Equipment Configuration - 
	public void selectAddEquipmentTypeFromDD(String equipmentToSelect){
		WebElement element = enggInfoFactory.get_DD_AddQuipmentType();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			
			WebElement tableGridMainElement = enggInfoFactory.get_AddQuipmentTypeTableGrid();
			List<WebElement> tableValues = tableGridMainElement.findElements(By.tagName("li"));
			boolean elementSelected = false;
			if (tableValues != null) {
				for(WebElement tableRow : tableValues){
					
					if (tableRow.getText().trim().equalsIgnoreCase(equipmentToSelect)) {
						System.out.println("rowName :"+tableRow.getText());
						//WebCheckBox.Select_The_Checkbox(tableRow, logger);
						//tableRow.click();
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", tableRow);
						WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

						if (tableRow.isSelected()) {
							elementSelected = true;
							System.out.println("Checkbox is selected");
							break;
						}
						
					}
				}
			}
			if (elementSelected) {
				logger.log(LogStatus.PASS, "Equipment '"+equipmentToSelect+"' selected successfully");
			}else{
				logger.log(LogStatus.FAIL, "Equipment '"+equipmentToSelect+"' not found");
			}
		}
	}
	
	public void clickOnAccordionLabel(String labelName) {
		WebElement element = enggInfoFactory.get_MainAccordionTableGrid();
		List<WebElement> tableVales = element.findElements(By.tagName("span"));
		boolean elementFound = false;
		if (element != null) {
			for (WebElement tableRow : tableVales) {
				String tableRowName = tableRow.getText().trim();
				if (tableRowName.equalsIgnoreCase(labelName)) {
					WebButton.Button_Click(driver, tableRow);
					WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
					elementFound = true;
				}
			}
		}
		if (elementFound) {
			logger.log(LogStatus.PASS, "Equipment configuration '" + labelName + "' selected successfully");
		} else {
			logger.log(LogStatus.FAIL, "Equipment configuration '" + labelName + "' not found");
		}
	}
	
	//AHU I/O points configuration
	public void enterAHUEquipmentType(String equipmentName){
		WebElement element = enggInfoFactory.get_EnggInfo_AHU_Equipment_Type_Name();
		
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, equipmentName);
			logger.log(LogStatus.PASS, "Text '"+equipmentName+"' entered successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Equipment_Type_Name text box for AHU");
		}
	}
	
	public void selectBaseConfiguration(String baseConfigValue) {
		WebElement element = null;
		element = enggInfoFactory.get_EnggInfo_AHU_DD_BaseConfig();
		boolean elementFound = false;

		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebElement tableGrid = enggInfoFactory.get_EnggInfo_AHU_DD_BaseConfig_ValueGrid();

			List<WebElement> baseConfigValGrid = tableGrid.findElements(By.tagName("li"));

			if (baseConfigValGrid != null) {
				for (WebElement tableRow : baseConfigValGrid) {
					String rowName = tableRow.getText().trim();
					if (rowName.equalsIgnoreCase(baseConfigValue)) {

					}
				}
			}
		}

		if (elementFound) {
			logger.log(LogStatus.PASS,
					"Base Configuration '<label>" + baseConfigValue + "</label>' selected successfully");
		} else {
			logger.log(LogStatus.FAIL, "Base Configuration '<label>" + baseConfigValue + "</label>' not found");
		}
	}
	
	
	//WebElement Getters -- END
}
