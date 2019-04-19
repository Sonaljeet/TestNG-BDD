
package mars.JCI.Project.MEMS_Cloud.EquipmentFaultRule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.MEMS.EquipmentFaultRule.MEMSCloud_EquipmentFaultRule_Page_Factory;
import mars.JCI.Project.MEMSCloud.SubRules.MEMSCloud_SubRules_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_EquipmentFaultRule_Action {

                public static WebDriver driver;
                /** The ExtentTest logger. */

                private static ExtentTest logger;

                public static MEMSCloud_EquipmentFaultRule_Page_Factory EquipmentFaultRulePF = null;

                public static MEMSCloud_Orgnization_Action orgObject = null;

                private WebElement element;

                public String configFile = BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";

                public MEMSCloud_EquipmentFaultRule_Action(WebDriver driver, ExtentTest logger) {
                                this.driver = driver;
                                this.logger = logger;
                                orgObject = new MEMSCloud_Orgnization_Action(driver, logger);
                                EquipmentFaultRulePF = new MEMSCloud_EquipmentFaultRule_Page_Factory(driver, logger);

                                /*
                                * try { desktopDriver= new MARSDesktopDriver(); } catch
                                * (IllegalStateException e) { // TODO Auto-generated catch block
                                * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
                                * catch block e.printStackTrace(); }
                                */
                }

                public void enterEquipmentFaultRuleTab() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getEquipmentFaultRule_Tab(),
                                                                "Equipment Fault Rule Tab Open",logger);

                }

                public void selectEquipmentCategory(String equipmentCategory) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getEquipmentCategory(),
                                                                "Equipment Category", equipmentCategory,logger);
                }

                public void selectEquipmentType() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getEquipmentType(), "Equipment Type",logger);
                                Thread.sleep(1000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getEquipmentType_Value_Select(),
                                                                "Equipment Type click",logger);
                }

                public void selectFaultCategory(String faultCategory) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getFaultCategory(), "Fault Category",
                                                                faultCategory,logger);
                }

                public void selectParameterValue(String parameterValue) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getParameterValue(),
                                                                "Parameter Value", parameterValue,logger);
                }

                public void selectFaultDetection(String faultDetection) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getFaultDetection(),
                                                                "Fault Detection", faultDetection,logger);
                }

                public void selectVersion(String version) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getVersion(), "Vesion", version,logger);
                }

                public void selectRuleCategory(String ruleCategory) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getRuleCategory(), "Rule Category",
                                                                ruleCategory,logger);
                }

                public void enterTimeDelay(String timeDelay) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentFaultRulePF.getTimeDelay(), "Time Delay",
                                                                timeDelay,logger);
                }

                public void enterEquationName(String equationName) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentFaultRulePF.getEquationName(), "Equation Name",
                                                                equationName,logger);
                }

                public void selectFaultPriority(String faultPriority) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getFaultPriority(), "Fault Priority",
                                                                faultPriority,logger);
                }

                public void enterBriefEquationDescription(String briefEquationDescription) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentFaultRulePF.getBriefEquationDescription(),
                                                                "Brief Equation Description", briefEquationDescription,logger);
                }

                public void enterEquationStatement(String elementName) throws Exception {
                                Thread.sleep(3000);

                                MEMSCloud_Orgnization_Action.dragAndDrop(EquipmentFaultRulePF.getAttributeFromTable(),
                                                                EquipmentFaultRulePF.getEquationStatement(), elementName);
                }

                public void selectGreaterThanEqualSymbol() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getGreaterThanEqualSymbol(),
                                                                "Greater than equal to button",logger);

                }

                public void enterConstantValueField(String constantValues) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentFaultRulePF.getConstantValueField(),
                                                                "Constant Value Field", constantValues,logger);
                }

                public void ConstantValueEnter_Btn() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getConstantValueEnter_Btn(),
                                                                "Constant Value Enter Button",logger);

                }

                public void addEquipmentFaultRule_Btn() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getaddEquipmentFaultRule_Btn(),
                                                                "Add Equipment Fault Rule",logger);
                                Thread.sleep(4000);

                }

                public void clickEditEquipmentFaultRule_Btn() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getClickEdit(),
                                                                "Equipment Fault Rule Edit Button",logger);

                }

                public void enterUpdatedEquationName(String equationName) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentFaultRulePF.getEquationName(),
                                                                "Updated Equation Name", equationName,logger);
                }

                public void clickUpdateButton() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getUpdateEquipmentFaultRule_Btn(),
                                                                "Update Equipment Fault Rule",logger);
                                Thread.sleep(3000);
                }

                public void checkAndClickUpdate_Btn() throws Exception {
                                Thread.sleep(3000);
                                if (EquipmentFaultRulePF.getUpdateEquipmentFaultRule_Btn().isDisplayed()
                                                                && EquipmentFaultRulePF.getUpdateEquipmentFaultRule_Btn().isEnabled()) {
                                                EquipmentFaultRulePF.getUpdateEquipmentFaultRule_Btn().click();
                                                Thread.sleep(3000);
                                } else {
                                                System.out.println("clicked on update button");
                                }
                }

                public void clickDeleteButton() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getDeleteEquipmentFaultRule_Btn(),
                                                                "Delete Equipment Fault Rule",logger);
                                Thread.sleep(3000);
                }

                public void clickDeleteConfirmButton() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getDeleteConfirmButton(),
                                                                "Confirm Delete Equipment Fault Rule",logger);

                }

                public void clickClearButton() throws Exception {
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getClearEquipmentFaultRule_Btn(),
                                                                "Clear Equipment Fault Rule",logger);
                                Thread.sleep(3000);
                }
                
                public void clickDeleteEquation_Btn() throws Exception
                {
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getDeleteEquationEquipmentFaultRule_Btn(), "Delete Equation Statement",logger);
                    Thread.sleep(3000);
                }
                
                public void checkEquationStatementClearOrNot() throws Exception
                {
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(EquipmentFaultRulePF.getEquationStatement(), "Equation Statement",logger);
                }
                
                
                public void enterAttributeValueField(String value) throws Exception
                {
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(EquipmentFaultRulePF.getAttributeValueField(),"Attribute value field", value,logger);
                }
                
                
                public void clickTestFault_Btn() throws Exception
                {
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getTestFaultEquationEquipmentFaultRule_Btn(),"Test Fault",logger);
                                Thread.sleep(3000);
                }

                public void searchEquipmentFaultRule(String equipmentCategory, String equipmentType, String SearchField)
                                                throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getFaultListLink(), "Fault List Link",logger);
                                Thread.sleep(1000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getEquipmentCategory_Search(),
                                                                "Equipment Category in Search", equipmentCategory,logger);
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(EquipmentFaultRulePF.getEquipmentType_Search(),
                                                                "Equipment Type in Search", equipmentType,logger);
                                Thread.sleep(1000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(
                                                                EquipmentFaultRulePF.getSearchEquipmentFaultRule_Field(), "Search Equipment Fault", SearchField,logger);
                }

                public void checkEquipmentDetailFieldClearOrNot() throws Exception {
                                Thread.sleep(3000);
                                
                                element=EquipmentFaultRulePF.getEquipmentCategory();
                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"Equipment Category",logger);
                                /*MEMSCloud_Orgnization_Action.clickWithLogger(EquipmentFaultRulePF.getEquipmentType(),"Equipment Type");
                                MEMSCloud_Orgnization_Action.checkCheckboxCheckedOrNot(EquipmentFaultRulePF.getEquipmentType_Value_Select(), "Equipment Type");*/
                                element=EquipmentFaultRulePF.getEquipmentType();
                                
                                MEMSCloud_Orgnization_Action.checkClearOrNotMultipleCheckbox(element,"Equipment Type");
                                element=EquipmentFaultRulePF.getFaultCategory();
                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Fault Category",logger);
                                element=EquipmentFaultRulePF.getParameterValue();
                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Parameter Value",logger);
                                element=EquipmentFaultRulePF.getFaultDetection();
                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Fault Detection",logger);
                                element=EquipmentFaultRulePF.getVersion();
                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Version",logger);
                                element=EquipmentFaultRulePF.getRuleCategory();
                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Rule Category",logger);
                                
                                element=EquipmentFaultRulePF.getTimeDelay();
                                MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Time Delay",logger);
                                element=EquipmentFaultRulePF.getEquationName();
                                MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element,"Equation Name",logger);
                                element=EquipmentFaultRulePF.getFaultPriority();
                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element,"Fault Priority",logger);
                                element=EquipmentFaultRulePF.getBriefEquationDescription();
                                MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element,"Brief Equation",logger);
                                element=EquipmentFaultRulePF.getEquationStatement();
                                MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element,"Eqaution Statement",logger);
                                element=EquipmentFaultRulePF.getConstantValueField();
                                MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Constant Value Field",logger);
                                
                }

                public void createEuipmentFaultRule() throws Exception {
                              
                                                String equationName = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                enterEquipmentFaultRuleTab();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                selectEquipmentCategory(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.EquipmentCategory"));
                                                selectEquipmentType();
                                                selectFaultCategory(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.FaultCategory"));

                                                selectParameterValue(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.ParameterValue"));
                                                selectFaultDetection(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.FaultDetection"));

                                                selectVersion(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.Version"));

                                                selectRuleCategory(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.RuleCategory"));

                                                enterTimeDelay(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.TimeDelay"));
                                                enterEquationName(equationName);
                                                WriteJsonFile.writeJSONFileDynamic(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "EquationName",
                                                                                equationName);
                                                selectFaultPriority(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.FaultyPriority"));

                                                enterBriefEquationDescription(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.BriefEquationDescription"));
                                                enterEquationStatement(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.AttributeValues"));
                                                selectGreaterThanEqualSymbol();
                                                enterConstantValueField(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..EquipmentFaultRule.ConstantFieldValue"));
                                                ConstantValueEnter_Btn();
                                                addEquipmentFaultRule_Btn();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                searchEquipmentFaultRule(
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                                equationName);
                                                MEMSCloud_Orgnization_Action.checkElementPresent(equationName,
                                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");

                                
                }

                public void updateEuipmentFaultRule() throws Exception {
                             
                                                String equationName = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);

                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                enterEquipmentFaultRuleTab();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                searchEquipmentFaultRule(
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
                                                                                                                "$..EquationName"));
                                                MEMSCloud_Orgnization_Action.checkElementPresent(equationName,
                                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");
                                                clickEditEquipmentFaultRule_Btn();
                                                enterUpdatedEquationName(equationName);
                                                clickUpdateButton();
                                                checkAndClickUpdate_Btn();
                                                WriteJsonFile.writeJSONFileDynamic(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "EquationName",
                                                                                equationName);
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                searchEquipmentFaultRule(
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
                                                                                                                "$..EquationName"));
                                                MEMSCloud_Orgnization_Action.checkElementPresent(equationName,
                                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");
                                
                }

                public void deleteEquipmentFaultRule() throws Exception {
                              
                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                enterEquipmentFaultRuleTab();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                searchEquipmentFaultRule(
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
                                                                                                                "$..EquationName"));
                                                MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
                                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");
                                                clickEditEquipmentFaultRule_Btn();
                                                clickDeleteButton();
                                                clickDeleteConfirmButton();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                searchEquipmentFaultRule(
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
                                                                                                                "$..EquationName"));

                                                MEMSCloud_Orgnization_Action.checkElementNotPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
                                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");

                               
                }

                public void clearEquipmentFaultRule() throws Exception {
                                
                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                enterEquipmentFaultRuleTab();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                searchEquipmentFaultRule(
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
                                                                                                                "$..EquationName"));
                                                MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
                                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");
                                                clickEditEquipmentFaultRule_Btn();
                                                clickClearButton();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                                checkEquipmentDetailFieldClearOrNot();
                                

                }
                
                public void deleteEquationStatement() throws Exception
                {
                              
                                orgObject.correctLogin_Admin_WithoutFacility();
                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                enterEquipmentFaultRuleTab();
                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                searchEquipmentFaultRule(
                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
                                                                                                "$..EquationName"));
                                MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");
                                clickEditEquipmentFaultRule_Btn();
                                clickDeleteEquation_Btn();
                                clickDeleteEquation_Btn();
                                clickDeleteEquation_Btn();
                                checkEquationStatementClearOrNot();
                                
                }
                
                public void testFaultEquipmentFaultRule() throws Exception
                {
                       
                                orgObject.correctLogin_Admin_WithoutFacility();
                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                enterEquipmentFaultRuleTab();
                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("equipmentfaultrule");
                                searchEquipmentFaultRule(
                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                "$..EquipmentFaultRule.EquipmentCategory"),
                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                                "$..EquipmentFaultRule.EquipmentType"),
                                                                ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),
                                                                                                "$..EquationName"));
                                MEMSCloud_Orgnization_Action.checkElementPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..EquationName"),
                                                                EquipmentFaultRulePF.checkEquipmentFaultRulePresent(), "Equipment Fault Rule");
                                clickEditEquipmentFaultRule_Btn();
                                enterAttributeValueField(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                "$..EquipmentFaultRule.AttributeValue"));
                                clickTestFault_Btn();
                                MEMSCloud_Orgnization_Action.alertWindowHandle();
                                
                }
                

}
