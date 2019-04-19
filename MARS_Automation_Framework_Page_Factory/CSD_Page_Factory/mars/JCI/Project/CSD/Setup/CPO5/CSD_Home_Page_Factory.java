/*-------------------------------------------------------------------------------------

(C) Copyright 2016 Johnson Controls, Inc. 
    Use or Copying of all or any part of this program, except as
    permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.CSD.Setup.CPO5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class CSD_Home_Page_Factory {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	public CSD_Home_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	//Check for LogOut Elements -- Logged Out Final Page
	@FindBy(css = ".tile_name.tile_name_padding")
	private WebElement loggedOutIdentifier;

	public WebElement get_loggedOutIdentifier() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, loggedOutIdentifier, logger) == true) {
			element = loggedOutIdentifier;
		}
		return element;
	}
	
	//Check if the Johnson Controls Logo is loaded
	@FindBy(xpath = "html/body/div[1]/div/div/div[1]/img")
	private WebElement homeJCIImageLink;

	public WebElement get_homeJCIImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeJCIImageLink, logger) == true) {
			element = homeJCIImageLink;
		}
		return element;
	}
	
	//Check if CSD 2.0 Test is present
	@FindBy(xpath = "html/body/div[1]/div/div/div[1]/span/span")
	private WebElement homeCSDTextLink;

	public WebElement get_homeCSDTextLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeCSDTextLink, logger) == true) {
			element = homeCSDTextLink;
		}
		return element;
	}
	
	//Check if the Left Menu button is present
	@FindBy(xpath = ".//*[@id='leftmenu-trigger']/i")
	private WebElement homeLeftMenuLink;

	public WebElement get_homeLeftMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeLeftMenuLink, logger) == true) {
			System.out.println("Element is there");
			element = homeLeftMenuLink;
		}
		return element;
	}
	
	//Check if the Generic Home Button image is loaded
	@FindBy(xpath = "html/body/header/ol/li[1]/a/i")
	private WebElement homeHomeButtonLink;

	public WebElement get_homeHomeButtonLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeHomeButtonLink, logger) == true) {
			element = homeHomeButtonLink;
		}
		return element;
	}
	
	//Check  if LogOut Button is Loaded
	@FindBy(css = ".sign_out>img")
	private WebElement homeLogOutButtonLink;

	public WebElement get_homeLogOutButtonLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeLogOutButtonLink, logger) == true) {
			element = homeLogOutButtonLink;
		}
		return element;
	}
	
	//Check if Welcome message is Displayed
	@FindBy(xpath = "html/body/div[1]/div/div/div[2]/p[1]/span")
	private WebElement homeWelcomeMessageLink;

	public WebElement get_homeWelcomeMessageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeWelcomeMessageLink, logger) == true) {
			element = homeWelcomeMessageLink;
		}
		return element;
	}
	
	//Check if Timestamp is Loaded properly
	@FindBy(xpath = ".//*[@id='lblTime']")
	private WebElement homeTimastampLink;

	public WebElement get_homeTimastampLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeTimastampLink, logger) == true) {
			element = homeTimastampLink;
		}
		return element;
	}
	
	//Check if Dashboard Menu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li1']/a")
	private WebElement homeDashboardMenuLink;

	public WebElement get_homeDashboardMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeDashboardMenuLink, logger) == true) {
			element = homeDashboardMenuLink;
		}
		return element;
	}
	
	//Check if FaultDashboardMenu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li2']/a")
	private WebElement homeFaultDashboardMenuLink;

	public WebElement get_homeFaultDashboardMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeFaultDashboardMenuLink, logger) == true) {
			element = homeFaultDashboardMenuLink;
		}
		return element;
	}
	
	//Check if EquipDetailsMenu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li6']/a")
	private WebElement homeEquipDetailsMenuLink;

	public WebElement get_homeEquipDetailsMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeEquipDetailsMenuLink, logger) == true) {
			element = homeEquipDetailsMenuLink;
		}
		return element;
	}
	
	//Check if ReportingMenu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li3']/a")
	private WebElement homeReportingMenuLink;

	public WebElement get_homeReportingMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeReportingMenuLink, logger) == true) {
			element = homeReportingMenuLink;
		}
		return element;
	}	
	
	//Check if DiagnosticsMenu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li4']/a")
	private WebElement homeDiagnosticsMenuLink;

	public WebElement get_homeDiagnosticsMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeDiagnosticsMenuLink, logger) == true) {
			element = homeDiagnosticsMenuLink;
		}
		return element;
	}
	
	//Check if AdministrationMenu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li5']/a")
	private WebElement homeAdministrationMenuLink;

	public WebElement get_homeAdministrationMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeAdministrationMenuLink, logger) == true) {
			element = homeAdministrationMenuLink;
		}
		return element;
	}
	
	//Check if BranchUserMenu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li8']/a")
	private WebElement homeBranchUserMenuLink;

	public WebElement get_homeBranchUserMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeBranchUserMenuLink, logger) == true) {
			element = homeBranchUserMenuLink;
		}
		return element;
	}
	
	//Check if SetHelpMenu is Loaded/Visible
	@FindBy(xpath = ".//*[@id='li7']/a")
	private WebElement homeSetHelpMenuLink;

	public WebElement get_homeSetHelpMenuLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeSetHelpMenuLink, logger) == true) {
			element = homeSetHelpMenuLink;
		}
		return element;
	}
	
		//Check if PowerBIReportMenu is Loaded/Visible
		@FindBy(xpath = ".//*[@id='li12']/a")
		private WebElement homePowerBIReportMenuLink;

		public WebElement get_homePowerBIReportMenuLink() {
			WebElement element = null;
			if (WebElementCommon.waitForElementPresent(driver, homePowerBIReportMenuLink, logger) == true) {
				element = homePowerBIReportMenuLink;
			}
			return element;
		}
		
		//Check if SiteSetupMenu is Loaded/Visible
		@FindBy(xpath = ".//*[@id='li14']/a")
		private WebElement homeSiteSetupMenuLink;

		public WebElement get_homeSiteSetupMenuLink() {
			WebElement element = null;
			if (WebElementCommon.waitForElementPresent(driver, homeSiteSetupMenuLink, logger) == true) {
				element = homeSiteSetupMenuLink;
			}
			return element;
		}
	
}
