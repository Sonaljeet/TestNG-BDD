package mars.JCI.Project.BCMET.Engineering;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCMET_Engineering_ActiveProjectList_Page_Factory {

	private static WebDriver driver = null;
	private static ExtentTest logger = null; 
	
	public BCMET_Engineering_ActiveProjectList_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_ContentPlaceHolder1_rgCreateProject_GridData")
	private WebElement projectSummaryTableGrid;
	public WebElement get_projectSummaryTable() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, projectSummaryTableGrid, logger)) {
			element = projectSummaryTableGrid;
		}
		return element;
	}
	@FindBy(id="body")
	private WebElement pageBody;
	public WebElement get_pageBody() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, pageBody, logger)) {
			element = pageBody;
		}
		return element;
	}
	@FindBy(css="i[automation_id=EnggineeringLink]")
	private WebElement EngineeringLink;
	public WebElement get_EngineeringLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, EngineeringLink, logger)) {
			
			element= EngineeringLink;
		}
		return element;
	}
	
	@FindBy(id="hlAdmin")
	private WebElement AdminLink;
	public WebElement get_AdminLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, AdminLink, logger)) {
			element= AdminLink;
		}
		return element;
	}
	
	@FindBy(id="hlMaster")
	private WebElement MasterLink;
	public WebElement get_MasterLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, MasterLink, logger)) {
			element= MasterLink;
		}
		return element;
	}
	
	@FindBy(css="b[automation_id=LogoutDDArrow]")
	private WebElement LogoutDDArrow;
	public WebElement get_LogoutDDArrow() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, LogoutDDArrow, logger)) {
			element= LogoutDDArrow;
		}
		return element;
	}
	
	@FindBy(css="span[automation_id=\"LogoutLink\"]")
	private WebElement LogoutLink;
	public WebElement get_LogoutLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, LogoutLink, logger)) {
			element= LogoutLink;
		}
		return element;
	}
	
	@FindBy(css="input[automation_id=Engg_ActiveProList_ProjectNameSearchBox]")
	private WebElement ProjectNameSearchBox;
	public WebElement get_ProjectNameSearchBox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ProjectNameSearchBox, logger)) {
			element= ProjectNameSearchBox;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ActiveProList_SearchButton]")
	private WebElement ProjectSearchButton;
	public WebElement get_ProjectSearchButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ProjectSearchButton, logger)) {
			element= ProjectSearchButton;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ActiveProjectListTab]")
	private WebElement ActiveProjectListTab;
	public WebElement get_ActiveProjectListTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ActiveProjectListTab, logger)) {
			element= ActiveProjectListTab;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ArchiveProjectListTab]")
	private WebElement ArchiveProjectListTab;
	public WebElement get_ArchiveProjectListTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ArchiveProjectListTab, logger)) {
			element= ArchiveProjectListTab;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ActiveProList_CreateNewProjectButton]")
	private WebElement CreateNewProjectButton;
	public WebElement get_CreateNewProjectButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CreateNewProjectButton, logger)) {
			element= CreateNewProjectButton;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ActiveProList_ArchiveProjectListButton]")
	private WebElement ArchiveProjectListButton;
	public WebElement get_ArchiveProjectListButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ArchiveProjectListButton, logger)) {
			element= ArchiveProjectListButton;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ActiveProList_DeleteProjectButton]")
	private WebElement DeleteProjectButton;
	public WebElement get_DeleteProjectButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, DeleteProjectButton, logger)) {
			element= DeleteProjectButton;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ActiveProList_CreateBCMETBackupButton]")
	private WebElement CreateBCMETBackupButton;
	public WebElement get_CreateBCMETBackupButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CreateBCMETBackupButton, logger)) {
			element= CreateBCMETBackupButton;
		}
		return element;
	}
	
	@FindBy(css="a[automation_id=Engg_ActiveProList_RestoreBCMETBackupButton]")
	private WebElement RestoreBCMETBackupButton;
	public WebElement get_RestoreBCMETBackupButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, RestoreBCMETBackupButton, logger)) {
			element= RestoreBCMETBackupButton;
		}
		return element;
	}
	
	@FindBy(css="div[automation_id=Engg_Pro_Info_PopMessageBoxInfo]")
	private WebElement ActiveProList_PopInfoMsg;
	public WebElement get_ActiveProList_PopInfoMsg() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ActiveProList_PopInfoMsg, logger)) {
			element= ActiveProList_PopInfoMsg;
		}
		return element;
	}
	
	@FindBy(css="input[automation_id=Engg_ActiveProList_PopOkButton]")
	private WebElement ActiveProList_PopOkButton;
	public WebElement get_ActiveProList_PopOkButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ActiveProList_PopOkButton, logger)) {
			element= ActiveProList_PopOkButton;
		}
		return element;
	}

	@FindBy(id="popup_ok")
	private WebElement DeleteProject_PopYesButton;
	public WebElement get_DeleteProject_PopYesButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, DeleteProject_PopYesButton, logger)) {
			element= DeleteProject_PopYesButton;
		}
		return element;
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rgArchiveProject_GridData")
	private WebElement ArchiveProjectListDataGrid;
	public WebElement get_ArchiveProjectListDataGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ArchiveProjectListDataGrid, logger)) {
			element= ArchiveProjectListDataGrid;
		}
		return element;
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnMoveToActiveProject_input")
	private WebElement MoveToActiveProjectListBtn;
	public WebElement get_MoveToActiveProjectListBtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, MoveToActiveProjectListBtn, logger)) {
			element= MoveToActiveProjectListBtn;
		}
		return element;
	} 
	//
	
/*	@FindBy(css="automation_id=\"EnggineeringLink\"")
	private WebElement EngineeringLink;
	public WebElement get_EngineeringLink() {
		WebElement element = null;
		if (WebElementCommon.isElementPresent(driver, EngineeringLink)) {
			element= EngineeringLink;
		}
		return element;
	}*/
	
}
