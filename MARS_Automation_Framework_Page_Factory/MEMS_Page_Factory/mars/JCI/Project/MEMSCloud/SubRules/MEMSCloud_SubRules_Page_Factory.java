package mars.JCI.Project.MEMSCloud.SubRules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class MEMSCloud_SubRules_Page_Factory {

	/** The WebDriver driver. */
	private static WebDriver driver;

	/** The ExtentTest logger. */
	private static ExtentTest logger;
	public String configFile = BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";

	public MEMSCloud_SubRules_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='setupscreen ng-scope']//a[contains(text(),'Sub rules')]")
	
	private WebElement subRules_Btn;

	public WebElement getSubRules_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(subRules_Btn,driver, logger) == true) {
			return subRules_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//input[@name='equation_name']")
	private WebElement equationName;

	public WebElement getEquationName() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(equationName,driver, logger) == true) {
			return equationName;
		} else
			return null;
	}

	@FindBy(xpath = "//textarea[@name='equatn_descri']")
	private WebElement briefEquationDescription;

	public WebElement getBriefEquationDescription() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(briefEquationDescription,driver, logger) == true) {
			return briefEquationDescription;
		} else
			return null;
	}

	@FindBy(xpath = "//select[@name='equipmentCategory']")
	private WebElement equipmentCategory;

	public WebElement getEquipmentCategory() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentCategory,driver, logger) == true) {
			return equipmentCategory;
		} else
			return null;
	}

	@FindBy(xpath = "//select[@name='version']")
	private WebElement version;

	public WebElement getVersion() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(version,driver, logger) == true) {
			return version;
		} else
			return null;
	}

	@FindBy(xpath = "//div[@class='form-control no-border no-border-space']//button[text()='<=']")
	private WebElement greaterThanEqualSymbol;

	public WebElement getGreaterThanEqualSymbol() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(greaterThanEqualSymbol,driver, logger) == true) {
			return greaterThanEqualSymbol;
		} else
			return null;
	}

	@FindBy(xpath = "//span[@class='inline-block']//input[@class='form-control num-ip']")
	private WebElement constantValueField;

	public WebElement getConstantValueField() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(constantValueField,driver, logger) == true) {
			return constantValueField;
		} else
			return null;
	}

	@FindBy(xpath = "//button[text()='NOT']//following-sibling::button[text()='ENTER']")
	private WebElement constantValueEnter_Btn;

	public WebElement getConstantValueEnter_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(constantValueEnter_Btn,driver, logger) == true) {
			return constantValueEnter_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//form[@name='subRulesForm']//button[text()='Add']")
	private WebElement addSubRule_Btn;

	public WebElement getaddSubRule_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(addSubRule_Btn,driver, logger) == true) {
			return addSubRule_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//form[@name='subRulesForm']//button[text()='Update']")
	private WebElement updateSubRule_Btn;

	public WebElement getUpdateSubRule_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(updateSubRule_Btn,driver, logger) == true) {
			return updateSubRule_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//form[@name='subRulesForm']//button[text()='Delete']")
	private WebElement deleteSubRule_Btn;

	public WebElement getDeleteSubRule_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(deleteSubRule_Btn,driver, logger) == true) {
			return deleteSubRule_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//input[@name='equipmentName']")
	private WebElement searchSubRule_Field;

	public WebElement getSearchSubRule_Field() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(searchSubRule_Field,driver,logger) == true) {
			return searchSubRule_Field;
		} else
			return null;
	}

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement clearSubRule_Btn;

	public WebElement getClearSubRule_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(clearSubRule_Btn,driver, logger) == true) {
			return clearSubRule_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//select[@name='tagsData']")
	private WebElement customTag;

	public WebElement getCustomTag() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(customTag,driver, logger) == true) {
			return customTag;
		} else
			return null;
	}

	@FindBy(xpath = "//button[@class='btn btn-primary margin-bottom-5 ng-scope'][text()='Delete equation']")
	private WebElement deleteEquation;

	public WebElement getDeleteEquation() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(deleteEquation,driver, logger) == true) {
			return deleteEquation;
		} else
			return null;
	}

	@FindBy(xpath = "//textarea[@name='equatn_statement']")
	private WebElement equationStatement;

	public WebElement getEquationStatement() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(equationStatement,driver, logger) == true) {
			return equationStatement;
		} else
			return null;
	}

	@FindBy(xpath = "//form[@name='subRulesForm']//button[text()='Yes']")
	private WebElement confirmDelete_Btn;

	public WebElement getConfirmDelete_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(confirmDelete_Btn,driver, logger) == true) {
			return confirmDelete_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//button[text()='Test fault']")
	private WebElement testFault_Btn;

	public WebElement getTestFault_Btn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(testFault_Btn,driver, logger) == true) {
			return testFault_Btn;
		} else
			return null;
	}

	@FindBy(xpath = "//input[@name='number']")
	private WebElement ahuStaticField;

	public WebElement getAhuStaticField() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(ahuStaticField,driver,logger) == true) {
			return ahuStaticField;
		} else
			return null;
	}

	private WebElement attributeFromTable = null;

	public WebElement getAttributeFromTable() throws InterruptedException {
		String attribute_From_Table = "$..Subrules.AttributeValues";

		Thread.sleep(3000);
		String attribute_From_Table_Value = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), attribute_From_Table);
		attributeFromTable = driver.findElement(
				By.xpath("//table[@id='tblEquipmentAttributes']//td[text()='" + attribute_From_Table_Value + "']"));
		return attributeFromTable;

	}

	public List<WebElement> subRules_inGrid = null;

	public List<WebElement> checkSubRulePresent() throws Exception {
		String rule_name_JsonPath = "$..EquationName";
		Thread.sleep(3000);
		String ruleName = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), rule_name_JsonPath);
		subRules_inGrid = driver.findElements(By.xpath("//div[text()='" + ruleName + "']"));
		return subRules_inGrid;

	}

}
