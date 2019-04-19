package mars.JCI.Project.MEMS_Cloud.EquipmentConfiguration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.Baseline.MEMSCloud_Baseline_Page_Factory;
import mars.JCI.Project.MEMSCloud.EquipmentConfiguration.MEMSCloud_EquipmentConfiguration_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_EquipmentConfiguration_Action {
	public static WebDriver driver;
	/** The ExtentTest logger. */
	
	private static ExtentTest logger;
	
	/** The WebElement/Locator element. */
	public static MEMSCloud_EquipmentConfiguration_Page_Factory EquipmentConfPF=null;
	public static List<String> Equipmentdatalist_data=new ArrayList<String>();
	private WebElement element;
	public static MEMSCloud_Orgnization_Action orgobject=null;
	//public String configFile="C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	/**
	 * Instantiates/Constructor a new MUI login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEMSCloud_EquipmentConfiguration_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		orgobject=new MEMSCloud_Orgnization_Action(driver,logger);
		EquipmentConfPF = new MEMSCloud_EquipmentConfiguration_Page_Factory(driver,logger);
		Equipmentdatalist_data = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..EquipmentConfiguration.*");
	}
	
	
	
	public void selectPortfolio(String  Porftfolio) throws Exception
	{		
		
			Thread.sleep(4000);
			MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentConfPF.getPortfolioDropdown(), "Portfolio", Porftfolio,logger);
	}
	
	public void selectLocation(String  Location) throws Exception 
	{
		
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentConfPF.getLocationDropdown(), "Location", Location,logger);
	}
	
	public void selectBuilding(String  Building) throws Exception 
	{
		
			Thread.sleep(3000);
			MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentConfPF.getBuildingDropdown(), "Building", Building,logger);
	}
	
	public void selectEquipemntCategory(String  EquipmentCategory) throws Exception 
	{
	
	    Thread.sleep(4000);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentConfPF.getEquipmentCategoryDropdown(), "EquipementCat", EquipmentCategory,logger);
	}
	
	public void selectEquipemntType(String  EquipemntType) throws Exception 
	{
	   Thread.sleep(4000);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentConfPF.getEquipmentTypeDropdown(), "EquipmentType", EquipemntType,logger);
	}
	
	public void enterEquipemntName(String  EquipemntName) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentConfPF.getequipment_nameTextBox(), "EquipmentName", EquipemntName,logger);
	}
	
	public void selectFalutDetection(String  FalutDetection) throws Exception 
	{
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentConfPF.getFault_DetectionDropdown(), "FalutDetection", FalutDetection,logger);
	}
	
	public void enterEquipemntSuffix(String  EquipemntSuffix) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentConfPF.getsuffixTextBox(), "EquipmentSuffix", EquipemntSuffix,logger);
	}
	
	public void enterEquipemntMaxPower(String  MaxPower) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentConfPF.getMax_PowerTextBox(), "MaxPower", MaxPower,logger);
	}
	
	public void selectMeters(String  Meters) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentConfPF.getMetersDropdown(), "Meters", Meters,logger);
	}
	
	public void enterEquipmentSearchBox(String  Searchparameter) throws Exception 
	{   Thread.sleep(7000);
		//System.out.println("before seaechbox");
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentConfPF.getEquipment_Searchbox(), "equipment", Searchparameter,logger);
		//System.out.println("after seaechbox");
	}
	
	public void clickEquipementAddBtn() throws Exception{
		Thread.sleep(2000);
		MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentConfPF.getAdd_Equipment_Btn(), "Add Equipment button",logger);
	}
	
	public void clickEquipementUpdateBtn() throws Exception{
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentConfPF.getUpdate_Equipment_Btn(), "Update Equipment button",logger);
	}

	public void clickEquipementClearBtn() throws Exception{
		Thread.sleep(2000);
		MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentConfPF.getClear_Equipment_Btn(), "Clear Equipment button",logger);
	}
	
	public void clickEquipementDeleteBtn() throws Exception{
		Thread.sleep(2000);
		MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentConfPF.getDelete_Equipment_Btn(), "Delete Equipment button",logger);
	}
	
	public void clickDeleteConfirmEquipemntBtn() throws Exception{
		MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentConfPF.getDeleteEquipment_Confirm(), "Delete Equipment button",logger);
	}
	

	public void verifyEquipementPresent(String Equipment) throws Exception{
		
			List<WebElement> elements=null;
			elements = EquipmentConfPF.checkEquipemtnPresent();
			if(elements.size() >0){
				elements.get(0).click();
				logger.log(LogStatus.PASS, "Equipement:= " +Equipment+" is created succesfully and is present in equipement grid");  
			}
			else{
				logger.log(LogStatus.FAIL, "Equipement:= " +Equipment+" is not created succesfully");   
			}
		
	}
	
	public void verifyUpdatedEquipementPresent(String Equipment) throws Exception{
		
			List<WebElement> elements=null;
			elements = EquipmentConfPF.checkEquipemtnPresent();
			if(elements.size() >0){
				elements.get(0).click();
				logger.log(LogStatus.PASS, "Equipement:= " +Equipment+" is updated succesfully and is present in equipement grid");  
			}
			else{
				logger.log(LogStatus.FAIL, "Equipement:= " +Equipment+" is not updated succesfully");   
			}
		
	}
	
	public void verifyEquipementNotPresent(String Equipment) throws Exception{
		
			List<WebElement> elements=null;
			elements = EquipmentConfPF.checkEquipemtnPresent();
			if(elements.size() >0){
				elements.get(0).click();
				logger.log(LogStatus.FAIL, "Equipement:= "+Equipment+ " is not deleted from equipement grid");  
			}
			else{
				logger.log(LogStatus.PASS, "Equipement:= "+Equipment+ " is deleted from equipement grid");   
			}
	}
	
	
	public void verifyEquipementPresentForNextAction(String Equipment) throws Exception{
		
			List<WebElement> elements=null;
			elements = EquipmentConfPF.checkEquipemtnPresent();
			if(elements.size() >0){
				elements.get(0).click();
				logger.log(LogStatus.PASS, "Equipement:= " +Equipment+"  is present in equipement grid");  
			}
			else{
				logger.log(LogStatus.FAIL, "Equipement:= " +Equipment+" is not present in equipement grid");   
			}
		
	}
	
	public void checkAndClickUpdateBtn() throws Exception{
		if((EquipmentConfPF.getUpdate_Equipment_Btn().isEnabled()) && (EquipmentConfPF.getUpdate_Equipment_Btn().isDisplayed())){
			Thread.sleep(3000);
			EquipmentConfPF.getUpdate_Equipment_Btn().click();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
		}else{
			System.out.println("clicked on update btn");
		}
	}
	public void checkEquipmentFieldsClearOrNot(String Equipment) throws Exception{
		
		//element = EquipmentConfPF.getPortfolioDropdown();
		//MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"Portfolio");
		element = EquipmentConfPF.getLocationDropdown();
		MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"Location",logger);
		element = EquipmentConfPF.getBuildingDropdown();
		MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"Building",logger);
		element = EquipmentConfPF.getEquipmentCategoryDropdown();
		MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"EquipmentCategory",logger);
		element = EquipmentConfPF.getEquipmentTypeDropdown();
		MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"EquipmentType",logger);
		element = EquipmentConfPF.getequipment_nameTextBox();
		MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element,"Equipment name",logger);
		element = EquipmentConfPF.getFault_DetectionDropdown();
		MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"Fault Detection",logger);
		logger.log(LogStatus.PASS, "Equipement:= "+Equipment+ " all values are cleared sucesfully");  
		
	}
	
	public void createEquipment() throws Exception
	{
		
			
			String Equipmentname=MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
			orgobject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..EquipmentConfiguration.EquipmentConfigurationURL"));
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			selectPortfolio(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
			selectLocation(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Location"));
			selectBuilding(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Building"));
			selectEquipemntCategory(Equipmentdatalist_data.get(1));
			selectEquipemntType(Equipmentdatalist_data.get(2));
			enterEquipemntName(Equipmentname);
			WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Equipment",Equipmentname);
			selectFalutDetection(Equipmentdatalist_data.get(3));
			clickEquipementAddBtn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			enterEquipmentSearchBox(Equipmentname);
			verifyEquipementPresent(Equipmentname);
			
		 
	}
	
	public void clearEquipment() throws Exception
	{
		
			orgobject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..EquipmentConfiguration.EquipmentConfigurationURL"));
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			enterEquipmentSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
			verifyEquipementPresentForNextAction(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			clickEquipementClearBtn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			checkEquipmentFieldsClearOrNot(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
		
	}
	
	public void updateEquipment() throws Exception
	{
		
			String Equipmentname = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
			orgobject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..EquipmentConfiguration.EquipmentConfigurationURL"));
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			enterEquipmentSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
			verifyEquipementPresentForNextAction(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
			enterEquipemntName(Equipmentname);
			WriteJsonFile.writeJSONFileDynamic(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "Equipment",
					Equipmentname);
			clickEquipementUpdateBtn();
			checkAndClickUpdateBtn(); //
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			enterEquipmentSearchBox(Equipmentname);
			verifyUpdatedEquipementPresent(Equipmentname);
	
	}

	public void deleteEquipment() throws Exception
	{
		
			orgobject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..EquipmentConfiguration.EquipmentConfigurationURL"));
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			enterEquipmentSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
			verifyEquipementPresentForNextAction(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			clickEquipementDeleteBtn();
			clickDeleteConfirmEquipemntBtn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("EquipmentConfigurationpage");
			enterEquipmentSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
			verifyEquipementNotPresent(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Equipment"));
		

	}
}
