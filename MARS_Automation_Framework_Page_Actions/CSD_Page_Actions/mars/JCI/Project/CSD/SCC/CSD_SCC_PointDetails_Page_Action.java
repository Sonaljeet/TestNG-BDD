package mars.JCI.Project.CSD.SCC;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

import commonFunctions.WebElementCommon;
import jxl.Sheet;
import jxl.Workbook;
import mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails.CSD_PointDetailsTab_Page_Factory;

public class CSD_SCC_PointDetails_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_PointDetailsTab_Page_Factory scc_pointDetailsPF = null;
	private static CSD_SCC_DataValidation_Master csdSCCDataValMaster = null;
	
	public static String chiller_att_id = null;
	
	private static final By IMAGELOADER = By.cssSelector("div[test-id='loaderWidget']");
	
	public static List<String> ptDetailsNamesList = new ArrayList<String>();
	public static List<String> pointNamesList = new ArrayList<String>();
	
	@SuppressWarnings("static-access")
	public CSD_SCC_PointDetails_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		scc_pointDetailsPF = new CSD_PointDetailsTab_Page_Factory(driver, logger);
		csdSCCDataValMaster = new CSD_SCC_DataValidation_Master(driver, logger);
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	
	//Click on the Dashboard Tab
	public static void clickOnDashboardLink(){
		
		waitForSpinnerToDisappear();
		WebElement element=scc_pointDetailsPF.get_pointDetailsTab_DashboardLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null && element.isEnabled()) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Dashboard Link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Dashboard Link");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	// Click on the point Details Tab
	public static void clickPointDetailsTab() throws InterruptedException{
		waitForSpinnerToDisappear();
		WebElement element=scc_pointDetailsPF.get_pointDetailsTab_PointDetaialsTabLink();
		boolean elementStatus=false;
		waitForSpinnerToDisappear();
		//Thread.sleep(5000);
		if (element !=null) {
			waitForSpinnerToDisappear();
			element.click();
			logger.log(LogStatus.PASS, "Point Details Tab link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to click Point Details Tab link");
		}
		//return elementStatus;
	}
	
	
	//Get the Required Chiller Equipment Model Details for validation -- Method to perform that
	public static String getChillerModelDetails() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement element_img=scc_pointDetailsPF.get_pointDetailsTab_ChillerModelDetailsImgLink();
		String chiller_model_name = null;
		waitForSpinnerToDisappear();
		//Thread.sleep(2000);
		boolean elementStatus=false;
		if (element_img !=null) {
			waitForSpinnerToDisappear();
			element_img.click();
			waitForSpinnerToDisappear();
		    WebElement element_txt=scc_pointDetailsPF.get_pointDetailsTab_ChillerModelDetailsTxtLink();
			if (element_txt !=null) {
				chiller_model_name = element_txt.getText().substring(6);
				System.out.println("chiller model name "+chiller_model_name);
				logger.log(LogStatus.PASS, "Chiller Model Name Collected successfully");
				element_img.click();
				elementStatus=true;
			}else{
				elementStatus=false;
				logger.log(LogStatus.FAIL, "Failed to collect Chiller Model Details");
			}
			logger.log(LogStatus.PASS, "Chiller Model Details Image clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to click Chiller Model Details Image link");
		}
		//return elementStatus;
		return chiller_model_name;
	}
	
	//Get the Asset Attribute ID Details From UI 
	public static String getAssetAttributeID() {
		WebElement element = scc_pointDetailsPF.get_pointDetailsTab_ChillerModelDetailsImgLink();
		//String chiller_att_id=null;
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			WebElement assetID_element = driver.findElement(By.cssSelector("span[test-id='AssetDetailsId']"));
			String chiller_att =  (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML", assetID_element);//element.getText();
			chiller_att_id = chiller_att;
			System.out.println("Chiller asset ID : "+chiller_att_id);
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Selected Chiller's AssetDetailsID Selected successfully. Asset Detail ID is : "+chiller_att_id);
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Chiller's AssetDetailsID");
		}
		return chiller_att_id;
		
	}
	
	//Click on the Manage Active Points Tab
	public static void clickManageActivePointsButton() {
			
		waitForSpinnerToDisappear();
		WebElement element=scc_pointDetailsPF.get_pointDetailsTab_ManageActivePointsButton();
		if (element !=null) {
			waitForSpinnerToDisappear();
			element.click();
			logger.log(LogStatus.PASS, "Point Details Tab link clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click Point Details Tab link");
		}
	}
	
	
	//Get the Required Chiller Equipment Model ID Details for validation From DB -- Method to perform that
	 // ------ Implemented in the DataValidationMaster ------- 
	
	@SuppressWarnings("static-access")
	public static void performPointValidation() 
			throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		
		String chiller_model = getChillerModelDetails();
		String asset_det_id = getAssetAttributeID();
		int model_id = csdSCCDataValMaster.GetModelIdForChillerModel(chiller_model);
		csdSCCDataValMaster.GetChillerAttributeDetails(model_id);
		csdSCCDataValMaster.getAssetDetailsForSelectedChiller(asset_det_id);
		//clickManageActivePointsButton();
		//validatePointDetailsWithPointDetailsTab();
		
	}
	
	
	//Get the Point Details from the UI and validate it with the SCC Data Import Tab
	
	@SuppressWarnings("static-access")
	public static void validatePointDetailsWithPointDetailsTab() {
		
		if(ptDetailsNamesList.size() > 0) ptDetailsNamesList.clear();
		waitForSpinnerToDisappear();
		List<String> pointCategoryList  = csdSCCDataValMaster.dbNameList;
		for (int i = 0; i < pointCategoryList.size(); i++) {
			
			System.out.println("pointCategoryList : "+pointCategoryList.get(i));
			GetChillerPointsFromUIDynamic(pointCategoryList.get(i));
		}
	}
	
	public static void GetChillerPointsFromUIDynamic(String point_header) {
		
		if(pointNamesList.size() > 0) pointNamesList.clear();
		System.out.println("Inside GetChillerPointsFromUIDynamic Method !");
		waitForSpinnerToDisappear();
		String point_sub_category = null;
		if(driver.findElements(By.xpath("//span[@test-id='"+point_header+"']")).size() != 0){
						
			System.out.println("Getting "+point_header+" Point Details for the selected Chiller !");
			List<WebElement> point_details = driver.findElements(By
	                .xpath("//span[@test-id='"+point_header+"']/ancestor::ul/ul")); //ancestor //span[@test-id='lst-CPO 5']/parent::ul/ul /ul
	        System.out.println(point_header+" Points : "+point_details.size());
	        logger.log(LogStatus.PASS, point_header+" Points : "+point_details.size());
	        for (int i = 1; i < point_details.size()+1; i++) {
	            WebElement linkElement = driver.findElement(By.xpath("//span[@test-id='"+point_header+"']/ancestor::ul/ul["+i+"]/li"));
	            point_sub_category = linkElement.getText();
	            pointNamesList.add(point_sub_category);
	            logger.log(LogStatus.PASS, point_header.toUpperCase()+" category point is : "+point_sub_category);
	        }
		}
		else{
			System.err.println("Going to check the Next iteration !");
			logger.log(LogStatus.FAIL, "Failed to Retrieve Point Details!");
		}
	}
	
	public static void checkForValidPointsAfterSCCImport() {
		
		
	}
	

}
