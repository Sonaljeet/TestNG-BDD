package mars.JCI.Project.DES.Site;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.JCI.Project.DES.COMMONS.DES_COMMONS_ValidationMethods;
import mars.JCI.Project.DES.CustomerSetup.DES_CustomerSetup_Page_Action;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.UsersRole.DES_UsersRole_Page_Action;

public class DES_Site_Page_Action {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element = null;
	private static DES_Site_Page_Factory sitePF = null;
	private static DES_Home_Page_Action homePA=null;
	private static DES_Login_Page_Action loginPA=null;
	public String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";
	public String customer = "Main Entity Customer";
	public String name = "";
	public String newSiteName = "";
	public WebElement newSite = null;
	// WebElement firstGroupofCustomer=null;
	// String groupName = "";
	int index = 0;

	public DES_Site_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		sitePF = new DES_Site_Page_Factory(driver, logger);
		homePA= new DES_Home_Page_Action(driver, logger);
		loginPA= new DES_Login_Page_Action(driver, logger);
	}

	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingConfiguration");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void enterSiteName(String sitename) {
		element = sitePF.getSiteNameTextBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, sitename);
			logger.log(LogStatus.PASS, "\"" + sitename + "\" entered sucessfully in Site Name field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Site Name field");

		}
	}

	public static void enterSiteAbbriviation(String siteAbbriviation) {
		element = sitePF.getsiteAbbreviationTexBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, siteAbbriviation);
			logger.log(LogStatus.PASS, "\"" + siteAbbriviation + "\" entered sucessfully in site Abbriviation field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the site Abbriviation field");

		}
	}

	public static void enterSiteAllocatedkWh(String AllocatedkWh) {
		element = sitePF.getallocatedkwh();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, AllocatedkWh);
			logger.log(LogStatus.PASS, "\"" + AllocatedkWh + "\" entered sucessfully in site Allocated kWh field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Allocated kWh field");

		}
	}

	public static void enterSiteAddress1(String SiteAddress1) {
		element = sitePF.getsiteAddress1TexBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, SiteAddress1);
			logger.log(LogStatus.PASS, "\"" + SiteAddress1 + "\" entered sucessfully in Site Address1field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Site Address1 field");

		}
	}

	public static void enterSiteAddress2(String SiteAddress2) {
		element = sitePF.getsiteAddress2TexBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, SiteAddress2);
			logger.log(LogStatus.PASS, "\"" + SiteAddress2 + "\" entered sucessfully in Site Address1field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Site Address1 field");

		}
	}

	public void selectSiteCountry(String country) {
		element = sitePF.getsitedrpdwnSiteCountry();
		if (element != null) {
			// element.clear();
			WebDropDown.SelectElementByVisibleText(element, country);
			logger.log(LogStatus.PASS, "\"" + country + "\" Selected as Country successfully from country dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from Country dropdown");
		}
	}

	public void selectSiteState(String state) {
		element = sitePF.getsitedrpdwnsiteStates();
		if (element != null) {
			// element.clear();
			WebDropDown.SelectElementByVisibleText(element, state);
			logger.log(LogStatus.PASS, "\"" + state + "\" Selected as State successfully from state dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from State dropdown");
		}

	}

	public void selectSiteCity(String city) {
		element = sitePF.getsitedrpdwnsiteCities();
		if (element != null) {
			// element.clear();
			// WebDropDown.SelectElementByIndex(element, city);
			WebDropDown.SelectElementByVisibleText(element, city);
			logger.log(LogStatus.PASS, "\"" + city + "\" Selected as City for the Customer");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from city Dropdown");
		}
	}

	public void enterSiteZipcode(String zipcode) {
		element = sitePF.getsiteZipCodeTextbox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, zipcode);
			logger.log(LogStatus.PASS, "\" " + zipcode + "\" Entered Successfully in zipcode field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to enter the ZipCode");
		}
	}

	public void selectStartDate(String startDate) {
		element = sitePF.getsiteStartDate();
		if (element != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, startDate);
			logger.log(LogStatus.PASS, "\"" + startDate + "\" Entered successfully in StartDate field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Start Date");
		}
	}

	public void selectEndDate(String endDate) {
		element = sitePF.getsiteEndDate();
		if (element != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, endDate);
			logger.log(LogStatus.PASS, "\"" + endDate + "\" Entered successfully in EndDate field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter End Date");
		}
	}

	public void selectCommissionDate(String endDate) {
		element = sitePF.getsiteCommissioningDate();
		if (element != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, endDate);
			logger.log(LogStatus.PASS, "\"" + endDate + "\" Entered successfully in Commissioning date field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Commissioning Date");
		}
	}

	public void selectSiteLogo(String logopath) {
		element = sitePF.getselectSiteLogo();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, logopath);
			logger.log(LogStatus.PASS, "\"" + logopath + "\" File selected as Site Logo");
		} else {
			logger.log(LogStatus.FAIL, "Failled to add Site logo image");
		}
	}

	public void enterSitePrimaryContactName(String primaryName) {
		element = sitePF.getsitePrimaryName();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, primaryName);
			logger.log(LogStatus.PASS, "\"" + primaryName + "\" Entered primary Name successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter primary Contact Name");
		}

	}

	public void enterSitePrimaryDesignation(String primaryDesignation) {
		element = sitePF.getsitePrimaryDesignation();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, primaryDesignation);
			logger.log(LogStatus.PASS, "\"" + primaryDesignation + "\" Entered Designation Succesfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Designation");
		}
	}

	public void enterPrimaryContactNumber(String primaryContactNumber) {
		element = sitePF.getsitePrimaryContactNumber();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, primaryContactNumber);
			logger.log(LogStatus.PASS, "\"" + primaryContactNumber + "\" Entered Primary Contact Number successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Contact Number");
		}

	}

	public void enterPrimaryEmailAddress(String primaryEmailAddress) {
		element = sitePF.getsitePrimaryEmail();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, primaryEmailAddress);
			logger.log(LogStatus.PASS, "\"" + primaryEmailAddress + "\" Entered  Primary email Address successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Primary email Address");
		}

	}

	public void selectSiteSBHGateWayID(int siteSBHGateWayIDindex) {
		element = sitePF.getdrpdwnSiteGatewayId();
		if (element != null) {
			// element.clear();

			WebDropDown.SelectElementByIndex(element, siteSBHGateWayIDindex);
			logger.log(LogStatus.PASS,
					"\"" + siteSBHGateWayIDindex + "\" Selected as Country successfully from country dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from SBH Gateway ID from dropdown");
		}
	}

	public void selectSiteSBHGateWayID2(int siteSBHGateWayIDindex) {
		element = sitePF.getdrpdwnSiteGatewayId();
		if (element != null) {
			// element.clear();
			DES_COMMONS_ValidationMethods.selectByDesiredIndex(element, siteSBHGateWayIDindex);
			// WebDropDown.SelectElementByIndex(element, siteSBHGateWayIDindex);
			logger.log(LogStatus.PASS,
					"\"" + siteSBHGateWayIDindex + "\" Selected as Country successfully from country dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from SBH Gateway ID from dropdown");
		}
	}

	public void clickOnSaveButton() {
		element = sitePF.getsiteSaveButton();
		if (element != null) {
			element.click();
			DES_Site_Page_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked to Save button");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Click Save button");
		}
	}

	public void clickOnDeleteButton() {
		waitForSpinnerToDisappear();
		element = sitePF.getsiteDeleteButton();
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			waitForSpinnerToDisappear();
			element=sitePF.getOkDeleteButton();
			if(element!=null){
					element.click();
					waitForSpinnerToDisappear();
			}
			DES_Site_Page_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked to Delete button");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Click Delete button");
		}

	}

	public String getValidationMessageFromSitePage() {
		String Message = null;
		element = sitePF.getsiteSuccessMessage();
		if (element != null) {
			Message = element.getText();
			System.out.println(Message + "Message From The Page");
			logger.log(LogStatus.PASS, "\"" + Message + "\" Message Recieved from Page");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Get the Message from Page");
		}
		return Message;
	}

	// Navigate to Site Page
	public void navigateToSitePage() throws InterruptedException {
		try {
			//loginPA.DES_CorrectLogin();
			homePA.waitForMapSpinnerToDisappear();
			//DES_Home_Page_Action.clickeOnSetup();
			homePA.navigateToSetupPage();
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			element = sitePF.getSiteTab();
			waitForSpinnerToDisappear();
			if (element != null) {
				waitForSpinnerToDisappear();
				element.click();
				logger.log(LogStatus.PASS, "Navigate to " + element.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Failled to Navigate to Site Page");
		}
	}

	/*// Select Customer from Customer dropdown
	public void selectCustomer(String customer) {
		try {
			waitForSpinnerToDisappear();
			element = sitePF.getcustomerLabel();
			System.out.println(element.getText() + " Label present");
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			element = sitePF.getdrpdwnsiteCustomers();
			if (element != null) {
				waitForSpinnerToDisappear();
				WebDropDown.SelectElementByVisibleText(element, customer);
				System.out.println(customer + " Selected as Customer");
				logger.log(LogStatus.PASS, "\"" + customer + "\" Selected as Customer");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not select Customer from Customer dropdown");
		}

	}*/
	// Select Customer from Customer dropdown
		public void selectCustomer(String customer) {
			try {
				String Userslistdata_JSONPath = "$..CustomerDetails.*";
				List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(
						ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
						Userslistdata_JSONPath);
				
				waitForSpinnerToDisappear();
				element = sitePF.getcustomerLabel();
				System.out.println(element.getText() + " Label present");
				waitForSpinnerToDisappear();
				Thread.sleep(2000);
				element = sitePF.getdrpdwnsiteCustomers();
				if (element != null) {
					waitForSpinnerToDisappear();
					WebDropDown.SelectElementByVisibleText(element, customer);
					System.out.println(customer + " Selected as Customer");
					logger.log(LogStatus.PASS, "\"" + customer + "\" Selected as Customer");
				}
			} catch (Exception e) {
				logger.log(LogStatus.FAIL, "Could not select Customer from Customer dropdown");
			}

		}

	
	public static String generateRandomString(Random rng, String str, int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = str.charAt(rng.nextInt(str.length()));
			str = str + text[i];
		}
		System.out.println(str);
		return str;

	}

	public void enterSiteDetails() throws InterruptedException, JsonIOException, JsonSyntaxException, IOException {
		
		String SiteDetailsJsonPath="$..SiteDetails.*";
		List<String> siteDetails=ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), SiteDetailsJsonPath);
		String siteName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Site_Name",
				siteName);
		waitForSpinnerToDisappear();
		enterSiteName(siteName);
		enterSiteAbbriviation(DES_UsersRole_Page_Action.generateRandomalphabets(6));
		enterSiteAddress1(DES_UsersRole_Page_Action.generateRandomalphabets(6));
		enterSiteAddress2(DES_UsersRole_Page_Action.generateRandomalphabets(6));
		waitForSpinnerToDisappear();
		selectSiteCountry(siteDetails.get(0).toString());
		Thread.sleep(2000);
		waitForSpinnerToDisappear();
		selectSiteState(siteDetails.get(1).toString());
		Thread.sleep(2000);
		waitForSpinnerToDisappear();
		selectSiteCity(siteDetails.get(2).toString());
		enterSiteZipcode(siteDetails.get(3).toString());
		selectStartDate(siteDetails.get(5).toString());
		selectEndDate(siteDetails.get(6).toString());
		selectCommissionDate(siteDetails.get(7).toString());
		enterSiteAllocatedkWh(siteDetails.get(8).toString());
		selectSiteLogo(siteDetails.get(4).toString());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		enterSitePrimaryContactName(siteDetails.get(9).toString());
		enterSitePrimaryDesignation(siteDetails.get(10).toString());
		enterPrimaryContactNumber(siteDetails.get(11).toString());
		enterPrimaryEmailAddress(siteDetails.get(12).toString());
		waitForSpinnerToDisappear();
		selectSiteSBHGateWayID(1);
		waitForSpinnerToDisappear();
		clickOnSaveButton();
		waitForSpinnerToDisappear();
		getValidationMessageFromSitePage();
		logger.log(LogStatus.PASS, "Added Site Successfully");
		

	}

	public String addSite() {
		try {
			String Userslistdata_JSONPath = "$..CustomerDetails.*";
			List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			navigateToSitePage();
			waitForSpinnerToDisappear();
			String customer= Cust_datalist.get(9).toString();
			/*WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Customer_Name",
					customer);*/
			selectCustomer(customer);
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			List<WebElement> custTree = driver.findElements(By.xpath("//div[@id='treeTemplateDiv']"));
			int count = custTree.size();
			logger.log(LogStatus.PASS, ""+ count);
			if (count > 0) {
				Iterator<WebElement> iter = custTree.iterator();
				while (iter.hasNext()) {
					WebElement treeItem = iter.next();
					String treeItemName = treeItem.getText();
					logger.log(LogStatus.PASS,"Node present on Page " + treeItemName);
					if (treeItemName.equalsIgnoreCase(Cust_datalist.get(9).toString())) {
						treeItem.click();
						waitForSpinnerToDisappear();
						element = sitePF.getsiteAddButton();
						if (element.isEnabled()) {
							waitForSpinnerToDisappear();
							element.click();
							logger.log(LogStatus.PASS,"Added new temp site");
							index = count + 1;
							newSite = driver.findElement(By.xpath("(//div[@id='treeTemplateDiv'])[" + index + "]"));
							newSite.click();
							newSiteName = newSite.getText();
							logger.log(LogStatus.PASS,"Newly temporary Added Site is  " + newSiteName);
							waitForSpinnerToDisappear();
							enterSiteDetails();
							logger.log(LogStatus.PASS,"Added the site with Complete Details");

						} else {
							/*
							 * element = sitePF.getfirstGroupOfCustomer(); if
							 * (element != null) { element.click(); groupName =
							 * element.getText();
							 * System.out.println("Select group of Customer " +
							 * groupName); element = sitePF.getsiteAddButton();
							 * if (element.isEnabled()) { element.click();
							 * System.out.
							 * println("Added new temp site under group" +
							 * groupName); index = count + 1; newSite =
							 * driver.findElement(By.xpath(
							 * "(//div[@id='treeTemplateDiv'])[" + index +
							 * "]")); newSite.click(); newSiteName =
							 * newSite.getText();
							 * System.out.println(newSiteName);
							 * enterSiteDetails(); System.out.
							 * println("Added the site with Complete Details");
							 * } }
							 */
							logger.log(LogStatus.PASS,"Could not Add site Under the Customer " + customer);
						}
					}

				}
				newSite.click();
				Thread.sleep(1000);
				waitForSpinnerToDisappear();
				clickOnDeleteButton();
				waitForSpinnerToDisappear();
				Thread.sleep(2000);
			} else{
				logger.log(LogStatus.PASS,"Did not selected Customer" +customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Could not Add site Under Customer ");

		}
		return customer;
	}

	public void UpdateSite() {
		try {
			String customer=addSite();
			Thread.sleep(1000);
			List<WebElement> custTree = driver.findElements(By.xpath("//div[@id='treeTemplateDiv']"));
			int count = custTree.size();
			// System.out.println(count);
			Iterator<WebElement> iter = custTree.iterator();
			while (iter.hasNext()) {
				WebElement treeItem = iter.next();
				String siteName = treeItem.getText();
				// System.out.println(siteName);
				if (siteName.equalsIgnoreCase(customer));
				{
					treeItem.click();
					newSite = driver.findElement(By.xpath("(//div[@id='treeTemplateDiv'])[" + index + "]"));
					newSite.click();
					waitForSpinnerToDisappear();
					enterSiteDetails();
					System.out.println(name + " Updated Site with new Details ");
				}
				logger.log(LogStatus.PASS, name + " Updated Site with new Details ");
				break;

			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to Update site details");

		}
	}

	public void updateSiteDetails() {
		try {

			String Userslistdata_JSONPath = "$..CustomerDetails.*";
			List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			navigateToSitePage();
			String customer= Cust_datalist.get(9).toString();
			/*WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Customer_Name",
					customer);*/
			selectCustomer(customer);
			Thread.sleep(2000);
			List<WebElement> custTree = driver.findElements(By.xpath("//div[@id='treeTemplateDiv']"));
			int count = custTree.size();
			newSite = driver.findElement(By.xpath("(//div[@id='treeTemplateDiv'])[" + count + "]"));
			newSite.click();
			Thread.sleep(2000);
			waitForSpinnerToDisappear();
			enterSiteDetails();
			logger.log(LogStatus.PASS, "Updated Site details");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not update Site details");
		}
	}

	public void DeleteSite() {
		try {
			addSite();
			System.out.println("Succesfully Add and Deleted site from the Customer");
		} catch (Exception e) {
			System.out.println("Failled to Delete site details");

		}
	}

}
