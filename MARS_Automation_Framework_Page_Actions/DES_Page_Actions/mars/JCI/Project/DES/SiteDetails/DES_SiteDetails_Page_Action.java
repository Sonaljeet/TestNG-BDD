package mars.JCI.Project.DES.SiteDetails;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.jfxmedia.logging.Logger;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.SiteOverview.DES_SiteOverview_Page_Action;

public class DES_SiteDetails_Page_Action {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element = null;
	private static DES_SiteDetails_Page_Factory siteDetailsPF = null;
	private static DES_Home_Page_Action homePA = null;
	private static DES_Login_Page_Action loginPA = null;
	private static DES_SiteOverview_Page_Action  siteOPA=null;
	public static String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";
	public DES_SiteDetails_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPA = new DES_Login_Page_Action(driver, logger);
		siteDetailsPF = new DES_SiteDetails_Page_Factory(driver, logger);
		homePA = new DES_Home_Page_Action(driver, logger);
		siteOPA= new DES_SiteOverview_Page_Action(driver, logger);

	}

	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingHome");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	public static void waitForPointPopupToAppear() {
		// driver.findElement(By.id("loadingWidget"));
		By unitspopupbody = By.id("unitspopupbody");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(unitspopupbody));
	}

	public static void waitForMETER_MAINSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divLoading_METER_MAIN");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

	public static void waitForBANKCONTROLLERSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divLoading_BANKCONTROLLER");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

	public static void waitForSPSSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divLoading_SPS");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

	public static void waitForEnclosureSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divLoading_Enclosure");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

	public static void waitForBattery_InverterSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divLoading_Battery_Inverter");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

	public void clickOnDetailsTab(){
		try{
			element = siteDetailsPF.getDetailsTab();
			if (element != null) {
				waitForSpinnerToDisappear();
				element.click();
				Thread.sleep(10000);
				waitForSpinnerToDisappear();
			}
			
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}
	public void navigateToDetailsTab() {
		try {
			loginPA.DES_CorrectLogin();
			siteOPA.validateSiteOverviewWidgetsLoad();			
			clickOnDetailsTab();			
			logger.log(LogStatus.PASS, "Successfully Navigate to Details tab");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not Navigate to Details Tab");
		}
	}
	
	public void ValidateWidgetsPresent(){
		List<WebElement> Systems = null;
		try{
			loginPA.DES_CorrectLogin();
			siteOPA.validateSiteOverviewWidgetsLoad();			
			clickOnDetailsTab();
			if(siteDetailsPF.SystemHeaders.size()>0){
				for(WebElement header:siteDetailsPF.SystemHeaders){
					logger.log(LogStatus.PASS, header.getText()+" System  present for currunt site are ");
				}
			}
			
		}catch (Exception e) {
			
		}
	}
	
	public void verifyPointForBattrySystemMeter(){
		try{
			element=siteDetailsPF.getBatterySystemMeter();
			if(element!=null){
				waitForMETER_MAINSpinnerToDisappear();
				element.click();
				waitForMETER_MAINSpinnerToDisappear();
			}
			if(siteDetailsPF.MeterPointList.size()>0){
			for(WebElement point:siteDetailsPF.MeterPointList){
				waitForMETER_MAINSpinnerToDisappear();
				logger.log(LogStatus.PASS,point.getText());
				waitForMETER_MAINSpinnerToDisappear();
				}
			}else{
				logger.log(LogStatus.PASS, "Currently there are no points mapped for Battery System Meter");
			}
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	public void verifyPointForCustomerLoadMeter(){
		try{
			element=siteDetailsPF.getCustomerLoadMeter();
			if(element!=null){
				waitForMETER_MAINSpinnerToDisappear();
				element.click();
				waitForMETER_MAINSpinnerToDisappear();
			}
			if(siteDetailsPF.MeterPointList.size()>0){
			for(WebElement point:siteDetailsPF.MeterPointList){
				waitForMETER_MAINSpinnerToDisappear();
				logger.log(LogStatus.PASS,point.getText());
				waitForMETER_MAINSpinnerToDisappear();
				}
			}else{
				logger.log(LogStatus.PASS, "Currently there are no points mapped for Customer Load Meter");
			}
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	public void verifyPointBatteryStringOneBank(){
		try {
			element=siteDetailsPF.getBatteryStringOneBank();
			if(element!=null){
				waitForBANKCONTROLLERSpinnerToDisappear();
				element.click();
				waitForBANKCONTROLLERSpinnerToDisappear();
			}
			if(siteDetailsPF.BankControllerPointList.size()>0){
				for(WebElement point:siteDetailsPF.BankControllerPointList){
					waitForBANKCONTROLLERSpinnerToDisappear();
					logger.log(LogStatus.PASS,point.getText());
					waitForBANKCONTROLLERSpinnerToDisappear();
				}
			}else{
				logger.log(LogStatus.PASS, "Currently there are no points mapped for Battery String 1- Bank 1");
			}
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	public void verifyPointBattryStringTwoBank(){
		try {
			element=siteDetailsPF.getBatteryStringTwoBank();
			if(element!=null)
			{
				waitForBANKCONTROLLERSpinnerToDisappear();
				element.click();
				waitForBANKCONTROLLERSpinnerToDisappear();
			}
			if(siteDetailsPF.BankControllerPointList.size()>0){
				for(WebElement point:siteDetailsPF.BankControllerPointList){
					waitForBANKCONTROLLERSpinnerToDisappear();
					logger.log(LogStatus.PASS,point.getText());
					waitForBANKCONTROLLERSpinnerToDisappear();
				}
			}else{
				logger.log(LogStatus.PASS, "Currently there are no points mapped for Battery String 2- Bank 2");
			}
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
		}
	}
	
	public void ValidateWidgetsDataPresent(){
		String system = "";
		try{
			loginPA.DES_CorrectLogin();
			siteOPA.validateSiteOverviewWidgetsLoad();			
			clickOnDetailsTab();
			waitForMETER_MAINSpinnerToDisappear();
			if(siteDetailsPF.SystemHeaders.size()>0){
				waitForMETER_MAINSpinnerToDisappear();
				for(WebElement header:siteDetailsPF.SystemHeaders){
					waitForMETER_MAINSpinnerToDisappear();
					system=header.getText();
					logger.log(LogStatus.PASS, system+ " System  present for currunt site are ");				
				
				switch (system) {
				
				case "METERS":
					
					if(siteDetailsPF.MeterPointList.size()>0){
					for(WebElement point:siteDetailsPF.MeterPointList){
						waitForMETER_MAINSpinnerToDisappear();
						logger.log(LogStatus.PASS,point.getText());
						waitForMETER_MAINSpinnerToDisappear();
						}
					}else{
						logger.log(LogStatus.PASS, "There are no points mapped for Utility Main Meter");
					}
					verifyPointForBattrySystemMeter();
					verifyPointForCustomerLoadMeter();
					
					break;
					
				case "BATTERIES":
					if(siteDetailsPF.BankControllerPointList.size()>0){
						for(WebElement point:siteDetailsPF.BankControllerPointList){
							waitForBANKCONTROLLERSpinnerToDisappear();
							logger.log(LogStatus.PASS,point.getText());
							waitForMETER_MAINSpinnerToDisappear();
							}
						}else{
							logger.log(LogStatus.PASS, "There are no points mapped for Battery Bank");
						}
					
					verifyPointBatteryStringOneBank();
					verifyPointBattryStringTwoBank();
					
					break;
				
				case "APPLICATIONS":
					if(siteDetailsPF.SPSPointList.size()>0){
						for(WebElement point: siteDetailsPF.SPSPointList){
							waitForSPSSpinnerToDisappear();
							logger.log(LogStatus.PASS,point.getText());
							waitForSPSSpinnerToDisappear();
						}
					}else{
						logger.log(LogStatus.PASS, "There are no points mapped for Appliactions");
					}
					break;	
					
				case "ENCLOSURE":
					if(siteDetailsPF.EnclosurePointList.size()>0){
						for(WebElement point: siteDetailsPF.EnclosurePointList){
							waitForSPSSpinnerToDisappear();
							logger.log(LogStatus.PASS,point.getText());
							waitForSPSSpinnerToDisappear();
						}
					}else{
						logger.log(LogStatus.PASS, "There are no points mapped for Enclosure");
					}
					break;
					
				case "BATTERY INVERTER":
					if(siteDetailsPF.Battery_InverterPointList.size()>0){
						for(WebElement point: siteDetailsPF.Battery_InverterPointList){
							waitForSPSSpinnerToDisappear();
							logger.log(LogStatus.PASS,point.getText());
							waitForSPSSpinnerToDisappear();
						}
					}else{
						logger.log(LogStatus.PASS, "There are no points mapped for BATTERY INVERTER");
					}
					break;
				case "INVERTER":
					if(siteDetailsPF.INVERTERPointList.size()>0){
						for(WebElement point: siteDetailsPF.INVERTERPointList){
							waitForSPSSpinnerToDisappear();
							logger.log(LogStatus.PASS,point.getText());
							waitForSPSSpinnerToDisappear();
						}
					}else{
						logger.log(LogStatus.PASS, "There are no points mapped for INVERTER");
					}
					break;	
				case "PEAK SHAVING APPLICATION - STATIONARY ENERGY STORAGE":
					if(siteDetailsPF.Peak_Shaving_Application___Stationary_Energy_StoragePointList.size()>0){
						for(WebElement point: siteDetailsPF.Peak_Shaving_Application___Stationary_Energy_StoragePointList){
							waitForSPSSpinnerToDisappear();
							logger.log(LogStatus.PASS,point.getText());
							waitForSPSSpinnerToDisappear();
						}
					}else{
						logger.log(LogStatus.PASS, "There are no points mapped for PEAK SHAVING APPLICATION - STATIONARY ENERGY STORAGE");
					}
					break;	
					
				default:
					logger.log(LogStatus.PASS, "There is no System Created for Points mapped");
					break;
				}
			}
					/*if(siteDetailsPF.MeterPointList.size()>0){
					for(WebElement point:siteDetailsPF.MeterPointList){
						waitForMETER_MAINSpinnerToDisappear();
						System.out.println(point.getText());
						waitForMETER_MAINSpinnerToDisappear();
						}
					}*/
					
					
				
				/*if(siteDetailsPF.MeterPointList.size()>0){
					for(WebElement point:siteDetailsPF.MeterPointList){
						logger.log(LogStatus.PASS, point.getText());
					}
				}*/
				
			}
			
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	public void configureWidget(){
		try{
			waitForSpinnerToDisappear();
			element=siteDetailsPF.getConfigWidgetbtn();
			if(element!=null){
				element.click();
				waitForPointPopupToAppear();
				waitForMETER_MAINSpinnerToDisappear();
			}
			
			element=siteDetailsPF.getbtnApply();
			if(element!=null){
				waitForMETER_MAINSpinnerToDisappear();
				element.click();
				logger.log(LogStatus.PASS,"Clicked on Apply Button");
			}
			
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}

	public void verifyConfigureWidget() {
		try{
			loginPA.DES_CorrectLogin();
			siteOPA.validateSiteOverviewWidgetsLoad();			
			clickOnDetailsTab();
			configureWidget();
			logger.log(LogStatus.PASS, "Successfully Verified the Configuration Point Pop-up");
			
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
	}

	public void verifySeach() {
		try {
			loginPA.DES_CorrectLogin();
			siteOPA.validateSiteOverviewWidgetsLoad();			
			clickOnDetailsTab();
			enterSearchPointAndValidate();
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
		}
		
	}

	public void enterSearchPointAndValidate() {
		String pointSearchJsonPath="$..pointSearch";
		String pointName="";
		try{
		List<String> pointSearch = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), pointSearchJsonPath);
		waitForSpinnerToDisappear();
		element=siteDetailsPF.getsearchTextBox();
		if(element!=null){
			waitForSpinnerToDisappear();
			element.click();
			element.sendKeys(pointSearch.get(0).toString());
			waitForSpinnerToDisappear();
		}
		List<WebElement> searchresult= driver.findElements(By.xpath("//span[@class='ui-match']"));
		for(WebElement pointFound:searchresult){
			pointName=pointFound.getText();
			
		}
		if(pointName.contains(pointSearch.get(0).toString())){
			logger.log(LogStatus.PASS, "Found Similler results " +pointName);
		}
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to Search point" + e.getMessage());
		}
	}
	
	
}
