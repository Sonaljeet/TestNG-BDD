package mars.JCI.Project.MEMS_Cloud.SubRules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.ConstantTemplate.MEMSCloud_ConstantTemplate_Page_Factory;
import mars.JCI.Project.MEMSCloud.SubRules.MEMSCloud_SubRules_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_SubRules_Action {

	public static WebDriver driver;
	/** The ExtentTest logger. */

	private static ExtentTest logger;

	public static MEMSCloud_SubRules_Page_Factory subRulesPF = null;

	public static MEMSCloud_Orgnization_Action orgObject = null;

	private WebElement element;

	public String configFile = BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";

	public MEMSCloud_SubRules_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		orgObject = new MEMSCloud_Orgnization_Action(driver, logger);
		subRulesPF = new MEMSCloud_SubRules_Page_Factory(driver, logger);
	}

	public void enterSubRulesTab() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getSubRules_Btn(), "Sub Rules Tab",logger);
		Thread.sleep(1000);
	}

	public void enterEquationName(String equationName) throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(subRulesPF.getEquationName(), "Equation Name",
				equationName,logger);

	}

	public void enterBriefEquationDescription(String briefEquationDescription) throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(subRulesPF.getBriefEquationDescription(),
				"Brief Description", briefEquationDescription,logger);
	}

	public void selectEquipmentCategory(String equipmentCategory) throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(subRulesPF.getEquipmentCategory(), "Equipment Category",
				equipmentCategory,logger);
	}

	public void selectVersion(String versionName) throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(subRulesPF.getVersion(), "Version", versionName,logger);
	}

	public void selectGreaterThanEqualSymbol() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getGreaterThanEqualSymbol(),
				"Greater than equal to button",logger);

	}

	public void enterConstantValueField(String constantValues) throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(subRulesPF.getConstantValueField(),
				"Constant Value Field", constantValues,logger);
	}

	public void ConstantValueEnter_Btn() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getConstantValueEnter_Btn(),
				"Constant Value Enter Button",logger);

	}

	public void addSubRule_Btn() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getaddSubRule_Btn(), "Add SubRules",logger);
		Thread.sleep(3000);
	}

	public void enterSearchSubRule_Field(String equationName) throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(subRulesPF.getSearchSubRule_Field(),
				"Sub Rule Search Field", equationName,logger);
	}

	public void updateSubRule_Btn() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getUpdateSubRule_Btn(), "Update SubRules",logger);

	}

	public void deleteSubRule_Btn() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getDeleteSubRule_Btn(), "Delete SubRules",logger);
	}

	public void deleteSubRuleConfirm_Btn() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getConfirmDelete_Btn(), "Confirm Delete SubRules",logger);
	}

	public void clearSubRules_Btn() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getClearSubRule_Btn(), "Clear SubRules",logger);
	}

	public void deleteEquationSubRules_Btn() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getDeleteEquation(), "Delete Equation",logger);
		Thread.sleep(1000);
	}

	public void checkEquationFiledClearOrNot(String equationName) throws Exception {
		
			element = subRulesPF.getEquationStatement();
			MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Equation Statement",logger);
			logger.log(LogStatus.PASS, "SubRules:= " + equationName + " equationStatement are cleared sucesfully");
		
	}

	public void checkSubRulesFieldClearOrNot(String equationName) throws Exception {
		
			element = subRulesPF.getEquationName();
			MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Equation Name",logger);
			element = subRulesPF.getBriefEquationDescription();
			MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Breif Equation Description",logger);
			element = subRulesPF.getEquipmentCategory();
			MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Equipment category",logger);
			element = subRulesPF.getVersion();
			MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Version",logger);
			element = subRulesPF.getEquationStatement();
			MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Equation Statement",logger);
			element = subRulesPF.getConstantValueField();
			MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Constant value field",logger);
			logger.log(LogStatus.PASS, "SubRules:= " + equationName + " all values are cleared sucesfully");
		
	}

	public void selectCustomTag(String customTag) throws Exception {
		Thread.sleep(2000);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(subRulesPF.getCustomTag(), "Custom Tag", customTag,logger);
	}

	public void entertestFault_Btn() throws Exception {
		Thread.sleep(2000);
		MEMSCloud_Orgnization_Action.clickWithLogger(subRulesPF.getTestFault_Btn(), "Test Fault",logger);
	}

	public void enterahuStaticField(String value) throws Exception {
		Thread.sleep(2000);
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(subRulesPF.getAhuStaticField(),
				"Ahu Static Field Value", value,logger);
	}

	public void checknclickupdateSubRule_Btn() throws Exception {
		Thread.sleep(3000);
		if (subRulesPF.getUpdateSubRule_Btn().isDisplayed() && subRulesPF.getUpdateSubRule_Btn().isEnabled()) {
			subRulesPF.getUpdateSubRule_Btn().click();
		} else {
			System.out.println("clicked on update button");
		}

	}

	public void createSubRules() throws Exception {
		
			String equationName = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
			orgObject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ConstantTemplate.ConstantTemplateURL"));
			enterSubRulesTab();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			WriteJsonFile.writeJSONFileDynamic(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "EquationName",
					equationName);
			enterEquationName(equationName);
			enterBriefEquationDescription(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..Subrules.BreifEquationDescription"));
			selectEquipmentCategory(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..Subrules.EquipmentCategory"));
			selectVersion(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..Subrules.Version"));
			MEMSCloud_Orgnization_Action.dragAndDrop(subRulesPF.getAttributeFromTable(),
					subRulesPF.getEquationStatement(),
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..Subrules.AttributeValues"));
			selectGreaterThanEqualSymbol();
			enterConstantValueField(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..Subrules.ConstantValues"));
			ConstantValueEnter_Btn();
			addSubRule_Btn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(equationName);
			MEMSCloud_Orgnization_Action.checkElementPresent(equationName, subRulesPF.checkSubRulePresent(),
					"Sub Rules");

		
	}

	public void updateSubRules() throws Exception {
		
			String equationName = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
			orgObject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ConstantTemplate.ConstantTemplateURL"));
			enterSubRulesTab();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));
			MEMSCloud_Orgnization_Action.checkElementPresent(equationName, subRulesPF.checkSubRulePresent(),
					"Sub Rules");
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterEquationName(equationName);
			WriteJsonFile.writeJSONFileDynamic(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "EquationName",
					equationName);
			updateSubRule_Btn();
			checknclickupdateSubRule_Btn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(equationName);
			MEMSCloud_Orgnization_Action.checkElementPresent(equationName, subRulesPF.checkSubRulePresent(),
					"Sub Rules");

		
	}

	public void deleteSubRules() throws Exception {
		
			String equationName = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
			orgObject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ConstantTemplate.ConstantTemplateURL"));
			enterSubRulesTab();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));
			MEMSCloud_Orgnization_Action.checkElementPresent(equationName, subRulesPF.checkSubRulePresent(),
					"Sub Rules");
			deleteSubRule_Btn();
			deleteSubRuleConfirm_Btn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));
			MEMSCloud_Orgnization_Action.checkElementNotPresent(equationName, subRulesPF.checkSubRulePresent(),
					"Sub Rules");

		
	}

	public void clearSubRules() throws Exception {
		
			orgObject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ConstantTemplate.ConstantTemplateURL"));
			enterSubRulesTab();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));
			MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
					subRulesPF.checkSubRulePresent(), "Sub Rules");
			clearSubRules_Btn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			checkSubRulesFieldClearOrNot(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));

		
	}

	public void customSubRules() throws Exception {
		
			orgObject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ConstantTemplate.ConstantTemplateURL"));
			enterSubRulesTab();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			selectCustomTag(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..Subrules.Customtag"));
			enterSearchSubRule_Field(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));
			MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
					subRulesPF.checkSubRulePresent(), "Sub Rules");

		
	}

	public void deleteEquationStatementSubRules() throws Exception {
	
			orgObject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ConstantTemplate.ConstantTemplateURL"));
			enterSubRulesTab();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));
			MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
					subRulesPF.checkSubRulePresent(), "Sub Rules");
			deleteEquationSubRules_Btn();
			deleteEquationSubRules_Btn();
			deleteEquationSubRules_Btn();
			checkEquationFiledClearOrNot(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));

		
	}

	public void testFaultSubRules() throws Exception {
		
			orgObject.correctLogin_Admin_WithoutFacility();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ConstantTemplate.ConstantTemplateURL"));
			enterSubRulesTab();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
			enterSearchSubRule_Field(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"));
			MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
					subRulesPF.checkSubRulePresent(), "Sub Rules");
			enterahuStaticField(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..Subrules.StaticFieldValue"));
			entertestFault_Btn();
			MEMSCloud_Orgnization_Action.alertWindowHandle();
		
	}

}
