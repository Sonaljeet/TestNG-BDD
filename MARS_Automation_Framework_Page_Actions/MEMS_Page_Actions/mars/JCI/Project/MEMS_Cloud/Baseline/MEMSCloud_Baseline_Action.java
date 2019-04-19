package mars.JCI.Project.MEMS_Cloud.Baseline;

import java.util.ArrayList;
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
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.Baseline.MEMSCloud_Baseline_Page_Factory;
import mars.JCI.Project.MEMSCloud.Portfoliosuperadmin.MEMSCloud_PortfolioCreation_Page_Factory;
import mars.JCI.Project.MEMSCloud.Users.MEMSCloud_Users_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_Baseline_Action {

public static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	public static MEMSCloud_Orgnization_Action orgobject=null;
	public static String username="";
	public static List<String> Baselinedatalist_data = new ArrayList<String>();
	public static List<Boolean> Baselinetextboxvalues = new ArrayList<Boolean>();
	/**
	 * Instantiates/Constructor a new MUI login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEMSCloud_Baseline_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		orgobject=new MEMSCloud_Orgnization_Action(driver,logger);
	}
	
	
	public void enterBaselinename(String Baseline_name) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getbaselinename();
			if(element!= null){
				if((element.isDisplayed()) && (element.isEnabled())){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, Baseline_name);
					logger.log(LogStatus.PASS, "baseline name Entered succesfully to baseline name WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for baseline name Field Failed");   
			}
			
		}
		
	public void selectBaseline_type(String  baseline_type) throws Exception{
		
		Thread.sleep(2000);
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getbaseline_type();
			if(element!= null){
				if((element.isDisplayed()) && (element.isEnabled())){
				if(MEMSCloud_Orgnization_Action.checkDropDownOptionsValue(element, baseline_type)){
					MEMSCloud_Orgnization_Action.selectByVisibleText(element, baseline_type,logger);
					logger.log(LogStatus.PASS, "baseline type Entered succesfully to baseline type WebElement");  
				}else{
					logger.log(LogStatus.FAIL, "Specified dropdown value is not present in dropdown");
					throw new Exception("Element not found");
				}
			  }
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for baseline type Field Failed");   
			}
		
			
		}
	
	public void selectLocation(String Location) throws Exception{
		
		Thread.sleep(2000);
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getLocation();
			if(element!= null){
				if((element.isDisplayed()) && (element.isEnabled())){
				if(MEMSCloud_Orgnization_Action.checkDropDownOptionsValue(element, Location)){
					MEMSCloud_Orgnization_Action.selectByVisibleText(element, Location,logger);
					logger.log(LogStatus.PASS, "Location Entered succesfully to Location WebElement");  
				}
				else{
					logger.log(LogStatus.FAIL, "Specified dropdown value is not present in dropdown"); 
					throw new Exception("Element not found");
				}
			  }
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Location Field Failed");   
			}
		
		}
	
	public void selectBuilding(String Buildingname) throws Exception {
		
			Thread.sleep(3000);
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getBuilding();
			if(element!= null){
				if((element.isDisplayed()) && (element.isEnabled())){
				if(MEMSCloud_Orgnization_Action.checkDropDownOptionsValue(element, Buildingname)){
					Thread.sleep(2000);
					MEMSCloud_Orgnization_Action.selectByVisibleTextWithFluentWait(element, Buildingname);
					MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
					logger.log(LogStatus.PASS, "building name Entered succesfully to building name WebElement");
				}else{
					logger.log(LogStatus.FAIL, "Specified dropdown value is not present in dropdown"); 
					throw new Exception("Element not found");
				}
			  }
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for building name Field Failed");   
			}
		
		}
	public void selectCommodity(String Commodity) throws Exception {
		Thread.sleep(2000);
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getCommodity();
			
			if(element!= null){
				if(MEMSCloud_Orgnization_Action.checkDropDownOptionsValue(element, Commodity)){
					MEMSCloud_Orgnization_Action.selectByVisibleText(element, Commodity,logger);
					logger.log(LogStatus.PASS, "commodity Entered succesfully to commodity WebElement");  
				}else{
					logger.log(LogStatus.FAIL, "Specified dropdown value is not present in dropdown"); 
					throw new Exception("Element not found");
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for commodity Field Failed");   
			}
		}
	
	public void selectPointrole(String PointRole) throws Exception {
		Thread.sleep(2000);
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getPointrole();
			if(element!= null){
				if(MEMSCloud_Orgnization_Action.checkDropDownOptionsValue(element, PointRole)){
					MEMSCloud_Orgnization_Action.selectByVisibleText(element, PointRole,logger);
					logger.log(LogStatus.PASS, "point role Entered succesfully to Point role WebElement");  
				}else{
					logger.log(LogStatus.FAIL, "Specified dropdown value is not present in dropdown");
					throw new Exception("Element not found");
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Point role Field Failed");   
			}
		}
	
	public void enterbaseline_insearchbox(String baselinename) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getBaseline_searchbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, baselinename);
					logger.log(LogStatus.PASS, "baselinename Entered succesfully to baselinename searchbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for baselinename searchbox Field Failed");   
			}
			
		}
	
	public void clickSubmit_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getbaselineSubmit_btn();
		if(element!= null){
				WebButton.Button_Click(driver, element);
				logger.log(LogStatus.PASS, "Clicked succesfully to Submit btn WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Submit Field Failed");   
		}
	}
	
	public void clickaddbaseline_icon() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getaddbaselinebtn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to createbaselineicon button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for creatbaselineicon Field Failed");   
		}
	}
		
	public void clickDeleteBaseline_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getDeletebaseline_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to deletebaselineicon button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for deletebaselineicon Field Failed");   
		}
	}
	
	public void clickdeletebaseline_confirm_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getDeleteBaseline_confirm();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to deletebaselineconfirm button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for deletebaselineconfirm Field Failed");   
		}
	}
	
	public void clickeditbaseline_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getEditbaseline_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to Editbaseline button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Editbaseline Field Failed");   
		}
	}
	
	public void verifyBaselinepresent(String baseline) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		elements = BaselinePF.checkbaselinepresent();
		if(elements.size() >0){	
			//elements.get(0).click();
				logger.log(LogStatus.PASS, " baseline:= "+baseline+ " is created sucessfully and is present in grid");  
		}
		else{
			logger.log(LogStatus.FAIL, " baseline:= "+baseline+ " is not created sucessfully");   
		}
	}
	
	public void verifyBaselinenotpresent(String baseline) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		elements = BaselinePF.checkbaselinepresent();
		if(elements.size()>0){	
				logger.log(LogStatus.FAIL, " baseline:= "+baseline+" not delete from the grid");  
		}
		else{
			logger.log(LogStatus.PASS, " baseline:= "+ baseline+" deleted succesfully from the grid");   
		}
	}
	public void verifyBaselineSearchpresent(String baseline) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		elements = BaselinePF.checkbaselinepresent();
		if(elements.size() >0){	
			//elements.get(0).click();
				logger.log(LogStatus.PASS, " baseline:= "+baseline+ " is present in grid");  
		}
		else{
			logger.log(LogStatus.FAIL, " baseline:= "+baseline+ " not present in grid");   
		}
	}
	public void verifyUpdatedBaselinepresent(String baseline) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		elements = BaselinePF.checkbaselinepresent();
		if(elements.size() >0){	
			//elements.get(0).click();
				logger.log(LogStatus.PASS, " baseline:= "+baseline+ " is updated sucessfully and is present in grid");  
		}
		else{
			logger.log(LogStatus.FAIL, " baseline:= "+baseline+ " is not updated sucessfully");   
		}
	}
	public void selectBaseline_year(String Baseline_year) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getBaseline_year_dropdown();
			if(element!= null){
					MEMSCloud_Orgnization_Action.selectByVisibleText(element, Baseline_year,logger);
					logger.log(LogStatus.PASS, "Baseline year selected succesfully to baseline year WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for baseline year Field Failed");   
			}
		}
	
	public void enterjan_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getJan_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.click();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "Jan month baseline value entered succesfully to jan month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement Jan month baseline Field Failed");   
			}
		}
	
	public void enterfeb_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getFeb_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "feb month baseline value entered succesfully to feb month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement feb month baseline Field Failed");   
			}
		}
	
	
	public void entermarch_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getMar_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "march month baseline value entered succesfully to march month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement march month baseline Field Failed");   
			}
		}
	
	public void enterapril_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getApr_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "April month baseline value entered succesfully to April month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement April month baseline Field Failed");   
			}
		}
	
	public void entermay_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getMay_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "May month baseline value entered succesfully to May month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement May month baseline Field Failed");   
			}
		}
	
	public void enterjune_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getJune_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "June month baseline value entered succesfully to June month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement June month baseline Field Failed");   
			}
		}
	public void enterjuly_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getJuly_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "July month baseline value entered succesfully to July month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement July month baseline Field Failed");   
			}
		}
	public void enterAug_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getAug_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "August month baseline value entered succesfully to August month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement August month baseline Field Failed");   
			}
		}
	public void enterseptember_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getSept_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "September month baseline value entered succesfully to September month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement September month baseline Field Failed");   
			}
		}
	public void enteroctober_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getOct_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "October month baseline value entered succesfully to October month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement October month baseline Field Failed");   
			}
		}
	public void enterNov_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getNov_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "November month baseline value entered succesfully to November month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement November month baseline Field Failed");   
			}
		}
	
	public void enterdecemeber_month(String month_baseline_value) throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			element = BaselinePF.getDec_month_textbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, month_baseline_value);
					logger.log(LogStatus.PASS, "December month baseline value entered succesfully to December month baseline textbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement December month baseline Field Failed");   
			}
		}

	
	public void click_adddefinebaseline_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getAdd_define_baseline_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to add define baseline button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for add define baseline button Field Failed");   
		}
	}
	
	public void click_updatedefinebaseline_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getUpdate_define_baseline_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to update define baseline button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for update define baseline button Field Failed");   
		}
	}
	
	public void click_cleardefinebaseline_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getClear_define_baseline_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to clear define baseline button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for clear define baseline button Field Failed");   
		}
	}
	
	public void click_deletedefinebaseline_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getDelete_define_baseline_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to delete define baseline button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for delete define baseline button Field Failed");   
		}
	}
	
	
	public void clickdeleteDefinebaseline_confirm_btn() throws Exception {
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getDeleteDefineBaselineConfirm_Btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to deletebaselineconfirm button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for deletebaselineconfirm Field Failed");   
		}
	}
	
	public void verifyDefineBaselinepresentbyyear(String baseline)throws Exception{
		
			List<WebElement> elements=null;
			MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			elements = BaselinePF.checkdefinebaselinepresent();
			if(elements.size() > 0){
				Thread.sleep(1000);
				elements.get(0).click();
				logger.log(LogStatus.PASS, "For baseline:= "+baseline+" Define  baseline added succefully");  
			}
			else{
				logger.log(LogStatus.FAIL, "For baseline:= "+baseline+" Define  baseline add failed");   
			}
	}
	
	public void verifyDefineBaselinenotpresentbyyear(String baseline)throws Exception{
			List<WebElement> elements=null;
			MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			elements = BaselinePF.checkdefinebaselinepresent();
			if(elements.size() >0){
				logger.log(LogStatus.FAIL, "Define  baseline:= "+baseline+" deleted failed");  
			}
			else{
				logger.log(LogStatus.PASS, "Define  baseline:= "+baseline+" deleted  succefully");   
			}
	}
	
	public void verifyDefineBaselinepresentbymonth(String baseline) throws Exception{
	
			List<WebElement> elements=null;
			MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			elements = BaselinePF.checkdefinebaselinepresentbymonth();
			if(elements.size() >0){
				elements.get(0).click();
				logger.log(LogStatus.PASS, "Define  baseline:= "+baseline+ " updated succefully");  
			}
			else{
				logger.log(LogStatus.FAIL, "Define  baseline:= "+baseline+ " updation failed");   
			}
	}
	
	public void clickonbaseline() throws Exception{
			List<WebElement> elements=null;
			MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			elements = BaselinePF.checkbaselinepresent();
			if(elements.size() >0){
				elements.get(0).click();
				logger.log(LogStatus.PASS, "Succesfully clicked on baseline ");  
			}
			else{
				logger.log(LogStatus.FAIL, "baseline click failed");   
			}
	}

	public void clickondefinebaseline() throws Exception{
	
			List<WebElement> elements=null;
			MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			elements = BaselinePF.checkdefinebaselinepresent();
			if(elements.size() >0){
				elements.get(0).click();
				logger.log(LogStatus.PASS, "Succesfully clicked on define baseline ");  
			}
			else{
				logger.log(LogStatus.FAIL, "define baseline click failed");   
			}
	}
	
	public List<WebElement> getAllBaselineMonthtTextboxes() throws Exception{
		
			List<WebElement> elements=null;
			MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
			elements = BaselinePF.getAllbaselinemonthstextboxes();
			if(elements.size() >0){
				logger.log(LogStatus.PASS, "Succesfully get the all baseline months textboxes ");  
				return elements;
			}
			else{
				logger.log(LogStatus.FAIL, "failed to get all baseline months textboxes ");  
				return null;
			}
	}
	
	public void checkblankbaselineyear(String Baseline) throws Exception{
		MEMSCloud_Baseline_Page_Factory BaselinePF = new MEMSCloud_Baseline_Page_Factory(driver,logger);
		element = BaselinePF.getBaseline_year_dropdown();
		System.out.println("s"+MEMSCloud_Orgnization_Action.getSelectedOptionFromDropDown(element));
		if(MEMSCloud_Orgnization_Action.getSelectedOptionFromDropDown(element).contains("Select")){
			logger.log(LogStatus.PASS, "Baseline:= "+Baseline+ " year dropdown is cleared successfully"); 
		}else{
			logger.log(LogStatus.FAIL, "Baseline:= "+Baseline+ " year dropdown is not cleared");
		}
		
	}
	
	public void checkAllBaselineBlankValues(String baseline) throws Exception{
		
			boolean status=true;
			List<WebElement> monthList = getAllBaselineMonthtTextboxes();
			System.out.println("size"+monthList.size());
			for(WebElement element: monthList){
				boolean elementStatus=MEMSCloud_Orgnization_Action.checkBlankTextbox(element);
				if(!elementStatus){
					logger.log(LogStatus.FAIL, "baseline:= "+baseline+ " textboxes values  not cleared");
					status=false;
					break;
				 }
					
				}
			
			if(status){
				logger.log(LogStatus.PASS, "baseline:= "+baseline+ " all textboxes values is cleared successfully"); 
			   }
	}
	
	public void create_baseline() throws Exception
	{
		
				String baselinename=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
				String Baselinelist_data_JSONPath = "$..Baselinedata.*";
				Baselinedatalist_data = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Baselinelist_data_JSONPath);
				orgobject.correctLogin_Admin_WithoutFacility();
				MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				Thread.sleep(5000);
				MEMSCloud_Orgnization_Action.Navigate_to_url(Baselinedatalist_data.get(0).toString());
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				clickaddbaseline_icon();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				enterBaselinename(baselinename);
				WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"baselinename",baselinename);
				selectBaseline_type(Baselinedatalist_data.get(1).toString());
				String dynamic_building_JSONPath = "$..Building";//needs to check names
				String dynamic_facility_JSONPath = "$..Location";
				selectLocation(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), dynamic_facility_JSONPath));  //dynamic handling
				//selectBuilding(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), dynamic_building_JSONPath));  //dynamic
				selectCommodity(Baselinedatalist_data.get(2).toString());
				selectPointrole(Baselinedatalist_data.get(3).toString());
				selectBuilding(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), dynamic_building_JSONPath));  //dynamic
				clickSubmit_btn();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				enterbaseline_insearchbox(baselinename);
				verifyBaselinepresent(baselinename);
		
	}
	
	public void update_baseline() throws Exception
	{
		
				orgobject.correctLogin_Admin_WithoutFacility();
				MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				Thread.sleep(5000);
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Baselinedata.BaselineURL"));
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				String Baseline_name_JSONPath = "$..baselinename";
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				clickeditbaseline_btn();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				String baselinename=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
				WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"baselinename",baselinename);
				enterBaselinename(baselinename);
				clickSubmit_btn();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				verifyUpdatedBaselinepresent(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));	
			
	}
	public void search_baseline() throws Exception
	{
		
				orgobject.correctLogin_Admin_WithoutFacility();
				MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				Thread.sleep(5000);
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Baselinedata.BaselineURL"));
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				String Baseline_name_JSONPath = "$..baselinename";
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				verifyBaselineSearchpresent(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
		 
	}
	
	public void add_define_baseline() throws Exception
	{
		
				orgobject.correctLogin_Admin_WithoutFacility();
				String Baselinelist_data_JSONPath = "$..Baselinedata.*";
				Baselinedatalist_data = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Baselinelist_data_JSONPath);
				MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				Thread.sleep(5000);
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Baselinedata.BaselineURL"));
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				
				String Baseline_name_JSONPath = "$..baselinename";
				
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				clickonbaseline();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				selectBaseline_year(Baselinedatalist_data.get(4).toString());//baseline year
				WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Baseline_year",Baselinedatalist_data.get(4).toString());
				enterjan_month(Baselinedatalist_data.get(5).toString());
				enterfeb_month(Baselinedatalist_data.get(5).toString());
				entermarch_month(Baselinedatalist_data.get(5).toString());
				enterapril_month(Baselinedatalist_data.get(5).toString());
                entermay_month(Baselinedatalist_data.get(5).toString());
                enterjune_month(Baselinedatalist_data.get(5).toString());
                enterjuly_month(Baselinedatalist_data.get(5).toString());
                enterAug_month(Baselinedatalist_data.get(5).toString());
                enterseptember_month(Baselinedatalist_data.get(5).toString());
                enteroctober_month(Baselinedatalist_data.get(5).toString());
                enterNov_month(Baselinedatalist_data.get(5).toString());
                enterdecemeber_month(Baselinedatalist_data.get(5).toString());
				click_adddefinebaseline_btn();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				verifyDefineBaselinepresentbyyear(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
		
	}
	
	public void update_define_baseline() throws Exception
	{
		
			orgobject.correctLogin_Admin_WithoutFacility();
			String Baselinelist_data_JSONPath = "$..Baselinedata.*";
			Baselinedatalist_data = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Baselinelist_data_JSONPath);
			MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			Thread.sleep(5000);
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Baselinedata.BaselineURL"));
			MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
			String Baseline_name_JSONPath = "$..baselinename";
			enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
			clickonbaseline();
			MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
			clickondefinebaseline();
            entermay_month(Baselinedatalist_data.get(6).toString());
			click_updatedefinebaseline_btn();
			MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
			verifyDefineBaselinepresentbymonth(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
		
	}
	
	public void clear_define_baseline() throws Exception
	{	
				orgobject.correctLogin_Admin_WithoutFacility();
				MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				Thread.sleep(5000);
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Baselinedata.BaselineURL"));
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				String Baseline_name_JSONPath = "$..baselinename";
				
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				clickonbaseline();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				clickondefinebaseline();
				click_cleardefinebaseline_btn();;
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				checkAllBaselineBlankValues(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				checkblankbaselineyear(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
		
	}
	
	public void delete_define_baseline() throws Exception
	{
		
				orgobject.correctLogin_Admin_WithoutFacility();
				MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				Thread.sleep(5000);
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Baselinedata.BaselineURL"));
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				
				String Baseline_name_JSONPath = "$..baselinename";
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				clickonbaseline();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				clickondefinebaseline();
				click_deletedefinebaseline_btn();
				clickdeleteDefinebaseline_confirm_btn();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
			    verifyDefineBaselinenotpresentbyyear(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
		
	}
	
	public void delete_baseline() throws Exception
	{
			
				orgobject.correctLogin_Admin_WithoutFacility();
				MEMSCloud_Orgnization_Action.waitForPortfoilioLandingPageSpinnerToDisappear();
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				Thread.sleep(5000);
				MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Baselinedata.BaselineURL"));
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				
				String Baseline_name_JSONPath = "$..baselinename";
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				clickDeleteBaseline_btn();
				clickdeletebaseline_confirm_btn();
				MEMSCloud_Orgnization_Action.waitForBaselineSpinnerToDisappear();
				enterbaseline_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
				verifyBaselinenotpresent(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath));
		
	}
	
	
}
