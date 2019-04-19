package mars.JCI.Project.MEMSCloud.ConstantTemplate;

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

public class MEMSCloud_ConstantTemplate_Page_Factory {
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
                public MEMSCloud_ConstantTemplate_Page_Factory(WebDriver driver, ExtentTest logger) {
                                this.driver = driver;
                                this.logger = logger;
                                PageFactory.initElements(driver, this);
                }
                
                @FindBy(xpath="//select[@name='equipmentCategory']")
                private WebElement equipmentCategory;
                public WebElement getEquipmentCategory() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentCategory,driver,logger)==true) {
                                return equipmentCategory;
                }else
                                return null;
                }

                @FindBy(xpath="//input[@name='templateName']")
                private WebElement constantTemplate;
                public WebElement getConstantTemplate()throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(constantTemplate,driver,logger)==true) {
                                return constantTemplate;
                }else
                                return null;
                }
                
                
                @FindBy(xpath="//button[contains(text(),'Add')]")
                private WebElement add_Template_Btn;
                public WebElement getAdd_Template_Btn() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(add_Template_Btn,driver, logger)==true) {
                                return add_Template_Btn;
                }else
                                return null;
                }
                
                @FindBy(xpath="//input[@name='equipmentName']")
                private WebElement template_SearchBox;
                public WebElement get_Template_SearchBox() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(template_SearchBox,driver, logger)==true) {
                                return template_SearchBox;
                }else
                                return null;
                }
                
                @FindBy(xpath="//button[contains(text(),'Update')]")
                private WebElement update_Template_Btn;
                public WebElement getUpdate_Template_Btn() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(update_Template_Btn,driver, logger)==true) {
                                return update_Template_Btn;
                }else
                                return null;
                }
                
                @FindBy(xpath="//button[contains(text(),'Delete')]")
                private WebElement delete_Template_Btn;
                public WebElement getDelete_Template_Btn() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(delete_Template_Btn,driver, logger)==true) {
                                return delete_Template_Btn;
                }else
                                return null;
                }
                

                @FindBy(xpath="//button[contains(text(),'Clear')]")
                private WebElement clear_Template_Btn;
                public WebElement getClear_Template_Btn() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(clear_Template_Btn,driver, logger)==true) {
                                return clear_Template_Btn;
                }else
                                return null;
                }
                
                
                @FindBy(xpath="//form[@name='constantTemplateForm']//button[text()='Yes']")
                private WebElement delete_Template_Confirm_Btn;
                public WebElement getDelete_Template_Confirm_Btn() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(delete_Template_Confirm_Btn,driver, logger)==true) {
                                return delete_Template_Confirm_Btn;
                }else
                                return null;
                }
                
                
                @FindBy(xpath="//select[@name='tagsData']")
                private WebElement custom_Template_Confirm_Btn;
                public WebElement getCustom_Tag_Select() throws Exception{
                if (commonFunctions.WebElementCommon.waitForElementPresent(custom_Template_Confirm_Btn,driver, logger)==true) {
                                return custom_Template_Confirm_Btn;
                }else
                                return null;
                }
                
                

                
                public List<WebElement> template_inTemplateGrid=null;
                public    List<WebElement> checkTemplatePresent() throws Exception
                {
                                String template_name_JsonPath="$..TemplateName";
                                Thread.sleep(3000);
                                String templateName=ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),template_name_JsonPath);
                                template_inTemplateGrid=driver.findElements(By.xpath("//span[text()='"+templateName+"']"));
                                return template_inTemplateGrid;
                                
                }
              
}
