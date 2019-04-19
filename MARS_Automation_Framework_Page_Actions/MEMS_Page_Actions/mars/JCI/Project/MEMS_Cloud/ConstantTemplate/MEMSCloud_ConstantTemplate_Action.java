package mars.JCI.Project.MEMS_Cloud.ConstantTemplate;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.ConstantTemplate.MEMSCloud_ConstantTemplate_Page_Factory;
import mars.JCI.Project.MEMSCloud.EquipmentConfiguration.MEMSCloud_EquipmentConfiguration_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_ConstantTemplate_Action {

                public static WebDriver driver;
                /** The ExtentTest logger. */

                private static ExtentTest logger;

                public static MEMSCloud_ConstantTemplate_Page_Factory constantTempPF = null;

                public static MEMSCloud_Orgnization_Action orgObject = null;
                
                

                private WebElement element;

                public String configFile = BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";

                public MEMSCloud_ConstantTemplate_Action(WebDriver driver, ExtentTest logger) {
                                this.driver = driver;
                                this.logger = logger;
                                orgObject = new MEMSCloud_Orgnization_Action(driver, logger);
                                constantTempPF = new MEMSCloud_ConstantTemplate_Page_Factory(driver, logger);
                }

                public void selectTemplateCategory(String equipmentCategory) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(constantTempPF.getEquipmentCategory(),
                                                                "EquipmentCategory", equipmentCategory,logger);
                }

                public void enterConstantTemplate(String templateName) throws Exception {
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(constantTempPF.getConstantTemplate(), "TemplateName",
                                                                templateName,logger);

                }

                public void clickTemplateClearBtn() throws Exception {
                                Thread.sleep(2000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(constantTempPF.getClear_Template_Btn(), "Clear Template Button",logger);
                }

                public void clickTemplateAddBtn() throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(constantTempPF.getAdd_Template_Btn(), "Add Template Button",logger);
                }

                public void enterTemplateSearchBox(String templateName) throws Exception {
                                Thread.sleep(3000);
                                MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(constantTempPF.get_Template_SearchBox(), "Template",
                                                                templateName,logger);
                }

                public void clickTemplateUpdateBtn() throws Exception {
                                Thread.sleep(5000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(constantTempPF.getUpdate_Template_Btn(), "Update Template Button",logger);
                }

                public void clickTemplateDeleteBtn() throws Exception {
                                Thread.sleep(5000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(constantTempPF.getDelete_Template_Btn(), "Delete Template Button",logger);

                }

                public void clickTemplateDeleteConfirmBtn() throws Exception {
                                Thread.sleep(5000);
                                MEMSCloud_Orgnization_Action.clickWithLogger(constantTempPF.getDelete_Template_Confirm_Btn(),
                                                                "Confirm Delete Template Button",logger);
                }

                public void clickAndCheckUpdateBtn() throws Exception {
                                if ((constantTempPF.getUpdate_Template_Btn().isEnabled())
                                                                && (constantTempPF.getUpdate_Template_Btn().isDisplayed())) {
                                                constantTempPF.getUpdate_Template_Btn().click();
                                } else {

                                                System.out.println("clicked on update btn");
                                }
                }

                public void checkTemplateFieldClearorNot(String templateName) throws Exception{
                               
                                                element = constantTempPF.getEquipmentCategory();
                                                MEMSCloud_Orgnization_Action.checkDropdownBlankOrNot(element, "Equipment type",logger);
                                                element = constantTempPF.getConstantTemplate();
                                                MEMSCloud_Orgnization_Action.checkBlankTextboxWithLogger(element, "Template Name",logger);
                                                logger.log(LogStatus.PASS, "Template:= " + templateName + " all values are cleared sucesfully");
                                
                }
                
                public void selectCustomTag(String customTagName) throws Exception
                {
                                Thread.sleep(5000);
                                MEMSCloud_Orgnization_Action.selectDropDownWithLogger(constantTempPF.getCustom_Tag_Select(),"Select Custom Tag", customTagName,logger);
                }
                

                public void createTemplate() throws Exception {
                                
                                                String templateName = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                                selectTemplateCategory(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.EquiptmentCategory"));
                                                enterConstantTemplate(templateName);
                                                WriteJsonFile.writeJSONFileDynamic(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "TemplateName",
                                                                                templateName);
                                                clickTemplateAddBtn();
                                                enterTemplateSearchBox(templateName);
                                                MEMSCloud_Orgnization_Action.checkElementPresent(templateName, constantTempPF.checkTemplatePresent(),
                                                                                "Template");

                                

                }

                public void updateTemplate() throws Exception {
                                
                                                String templateName = MEMSCloud_Orgnization_Action.generateRandomalphabets(5);
                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                                enterTemplateSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName"));
                                                MEMSCloud_Orgnization_Action.checkElementPresent((ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName")),
                                                                                constantTempPF.checkTemplatePresent(), "Updated");
                                                enterConstantTemplate(templateName);
                                                WriteJsonFile.writeJSONFileDynamic(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "TemplateName",
                                                                                templateName);
                                                clickTemplateUpdateBtn();
                                                clickAndCheckUpdateBtn();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                                enterTemplateSearchBox(templateName);
                                                MEMSCloud_Orgnization_Action.checkElementPresent(templateName, constantTempPF.checkTemplatePresent(),
                                                                                "Template");
                                
                }

                public void clearTemplate() throws Exception {
                                
                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                                enterTemplateSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName"));
                                                MEMSCloud_Orgnization_Action.checkElementPresent((ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName")),
                                                                                constantTempPF.checkTemplatePresent(), "Updated");
                                                clickTemplateClearBtn();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                                checkTemplateFieldClearorNot(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName"));

                                

                }

                public void deleteTemplate() throws Exception {
                                
                                                orgObject.correctLogin_Admin_WithoutFacility();
                                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                                enterTemplateSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName"));
                                                MEMSCloud_Orgnization_Action.checkElementPresent((ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName")),
                                                                                constantTempPF.checkTemplatePresent(), "Updated");
                                                clickTemplateDeleteBtn();
                                                clickTemplateDeleteConfirmBtn();
                                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                                enterTemplateSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName"));

                                                MEMSCloud_Orgnization_Action.checkElementNotPresent(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName"),
                                                                                constantTempPF.checkTemplatePresent(), "Template");

                                

                }
                
                public void customTemplate() throws Exception
                {
                                
                                orgObject.correctLogin_Admin_WithoutFacility();
                                MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
                                                                "$..ConstantTemplate.ConstantTemplateURL"));
                                MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("constanttemplatepage");
                                selectCustomTag(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),"$..ConstantTemplate.Customtag"));
                                
                                enterTemplateSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName"));
                                MEMSCloud_Orgnization_Action.checkElementPresent((ReadJsonFile.readJsonFileDynamic_firstentry(
                                                                ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..TemplateName")), constantTempPF.checkTemplatePresent(),
                                                                "Template");
                }
                                
                                         
}
