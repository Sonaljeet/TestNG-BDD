package mars.JCI.Project.DES.SiteOverview;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.JCI.Project.DES.API_Page_Action.DES_API_Page_Action;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Factory;
import mars.JCI.Project.DES.SiteOverView.DES_SiteOverView_Page_Factory;

public class DES_SiteOverview_Page_Action {
	/** The driver. */
	private static WebDriver driver;
	/** The logger. */
	private static ExtentTest logger;
	private WebElement element;
	public static String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";

	/** The login page. */

	private static DES_SiteOverView_Page_Factory sitePF = null;
	private static DES_Home_Page_Action homePA = null;

	public DES_SiteOverview_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		sitePF = new DES_SiteOverView_Page_Factory(driver, logger);
		homePA = new DES_Home_Page_Action(driver, logger);
	}

	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingHome");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

	public static void waitForSiteInfoSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingsiteInfo");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForPowerWidgetSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingPanel");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForBatteryHealthWidgetSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingSiteSystemHealth");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForSiteEnergyOverviewSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingSiteEnergyOverview");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForSOCTrendChartSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingsoctrendchart");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForPowerTrendChartSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingcurrentpowertrend");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForAlarmWidgetSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingAlarms");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public void searchText(String searchString) {

		element = sitePF.getSearchBox();
		if (element != null) {
			if (element.isDisplayed()) {
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Username");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, searchString);
				logger.log(LogStatus.PASS, "Customer Entered succesfully to User Name WebElement");
			}
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Field Failed");
		}

	}

	public void getSiteInfoWidget() throws InterruptedException {
		try {
			element = sitePF.getsiteInfoWidget();
			if (element != null) {
				element.click();
				waitForSpinnerToDisappear();
				waitForSiteInfoSpinnerToDisappear();
				String siteinfolink = element.getText();
				System.out.println("Navigate to --> " + siteinfolink);

				List<WebElement> siteDetails = driver.findElements(By.xpath("//div[@class='col-xs-7']/p"));
				for (WebElement sitedetailsElement : siteDetails) {
					Thread.sleep(1000);
					waitForSiteInfoSpinnerToDisappear();
					String sitedetailsavailable = sitedetailsElement.getText();
					String detailsValue = sitedetailsElement.getCssValue(sitedetailsavailable).toString();
					logger.log(LogStatus.PASS, sitedetailsavailable + detailsValue);
				}
				element = sitePF.getsiteLogo();
				if (element != null) {

					System.out.println("Site Logo is stored at " + element.getAttribute("src"));
				} else {
					System.out.println("Cound Not find Site Logo");
				}
				element = sitePF.getcloseSiteInfoWidget();
				if (element != null) {
					element.click();
					waitForSpinnerToDisappear();
					System.out.println("Site info widgets is Closed");
				}
			}
			logger.log(LogStatus.PASS, "Successfully Found Site Info Widget");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to find the Site Info Widget");
		}
	}

	public void getSiteInfo() throws InterruptedException {
		try {
			getSiteFromDashBoard();
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			getSiteInfoWidget();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Successfully Validated Site Info details");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to find the Site Info");
		}
	}

	public void getListOfCustomer() throws InterruptedException {
		try {
			homePA.navigateToSiteOverviewPage();
			List<WebElement> customerList = driver.findElements(By.xpath("//div/ol[@automation-id='customerTree']"));
			Iterator<WebElement> itr = customerList.iterator();
			while (itr.hasNext()) {
				WebElement customerName = itr.next();
				System.out.println(customerName.getText());
			}
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Succsesfully Collected List of Sites");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to Collect List of Sites");
			e.printStackTrace();
		}
	}

	public void getSiteFromDashBoard() throws InterruptedException {
		try {

			String siteJsonPath = "$..SiteDetails.*";
			List<String> SiteDetails1 = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), siteJsonPath);
			homePA.navigateToSiteOverviewPage();
			searchText(SiteDetails1.get(13).toString());
			WebElement qaSite = driver.findElement(By.xpath("//span[@class='ui-match']"));
			qaSite.click();
			Thread.sleep(2000);
			waitForAlarmWidgetSpinnerToDisappear();
			System.out.println("Name of the Site search is " + qaSite.getText());
			logger.log(LogStatus.PASS, "Succsesfully got site from dashboard");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Failed to locate expected site");
			e.printStackTrace();
		}
	}

	public void validateSiteOverviewWidgetsLoad() throws InterruptedException {
		String siteJsonPath="$..UATSiteName";
		
		List<String> siteNameFromJson= ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), siteJsonPath);
		String siteName=siteNameFromJson.get(0).toString();
		try {			
			homePA.navigateToSiteOverviewPage();
			searchText(siteName);// Zucker Building
			WebElement qaSite = driver.findElement(By.xpath("//span[@class='ui-match']"));
			System.out.println("Name of the Site search is " + qaSite.getText());
			qaSite.click();
			waitForSpinnerToDisappear();
			System.out.println("Waiting to Load Widget Data");
			Thread.sleep(3000);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Searched for " + qaSite.getText());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to Search Demo site");

		}
	}

	public String getStateOfChargeDetails() throws InterruptedException {
		String DCCapacity = "", SOC = "";
		try {
			waitForSiteEnergyOverviewSpinnerToDisappear();
			validateSiteOverviewWidgetsLoad();
			element = sitePF.getenergyWidget();
			if (element != null) {
				System.out.println("STATE OF CHARGE Widget is available for Site at Location " + element.getLocation());
				element = sitePF.getbatteryLevelPercentage();
				if (element != null) {
					waitForSiteEnergyOverviewSpinnerToDisappear();
					SOC = element.getText();
					logger.log(LogStatus.PASS, "Current Energy " + SOC);

				}
				element = sitePF.getDCCapacity();
				if (element != null) {
					waitForSiteEnergyOverviewSpinnerToDisappear();
					DCCapacity = element.getText();
					logger.log(LogStatus.PASS, "Current Battary DC Capacity  is " + DCCapacity);
				}

			}
			logger.log(LogStatus.PASS, "Succsesfully Validated Energgy Template details for the Selected Site");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not Energy Templates Details for the Selected Site");

		}
		return SOC;
	}

	public String getDCCapacity() {
		String DCCapacity = "";
		try {
			waitForSiteEnergyOverviewSpinnerToDisappear();
			validateSiteOverviewWidgetsLoad();
			element = sitePF.getDCCapacity();
			if (element != null) {
				waitForSiteEnergyOverviewSpinnerToDisappear();
				DCCapacity = element.getText();
				logger.log(LogStatus.PASS, "Current Battary DC Capacity  is " + DCCapacity);
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not collect the DC Capacity value");
		}
		return DCCapacity;
	}

	public String getPowerDetails() throws InterruptedException {
		String aggchargevalue = "", power_value = "";
		try {
			validateSiteOverviewWidgetsLoad();
			waitForPowerWidgetSpinnerToDisappear();
			element = sitePF.getaggchargevalue();
			if (element != null) {
				aggchargevalue = element.getText();
				if (aggchargevalue != null) {
					System.out.println("agg. charge value " + aggchargevalue);
				}
				element = sitePF.getaggchargevalueUnit();
				if (element != null) {
					String unit = element.getText();
					power_value = aggchargevalue + "" + unit;
					logger.log(LogStatus.PASS, "Aggregate charge value =" + power_value);
				}
				waitForPowerWidgetSpinnerToDisappear();

			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not Validated Power Details for the Selected Site");

		}
		return power_value;
	}

	public String getACCapacity() {
		String acCapacity = "";
		try {
			validateSiteOverviewWidgetsLoad();
			waitForPowerWidgetSpinnerToDisappear();
			element = sitePF.getACCapacity();
			if (element != null) {
				waitForPowerWidgetSpinnerToDisappear();
				acCapacity = element.getText();
				if (acCapacity != null) {
					System.out.println("Ac Capacity   is " + acCapacity);
				}
				logger.log(LogStatus.PASS, "Succsesfully validated Power Details for the Selected Site");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to get AC Capacity value");
		}
		return acCapacity;
	}

	public String getBatteryStateHealthDetails() throws InterruptedException {
		String BSOCH = "";
		try {
			waitForSpinnerToDisappear();
			waitForBatteryHealthWidgetSpinnerToDisappear();
			validateSiteOverviewWidgetsLoad();

			element = sitePF.getpowerPercentageValue();
			if (element != null) {
				waitForBatteryHealthWidgetSpinnerToDisappear();
				BSOCH = element.getText() + "%";
				System.out.println("Power percentage for site is " + BSOCH);
				logger.log(LogStatus.PASS,
						"Succsesfully validated Battery State of Health Details for the Selected Site");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Could not Validated Battery State of Health Details for the Selected Site" + e.getMessage());

		}
		return BSOCH;
	}

	public String getLastDataCollectedDetails() {
		String Time = "", Date = "", LastDataCollected = "";
		try {
			waitForSpinnerToDisappear();
			waitForBatteryHealthWidgetSpinnerToDisappear();
			validateSiteOverviewWidgetsLoad();

			element = sitePF.getSiteName();
			if (element != null) {
				waitForBatteryHealthWidgetSpinnerToDisappear();
				System.out.println("Site Name " + element.getText());
			}
			waitForBatteryHealthWidgetSpinnerToDisappear();
			element = sitePF.getsystemHealthWidget();
			if (element != null) {
				System.out.println("Battery State of Health Widget is Present");
				element = sitePF.getcommissionDate();
				if (element != null) {
					waitForBatteryHealthWidgetSpinnerToDisappear();
					System.out.println("Commissioning Date for the Site is " + element.getText());
				}
			}
			element = sitePF.getlatDataCollectedDate();
			if (element != null) {
				waitForBatteryHealthWidgetSpinnerToDisappear();
				Date = element.getText();
				System.out.println("Last Data collected Date is  " + Date);
			}
			element = sitePF.getlatDataCollectedTime();
			if (element != null) {
				waitForBatteryHealthWidgetSpinnerToDisappear();
				Time = element.getText();
				System.out.println("Last Data collected Time is  " + Time);
			}

			LastDataCollected = Date + " " + Time;

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to collect system details");
		}
		return LastDataCollected;
	}

	public void getSOCTrendGraph() throws InterruptedException {
		try {
			waitForSOCTrendChartSpinnerToDisappear();
			validateSiteOverviewWidgetsLoad();
			element = sitePF.getsocTrendWidget();
			Thread.sleep(2000);
			if (element != null) {
				element = sitePF.getsocGraphMax();
				if (element != null) {
					waitForSOCTrendChartSpinnerToDisappear();
					element.click();
					List<WebElement> filter1 = driver.findElements(By.xpath("//div[@automation-id='socTrendWidget']"));
					Iterator<WebElement> itr = filter1.iterator();
					while (itr.hasNext()) {
						WebElement filterItem = itr.next();
						logger.log(LogStatus.PASS,
								" Filteres and current Graph shown for the Dates " + filterItem.getText());
					}
					Thread.sleep(2000);
					for (int i = 2; i <= 5; i++) {
						WebElement graphFilter = driver.findElement(By.xpath("//*[@id='socTrend']/div/div[2]/widget-time-span/div/div[2]/button[" + i + "]"));
						waitForSOCTrendChartSpinnerToDisappear();
						graphFilter.click();
						logger.log(LogStatus.PASS, "Verifying the Graph For Filter " + graphFilter.getText());
					}
					element = sitePF.getsocGraphMax();
					if (element != null) {
						waitForSOCTrendChartSpinnerToDisappear();
						element.click();
					}
				}
				logger.log(LogStatus.PASS, "Succsesfully validated SOC Trend for the Selected Site");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not Validated SOC Trend for the Selected Site");

		}

	}

	public void getcurrentPowerTrendGraph() throws InterruptedException {
		try {
			waitForPowerTrendChartSpinnerToDisappear();
			validateSiteOverviewWidgetsLoad();
			element = sitePF.getcurrentPowerTrendWidget();
			if (element != null) {
				element = sitePF.getcurrentPowerGraphMax();
				if (element != null) {
					waitForPowerTrendChartSpinnerToDisappear();
					element.click();
					List<WebElement> filter1 = driver
							.findElements(By.xpath("//div[@automation-id='currentpowerWidget']"));
					Iterator<WebElement> itr = filter1.iterator();
					while (itr.hasNext()) {
						waitForPowerTrendChartSpinnerToDisappear();
						WebElement filterItem = itr.next();
						logger.log(LogStatus.PASS,
								" Filteres and current Graph shown for the Dates " + filterItem.getText());
					}
					Thread.sleep(1000);
					for (int i = 2; i <= 5; i++) {
						WebElement graphFilter = driver.findElement(
								By.xpath("//*[@id='currentPowerTrend']/div/div[2]/widget-time-span/div/div[2]/button["
										+ i + "]"));
						waitForPowerTrendChartSpinnerToDisappear();
						graphFilter.click();
						waitForPowerTrendChartSpinnerToDisappear();
						logger.log(LogStatus.PASS, "Verifying the Graph For Filter " + graphFilter.getText());
					}
					element = sitePF.getcurrentPowerGraphMax();
					if (element != null) {
						waitForPowerTrendChartSpinnerToDisappear();
						element.click();
					}
					logger.log(LogStatus.PASS, "Succsesfully validated current Power Trend for the Selected Site");
				}
			}
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not validated current Power Trend for the Selected Site");

		}

	}

	public void getAlarmsDetailsForSite() {
		try {
			waitForAlarmWidgetSpinnerToDisappear();
			validateSiteOverviewWidgetsLoad();
			element = sitePF.getalrmWidgetHeader();
			if (element != null) {
				waitForAlarmWidgetSpinnerToDisappear();
				logger.log(LogStatus.PASS, element.getText() + " Header for Widget is present");
			}
			element = sitePF.getalarmsExpansionBtn();
			Thread.sleep(1000);
			if (element != null) {
				waitForAlarmWidgetSpinnerToDisappear();
				element.click();
				WebElement tableHeader = driver.findElement(By.xpath("//table/thead/tr"));
				if (tableHeader != null) {
					waitForAlarmWidgetSpinnerToDisappear();
					System.out.println(tableHeader.getText());
					List<WebElement> alarms = driver.findElements(By.xpath("//tbody/tr"));
					for (int i = 1; i <= alarms.size() - 1; i++) {
						WebElement alarmItem = driver
								.findElement(By.xpath("//*[@id='alarmsmainContent']/div/table/tbody/tr[" + i + "]"));

						logger.log(LogStatus.PASS, alarmItem.getText());
						logger.log(LogStatus.PASS, "-----------------------------------------");
					}
					element = sitePF.getalarmsExpansionBtn();
					if (element != null) {
						waitForAlarmWidgetSpinnerToDisappear();
						element.click();
						logger.log(LogStatus.PASS, "Succsesfully validated Alarms Appeared for the Selected Site");
					}
					
				} else {
					System.out.println("No data Available in Alarm Section");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Failed to Validated Alarms Data");
			e.printStackTrace();
		}
	}

	public void validateSiteOverviewWidgets() {
		try {
			validateSiteOverviewWidgetsLoad();
			element = sitePF.getenergyWidget();
			if (element != null) {
				System.out.println(
						"Energy/Template Enegry Widget is available for Site at Location " + element.getLocation());
				element = sitePF.getbatteryLevelPercentage();
				if (element != null) {
					System.out.println("current Energy " + element.getText() + "%");
				}
				element = sitePF.getDCCapacity();
				if (element != null) {
					System.out.println("current Battary DC Capacity is " + element.getText());
				}

			}

			// ** Power Widget *//*
			element = sitePF.getaggPowerSummary();
			if (element != null) {
				System.out.println("Power Widget is available for Site At Location" + element.getLocation());
				element = sitePF.getaggPowerSummarychart();
				if (element != null) {
					System.out.println("Aggregated Power Logo size is -" + element.getSize());
				}
				element = sitePF.getaggPowerSummaryvalue();
				if (element != null) {
					System.out.println("Aggregated Power of the Site is " + element.getText() + "kW");
				}
			}

			// ** System Health Widget *//*
			element = sitePF.getsystemHealthWidget();
			if (element != null) {
				System.out.println("System Health Widget is Present");
				element = sitePF.getcommissionDate();
				if (element != null) {
					System.out.println("Commissioning Date for the Site is " + element.getText());
				}
				element = sitePF.getlatDataCollectedDate();
				if (element != null) {
					System.out.println("Last Data collected Date and Time is  " + element.getText());
				}
				element = sitePF.getpowerPercentageValue();
				if (element != null) {
					System.out.println("BSOH value for the site is " + element.getText() + "%");
				}
			}

			// ** SOC Trend Widget *//*
			waitForSpinnerToDisappear();
			element = sitePF.getsocTrendWidget();
			if (element != null) {
				element = sitePF.getsocGraphMax();
				if (element != null) {
					element.click();
					List<WebElement> filter1 = driver.findElements(By.xpath("//div[@automation-id='socTrendWidget']"));

					Iterator<WebElement> itr = filter1.iterator();
					while (itr.hasNext()) {
						WebElement filterItem = itr.next();
						System.out.println(" Filters and current Graph shown for the Dates " + filterItem.getText());
					}
					Thread.sleep(2000);
					for (int i = 2; i <= 5; i++) {
						WebElement graphFilter = driver.findElement(By
								.xpath("//*[@id='socTrend']/div/div[2]/widget-time-span/div/div[2]/button[" + i + "]"));
						graphFilter.click();
						Thread.sleep(2000);
						waitForSpinnerToDisappear();
						System.out.println("Verifying the Graph For Filter " + graphFilter.getText());
						// WebElement graph=driver.findElements(By.)

						element = sitePF.getNoGraphDataAvailable();
						if (element != null) {
							System.out.println("Error--> " + element.getText());
						} else {
							System.out.println("Graph is present for the Filter Selected");
						}
					}
					element = sitePF.getsocGraphMax();
					if (element != null) {
						element.click();
					}
				}
			}

			// ** current Power Trend *//*
			waitForSpinnerToDisappear();
			element = sitePF.getcurrentPowerTrendWidget();
			if (element != null) {
				element = sitePF.getcurrentPowerGraphMax();
				if (element != null) {
					element.click();
					List<WebElement> filter1 = driver
							.findElements(By.xpath("//div[@automation-id='currentpowerWidget']"));
					Iterator<WebElement> itr = filter1.iterator();
					while (itr.hasNext()) {
						WebElement filterItem = itr.next();
						System.out.println("Filteres and current Graph shown for the Dates " + filterItem.getText());
					}
					Thread.sleep(2000);
					for (int i = 2; i <= 5; i++) {
						WebElement graphFilter = driver.findElement(
								By.xpath("//*[@id='currentPowerTrend']/div/div[2]/widget-time-span/div/div[2]/button["
										+ i + "]"));
						graphFilter.click();
						Thread.sleep(2000);
						System.out.println("Verifying the Power Trend Graph For Filter " + graphFilter.getText());
						element = sitePF.getNoGraphDataAvailable();
						if (element != null) {
							System.out.println("Error--> " + element.getText());
						} else {
							System.out.println("Graph is present for the Filter Selected");
						}
					}
					element = sitePF.getcurrentPowerGraphMax();
					if (element != null) {
						element.click();
					}
				}
			}

			// ** Alarms Widget *//*
			element = sitePF.getalrmWidgetHeader();
			if (element != null) {
				System.out.println(element.getText() + " Header for Widget is present");
			}
			element = sitePF.getalarmsExpansionBtn();
			if (element != null) {
				element.click();
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				WebElement tableHeader = driver.findElement(By.xpath("//table/thead/tr"));
				System.out.println(tableHeader.getText());

				List<WebElement> alarms = driver.findElements(By.xpath("//tbody/tr"));
				for (int i = 1; i <= alarms.size() - 1; i++) {
					WebElement alarmItem = driver
							.findElement(By.xpath("//*[@id='alarmsmainContent']/div/table/tbody/tr[" + i + "]"));
					System.out.println(alarmItem.getText());
					System.out.println("-----------------------------------------");
				}
				element = sitePF.getalarmsExpansionBtn();
				if (element != null) {
					element.click();
					logger.log(LogStatus.PASS, "Succsesfully validated All Widgets and Graphs for the Selected Site");
				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Failed to validated All Widgets and Graphs for the Selected Site" +e.getMessage());
			
		}

	}

}
