/**
 * 
 */
package mars.JCI.Project.CSD.HomePage.Dashboard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.MouseOperation;
import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.HomePage.Dashboard.CSD_HomePage_Dashboard_Page_Factory;

/**
 * @author cdeyso
 *
 */
public class CSD_HomePage_Dashboard_Page_Action {
	
	private static WebDriver driver=null;
	private static ExtentTest logger=null;
	
	private static CSD_HomePage_Dashboard_Page_Factory csdHomePageDB = null;
	private static CSD_HomePage_DataValidation_Master csdDataValMaster = null;
	
	public static List<String> dbPageChillerPointsList = new ArrayList<String>();
	public static List<String> dbPageChillerPointsValList = new ArrayList<String>();
	
	private static final By IMAGELOADER = By.cssSelector("div[test-id='loaderWidget']");
	
	@SuppressWarnings("static-access")
	public CSD_HomePage_Dashboard_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		csdHomePageDB = new CSD_HomePage_Dashboard_Page_Factory(driver, logger);
		csdDataValMaster = new CSD_HomePage_DataValidation_Master(logger);
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	public static int getRamdomNoBetweenRange(int min,int max) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
	
	
	//==========WebElement related metods--START
	
	//Click on the Red Section of the Chiller Status Details 
	public static void clickOnRedChillerStatus() throws InterruptedException{
		
		waitForSpinnerToDisappear();
		WebElement element=csdHomePageDB.get_hp_ChillerStatusRedLink();
		waitForSpinnerToDisappear();
		if (element !=null && element.isEnabled()) {
			System.out.println("clickOnRedChillerStatus");
			//JavascriptExecutor js =(JavascriptExecutor)driver;js.executeScript("window.scrollTo(0,"+element.getLocation().y+")");
			element.click();//MouseOperation.leftClick(element);//
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Chiller Status with RED is Clicked.");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click Chiller Status with RED");
		}
	}
	
	//Click on the Green Section of the Chiller Status Details 
	public static void clickOnGreenChillerStatus() throws InterruptedException{
		
		waitForSpinnerToDisappear();
		WebElement element=csdHomePageDB.get_hp_ChillerStatusGreenLink();
		waitForSpinnerToDisappear();
		if (element !=null && element.isEnabled()) {
			System.out.println("clickOnGreenChillerStatus");
			//JavascriptExecutor js =(JavascriptExecutor)driver;js.executeScript("window.scrollTo(0,"+element.getLocation().y+")");
			element.click();//MouseOperation.leftClick(element);//
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Chiller Status with GREEN is Clicked.");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click Chiller Status with GREEN");
		}
	}
	
	//Check for all the visible branches are Displayed under the Customer Name Section
	@SuppressWarnings("static-access")
	public static void validateAllValidCustNamesAreDisplayed() throws ClassNotFoundException, SQLException, InterruptedException {
		
		waitForSpinnerToDisappear();
		List<WebElement> custNameList=csdHomePageDB.get_hp_CustomerNameList();
		waitForSpinnerToDisappear();
		csdDataValMaster.getCSDDBSession();
		csdDataValMaster.checkIfValidCustNamesAreDisplayedForLoggedUser("souvik","#FF0000"); //List<String> dbValidNames = 
		if(custNameList.size() <= csdDataValMaster.custName.size()){
			logger.log(LogStatus.INFO, "The No of Customer Names Displayed : "+custNameList.size()+" and the Valid number of Customers for the logged user is : "+csdDataValMaster.custName.size());
			logger.log(LogStatus.INFO, "The No of Customer Names Displayed Falls under the Valid Names for the Logged In USER.");
			for (int i = 0; i < custNameList.size(); i++) {
				String uiCustName = custNameList.get(i).getText();
				System.out.println("uiCustName "+uiCustName);
				for (int j = 0; j < csdDataValMaster.custName.size(); j++) {
					//System.out.println("dbValidNames.get(j) "+dbValidNames.get(j));
					if(csdDataValMaster.custName.get(j).contains(uiCustName)){
						logger.log(LogStatus.PASS, uiCustName+" is a Valid Customer Name for the Logged in User and is displayed properly.");
					}
				}
			}
		}else{
			logger.log(LogStatus.FAIL, "The No of Customer Names Displayed is not under the Valid Names for the Logged In USER.");
		}
		
	}
	
	//Select A Random Customer Name for Validating the Site/Facility Change
	@SuppressWarnings("static-access")
	public static String selectSpecifiedCustNameFromUI() {
		
		waitForSpinnerToDisappear();
		int custNameVal = getRamdomNoBetweenRange(2, csdDataValMaster.custName.size()); System.out.println("custNameVal "+custNameVal);
		String selCustName = csdDataValMaster.custName.get(custNameVal);
		String selCustID = csdDataValMaster.custID.get(custNameVal);
		WebElement custNameTB = csdHomePageDB.get_hp_CustomerNameSearch();
		if(custNameTB != null){
			custNameTB.sendKeys(selCustName);
			waitForSpinnerToDisappear();
			WebElement custNameTB_result = csdHomePageDB.get_hp_custNameSearchResultTextElement(selCustName);
			custNameTB_result.click();
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, selCustName+" is the Customer Name Selected.");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			return selCustID;
		}else{
			logger.log(LogStatus.FAIL, "Unable to search for Cust Name - "+selCustName);
		}
		return null;
		
	}
	
	//Validate Site/Facility Name is Getting Filtered upon Customer Name Selection
	@SuppressWarnings("static-access")
	public static void validateAllValidFacilityNamesAreDisplayed() throws SQLException, InterruptedException {
		
		String selCustID = selectSpecifiedCustNameFromUI();
		Thread.sleep(5000);
		waitForSpinnerToDisappear();
		List<WebElement> facilityNameList=csdHomePageDB.get_hp_SiteFacilityNameList();
		if(facilityNameList.size() > 0){
			logger.log(LogStatus.INFO, "Facility Name is populated for the Selected Customer Name.");
			logger.log(LogStatus.INFO, "Total no of Facilities Reflected are - "+facilityNameList.size());
			csdDataValMaster.checkIfValidFacilityNamesAreDisplayedForLoggedUser(selCustID);
			waitForSpinnerToDisappear();
			if (facilityNameList.size() == csdDataValMaster.facilityProjName.size()) {
				logger.log(LogStatus.PASS, "All the Valid Facility Names are populated for the Selected Customer Name.");
				for (int i = 0; i <	 facilityNameList.size(); i++) {
					waitForSpinnerToDisappear();
					if (facilityNameList.get(i).getText().contains(csdDataValMaster.facilityProjName.get(i))) {
						logger.log(LogStatus.PASS, facilityNameList.get(i).getText()+" Facility is Reflected in the Application.");
						
					}else{
						logger.log(LogStatus.FAIL, "Facility Names are not Matching. Error Occured while Validating Facility Names.");
						logger.log(LogStatus.FAIL, "Facility Name is : "+facilityNameList.get(i).getText());
					}
				}
			}else{
				logger.log(LogStatus.FAIL, "Error Encountered while Populating the Facility Names for the Selected Customer.");
			}
		}else{
			logger.log(LogStatus.FAIL, "Error Encountered while Validating Facility Name.");
		}
	}
	
	//Select A Random Facility Name for Validating the Site/Facility Change
	@SuppressWarnings("static-access")
	public static String selectSpecifiedFacilityNameFromUI() {
		
		waitForSpinnerToDisappear();
		if (csdDataValMaster.facilityProjName.size() > 1) {
			int custNameVal = getRamdomNoBetweenRange(0, csdDataValMaster.facilityProjName.size());
			System.out.println("custNameVal " + custNameVal);
			String selFacilityName = csdDataValMaster.facilityProjName.get(custNameVal);
			String selFacilityProjID = csdDataValMaster.facilityProjID.get(custNameVal);
			WebElement facilityNameElement = csdHomePageDB.get_hp_facilityNameSearchResultTextElement(selFacilityName);
			if (facilityNameElement != null) {
				facilityNameElement.click();
				logger.log(LogStatus.INFO, selFacilityName + " Facility Name is Selected");
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				return selFacilityProjID;
			} else {
				logger.log(LogStatus.FAIL, "Error Encountered while selecting the Facility Names for the Customer.");
			} 
		}else{
			String selFacilityName = csdDataValMaster.facilityProjName.get(0);
			String selFacilityProjID = csdDataValMaster.facilityProjID.get(0);
			WebElement facilityNameElement = csdHomePageDB.get_hp_facilityNameSearchResultTextElement(selFacilityName);
			if (facilityNameElement != null) {
				facilityNameElement.click();
				logger.log(LogStatus.INFO, selFacilityName + " Facility Name is Selected");
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				return selFacilityProjID;
			} else {
				logger.log(LogStatus.FAIL, "Error Encountered while selecting the Facility Names for the Customer.");
			} 
		}
		return null;
	}
	
	
	//Check if upon selection of a facility the Asset is getting updated
	@SuppressWarnings("static-access")
	public static void validateAllValidAssetNamesAreDisplayed() throws SQLException, InterruptedException {
		
		waitForSpinnerToDisappear();
		Thread.sleep(2000);
		String selFacilityProjID = selectSpecifiedFacilityNameFromUI();
		List<WebElement> assetElement = csdHomePageDB.get_hp_ChillerNameList();
		if (assetElement.size() > 0) {
			logger.log(LogStatus.INFO, "Asset Name is populated for the Selected Customer Name.");
			logger.log(LogStatus.INFO, "Total no of Assets Reflected are - " + assetElement.size());
			for (int i = 0; i < assetElement.size(); i++) {
				Thread.sleep(1000);
				System.out.println(assetElement.get(i).getText());
				}
			csdDataValMaster.checkIfValidAssetNamesAreDisplayedForLoggedUser(selFacilityProjID);
			if (assetElement.size() == csdDataValMaster.assetAssetName.size()) {
				for (int i = 0; i < assetElement.size(); i++) {
					waitForSpinnerToDisappear();
					Thread.sleep(3000);
					if (assetElement.get(i).getText().contains(csdDataValMaster.assetAssetName.get(i))) {
						logger.log(LogStatus.PASS,
								assetElement.get(i).getText() + " Facility is Reflected in the Application.");

					} else {
						logger.log(LogStatus.FAIL,
								"Facility Names are not Matching. Error Occured while Validating Facility Names.");
					}
				}
			} else{
				logger.log(LogStatus.FAIL, "Error Encountered while Populating the Asset Names for the Selected Customer.");
			}
		}else{
			logger.log(LogStatus.FAIL, "Error Encountered while Validating Asset Name.");
		}
	}
	
	//Select the Nth Chiller Asset to Hover and Check Status Of
	@SuppressWarnings("static-access")
	public static List<String> hoverAndGetTripStatusForAsset() {
		
		waitForSpinnerToDisappear();
		List<String> randomAssetTripStatus = new ArrayList<String>();
		if(csdDataValMaster.assetTripStatus.size() > 1){
			logger.log(LogStatus.INFO, "There are More than One asset to validate Trip Status.");
			logger.log(LogStatus.INFO, "Selecting one Random asset to check Upon.");
			int custNameVal = getRamdomNoBetweenRange(0, csdDataValMaster.assetTripStatus.size()); System.out.println("custNameVal " + custNameVal);
			WebElement randomAssetTripStatus_element = csdHomePageDB.get_hp_ChillerStatusMessage(custNameVal);
			String randomAssetTripStatus_text = randomAssetTripStatus_element.getAttribute("title"); System.out.println("randomAssetTripStatus_text "+randomAssetTripStatus_text);
			randomAssetTripStatus.add(randomAssetTripStatus_text);
			randomAssetTripStatus.add(csdDataValMaster.assetTripStatus.get(custNameVal));
			System.out.println("randomAssetTripStatus_text "+randomAssetTripStatus);
			return randomAssetTripStatus;
		}else{ 
			logger.log(LogStatus.INFO, "There is only One asset to validate Trip Status.");
			WebElement randomAssetTripStatus_element = csdHomePageDB.get_hp_ChillerStatusMessage(0);
			String randomAssetTripStatus_text = randomAssetTripStatus_element.getAttribute("title"); System.out.println("randomAssetTripStatus_text "+randomAssetTripStatus_text);
			randomAssetTripStatus.add(randomAssetTripStatus_text);
			randomAssetTripStatus.add(csdDataValMaster.assetTripStatus.get(0));
			System.out.println("randomAssetTripStatus_text "+randomAssetTripStatus);
			return randomAssetTripStatus;
		}
	}
	
	
	//Check if asset is selected the status is getting reflected upon mouse hovering on tooltip
	public static void validateAssetStatusOnToolTip() {
		
		waitForSpinnerToDisappear();
		List<String> tripStatusValue = hoverAndGetTripStatusForAsset();
		String actualString = tripStatusValue.get(0);
		String expectedString = tripStatusValue.get(1);
		if(actualString.contains(expectedString)){
			logger.log(LogStatus.PASS, actualString+" is the proper Trip Status for the Selected Asset.");
		}else{
			logger.log(LogStatus.FAIL, actualString+" is NOT the proper Trip Status for the Selected Asset.");
		}
	}
	
	
	//Chiller Information -- Validate Chiller Point Names and Values
	@SuppressWarnings("static-access")
	public static void validateChillerInfoPointNamesAndVal() 
			throws SQLException {
		
		waitForSpinnerToDisappear();
		List<WebElement> chillerInfoPointsNames_elements = csdHomePageDB.get_hp_ChillerInfoPointsNameList();
		if (chillerInfoPointsNames_elements != null) {
			logger.log(LogStatus.INFO, "Asset Points are Reflecting under the Chiller Information Section.");
			for (int i = 0; i < chillerInfoPointsNames_elements.size(); i++) {
				WebElement ci_pointName = csdHomePageDB.get_hp_ChillerInfoPointsName(i + 1);
				String ci_pointName_text = ci_pointName.getText(); //System.out.println("ci_pointName_text "+ci_pointName_text);
				dbPageChillerPointsList.add(ci_pointName_text);
			}
			System.out.println("dbPageChillerPointsList " + dbPageChillerPointsList);
			List<WebElement> chillerInfoPointsValues_elements = csdHomePageDB.get_hp_ChillerInfoPointsValuesList();
			for (int i = 0; i < chillerInfoPointsValues_elements.size(); i++) {
				WebElement ci_pointVal = csdHomePageDB.get_hp_ChillerInfoPointsValue(i + 1);
				String ci_pointVal_text = ci_pointVal.getText(); //System.out.println("ci_pointName_text "+ci_pointName_text);
				dbPageChillerPointsValList.add(ci_pointVal_text);
			}
			System.out.println("dbPageChillerPointsValList " + dbPageChillerPointsValList);
			csdDataValMaster.validateAssetOverviewPointNames();
			if(csdDataValMaster.assetOverviewPointNames.size() == dbPageChillerPointsList.size()){
				logger.log(LogStatus.PASS, "Valid Number of Overview Points are reflected Under Chiller Information Section.");
				for(int i=0;i<dbPageChillerPointsList.size();i++){
					if(dbPageChillerPointsList.get(i).equalsIgnoreCase(csdDataValMaster.assetOverviewPointNames.get(i))){
						logger.log(LogStatus.INFO, dbPageChillerPointsList.get(i)+" Point is Reflectd under the Chiller Information Section.");
					}
				}
				logger.log(LogStatus.PASS, "All the Valid Chiller Overview Points are Reflected under the Chiller Information Section.");
			}
			
		}else { 
			logger.log(LogStatus.INFO, "Asset Points are NOT Reflecting under the Chiller Information Section.");
			logger.log(LogStatus.PASS, "There are no Asset Points under Chiller Information nfor validations.");
		}
	}
	
	
	
	
	

}
