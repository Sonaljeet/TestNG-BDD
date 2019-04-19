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

import commonFunctions.WebElementCommon;

public class BCM_Setup_ContractInformation_Page_Factory {

	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public BCM_Setup_ContractInformation_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="body")
	private WebElement entirePageBdy;
	
	public WebElement getPageBody(){
		if (WebElementCommon.waitForElementPresent(driver, entirePageBdy, logger)) {
			return entirePageBdy;
		}else
			return null;
	}
	
//Customer Info Summary WebElements	--- START
	@FindBy(css="input[Automation_id=setUpContractInfo_CustomerName]")
	private WebElement setUpContractInfo_CustomerName;
	
	public WebElement get_setUpContractInfo_CustomerName(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_CustomerName, logger)){
			return setUpContractInfo_CustomerName;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_CountryDropDown]")
	private WebElement setUpContractInfo_CountryDropDown;
	
	public WebElement get_setUpContractInfo_CountryDropDown(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_CountryDropDown, logger)){
			return setUpContractInfo_CountryDropDown;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_Address1]")
	private WebElement setUpContractInfo_Address1;
	
	public WebElement get_setUpContractInfo_Address1(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_Address1, logger)){
			return setUpContractInfo_Address1;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_City]")
	private WebElement setUpContractInfo_City;
	
	public WebElement get_setUpContractInfo_City(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_City, logger)){
			return setUpContractInfo_City;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_Email]")
	private WebElement setUpContractInfo_Email;

	public WebElement get_setUpContractInfo_Email() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_Email, logger)) {
			return setUpContractInfo_Email;
		} else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_ContactNumber]")
	private WebElement setUpContractInfo_ContactNumber;
	
	public WebElement get_setUpContractInfo_ContactNumber(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_ContactNumber, logger)){
			return setUpContractInfo_ContactNumber;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_State]")
	private WebElement setUpContractInfo_State;
	
	public WebElement get_setUpContractInfo_State(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_State, logger)){
			return setUpContractInfo_State;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_Address2]")
	private WebElement setUpContractInfo_Address2;
	
	public WebElement get_setUpContractInfo_Address2(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_Address2, logger)){
			return setUpContractInfo_Address2;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpContractInfo_PinCode]")
	private WebElement setUpContractInfo_PinCode;
	
	public WebElement get_setUpContractInfo_PinCode(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_PinCode, logger)){
			return setUpContractInfo_PinCode;
		}else
			return null;
	}
	
	@FindBy(css="a[Automation_id=setUpContractInfo_SaveButton]")
	private WebElement setUpContractInfo_SaveButton;
	
	public WebElement get_setUpContractInfo_SaveButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_SaveButton, logger)){
			return setUpContractInfo_SaveButton;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpContractInfo_CustomerNameErrorMsg]")
	private WebElement setUpContractInfo_CustomerNameErrorMsg;
	
	public WebElement get_setUpContractInfo_CustomerNameErrorMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_CustomerNameErrorMsg, logger)){
			return setUpContractInfo_CustomerNameErrorMsg;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpContractInfo_EmailAddressErrorMsg]")
	private WebElement setUpContractInfo_EmailAddressErrorMsg;
	
	public WebElement get_setUpContractInfo_EmailAddressErrorMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_EmailAddressErrorMsg, logger)){
			return setUpContractInfo_EmailAddressErrorMsg;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpContractInfo_CustomerInfoSaveMsg]")
	private WebElement setUpContractInfo_CustomerInfoSaveMsg;
	
	public WebElement get_setUpContractInfo_CustomerInfoSaveMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_CustomerInfoSaveMsg, logger)){
			return setUpContractInfo_CustomerInfoSaveMsg;
		}else
			return null;
	}
//Customer Info Summary WebElements	--- END
	
//==================================================================================================//
	
