package mars.JCI.Project.MEMSCloud_MappedPoints;

import java.util.List;
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

import commonFunctions.WebButton;
import commonFunctions.WebDropDown;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_MappedPoint_Action {
	public static WebDriver driver;
	public static ExtentTest logger;
	public String configFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	public static WebElement element;
	public static MEMSCloud_MappedPoints_Page_Factory mappedPoint_PageFact = null;
	
	/**
	 * Instantiates/Constructor a new MEMS Cloud login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEMSCloud_MappedPoint_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		mappedPoint_PageFact = new MEMSCloud_MappedPoints_Page_Factory(driver, logger);
	}

	//Wait for MAPPING POITNS Page Spinner
	public static void waitForSpinnerToDisappear_MappedPoints() throws InterruptedException {
		Thread.sleep(2000);
		By spiner = By.xpath("//div[@class='loadingimage meter-configration-lodar']/i[@id='loadingimage']");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(180, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	public static void waitForSpinnerToDisappear_Setup() throws InterruptedException {
		Thread.sleep(2000);
		By spiner = By.xpath("//div[@class='loadingimage meter-configration-lodar']/i[@class='fa fa-refresh fa-spin imageloader'][@id='loadingimage']");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(120, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
/*	//Click for Web Elements	
	public static void clickForWebElements(WebElement element, String passLog, String faildLog) throws InterruptedException{
		if(element != null && element.isDisplayed() && element.isEnabled()){
			WebButton.Button_Click(driver, element);
			Thread.sleep(300);
			logger.log(LogStatus.PASS, passLog);
		}else{
			logger.log(LogStatus.ERROR, faildLog);
		}		
	}*/
	
	/**
	 * 
	 * @param element
	 * @param passLog
	 * @param faildLog
	 * @throws InterruptedException
	 */
	//Click for Web Elements
	public static void clickForWebElements(WebElement element, String passLog, String faildLog) throws InterruptedException{
		if(element != null && element.isDisplayed() && element.isEnabled()){
			Thread.sleep(500);
			WebButton.Button_Click(driver, element);
			Thread.sleep(300);			
			logger.log(LogStatus.PASS, passLog);
		}else{
			logger.log(LogStatus.ERROR, faildLog);
		}		
	}
	
	/**
	 * Instantiates a new MEMS CLOUD Mapping point Action Page.
	 * @param WebElement
	 * @param InputText
	 */
	
	public void enterText_InputTextBox(WebElement element, String inputText){
		if(element != null && element.isDisplayed() && element.isEnabled()){
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, inputText);
			logger.log(LogStatus.PASS, inputText +" Text successfully entered in text textbox.");
		}else{
			logger.log(LogStatus.ERROR, inputText +" Textbox Webelement field failed.");
		}
	}
	
	public void selectDropDown(WebElement element){
		Select oSelect = new Select(element);		
		WebDropDown.SelectElementByVisibleText(element, "Year");	
		WebElement options= oSelect.getFirstSelectedOption();
		String selectedValueInDropDown = options.getText();		
		boolean found = false;
		List<WebElement> allOptions = oSelect.getOptions();
		for(int i=0; i<allOptions.size(); i++) {			
		    if(allOptions.get(i).equals(selectedValueInDropDown)) {
		        found=true;
		        break;
		        }
		}
		if(found) {
		    System.out.println("Value exists");
		}

	}
	
	// Upload Offline Data for the Period Year and Resolution Month
	public void uploadOfflineData_Period_Year_Reso_Month() {
		try {
			String Userslistdata_JSONPath = "$..MappedPoints_Credentials.*";
			List<String> MappedPoints_Credentials_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
			correctLogin(MappedPoints_Credentials_datalist.get(0).toString(), MappedPoints_Credentials_datalist.get(1).toString());
			waitForPortfoilioLandingPageSpinnerToDisappear();
			waitForLoginUser();
			navigateSetup();
			moveNextTabList();
			navigateMappedPointsTab();	
			clickOnOfflinePointsTab();
			String OfflinePoints_Year_Month_JSONPath = "$..OfflinePoints_Year_Month.*";
			List<String> OfflinePoints_Year_Month_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), OfflinePoints_Year_Month_JSONPath);
			select_Period_DropDown(OfflinePoints_Year_Month_datalist.get(0).toString());
			select_Resolution_DropDown(OfflinePoints_Year_Month_datalist.get(1).toString());
			select_From_TimeLine(OfflinePoints_Year_Month_datalist.get(2).toString());
			select_To_TimeLine(OfflinePoints_Year_Month_datalist.get(3).toString());	
			enter_PointName_InSearchTextBox(OfflinePoints_Year_Month_datalist.get(4).toString());
			clickOnSearchBtn();
			selectPointOnWebTable(OfflinePoints_Year_Month_datalist.get(4).toString());
			downloadTemplate();
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, new String("Error Message for is : " + e.getMessage()));
		}		
	}	


	public void downloadTemplate() throws InterruptedException {
		element = mappedPoint_PageFact.getdownloadxlsFile();
		clickForWebElements(element, "OfflinePoint.csv template file download link clicked successfully.", " OfflinePoint.csv template file download link WebElement field failed");
		Thread.sleep(500);
	}

	public void selectPointOnWebTable(String PointName) throws InterruptedException {
		element = mappedPoint_PageFact.getselectPointOnWebTable(PointName);
		clickForWebElements(element, PointName+" Point selected successfully.", PointName+" WebElement field failed");
		Thread.sleep(500);
	}

	public void clickOnSearchBtn() throws InterruptedException {
		element = mappedPoint_PageFact.getSearchBtn();
		clickForWebElements(element, "Search button clicked successfully.", "Search button WebElement field failed.");	
		Thread.sleep(1000);
		waitForSpinnerToDisappear_MappedPoints();
	}

	public void enter_PointName_InSearchTextBox(String pointName) throws InterruptedException {
		element = mappedPoint_PageFact.getSearchTextBox();
		enterText_InputTextBox(element, pointName);	
		
	}

	public void select_From_TimeLine(String FromYear) throws InterruptedException {
		element = mappedPoint_PageFact.getFrom_TimeLine();	
		element.click();		
		for (int i = 0; i < 30; i++) {
			String getYear = mappedPoint_PageFact.getYearRange_TimeLine().getText();	
			//System.out.println(getYear);
			String [] years = getYear.split("-");
			if (Integer.parseInt(years[0]) <= Integer.parseInt(FromYear)) {
				WebElement selectYr = mappedPoint_PageFact.getSelectYr(FromYear);
				if (selectYr != null && selectYr.isDisplayed() && selectYr.isEnabled()) {
					selectYr.click();
					Thread.sleep(300);
					//System.out.println("Year Selected Successfully.");
					logger.log(LogStatus.PASS, FromYear +" Year Selected successfully form From TimelIne");
					break;
				} else {
					logger.log(LogStatus.ERROR, FromYear +" Year Webelement field failed.");
				}
			} else {
				WebElement YrPrevious = mappedPoint_PageFact.getYearPrevious();
				if (YrPrevious != null && YrPrevious.isDisplayed() && YrPrevious.isEnabled())
					YrPrevious.click();
					Thread.sleep(300);
				//System.out.println("Click on Previous");
			}
		}
	}

	public void select_To_TimeLine(String ToYear) throws InterruptedException {
		element = mappedPoint_PageFact.getTo_TimeLine();	
		element.click();		
		for (int i = 0; i < 30; i++) {
			String getYear = mappedPoint_PageFact.getYearRange_TimeLine().getText();	
			//System.out.println(getYear);
			String [] years = getYear.split("-");
			if (Integer.parseInt(years[0]) <= Integer.parseInt(ToYear)) {
				WebElement selectYr = mappedPoint_PageFact.getSelectYr(ToYear);
				if (selectYr != null && selectYr.isDisplayed() && selectYr.isEnabled()) {
					selectYr.click();
					Thread.sleep(300);
					//System.out.println("Year Selected Successfully.");
					logger.log(LogStatus.PASS, ToYear +" Year Selected successfully form To TimelIne.");
					break;
				} else {
					logger.log(LogStatus.ERROR, ToYear +" Year Webelement field failed.");
				}
			} else {
				WebElement YrPrevious = mappedPoint_PageFact.getYearPrevious();
				if (YrPrevious != null && YrPrevious.isDisplayed() && YrPrevious.isEnabled())
					YrPrevious.click();
					Thread.sleep(300);
				//System.out.println("Click on Previous");
			}
		}
	}

	public void select_Resolution_DropDown(String Month) throws Exception {
		element = mappedPoint_PageFact.getResolution();		
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(element, "Year", "Year", logger);
	}

	public void select_Period_DropDown(String Year) throws Exception {
		element = mappedPoint_PageFact.getPeriod();
		// selectDropDown(element);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(element, "Year", "Year", logger);
	}

	public void clickOnOfflinePointsTab() throws InterruptedException {
		element = mappedPoint_PageFact.getOfflinePoints();
		clickForWebElements(element, "Clicked on Offline Points Tab successfully.", "Offline Points Tab Web Element field failed.");
		waitForSpinnerToDisappear_MappedPoints();
		Thread.sleep(2000);
	}

	public void moveNextTabList() throws InterruptedException {
		element = mappedPoint_PageFact.getNextTabList();		
		clickForWebElements(element, "Moved Next Tab List clicked successfully.", "Next Tab List Web Element field failed.");
	}

	public void navigateMappedPointsTab() throws InterruptedException {
		element = mappedPoint_PageFact.getMappedPoints();	
		clickForWebElements(element, "Mapped Points Tab clicked successfully.", "Mapped Points Web Element field failed.");	
		Thread.sleep(3000);
		waitForSpinnerToDisappear_MappedPoints();
		Thread.sleep(500);
	}

	public void waitForLoginUser() throws InterruptedException {				
		element = mappedPoint_PageFact.getUserImage();			
		if(element != null){
			logger.log(LogStatus.PASS, "User ImgeIcon is present on application.");	
		}else{
			logger.log(LogStatus.ERROR, "User ImgeIcon is not present on application.");
		}
	}


	public void navigateSetup() {
		try {
			String Userslistdata_JSONPath = "$..MappedPoints_Credentials.*";
			List<String> MappedPoints_Credentials_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
			driver.get(MappedPoints_Credentials_datalist.get(2).toString());
			Thread.sleep(1500);
			waitForSpinnerToDisappear_Setup();
			logger.log(LogStatus.PASS, "Setup page Navigated successfully.");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to navigate Setup Page.");
		}		
	}


	public static void correctLogin(String username, String password) throws Exception {
		MEMSCloud_Orgnization_Action MEMSCloud_Orgnization_Action = new MEMSCloud_Orgnization_Action(driver, logger);
		MEMSCloud_Orgnization_Action.enterUserID(username);
		MEMSCloud_Orgnization_Action.enterPassword(password);
		MEMSCloud_Orgnization_Action.clickSignIn_btn();				
		waitForPortfoilioLandingPageSpinnerToDisappear();
	}
	
	public static void waitForPortfoilioLandingPageSpinnerToDisappear() throws InterruptedException{        
        for (int i = 1; i < 3; i++) {
			Thread.sleep(5000);
			By spiner1 = By.xpath("(//widget-loader/div/i[@class='fa fa-refresh fa-spin imageloader'])[" + i + "]");
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver).withTimeout(180, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
			fluentWait1.until(ExpectedConditions.invisibilityOfElementLocated(spiner1));
		}
	}

}
