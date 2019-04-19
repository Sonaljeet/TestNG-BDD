/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class BCM_Setup_Home_Page_Factory {

	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public BCM_Setup_Home_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[automation_id=setUpPage_SetupLink]")
	private WebElement setUpPage_SetupLink;
	
	public WebElement get_setUpPage_SetupLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_SetupLink, logger)){
			return setUpPage_SetupLink;
		}else
			return null;
	}
	
	@FindBy(css="a[automation_id=setUpPage_LogOutDropDown]")
	private WebElement setUpPage_LogOutDropDown;
	
	public WebElement get_setUpPage_LogOutDropDown(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_LogOutDropDown, logger)){
			return setUpPage_LogOutDropDown;
		}else
			return null;
	}
	
	@FindBy(css="")
	private WebElement element;
	
	public WebElement get_element(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, element, logger)){
			return element;
		}else
			return null;
	}
	
	@FindBy(id="lblLogout")
	private WebElement setUpPage_LogOutLink;
	
	public WebElement get_setUpPage_LogOutLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_LogOutLink, logger)){
			return setUpPage_LogOutLink;
		}else
			return null;
	}
	
	@FindBy(css="a[id='hrfHome']")
	private WebElement setUpPage_HomeLink;
	
	public WebElement get_setUpPage_HomeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_HomeLink, logger)){
			return setUpPage_HomeLink;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpPage_FavoriteLink]")
	private WebElement setUpPage_FavoriteLink;
	
	public WebElement get_setUpPage_FavoriteLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_FavoriteLink, logger)){
			return setUpPage_FavoriteLink;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpPage_LibraryLink]")
	private WebElement setUpPage_LibraryLink;
	
	public WebElement get_setUpPage_LibraryLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_LibraryLink, logger)){
			return setUpPage_LibraryLink;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpPage_ContactsLink]")
	private WebElement setUpPage_ContactsLink;
	
	public WebElement get_setUpPage_ContactsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_ContactsLink, logger)){
			return setUpPage_ContactsLink;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpPage_OutsideAirLink]")
	private WebElement setUpPage_OutsideAirLink;
	
	public WebElement get_setUpPage_OutsideAirLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_OutsideAirLink, logger)){
			return setUpPage_OutsideAirLink;
		}else
			return null;
	}
	@FindBy(css="input[Automation_id=setUpPage_SideBarLink]")
	private WebElement setUpPage_SideBarLink;
	
	public WebElement get_setUpPage_SideBarLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_SideBarLink, logger)){
			return setUpPage_SideBarLink;
		}else
			return null;
	}

	@FindBy(css="input[automation_id=setUpHome_ContractInfoLink]")
	private WebElement setUpHome_ContractInfoLink;
	
	public WebElement get_setUpHome_ContractInfoLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpHome_ContractInfoLink, logger)){
			return setUpHome_ContractInfoLink;
		}else
			return null;
	}
	
	@FindBy(css="a[id=ContentPlaceHolder1_lnkBtnPtDiscovery]")
	private WebElement setUpPage_PointDiscoveryLink;
	
	public WebElement get_setUpPage_PointDiscoveryLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_PointDiscoveryLink, logger)){
			return setUpPage_PointDiscoveryLink;
		}else
			return null;
	}
	
	@FindBy(css="a[id=ContentPlaceHolder1_lnkBtnSysConfiguration]")
	private WebElement setUpPage_BuildingsLink;
	
	public WebElement get_setUpPage_BuildingsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_BuildingsLink, logger)){
			return setUpPage_BuildingsLink;
		}else
			return null;
	}
	
	@FindBy(css="a[id=ContentPlaceHolder1_lnkBtnSystems]")
	private WebElement setUpPage_SystemsLink;
	
	public WebElement get_setUpPage_SystemsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_SystemsLink, logger)){
			return setUpPage_SystemsLink;
		}else
			return null;
	}
	
	@FindBy(css="a[id=ContentPlaceHolder1_lnkBtnCustomeSummary]")
	private WebElement setUpPage_CustomSummaryLink;
	
	public WebElement get_setUpPage_CustomSummaryLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_CustomSummaryLink, logger)){
			return setUpPage_CustomSummaryLink;
		}else
			return null;
	}
	
	@FindBy(css="a[id=ContentPlaceHolder1_LineEnergymeter]")
	private WebElement setUpPage_EnergyMeterLink;
	
	public WebElement get_setUpPage_EnergyMeterLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_EnergyMeterLink, logger)){
			return setUpPage_EnergyMeterLink;
		}else
			return null;
	}
	
	@FindBy(css="a[id=ContentPlaceHolder1_lnkBtnUserRole]")
	private WebElement setUpPage_UserRoleLink;
	
	public WebElement get_setUpPage_UserRoleLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_UserRoleLink, logger)){
			return setUpPage_UserRoleLink;
		}else
			return null;
	}
	
	@FindBy(partialLinkText="Add User")
	private WebElement setUpPage_AddUserLink;
	
	public WebElement get_setUpPage_AddUserLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpPage_AddUserLink, logger)){
			return setUpPage_AddUserLink;
		}else
			return null;
	}
	
}
