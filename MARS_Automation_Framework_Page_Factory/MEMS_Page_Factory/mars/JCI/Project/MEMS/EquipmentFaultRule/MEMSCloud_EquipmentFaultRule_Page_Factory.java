package mars.JCI.Project.MEMS.EquipmentFaultRule;

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

public class MEMSCloud_EquipmentFaultRule_Page_Factory {
                
                
                /** The WebDriver driver. */
                private static WebDriver driver;
                
                /** The ExtentTest logger. */
                private static ExtentTest logger;
                public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
                
                /**
                * Instantiates a new MEMS Constant Template page factory.
                *
                * @param driver the driver
                * @param logger the logger
                */
                public MEMSCloud_EquipmentFaultRule_Page_Factory(WebDriver driver, ExtentTest logger) {
                                this.driver = driver;
                                this.logger = logger;
                                PageFactory.initElements(driver, this);
                }
                
                
                     
                
                @FindBy(xpath = "//div[@class='setupscreen ng-scope']//a[contains(text(),'Equipment fault rules')]")
                private WebElement equipmentFaultRule_Tab;

                public WebElement getEquipmentFaultRule_Tab() throws Exception{
                                if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentFaultRule_Tab,driver, logger) == true) {
                                                return equipmentFaultRule_Tab;
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
                
                
                @FindBy(xpath ="//textarea[@name='equatn_descri']")
                private WebElement briefEquationDescription;

                public WebElement getBriefEquationDescription() throws Exception{
                                if (commonFunctions.WebElementCommon.waitForElementPresent(briefEquationDescription,driver, logger) == true) {
                                                return briefEquationDescription;
                                } else
                                                return null;
                }
                
                @FindBy(xpath = "//select[@name='equipment_type']")
                private WebElement equipmentCategory;

                public WebElement getEquipmentCategory() throws Exception{
                                if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentCategory,driver, logger) == true) {
                                                return equipmentCategory;
                                } else
                                                return null;
                }
                
                
                @FindBy(xpath = "//div[@class='multiselect-parent btn-group dropdown-multiselect']/button")
                private WebElement equipmentType_dropdown;

                public WebElement getEquipmentType() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentType_dropdown,driver, logger) == true) {
                                                return equipmentType_dropdown;
                                } else
                                                return null;
                }
                
                private WebElement equipmentType_Value_Select = null;

                public WebElement getEquipmentType_Value_Select() throws InterruptedException {
                                String equipmentType_Value = "$..EquipmentFaultRule.EquipmentType";

                                Thread.sleep(3000);
                                String equipment_Type = ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), equipmentType_Value);
                                equipmentType_Value_Select = driver.findElement(
                                                                By.xpath("//span[text()=' "+equipment_Type+"']"));
                                return equipmentType_Value_Select;

                }
                
                @FindBy(xpath = "//select[@id='fault_category']")
                private WebElement faultCategory;

                public WebElement getFaultCategory() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(faultCategory,driver, logger) == true) {
                                                return faultCategory;
                                } else
                                                return null;
                }
                
                
                @FindBy(xpath = "//select[@name='parameter_value']")
                private WebElement parameterValue;

                public WebElement getParameterValue() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(parameterValue,driver, logger) == true) {
                                                return parameterValue;
                                } else
                                                return null;
                }
                
                @FindBy(xpath = "//select[@id='fault_detection']")
                private WebElement faultDetection;

                public WebElement getFaultDetection() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(faultDetection,driver, logger) == true) {
                                                return faultDetection;
                                } else
                                                return null;
                }
                
                
                @FindBy(xpath = "//select[@name='equipment']")
                private WebElement version;

                public WebElement getVersion() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(version,driver, logger) == true) {
                                                return version;
                                } else
                                                return null;
                }
                
                @FindBy(xpath ="//select[@name='rule_category']")
                private WebElement ruleCategory;

                public WebElement getRuleCategory() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(ruleCategory,driver, logger) == true) {
                                                return ruleCategory;
                                } else
                                                return null;
                }

                
                @FindBy(xpath ="//input[@name='time_delay']")
                private WebElement timeDelay;

                public WebElement getTimeDelay() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(timeDelay,driver, logger) == true) {
                                                return timeDelay;
                                } else
                                                return null;
                }

                
                @FindBy(xpath ="//select[@name='fault_priority']")
                private WebElement faultPriority;

                public WebElement getFaultPriority() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(faultPriority,driver, logger) == true) {
                                                return faultPriority;
                                } else
                                                return null;
                }
                
                
                @FindBy(xpath ="//textarea[@name='equatn_statement']")
                private WebElement equationStatement;

                public WebElement getEquationStatement() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(equationStatement,driver, logger) == true) {
                                                return equationStatement;
                                } else
                                                return null;
                }
                
                 
                
                @FindBy(xpath = "//div[@class='form-control no-border no-border-space']//button[text()='<=']")
                private WebElement greaterThanEqualSymbol;

                public WebElement getGreaterThanEqualSymbol() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(greaterThanEqualSymbol,driver, logger) == true) {
                                                return greaterThanEqualSymbol;
                                } else
                                                return null;
                }
                
                @FindBy(xpath = "//span[@class='inline-block']//input[@class='form-control num-ip']")
                private WebElement constantValueField;

                public WebElement getConstantValueField() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(constantValueField,driver, logger) == true) {
                                                return constantValueField;
                                } else
                                                return null;
                }

                @FindBy(xpath = "//button[text()='NOT']//following-sibling::button[text()='ENTER']")
                private WebElement constantValueEnter_Btn;

                public WebElement getConstantValueEnter_Btn() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(constantValueEnter_Btn,driver, logger) == true) {
                                                return constantValueEnter_Btn;
                                } else
                                                return null;
                }

                
                private WebElement attributeFromTable = null;

                public WebElement getAttributeFromTable() throws InterruptedException {
                                String attribute_From_Table = "$..EquipmentFaultRule.AttributeValues";

                                Thread.sleep(3000);
                                String attribute_From_Table_Value = ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), attribute_From_Table);
                                attributeFromTable = driver.findElement(
                                                                By.xpath("//table[@id='tblEquipmentAttributes']//td[text()='" + attribute_From_Table_Value + "']"));
                                return attributeFromTable;

                }
                
                
                @FindBy(xpath = "//button[text()='Add']")
                private WebElement addEquipmentFaultRule_Btn;

                public WebElement getaddEquipmentFaultRule_Btn() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(addEquipmentFaultRule_Btn,driver, logger) == true) {
                                                return addEquipmentFaultRule_Btn;
                                } else
                                                return null;
                }
                
                
                @FindBy(xpath = "//select[@name='equipmentCategory']")
                private WebElement equipmentCategory_Search;

                public WebElement getEquipmentCategory_Search() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentCategory_Search,driver,logger) == true) {
                                                return equipmentCategory_Search;
                                } else
                                                return null;
                }
                
                
                
                @FindBy(xpath = "//select[@name='equipmentType']")
                private WebElement equipmentType_Search;

                public WebElement getEquipmentType_Search() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentType_Search,driver, logger) == true) {
                                                return equipmentType_Search;
                                } else
                                                return null;
                }
                
                @FindBy(xpath = "//select[@name='tagsData']")
                private WebElement customTag;

                public WebElement getCustomTag() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(customTag,driver, logger) == true) {
                                                return customTag;
                                } else
                                                return null;
                }
                
                @FindBy(xpath = "//input[@name='equipmentName']")
                private WebElement searchequipmentFaultRule;

                public WebElement getSearchEquipmentFaultRule_Field() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(searchequipmentFaultRule,driver, logger) == true) {
                                                return  searchequipmentFaultRule;
                                } else
                                                return null;
                }
                
                @FindBy(xpath = "//button[text()='Clear']")
                private WebElement clearequipmentFaultRule_Btn;

                public WebElement getClearEquipmentFaultRule_Btn() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(clearequipmentFaultRule_Btn,driver, logger) == true) {
                                                return clearequipmentFaultRule_Btn;
                                } else
                                                return null;
                }
                
                @FindBy(xpath = "//button[@class='btn btn-primary margin-bottom-5 ng-scope'][text()='Delete equation']")
                private WebElement deleteEquationEquipmentFaultRule_Btn;

                public WebElement getDeleteEquationEquipmentFaultRule_Btn() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(deleteEquationEquipmentFaultRule_Btn,driver, logger) == true) {
                                                return  deleteEquationEquipmentFaultRule_Btn;
                                } else
                                                return null;
                }
                
                
                @FindBy(xpath="//button[text()='Test fault']")
                private WebElement testFaultEquationEquipmentFaultRule_Btn;
                public WebElement getTestFaultEquationEquipmentFaultRule_Btn() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(testFaultEquationEquipmentFaultRule_Btn,driver,logger)==true) {
                                return testFaultEquationEquipmentFaultRule_Btn;
                }else
                                return null;
                }
                
                
                
                @FindBy(xpath = "//button[text()='Update']")
                private WebElement updateEquationEquipmentFaultRule_Btn;

                public WebElement getUpdateEquipmentFaultRule_Btn() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(updateEquationEquipmentFaultRule_Btn,driver, logger) == true) {
                                                return updateEquationEquipmentFaultRule_Btn;
                                } else
                                                return null;
                }
                
                
                @FindBy(xpath = "//button[text()='Delete']")
                private WebElement deleteEquipmentFaultRule_Btn;

                public WebElement getDeleteEquipmentFaultRule_Btn() throws Exception {
                                if (commonFunctions.WebElementCommon.waitForElementPresent(deleteEquipmentFaultRule_Btn,driver, logger) == true) {
                                                return  deleteEquipmentFaultRule_Btn;
                                } else
                                                return null;
                }
                
                
                
                public List<WebElement> EquipmentFaultRule_inGrid=null;
                public    List<WebElement> checkEquipmentFaultRulePresent() throws Exception
                {
                                String rule_name_JsonPath="$..EquationName";
                                Thread.sleep(3000);
                                String ruleName=ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),rule_name_JsonPath);
                                EquipmentFaultRule_inGrid=driver.findElements(By.xpath("//span[text()='"+ruleName+"']"));
                                return EquipmentFaultRule_inGrid;
                                
                }

                @FindBy(xpath="//input[@name='number']")
                private WebElement attributeValueField;
                public WebElement getAttributeValueField() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(attributeValueField,driver, logger)==true) {
                                return attributeValueField;
                }else
                                return null;
                }
                
                
                @FindBy(xpath="//a[text()='Fault list']")
                private WebElement faultListLink;
                public WebElement getFaultListLink() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(faultListLink,driver,logger)==true) {
                                return faultListLink;
                }else
                                return null;
                }
                
                
                @FindBy(xpath="(//div[@class='ngCell  col5 colt5']//a[@data-toggle='collapse'])[1]")

                private WebElement clickEdit;
                public WebElement getClickEdit() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(clickEdit,driver, logger)==true) {
                                return clickEdit;
                }else
                                return null;
                }
                
                
                @FindBy(xpath="//button[text()='Yes']")

                private WebElement deleteConfirmButton;
                public WebElement getDeleteConfirmButton() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(deleteConfirmButton,driver, logger)==true) {
                                return deleteConfirmButton;
                }else
                                return null;
                }
                      
                
                
 }