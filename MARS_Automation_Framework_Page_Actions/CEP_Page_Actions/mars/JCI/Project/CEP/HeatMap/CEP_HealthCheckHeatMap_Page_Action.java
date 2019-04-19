package mars.JCI.Project.CEP.HeatMap;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebDropDown;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Factory;

public class CEP_HealthCheckHeatMap_Page_Action extends BaseClass {
	@SuppressWarnings("static-access")
	public CEP_HealthCheckHeatMap_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void selectHealthCheck() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHeatMap = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		Thread.sleep(10000);
		WebElement chillerStatusDropDown = objHeatMap.getChillerStatusDropDown();
		if (chillerStatusDropDown != null) {
			WebDropDown.selectByDesiredIndex(chillerStatusDropDown, 1, logger);
			logger.log(LogStatus.PASS, "Health Check option is present and selected.");
			Select select=new Select(chillerStatusDropDown);
			select.selectByIndex(0);
			Thread.sleep(6000);
			select.selectByIndex(1);
			Thread.sleep(6000);
		} else {
			logger.log(LogStatus.FAIL, "Health Check option is not present.");
		}
	}

	public void validateHealthCheckColorBifurcation() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHeatMap = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		WebElement healthCheckGreen = objHeatMap.getHealthCheckGreen();
		if (healthCheckGreen != null) {
			logger.log(LogStatus.PASS, "Heat map bifurcation is based on colors and is as expected.");
			getFinalReport(driver, logger, "testSmokeHealthCheckBifurcation", true);
		} else {
			logger.log(LogStatus.FAIL, "Heat map bifurcation is not based on colors.");
			getFinalReport(driver, logger, "testSmokeHealthCheckBifurcation", false);
		}
	}

	public void validateColorWidget() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHeatMap = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		WebElement healthCheckGreen = objHeatMap.getHealthCheckGreen();
		if (healthCheckGreen != null) {
			Actions action = new Actions(driver);
			action.moveToElement(healthCheckGreen).click().build().perform();
			//Thread.sleep(10000);
			logger.log(LogStatus.PASS, "Functionality of Color Widget is as expected.");
			getFinalReport(driver, logger, "testSmokeHealthCheckColorWidget", true);
		} else {
			logger.log(LogStatus.FAIL, "Heat map bifurcation is not based on colors.");
			getFinalReport(driver, logger, "testSmokeHealthCheckColorWidget", false);
		}

	}

	public void healthCheckTotalCountOfGreen() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHeatMap = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		WebElement totalGreenCount = objHeatMap.getHealthCheckCountOfGreenColor();
		int countFromDB = CEP_HeatMap_DataBase_Action.healthCheckTotalGreenCount();
		if (totalGreenCount != null) {
			Actions action = new Actions(driver);
			action.moveToElement(totalGreenCount).build().perform();
			int count = Integer.parseInt(totalGreenCount.getText());
			if (count == countFromDB) {
				logger.log(LogStatus.PASS, "Count for Color Widget present and is matching with DB.");
				logger.log(LogStatus.INFO, "Count from DB is:" + countFromDB);
				logger.log(LogStatus.INFO, "Count in the UI is:" + count);
			} else {
				logger.log(LogStatus.FAIL, "Count for Color Widget is not matching with DB.");
				logger.log(LogStatus.INFO, "Count from DB is:" + countFromDB);
				logger.log(LogStatus.INFO, "Count in the UI is:" + count);
			}

		} else {
			logger.log(LogStatus.FAIL, "Count for Color Widget not present.");
		}
	}

	public void defaultColorWidget() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHeatMap = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		String customer = CEP_HeatMap_DataBase_Action.healthCheckGreenCustomer();
		WebElement customerUI;
		WebElement searchTextBox = objHeatMap.getSearchTextBox();
		if (searchTextBox != null) {
			searchTextBox.sendKeys(customer);
			customerUI = objHeatMap.getCustomerInSearchResult(customer);
			if ((customerUI != null) && (customerUI.getText().equalsIgnoreCase(customer))) {
				logger.log(LogStatus.PASS, "Default Color Widget is as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Default Color Widget is as not expected.");
		}
	}

	public void validateGreenCountGeography() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		List<String> geographies = CEP_LeftPanel_DataBase_Action.geographyListDB();
		for (int iCount = 0; iCount < geographies.size(); iCount++) {
			int countDB = CEP_HeatMap_DataBase_Action.greenCountForGeography(geographies.get(iCount));
			String customer=CEP_HeatMap_DataBase_Action.getFirstCustomerName("GeographyName", geographies.get(iCount));
			WebElement search=objLeftPanel.getSearchBox();
					search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(geographies.get(iCount), "1");
			//WebElement elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action=new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(8000);
		        WebElement element1 = objHealthCheck.getHealthCheckCountOfGreenColor();
				if (element1 != null) {
					int count = Integer.parseInt(objHealthCheck.getHealthCheckCountOfGreenColor().getText());
					if (count == countDB) {
						logger.log(LogStatus.PASS,
								"Color widget changed after clicking on '" + geographies.get(iCount) + "'");
						logger.log(LogStatus.PASS, "Count of Chillers for color widget matching with DB.");
						logger.log(LogStatus.INFO, "Count in UI is:" + count);
						logger.log(LogStatus.INFO, "Count from DB is:" + countDB);
					} else {
						logger.log(LogStatus.FAIL, "Count of Chillers for "+geographies.get(iCount)+" color widget not matching with DB.");
						logger.log(LogStatus.INFO, "Count in UI is:" + count);
						logger.log(LogStatus.INFO, "Count from DB is:" + countDB);
					}
				} else {
					logger.log(LogStatus.FAIL, "Color widget not present for '"+geographies.get(iCount)+"'");
				}

			} else {
				logger.log(LogStatus.FAIL, "Geography " + geographies.get(iCount) + " not present.");
			}
			search.clear();
		}
	}
	public void validateGreenCountCountry() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		List<String> countries = CEP_LeftPanel_DataBase_Action.countryListDB();
		for (int iCount = 0; iCount < countries.size(); iCount++) {
			int countDB = CEP_HeatMap_DataBase_Action.greenCountForCountry(countries.get(iCount));
			String customer=CEP_HeatMap_DataBase_Action.getFirstCustomerName("CountryName", countries.get(iCount));
			WebElement search=objLeftPanel.getSearchBox();
					search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(countries.get(iCount), "2");
			//WebElement elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action=new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(8000);
		        WebElement element1 = objHealthCheck.getHealthCheckCountOfGreenColor();
				if (element1 != null) {
					int count = Integer.parseInt(objHealthCheck.getHealthCheckCountOfGreenColor().getText());
					if (count == countDB) {
						logger.log(LogStatus.PASS,
								"Color widget changed after clicking on '" + countries.get(iCount) + "'");
						logger.log(LogStatus.PASS, "Count of Chillers for color widget matching with DB.");
						logger.log(LogStatus.INFO, "Count in UI is:" + count);
						logger.log(LogStatus.INFO, "Count from DB is:" + countDB);
					} else {
						logger.log(LogStatus.FAIL, "Count of Chillers for "+countries.get(iCount)+" color widget not matching with DB.");
						logger.log(LogStatus.INFO, "Count in UI is:" + count);
						logger.log(LogStatus.INFO, "Count from DB is:" + countDB);
					}
				} else {
					logger.log(LogStatus.FAIL, "Color widget not present for '"+countries.get(iCount)+"'");
				}

			} else {
				logger.log(LogStatus.FAIL, "Country " + countries.get(iCount) + " not present.");
			}
			search.clear();
		}
	}
	public void validateGreenCountBranch() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		List<String> branches = CEP_LeftPanel_DataBase_Action.branchListDB();
		for (int iCount = 0; iCount < branches.size(); iCount++) {
			int countDB = CEP_HeatMap_DataBase_Action.greenCountForBranch(branches.get(iCount));
			String customer=CEP_HeatMap_DataBase_Action.getFirstCustomerName("BranchName", branches.get(iCount));
			WebElement search=objLeftPanel.getSearchBox();
					search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(branches.get(iCount), "3");
			//WebElement elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action=new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(8000);
		        WebElement element1 = objHealthCheck.getHealthCheckCountOfGreenColor();
				if (element1 != null) {
					int count = Integer.parseInt(objHealthCheck.getHealthCheckCountOfGreenColor().getText());
					if (count == countDB) {
						logger.log(LogStatus.PASS,
								"Color widget changed after clicking on '" + branches.get(iCount) + "'");
						logger.log(LogStatus.PASS, "Count of Chillers for color widget matching with DB.");
						logger.log(LogStatus.INFO, "Count in UI is:" + count);
						logger.log(LogStatus.INFO, "Count from DB is:" + countDB);
					} else {
						logger.log(LogStatus.FAIL, "Count of Chillers for "+branches.get(iCount)+" color widget not matching with DB.");
						logger.log(LogStatus.INFO, "Count in UI is:" + count);
						logger.log(LogStatus.INFO, "Count from DB is:" + countDB);
					}
				} else {
					logger.log(LogStatus.FAIL, "Color widget not present for '"+branches.get(iCount)+"'");
				}

			} else {
				logger.log(LogStatus.FAIL, "Branch" + branches.get(iCount) + "not present.");
			}
			search.clear();
		}
	}
}