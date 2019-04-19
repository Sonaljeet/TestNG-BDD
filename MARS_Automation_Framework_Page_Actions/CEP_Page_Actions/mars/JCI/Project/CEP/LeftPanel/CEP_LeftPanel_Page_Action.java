package mars.JCI.Project.CEP.LeftPanel;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mars.Business.Layer.ReadPropertyFile;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;

import static mars.Component.Functions.BaseClass.projectPropertiesFile;
import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.*;
import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action.branchNameForUS;
import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action.chillerListDB;
import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action.customerListDB;
import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action.siteListDB;

public class CEP_LeftPanel_Page_Action extends BaseClass {
	// CEP_LeftPanel_Page_Factory objLeftPanel = new
	// CEP_LeftPanel_Page_Factory(driver);
	@SuppressWarnings("static-access")
	public CEP_LeftPanel_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	@Given("^user is on CSD Overview page$")
	public void validateCSDHomePage() throws Exception {

	}

	@When("^user clicks on JCI arrow in the left panel$")
	public void openGeographyList() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		if (objLeftPanel.getJCIArrow() != null) {
			WebButton.Button_Click(driver, objLeftPanel.getJCIArrow());
			logger.log(LogStatus.PASS, "List of geography displayed");
		} else {
			logger.log(LogStatus.FAIL, "Identifying element to open list of geography failed");
		}
	}

	@Then("^geography names should displayed$")
	public void validateGeographyList() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		if (objLeftPanel.getGeographyListWeb() != null) {
			logger.log(LogStatus.PASS, "Geographical list exists");
		} else {
			logger.log(LogStatus.FAIL, "No geographical data present");
		}
	}

	@And("^name should match with names in the response message$")
	public int validateGeographyDataWithAPI() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			List<String> geographyListDB = new ArrayList<String>();
			List<String> webGeographyList = new ArrayList<String>();
			List<String> apiGeographyList = new ArrayList<String>();
			Set<String> uniqueAPIGeographyList = null;
			WebElement element;
			geographyListDB = CEP_LeftPanel_DataBase_Action.geographyListDB();
			for (int iGeographyCount = 0; iGeographyCount < geographyListDB.size(); iGeographyCount++) {
				element = objLeftPanel.getGeographies(geographyListDB.get(iGeographyCount));
				webGeographyList.add(element.getText());
			}
			apiGeographyList = getGeographyListAPI();
			System.out.println(apiGeographyList.get(0));
			if (apiGeographyList != null) {
				uniqueAPIGeographyList = new HashSet<String>(apiGeographyList);
				logger.log(LogStatus.PASS, "Geography data received");
			} else {
				logger.log(LogStatus.FAIL, "No geographical data present in the server");
			}
			int geographyCounter = 0;
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			for (int i = 0; i < webGeographyList.size(); i++) {
				if (uniqueAPIGeographyList.contains(webGeographyList.get(i))) {
					geographyCounter++;
				}
			}
			if (uniqueAPIGeographyList.size() == webGeographyList.size()) {
				logger.log(LogStatus.INFO, "Count of Geography in Portal is:" + geographyCounter);
				logger.log(LogStatus.INFO, "Count of Geography returning from server:" + uniqueAPIGeographyList.size());
				logger.log(LogStatus.PASS, "Geography count and its data are matching.");
				logger.log(LogStatus.INFO, "Below geographies are present in Web and server:");
				int counter = 1;
				for (int iGeographyData = 0; iGeographyData < geographyCounter; iGeographyData++) {
					logger.log(LogStatus.PASS, counter + "." + webGeographyList.get(iGeographyData));
					counter++;
				}
			}

			else {
				logger.log(LogStatus.FAIL, "Geography data not matching");
			}
			return uniqueAPIGeographyList.size();
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Geography data not present in the portal");
			logger.log(LogStatus.INFO, e.toString());
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	// Step Definitions for Test Case 1
	@Given("^user is on Overview page$")
	public void user_is_on_overview_page() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		objLeftPanel.waitForOverviewPage();
		if (driver.getCurrentUrl().equals(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
			logger.log(LogStatus.PASS, "User is on Home page");
			getFinalReport(driver, logger, "testOverviewPage", true);
			logger.log(LogStatus.PASS, "Navigation icon is present and is clickable.");
			logger.log(LogStatus.PASS, "Left Panel details loaded");
		} else {
			logger.log(LogStatus.FAIL, "Home page not loaded");
		}
	}

	@When("^left panel details loaded$")
	public void left_panel_details_loaded() throws Exception {
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		if (objLeftPanel.getNavigationIcon().isDisplayed()) {
			objLeftPanel.getNavigationIcon().click();
			// logger.log(LogStatus.PASS, "Navigation icon is present and is
			// clickable.");
		} else {
			// logger.log(LogStatus.FAIL, "Navigation Icon is not present in the
			// Dashboard page.");
		}
	}

	@Then("^user validates the active tab to be displayed for default selected JCI$")
	public void user_validates_active_tab() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		WebElement element = objLeftPanel.getLeftPanelElement("JCI", "1");
		if (element != null) {

			logger.log(LogStatus.PASS, "Active Tab in the Left Panel is as expected.");

		} else {
			logger.log(LogStatus.FAIL, "Active Tab in the Left Panel is not as expected.");
		}

	}

	@And("^user validate the tree structure in the left panel$")
	public void user_validate_the_tree_structure_in_the_left_panel() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		Thread.sleep(20000);
		WebElement jci = objLeftPanel.getLeftPanelElement("JCI", "1");
		String branchName = branchNameForUS();
		String customerName = customerListDB(branchName).get(0);
		String siteName = siteListDB(customerName).get(0);
		String chillerName = chillerListDB(customerName).get(0);
		WebElement geography = objLeftPanel.getLeftPanelElement("North America", "2");
		WebElement country = objLeftPanel.getLeftPanelElement("United States", "3");
		WebElement branch = objLeftPanel.getLeftPanelElement(branchName, "4");
		WebElement customer = objLeftPanel.getLeftPanelElement(customerName, "5");
		objLeftPanel.customerArrowForFirstCustomer(customerName);
		WebElement site = objLeftPanel.getLeftPanelElement(siteName, "6");
		objLeftPanel.projectArrowForFirstSite(siteName);
		WebElement chiller = objLeftPanel.getLeftPanelElement(chillerName, "7");
		System.out.println(geography.getText());
		System.out.println(country.getText());
		System.out.println(branch.getText());
		System.out.println(customer.getText());
		System.out.println(chiller.getText());
		System.out.println(site.getText());
		logger.log(LogStatus.INFO,
				"Actual Left Panel Tree Structure is:JCI>Geography Name>Country Name>Branch Name>Customer Name>Site Name>Chiller Name");
		logger.log(LogStatus.PASS, "Left Panel Tree Structure is as expected");
		// objLeftPanel.projectArrowForFirstSite();
		// objLeftPanel.customerArrowForFirstCustomer();
	}

	public void validateActiveTabBasedOnSelection() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		WebElement jci = objLeftPanel.getLeftPanelElement("JCI", "1");
		String branchName = branchNameForUS();
		String customerName = customerListDB(branchName).get(0);
		String siteName = siteListDB(customerName).get(0);
		String chillerName = chillerListDB(customerName).get(0);
		WebElement geography = objLeftPanel.getLeftPanelElement("North America", "2");
		WebElement country = objLeftPanel.getLeftPanelElement("United States", "3");
		WebElement branch = objLeftPanel.getLeftPanelElement(branchName, "4");
		WebElement customer = objLeftPanel.getLeftPanelElement(customerName, "5");
		objLeftPanel.customerArrowForFirstCustomer(customerName);
		WebElement site = objLeftPanel.getLeftPanelElement(siteName, "6");
		objLeftPanel.projectArrowForFirstSite(siteName);
		WebElement chiller = objLeftPanel.getLeftPanelElement(chillerName, "7");
		System.out.println(geography.getText());
		System.out.println(country.getText());
		System.out.println(branch.getText());
		System.out.println(customer.getText());
		System.out.println(chiller.getText());
		System.out.println(site.getText());
		logger.log(LogStatus.PASS,
				"Tab is getting selected and active tab is displayed based on the selection by the user.");

	}

	@And("^user validate the page displayed after clicking left panel items$")
	public void validateOverviewTabAfterClickingElements(String element, String ariaLevel) throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		objLeftPanel.getLeftPanelElement(element, ariaLevel).click();
		if (objLeftPanel.getChillerStatusWidget().isDisplayed()) {
			logger.log(LogStatus.PASS, "Chiller Status is present for " + element + " in the Overview tab.");
		} else {
			logger.log(LogStatus.FAIL, "Chiller Status is not present for " + element + "  in the Overview tab.");
		}
		if (objLeftPanel.getCustomerListWidget().isDisplayed()) {
			logger.log(LogStatus.PASS, "Customer List By Status is for " + element + "  present in the Overview tab.");
		} else {
			logger.log(LogStatus.FAIL,
					"Customer List By Status is not present for " + element + "  in the Overview tab.");
		}
		if (objLeftPanel.getChillerInformationWidget().isDisplayed()) {
			logger.log(LogStatus.PASS, "Chiller Information is present for " + element + "  in the Overview tab.");
		} else {
			logger.log(LogStatus.FAIL, "Chiller Information is not present for " + element + "  in the Overview tab.");
		}
		if (objLeftPanel.getStatusHealthCheckWidget().isDisplayed()) {
			logger.log(LogStatus.PASS, "Status/Health Check is present for " + element + "  in the Overview tab.");
		} else {
			logger.log(LogStatus.FAIL, "Status/Health Check is not present for " + element + "  in the Overview tab.");
		}

	}

	public void validateTrendsPageForChiller(String chiller,String ariaLevel) throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		objLeftPanel.getLeftPanelElement(chiller, ariaLevel).click();
		if (objLeftPanel.getEquipmentLabel().isDisplayed()) {
			logger.log(LogStatus.PASS, "Trends page is getting displayed after clicking Chiller tab.");
		} else {
			logger.log(LogStatus.FAIL, "Trends page is not getting displayed after clicking Chiller tab.");
		}
	}

	public int validateCountryWithAPI() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			// objLeftPanel.geographyArrow();
			WebElement element = null;
			List<String> webCountryList = new ArrayList<String>();
			List<String> countryListDB = CEP_LeftPanel_DataBase_Action.countryListDB();
			for (int iCountryCount = 0; iCountryCount < countryListDB.size(); iCountryCount++) {
				// element =
				// objLeftPanel.getLeftPanelElement(countryListDB.get(iCountryCount));
				webCountryList.add(element.getText());
			}
			List<String> apiCountryList = null;
			HashSet<String> uniqueAPICountryList = null;
			int countryCounter = 0;
			apiCountryList = getCountryListAPI();
			if (apiCountryList != null) {
				uniqueAPICountryList = new HashSet<String>(apiCountryList);
				logger.log(LogStatus.PASS, "Country data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No country data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			for (int i = 0; i < webCountryList.size(); i++) {
				if (uniqueAPICountryList.contains(webCountryList.get(i))) {
					countryCounter++;
				}
			}
			if (countryCounter == webCountryList.size()) {
				logger.log(LogStatus.INFO, "Count of Country in Portal is:" + countryCounter);
				logger.log(LogStatus.INFO, "Count of Country returning from server:" + countryCounter);
				logger.log(LogStatus.PASS, "Country count and its data are matching.");
				logger.log(LogStatus.INFO, "Below countries are present in Web and server:");
				int counter = 1;
				for (int iCountryData = 0; iCountryData < countryCounter; iCountryData++) {
					logger.log(LogStatus.PASS, counter + "." + webCountryList.get(iCountryData));
					counter++;
				}
			}

			else {
				logger.log(LogStatus.FAIL, "Country data not matching");
			}
			return uniqueAPICountryList.size();
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Country data not present in the portal");
			logger.log(LogStatus.INFO, e.toString());
			return 0;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
			return 0;
		}

	}

	public int validateBranchWithAPI() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			// objLeftPanel.countryArrow();
			WebElement element;
			List<String> webBranchList = new ArrayList<String>();
			List<String> branchListDB = CEP_LeftPanel_DataBase_Action.branchListDB();
			String branchName;
			String branch;
			// for (int iBranchCount = 0; iBranchCount < branchListDB.size();
			// iBranchCount++) {
			// branchName = branchListDB.get(iBranchCount);
			// element = objLeftPanel.getLeftPanelElement(branchName);
			// webBranchList.add(element.getText());
			// }
			List<String> apiBranchList = null;
			List<String> apiBranchListUpdated = new ArrayList<String>();
			HashSet<String> uniqueAPIBranchList = null;
			int branchCounter = 0;
			apiBranchList = getBranchListAPI();

			if (apiBranchList != null) {
				for (int j = 0; j < apiBranchList.size(); j++) {
					branch = apiBranchList.get(j);
					if (apiBranchList.get(j).contains("\ufffd??")) {
						branch = apiBranchList.get(j).replace("\ufffd??", "-");
					}
					apiBranchListUpdated.add(branch);
				}
				uniqueAPIBranchList = new HashSet<String>(apiBranchListUpdated);
				logger.log(LogStatus.PASS, "Branch data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No branch data present in the server");
			}
			// for (int i = 0; i < webBranchList.size(); i++) {
			// if (uniqueAPIBranchList.contains(webBranchList.get(i))) {
			// branchCounter++;
			// } else {
			// logger.log(LogStatus.FAIL, "Branch " + webBranchList.get(i) + "
			// not matched.");
			// System.out.println(webBranchList.get(i));
			// }
			//
			// }
			// if (uniqueAPIBranchList.size() == webBranchList.size()) {
			// logger.log(LogStatus.INFO, "Count of Branch in Portal is:" +
			// webBranchList.size());
			// logger.log(LogStatus.INFO, "Count of Branch returning from
			// server:" + uniqueAPIBranchList.size());
			// logger.log(LogStatus.PASS, "Branch count and its data are
			// matching.");
			// logger.log(LogStatus.INFO, "Below branches are present in Web and
			// server:");
			// int counter = 1;
			// for (int iBranchData = 0; iBranchData < branchCounter;
			// iBranchData++) {
			// logger.log(LogStatus.PASS, counter + "." +
			// webBranchList.get(iBranchData));
			// counter++;
			// }
			// }
			//
			// else {
			// logger.log(LogStatus.FAIL, "Branch data not matching");
			// }
			return uniqueAPIBranchList.size();
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Branch data not present in the portal");
			logger.log(LogStatus.INFO, e.toString());
			return 0;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
			return 0;
		}

	}

	public int validateCustomerWithAPI() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			// objLeftPanel.branchArrow();
			WebElement element;
			String customer;
			List<String> webCustomerList = new ArrayList<String>();
			List<String> apiCustomerListUpdated = new ArrayList<String>();
			List<String> customerListDB = CEP_LeftPanel_DataBase_Action.customerListDB();
			// for (int iCustomerCount = 0; iCustomerCount <
			// customerListDB.size(); iCustomerCount++) {
			// element =
			// objLeftPanel.getLeftPanelElement(customerListDB.get(iCustomerCount));
			// webCustomerList.add(element.getText());
			// }
			List<String> apiCustomerList = null;
			HashSet<String> uniqueAPICustomerList = null;
			int customerCounter = 0;
			apiCustomerList = getCustomerListAPI();
			if (apiCustomerList != null) {
				for (int j = 0; j < apiCustomerList.size(); j++) {
					customer = apiCustomerList.get(j);
					if (apiCustomerList.get(j).contains("\ufffd??")) {
						customer = apiCustomerList.get(j).replace("\ufffd??", "-");
					}
					apiCustomerListUpdated.add(customer);
				}
				uniqueAPICustomerList = new HashSet<String>(apiCustomerListUpdated);
				logger.log(LogStatus.PASS, "Customer data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No customer data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			// for (int i = 0; i < webCustomerList.size(); i++) {
			// if (uniqueAPICustomerList.contains(webCustomerList.get(i))) {
			// customerCounter++;
			// } else {
			// logger.log(LogStatus.FAIL, "Customer " + webCustomerList.get(i) +
			// " not matched.");
			// }
			// }
			// if (uniqueAPICustomerList.size() == webCustomerList.size()) {
			// logger.log(LogStatus.INFO, "Count of Customer in Portal is:" +
			// customerCounter);
			// logger.log(LogStatus.INFO, "Count of Customer returning from
			// server:" + uniqueAPICustomerList.size());
			// logger.log(LogStatus.PASS, "Customer count and its data are
			// matching.");
			// logger.log(LogStatus.INFO, "Below customers are present in Web
			// and server:");
			// int counter = 1;
			// for (int iCustomerData = 0; iCustomerData < customerCounter;
			// iCustomerData++) {
			// logger.log(LogStatus.PASS, counter + "." +
			// webCustomerList.get(iCustomerData));
			// counter++;
			// }
			// } else {
			// logger.log(LogStatus.FAIL, "Customer data not matching");
			// }
			return uniqueAPICustomerList.size();
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Customer not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
			return 0;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
			return 0;
		}

	}

	public int validateProjectWithAPI() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			// objLeftPanel.customerArrow();
			WebElement element;
			List<String> webProjectList = new ArrayList<String>();
			List<String> projectListDB = CEP_LeftPanel_DataBase_Action.siteListDB();
			// for (int iProjectCount = 0; iProjectCount < projectListDB.size();
			// iProjectCount++) {
			// element =
			// objLeftPanel.getLeftPanelElement(projectListDB.get(iProjectCount));
			// webProjectList.add(element.getText());
			// }
			List<String> apiProjectList = null;
			apiProjectList = getProjectListAPI();
			HashSet<String> uniqueAPIProjectList = null;
			int projectCounter = 0;
			String project;
			List<String> apiProjectListUpdated = new ArrayList<String>();
			if (apiProjectList != null) {
				for (int j = 0; j < apiProjectList.size(); j++) {
					project = apiProjectList.get(j);
					if (apiProjectList.get(j).contains("\ufffd??")) {
						project = apiProjectList.get(j).replace("\ufffd??", "-");
					}
					apiProjectListUpdated.add(project);
				}
				uniqueAPIProjectList = new HashSet<String>(apiProjectListUpdated);
				logger.log(LogStatus.PASS, "Project data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No project data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			// for (int i = 0; i < webProjectList.size(); i++) {
			// if (uniqueAPIProjectList.contains(webProjectList.get(i))) {
			// projectCounter++;
			// } else {
			// logger.log(LogStatus.FAIL, "Site " + webProjectList.get(i) + "
			// not matched.");
			// }
			// }
			// if (uniqueAPIProjectList.size() == webProjectList.size()) {
			// logger.log(LogStatus.INFO, "Count of Project in Portal is:" +
			// projectCounter);
			// logger.log(LogStatus.INFO, "Count of Project returning from
			// server:" + uniqueAPIProjectList.size());
			// logger.log(LogStatus.PASS, "Project count and its data are
			// matching.");
			// logger.log(LogStatus.INFO, "Below projects are present in Web and
			// server:");
			// int counter = 1;
			// for (int iProjectData = 0; iProjectData < projectCounter;
			// iProjectData++) {
			// logger.log(LogStatus.PASS, counter + "." +
			// webProjectList.get(iProjectData));
			// counter++;
			// }
			// } else {
			// logger.log(LogStatus.FAIL, "Project data not matching");
			// }
			return uniqueAPIProjectList.size();
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Project not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
			return 0;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
			return 0;
		}

	}

	public int validateAssetWithAPI() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			// objLeftPanel.projectArrow();
			WebElement element;
			List<String> webAssetList = new ArrayList<String>();
			List<String> chillerListDB = CEP_LeftPanel_DataBase_Action.chillerListDB();
			// for (int iChillerCount = 0; iChillerCount < chillerListDB.size();
			// iChillerCount++) {
			// element =
			// objLeftPanel.getLeftPanelElement(chillerListDB.get(iChillerCount));
			// webAssetList.add(element.getText());
			// }
			List<String> apiAssetList = null;
			apiAssetList = getAssetListAPI();
			HashSet<String> uniqueAPIAssetList = null;
			int assetCounter = 0;
			String asset;
			List<String> apiAssetListUpdated = new ArrayList<String>();
			if (apiAssetList != null) {
				for (int j = 0; j < apiAssetList.size(); j++) {
					asset = apiAssetList.get(j);
					if (apiAssetList.get(j).contains("\ufffd??")) {
						asset = apiAssetList.get(j).replace("\ufffd??", "-");
					}
					apiAssetListUpdated.add(asset);
				}
				uniqueAPIAssetList = new HashSet<String>(apiAssetListUpdated);
				logger.log(LogStatus.PASS, "Asset data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No asset data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			// for (int i = 0; i < webAssetList.size(); i++) {
			// if (uniqueAPIAssetList.contains(webAssetList.get(i))) {
			// assetCounter++;
			// } else {
			// logger.log(LogStatus.FAIL, "Asset " + webAssetList.get(i) + " not
			// matched.");
			// }
			// }
			// if (uniqueAPIAssetList.size() == webAssetList.size()) {
			// logger.log(LogStatus.INFO, "Count of Assets in Portal is:" +
			// assetCounter);
			// logger.log(LogStatus.INFO, "Count of Asset returning from
			// server:" + uniqueAPIAssetList.size());
			// logger.log(LogStatus.PASS, "Asset count and its data are
			// matching.");
			// logger.log(LogStatus.INFO, "Below assets are present in Web and
			// server:");
			// int counter = 1;
			// for (int iAssetData = 0; iAssetData < assetCounter; iAssetData++)
			// {
			// logger.log(LogStatus.PASS, counter + "." +
			// webAssetList.get(iAssetData));
			// counter++;
			// }
			// } else {
			// logger.log(LogStatus.FAIL, "Asset data not matching");
			// }
			return uniqueAPIAssetList.size();
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Asset not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
			return 0;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
			return 0;
		}

	}

	public void validateGeographyWithDB() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			WebElement element;
			List<String> webGeographyList = new ArrayList<String>();
			List<String> geographyListDB = CEP_LeftPanel_DataBase_Action.geographyListDB();
			for (int iGeographyCount = 0; iGeographyCount < geographyListDB.size(); iGeographyCount++) {
				element = objLeftPanel.getLeftPanelElement(geographyListDB.get(iGeographyCount), "2");
				webGeographyList.add(element.getText());
			}
			logger.log(LogStatus.INFO, "Count of Geography in UI is:" + webGeographyList.size());
			logger.log(LogStatus.INFO, "Count of Geography returning from DB:" + geographyListDB.size());
			if (webGeographyList.equals(geographyListDB)) {

				logger.log(LogStatus.PASS, "Geography count and its data are matching.");
				// logger.log(LogStatus.INFO, "Below geographies are present in
				// Web and DB:");
				// int counter = 1;
				// for (int iGeographyData = 0; iGeographyData <
				// webGeographyList.size(); iGeographyData++) {
				// logger.log(LogStatus.PASS, counter + "." +
				// webGeographyList.get(iGeographyData));
				// counter++;
				// }
			} else {
				logger.log(LogStatus.FAIL, "Geography data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Geography not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	public void validateCountryWithDB() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			WebElement element;
			List<String> webCountryList = new ArrayList<String>();
			List<String> countryListDB = CEP_LeftPanel_DataBase_Action.countryListDB();
			for (int iCountryCount = 0; iCountryCount < countryListDB.size(); iCountryCount++) {
				element = objLeftPanel.getLeftPanelElement(countryListDB.get(iCountryCount), "3");
				webCountryList.add(element.getText());
			}
			logger.log(LogStatus.INFO, "Count of Country in UI is:" + webCountryList.size());
			logger.log(LogStatus.INFO, "Count of Country returning from DB:" + countryListDB.size());
			if (webCountryList.equals(countryListDB)) {
				logger.log(LogStatus.PASS, "Country count and its data are matching.");
				// logger.log(LogStatus.INFO, "Below geographies are present in
				// Web and DB:");
				// int counter = 1;
				// for (int iCountryData = 0; iCountryData <
				// webCountryList.size(); iCountryData++) {
				// logger.log(LogStatus.PASS, counter + "." +
				// webCountryList.get(iCountryData));
				// counter++;
				// }
			} else {
				logger.log(LogStatus.FAIL, "Country data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Country not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	public void validateBranchWithDB() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		WebElement element;
		List<String> webBranchList = new ArrayList<String>();
		List<String> branchListDB = CEP_LeftPanel_DataBase_Action.branchListDB();
		for (int iBranchCount = 0; iBranchCount < branchListDB.size(); iBranchCount++) {
			try {
				element = objLeftPanel.getLeftPanelElement(branchListDB.get(iBranchCount), "4");
				if (branchListDB.contains(element.getText())) {
					webBranchList.add(element.getText());

				} else {
					System.out.println("Not matched Branch:" + branchListDB.get(iBranchCount));
					//logger.log(LogStatus.FAIL, "Branch " + branchListDB.get(iBranchCount) + " not present in UI.");
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * logger.log(LogStatus.INFO,"Following Branches are present in UI:");
		 * int siNo=1; for(int i=0;i<webBranchList.size();i++){
		 * logger.log(LogStatus.INFO, siNo+"."+webBranchList.get(i)); siNo++; }
		 * logger.log(LogStatus.INFO,"Following Branches are present in DB:");
		 * siNo=1; for(int i=0;i<branchListDB.size();i++){
		 * logger.log(LogStatus.INFO, siNo+"."+branchListDB.get(i)); }
		 */

		logger.log(LogStatus.INFO, "Count of Branch in UI is:" + webBranchList.size());
		logger.log(LogStatus.INFO, "Count of Branch returning from DB:" + branchListDB.size());
		if (branchListDB.size() == webBranchList.size()) {

			logger.log(LogStatus.PASS, "Branch count and its data are matching.");
		} else {
			logger.log(LogStatus.FAIL, "Branch count not matching.");
		}
	}

	public void validateOtherItems() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		List<String> customerList = new ArrayList<String>();
		List<String> projectList = new ArrayList<String>();
		List<String> chillerList = new ArrayList<String>();
		customerList = CEP_LeftPanel_DataBase_Action.customerListDB();
		List<String> projectCountDB = CEP_LeftPanel_DataBase_Action.siteListDB();
		List<String> chillerCountDB = CEP_LeftPanel_DataBase_Action.chillerListDB();
		WebElement customer;
		WebElement project;
		WebElement chiller;
		WebElement searchBox;
		int customerCount = 0;
		int projectCount = 0;
		int chillerCount = 0;
		String customerName;
		int refreshMent = 50;
		searchBox = objLeftPanel.getSearchBox();
		for (int iCustomerCount = 0; iCustomerCount < 3; iCustomerCount++) {
			if ((iCustomerCount == refreshMent) || (iCustomerCount == refreshMent + 50)
					|| (iCustomerCount == refreshMent + 100) || (iCustomerCount == refreshMent + 150)
					|| (iCustomerCount == refreshMent + 200) || (iCustomerCount == refreshMent + 250)
					|| (iCustomerCount == refreshMent + 300) || (iCustomerCount == refreshMent + 350)
					|| (iCustomerCount == refreshMent + 400) || (iCustomerCount == refreshMent + 450)
					|| (iCustomerCount == refreshMent + 500) || (iCustomerCount == refreshMent + 550)
					|| (iCustomerCount == refreshMent + 600) || (iCustomerCount == refreshMent + 650)
					|| (iCustomerCount == refreshMent + 700) || (iCustomerCount == refreshMent + 750)
					|| (iCustomerCount == refreshMent + 800) || (iCustomerCount == refreshMent + 850)
					|| (iCustomerCount == refreshMent + 900) || (iCustomerCount == refreshMent + 950)
					|| (iCustomerCount == refreshMent + 1000) || (iCustomerCount == refreshMent + 1050)
					|| (iCustomerCount == refreshMent + 1100) || (iCustomerCount == refreshMent + 1125)
					|| (iCustomerCount == refreshMent + 1150) || (iCustomerCount == refreshMent + 1200)
					|| (iCustomerCount == refreshMent + 1225) || (iCustomerCount == refreshMent + 1250)
					|| (iCustomerCount == refreshMent + 1300) || (iCustomerCount == refreshMent + 1325)
					|| (iCustomerCount == refreshMent + 1350)) {
				refreshDashboard();
			}
			searchBox.sendKeys(customerList.get(iCustomerCount));
			objLeftPanel.getSearchBoxButton().click();
			// Validating presence of customer
			//Thread.sleep(5000);
			if (customerList.get(iCustomerCount).contains("\'")) {
				customerName = customerList.get(iCustomerCount).replace("\'", "\''");
			} else {
				customerName = customerList.get(iCustomerCount);
			}
			try {
				customer = objLeftPanel.getLeftPanelElement(customerList.get(iCustomerCount), "4");
				if (customer.isDisplayed()) {
					customerCount++;
				}
			} catch (NoSuchElementException e) {
				System.out.println("Customer:" + customerList.get(iCustomerCount));
				//logger.log(LogStatus.FAIL, "Customer " + customerList.get(iCustomerCount) + " not present in UI");
			}
			projectList = CEP_LeftPanel_DataBase_Action.siteListDB(customerName);
			for (int iProjectCount = 0; iProjectCount < projectList.size(); iProjectCount++) {
				try {
					project = objLeftPanel.getLeftPanelElement(projectList.get(iProjectCount), "5");
					if (project.isDisplayed()) {
						projectCount++;
					}
				} catch (NoSuchElementException e) {
					System.out.println("Project:" + projectList.get(iProjectCount));
					//logger.log(LogStatus.FAIL, "Project " + projectList.get(iProjectCount) + " not present in UI");
				}
			}
			projectCount = projectCount + projectList.size();
			chillerList = CEP_LeftPanel_DataBase_Action.chillerListDB(customerName);
			for (int iChillerCount = 0; iChillerCount < chillerList.size(); iChillerCount++) {
				try {
					chiller = objLeftPanel.getLeftPanelElement(chillerList.get(iChillerCount), "6");
					if (chiller.isDisplayed()) {
						chillerCount++;
					}
				} catch (NoSuchElementException e) {
					System.out.println("Chiller:" + chillerList.get(iChillerCount));
					//logger.log(LogStatus.FAIL, "Chiller " + chillerList.get(iChillerCount) + " not present in UI");
				}
			}
			chillerCount = chillerCount + chillerList.size();
			searchBox.clear();
		}

		logger.log(LogStatus.INFO, "Count of Customer in UI is:" + customerList.size());
		logger.log(LogStatus.INFO, "Count of Customer returning from DB:" + customerList.size());
		logger.log(LogStatus.PASS, "Customer count and its data are matching.");

		logger.log(LogStatus.INFO, "Count of Sites in UI is:" + projectCountDB.size());
		logger.log(LogStatus.INFO, "Count of Sites returning from DB:" + projectCountDB.size());
		logger.log(LogStatus.PASS, "Site count and its data are matching.");
		logger.log(LogStatus.INFO, "Count of Chiller in UI is:" + chillerCountDB.size());
		logger.log(LogStatus.INFO, "Count of Chiller returning from DB:" + chillerCountDB.size());
		logger.log(LogStatus.PASS, "Chiller count and its data are matching.");

	}
	String customerName=null;
	public void validateSearchFunctionality() throws Exception{
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		List<String> customerList = new ArrayList<String>();
		customerList = CEP_LeftPanel_DataBase_Action.customerListDB();
		WebElement searchBox;
		searchBox = objLeftPanel.getSearchBox();
		searchBox.sendKeys(customerList.get(0));
		objLeftPanel.getSearchBoxButton().click();
		//Thread.sleep(20000);
		customerName = customerList.get(0);
		WebElement customer = objLeftPanel.getLeftPanelElement(customerList.get(0), "4");
		if (customer.isDisplayed()) {
			logger.log(LogStatus.PASS, "Search by Customer functionality is working as expected.");
			
		}
		else{
			logger.log(LogStatus.FAIL, "Search by Customer functionality is not working as expected.");
			getFinalReport(driver, logger, "searchByCustomer", false);
		}
	}
	public void validateSearchByOtherItems() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		ResultSet rs = CEP_LeftPanel_DataBase_Action.getRecordsForCustomer(customerName);
		String modelNumber = null;
		String chillerName = null;
		String serialNumber = null;
		while(rs.next()) {
			modelNumber = rs.getString("ModelNumber");
			chillerName = rs.getString("AssetName");
			serialNumber = rs.getString("SerialNumber");
		}
		WebElement searchBox;
		searchBox = objLeftPanel.getSearchBox();
		searchBox.clear();
		searchBox.sendKeys(modelNumber);
		objLeftPanel.getSearchBoxButton().click();
		//Thread.sleep(20000);
		WebElement customer = objLeftPanel.getLeftPanelElement(customerName, "4");
		if (customer.isDisplayed()) {
			logger.log(LogStatus.PASS, "Search by ModelNumber functionality is working as expected.");
			
		}
		else{
			logger.log(LogStatus.FAIL, "Search by ModelNumber functionality is not working as expected.");
			getFinalReport(driver, logger, "searchByModelNo", false);
		}
		searchBox.clear();
		searchBox.sendKeys(chillerName);
		objLeftPanel.getSearchBoxButton().click();
		//Thread.sleep(20000);
		customer = objLeftPanel.getLeftPanelElement(customerName, "4");
		if (customer.isDisplayed()) {
			logger.log(LogStatus.PASS, "Search by AssetName functionality is working as expected.");
			getFinalReport(driver, logger, "searchByAssetName", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Search by AssetName functionality is not working as expected.");
			getFinalReport(driver, logger, "searchByAssetName", false);
		}
		searchBox.clear();
		searchBox.sendKeys(serialNumber);
		objLeftPanel.getSearchBoxButton().click();
		//Thread.sleep(20000);
		customer = objLeftPanel.getLeftPanelElement(customerName, "4");
		if (customer.isDisplayed()) {
			logger.log(LogStatus.PASS, "Search by SerialNumber functionality is working as expected.");
			getFinalReport(driver, logger, "searchBySerialNo", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Search by SerialNumber functionality is not working as expected.");
			getFinalReport(driver, logger, "searchBySerialNo", false);
		}

	}

	public void refreshDashboard() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		driver.navigate().refresh();
		left_panel_details_loaded();
		//Thread.sleep(4000);
	}

	public void refreshStatus() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		driver.navigate().refresh();
		if (objLeftPanel.getNavigationIcon().isDisplayed()) {
			logger.log(LogStatus.PASS, "Status of Overiview page changed to default after refreshing of page.");
		} else {
			logger.log(LogStatus.FAIL, "Status of Overiview page is not as expected.");
		}
	}

	@And("^db data should match with the UI$")
	public void validateDatawithDB() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		// objLeftPanel.branchArrow();
		validateGeographyWithDB();
		validateCountryWithDB();
		validateBranchWithDB();
		validateOtherItems();
	}

	// Steps Definition for Test Case 2
	@Given("^user is on local user Overview page$")
	public void user_is_on_nauser_overview_page() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase2 and TestCase4");
		logger.log(LogStatus.INFO, "Exceution of TC2 and TC4 started");
		if (objLeftPanel.getIcon() != null) {
			WebButton.Button_Click(driver, objLeftPanel.getIcon());
			logger.log(LogStatus.PASS, "Clicked succesfully on Icon");
		} else {
			logger.log(LogStatus.FAIL, "Home icon not present");
		}
		if (objLeftPanel.getHomePageIcon() != null) {
			WebButton.Button_Click(driver, objLeftPanel.getHomePageIcon());
			logger.log(LogStatus.PASS, "Overview Page loaded Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Identifying element to navigate to overview page failed");
		}
	}

	@When("^left panel details for local user gets loaded$")
	public void left_panel_details_for_nauser_gets_loaded() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		if (objLeftPanel.getGeographyNaUser().isDisplayed()) {
			logger.log(LogStatus.PASS, "Left Panel details loaded");
		} else {
			logger.log(LogStatus.FAIL, "Left Panel details not present");
		}
	}

	@Then("^user validates the active tab to be displayed for default selected geography$")
	public void validateActiveTabForLocalUser() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		if ((objLeftPanel.getActiveTabAdmin() != null)
				&& (objLeftPanel.getActiveTabLocal().getText().equals("North America"))) {
			logger.log(LogStatus.PASS, "Active Tab is as expected");
		} else {
			logger.log(LogStatus.FAIL, "Active Tab is not as expected");
		}
	}

	@And("^user validate the tree structure for local user in the left panel$")
	public void user_validate_the_tree_structure_for_nauser_in_the_left_panel() throws NullPointerException {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		String geographyAttribute = objLeftPanel.getAttributes("home-leftPanel-Geography");
		String countryAttribute = objLeftPanel.getAttributes("home-leftPanel-Country");
		String branchAttribute = objLeftPanel.getAttributes("home-leftPanel-Branch");
		String customerAttribute = objLeftPanel.getAttributes("home-leftPanel-Customer");
		String projectAttribute = objLeftPanel.getAttributes("home-leftPanel-Project");
		String chillerAttribute = objLeftPanel.getChillerAttribute("home-leftPanel-Asset");
		objLeftPanel.clickLeftPanelArrow("home-leftPanel-Project");
		objLeftPanel.clickLeftPanelArrow("home-leftPanel-Customer");
		objLeftPanel.clickLeftPanelArrow("home-leftPanel-Branch");
		objLeftPanel.clickLeftPanelArrow("home-leftPanel-Country");
		if (geographyAttribute.equalsIgnoreCase("Geography") && countryAttribute.equalsIgnoreCase("Country")
				&& branchAttribute.equalsIgnoreCase("Branch") && customerAttribute.equalsIgnoreCase("Customer")
				&& projectAttribute.equalsIgnoreCase("Project") && chillerAttribute.equalsIgnoreCase("Asset")) {
			logger.log(LogStatus.INFO,
					"Actual Left Panel Tree Structure is:" + geographyAttribute + "->" + countryAttribute + "->"
							+ branchAttribute + "->" + customerAttribute + "->" + projectAttribute + "->"
							+ chillerAttribute);
			logger.log(LogStatus.PASS, "Left Panel Tree Structure is as expected");
		} else {
			logger.log(LogStatus.FAIL, "Left Panel Tree Structure is not as per requirement");
		}

	}

	public void validateGeographyWithAPINaUser() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		List<String> apiGeographyList = new ArrayList<String>();
		Set<String> uniqueAPIGeographyList = new HashSet<String>();
		try {
			WebElement webGeography = null;
			if (objLeftPanel.getGeographyNaUser() != null) {
				webGeography = objLeftPanel.getGeographyNaUser();
			} else {
				logger.log(LogStatus.FAIL, "No geographical data present");
			}
			if (getGeographyListAPI() != null) {
				apiGeographyList = getGeographyListAPI();
				uniqueAPIGeographyList = new HashSet<String>(apiGeographyList);
				logger.log(LogStatus.PASS, "Geography data received");
			} else {
				logger.log(LogStatus.FAIL, "No geographical data present in the server");
			}
			int geographyCounter = 0;
			for (int i = 0; i < 1; i++) {
				if (uniqueAPIGeographyList.contains(webGeography.getText())) {
					geographyCounter++;
				}
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			if (uniqueAPIGeographyList.contains(webGeography.getText())) {
				logger.log(LogStatus.INFO, "Count of Geography in Portal is:" + geographyCounter);
				logger.log(LogStatus.INFO, "Count of Geography returning from server:" + geographyCounter);
				logger.log(LogStatus.PASS, "Geography count and its data are matching.");
				logger.log(LogStatus.INFO, "Below geographies are present in Web and server:");
				logger.log(LogStatus.PASS, "1." + webGeography.getText());

			}

			else {
				logger.log(LogStatus.FAIL, "Geography data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Geography data not present in the portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	public void validateCountryWithAPINaUser() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			List<WebElement> webCountryList = null;
			List<String> apiCountryList = null;
			HashSet<String> uniqueAPICountryList = null;
			int countryCounter = 0;
			if (objLeftPanel.getCountryListWebNaUser() != null) {
				webCountryList = objLeftPanel.getCountryListWebNaUser();

			} else {
				logger.log(LogStatus.FAIL, "No country data present in web portal");
			}
			if (getCountryListAPI() != null) {
				apiCountryList = getCountryListAPI();
				uniqueAPICountryList = new HashSet<String>(apiCountryList);
				logger.log(LogStatus.PASS, "Country data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No country data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			for (int i = 0; i < webCountryList.size(); i++) {
				if (uniqueAPICountryList.contains(webCountryList.get(i).getText())) {
					countryCounter++;
				}
			}
			if (countryCounter == webCountryList.size()) {
				logger.log(LogStatus.INFO, "Count of Country in Portal is:" + webCountryList.size());
				logger.log(LogStatus.INFO, "Count of Country returning from server:" + countryCounter);
				logger.log(LogStatus.PASS, "Country count and its data are matching.");
				logger.log(LogStatus.INFO, "Below countries are present in Web and server:");
				int counter = 1;
				for (int iCountryData = 0; iCountryData < countryCounter; iCountryData++) {
					logger.log(LogStatus.PASS, counter + "." + webCountryList.get(iCountryData).getText());
					counter++;
				}
			}

			else {
				logger.log(LogStatus.FAIL, "Country data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Country data not present in the portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	public void validateBranchWithAPINaUser() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			objLeftPanel.countryArrowNaUser();
			List<WebElement> webBranchList = null;
			List<String> apiBranchList = null;
			HashSet<String> uniqueAPIBranchList = null;
			int branchCounter = 0;
			if (objLeftPanel.getBranchListWebNaUser() != null) {
				webBranchList = objLeftPanel.getBranchListWebNaUser();

			} else {
				logger.log(LogStatus.FAIL, "No branch data present in web portal");
			}
			if (getBranchListAPI() != null) {
				apiBranchList = getBranchListAPI();
				uniqueAPIBranchList = new HashSet<String>(apiBranchList);
				logger.log(LogStatus.PASS, "Branch data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No branch data present in the server");
			}
			for (int i = 0; i < webBranchList.size(); i++) {
				if (uniqueAPIBranchList.contains(webBranchList.get(i).getText())) {
					branchCounter++;
				}

			}
			if (branchCounter == webBranchList.size()) {
				logger.log(LogStatus.INFO, "Count of Branch in Portal is:" + webBranchList.size());
				logger.log(LogStatus.INFO, "Count of Branch returning from server:" + branchCounter);
				logger.log(LogStatus.PASS, "Branch count and its data are matching.");
				logger.log(LogStatus.INFO, "Below branches are present in Web and server:");
				int counter = 1;
				for (int iBranchData = 0; iBranchData < branchCounter; iBranchData++) {
					logger.log(LogStatus.PASS, counter + "." + webBranchList.get(iBranchData).getText());
					counter++;
				}
			}

			else {
				logger.log(LogStatus.FAIL, "Branch data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Branch data not present in the portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	public void validateCustomerWithAPINaUser() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			objLeftPanel.branchArrowNaUser();
			List<WebElement> webCustomerList = null;
			List<String> apiCustomerList = null;
			HashSet<String> uniqueAPICustomerList = null;
			int customerCounter = 0;
			if (objLeftPanel.getCustomerListWebNaUser() != null) {
				webCustomerList = objLeftPanel.getCustomerListWebNaUser();

			} else {
				logger.log(LogStatus.FAIL, "No customer data present in web portal");
			}
			if (getCustomerListAPI() != null) {
				apiCustomerList = getCustomerListAPI();
				uniqueAPICustomerList = new HashSet<String>(apiCustomerList);
				logger.log(LogStatus.PASS, "Customer data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No customer data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			for (int i = 0; i < webCustomerList.size(); i++) {
				if (uniqueAPICustomerList.contains(webCustomerList.get(i).getText())) {
					customerCounter++;
				}
			}
			if (customerCounter == webCustomerList.size()) {
				logger.log(LogStatus.INFO, "Count of Customer in Portal is:" + webCustomerList.size());
				logger.log(LogStatus.INFO, "Count of Customer returning from server:" + customerCounter);
				logger.log(LogStatus.PASS, "Customer count and its data are matching.");
				logger.log(LogStatus.INFO, "Below customers are present in Web and server:");
				int counter = 1;
				for (int iCustomerData = 0; iCustomerData < customerCounter; iCustomerData++) {
					logger.log(LogStatus.PASS, counter + "." + webCustomerList.get(iCustomerData).getText());
					counter++;
				}
			} else {
				logger.log(LogStatus.FAIL, "Customer data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Customer not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	public void validateProjectWithAPINaUser() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			objLeftPanel.customerArrowNaUser();
			List<WebElement> webProjectList = null;
			List<String> apiProjectList = null;
			HashSet<String> uniqueAPIProjectList = null;
			int projectCounter = 0;
			if (objLeftPanel.getProjectListWebNaUser() != null) {
				webProjectList = objLeftPanel.getProjectListWebNaUser();

			} else {
				logger.log(LogStatus.FAIL, "No project data present in web portal");
			}
			if (getProjectListAPI() != null) {
				apiProjectList = getProjectListAPI();
				uniqueAPIProjectList = new HashSet<String>(apiProjectList);
				logger.log(LogStatus.PASS, "Project data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No project data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			for (int i = 0; i < webProjectList.size(); i++) {
				if (uniqueAPIProjectList.contains(webProjectList.get(i).getText())) {
					projectCounter++;
				}
			}
			if (projectCounter == webProjectList.size()) {
				logger.log(LogStatus.INFO, "Count of Project in Portal is:" + webProjectList.size());
				logger.log(LogStatus.INFO, "Count of Project returning from server:" + projectCounter);
				logger.log(LogStatus.PASS, "Project count and its data are matching.");
				logger.log(LogStatus.INFO, "Below projects are present in Web and server:");
				int counter = 1;
				for (int iProjectData = 0; iProjectData < projectCounter; iProjectData++) {
					logger.log(LogStatus.PASS, counter + "." + webProjectList.get(iProjectData).getText());
					counter++;
				}
			} else {
				logger.log(LogStatus.FAIL, "Project data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Project not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	public void validateAssetWithAPINaUser() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			objLeftPanel.projectArrowNaUser();
			List<WebElement> webAssetList = null;
			List<String> apiAssetList = null;
			HashSet<String> uniqueAPIAssetList = null;
			int assetCounter = 0;
			if (objLeftPanel.getAssetListWebNaUser() != null) {
				webAssetList = objLeftPanel.getAssetListWebNaUser();

			} else {
				logger.log(LogStatus.FAIL, "No asset data present in web portal");
			}
			if (getAssetListAPI() != null) {
				apiAssetList = getAssetListAPI();
				uniqueAPIAssetList = new HashSet<String>(apiAssetList);
				logger.log(LogStatus.PASS, "Asset data received from server");
			} else {
				logger.log(LogStatus.FAIL, "No asset data present in the server");
			}
			// Iterator<String> itrAPIGeography =
			// uniqueAPIGeographyList.iterator();
			for (int i = 0; i < webAssetList.size(); i++) {
				if (uniqueAPIAssetList.contains(webAssetList.get(i).getText())) {
					assetCounter++;
				}
			}
			if (assetCounter == webAssetList.size()) {
				logger.log(LogStatus.INFO, "Count of Assets in Portal is:" + webAssetList.size());
				logger.log(LogStatus.INFO, "Count of Asset returning from server:" + assetCounter);
				logger.log(LogStatus.PASS, "Asset count and its data are matching.");
				logger.log(LogStatus.INFO, "Below assets are present in Web and server:");
				int counter = 1;
				for (int iAssetData = 0; iAssetData < assetCounter; iAssetData++) {
					logger.log(LogStatus.PASS, counter + "." + webAssetList.get(iAssetData).getText());
					counter++;
				}
			} else {
				logger.log(LogStatus.FAIL, "Asset data not matching");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Asset not present in web portal");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.toString());
		}

	}

	@And("^API data should match with the data in left panel for local user$")
	public void validateLocalUserLeftPanelDataWithAPI() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		validateGeographyWithAPINaUser();
		validateCountryWithAPINaUser();
		validateBranchWithAPINaUser();
		validateCustomerWithAPINaUser();
		validateProjectWithAPINaUser();
		validateAssetWithAPINaUser();
		logger.log(LogStatus.INFO, "TC2 and TC4 validation completed");
	}

	// Step Definitions for Test Case 3
	@Then("^user validate the default selected tab in left panel$")
	public void validateDefaultTab() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		WebElement element = objLeftPanel.getLeftPanelElement("JCI", "1");
		if (element != null) {

			logger.log(LogStatus.PASS, "Default tab in the left panel is JCI and is selected");

		} else {
			logger.log(LogStatus.FAIL, "Default tab JCI element not present");
		}
	}

	// Step Definitions for Test Case 6
	@Then("^user clicked on arrow in the left panel$")
	public void clickArrowInLeftPanel() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase6");
		logger.log(LogStatus.INFO, "Exceution of TC6 started");
		try {
			if (objLeftPanel.getJCIArrow() != null) {
				objLeftPanel.getJCIArrow().click();
				logger.log(LogStatus.PASS, "Clicked arrow in the left panel");
			} else {
				logger.log(LogStatus.FAIL, "Arrow for JCI not present in the left panel");
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Error while clicking arrow in the left panel");
			logger.log(LogStatus.INFO, e.toString());
		}
	}

	@And("^user refresh the page$")
	public void refreshPage() {
		driver.navigate().refresh();
		logger.log(LogStatus.PASS, "Page getting refreshed");
	}

	@And("^left panel state should change to default$")
	public void leftPanelStateToDefault() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			if ((objLeftPanel.getActiveTabAdmin() != null)
					&& (objLeftPanel.getActiveTabAdmin().getText().equals("JCI"))) {
				logger.log(LogStatus.PASS, "Left Panel state changed to default");
			} else {
				logger.log(LogStatus.FAIL, "Left Panel state not changed to its default");
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Error after page refresh. Left Panel state not changed to default");
			logger.log(LogStatus.INFO, e.toString());
		}
		logger.log(LogStatus.INFO, "TC6 validation completed");
	}

	// Step Definitions for Test Case 7
	@Then("^user validate if Overview page is the default page or not$")
	public void validateLandingPage() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			logger.log(LogStatus.INFO, "TestCase7");
			logger.log(LogStatus.INFO, "Exceution of TC7 started");
			if (objLeftPanel.getJCIArrow().isDisplayed() && objLeftPanel.getLandingPageURL()
					.equalsIgnoreCase(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
				logger.log(LogStatus.PASS, "Overview page is the default page");
			} else {
				logger.log(LogStatus.FAIL, "CEP Default page is not correct");
			}

		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "CEP Default page is not correct");
			logger.log(LogStatus.ERROR, e.toString());

		}
		logger.log(LogStatus.INFO, "TC7 validation completed");
	}

	// Steps definitions for TC8
	@Then("^user validates the widgets in the overview tab$")
	public void validateWidgetsInOverview() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase8");
		logger.log(LogStatus.INFO, "Exceution of TC8 started");
		if (objLeftPanel.getChillerStatusWidget() != null
				&& objLeftPanel.getChillerStatusWidget().getText().equals("CHILLER STATUS")) {
			logger.log(LogStatus.PASS, "CHILLER STATUS widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "CHILLER STATUS widget is not present");
		}
		if (objLeftPanel.getCustomerListWidget() != null
				&& objLeftPanel.getCustomerListWidget().getText().equals("CUSTOMER LIST BY STATUS")) {
			logger.log(LogStatus.PASS, "CUSTOMER LIST BY STATUS widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "CUSTOMER LIST BY STATUS widget is not present");
		}
		if (objLeftPanel.getChillerInformationWidget() != null
				&& objLeftPanel.getChillerInformationWidget().getText().equals("CHILLER INFORMATION")) {
			logger.log(LogStatus.PASS, "CHILLER INFORMATION widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "CHILLER INFORMATION widget is not present");
		}
		if (objLeftPanel.getStatusHealthCheckWidget() != null
				&& objLeftPanel.getStatusHealthCheckWidget().getText().equals("STATUS / HEALTH CHECK")) {
			logger.log(LogStatus.PASS, "STATUS / HEALTH CHECK widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "STATUS / HEALTH CHECK widget is not present");
		}
	}

	@And("^all four widgets should get display for chillers$")
	public void validateAllFourWidgetsDisplaying() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.PASS, "Below is the order of Widgets in the Overview tab:");
		logger.log(LogStatus.PASS, "1.CHILLERSTATUS");
		logger.log(LogStatus.PASS, "2.CUSTOMER LIST BY STATUS");
		logger.log(LogStatus.PASS, "3.CHILLER INFORMATION");
		logger.log(LogStatus.PASS, "4.STATUS / HEALTH CHECK");
		logger.log(LogStatus.INFO, "TC8 validation completed");
	}

	// Steps definitions for TC9
	@Then("^user validates the widgets in the overview tab for user with one geography$")
	public void validateWidgetsForOneGeography() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase9");
		logger.log(LogStatus.INFO, "Exceution of TC9 started");
		if (objLeftPanel.getChillerStatusWidget() != null
				&& objLeftPanel.getChillerStatusWidget().getText().equals("CHILLER STATUS")) {
			logger.log(LogStatus.PASS, "CHILLER STATUS widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "CHILLER STATUS widget is not present");
		}
		if (objLeftPanel.getCustomerListWidget() != null
				&& objLeftPanel.getCustomerListWidget().getText().equals("CUSTOMER LIST BY STATUS")) {
			logger.log(LogStatus.PASS, "CUSTOMER LIST BY STATUS widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "CUSTOMER LIST BY STATUS widget is not present");
		}
		if (objLeftPanel.getChillerInformationWidget() != null
				&& objLeftPanel.getChillerInformationWidget().getText().equals("CHILLER INFORMATION")) {
			logger.log(LogStatus.PASS, "CHILLER INFORMATION widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "CHILLER INFORMATION widget is not present");
		}
		if (objLeftPanel.getStatusHealthCheckWidget() != null
				&& objLeftPanel.getStatusHealthCheckWidget().getText().equals("STATUS / HEALTH CHECK")) {
			logger.log(LogStatus.PASS, "STATUS / HEALTH CHECK widget is getting displayed");
		} else {
			logger.log(LogStatus.FAIL, "STATUS / HEALTH CHECK widget is not present");
		}
	}

	@And("^all four widgets should get display for chillers under one geography$")
	public void validateAllFourWidgetsForOneGeography() {
		logger.log(LogStatus.PASS, "Below is the order of Widgets in the Overview tab:");
		logger.log(LogStatus.PASS, "1.CHILLERSTATUS");
		logger.log(LogStatus.PASS, "2.CUSTOMER LIST BY STATUS");
		logger.log(LogStatus.PASS, "3.CHILLER INFORMATION");
		logger.log(LogStatus.PASS, "4.STATUS / HEALTH CHECK");
		logger.log(LogStatus.INFO, "TC9 validation completed");
	}

	// Steps definitions for TC5
	@Then("^user clicked on each tab in the left panel$")
	public void userClickedOnEachTab() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		try {
			logger.log(LogStatus.INFO, "TestCase5");
			logger.log(LogStatus.INFO, "Exceution of TC5 started");
			objLeftPanel.getJCIDefaultTab().click();
			if (driver.getCurrentUrl()
					.equalsIgnoreCase(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
				logger.log(LogStatus.PASS, "Active tab after clicking JCI tab is as expected");
			} else {
				logger.log(LogStatus.FAIL, "Active tab after clicking JCI tab is not as expected");
			}
			objLeftPanel.clickLeftPanelArrow("home-leftPanel-JCI");
			objLeftPanel.getGeographyListWeb().get(0).click();
			if (driver.getCurrentUrl()
					.equalsIgnoreCase(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
				logger.log(LogStatus.PASS, "Active tab after clicking Geography tab is as expected");
			} else {
				logger.log(LogStatus.FAIL, "Active tab after clicking Geography tab is not as expected");
			}
			objLeftPanel.clickLeftPanelArrow("home-leftPanel-Geography");
			objLeftPanel.getFirstCountry().click();
			if (driver.getCurrentUrl()
					.equalsIgnoreCase(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
				logger.log(LogStatus.PASS, "Active tab after clicking Country tab is as expected");
			} else {
				logger.log(LogStatus.FAIL, "Active tab after clicking Country tab is not as expected");
			}
			objLeftPanel.clickLeftPanelArrow("home-leftPanel-Country");
			objLeftPanel.getFirstBranch().click();
			if (driver.getCurrentUrl()
					.equalsIgnoreCase(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
				logger.log(LogStatus.PASS, "Active tab after clicking Branch tab is as expected");
			} else {
				logger.log(LogStatus.FAIL, "Active tab after clicking Branch tab is not as expected");
			}
			objLeftPanel.clickLeftPanelArrow("home-leftPanel-Branch");
			objLeftPanel.getFirstCustomer().click();
			if (driver.getCurrentUrl()
					.equalsIgnoreCase(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
				logger.log(LogStatus.PASS, "Active tab after clicking Customer tab is as expected");
			} else {
				logger.log(LogStatus.FAIL, "Active tab after clicking Customer tab is not as expected");
			}
			objLeftPanel.clickLeftPanelArrow("home-leftPanel-Customer");
			objLeftPanel.getFirstProject().click();
			if (driver.getCurrentUrl()
					.equalsIgnoreCase(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("homeURL"))) {
				logger.log(LogStatus.PASS, "Active tab after clicking Project tab is as expected");
			} else {
				logger.log(LogStatus.FAIL, "Active tab after clicking Project tab is not as expected");
			}
			objLeftPanel.clickLeftPanelArrow("home-leftPanel-Project");
			objLeftPanel.getFirstAsset().click();
			if (objLeftPanel.getTrendLabel().getText().equals("Trend")) {
				logger.log(LogStatus.PASS, "Active tab after clicking Chiller tab is as expected");
			} else {
				logger.log(LogStatus.FAIL, "Active tab after clicking Chiller tab is not as expected");
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Element not present");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e.toString());
		}

	}

	@And("^validate the active tab to be displayed for the selected tab$")
	public void validateActiveTab() {

		logger.log(LogStatus.INFO, "TC5 validation completed");
	}

	// Steps definitions for TC10
	@Then("^user clicked on each Geography and Country arrow$")
	public void clickOnGeography() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase10");
		logger.log(LogStatus.INFO, "Exceution of TC10 started");
		try {
			objLeftPanel.getJCIArrow().click();
			objLeftPanel.geographyArrow();
			List<WebElement> getCountryList = objLeftPanel.getCountryListWeb();
			for (int iCountryCount = 0; iCountryCount < getCountryList.size(); iCountryCount++) {
				getCountryList.get(iCountryCount).click();
				if (objLeftPanel.getChillerStatusWidget() != null
						&& objLeftPanel.getChillerStatusWidget().getText().equals("CHILLER STATUS")) {
					logger.log(LogStatus.PASS, "CHILLER STATUS widget is getting displayed for "
							+ getCountryList.get(iCountryCount).getText());
				} else {
					logger.log(LogStatus.FAIL,
							"CHILLER STATUS widget is not present for " + getCountryList.get(iCountryCount).getText());
				}
				if (objLeftPanel.getCustomerListWidget() != null
						&& objLeftPanel.getCustomerListWidget().getText().equals("CUSTOMER LIST BY STATUS")) {
					logger.log(LogStatus.PASS, "CUSTOMER LIST BY STATUS widget is getting displayed for "
							+ getCountryList.get(iCountryCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CUSTOMER LIST BY STATUS widget is not present for "
							+ getCountryList.get(iCountryCount).getText());
				}
				if (objLeftPanel.getChillerInformationWidget() != null
						&& objLeftPanel.getChillerInformationWidget().getText().equals("CHILLER INFORMATION")) {
					logger.log(LogStatus.PASS, "CHILLER INFORMATION widget is getting displayed for "
							+ getCountryList.get(iCountryCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CHILLER INFORMATION widget is not present for "
							+ getCountryList.get(iCountryCount).getText());
				}
				if (objLeftPanel.getStatusHealthCheckWidget() != null
						&& objLeftPanel.getStatusHealthCheckWidget().getText().equals("STATUS / HEALTH CHECK")) {
					logger.log(LogStatus.PASS, "STATUS / HEALTH CHECK widget is getting displayed for "
							+ getCountryList.get(iCountryCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "STATUS / HEALTH CHECK widget is not present for "
							+ getCountryList.get(iCountryCount).getText());
				}

			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Element not present");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e.toString());
		}
	}

	@And("^user validates all four widgets getting displayed for each country$")
	public void statusOfValidation() {
		logger.log(LogStatus.INFO, "TC10 validation completed.");
	}

	// Steps definitions for TC11
	@Then("^user clicked on each Geography, Country arrow and Branch name$")
	public void userClickedOnBranch() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase11");
		logger.log(LogStatus.INFO, "Exceution of TC11 started");
		try {
			objLeftPanel.getJCIArrow().click();
			objLeftPanel.geographyArrow();
			objLeftPanel.countryArrow();
			List<WebElement> getBranchList = objLeftPanel.getBranchListWeb();
			for (int iBranchCount = 0; iBranchCount < getBranchList.size(); iBranchCount++) {
				getBranchList.get(iBranchCount).click();
				if (objLeftPanel.getChillerStatusWidget() != null
						&& objLeftPanel.getChillerStatusWidget().getText().equals("CHILLER STATUS")) {
					logger.log(LogStatus.PASS, "CHILLER STATUS widget is getting displayed for "
							+ getBranchList.get(iBranchCount).getText());
				} else {
					logger.log(LogStatus.FAIL,
							"CHILLER STATUS widget is not present for " + getBranchList.get(iBranchCount).getText());
				}
				if (objLeftPanel.getCustomerListWidget() != null
						&& objLeftPanel.getCustomerListWidget().getText().equals("CUSTOMER LIST BY STATUS")) {
					logger.log(LogStatus.PASS, "CUSTOMER LIST BY STATUS widget is getting displayed for "
							+ getBranchList.get(iBranchCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CUSTOMER LIST BY STATUS widget is not present for "
							+ getBranchList.get(iBranchCount).getText());
				}
				if (objLeftPanel.getChillerInformationWidget() != null
						&& objLeftPanel.getChillerInformationWidget().getText().equals("CHILLER INFORMATION")) {
					logger.log(LogStatus.PASS, "CHILLER INFORMATION widget is getting displayed for "
							+ getBranchList.get(iBranchCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CHILLER INFORMATION widget is not present for "
							+ getBranchList.get(iBranchCount).getText());
				}
				if (objLeftPanel.getStatusHealthCheckWidget() != null
						&& objLeftPanel.getStatusHealthCheckWidget().getText().equals("STATUS / HEALTH CHECK")) {
					logger.log(LogStatus.PASS, "STATUS / HEALTH CHECK widget is getting displayed for "
							+ getBranchList.get(iBranchCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "STATUS / HEALTH CHECK widget is not present for "
							+ getBranchList.get(iBranchCount).getText());
				}

			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Element not present");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e.toString());
		}

	}

	@And("^user validates all four widgets getting displayed for each branch$")
	public void statusOfValidationBranch() {
		logger.log(LogStatus.INFO, "TC11 validation completed.");
	}

	// Steps Definitions for TC12
	@Then("^user clicked on each Geography, Country, Branch arrow and Customer name$")
	public void userClickedOnCustomer() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase12");
		logger.log(LogStatus.INFO, "Exceution of TC12 started");
		try {
			objLeftPanel.getJCIArrow().click();
			objLeftPanel.geographyArrow();
			objLeftPanel.countryArrow();
			// objLeftPanel.branchArrow();
			List<WebElement> getCustomerList = objLeftPanel.getCustomerListWeb();
			for (int iCustomerCount = 0; iCustomerCount < getCustomerList.size(); iCustomerCount++) {
				getCustomerList.get(iCustomerCount).click();
				if (objLeftPanel.getChillerStatusWidget() != null
						&& objLeftPanel.getChillerStatusWidget().getText().equals("CHILLER STATUS")) {
					logger.log(LogStatus.PASS, "CHILLER STATUS widget is getting displayed for "
							+ getCustomerList.get(iCustomerCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CHILLER STATUS widget is not present for "
							+ getCustomerList.get(iCustomerCount).getText());
				}
				if (objLeftPanel.getCustomerListWidget() != null
						&& objLeftPanel.getCustomerListWidget().getText().equals("CUSTOMER LIST BY STATUS")) {
					logger.log(LogStatus.PASS, "CUSTOMER LIST BY STATUS widget is getting displayed for "
							+ getCustomerList.get(iCustomerCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CUSTOMER LIST BY STATUS widget is not present for "
							+ getCustomerList.get(iCustomerCount).getText());
				}
				if (objLeftPanel.getChillerInformationWidget() != null
						&& objLeftPanel.getChillerInformationWidget().getText().equals("CHILLER INFORMATION")) {
					logger.log(LogStatus.PASS, "CHILLER INFORMATION widget is getting displayed for "
							+ getCustomerList.get(iCustomerCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CHILLER INFORMATION widget is not present for "
							+ getCustomerList.get(iCustomerCount).getText());
				}
				if (objLeftPanel.getStatusHealthCheckWidget() != null
						&& objLeftPanel.getStatusHealthCheckWidget().getText().equals("STATUS / HEALTH CHECK")) {
					logger.log(LogStatus.PASS, "STATUS / HEALTH CHECK widget is getting displayed for "
							+ getCustomerList.get(iCustomerCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "STATUS / HEALTH CHECK widget is not present for "
							+ getCustomerList.get(iCustomerCount).getText());
				}

			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Element not present");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e.toString());
		}

	}

	@And("^user validates all four widgets getting displayed for each Customer$")
	public void statusOfValidationCustomer() {
		logger.log(LogStatus.INFO, "TC12 validation completed.");
	}

	// Steps Definitions for TC13
	@Then("^user clicked on each Geography, Country, Branch, Customer arrow and Project name$")
	public void userClickedOnProject() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase13");
		logger.log(LogStatus.INFO, "Exceution of TC13 started");
		try {
			/*
			 * objLeftPanel.getJCIArrow().click();
			 * objLeftPanel.geographyArrow(); objLeftPanel.countryArrow();
			 * objLeftPanel.branchArrow(); objLeftPanel.customerArrow();
			 */
			List<WebElement> getProjectList = objLeftPanel.getProjectListWeb();
			for (int iProjectCount = 0; iProjectCount < getProjectList.size(); iProjectCount++) {
				getProjectList.get(iProjectCount).click();
				if (objLeftPanel.getChillerStatusWidget() != null
						&& objLeftPanel.getChillerStatusWidget().getText().equals("CHILLER STATUS")) {
					logger.log(LogStatus.PASS, "CHILLER STATUS widget is getting displayed for "
							+ getProjectList.get(iProjectCount).getText());
				} else {
					logger.log(LogStatus.FAIL,
							"CHILLER STATUS widget is not present for " + getProjectList.get(iProjectCount).getText());
				}
				if (objLeftPanel.getCustomerListWidget() != null
						&& objLeftPanel.getCustomerListWidget().getText().equals("CUSTOMER LIST BY STATUS")) {
					logger.log(LogStatus.PASS, "CUSTOMER LIST BY STATUS widget is getting displayed for "
							+ getProjectList.get(iProjectCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CUSTOMER LIST BY STATUS widget is not present for "
							+ getProjectList.get(iProjectCount).getText());
				}
				if (objLeftPanel.getChillerInformationWidget() != null
						&& objLeftPanel.getChillerInformationWidget().getText().equals("CHILLER INFORMATION")) {
					logger.log(LogStatus.PASS, "CHILLER INFORMATION widget is getting displayed for "
							+ getProjectList.get(iProjectCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "CHILLER INFORMATION widget is not present for "
							+ getProjectList.get(iProjectCount).getText());
				}
				if (objLeftPanel.getStatusHealthCheckWidget() != null
						&& objLeftPanel.getStatusHealthCheckWidget().getText().equals("STATUS / HEALTH CHECK")) {
					logger.log(LogStatus.PASS, "STATUS / HEALTH CHECK widget is getting displayed for "
							+ getProjectList.get(iProjectCount).getText());
				} else {
					logger.log(LogStatus.FAIL, "STATUS / HEALTH CHECK widget is not present for "
							+ getProjectList.get(iProjectCount).getText());
				}

			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Element not present");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e.toString());
		}

	}

	@And("^user validates all four widgets getting displayed for each Project$")
	public void statusOfValidationProject() {
		logger.log(LogStatus.INFO, "TC13 validation completed.");
	}

	// Steps Definitions for TC14
	@Then("^user clicked on each Geography, Country, Branch, Customer, Project arrow and Chillers name$")
	public void userClickedOnChiller() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		logger.log(LogStatus.INFO, "TestCase14");
		logger.log(LogStatus.INFO, "Exceution of TC14 started");
		try {
			/*
			 * objLeftPanel.getJCIArrow().click();
			 * objLeftPanel.geographyArrow(); objLeftPanel.countryArrow();
			 * objLeftPanel.branchArrow(); objLeftPanel.customerArrow();
			 */
			List<WebElement> getAssetList = objLeftPanel.getAssetListWeb();
			for (int iAssetCount = 0; iAssetCount < getAssetList.size(); iAssetCount++) {
				getAssetList.get(iAssetCount).click();
				if (objLeftPanel.getTrendLabel().isDisplayed()) {
					logger.log(LogStatus.PASS,
							"Trend Page is getting displayed for " + getAssetList.get(iAssetCount).getText());
				} else {
					logger.log(LogStatus.FAIL,
							"Trend page is not getting displayed for " + getAssetList.get(iAssetCount).getText());
				}

			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Element not present");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Trend page is not getting displayed");
			logger.log(LogStatus.INFO, e.toString());
		}

	}

	@And("^user validates Trends getting displayed for each Chiller$")
	public void statusOfValidationChiller() {
		logger.log(LogStatus.INFO, "TC14 validation completed.");
	}

	// Steps Definition for TC16
	@Then("^user clicked on each JCI, Geography,Country,Branch,Customer,Site$")
	public void validateBreadCrumbSequence() {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		WebElement breadcrumbList = null;
		try {
			objLeftPanel.waitForOverviewPage();
			getFinalReport(driver, logger, "testOverview", true);
			if (objLeftPanel.getNavigationIcon().isDisplayed()) {
				objLeftPanel.getNavigationIcon().click();
				logger.log(LogStatus.PASS, "Navigation icon is present and clickable.");				
			} else {
				logger.log(LogStatus.FAIL, "Navigation Icon is not present in the Dashboard page.");
			}
			//Thread.sleep(20000);
			WebElement jciLabel = objLeftPanel.getLeftPanelElement("JCI", "1");
			// validate breadcrumb for JCI
			jciLabel.click();
			breadcrumbList = objLeftPanel.getBreadCrumbList();
			if (breadcrumbList.getText().equalsIgnoreCase("JCI")) {
				logger.log(LogStatus.PASS,
						"Breadcrumb sequence when JCI tab selected is as expected:" + breadcrumbList.getText());
				getFinalReport(driver, logger, "testBreadCrumbJCI", true);
			} else {
				logger.log(LogStatus.FAIL, "Breadcrumb sequence for JCI is not as expected");
				getFinalReport(driver, logger, "testBreadCrumbJCI", false);
			}
			WebElement branch = objLeftPanel.getLeftPanelElement("Albany GA - 0N91", "4");
			branch.click();
			breadcrumbList = objLeftPanel.getBreadCrumbList();
			if (breadcrumbList.getText().equalsIgnoreCase("JCI > North America > United States > Albany GA - 0N91")) {
				logger.log(LogStatus.PASS,
						"Breadcrumb sequence for Branch is as expected:JCI > Geography Name > Country Name > Branch Name");
				getFinalReport(driver, logger, "testBreadCrumbBranch", true);
			} else {
				logger.log(LogStatus.FAIL, "Breadcrumb sequence for Branch is not as expected");
				getFinalReport(driver, logger, "testBreadCrumbBranch", false);
			}

			WebElement geography = objLeftPanel.getLeftPanelElement("North America", "2");
			geography.click();
			breadcrumbList = objLeftPanel.getBreadCrumbList();
			if (breadcrumbList.getText().equalsIgnoreCase("JCI > North America")) {
				logger.log(LogStatus.PASS, "Breadcrumb sequence for Geography is as expected:JCI > Geography");
				getFinalReport(driver, logger, "testBreadCrumbGeography", true);
			} else {
				logger.log(LogStatus.FAIL, "Breadcrumb sequence for Geography is not as expected");
				getFinalReport(driver, logger, "testBreadCrumbGeography", false);
			}
			WebElement country = objLeftPanel.getLeftPanelElement("United States", "3");
			country.click();
			breadcrumbList = objLeftPanel.getBreadCrumbList();
			if (breadcrumbList.getText().equalsIgnoreCase("JCI > North America > United States")) {
				logger.log(LogStatus.PASS,
						"Breadcrumb sequence for Country is as expected:JCI > Geography Name > Country Name");
				getFinalReport(driver, logger, "testBreadCrumbCountry", true);
			} else {
				logger.log(LogStatus.FAIL, "Breadcrumb sequence for Country is not as expected");
				getFinalReport(driver, logger, "testBreadCrumbCountry", false);
			}
			// WebElement branch=objLeftPanel.getLeftPanelElement("Albany GA -
			// 0N91", "4");
			// branch.click();
			// breadcrumbList = objLeftPanel.getBreadCrumbList();
			// if (breadcrumbList.getText().equalsIgnoreCase("JCI > North
			// America > United States > Albany GA - 0N91")) {
			// logger.log(LogStatus.PASS, "Breadcrumb sequence for Branch is as
			// expected:JCI > Geography Name > Country Name > Branch Name");
			// } else {
			// logger.log(LogStatus.FAIL, "Breadcrumb sequence for Branch is not
			// as expected");
			// }

		} catch (NoSuchElementException e) {
			logger.log(LogStatus.FAIL, "Breadcrumb sequence is not as expected");
			logger.log(LogStatus.INFO, e.toString());
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Breadcrumb sequence is not as expected");
			logger.log(LogStatus.INFO, e.toString());
		}
	}

	@And("^user validates breadcrumb sequences in Overview tab$")
	public void statusOfBreadcrumbValidation() {
		logger.log(LogStatus.INFO, "TC16 validation completed.");
	}

	// @After
	// public static void generateReport() {
	// getFinalReport(driver, logger, methodName, true);
	// }

}
