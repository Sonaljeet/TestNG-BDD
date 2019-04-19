package mars.JCI.Project.CSD.HomePage.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CSD_HomePage_Dashboard_PointDetails_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	
	private static CSD_HomePage_Dashboard_Page_Factory csd_db_dashboard_pf = null;
	
	public CSD_HomePage_Dashboard_PointDetails_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		csd_db_dashboard_pf = new CSD_HomePage_Dashboard_Page_Factory(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//The Dashboard Expansion Link 
	@FindBy(css="a[test-id='Dashboard-tab']")
	private WebElement pointDetails_DashboardTab;
		
	public WebElement get_pointDetails_DashboardTab(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetails_DashboardTab, logger)){
			return pointDetails_DashboardTab;
		}else
			return null;
	}
	
	
	//The Dashboard Expansion Link -- The PointDetails Tab
	@FindBy(css="a[test-id='PointDetails-tab']")
	private WebElement pointDetails_PointDetailsTab;
		
	public WebElement get_pointDetails_PointDetailsTab(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetails_PointDetailsTab, logger)){
			return pointDetails_PointDetailsTab;
		}else
			return null;
	}
	
	
	//The Dashboard Expansion Link -- The PointDetails Tab -- Manage Active Points Button
	@FindBy(css="a[test-id='PointDetails-tab']")
	private WebElement pointDetails_ManageActivePointsLink;
		
	public WebElement get_pointDetails_ManageActivePointsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, pointDetails_ManageActivePointsLink, logger)){
			return pointDetails_ManageActivePointsLink;
		}else
			return null;
	}
	
	
	

}
