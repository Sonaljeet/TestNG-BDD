package mars.JCI.Project.MEMS_Cloud.MeterConfiguration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.Alert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.MeterConfiguration.MEMSCloud_MeterConfiguration_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_MeterConfiguration_Action {
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	public static MEMSCloud_Orgnization_Action orgnizaton_action_obj = null;
	private static MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = null;
	public static WebDriver driver;
	public String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	private WebElement element;

	/**
	 * Instantiates a new MEMS CLOUD Meter Configuration.
	 *
	 * @param driver
	 *            the driver
	 * @param logger
	 *            the logger
	 */
	public MEMSCloud_MeterConfiguration_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		orgnizaton_action_obj = new MEMSCloud_Orgnization_Action(driver, logger);
		MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		// PageFactory.initElements(driver, this);
	}

	public void waitForLoginUser() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory PortfolioPF = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = PortfolioPF.getUserImage();
		if (element != null) {
			logger.log(LogStatus.PASS, "User ImgeIcon is present on application");
		} else {
			logger.log(LogStatus.FAIL, "User ImgeIcon is not present on application");
		}
	}

	public static void waitForSpinnerToDisappear_MeterConfig() throws Exception {
		/*
		 * try { By spiner = By.id("loadingimage2"); WebElement ele =
		 * driver.findElement(By.id("loadingimage2")); System.out.println(
		 * "Spinner displayed is before " + ele.isDisplayed()); for (int i = 0;
		 * i < 10; i++) { if (ele.isDisplayed()) { Wait<WebDriver> fluentWait2 =
		 * new FluentWait<WebDriver>(driver).withTimeout(90,
		 * TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		 * fluentWait2.until(ExpectedConditions.invisibilityOfElementLocated(
		 * spiner)); break; } else { Thread.sleep(500); System.out.println(
		 * "Waiting for Spinner : " + 500*i + " ms"); } } } catch (Exception e)
		 * { System.out.println(e.getMessage());
		 * 
		 * }
		 */

		try {

			By spiner = By.xpath("//i[@class='fa fa-refresh fa-spin imageloader'][@id='loadingimage2']");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(180, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS);
			fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Spinner not found");
			throw new Exception("Element not found");
		}
	}

	// *************** SELECT DROP DOWN
	public static void selectByVisibleText(WebElement element, String text) throws Exception {
		try {
			System.out.println("element " + element + "text " + text);
			new Select(element).selectByVisibleText(text);
			System.out.println(text.toUpperCase() + " Drop down list is Selected.");
			logger.log(LogStatus.INFO, text.toUpperCase() + " Drop down list is Selected.");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option.");
			throw new Exception("Element not found");
		}
	}

	// *************** SELECT DROP DOWN LIST
	public void selectDropDown(WebElement element, String dpListName) throws Exception {
		for (int i = 0; i <= 20; i++) {
			if (element != null && element.isEnabled()) {
				element.click();
				selectByVisibleText(element, dpListName);
				Thread.sleep(300);
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		if (element != null && element.isEnabled()) {
			logger.log(LogStatus.PASS, dpListName + " drop down selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + dpListName + " Field Failed.");
		}
	}

	// *************** WAIT FOR PORTFOLIO LANDING PAGE SPINNER TO DISAPPEAR
	public static void waitForPortfoilioLandingPageSpinnerToDisappear() throws Exception {
		try {
			for (int i = 1; i < 3; i++) {
				Thread.sleep(5000);
				By spiner = By.xpath("(//widget-loader/div/i[@class='fa fa-refresh fa-spin imageloader'])[" + i + "]");
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(180, TimeUnit.SECONDS)
						.pollingEvery(2, TimeUnit.SECONDS);
				fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
			}
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Spinner not found");
			throw new Exception("Element not found");
		}
	}

	public static void waitForSpinnerToDisappear_Setup() throws Exception {
		try {
			Thread.sleep(3000);
			By spiner = By.id("loadingimage");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(120, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS);
			fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Spinner not found");
			throw new Exception("Element not found");
		}
	}

	public static void waitForSpinnerToDisappearSetup_New() throws Exception {
		for (int i = 0; i < 10; i++) {
			List<WebElement> element2 = driver.findElements(
					By.xpath("//div[@class='loadingimage meter-configration-lodar']/i[@id='loadingimage']"));
			By ele = By.xpath("//div[@class='loadingimage meter-configration-lodar']/i[@id='loadingimage']");
			System.out.println("size is " + element2.size());
			if (element2.size() > 0) {
				System.out.println("Spinner Attribute Value : " + element2.get(0).getAttribute("style"));

				if (element2 != null && !element2.get(0).getAttribute("style").contains("null")
						&& !element2.get(0).getAttribute("style").equals(" ")
						&& !element2.get(0).getAttribute("style").equalsIgnoreCase("none")) {

					@SuppressWarnings("unchecked")
					Wait<WebDriver> wait1 = new FluentWait(driver).withTimeout(5, TimeUnit.SECONDS).pollingEvery(100,
							TimeUnit.MICROSECONDS);
					wait1.until(ExpectedConditions.invisibilityOfElementLocated(ele));
					System.out.println("Page Load successfully...");
					break;
				}
			} else {
				Thread.sleep(1000);
				System.out.println("in delay");
			}
		}

	}

	public void selectDropDown_UsingJS(WebElement dropDownListBox, String dropDownText) throws InterruptedException{
		boolean flag = false;		
		for (int i = 0; i <= 20; i++) {	
			Select oSelct = new Select(dropDownListBox);
			if(dropDownListBox != null && dropDownListBox.isEnabled() && dropDownListBox.isDisplayed()){
				Thread.sleep(500);				
				//((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", dropDownListBox, dropDownText);
				((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", dropDownListBox, dropDownText);
				Thread.sleep(300);
				oSelct.selectByIndex(0);
				Thread.sleep(500);
				oSelct.selectByVisibleText(dropDownText);
				Thread.sleep(500);
				flag = true;
				break;
			}else{
				Thread.sleep(1000);
			}
		}
		if(flag){
			logger.log(LogStatus.PASS, "Select "+  dropDownText.toUpperCase() + " from drop down list Successfully.");
		}else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + dropDownText.toUpperCase() + " Field Failed.");
		}
	}
	
	// *************** SEND INPUT TEXT BOX
	public static void sendInputTextBoxWithLogger(WebElement element, String Message, String text) throws Exception {
		if (element != null) {
			if (element.isDisplayed()) {
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, text);
				logger.log(LogStatus.PASS, text + " Entered succesfully to " + Message + " WebElement");
			}
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for " + Message + " Field Failed");
			throw new Exception("Element not found");
		}
	}

	// *************** CREATE ONLINE METER
	public void createOnlineMeter() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..OnlineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		selectBuildind(MeterConfiguration_datalist.get(4).toString());
		clickOnCreateMeteriCon();
		selectDropDown(MeterConfig.getSystem(), MeterConfiguration_datalist.get(5).toString());
		selectDropDown(MeterConfig.getmeterNature(), MeterConfiguration_datalist.get(6).toString());
		selectDropDown(MeterConfig.getmeterType(), MeterConfiguration_datalist.get(7).toString());
		selectDropDown(MeterConfig.getmeterLoadType(), MeterConfiguration_datalist.get(8).toString());
		String Online_MeterName = MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"Online_MeterName", Online_MeterName);
		System.out.println("MeterName : " + Online_MeterName);
		sendInputTextBoxWithLogger(MeterConfig.getmeterName(), "Meter Name", Online_MeterName);
		select_MeterRollUp(MeterConfiguration_datalist.get(9).toString());
		System.out.println("Meter Roll Up : " + MeterConfiguration_datalist.get(9).toString());
		selectDropDown(MeterConfig.getequipmentCategory(), MeterConfiguration_datalist.get(10).toString());
		SaveOnlineMeter();
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		checkCreatedOnlineMeterIsPresent(Online_MeterName);

	}

	public void checkCreatedOnlineMeterIsPresent(String meterName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getOnlineMeter(meterName);
		if (elements != null) {
			elements.get(0).click();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, meterName + " Online meter is created sucessfully .");
		} else {
			logger.log(LogStatus.ERROR, meterName + " Online meter is not created sucessfully ..");
		}

	}

	// *************** EXPAND COMMODITY TREE
	public void expandCommodityTree(String buildingName, String commodityName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getCommodityTree(buildingName, commodityName);
		List<WebElement> elements1 = MeterConfig.getexpandCommodityTree_Minus(buildingName, commodityName);
		int flag = 0;
		for (int i = 0; i <= 20; i++) {
			if (elements.size() > 0) {
				elements.get(0).click();
				Thread.sleep(700);
				flag = 1;
				break;
			} else if (elements1.size() > 0) {
				Thread.sleep(500);
				flag = 1;
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		if (flag == 1) {
			logger.log(LogStatus.PASS, commodityName + " Commodity Tree Expanded Successfully.");
		} else {
			logger.log(LogStatus.PASS, commodityName + " Commodity Tree WebElement field faild.");
		}

		/*
		 * for (int i = 0; i <= 20; i++) { if(elements != null &&
		 * elements.get(0).isEnabled()){ Thread.sleep(1000);
		 * elements.get(0).click(); Thread.sleep(1000); break; }else{
		 * Thread.sleep(1000); }
		 * 
		 * if(elements != null && elements.get(0).isEnabled()){
		 * logger.log(LogStatus.PASS, commodityName +
		 * " Commodity Tree Expanded Successfully."); }else{
		 * logger.log(LogStatus.PASS, commodityName +
		 * " Commodity Tree WebElement field faild."); } }
		 */

		/*
		 * if (elements != null) { waitForSpinnerToDisappear_MeterConfig();
		 * elements.get(0).click(); waitForSpinnerToDisappear_MeterConfig();
		 * Thread.sleep(1000); logger.log(LogStatus.PASS, commodityName +
		 * " Commodity Tree Expanded Successfully."); } else {
		 * logger.log(LogStatus.ERROR, "Identifying WebElement for " +
		 * commodityName + " Commodity Tree  Field Failed."); }
		 */
	}

	// *************** EXPAND BUILDING TREE
	public void expandBuildingTree(String BuildingName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getExpandBuildingTree(BuildingName);
		if (elements != null) {
			elements.get(0).click();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, BuildingName + " Building Tree Expanded Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + BuildingName + " Building Tree  Field Failed.");
		}

	}

	// *************** SELECT METER ROLL UP
	public void SaveOnlineMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getSave();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(2000);
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, "Clicked on Save button Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Save button Field Failed.");
		}

	}

	public void select_MeterRollUp(String meterRollUp) throws Exception {
		if (meterRollUp.equalsIgnoreCase("Yes")) {
			select_MeterRollUp_Yes();

		} else if (meterRollUp.equalsIgnoreCase("No")) {
			select_MeterRollUp_No();

		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for  Meter Roll Up Radio button Field Failed.");
		}
	}

	// *************** SELECT METER ROLL UP
	public void select_MeterRollUp_Yes() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getMeterRollUp_Yes();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Roll Up YES Radio button selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for  Meter Roll Up Radio button Field Failed.");
		}

	}

	// *************** SELECT METER ROLL UP No
	public void select_MeterRollUp_No() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getMeterRollUp_No();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Roll Up NO Radio button selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for  Meter Roll Up Radio button Field Failed.");
		}

	}

	// *************** CLICK ON CREATE METER ICON
	public void clickOnCreateMeteriCon() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getCreateMeter();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Create Meter icon clicked Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Create Meter icon Field Failed.");
		}
	}

	// *************** SELECT BUILDING
	public void selectBuildind(String buildingName) throws Exception {
		List<WebElement> elements = MeterConfig.getSelectBuilding(buildingName);
		if (element != null) {
			elements.get(0).click();
			logger.log(LogStatus.PASS, buildingName + " Building is Selected successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + buildingName + " Field Failed.");
		}
	}

	// *************** EXPAND METER CONFIGURATION TREEE
	public void expandMeterDistributionTree(String locationName) throws Exception {
		List<WebElement> elements = MeterConfig.getExpandNavigationTree(locationName);
		if (element != null) {
			elements.get(0).click();
			logger.log(LogStatus.PASS, locationName + " Facility Tree expand Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + locationName + "tree Field Failed.");
		}

	}

	// *************** NAVIGATE METER CONFIGURATION TAB
	public void navigateMeterConfigurationTab() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getMeterConfiguration();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(3000);
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, "Navigate Meter Configuration Tab Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Meter Configuration Field Failed.");
		}
	}

	// *************** CORRECT LOGIN
	public void correctLogin(String username, String password) throws Exception {
		MEMSCloud_Orgnization_Action MEMSCloud_Orgnization_Action = new MEMSCloud_Orgnization_Action(driver, logger);
		MEMSCloud_Orgnization_Action.enterUserID(username);
		MEMSCloud_Orgnization_Action.enterPassword(password);
		MEMSCloud_Orgnization_Action.clickSignIn_btn();
		Thread.sleep(2000);
		waitForPortfoilioLandingPageSpinnerToDisappear();
	}

	// *************** DELETE ONLINE METER
	public void deleteOnlineMeter() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..OnlineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		String MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		checkCreatedOnlineMeterIsPresent(MeterName);
		deleteSelectedMeter();
		accept_DeleteConformation();
		isMeterDelete(MeterName);

	}

	// *************** IS METER DELETE
	public void isMeterDelete(String meterName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getOnlineMeter(meterName);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.ERROR, meterName + " Online meter not deleted.");
		} else {
			logger.log(LogStatus.PASS, meterName + " Online meter is deleted successfully.");
		}
	}

	// *************** DELETE SELECTED METER
	public void deleteSelectedMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getdelete();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked on deleter meter icon Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for deleter meter icon Field Failed.");
		}
	}

	// *************** CREATE VIRTUAL METER
	public void createVirtualMeter() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..VirtualMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		selectBuildind(MeterConfiguration_datalist.get(4).toString());
		clickOnCreateMeteriCon();
		selectDropDown(MeterConfig.getSystem(), MeterConfiguration_datalist.get(5).toString());
		String Virtual_MeterNature = MeterConfiguration_datalist.get(6).toString();
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"Virtual_MeterNature", Virtual_MeterNature);
		selectDropDown(MeterConfig.getmeterNature(), Virtual_MeterNature);
		selectDropDown(MeterConfig.getmeterType(), MeterConfiguration_datalist.get(7).toString());
		selectDropDown(MeterConfig.getmeterLoadType(), MeterConfiguration_datalist.get(8).toString());
		String Virtual_MeterName = MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"Virtual_MeterName", Virtual_MeterName);
		System.out.println("MeterName : " + Virtual_MeterName);
		sendInputTextBoxWithLogger(MeterConfig.getmeterName(), "Meter Name", Virtual_MeterName);
		select_MeterRollUp(MeterConfiguration_datalist.get(9).toString());
		selectDropDown(MeterConfig.getequipmentCategory(), MeterConfiguration_datalist.get(10).toString());
		String Virtual_MeterPointName = MEMSCloud_Orgnization_Action.generateRandomalphabets(10);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"Virtual_MeterPointName", Virtual_MeterPointName);
		sendInputTextBoxWithLogger(MeterConfig.getPointName(), "Virtual_PointName", Virtual_MeterPointName);
		String Virtual_PointDescription = MEMSCloud_Orgnization_Action.generateRandomalphabets(10);
		sendInputTextBoxWithLogger(MeterConfig.getEnterDescription(), "Meter Name",
				Virtual_PointDescription + " Test Description");
		selectDropDown(MeterConfig.getUnitType(), MeterConfiguration_datalist.get(11).toString());
		selectUnitDropDown(MeterConfig.getUnit(), MeterConfiguration_datalist.get(12).toString());
		selectDropDown(MeterConfig.getPointRole(), MeterConfiguration_datalist.get(13).toString());
		selectDropDown(MeterConfig.getSeriesType(), MeterConfiguration_datalist.get(14).toString());
		clickOnVirtualPointDefination();
		String OnlineMeter_JSONPath = "$..OnlineMeter.*";
		List<String> OnlineMeter_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), OnlineMeter_JSONPath);
		expandBuildingTree_virPopUp(OnlineMeter_datalist.get(4).toString());
		expandCommodityTree_VirPopUp(OnlineMeter_datalist.get(4).toString(), OnlineMeter_datalist.get(6).toString());
		String pointName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		expandMeterTree(pointName);
		String ConfigureMeterPoint_JSONPath = "$..ConfigureMeterPoint.*";
		List<String> ConfigureMeterPoint_JSONPath_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				ConfigureMeterPoint_JSONPath);
		dragDropPoint(ConfigureMeterPoint_JSONPath_datalist.get(8).toString());
		clickOnDivideButton();
		enterNumericValue();
		clickOnEnterButton();
		validateSyntax();
		String virtualPointdefination = getVirtualPointDefination();
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"virtual_Point_Defination", virtualPointdefination);
		clickOnSaveRuleBtn();
		saveVirtualMeterpoint();
		// expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),MeterConfiguration_datalist.get(6).toString());
		String virtualMeterpoint = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"$..Virtual_MeterPointName");
		isVirtualMeterPointPresent(virtualMeterpoint);
		String virtual_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Virtual_MeterName");
		isVirtualMeterPresent(virtual_MeterName);

	}

	public void selectDp(WebElement element, String dpListName) throws Exception {
		if (element != null && element.isEnabled()) {
			element.click();
			selectByVisibleText(element, dpListName);
		}
	}

	@SuppressWarnings("unchecked")
	public void selectUnitDropDown(WebElement element, String dpText) throws Exception {
		Boolean found = false;
		for (int i = 0; i <= 20; i++) {
			selectDp(element, dpText);
			Select select = new Select(element);
			List<WebElement> allOptions = select.getOptions();
			for (int j = 0; j < allOptions.size(); j++) {
				System.out.println(allOptions.get(j).toString());
				System.out.println(dpText);
				String dpList = allOptions.get(j).getText();
				if (dpList.equalsIgnoreCase(dpText)) {
					found = true;
				}
			}
			break;
		}
		if (found) {
			System.out.println(dpText + " Drop down list exists");
		} else {
			Thread.sleep(1000);
			selectDp(element, dpText);
			System.out.println("Drop down not exists");
		}

		if (found) {
			logger.log(LogStatus.PASS, dpText + " drop down selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + dpText + " Field Failed.");

		}
	}

	public void waitTillMeterDistributionTreeAppear(String facilityName) throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> waitForFacility = MeterConfig.getFacility(facilityName);
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.visibilityOfAllElements(waitForFacility));
		logger.log(LogStatus.PASS, facilityName + " Facility is Present.");

	}

	// *************** VIRTUAL METER IS PRESENT
	public void isVirtualMeterPresent(String virtual_MeterName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getVirtualMeterPoint(virtual_MeterName);
		if (elements.size() > 0) {
			Thread.sleep(700);
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(700);
			logger.log(LogStatus.PASS, virtual_MeterName + " Virtual Meter is created sucessfully.");
		} else {
			logger.log(LogStatus.ERROR, virtual_MeterName + " Virtual Meter is not created sucessfully.");
		}

	}

	// *************** VIRTUAL METER POINT IS PRESENT
	public void isVirtualMeterPointPresent(String virtualMeterpoint) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getVirtualMeterPoint(virtualMeterpoint);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, virtualMeterpoint + " Virtual Meter Point is Present.");
		} else {
			logger.log(LogStatus.ERROR, virtualMeterpoint + " Virtual Meter Point is not Present.");
		}

	}

	// *************** VIRTUAL POINT DEFINATION
	public String getVirtualPointDefination() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		WebElement dropableArea = MeterConfig.getdroppableTextArea();
		if (dropableArea != null) {
			String virtualPoitDef = dropableArea.getAttribute("value");
			logger.log(LogStatus.PASS, "Virtual point defination write in runtime Testdata successfully.");
			return virtualPoitDef;
		} else {
			logger.log(LogStatus.ERROR, "Virtual point defination does not write in runtime Testdata.");
			return null;
		}
	}

	// *************** CLICK ON SAVE VIRTUAL METER POINT BUTTON
	public void saveVirtualMeterpoint() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getSaveVirtualMeterpoint();
		if (element != null) {
			Thread.sleep(500);
			WebButton.Button_Click(driver, element);
			Thread.sleep(500);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Clicked on Save Rule button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Save Rule Field Failed.");
		}
	}

	// *************** CLICK ON SAVE RULE BUTTON
	public void clickOnSaveRuleBtn() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getSaveRule();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked on Save Rule button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Save Rule Field Failed.");
		}

	}

	// *************** CLICK ON VALIDATE SYNTAX BUTTON
	public void validateSyntax() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getValidateSyntax();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Clicked on Validate Syntax button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Validate Syntax Field Failed.");
		}
	}

	// *************** CLICK ON ENTER BUTTON
	public void clickOnEnterButton() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getenterExp();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			// waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Clicked on Enter button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Enter Field Failed.");
		}

	}

	// *************** DRAG DROP METER POINT
	public void enterNumericValue() throws Exception {
		sendInputTextBoxWithLogger(MeterConfig.getNumericValue(), "Numeric Value", "2");
		Thread.sleep(500);
	}

	// *************** DRAG DROP METER POINT
	public void clickOnDivideButton() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getDivideBtn();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Clicked on expression button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for expression button Field Failed.");
		}
	}

	// *************** DRAG DROP METER POINT
	public void dragDropPoint(String meterPoint) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> draggableElements = MeterConfig.getSelectMeterPoint(meterPoint);
		WebElement dropableArea = MeterConfig.getdroppableTextArea();
		if (draggableElements.size() > 0 && dropableArea != null) {
			(new Actions(driver)).dragAndDrop(draggableElements.get(0), dropableArea).perform();
			// waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Meter point Drag Dropped successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Meter point Drag Dropped Field Failed.");
		}

	}

	// *************** EXPAND METER TREE
	public void expandMeterTree(String pointName) throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getexpandMeterTree(pointName);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, pointName + " Meter Tree expand successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + pointName + " Meter Tree Field Failed.");
		}

	}

	// *************** EXPAND COMMODITY TREE
	public void expandCommodityTree_VirPopUp(String buildingName, String commodityName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getexpandCommodityTree_VirPopUp(buildingName, commodityName);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Commodity Tree expand successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Commodity Tree Field Failed.");
		}
	}

	// *************** EXPAND VIRTUAL POINT BUILDING TREE
	public void expandBuildingTree_virPopUp(String locationName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getexpandBuildingTree_VirPopUp(locationName);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Building Tree expand successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Building Tree Field Failed.");
		}

	}

	// *************** CLICK ON VIRTUAL POINT DEFINATION BUTTON
	public void clickOnVirtualPointDefination() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getVirtualPointDef();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked on Virtual point definition button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Virtual point definition button Field Failed.");
		}

	}

	// *************** CONFIGURE METER POINT

	public void ConfigureMeterPoint() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..ConfigureMeterPoint.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		// waitForSpinnerToDisappearSetup_New();
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		selectDataCollector(MeterConfiguration_datalist.get(5).toString());
		selectDataSource(MeterConfiguration_datalist.get(6).toString());
		selectDataSourceDevice(MeterConfiguration_datalist.get(7).toString());
		clickOnAllPointsButton();
		doubleClickOnPoint(MeterConfiguration_datalist.get(8).toString());
		selectReadFrequency(MeterConfiguration_datalist.get(9).toString());
		selectUnitType(MeterConfiguration_datalist.get(10).toString());
		selectUnit(MeterConfiguration_datalist.get(11).toString());
		selectPointRole(MeterConfiguration_datalist.get(12).toString());
		selectMeterSeriesType(MeterConfiguration_datalist.get(13).toString());
		enterMinValue(MeterConfiguration_datalist.get(14).toString());
		enterMaxValue(MeterConfiguration_datalist.get(15).toString());
		clickOnUpdateButton(MeterConfiguration_datalist.get(8).toString());

	}

	// *************** MAP METER POINT
	public void mapMeterPoint() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..ConfigureMeterPoint.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		selectDataCollector(MeterConfiguration_datalist.get(5).toString());
		selectDataSource(MeterConfiguration_datalist.get(6).toString());
		selectDataSourceDevice(MeterConfiguration_datalist.get(7).toString());
		clickOnAllPointsButton();
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(16).toString());
		String Online_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		checkCreatedOnlineMeterIsPresent(Online_MeterName);
		clickOnCreateMeteriCon();
		selectPoint();
		selectMeterPoint(MeterConfiguration_datalist.get(8).toString());
		saveMeterPoint();
		expandMeterPoint(Online_MeterName);
		isPointAdd(MeterConfiguration_datalist.get(8).toString());

	}

	// *************** EXPAND METER POINT
	public void deleteMappedMeterPoint() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..ConfigureMeterPoint.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		selectDataCollector(MeterConfiguration_datalist.get(5).toString());
		selectDataSource(MeterConfiguration_datalist.get(6).toString());
		selectDataSourceDevice(MeterConfiguration_datalist.get(7).toString());
		clickOnAllPointsButton();
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(16).toString());
		String Online_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		expandMeterPoint(Online_MeterName);
		isPointAdd(MeterConfiguration_datalist.get(8).toString());
		clickOnDeleteiCon();
		accept_DeleteConformation();
		isPointDeleted(MeterConfiguration_datalist.get(8).toString());

	}

	// *************** Set Historical Request

	public void setHistoricalRequest() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..HistoricalRequest.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		selectDataCollector(MeterConfiguration_datalist.get(3).toString());
		selectDataSource(MeterConfiguration_datalist.get(4).toString());
		selectDataSourceDevice(MeterConfiguration_datalist.get(5).toString());
		clickOnAllPointsButton();
		clickOnHistoricalRequestBtn();
		enterStartDate(MeterConfiguration_datalist.get(6).toString());
		enterEndDate(MeterConfiguration_datalist.get(7).toString());
		clickOnMeterPoint(MeterConfiguration_datalist.get(8).toString());
		clickOnSubmitButton();

	}

	// *************** CLICK ON SUBMIT BUTTON
	public void clickOnSubmitButton() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getsubmitHistoricalReq();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Historical request submitted successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Historical request failed.");
		}
	}

	// *************** ENTER START DATE
	public void clickOnMeterPoint(String pointName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getclickMeterPoint(pointName);
		if (elements.size() > 0) {
			elements.get(0).click();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, pointName + " Point selected successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + pointName + " Point Field Failed.");
		}

	}

	// *************** ENTER START DATE
	public void enterEndDate(String endDate) throws Exception {
		sendInputTextBoxWithLogger(MeterConfig.getendDate(), "End Date", endDate);
	}

	// *************** ENTER START DATE
	public void enterStartDate(String startDate) throws Exception {
		sendInputTextBoxWithLogger(MeterConfig.getstartDate(), "Start Date", startDate);
	}

	// *************** CLICK ON HISTORICAL REQUEST BUTTON
	public void clickOnHistoricalRequestBtn() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getHistoricalReq();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Clicked on Historical Request button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Historical Request button Field Failed.");
		}
	}

	// *************** IS METER POINT DELETED
	public void acceptDeleteConformation() throws Exception {
		Alert alert = driver.switchTo().alert();
		waitForSpinnerToDisappear_MeterConfig();
		alert.accept();
		Thread.sleep(1200);
		waitForSpinnerToDisappear_MeterConfig();
		logger.log(LogStatus.PASS, "Accept delete conformation successfully.");
	}

	// *************** IS METER POINT DELETED
	public void isPointDeleted(String pointName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		waitForSpinnerToDisappear_MeterConfig();
		Thread.sleep(3000);
		List<WebElement> elements = MeterConfig.selectedAddedPoint(pointName);
		waitForSpinnerToDisappear_MeterConfig();
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			logger.log(LogStatus.ERROR, pointName + " Meter Point not deleted.");
		} else {
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, pointName + " Meter Point deleted successfully.");
		}
	}

	// *************** DELETE METER POINT
	public void clickOnDeleteiCon() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getdelete();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked on delete button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for delete button Field Failed.");
		}
	}

	// *************** EXPAND METER POINT
	public void isPointAdd(String pointName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.selectedAddedPoint(pointName);
		if (elements.size() > 0) {
			elements.get(0).click();
			Thread.sleep(300);
			logger.log(LogStatus.PASS, pointName + " Point selected successfully.");
		} else {
			logger.log(LogStatus.ERROR, pointName + " Point is not selected successfully.");
		}
	}

	// *************** EXPAND METER POINT
	public void expandMeterPoint(String meterPointName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getexpandMeterPoint(meterPointName);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(2000);
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, meterPointName + " Meter Point Tree expand successfully.");
		} else {
			logger.log(LogStatus.ERROR,
					"Identifying WebElement for " + meterPointName + " Meter Point expand icon Field Failed.");
		}

	}

	// *************** SELECT METER POINT CHECK BOX
	public void saveMeterPoint() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getSaveMeterPoint();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(500);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Clicked on save button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Save button Field Failed.");
		}

	}

	// *************** SELECT METER POINT CHECK BOX
	public void selectMeterPoint(String meterPoint) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getselectMeterPoint(meterPoint);
		if (elements.size() > 0) {
			elements.get(0).click();
			Thread.sleep(300);
			logger.log(LogStatus.PASS, meterPoint + " is selected successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + meterPoint + " Field Failed.");
		}
	}

	// *************** SELECT ADD POINT RADIO BUTTON
	public void selectPoint() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getAddPoint();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(300);
			logger.log(LogStatus.PASS, "Add Point Radio button selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Add Point Field Failed.");
		}

	}

	// *************** CLICK ON UPDATE BUTTON
	public void clickOnUpdateButton(String MeterPointname) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getUpdate();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, MeterPointname + " MeterPoint is configured Successfully.");
		} else {
			logger.log(LogStatus.ERROR, MeterPointname + " MeterPoint is not configured Successfully.");
		}

	}

	// *************** CLICK ON ALLPOINT BUTTON
	public void clickOnAllPointsButton() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getAllPoints();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(1500);
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, "AllPoints button clicked Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for AllPoints Field Failed.");
		}

	}

	// *************** ENTER MAX VALUE
	public void enterMaxValue(String maxValue) throws Exception {
		sendInputTextBoxWithLogger(MeterConfig.getMaxValue(), "Max Value", maxValue);
		// waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** ENTER MIN VALUE
	public void enterMinValue(String minValue) throws Exception {
		sendInputTextBoxWithLogger(MeterConfig.getMinValue(), "Min Value", minValue);
		// waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** SELECT METER SERIES TYPE
	public void selectMeterSeriesType(String meterSeriesType) throws Exception {
		selectDropDown(MeterConfig.getMeterSeriesType(), meterSeriesType);
		Thread.sleep(1000);
		// waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** SELECT POINT ROLE
	public void selectPointRole(String pointRole) throws Exception {
		selectDropDown(MeterConfig.getMeterPointRole(), pointRole);
		Thread.sleep(1000);
		// waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** SELECT READ FRQUENCY
	public void selectUnit(String meterUnit) throws Exception {
		selectDropDown(MeterConfig.getMeterUnit(), meterUnit);
		Thread.sleep(1000);
		// waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** SELECT READ FRQUENCY
	public void selectUnitType(String unitType) throws Exception {
		selectDropDown(MeterConfig.getMeterUnitType(), unitType);
		Thread.sleep(1000);
		// waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** SELECT READ FRQUENCY
	public void selectReadFrequency(String readFrq) throws Exception {
		selectDropDown(MeterConfig.getReadFrequency(), readFrq);
		// waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** DOUBLE CLICK ON POINT
	public void doubleClickOnPoint(String pointName) throws Exception {
		Actions action = new Actions(driver);
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getMeterPoint(pointName);
		if (elements != null) {
			action.doubleClick(elements.get(0)).perform();
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, "Double Clicked on point Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for point Field Failed.");
		}
	}

	// *************** SELECT DATA SOURCE DEVICE
	public void selectDataSourceDevice(String dataSourceDevice) throws Exception {
		WebElement dpValue = MeterConfig.getDataSource_Device();
		Select se = new Select(dpValue);
		String dpList = se.getFirstSelectedOption().getText();
		if (dpList.equalsIgnoreCase(dataSourceDevice)) {
			Thread.sleep(500);
		} else {
			selectDropDown(MeterConfig.getDataSource_Device(), dataSourceDevice);
		}
	}

	// *************** SELECT DATA SOURCE
	public void selectDataSource(String dataSource) throws Exception {
		selectDropDown(MeterConfig.getData_Source(), dataSource);
		waitForSpinnerToDisappear_MeterConfig();
	}

	// *************** SELECT DATA COLLECTOR
	public void selectDataCollector(String dataCollector) throws Exception {
		selectDropDown(MeterConfig.getDatacollector(), dataCollector);
	}

	public void deleteVirtualMeterPoint() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..VirtualMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		// waitForSpinnerToDisappear_MeterConfig();
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		String virtualMeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Virtual_MeterName");
		expandMeterPoint(virtualMeterName);
		String virtualMeterpoint = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"$..Virtual_MeterPointName");
		isVirtualMeterPointPresent(virtualMeterpoint);
		clickOnDeleteiCon();
		// acceptDeleteConformation();
		accept_DeleteConformation();
		isVirtualMeterPointDelete(virtualMeterpoint);

	}

	public void isVirtualMeterPointDelete(String virtualMeterpoint) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		waitForSpinnerToDisappear_MeterConfig();
		Thread.sleep(3000);
		List<WebElement> elements = MeterConfig.getVirtualMeterPoint(virtualMeterpoint);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			logger.log(LogStatus.ERROR, virtualMeterpoint + " Virtual Meter Point is not deleted.");
		} else {
			logger.log(LogStatus.PASS, virtualMeterpoint + " Virtual Meter Point deleted successfully.");

		}

	}

	public void deleteVirtualMeter() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..VirtualMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		// MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		// waitForSpinnerToDisappear_MeterConfig();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		// waitForSpinnerToDisappear_MeterConfig();
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		String virtualMeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Virtual_MeterName");
		expandMeterPoint(virtualMeterName);
		isVirtualMeterPresent(virtualMeterName);
		clickOnDeleteiCon();
		// acceptDeleteConformation();
		accept_DeleteConformation();
		waitForSpinnerToDisappear_MeterConfig();
		isVirtualMeterDeleted(virtualMeterName);

	}

	public void isVirtualMeterDeleted(String virtual_MeterName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		waitForSpinnerToDisappear_MeterConfig();
		Thread.sleep(3000);
		List<WebElement> elements = MeterConfig.getVirtualMeterPoint(virtual_MeterName);
		if (elements.size() > 0) {
			WebButton.Button_Click(driver, elements.get(0));
			logger.log(LogStatus.ERROR, virtual_MeterName + " Virtual Meter is not deleted.");
		} else {
			logger.log(LogStatus.PASS, virtual_MeterName + " Virtual Meter deleted successfully.");
		}

	}

	// Create Offline Meter
	public void createOfflineMeter() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..OfflineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		selectBuildind(MeterConfiguration_datalist.get(4).toString());
		clickOnCreateMeteriCon();
		selectSystemDropDown(MeterConfiguration_datalist.get(5).toString());
		selectMeterNature(MeterConfiguration_datalist.get(6).toString());
		selectMeterType(MeterConfiguration_datalist.get(7).toString());
		selectMeterLoadType(MeterConfiguration_datalist.get(8).toString());
		String Offline_MeterName = MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"Offline_MeterName", Offline_MeterName);
		System.out.println("MeterName : " + Offline_MeterName);
		enterMeterName(Offline_MeterName);
		select_MeterRollUp(MeterConfiguration_datalist.get(9).toString());
		slectEquipmentCategoryDropDown(MeterConfiguration_datalist.get(10).toString());
		String Offline_MeterPointName = MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"Offline_MeterPointName", Offline_MeterPointName);
		System.out.println("Offline_MeterPointName : " + Offline_MeterPointName);
		enterOfflineMeterPointName(Offline_MeterPointName);
		String Offline_PointDescription = MEMSCloud_Orgnization_Action.generateRandomalphabets(10);
		enterDescription(Offline_PointDescription);
		select_UnitType(MeterConfiguration_datalist.get(11).toString());
		select_Unit(MeterConfiguration_datalist.get(12).toString());
		select_PointRole(MeterConfiguration_datalist.get(13).toString());
		select_Seriestype(MeterConfiguration_datalist.get(14).toString());
		saveOfflineMeter();
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		checkCreatedOfflineMeterIsPresent(Offline_MeterName);

	}

	public void checkCreatedOfflineMeterIsPresent(String meterName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getOnlineMeter(meterName);
		if (elements != null) {
			elements.get(0).click();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, meterName + " Offline meter is created sucessfully .");
		} else {
			logger.log(LogStatus.ERROR, meterName + " Offline meter is not created sucessfully ..");
		}
	}

	public void saveOfflineMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getOfflineSaveMeter();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Clicked on save button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Save button Field Failed.");
		}

	}

	public void select_Seriestype(String seriesType) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getOfflineSeriesType(), "Series Type",
				seriesType, logger);
	}

	public void select_PointRole(String pointrole) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getOfflinePointRole(), "Point Role",
				pointrole, logger);
	}

	public void select_Unit(String unit) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getUnit(), "Unit", unit, logger);
	}

	public void select_UnitType(String unitType) throws Exception {
		/*
		 * for (int i = 0; i <= 20; i++) { element=
		 * MeterConfig.getOfflineunitType(); if(element != null &&
		 * element.isDisplayed() && element.isEnabled()){
		 * MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.
		 * getOfflineunitType(), "Unit Type", unitType); break; }else{
		 * Thread.sleep(500); } }
		 */
		int flag = 0;
		for (int i = 0; i <= 20; i++) {
			element = MeterConfig.getOfflineunitType();
			if (element != null && element.isEnabled()) {
				element.click();
				selectByVisibleText(element, unitType);
				Thread.sleep(500);
				flag = 1;
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		if (flag == 1) {
			logger.log(LogStatus.PASS, unitType + " drop down selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + unitType + " Field Failed.");
		}
		// MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getOfflineunitType(),
		// "Unit Type", unitType);
	}

	public void enterDescription(String offline_PointDescription) throws Exception {
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(MeterConfig.getEnterDescription(),
				"Offline Meter Point Description", offline_PointDescription + " Description", logger);
	}

	public void enterOfflineMeterPointName(String offline_MeterPointName) throws Exception {
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(MeterConfig.getofflineMeterPointName(),
				"Offline Meter Point Name", offline_MeterPointName, logger);
	}

	public void slectEquipmentCategoryDropDown(String EquipmentCategory) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getequipmentCategory(), "Equipment Category",
				EquipmentCategory, logger);
	}

	public void enterMeterName(String OfflineMeterName) throws Exception {
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(MeterConfig.getmeterName(), "Offline Meter Name",
				OfflineMeterName, logger);
	}

	public void selectMeterLoadType(String MeterLoadType) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getmeterLoadType(), "Meter Load Type",
				MeterLoadType, logger);
	}

	public void selectMeterType(String MeterType) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getmeterType(), "Meter Type", MeterType,
				logger);
	}

	public void selectMeterNature(String Meternature) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getmeterNature(), "Meter Nature", Meternature,
				logger);
	}

	public void selectSystemDropDown(String system) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getSystem(), "System", system, logger);
	}

	public void deleteOfflineMeter() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..OfflineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		// Thread.sleep(3000);
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		// waitForSpinnerToDisappear_MeterConfig();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		// waitForSpinnerToDisappear_MeterConfig();
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		// waitForSpinnerToDisappear_MeterConfig();
		selectBuildind(MeterConfiguration_datalist.get(4).toString());
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		String Offline_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Offline_MeterName");
		checkCreatedOfflineMeterIsPresent(Offline_MeterName);
		deleteSelectedOfflineMeter();
		// waitForSpinnerToDisappear_MeterConfig();
		accept_DeleteConformation();
		// waitForSpinnerToDisappear_MeterConfig();
		checkOfflineMeterIsDeleted(Offline_MeterName);

	}

	public void checkOfflineMeterIsDeleted(String offline_MeterName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getOnlineMeter(offline_MeterName);
		if (elements.size() > 0) {
			// waitForSpinnerToDisappear_MeterConfig();
			elements.get(0).click();
			// waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.ERROR, offline_MeterName + " Offline meter is not deleted.");

		} else {
			logger.log(LogStatus.PASS, offline_MeterName + " Offline meter is deleted sucessfully .");
		}
	}

	public void deleteSelectedOfflineMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getdeleteOfflineMeter();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(1500);
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, "Clicked on delete meter icon Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for deleter meter icon Field Failed.");
		}
	}

	public void createOfflineMeterPoint() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..OfflineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		selectBuildind(MeterConfiguration_datalist.get(4).toString());
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		String Offline_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Offline_MeterName");
		checkCreatedOfflineMeterIsPresent(Offline_MeterName);
		clickOnCreateMeteriCon();
		select_Add_Offline_MeterPoint_RadioBtn();
		String Offline_MeterPoint = MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
				"Offline_MeterPoint", Offline_MeterPoint);
		System.out.println("Offline_MeterPoint : " + Offline_MeterPoint);
		enterOfflineMeterPoint(Offline_MeterPoint);
		String Offline_PointDescription = MEMSCloud_Orgnization_Action.generateRandomalphabets(10);
		enter_Description(Offline_PointDescription);
		select_OfflineUnitType(MeterConfiguration_datalist.get(11).toString());
		select_UnitOfflineMeterPoint(MeterConfiguration_datalist.get(12).toString());
		select_OfflineMeterPointRole(MeterConfiguration_datalist.get(13).toString());
		select_OfflineMeterPointSeriestype(MeterConfiguration_datalist.get(14).toString());
		saveOfflineMeterPoint();
		expandMeterPointTree(Offline_MeterName);
		isPointAdded(Offline_MeterPoint);

	}

	public void isPointAdded(String offline_MeterPoint) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getOfflineMeterPointTree(offline_MeterPoint);
		if (elements != null) {
			elements.get(0).click();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, offline_MeterPoint + " Meter Point added Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + offline_MeterPoint + " Meter Point not added.");
		}
	}

	public void expandMeterPointTree(String Offline_MeterName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getExpandMeterPointTree(Offline_MeterName);
		if (elements != null) {
			for (int i = 0; i <= 20; i++) {
				if (elements.get(0).isEnabled()) {
					elements.get(0).click();
					waitForSpinnerToDisappear_MeterConfig();
					logger.log(LogStatus.PASS, Offline_MeterName + " Meter Point Tree Expanded Successfully.");
					break;
				} else {
					Thread.sleep(1000);
				}
			}

		} else {
			logger.log(LogStatus.ERROR,
					"Identifying WebElement for " + Offline_MeterName + " Meter Point Tree  Field Failed.");
		}

	}

	public void saveOfflineMeterPoint() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.get_OfflineSaveMeter();

		for (int i = 0; i <= 20; i++) {
			if (element != null && element.isEnabled()) {
				WebButton.Button_Click(driver, element);
				waitForSpinnerToDisappear_MeterConfig();
				Thread.sleep(3000);
				logger.log(LogStatus.PASS, "Clicked on save button successfully.");
				break;
			} else {
				Thread.sleep(1000);
			}
			if (i >= 19) {
				logger.log(LogStatus.ERROR, "Identifying WebElement for Save button Field Failed.");
			}
		}

		/*
		 * if (element != null) { waitForSpinnerToDisappear_MeterConfig();
		 * WebButton.Button_Click(driver, element);
		 * waitForSpinnerToDisappear_MeterConfig(); Thread.sleep(1000);
		 * logger.log(LogStatus.PASS, "Clicked on save button successfully."); }
		 * else { logger.log(LogStatus.ERROR,
		 * "Identifying WebElement for Save button Field Failed."); }
		 */

	}

	public void select_OfflineMeterPointSeriestype(String seriesType) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getofflineMeterPointseriesType(),
				"Series Type", seriesType, logger);

	}

	public void select_OfflineMeterPointRole(String pointrole) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getofflineMeterPointRole(), "Point Role",
				pointrole, logger);
	}

	public void select_UnitOfflineMeterPoint(String unit) throws Exception {
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getUnitOfflineMeterPoint(), "Unit", unit,
				logger);
	}

	public void enter_Description(String offline_PointDescription) throws Exception {
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(MeterConfig.getEnter_Description(),
				"Offline Meter Point Description", offline_PointDescription + " Description", logger);
	}

	public void select_OfflineUnitType(String unitType) throws Exception {
		int flag = 0;
		for (int i = 0; i <= 20; i++) {
			element = MeterConfig.getoffline_UnitType();
			if (element != null && element.isEnabled()) {
				element.click();
				selectByVisibleText(element, unitType);
				Thread.sleep(500);
				flag = 1;
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		if (flag == 1) {
			logger.log(LogStatus.PASS, unitType + " drop down selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + unitType + " Field Failed.");
		}

		// MEMSCloud_Orgnization_Action.selectDropDownWithLogger(MeterConfig.getoffline_UnitType(),
		// "Unit Type", unitType);
	}

	public void enterOfflineMeterPoint(String offline_MeterPointName) throws Exception {
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(MeterConfig.getOffline_MeterPointName(),
				"Offline Meter Point ", offline_MeterPointName, logger);
	}

	public void select_Add_Offline_MeterPoint_RadioBtn() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getAddofflineMeterPointRadioBtn();
		if (element != null) {
			;
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Add offline meter point radio button clicked Successfully.");
		} else {
			logger.log(LogStatus.ERROR,
					"Identifying WebElement for Add offline meter point radio button Field Failed.");
		}
	}

	public void deleteOfflineMeterPoint() throws Exception {

		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		String Userslistdata_JSONPath = "$..OfflineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());
		selectBuildind(MeterConfiguration_datalist.get(4).toString());
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),
				MeterConfiguration_datalist.get(6).toString());
		String Offline_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Offline_MeterName");
		expandMeterPointTree(Offline_MeterName);
		String Offline_MeterPoint = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Offline_MeterPoint");
		isPointAdded(Offline_MeterPoint);
		deleteSelectedOfflineMeter();
		accept_DeleteConformation();
		isMeterPoint_Deleted(Offline_MeterPoint);

	}

	public void selectmeter(String offline_MeterName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getSelectOfflineMeterPoint(offline_MeterName);
		if (elements.size() > 0) {
			waitForSpinnerToDisappear_MeterConfig();
			elements.get(0).click();
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, offline_MeterName + " Meter Point selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, offline_MeterName + " Meter Point not found.");
		}

	}

	public void accept_DeleteConformation() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getdeleteOfflineMeterPoint();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			Thread.sleep(2000);
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, "Accept delete conformation.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for delete conformation Field Failed.");
		}

	}

	public void isMeterPoint_Deleted(String offline_MeterPoint) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.getOfflineMeterPointTree(offline_MeterPoint);
		if (elements.size() > 0) {
			elements.get(0).click();
			Thread.sleep(1000);
			logger.log(LogStatus.ERROR, offline_MeterPoint + " Meter Point not deleted.");
		} else {
			logger.log(LogStatus.PASS, offline_MeterPoint + " Meter Point deleted Successfully.");
		}

	}

	public void OnlinePoint_UnderOnlineMeter() throws Exception{
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		String Userslistdata_JSONPath = "$..OnlineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();		
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();			
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());		
		String AddOnlinePoint_JSONPath = "$..AddOnlinePoint_Under_OnlineMeter.*";
		List<String> AddOnlinePoint_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),AddOnlinePoint_JSONPath);
		selectDataCollector(AddOnlinePoint_datalist.get(0).toString());
		selectDataSource(AddOnlinePoint_datalist.get(1).toString());
		selectDataSourceDevice(AddOnlinePoint_datalist.get(2).toString());
		clickOnAllPointsButton();
		doubleClickOnPoint(AddOnlinePoint_datalist.get(3).toString());
		selectReadFrequency(AddOnlinePoint_datalist.get(4).toString());
		selectUnitType(AddOnlinePoint_datalist.get(5).toString());
		selectUnit(AddOnlinePoint_datalist.get(6).toString());
		selectPointRole(AddOnlinePoint_datalist.get(7).toString());
		selectMeterSeriesType(AddOnlinePoint_datalist.get(8).toString());
		enterMinValue(AddOnlinePoint_datalist.get(9).toString());
		enterMaxValue(AddOnlinePoint_datalist.get(10).toString());
		clickOnUpdateButton(AddOnlinePoint_datalist.get(3).toString());			
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());		
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),MeterConfiguration_datalist.get(6).toString());
		String Online_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		checkCreatedOnlineMeterIsPresent(Online_MeterName);
		clickOnCreateMeteriCon();
		select_AddOnlinePointRadioBtn();
		selectOnlinePoint(AddOnlinePoint_datalist.get(3).toString());
		saveMeterPoint();
		expandMeterPoint(Online_MeterName);
		isPointAdd(AddOnlinePoint_datalist.get(3).toString());		
	}
	
	public void select_AddOnlinePointRadioBtn() {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		element = MeterConfig.getAddOnlinePointRadioBtn();
		if(element != null && element.isDisplayed() && element.isEnabled()){			;
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Add Online Point radio button clicked Successfully.");
		}else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Add Online Point radio button Field Failed.");	
		}		
	}
	
	// *************** SELECT ONLINE POINT CHECK BOX	
	public void selectOnlinePoint(String PointName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		List<WebElement> elements = MeterConfig.getselectOnlinePoint(PointName);
		if (elements.size() > 0 && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {			
			//elements.get(0).click();	
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(300);
			logger.log(LogStatus.PASS, PointName + " is selected successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + PointName + " Field Failed.");
		}
	}

	public void add_VirtualPoint_UnderOnlineMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		String Userslistdata_JSONPath = "$..OnlineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();		
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();			
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());	
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());		
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),MeterConfiguration_datalist.get(6).toString());
		String Online_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		checkCreatedOnlineMeterIsPresent(Online_MeterName);			
		clickOnCreateMeteriCon();
		select_AddVirtualPointRadioBtn();
		String Virtual_MeterPointName_UnderOnlineMeter = MEMSCloud_Orgnization_Action.generateRandomalphabets(8);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),	"Virtual_MeterPointName_UnderOnlineMeter", Virtual_MeterPointName_UnderOnlineMeter);
		enterVirtualMeterPointName_UnderOnlineMeter(Virtual_MeterPointName_UnderOnlineMeter);
		String Virtual_MeterPointDesc_UnderOnlineMeter = MEMSCloud_Orgnization_Action.generateRandomalphabets(8);
		enterVirtualDesc_UnderOnlineMet(Virtual_MeterPointDesc_UnderOnlineMeter);
		String VirtualPoint_Under_OnlineMeter_JSONPath = "$..AddVirtualPoint_Under_OnlineMeter.*";
		List<String> VirtualPoint_Under_OnlineMeter_JSONPath_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),VirtualPoint_Under_OnlineMeter_JSONPath);
		selectUnitTypeDropDown(VirtualPoint_Under_OnlineMeter_JSONPath_datalist.get(1).toString());
		selectUnitDropDown(VirtualPoint_Under_OnlineMeter_JSONPath_datalist.get(2).toString());
		selectPointRoleDropDown(VirtualPoint_Under_OnlineMeter_JSONPath_datalist.get(3).toString());
		selectSeriesTypeDropDown(VirtualPoint_Under_OnlineMeter_JSONPath_datalist.get(4).toString());
		clickOnVirtualPointDefination_Under_OnlineMet();			
		String OnlineMeter_JSONPath = "$..OnlineMeter.*";
		List<String> OnlineMeter_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), OnlineMeter_JSONPath);
		expandBuildingTree_virPopUp_UnderOnlineMet(OnlineMeter_datalist.get(4).toString());
		expandCommodityTree_VirPopUp_UnderOnlineMet(OnlineMeter_datalist.get(4).toString(), OnlineMeter_datalist.get(6).toString());
		String pointName = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		expandMeterTree(pointName);
		String MeterPoint_JSONPath = "$..AddVirtualPoint_Under_OnlineMeter.*";
		List<String> MeterPoint_JSONPath_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), MeterPoint_JSONPath);
		dragDropPoint(MeterPoint_JSONPath_datalist.get(0).toString());
		clickOnDivideButton();
		enterNumericValue();
		clickOnEnterButton();
		validateSyntax();
		String virtualPointdefination = getVirtualPointDefination();
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),	"virtual_Point_Defination", virtualPointdefination);
		clickOnSaveRuleBtn();
		saveVirtualMeterpoint_UnderOnlineMeter();
		isVirtualPointAdd_UnderOnlineMeter(Virtual_MeterPointName_UnderOnlineMeter);
		
	}
	public void isVirtualPointAdd_UnderOnlineMeter(String meterPointName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		List<WebElement> elements = MeterConfig.getVirtualPoint_Under_OnlineMeter(meterPointName);
		if (elements.size() > 0 && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {				
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(500);
			logger.log(LogStatus.PASS, meterPointName + " Point Present Under Online meter.");
		} else {
			logger.log(LogStatus.ERROR, meterPointName + " Point Not Present Under Online meter.");
		}		
	}
	
	public void saveVirtualMeterpoint_UnderOnlineMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		element = MeterConfig.getSaveVirtualMeterpoint_UnderOnlineMeter();
		if (element != null && element.isDisplayed() && element.isEnabled()) {
			// Thread.sleep(2000);
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Clicked on Save Rule button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Save Rule Field Failed.");
		}
	}

	public void expandCommodityTree_VirPopUp_UnderOnlineMet(String buildingName, String commodityName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		List<WebElement> elements1 = MeterConfig.getexpandCommodityTree_VirPopUp_Minus(buildingName, commodityName);
		List<WebElement> elements = MeterConfig.getexpandCommodityTree_VirPopUp_Plus(buildingName, commodityName);
		if (elements.size() > 0 && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Commodity Tree expand successfully.");
		} else if (elements1.size() > 0 && elements1.get(0).isDisplayed() && elements1.get(0).isEnabled()) {
			logger.log(LogStatus.PASS, "Commodity Tree expand successfully.");
		}
		else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Commodity Tree Field Failed.");
		}
	}
	
	public void expandBuildingTree_virPopUp_UnderOnlineMet(String BuildingName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		List<WebElement> elements = MeterConfig.getexpandBuildingTree_VirPopUp_Plus(BuildingName);
		List<WebElement> elements1 = MeterConfig.getexpandBuildingTree_VirPopUp_Minus(BuildingName);
		if (elements.size() > 0 && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Building Tree expand successfully.");
		} else if (elements1.size() > 0 && elements1.get(0).isDisplayed() && elements1.get(0).isEnabled()) {
			logger.log(LogStatus.PASS, "Building Tree expand successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Building Tree Field Failed.");
		}
	}

	public void clickOnVirtualPointDefination_Under_OnlineMet() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		element = MeterConfig.getVirtualPointDef_Under_OnlineMet();
		if (element != null && element.isDisplayed() && element.isEnabled()) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear_MeterConfig();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked on Virtual point definition button successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Virtual point definition button Field Failed.");
		}		
	}
	
	public void selectPointRoleDropDown(String PointRole) throws Exception {
		selectDropDown(MeterConfig.getpointRole_VirMet_Under_OnlineMet(), PointRole);
	}

	public void select_AddVirtualPointRadioBtn() {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		element = MeterConfig.getAddVirtualPointRadioBtn();
		if(element != null && element.isDisplayed() && element.isEnabled()){			
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Add Virtual Point radio button clicked Successfully.");
		}else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Add Virtual Point radio button Field Failed.");	
		}		
	}
	public void enterVirtualMeterPointName_UnderOnlineMeter(String PointName) throws Exception {		
		sendInputTextBoxWithLogger(MeterConfig.getVirtualpointName_UnderOnlineMeter(), "Virtual_MeterPointName_UnderOnlineMeter", PointName);
	}
	public void enterVirtualDesc_UnderOnlineMet(String virtual_MeterPointDesc_UnderOnlineMeter) throws Exception {
		sendInputTextBoxWithLogger(MeterConfig.getEnterVirtualDesc_UnderOnlineMet(), "Virtual_MeterPointDescription_UnderOnlineMeter", virtual_MeterPointDesc_UnderOnlineMeter);		
	}
	public void selectUnitTypeDropDown(String UnitType) throws InterruptedException {
		//selectDropDown(MeterConfig.getunitType_VirPt_Under_OnlineMet(), UnitType);
		selectDropDown_UsingJS(MeterConfig.getunitType_VirPt_Under_OnlineMet(), UnitType);
	}
	public void selectUnitDropDown(String Unit) throws InterruptedException {	
		//Thread.sleep(2000);
		//element = MeterConfig.getUnit_VirMet_Under_OnlineMet();
		//selectUnitDropDown(element, Unit);
		selectDropDown_UsingJS(MeterConfig.getUnit_VirMet_Under_OnlineMet(), Unit);
		
	/*	int flag = 0;
		for (int i = 0; i <= 20; i++) {					
		element = MeterConfig.getUnit_VirMet_Under_OnlineMet();
			if(element != null && element.isEnabled()){				
				element.click();
				Thread.sleep(500);
				selectByVisibleText(element, Unit);
				flag = 1;
				break;
			}else{
				Thread.sleep(1000);
			}			
		} 
		
		if(flag == 1){
			logger.log(LogStatus.PASS, Unit + " drop down selected Successfully.");
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for " + Unit + " Field Failed.");
		}
				*/
	}


	public void selectSeriesTypeDropDown(String SeriesType) throws InterruptedException {
		//selectDropDown(MeterConfig.getseriesType_VirMet_Under_OnlineMet(), SeriesType);
		//Thread.sleep(2000);
		//element = MeterConfig.getseriesType_VirMet_Under_OnlineMet();
		//selectUnitDropDown(element, SeriesType);
		selectDropDown_UsingJS(MeterConfig.getseriesType_VirMet_Under_OnlineMet(), SeriesType);
	}

	public void delete_VirtualPoint_UnderOnlineMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		String Userslistdata_JSONPath = "$..OnlineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),Userslistdata_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();		
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();			
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());	
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());		
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),MeterConfiguration_datalist.get(6).toString());
		String Online_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		checkCreatedOnlineMeterIsPresent(Online_MeterName);
		String pointName = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		expandOnlineMeterPoint(pointName);
		String Virtual_MeterPointName_UnderOnlineMeter = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Virtual_MeterPointName_UnderOnlineMeter");
		isVirtualPointAdd_UnderOnlineMeter(Virtual_MeterPointName_UnderOnlineMeter);
		clickOnDeleteiCon();
		accept_DeleteConformation();
		isVirtualPointDelete_UnderOnlineMeter(Virtual_MeterPointName_UnderOnlineMeter);
		
	}
	
	public void isVirtualPointDelete_UnderOnlineMeter(String meterPointName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		List<WebElement> elements = MeterConfig.getVirtualPoint_Under_OnlineMeter(meterPointName);
		if (elements.size() > 0 && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {					
			WebButton.Button_Click(driver, elements.get(0));
			Thread.sleep(500);
			logger.log(LogStatus.ERROR, meterPointName + " Point Present Under Online meter.");
		} else {
			logger.log(LogStatus.PASS, meterPointName + " Point Deleted Successfully.");
		}		
	}

	// *************** EXPAND ONLINE METER POINT
	public void expandOnlineMeterPoint(String meterPointName) throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		List<WebElement> elements = MeterConfig.getexpandOnlineMeterPoint(meterPointName);
		if (elements.size() > 0 && elements.get(0).isEnabled() && elements.get(0).isDisplayed()) {				
			WebButton.Button_Click(driver, elements.get(0));	
			Thread.sleep(2000);			
			waitForSpinnerToDisappear_MeterConfig();
			logger.log(LogStatus.PASS, meterPointName + " Meter Point Tree expand successfully.");
		} else {
			logger.log(LogStatus.ERROR,	"Identifying WebElement for " + meterPointName + " Meter Point expand icon Field Failed.");
		}

	}

	public void delete_OnlinePoint_UnderOnlineMeter() throws Exception {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
		String Userslistdata_JSONPath = "$..OnlineMeter.*";
		List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),Userslistdata_JSONPath);
		String AddOnlinePoint_JSONPath = "$..AddOnlinePoint_Under_OnlineMeter.*";
		List<String> AddOnlinePoint_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),AddOnlinePoint_JSONPath);
		correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
		waitForLoginUser();
		waitForPortfoilioLandingPageSpinnerToDisappear();		
		driver.get(MeterConfiguration_datalist.get(2).toString());
		waitForSpinnerToDisappear_Setup();
		navigateMeterConfigurationTab();
		waitTillMeterDistributionTreeAppear(MeterConfiguration_datalist.get(3).toString());	
		expandMeterDistributionTree(MeterConfiguration_datalist.get(3).toString());		
		expandBuildingTree(MeterConfiguration_datalist.get(4).toString());
		expandCommodityTree(MeterConfiguration_datalist.get(4).toString(),MeterConfiguration_datalist.get(6).toString());
		String Online_MeterName = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Online_MeterName");
		checkCreatedOnlineMeterIsPresent(Online_MeterName);			
		expandOnlineMeterPoint(Online_MeterName);
		isPointAdd(AddOnlinePoint_datalist.get(3).toString());
		clickOnDeleteiCon();
		accept_DeleteConformation();
		isPointDelete(AddOnlinePoint_datalist.get(3).toString());		
	}
	
	// *************** EXPAND METER POINT
	public void isPointDelete(String pointName) throws InterruptedException {
		MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver,
				logger);
		List<WebElement> elements = MeterConfig.selectedAddedPoint(pointName);
		if (elements.size() > 0 && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
			elements.get(0).click();
			Thread.sleep(300);
			logger.log(LogStatus.ERROR, pointName + " Point is not Deleted.");
		} else {
			logger.log(LogStatus.PASS, pointName + " Point Deleted successfully.");
		}
	}
}
