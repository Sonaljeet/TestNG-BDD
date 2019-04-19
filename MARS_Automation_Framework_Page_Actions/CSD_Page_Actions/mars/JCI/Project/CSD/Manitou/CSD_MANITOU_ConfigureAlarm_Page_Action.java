/**
 * 
 */
package mars.JCI.Project.CSD.Manitou;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.Setup.MANITOU.CSD_SetManitou_Page_Factory;

/**
 * @author cdeyso
 *
 */
public class CSD_MANITOU_ConfigureAlarm_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_SetManitou_Page_Factory manitouPageFactory = null;
	private static CSD_MANITOU_DataValidation_Master manitouDataValMaster = null;
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	public static List<String> customer_names = new ArrayList<String>();
	public static List<String> alarmType_names = new ArrayList<String>();
	public static List<String> alarmType_values = new ArrayList<String>();
	public static String selCommPtotocolType,selCustomerName,selFacilityName,selAssetName,selAlarmTypeName,selAlarmValue = null;
	public static int randomCustIndex,randomFacilityIndex,randomAssetIndex,randomAlarmTypeIndex = 0;
	
	
	@SuppressWarnings("static-access")
	public CSD_MANITOU_ConfigureAlarm_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		manitouPageFactory = new CSD_SetManitou_Page_Factory(driver, logger);
		manitouDataValMaster = new CSD_MANITOU_DataValidation_Master(logger);
	}
	
	//Waiting for the Spinner to Disappear -- a workaround for not using Thread.sleep(2000)
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	//Get a Random Number between a provided range for further Random Cross Testing.
	public static int getRamdomNoBetweenRange(int min,int max) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
	
	//To Select the specified textfrom the drop Down
	public static void selectByVisibleText(WebElement element, String text) {
		
		try {
			System.out.println("element "+element+"text "+text);
			new Select(element).selectByVisibleText(text);
			System.out.println(text.toUpperCase()+" Option is Selected");
			logger.log(LogStatus.INFO, text.toUpperCase()+" Option is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
		}
	}
	
	//To Select the specified textfrom the drop Down
	public static void selectByDesiredIndex(WebElement element, int index) {
		
		try {
			System.out.println("element "+element+"index "+index);
			new Select(element).selectByIndex(index);
			System.out.println("Option No."+index+" is Selected");
			logger.log(LogStatus.INFO, "Option No."+index+" is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
		}
	}
	
	//To get all the Values under a dropdown 
	public static List<String> getAllOptions(WebElement element) {
	    List<String> options = new ArrayList<String>();
	    for (WebElement option : new Select(element).getOptions()) {
	        String txt = option.getText();
	        if (option.getAttribute("value") != "") options.add(option.getText());
	    }
	    return options;
	}
	
	//Get Selected Option From DropDown
	public static String getSelectedOptionFromDropDown(WebElement element) {
		
		Select sel_element_Val = new Select(element);
		String element_Val_text = sel_element_Val.getFirstSelectedOption().getText();
		return element_Val_text;
	}
	
	//--------------------------------------------------- WebElement related methods--START ------------------
	
	//Click on the Rap Alarm Test Tab
	public static void getToRapAlarmTestPage() {
		
		waitForSpinnerToDisappear();
		WebElement adminTab_element = manitouPageFactory.get_manitou_AdministrationLink();
		if(adminTab_element !=null && adminTab_element.isEnabled()){
			adminTab_element.click();
			waitForSpinnerToDisappear();
			WebElement sccTab_element = manitouPageFactory.get_manitou_SCCTabLink();
			sccTab_element.click();
			waitForSpinnerToDisappear();
			WebElement rtaTab_element = manitouPageFactory.get_manitou_RTATabLink();
			rtaTab_element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			validateRTSPageLoad();
			logger.log(LogStatus.PASS, "Rap Test Alarm Page is opened successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to open Rap Test Alarm Page.");
		}
		
	}
	
	//Validate if the RTA Page is loaded properly or not
	public static void validateRTSPageLoad() {
		
		waitForSpinnerToDisappear();
		WebElement custNamesList_element = manitouPageFactory.get_manitou_RTA_CustomerDDLLink();
		if(custNamesList_element!=null && custNamesList_element.isEnabled()){
			logger.log(LogStatus.INFO, "Rap Test Alarm Page is loaded successfully");
		}else if(custNamesList_element==null){
			waitForSpinnerToDisappear();
			WebElement homeBtn_element = manitouPageFactory.get_manitou_HomeButtonLink();
			homeBtn_element.click();
			waitForSpinnerToDisappear();
			WebElement adminTab_element = manitouPageFactory.get_manitou_AdministrationLink();
			adminTab_element.click();
			getToRapAlarmTestPage();
		}
	}
	
	
	//Select Customer from DropDown List
	@SuppressWarnings("static-access")
	public static void selectCustomerFromDDL() 
			throws SQLException, ClassNotFoundException, InterruptedException {
		
		waitForSpinnerToDisappear();
		Thread.sleep(2000);
		manitouDataValMaster.checkIfValidManitouCustomerAreReflected("souvik");
		WebElement custNamesList_element = manitouPageFactory.get_manitou_RTA_CustomerDDLLink();
		customer_names = getAllOptions(custNamesList_element);
		System.out.println(customer_names.size()+" -- "+manitouDataValMaster.custName.size());
		if(customer_names.size()-1 == manitouDataValMaster.custName.size()){
			logger.log(LogStatus.INFO, "Valid Number of Customer Names are getting reflected under the DropDown.");
			for (int i = 0; i < manitouDataValMaster.custName.size(); i++) {
				if (manitouDataValMaster.custName.get(i).contains(customer_names.get(i+1))) {
					System.out.println("Branch : "+manitouDataValMaster.custName.get(i)+" is Present and is mapped properly in the SSF Form !");
					logger.log(LogStatus.PASS, "Branch : "+manitouDataValMaster.custName.get(i)+" is Present and is mapped properly in the SSF Form !");
				}
			}
			waitForSpinnerToDisappear();
			randomCustIndex = getRamdomNoBetweenRange(2,  manitouDataValMaster.custName.size());
			selectByDesiredIndex(custNamesList_element, randomCustIndex);
			waitForSpinnerToDisappear();
			selCustomerName = getSelectedOptionFromDropDown(custNamesList_element);
			logger.log(LogStatus.INFO, selCustomerName+" Option is Selected for Testing From the Customer Name DropDown.");
		}else{
			logger.log(LogStatus.FAIL, "Invalid Number of Customer Names are getting reflected under the DropDown.");
			logger.log(LogStatus.FAIL, "Number of options listed : "+customer_names.size()+" and Number of Eligible options are : "+manitouDataValMaster.custName.size());
		}
	}
	
	
	//Select Facility from DropDown List
	@SuppressWarnings("static-access")
	public static void selectFacilityFromDDL() 
			throws ClassNotFoundException, SQLException {
		
		waitForSpinnerToDisappear();
		WebElement facilityNamesList_element = manitouPageFactory.get_manitou_RTA_FacilityDDLLink();
		if (facilityNamesList_element!=null && facilityNamesList_element.isEnabled()) {
			String selCustID = manitouDataValMaster.custID.get(randomCustIndex-1);
			System.out.println("manitouDataValMaster.custID.get(randomCustIndex) "
					+ manitouDataValMaster.custID.get(randomCustIndex));
			manitouDataValMaster.checkIfValidManitouFacilityAreReflected(selCustID);
			System.out.println("manitouDataValMaster.projName " + manitouDataValMaster.projName);
			if (manitouDataValMaster.projName.size() > 1) {

				randomFacilityIndex = getRamdomNoBetweenRange(1, manitouDataValMaster.projName.size());
				selectByDesiredIndex(facilityNamesList_element, randomFacilityIndex);
				waitForSpinnerToDisappear();
				selFacilityName = getSelectedOptionFromDropDown(facilityNamesList_element);
				logger.log(LogStatus.INFO, selFacilityName+" option is selected From the Facility DropDown List");
				logger.log(LogStatus.PASS, "Valid Facility is Selected for Manitou alarm Setup.");
			} else if (manitouDataValMaster.projName.size() == 1) {
				
				selectByDesiredIndex(facilityNamesList_element, 1);
				waitForSpinnerToDisappear();
				selFacilityName = getSelectedOptionFromDropDown(facilityNamesList_element);
				logger.log(LogStatus.INFO, selFacilityName+" option is selected From the Facility DropDown List");
				logger.log(LogStatus.PASS, "Valid Facility is Selected for Manitou alarm Setup.");
			}
			
		}else{
			logger.log(LogStatus.FAIL, "Error occured while selecting the Facility From DropDown.");
		}
	}
	
	
	//Select Asset From the DropDown List
	@SuppressWarnings("static-access")
	public static void selectAssetFromDDL() 
			throws ClassNotFoundException, SQLException {
		
		waitForSpinnerToDisappear();
		WebElement assetNamesList_element = manitouPageFactory.get_manitou_RTA_AssetDDLLink();
		if(assetNamesList_element != null && assetNamesList_element.isEnabled()){
			manitouDataValMaster.checkIfValidManitouAssetsAreReflected();
			if (manitouDataValMaster.asset_assetDetID.size() > 1) {

				randomAssetIndex = getRamdomNoBetweenRange(1, manitouDataValMaster.asset_assetDetID.size());
				selectByDesiredIndex(assetNamesList_element, randomAssetIndex);
				waitForSpinnerToDisappear();
				selAssetName = getSelectedOptionFromDropDown(assetNamesList_element);
				logger.log(LogStatus.INFO, selAssetName+" option is selected From the Asset DropDown List");
				logger.log(LogStatus.PASS, "Valid Asset is Selected for Manitou alarm Setup.");
			} else if (manitouDataValMaster.asset_assetDetID.size() == 1) {
				
				selectByDesiredIndex(assetNamesList_element, 1);
				waitForSpinnerToDisappear();
				selAssetName = getSelectedOptionFromDropDown(assetNamesList_element);
				logger.log(LogStatus.INFO, selAssetName+" option is selected From the Asset DropDown List");
				logger.log(LogStatus.PASS, "Valid Asset is Selected for Manitou alarm Setup.");
			}
			
		}else{
			logger.log(LogStatus.FAIL, "Error occured while selecting the Facility From DropDown.");
		}
	}
	

	//Validate the Asset Details reflected on the UI
	@SuppressWarnings("static-access")
	public static void validateReflectedAssetDetails() {
		
		waitForSpinnerToDisappear();
		WebElement commProtoText_element = manitouPageFactory.get_manitou_RTA_CommProtocolTextLink();System.out.println(commProtoText_element.getText());
		WebElement ownerDetails_element = manitouPageFactory.get_manitou_RTA_OwnerTextLink();System.out.println(ownerDetails_element.getText());
		WebElement deviceDetails_element = manitouPageFactory.get_manitou_RTA_DeviceTextLink();System.out.println(deviceDetails_element.getText());
		WebElement eqpRefDetails_element = manitouPageFactory.get_manitou_RTA_EqpRefTextLink();System.out.println(eqpRefDetails_element.getText());
		
		if(commProtoText_element!= null && ownerDetails_element!=null && deviceDetails_element!=null && eqpRefDetails_element!=null){
			
			if(manitouDataValMaster.asset_assetDetID.size() > 1){
				
				if(manitouDataValMaster.asset_Modeltype.get(randomAssetIndex-1).equals(commProtoText_element.getText())){
					selCommPtotocolType = manitouDataValMaster.asset_Modeltype.get(randomAssetIndex-1);
					System.out.println(manitouDataValMaster.asset_Modeltype.get(randomAssetIndex-1)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_Modeltype.get(randomAssetIndex-1)+" is reflected properly on the UI.");
				}
				if(manitouDataValMaster.asset_owner.get(randomAssetIndex-1).equals(ownerDetails_element.getText())){
					System.out.println(manitouDataValMaster.asset_owner.get(randomAssetIndex-1)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_owner.get(randomAssetIndex-1)+" is reflected properly on the UI.");
				}
				if(manitouDataValMaster.asset_Device.get(randomAssetIndex-1).equals(deviceDetails_element.getAttribute("title"))){
					System.out.println(manitouDataValMaster.asset_Device.get(randomAssetIndex-1)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_Device.get(randomAssetIndex-1)+" is reflected properly on the UI.");
				}
				if(manitouDataValMaster.asset_reference.get(randomAssetIndex-1).equals(eqpRefDetails_element.getAttribute("title"))){
					System.out.println(manitouDataValMaster.asset_reference.get(randomAssetIndex-1)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_reference.get(randomAssetIndex-1)+" is reflected properly on the UI.");
				}
				logger.log(LogStatus.PASS, "Valid Asset Details are populated under the UI");
			}else if (manitouDataValMaster.asset_assetDetID.size() == 1) {
				if(manitouDataValMaster.asset_Modeltype.get(0).equals(commProtoText_element.getText())){
					selCommPtotocolType = manitouDataValMaster.asset_Modeltype.get(0);
					System.out.println(manitouDataValMaster.asset_Modeltype.get(0)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_Modeltype.get(0)+" is reflected properly on the UI.");
				}
				if(manitouDataValMaster.asset_owner.get(0).equals(ownerDetails_element.getText())){
					System.out.println(manitouDataValMaster.asset_owner.get(0)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_owner.get(0)+" is reflected properly on the UI.");
				}
				if(manitouDataValMaster.asset_Device.get(0).equals(deviceDetails_element.getAttribute("title"))){
					System.out.println(manitouDataValMaster.asset_Device.get(0)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_Device.get(0)+" is reflected properly on the UI.");
				}
				if(manitouDataValMaster.asset_reference.get(0).equals(eqpRefDetails_element.getAttribute("title"))){
					System.out.println(manitouDataValMaster.asset_reference.get(0)+" is reflected properly on the UI.");
					logger.log(LogStatus.PASS, manitouDataValMaster.asset_reference.get(0)+" is reflected properly on the UI.");
				}
				logger.log(LogStatus.PASS, "Valid Asset Details are populated under the UI");
			}
			
		}else{
			logger.log(LogStatus.FAIL, "Error Validating the Asset Details From UI");
		}
	}
	
	//Select an Alarm Type based on the Communication Protocol
	public static void validateAlarmTypeandAlarmValue() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		
		waitForSpinnerToDisappear();
		if(selCommPtotocolType.equals("YT2")){
			selectAlarmTypeFromDDL();
		}else if(selCommPtotocolType.equals("YT3")){
			selectAlarmTypeFromDDL();
			selectAlarmTypeValueFromDDL();
		}
		
	}

	
	//Select an Alarm Type From the Drop Down List
	@SuppressWarnings("static-access")
	public static void selectAlarmTypeFromDDL() 
			throws ClassNotFoundException, SQLException {
		
		waitForSpinnerToDisappear();
		WebElement alarmTypeList_element = manitouPageFactory.get_manitou_RTA_AlarmTypeDDLLink();
		if(alarmTypeList_element!=null && alarmTypeList_element.isEnabled()){
			if(manitouDataValMaster.asset_assetDetID.size() > 1){
				alarmType_names = getAllOptions(alarmTypeList_element);System.out.println("alarmType_names "+alarmType_names);
				manitouDataValMaster.checkIfValidManitouAlarmTypesAreReflected(randomAssetIndex-1);
				System.out.println(manitouDataValMaster.uniq_attName.size()+"--"+(alarmType_names.size()-1));
				if(manitouDataValMaster.uniq_attName.size() > 1){
					
					if(alarmType_names.size()-1 == manitouDataValMaster.uniq_attName.size()){
						logger.log(LogStatus.INFO, "Valid Alarm Types are populated under the UI");
						randomAlarmTypeIndex = getRamdomNoBetweenRange(1, manitouDataValMaster.uniq_attName.size());
						selectByDesiredIndex(alarmTypeList_element, randomAssetIndex);
						waitForSpinnerToDisappear();
						selAlarmTypeName = getSelectedOptionFromDropDown(alarmTypeList_element);
						logger.log(LogStatus.INFO, selAlarmTypeName+" option is selected From the Alarm Type DropDown List");
						logger.log(LogStatus.PASS, "Valid Alarm Type is Selected for Manitou alarm Setup.");
					}
				}else if (manitouDataValMaster.uniq_attName.size() == 1) {
					
					if(alarmType_names.size()-1 == manitouDataValMaster.uniq_attName.size()){
						logger.log(LogStatus.INFO, "Valid Alarm Types are populated under the UI");
						selectByDesiredIndex(alarmTypeList_element, 1);
						waitForSpinnerToDisappear();
						selAlarmTypeName = getSelectedOptionFromDropDown(alarmTypeList_element);
						logger.log(LogStatus.INFO, selAlarmTypeName+" option is selected From the Alarm Type DropDown List");
						logger.log(LogStatus.PASS, "Valid Alarm Type is Selected for Manitou alarm Setup.");
					}
				}
			}else if (manitouDataValMaster.asset_assetDetID.size() == 1) {
				alarmType_names = getAllOptions(alarmTypeList_element);System.out.println("alarmType_names "+alarmType_names);
				manitouDataValMaster.checkIfValidManitouAlarmTypesAreReflected(0);
				System.out.println(manitouDataValMaster.uniq_attName.size()+"--"+(alarmType_names.size()-1));
				if(manitouDataValMaster.uniq_attName.size() > 1){
					
					if(alarmType_names.size()-1 == manitouDataValMaster.uniq_attName.size()){
						logger.log(LogStatus.INFO, "Valid Alarm Types are populated under the UI");
						randomAlarmTypeIndex = getRamdomNoBetweenRange(1, manitouDataValMaster.uniq_attName.size());
						selectByDesiredIndex(alarmTypeList_element, randomAssetIndex);
						waitForSpinnerToDisappear();
						selAlarmTypeName = getSelectedOptionFromDropDown(alarmTypeList_element);
						logger.log(LogStatus.INFO, selAlarmTypeName+" option is selected From the Alarm Type DropDown List");
						logger.log(LogStatus.PASS, "Valid Alarm Type is Selected for Manitou alarm Setup.");
					}
				}else if (manitouDataValMaster.uniq_attName.size() == 1) {
					
					if(alarmType_names.size()-1 == manitouDataValMaster.uniq_attName.size()){
						logger.log(LogStatus.INFO, "Valid Alarm Types are populated under the UI");
						selectByDesiredIndex(alarmTypeList_element, 1);
						waitForSpinnerToDisappear();
						selAlarmTypeName = getSelectedOptionFromDropDown(alarmTypeList_element);
						logger.log(LogStatus.INFO, selAlarmTypeName+" option is selected From the Alarm Type DropDown List");
						logger.log(LogStatus.PASS, "Valid Alarm Type is Selected for Manitou alarm Setup.");
					}
				}
			}
		}
	}

	
	//Select an Alarm Value from the Drop Down List -- Based on the Alarm Type Selection
	@SuppressWarnings("static-access")
	public static void selectAlarmTypeValueFromDDL()
			throws ClassNotFoundException, SQLException, InterruptedException {
		
		waitForSpinnerToDisappear();
		Thread.sleep(2000);
		WebElement alarmValue_element = manitouPageFactory.get_manitou_RTA_AlarmValueDDLLink();
		if(alarmValue_element!=null && alarmValue_element.isEnabled()){
			alarmType_values = getAllOptions(alarmValue_element);System.out.println("alarmType_values "+alarmType_values);
			if(manitouDataValMaster.uniq_attName.size() > 1){
				manitouDataValMaster.checkIfValidManitouAlarmValuesAreReflected(randomAlarmTypeIndex-1, selAlarmTypeName);
				if(alarmType_values.size()-1 == manitouDataValMaster.alarm_Value.size()){
					logger.log(LogStatus.INFO, "Valid number of Alarm Values are reflected under the DropDown List.");
					selectByDesiredIndex(alarmValue_element, 1);
					waitForSpinnerToDisappear();
					selAlarmValue = getSelectedOptionFromDropDown(alarmValue_element);
					logger.log(LogStatus.INFO, selAlarmValue+" option is selected From the Alarm Values DropDown List");
					logger.log(LogStatus.PASS, "Valid Alarm Value is Selected for Manitou alarm Setup.");
				}else{
					logger.log(LogStatus.FAIL, "Invalid number of Alarm Values are reflected under the DropDown List.");
				}
			}else if(manitouDataValMaster.uniq_attName.size() == 1){
				manitouDataValMaster.checkIfValidManitouAlarmValuesAreReflected(0, selAlarmTypeName);
				if(alarmType_values.size()-1 == manitouDataValMaster.alarm_Value.size()){
					logger.log(LogStatus.INFO, "Valid number of Alarm Values are reflected under the DropDown List.");
					selectByDesiredIndex(alarmValue_element, 1);
					waitForSpinnerToDisappear();
					selAlarmValue = getSelectedOptionFromDropDown(alarmValue_element);
					logger.log(LogStatus.INFO, selAlarmValue+" option is selected From the Alarm Values DropDown List");
					logger.log(LogStatus.PASS, "Valid Alarm Value is Selected for Manitou alarm Setup.");
				}else{
					logger.log(LogStatus.FAIL, "Invalid number of Alarm Values are reflected under the DropDown List.");
				}
			}
			
			
			logger.log(LogStatus.PASS, " Option is Selected for Testing From the Alarm Value DropDown.");
		}else{
			logger.log(LogStatus.FAIL, "Error occured while selecting the Alarm Value Type");
		}
	}
}
