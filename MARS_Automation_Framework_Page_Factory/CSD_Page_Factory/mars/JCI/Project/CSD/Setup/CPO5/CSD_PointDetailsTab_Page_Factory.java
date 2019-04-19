/*-------------------------------------------------------------------------------------

(C) Copyright 2016 Johnson Controls, Inc. 
    Use or Copying of all or any part of this program, except as
    permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/
/**
 * @author cdeyso
 *
 */

package mars.JCI.Project.CSD.Setup.CPO5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CSD_PointDetailsTab_Page_Factory {

	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_PointDetailsTab_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		
		PageFactory.initElements(driver, this);
	}
	
	//The Dashboard Tab
	@FindBy(css="a[test-id='Dashboard-tab']")
	private WebElement pointDetailsTab_DashboardLink;
	
	public WebElement get_pointDetailsTab_DashboardLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_DashboardLink, logger)){
			return pointDetailsTab_DashboardLink;
		}else
			return null;
	}
	
	//The Right Menu Tab For Searching Chillers and Plants
	@FindBy(css="a[test-id='btnRightmenu']")
	private WebElement pointDetailsTab_RightmenuLink;
	
	public WebElement get_pointDetailsTab_RightmenuLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_RightmenuLink, logger)){
			return pointDetailsTab_RightmenuLink;
		}else
			return null;
	}
	
	//The Text Box for Searching Chillers
	@FindBy(xpath=".//*[@id='cssmenu']/div/table/tbody/tr/td[1]/input")
	private WebElement pointDetailsTab_SearchChillerTxtBox;
	
	public WebElement get_pointDetailsTab_SearchChillerTxtBox(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_SearchChillerTxtBox, logger)){
			return pointDetailsTab_SearchChillerTxtBox;
		}else
			return null;
	}
	
	//Enter Name of the Project
	@FindBy(xpath=".//*[@id='cssmenu']/ul/li/a/span[1]")
	private WebElement pointDetailsTab_ChillerDetailsOne;
	
	public WebElement get_pointDetailsTab_ChillerDetailsOne(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_ChillerDetailsOne, logger)){
			return pointDetailsTab_ChillerDetailsOne;
		}else
			return null;
	}
	
	//Select Name of the Site -- TO BE MADE DYNAMIC -- THE LOCATOR NEEDS TO BE DYNAMIC
	@FindBy(xpath=".//*[@id='cssmenu']/ul/li/ul/li/a/span[1]")
	private WebElement pointDetailsTab_ChillerDetailsTwo;
	
	public WebElement get_pointDetailsTab_ChillerDetailsTwo(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_ChillerDetailsTwo, logger)){
			return pointDetailsTab_ChillerDetailsTwo;
		}else
			return null;
	}
	
	//Select Name of the Chiller -- TO BE MADE DYNAMIC -- THE LOCATOR NEEDS TO BE DYNAMIC
	@FindBy(xpath=".//*[@id='cssmenu']/ul/li/ul/li/ul[1]/li/div/div[1]/a/span[1]")
	private WebElement pointDetailsTab_ChillerDetailsThree;
	
	public WebElement get_pointDetailsTab_ChillerDetailsThree(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_ChillerDetailsThree, logger)){
			return pointDetailsTab_ChillerDetailsThree;
		}else
			return null;
	}
	
	//The Point Details Tab
	@FindBy(css="a[test-id='PointDetails-tab']")
	private WebElement pointDetailsTab_PointDetaialsTabLink;
	
	public WebElement get_pointDetailsTab_PointDetaialsTabLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_PointDetaialsTabLink, logger)){
			return pointDetailsTab_PointDetaialsTabLink;
		}else
			return null;
	}
	
	//The Get Chiller Model Details Image Link //
	@FindBy(css="#wrap > div > div > div > div > div:nth-child(1) > div.col-md-6-fix.margin_bottom.chiller-list-popup > table > tbody > tr > td:nth-child(2) > a > img")//.col-md-6-fix.margin_bottom.chiller-list-popup > table > tbody > tr > td > a > img
	private WebElement pointDetailsTab_ChillerModelDetailsImgLink;
	
	public WebElement get_pointDetailsTab_ChillerModelDetailsImgLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_ChillerModelDetailsImgLink, logger)){
			return pointDetailsTab_ChillerModelDetailsImgLink;
		}else
			return null;
	}
	
	//The Get Chiller Model Details Text Name Link
	@FindBy(css="#wrap > div > div > div > div > div:nth-child(2) > div > chiller-details-dir > div > div:nth-child(1) > span:nth-child(4)")
	private WebElement pointDetailsTab_ChillerModelDetailsTxtLink;
	
	public WebElement get_pointDetailsTab_ChillerModelDetailsTxtLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_ChillerModelDetailsTxtLink, logger)){
			return pointDetailsTab_ChillerModelDetailsTxtLink;
		}else
			return null;
	}
	
	//The attribute id for the selected chiller
	@FindBy(css="span[test-id='AssetDetailsId']")
	private WebElement pointDetailsTab_ChillerModelAttDetailsLink;
	
	public WebElement get_pointDetailsTab_ChillerModelAttDetailsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetailsTab_ChillerModelAttDetailsLink, logger)){
			return pointDetailsTab_ChillerModelAttDetailsLink;
		}else
			return null;
	}
	
}
