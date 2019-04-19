/**
 * 
 */
package mars.JCI.Project.CSD.Setup.CPO5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author cdeyso
 *
 */
public class CSD_SCTTemplate_Page_Factory {


	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SCTTemplate_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		
		PageFactory.initElements(driver, this);
	}
	
	//The Administration Tab
	@FindBy(css="a[test-id='administration-tab']")
	private WebElement sctTab_AdministrationLink;
	
	public WebElement get_sctTab_AdministrationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sctTab_AdministrationLink, logger)){
			return sctTab_AdministrationLink;
		}else
			return null;
	}
	
	//The SCT Upload Tab
	@FindBy(css="a[test-id='sctUpload-tab']")
	private WebElement sctTab_SCTUploadLink;
		
	public WebElement get_sctTab_SCTUploadLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sctTab_SCTUploadLink, logger)){
			return sctTab_SCTUploadLink;
		}else
			return null;
	}
	
	//The SCT Template Tab
	@FindBy(css="a[test-id='sctTemplate-tab']")
	private WebElement sctTab_SCTTemplateLink;
			
	public WebElement get_sctTab_SCTTemplateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sctTab_SCTTemplateLink, logger)){
			return sctTab_SCTTemplateLink;
		}else
			return null;
	}
	
	//The SCT Template Form -- Equipment Item
	@FindBy(css="select[test-id='SctTemp-Equipment']")
	private WebElement sctTab_SCTTemplateEquipmentLink;
			
	public WebElement get_sctTab_SCTTemplateEquipmentLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sctTab_SCTTemplateEquipmentLink, logger)){
			return sctTab_SCTTemplateEquipmentLink;
		}else
			return null;
	}
	
	//The SCT Template Form -- Model Item
	@FindBy(css="select[test-id='SctTemp-Model']")
	private WebElement sctTab_SCTTemplateModelLink;
			
	public WebElement get_sctTab_SCTTemplateModelLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sctTab_SCTTemplateModelLink, logger)){
			return sctTab_SCTTemplateModelLink;
		}else
			return null;
	}
	
	//The SCT Template Form -- Template Download Button Item
	@FindBy(css="input[test-id='SctTemp-btnDownload']")
	private WebElement sctTab_SCTTemplateDownloadButtonLink;
			
	public WebElement get_sctTab_SCTTemplateDownloadButtonLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sctTab_SCTTemplateDownloadButtonLink, logger)){
			return sctTab_SCTTemplateDownloadButtonLink;
		}else
			return null;
	}
	
	//The SCT Template Form -- After Download PopUp Item 
	@FindBy(id="popup_ok")
	private WebElement sctTab_SCTTemplateDownloadPopUpLink;
			
	public WebElement get_sctTab_SCTTemplateDownloadPopUpLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sctTab_SCTTemplateDownloadPopUpLink, logger)){
			return sctTab_SCTTemplateDownloadPopUpLink;
		}else
			return null;
	}
	
}
