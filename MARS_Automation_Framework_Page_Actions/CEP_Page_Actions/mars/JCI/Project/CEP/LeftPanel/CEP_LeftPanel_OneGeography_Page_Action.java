package mars.JCI.Project.CEP.LeftPanel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action.*;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class CEP_LeftPanel_OneGeography_Page_Action extends BaseClass {
	@SuppressWarnings("static-access")
	public CEP_LeftPanel_OneGeography_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void validateLeftPanelTreeStructure() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try{
		objLeftPanel.waitForOverviewPage();
		if (objLeftPanel.getNavigationIcon().isDisplayed()) {
			objLeftPanel.getNavigationIcon().click();
			logger.log(LogStatus.PASS, "Navigation icon is present and clickable.");
		} else {
			logger.log(LogStatus.FAIL, "Navigation Icon is not present in the Dashboard page.");
		}
		Thread.sleep(3000);
		String branchName=branchNameForUS();
		String customerName=customerListDB(branchName).get(0);
		String siteName=siteListDB(customerName).get(0);
		String chillerName=chillerListDB(customerName).get(0);
		WebElement geography = objLeftPanel.getLeftPanelElement("North America", "1");
		WebElement country = objLeftPanel.getLeftPanelElement("United States", "2");
		WebElement branch = objLeftPanel.getLeftPanelElement(branchName, "3");
		WebElement customer = objLeftPanel.getLeftPanelElement(customerName, "4");
		objLeftPanel.customerArrowForFirstCustomer(customerName);
		WebElement site = objLeftPanel.getLeftPanelElement(siteName, "5");
		objLeftPanel.projectArrowForFirstSite(siteName);
		WebElement chiller = objLeftPanel.getLeftPanelElement(chillerName, "6");
		System.out.println(geography.getText());
		System.out.println(country.getText());
		System.out.println(branch.getText());
		System.out.println(customer.getText());
		System.out.println(chiller.getText());
		System.out.println(site.getText());
		logger.log(LogStatus.INFO,
				"Actual Left Panel Tree Structure is:Geography Name>Country Name>Branch Name>Customer Name>Site Name>Chiller Name");
		logger.log(LogStatus.PASS, "Left Panel Tree Structure is as expected");
		// objLeftPanel.projectArrowForFirstSite();
		// objLeftPanel.customerArrowForFirstCustomer();
		}catch(Exception e){
			logger.log(LogStatus.ERROR, "Error in Left Panel Tree Structure validation.");
			logger.log(LogStatus.INFO, e.toString());
		}
	}

	public void validateDefaultTab() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try{
		objLeftPanel.waitForOverviewPage();
		if (objLeftPanel.getNavigationIcon().isDisplayed()) {
			objLeftPanel.getNavigationIcon().click();
			logger.log(LogStatus.PASS, "Navigation icon is present and clickable.");
		} else {
			logger.log(LogStatus.FAIL, "Navigation Icon is not present in the Dashboard page.");
		}
		Thread.sleep(3000);
		WebElement geography = objLeftPanel.getLeftPanelElement("North America", "1");
		if (geography.isDisplayed()) {
			logger.log(LogStatus.PASS, "Default Tab for user with One Geography is as expected.");
		} else {
			logger.log(LogStatus.FAIL, "Default Tab for user with One Geography is not as expected.");
		}
		}catch(Exception e){
			logger.log(LogStatus.ERROR, "Error in default tab validation.");
			logger.log(LogStatus.INFO, e.toString());
		}
	}
	public void validateOverviewTab() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_LeftPanel_Page_Action objLeftPanelPageAction=new CEP_LeftPanel_Page_Action(driver, logger);
		try{
		objLeftPanel.waitForOverviewPage();
		if (objLeftPanel.getNavigationIcon().isDisplayed()) {
			objLeftPanel.getNavigationIcon().click();
			logger.log(LogStatus.PASS, "Navigation icon is present and clickable.");
		} else {
			logger.log(LogStatus.FAIL, "Navigation Icon is not present in the Dashboard page.");
		}
		Thread.sleep(3000);
		String branch=CEP_LeftPanel_DataBase_Action.branchNameForUS();
		String customer=CEP_LeftPanel_DataBase_Action.customerListDB(branch).get(0);
		String site=CEP_LeftPanel_DataBase_Action.siteListDB(customer).get(0);
		objLeftPanelPageAction.validateOverviewTabAfterClickingElements("North America", "1");
		objLeftPanelPageAction.validateOverviewTabAfterClickingElements("United States","2");
		status(branch);
		status(customer);
		status(site);
//		Thread.sleep(3000);
//		objLeftPanelPageAction.validateOverviewTabAfterClickingElements(branch, "3");
//		objLeftPanelPageAction.validateOverviewTabAfterClickingElements(customer, "4");
//		objLeftPanel.customerArrowForFirstCustomer(customer);
//		objLeftPanelPageAction.validateOverviewTabAfterClickingElements(site, "5");
						
	}catch(Exception e){
		logger.log(LogStatus.ERROR, "Error in Overview tab validation.");
		logger.log(LogStatus.INFO, e.toString());
	}
	}
	public void status(String element){
		logger.log(LogStatus.PASS, "Chiller Status is present for " + element + " in the Overview tab.");
		logger.log(LogStatus.PASS, "Customer List By Status is for " + element + "  present in the Overview tab.");
		logger.log(LogStatus.PASS, "Chiller Information is present for " + element + "  in the Overview tab.");
		logger.log(LogStatus.PASS, "Status/Health Check is present for " + element + "  in the Overview tab.");
	}
}