//Emergency Info Summary WebElements	--- START
//This webelement is sued to click on the drop down arrow of the Group Name

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_Arrow")
	private WebElement setUpEmergencyContact_GroupName;
	
	public WebElement get_setUpEmergencyContact_GroupName(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_GroupName, logger)){
			return setUpEmergencyContact_GroupName;
		}else
			return null;
	}
	@FindBy(css="input[id=ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_ClientState]")
	private WebElement groupNameDropDownValue;
	public WebElement get_groupNameDropDownValue(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, groupNameDropDownValue, logger)){
			return groupNameDropDownValue;
		}else
			return null;
	}

	@FindBy(css="#ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_DropDown > div > ul > li:nth-child(1)")
	private WebElement groupValPleaseSelect;
	public WebElement gpValPlzSelect(){
		//commonFunctions.WebElementCommon.staticWait(2000);
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, groupValPleaseSelect, logger)){
			return groupValPleaseSelect;
		}else
			return null;
	}
	
	@FindBy(css="#ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_DropDown > div > ul > li:nth-child(2)")
	private WebElement groupValSecAndFire;
	public WebElement gpValSecAndFire(){
		commonFunctions.WebElementCommon.staticWait(2000);
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, groupValSecAndFire, logger)){
			return groupValSecAndFire;
		}else
			return null;
	}
	
	@FindBy(css="#ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_DropDown > div > ul > li:nth-child(3)")
	private WebElement groupValBMSTech;
	public WebElement gpValBMSTech(){
		//commonFunctions.WebElementCommon.staticWait(2000);
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, groupValBMSTech, logger)){
			return groupValBMSTech;
		}else
			return null;
	}
	
	@FindBy(css="#ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_DropDown > div > ul > li:nth-child(4)")
	private WebElement groupValEmerCont;
	public WebElement gpValEmerCont(){
		commonFunctions.WebElementCommon.staticWait(2000);
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, groupValEmerCont, logger)){
			return groupValEmerCont;
		}else
			return null;
	}
	
	@FindBy(css="#ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_DropDown > div > ul > li:nth-child(5)")
	private WebElement groupValBuilOwn;
	public WebElement gpValBuilOwn(){
		commonFunctions.WebElementCommon.staticWait(2000);
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, groupValBuilOwn, logger)){
			return groupValBuilOwn;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpEmergencyContact_ContactPerson]")
	private WebElement setUpEmergencyContact_ContactPerson;
	
	public WebElement get_setUpEmergencyContact_ContactPerson(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_ContactPerson, logger)){
			return setUpEmergencyContact_ContactPerson;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpEmergencyContact_ContactNumber]")
	private WebElement setUpEmergencyContact_ContactNumber;
	
	public WebElement get_setUpEmergencyContact_ContactNumber(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_ContactNumber, logger)){
			return setUpEmergencyContact_ContactNumber;
		}else
			return null;
	}
	
	@FindBy(css="input[Automation_id=setUpEmergencyContact_EmailAddress]")
	private WebElement setUpEmergencyContact_EmailAddress;
	
	public WebElement get_setUpEmergencyContact_EmailAddress(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_EmailAddress, logger)){
			return setUpEmergencyContact_EmailAddress;
		}else
			return null;
	}
	
	@FindBy(css="input[id=ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadBtnSaveAdd_input]")
	private WebElement setUpEmergencyContact_AddButton;
	
	public WebElement get_setUpEmergencyContact_AddButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_AddButton, logger)){
			return setUpEmergencyContact_AddButton;
		}else
			return null;
	}
	
	@FindBy(css="a[Automation_id=setUpEmergencyContact_ClearButton]")
	private WebElement setUpEmergencyContact_ClearButton;
	
	public WebElement get_setUpEmergencyContact_ClearButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_ClearButton, logger)){
			return setUpEmergencyContact_ClearButton;
		}else
			return null;
	}
	
	@FindBy(css="a[Automation_id=setUpContractInfo_ExportButton]")
	private WebElement setUpContractInfo_ExportButton;
	
	public WebElement get_setUpContractInfo_ExportButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpContractInfo_ExportButton, logger)){
			return setUpContractInfo_ExportButton;
		}else
			return null;
	}
	
	@FindBy(css="a[Automation_id=setUpEmergencyContact_NextButon]")
	private WebElement setUpEmergencyContact_NextButon;
	
	public WebElement get_setUpEmergencyContact_NextButon(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_NextButon, logger)){
			return setUpEmergencyContact_NextButon;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpEmergencyContact_SelectGroupErrorMsg]")
	private WebElement setUpEmergencyContact_SelectGroupErrorMsg;
	
	public WebElement get_setUpEmergencyContact_SelectGroupErrorMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_SelectGroupErrorMsg, logger)){
			return setUpEmergencyContact_SelectGroupErrorMsg;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpEmergencyContact_ContactPersonErrorMsg]")
	private WebElement setUpEmergencyContact_ContactPersonErrorMsg;
	
	public WebElement get_setUpEmergencyContact_ContactPersonErrorMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_ContactPersonErrorMsg, logger)){
			return setUpEmergencyContact_ContactPersonErrorMsg;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpEmergencyContact_ContactNumberErrorMsg]")
	private WebElement setUpEmergencyContact_ContactNumberErrorMsg;
	
	public WebElement get_setUpEmergencyContact_ContactNumberErrorMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_ContactNumberErrorMsg, logger)){
			return setUpEmergencyContact_ContactNumberErrorMsg;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpEmergencyContact_EmailAddressErrorMsg]")
	private WebElement setUpEmergencyContact_EmailAddressErrorMsg;
	
	public WebElement get_setUpEmergencyContact_EmailAddressErrorMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_EmailAddressErrorMsg, logger)){
			return setUpEmergencyContact_EmailAddressErrorMsg;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpEmergencyContact_EmailAddressErrorMsg]")
	private WebElement setUpEmergencyContact_InvalidEmailErrorMsg;
	
	public WebElement get_setUpEmergencyContact_InvalidEmailErrorMsg(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_InvalidEmailErrorMsg, logger)){
			return setUpEmergencyContact_InvalidEmailErrorMsg;
		}else
			return null;
	}
	
	@FindBy(css="span[Automation_id=setUpEmergencyContact_InfoSaveMessage]")
	private WebElement setUpEmergencyContact_InfoSaveMessage;
	
	public WebElement get_setUpEmergencyContact_InfoSaveMessage(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpEmergencyContact_InfoSaveMessage, logger)){
			return setUpEmergencyContact_InfoSaveMessage;
		}else
			return null;
	}
	
	@FindBy(css="div[id=ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadGrid1_GridData]")
	private WebElement gridTable;
	
	public WebElement get_gridTable(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, gridTable, logger)){
			return gridTable;
		}else{
			return null;
		}
	}
	@FindBy(xpath="//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadGrid1_ctl00\"]/tbody/tr")
	private WebElement gridRows;
	
	public WebElement get_gridRows(){
		if (WebElementCommon.waitForElementPresent(driver, gridRows, logger)) {
			return gridRows;
		}else{
			return null;
		}
	}
//Emergency Info Summary WebElements	--- END
}
