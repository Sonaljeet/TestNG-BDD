package mars.JCI.Project.CEP.CustomerListByStatus;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.HeatMap.CEP_HeatMap_DataBase_Action;
import mars.JCI.Project.CEP.HeatMap.CEP_StatusCheckHeatMap_Page_Factory;

public class CEP_CustomerListByStatus_Page_Action2 extends BaseClass implements Runnable {
	private CountDownLatch latch;
	@SuppressWarnings("static-access")
	public CEP_CustomerListByStatus_Page_Action2(WebDriver driver, ExtentTest logger,CountDownLatch latch) {
		this.driver = driver;
		this.logger = logger;
		this.latch = latch;
	}

	public void validateDefaultStatus() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForRedChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		List<String> chillerName = new ArrayList<String>();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
			projectName.add(rs.getString("ProjectName"));
			chillerName.add(rs.getString("AssetName"));
		}
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			objHealthCheck.getSearchTextBox().sendKeys(customer.getText());
			objHealthCheck.getCustomerInSearchResult(customer.getText()).click();
		}
		WebElement project = objStatusCheck.getProjectInSearchResult(projectName.get(0));
		WebElement chiller = objStatusCheck.getAssetInSearchResult(chillerName.get(0));
		if ((customer.isDisplayed()) && (project.isDisplayed()) && (chiller.isDisplayed())) {
			logger.log(LogStatus.PASS, "Red Color widget details is as expected in the CustomerListByStatus tab.");
		} else {
			logger.log(LogStatus.FAIL, "Red Color widget details is not as expected.");
			getFinalReport(driver, logger, "testDefaultCustomerByList", false);
		}
	}

	public void validateTab() throws Exception {
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		List<WebElement> rightHeaders = objCustList.getRightHeaders();
		WebElement customerNameHeader = objCustList.getCustomerNameHeader();
		WebElement siteNameHeader = objCustList.getSiteNameHeader();
		WebElement assetNameHeader = objCustList.getAssetNameHeader();
		List<WebElement> countHeaders = objCustList.getCountHeaderList();
		if ((rightHeaders != null) || (customerNameHeader != null) || (siteNameHeader != null)
				|| (assetNameHeader != null)) {
			if (rightHeaders.get(0).getText().equalsIgnoreCase("CUSTOMER LIST BY STATUS")) {
				logger.log(LogStatus.PASS, "'Customer List By Status' header is present.");
			} else {
				logger.log(LogStatus.FAIL, "'Customer List By Status' header is not present.");
			}
			if (customerNameHeader.getText().equalsIgnoreCase("Customer Name")) {
				logger.log(LogStatus.PASS, "'Customer Name' header is present.");
			} else {
				logger.log(LogStatus.FAIL, "'Customer Name' header is not present.");
			}
			if (siteNameHeader.getText().equalsIgnoreCase("Site/Facility name")) {
				logger.log(LogStatus.PASS, "'Site/Facility name' header is present.");
			} else {
				logger.log(LogStatus.FAIL, "'Site/Facility name' header is not present.");
			}
			if (assetNameHeader.getText().equalsIgnoreCase("Asset name")) {
				logger.log(LogStatus.PASS, "'Asset name' header is present.");
			} else {
				logger.log(LogStatus.FAIL, "'Asset name' header is not present.");
			}
			if (countHeaders.get(0).getText().contains("Count")) {
				logger.log(LogStatus.PASS, "Count header is present.");
			} else {
				logger.log(LogStatus.FAIL, "Count header is not present.");
			}
		}
	}

	public void validateSearchBox() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForRedChillers();
		List<String> customerName = new ArrayList<String>();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
		}
		objHealthCheck.getSearchTextBox().sendKeys(customerName.get(0));
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			logger.log(LogStatus.PASS, "Search by customer functionality is as expected.");
		} else {
			logger.log(LogStatus.FAIL, "Search by customer functionality is not as expected.");
		}
	}

	public void validateDefaultCustomerCount() throws Exception {
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		String customerCount = objCustList.getCountHeaderList().get(0).getText();
		String dBCount = String.valueOf(CEP_HeatMap_DataBase_Action.statusCheckTotalRedCount());
		if (customerCount.equalsIgnoreCase("Count-" + dBCount)) {
			logger.log(LogStatus.PASS, "Default count present and is matching with DB count.");
			logger.log(LogStatus.INFO, "Count from DB and in UI is:" + customerCount);
		} else {
			logger.log(LogStatus.PASS, "Default count not matching with DB count.");
			logger.log(LogStatus.INFO, "Count from DB and in UI is:" + customerCount);
		}
	}

	public void validateDefaultChillerCount() throws Exception {
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForRedChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> chillerName = new ArrayList<String>();
		String chillerCount = objCustList.getCountHeaderList().get(2).getText();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
		}
		objHealthCheck.getSearchTextBox().sendKeys(customerName.get(0));
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			customer.click();
			chillerName = CEP_HeatMap_DataBase_Action.getChillerList(customer.getText());
			if (chillerCount.equalsIgnoreCase("Count-" + chillerName.size())) {
				logger.log(LogStatus.PASS, "Default chiller count present and is matching with DB count.");
				logger.log(LogStatus.INFO, "Count of chillers from DB and in UI is:" + chillerCount);
			} else {
				logger.log(LogStatus.PASS, "Default chiller count is not as expected.");
				logger.log(LogStatus.INFO, "Count of chillers from DB and in UI is:" + chillerCount);
			}
		} else {
			logger.log(LogStatus.FAIL, "Customer for default color widget is not present.");
		}
	}

	public void validateDefaultSiteCount() throws Exception {
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForRedChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		String projectCount = objCustList.getCountHeaderList().get(1).getText();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
		}
		objHealthCheck.getSearchTextBox().sendKeys(customerName.get(0));
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			customer.click();
			projectName = CEP_HeatMap_DataBase_Action.getSiteList(customer.getText());
			if (projectCount.equalsIgnoreCase("Count-" + projectName.size())) {
				logger.log(LogStatus.PASS, "Default project count present and is matching with DB count.");
				logger.log(LogStatus.INFO, "Count of projects from DB and in UI is:" + projectCount);
			} else {
				logger.log(LogStatus.PASS, "Default project count is not as expected.");
				logger.log(LogStatus.INFO, "Count of projects from DB and in UI is:" + projectCount);
			}
		} else {
			logger.log(LogStatus.FAIL, "Customer for default color widget is not present.");
		}
	}

	public void validateForGreen() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIGreen();
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		if (greenColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greenColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				int chillerCountUI = 0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteNames = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIGreen(customerName);
				List<String> chillerNames = CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIGreen(customerName);
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				int customerCountUI = Integer.parseInt(countHeaders.get(0).getText().substring(6));
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI > 1) {
					System.out.println(siteCountUI);
					for (int iSiteCount = 0; iSiteCount < siteNames.size(); iSiteCount++) {
						try {
							WebElement element = objStatusCheck.getProjectInSearchResult(siteNames.get(iSiteCount));
							action.moveToElement(element).click().build().perform();
							chillerCountUI = chillerCountUI
									+ Integer.parseInt(countHeaders.get(2).getText().substring(6));
						} catch (Exception e) {
							logger.log(LogStatus.FAIL, "Site " + siteNames.get(iSiteCount) + " not present in UI.");
						}
					}
				} else {
					chillerCountUI = Integer.parseInt(countHeaders.get(2).getText().substring(6));
				}
				int customerCountDB = customerList.size();
				int siteCountDB = siteNames.size();
				int chillerCountDB = chillerNames.size();
				if ((customerCountUI == customerCountDB) && (siteCountUI == siteCountDB)
						&& (chillerCountUI == chillerCountDB)) {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Green color widget.");
					logger.log(LogStatus.PASS, "Counts are matching with DB for Green color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				} else {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Green color widget.");
					logger.log(LogStatus.FAIL, "Counts are not matching with DB for Green color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Green Color widget not present.");
		}

	}

	public void validateForYellow() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIYellow();
		WebElement yellowColor = objStatusCheck.getStatusCheckYellow();
		if (yellowColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(yellowColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				int chillerCountUI = 0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteNames = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIYellow(customerName);
				List<String> chillerNames = CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIYellow(customerName);
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				int customerCountUI = Integer.parseInt(countHeaders.get(0).getText().substring(6));
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI > 1) {
					System.out.println(siteCountUI);
					for (int iSiteCount = 0; iSiteCount < siteNames.size(); iSiteCount++) {
						try {
							WebElement element = objStatusCheck.getProjectInSearchResult(siteNames.get(iSiteCount));
							action.moveToElement(element).click().build().perform();
							chillerCountUI = chillerCountUI
									+ Integer.parseInt(countHeaders.get(2).getText().substring(6));
						} catch (Exception e) {
							logger.log(LogStatus.FAIL, "Site " + siteNames.get(iSiteCount) + " not present in UI.");
						}
					}
				} else {
					chillerCountUI = Integer.parseInt(countHeaders.get(2).getText().substring(6));
				}
				int customerCountDB = customerList.size();
				int siteCountDB = siteNames.size();
				int chillerCountDB = chillerNames.size();
				if ((customerCountUI == customerCountDB) && (siteCountUI == siteCountDB)
						&& (chillerCountUI == chillerCountDB)) {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Yellow color widget.");
					logger.log(LogStatus.PASS, "Counts are matching with DB for Yellow color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				} else {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Yellow color widget.");
					logger.log(LogStatus.FAIL, "Counts are not matching with DB for Yellow color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Yellow Color widget not present.");
		}

	}

	public void validateForOrange() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIOrange();
		WebElement orangeColor = objStatusCheck.getStatusCheckOrange();
		if (orangeColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(orangeColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				int chillerCountUI = 0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteNames = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIOrange(customerName);
				List<String> chillerNames = CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIOrange(customerName);
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				int customerCountUI = Integer.parseInt(countHeaders.get(0).getText().substring(6));
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI > 1) {
					System.out.println(siteCountUI);
					for (int iSiteCount = 0; iSiteCount < siteNames.size(); iSiteCount++) {
						try {
							WebElement element = objStatusCheck.getProjectInSearchResult(siteNames.get(iSiteCount));
							action.moveToElement(element).click().build().perform();
							chillerCountUI = chillerCountUI
									+ Integer.parseInt(countHeaders.get(2).getText().substring(6));
						} catch (Exception e) {
							logger.log(LogStatus.FAIL, "Site " + siteNames.get(iSiteCount) + " not present in UI.");
						}
					}
				} else {
					chillerCountUI = Integer.parseInt(countHeaders.get(2).getText().substring(6));
				}
				int customerCountDB = customerList.size();
				int siteCountDB = siteNames.size();
				int chillerCountDB = chillerNames.size();
				if ((customerCountUI == customerCountDB) && (siteCountUI == siteCountDB)
						&& (chillerCountUI == chillerCountDB)) {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Orange color widget.");
					logger.log(LogStatus.PASS, "Counts are matching with DB for Orange color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				} else {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Orange color widget.");
					logger.log(LogStatus.FAIL, "Counts are not matching with DB for Orange color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Orange Color widget not present.");
		}

	}

	public void validateForGrey() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIGrey();
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		if (greyColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greyColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				int chillerCountUI = 0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteNames = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIGrey(customerName);
				List<String> chillerNames = CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIGrey(customerName);
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				int customerCountUI = Integer.parseInt(countHeaders.get(0).getText().substring(6));
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI > 1) {
					System.out.println(siteCountUI);
					for (int iSiteCount = 0; iSiteCount < siteNames.size(); iSiteCount++) {
						try {
							WebElement element = objStatusCheck.getProjectInSearchResult(siteNames.get(iSiteCount));
							action.moveToElement(element).click().build().perform();
							chillerCountUI = chillerCountUI
									+ Integer.parseInt(countHeaders.get(2).getText().substring(6));
						} catch (Exception e) {
							logger.log(LogStatus.FAIL, "Site " + siteNames.get(iSiteCount) + " not present in UI.");
						}
					}
				} else {
					chillerCountUI = Integer.parseInt(countHeaders.get(2).getText().substring(6));
				}
				int customerCountDB = customerList.size();
				int siteCountDB = siteNames.size();
				int chillerCountDB = chillerNames.size();
				if ((customerCountUI == customerCountDB) && (siteCountUI == siteCountDB)
						&& (chillerCountUI == chillerCountDB)) {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Grey color widget.");
					logger.log(LogStatus.PASS, "Counts are matching with DB for Grey color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				} else {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Grey color widget.");
					logger.log(LogStatus.FAIL, "Counts are not matching with DB for Grey color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Grey Color widget not present.");
		}
	}

	public void validateSiteListForGreenCustomer() throws Exception {
		logger.log(LogStatus.INFO, "Validation of Site/FacilityName for 'Green' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIGreen();
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		if (greenColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greenColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIGreen(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(4000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI == siteListDB.size()) {
					logger.log(LogStatus.PASS, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				} else {
					logger.log(LogStatus.FAIL, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				}
				logger.log(LogStatus.INFO, "Site Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (element != null) {
							logger.log(LogStatus.PASS,
									"Site " + siteListDB.get(iSiteCount) + " present in UI and matched with DB.");
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but exists in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {

					WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (element != null) {
						logger.log(LogStatus.PASS, "Site " + siteListDB.get(0) + " present in UI and matched with DB.");
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");

					}
				}
				objHealthCheck.getSearchTextBox().clear();
			}

		} else {
			logger.log(LogStatus.INFO, "Green Color widget not present.");
		}

	}

	public void validateSiteListForRedCustomer() throws Exception {
		logger.log(LogStatus.INFO, "Validation of Site/FacilityName for 'Red' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIRed();
		WebElement redColor = objStatusCheck.getStatusCheckRed();
		if (redColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(redColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIRed(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI == siteListDB.size()) {
					logger.log(LogStatus.PASS, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				} else {
					logger.log(LogStatus.FAIL, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				}
				logger.log(LogStatus.INFO, "Site Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (element != null) {
							logger.log(LogStatus.PASS,
									"Site " + siteListDB.get(iSiteCount) + " present in UI and matched with DB.");
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but exists in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {

					WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (element != null) {
						logger.log(LogStatus.PASS, "Site " + siteListDB.get(0) + " present in UI and matched with DB.");
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");

					}
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Red Color widget not present.");
		}

	}

	public void validateSiteListForYellowCustomer() throws Exception {
		logger.log(LogStatus.INFO, "Validation of Site/FacilityName for 'Yellow' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIYellow();
		WebElement yellowColor = objStatusCheck.getStatusCheckYellow();
		if (yellowColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(yellowColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIYellow(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI == siteListDB.size()) {
					logger.log(LogStatus.PASS, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				} else {
					logger.log(LogStatus.FAIL, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				}
				logger.log(LogStatus.INFO, "Site Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (element != null) {
							logger.log(LogStatus.PASS,
									"Site " + siteListDB.get(iSiteCount) + " present in UI and matched with DB.");
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but present in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {

					WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (element != null) {
						logger.log(LogStatus.PASS, "Site " + siteListDB.get(0) + " present in UI and matched with DB.");
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");

					}
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Yellow Color widget not present.");
		}

	}

	public void validateSiteListForOrangeCustomer() throws Exception {
		logger.log(LogStatus.INFO, "Validation of Site/FacilityName for 'Orange' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIOrange();
		WebElement orangeColor = objStatusCheck.getStatusCheckOrange();
		if (orangeColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(orangeColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIOrange(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI == siteListDB.size()) {
					logger.log(LogStatus.PASS, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				} else {
					logger.log(LogStatus.FAIL, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				}
				logger.log(LogStatus.INFO, "Site Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (element != null) {
							logger.log(LogStatus.PASS,
									"Site " + siteListDB.get(iSiteCount) + " present in UI and matched with DB.");
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but present in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {

					WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (element != null) {
						logger.log(LogStatus.PASS, "Site " + siteListDB.get(0) + " present in UI and matched with DB.");
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");

					}
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Orange Color widget not present.");
		}

	}

	public void validateSiteListForGreyCustomer() throws Exception {
		logger.log(LogStatus.INFO, "Validation of Site/FacilityName for 'Grey' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIGrey();
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		if (greyColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greyColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIGrey(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI == siteListDB.size()) {
					logger.log(LogStatus.PASS, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				} else {
					logger.log(LogStatus.FAIL, "Site count for customer " + customerList.get(iCustomerCount)
							+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Site Count in UI:" + siteCountUI);
					logger.log(LogStatus.INFO, "Site Count in DB:" + siteListDB.size());
				}
				logger.log(LogStatus.INFO, "Site Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (element != null) {
							logger.log(LogStatus.PASS,
									"Site " + siteListDB.get(iSiteCount) + " present in UI and matched with DB.");
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but present in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {

					WebElement element = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (element != null) {
						logger.log(LogStatus.PASS, "Site " + siteListDB.get(0) + " present in UI and matched with DB.");
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");

					}
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Grey Color widget not present.");
		}

	}
	public void validateChillerListForGreenCustomer() throws Exception{
		logger.log(LogStatus.INFO, "Validation of Chillers for 'Green' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIGreen();
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		if (greenColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greenColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				String siteName;
				int chillerCountDB=0;
				int chillerCountUI=0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIGreen(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(4000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				List<String> chillerListDB = new ArrayList<String>();
				logger.log(LogStatus.INFO, "Chiller Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						if (siteListDB.get(iSiteCount).contains("\'")) {
							siteName = siteListDB.get(iSiteCount).replaceAll("\'", "''");
						} else {
							siteName = siteListDB.get(iSiteCount);
						}
						WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (siteUI != null) {
							try{
							action.moveToElement(siteUI).click().build().perform();
							}catch(WebDriverException e){
								action.moveToElement(siteUI).click().build().perform();
							}
							chillerCountUI= chillerCountUI+Integer.parseInt(countHeaders.get(2).getText().substring(6));
							chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIGreen(customerName,siteName);
							chillerCountDB=chillerCountDB+chillerListDB.size();
							for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
								WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
								if(chillerUI!=null){
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
								}
								else{
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
								}
							}
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but exists in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {
					if (siteListDB.get(0).contains("\'")) {
						siteName = siteListDB.get(0).replaceAll("\'", "''");
					} else {
						siteName = siteListDB.get(0);
					}
					WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (siteUI != null) {
						try{
						action.moveToElement(siteUI).click().build().perform();
						}catch(WebDriverException e){
							action.moveToElement(siteUI).click().build().perform();
						}
						chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIGreen(customerName,siteName);
						chillerCountDB=chillerCountDB+chillerListDB.size();
						chillerCountUI=Integer.parseInt(countHeaders.get(2).getText().substring(6));
						for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
							WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
							if(chillerUI!=null){
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
							}
							else{
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
							}
						}
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");
					}
				}
				if(chillerCountUI==chillerCountDB){
					logger.log(LogStatus.PASS, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				else{
					logger.log(LogStatus.FAIL, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
				chillerListDB.clear();			
			}

		} else {
			logger.log(LogStatus.INFO, "Green Color widget not present.");
		}		

	}
	public void validateChillerListForRedCustomer() throws Exception{
		logger.log(LogStatus.INFO, "Validation of Chillers for 'Red' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIRed();
		WebElement redColor = objStatusCheck.getStatusCheckRed();
		if (redColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(redColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				String siteName;
				int chillerCountDB=0;
				int chillerCountUI=0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIRed(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(4000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				List<String> chillerListDB = new ArrayList<String>();
				logger.log(LogStatus.INFO, "Chiller Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						if (siteListDB.get(iSiteCount).contains("\'")) {
							siteName = siteListDB.get(iSiteCount).replaceAll("\'", "''");
						} else {
							siteName = siteListDB.get(iSiteCount);
						}
						WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (siteUI != null) {
							siteUI.click();
							chillerCountUI= chillerCountUI+Integer.parseInt(countHeaders.get(2).getText().substring(6));
							chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIRed(customerName,siteName);
							chillerCountDB=chillerCountDB+chillerListDB.size();
							for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
								WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
								if(chillerUI!=null){
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
								}
								else{
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
								}
							}
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but exists in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {
					if (siteListDB.get(0).contains("\'")) {
						siteName = siteListDB.get(0).replaceAll("\'", "''");
					} else {
						siteName = siteListDB.get(0);
					}
					WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (siteUI != null) {
						siteUI.click();
						chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIRed(customerName,siteName);
						chillerCountDB=chillerCountDB+chillerListDB.size();
						chillerCountUI=Integer.parseInt(countHeaders.get(2).getText().substring(6));
						for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
							WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
							if(chillerUI!=null){
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
							}
							else{
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
							}
						}
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");
					}
				}
				if(chillerCountUI==chillerCountDB){
					logger.log(LogStatus.PASS, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				else{
					logger.log(LogStatus.FAIL, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
				chillerListDB.clear();
			}

		} else {
			logger.log(LogStatus.INFO, "Red Color widget not present.");
		}		
	}
	public void validateChillerListForYellowCustomer() throws Exception{
		logger.log(LogStatus.INFO, "Validation of Chillers for 'Yellow' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIYellow();
		WebElement yellowColor = objStatusCheck.getStatusCheckYellow();
		if (yellowColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(yellowColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				String siteName;
				int chillerCountDB=0;
				int chillerCountUI=0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIYellow(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(4000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				List<String> chillerListDB = new ArrayList<String>();
				logger.log(LogStatus.INFO, "Chiller Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						if (siteListDB.get(iSiteCount).contains("\'")) {
							siteName = siteListDB.get(iSiteCount).replaceAll("\'", "''");
						} else {
							siteName = siteListDB.get(iSiteCount);
						}
						WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (siteUI != null) {
							siteUI.click();
							chillerCountUI= chillerCountUI+Integer.parseInt(countHeaders.get(2).getText().substring(6));
							chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIYellow(customerName,siteName);
							chillerCountDB=chillerCountDB+chillerListDB.size();
							for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
								WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
								if(chillerUI!=null){
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
								}
								else{
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
								}
							}
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but exists in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {
					if (siteListDB.get(0).contains("\'")) {
						siteName = siteListDB.get(0).replaceAll("\'", "''");
					} else {
						siteName = siteListDB.get(0);
					}
					WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (siteUI != null) {
						siteUI.click();
						chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIYellow(customerName,siteName);
						chillerCountDB=chillerCountDB+chillerListDB.size();
						chillerCountUI=Integer.parseInt(countHeaders.get(2).getText().substring(6));
						for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
							WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
							if(chillerUI!=null){
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
							}
							else{
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
							}
						}
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");
					}
				}
				if(chillerCountUI==chillerCountDB){
					logger.log(LogStatus.PASS, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				else{
					logger.log(LogStatus.FAIL, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
				chillerListDB.clear();
			}

		} else {
			logger.log(LogStatus.INFO, "Yellow Color widget not present.");
		}		
	}
	public void validateChillerListForOrangeCustomer() throws Exception{
		logger.log(LogStatus.INFO, "Validation of Chillers for 'Orange' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIOrange();
		WebElement orangeColor = objStatusCheck.getStatusCheckOrange();
		if (orangeColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(orangeColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				String siteName;
				int chillerCountDB=0;
				int chillerCountUI=0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIOrange(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(4000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				List<String> chillerListDB = new ArrayList<String>();
				logger.log(LogStatus.INFO, "Chiller Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						if (siteListDB.get(iSiteCount).contains("\'")) {
							siteName = siteListDB.get(iSiteCount).replaceAll("\'", "''");
						} else {
							siteName = siteListDB.get(iSiteCount);
						}
						WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (siteUI != null) {
							siteUI.click();
							chillerCountUI= chillerCountUI+Integer.parseInt(countHeaders.get(2).getText().substring(6));
							chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIOrange(customerName,siteName);
							chillerCountDB=chillerCountDB+chillerListDB.size();
							for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
								WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
								if(chillerUI!=null){
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
								}
								else{
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
								}
							}
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but exists in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {
					if (siteListDB.get(0).contains("\'")) {
						siteName = siteListDB.get(0).replaceAll("\'", "''");
					} else {
						siteName = siteListDB.get(0);
					}
					WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (siteUI != null) {
						siteUI.click();
						chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIOrange(customerName,siteName);
						chillerCountDB=chillerCountDB+chillerListDB.size();
						chillerCountUI=Integer.parseInt(countHeaders.get(2).getText().substring(6));
						for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
							WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
							if(chillerUI!=null){
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
							}
							else{
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
							}
						}
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");
					}
				}
				if(chillerCountUI==chillerCountDB){
					logger.log(LogStatus.PASS, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				else{
					logger.log(LogStatus.FAIL, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
				chillerListDB.clear();
			}

		} else {
			logger.log(LogStatus.INFO, "Orange Color widget not present.");
		}		
	}
	public void validateChillerListForGreyCustomer() throws Exception{
		logger.log(LogStatus.INFO, "Validation of Chillers for 'Grey' Color Widget.");
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIGrey();
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		if (greyColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greyColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				String siteName;
				int chillerCountDB=0;
				int chillerCountUI=0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteListDB = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIGrey(customerName);
				if (siteListDB.size() == 0) {
					objHealthCheck.getSearchTextBox().clear();
					continue;
				}
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				Thread.sleep(4000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				List<String> chillerListDB = new ArrayList<String>();
				logger.log(LogStatus.INFO, "Chiller Details for customer " + customerList.get(iCustomerCount) + ":");
				if (siteCountUI > 1) {
					for (int iSiteCount = 0; iSiteCount < siteListDB.size(); iSiteCount++) {
						Thread.sleep(4000);
						if (siteListDB.get(iSiteCount).contains("\'")) {
							siteName = siteListDB.get(iSiteCount).replaceAll("\'", "''");
						} else {
							siteName = siteListDB.get(iSiteCount);
						}
						WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(iSiteCount));
						if (siteUI != null) {
							siteUI.click();
							chillerCountUI= chillerCountUI+Integer.parseInt(countHeaders.get(2).getText().substring(6));
							chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIGrey(customerName,siteName);
							chillerCountDB=chillerCountDB+chillerListDB.size();
							for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
								WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
								if(chillerUI!=null){
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
								}
								else{
									logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
								}
							}
						} else {
							logger.log(LogStatus.FAIL,
									"Site " + siteListDB.get(iSiteCount) + " not present in UI but exists in DB.");
						}
					}
				} else if (siteListDB.size() == 1) {
					if (siteListDB.get(0).contains("\'")) {
						siteName = siteListDB.get(0).replaceAll("\'", "''");
					} else {
						siteName = siteListDB.get(0);
					}
					WebElement siteUI = objStatusCheck.getProjectInSearchResult(siteListDB.get(0));
					if (siteUI != null) {
						siteUI.click();
						chillerListDB=CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIGrey(customerName,siteName);
						chillerCountDB=chillerCountDB+chillerListDB.size();
						chillerCountUI=Integer.parseInt(countHeaders.get(2).getText().substring(6));
						for(int iChillerCount=0;iChillerCount<chillerListDB.size();iChillerCount++){
							WebElement chillerUI = objStatusCheck.getAssetInSearchResult(chillerListDB.get(iChillerCount));
							if(chillerUI!=null){
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is present in UI and matched with DB.");
							}
							else{
								logger.log(LogStatus.PASS, "Chiller '"+chillerListDB.get(iChillerCount)+"' is not present in UI but exists in DB.");
							}
						}
					} else {
						logger.log(LogStatus.FAIL,
								"Site " + siteListDB.get(0) + " not present in UI but exists in DB.");
					}
				}
				if(chillerCountUI==chillerCountDB){
					logger.log(LogStatus.PASS, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				else{
					logger.log(LogStatus.FAIL, "Chiller count for customer " + customerList.get(iCustomerCount)
					+ " is not matching with DB data.");
					logger.log(LogStatus.INFO, "Chiller Count in UI:" + chillerCountUI);
					logger.log(LogStatus.INFO, "Chiller Count in DB:" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
				chillerListDB.clear();
			}

		} else {
			logger.log(LogStatus.INFO, "Grey Color widget not present.");
		}		
	}
	
	CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
	CEP_CustomerListByStatus_Page_Factory objCustList = new CEP_CustomerListByStatus_Page_Factory(driver);
	CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
	List<String> customerList = CEP_HeatMap_DataBase_Action.statusCheckCustomerListJCIGreen();
	
	@Override
	public void run() {
		System.out.println("In Thread: "+Thread.currentThread().getName());
		try{
		Thread.sleep(2000);
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		if (greenColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greenColor).click().build().perform();
			for (int iCustomerCount = 0; iCustomerCount < customerList.size(); iCustomerCount++) {
				String customerName;
				int chillerCountUI = 0;
				if (customerList.get(iCustomerCount).contains("\'")) {
					customerName = customerList.get(iCustomerCount).replaceAll("\'", "''");
				} else {
					customerName = customerList.get(iCustomerCount);
				}
				List<String> siteNames = CEP_HeatMap_DataBase_Action.statusCheckProjectListJCIGreen(customerName);
				List<String> chillerNames = CEP_HeatMap_DataBase_Action.statusCheckAssetListJCIGreen(customerName);
				objHealthCheck.getSearchTextBox().sendKeys(customerList.get(iCustomerCount));
				WebElement customer = objHealthCheck.getCustomerInSearchResult(customerList.get(iCustomerCount));
				customer.click();
				List<WebElement> countHeaders = objCustList.getCountHeaderList();
				int customerCountUI = Integer.parseInt(countHeaders.get(0).getText().substring(6));
				Thread.sleep(2000);
				int siteCountUI = Integer.parseInt(countHeaders.get(1).getText().substring(6));
				if (siteCountUI > 1) {
					System.out.println(siteCountUI);
					for (int iSiteCount = 0; iSiteCount < siteNames.size(); iSiteCount++) {
						try {
							WebElement element = objStatusCheck.getProjectInSearchResult(siteNames.get(iSiteCount));
							action.moveToElement(element).click().build().perform();
							chillerCountUI = chillerCountUI
									+ Integer.parseInt(countHeaders.get(2).getText().substring(6));
						} catch (Exception e) {
							logger.log(LogStatus.FAIL, "Site " + siteNames.get(iSiteCount) + " not present in UI.");
						}
					}
				} else {
					chillerCountUI = Integer.parseInt(countHeaders.get(2).getText().substring(6));
				}
				int customerCountDB = customerList.size();
				int siteCountDB = siteNames.size();
				int chillerCountDB = chillerNames.size();
				if ((customerCountUI == customerCountDB) && (siteCountUI == siteCountDB)
						&& (chillerCountUI == chillerCountDB)) {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Green color widget.");
					logger.log(LogStatus.PASS, "Counts are matching with DB for Green color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				} else {
					logger.log(LogStatus.PASS, "CustomerListByStatus changed for Green color widget.");
					logger.log(LogStatus.FAIL, "Counts are not matching with DB for Green color widget for '"
							+ customerList.get(iCustomerCount) + "'.");
					logger.log(LogStatus.INFO, "Count of Customers in UI and in DB are:UI-" + customerCountUI
							+ " and DB-" + customerCountDB);
					logger.log(LogStatus.INFO, "Count of Projects in UI and in DB for '"
							+ customerList.get(iCustomerCount) + "' are:UI-" + siteCountUI + " and DB-" + siteCountDB);
					logger.log(LogStatus.INFO,
							"Count of Chillers in UI and in DB for '" + customerList.get(iCustomerCount) + "' are:UI-"
									+ chillerCountUI + " and DB-" + chillerCountDB);
				}
				objHealthCheck.getSearchTextBox().clear();
			}
		} else {
			logger.log(LogStatus.INFO, "Green Color widget not present.");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
		latch.countDown();
	}
}
