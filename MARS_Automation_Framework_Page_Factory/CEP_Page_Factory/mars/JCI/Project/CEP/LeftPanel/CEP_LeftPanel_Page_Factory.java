package mars.JCI.Project.CEP.LeftPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class CEP_LeftPanel_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";

	@SuppressWarnings("static-access")
	public CEP_LeftPanel_Page_Factory(WebDriver driver) {
		this.driver = driver;
		// this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-th']")
	private WebElement icon;

	public WebElement getIcon() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, icon, logger) == true) {
			return icon;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//i[@class='fa fa-home fa-icons fa-active fa-3x']")
	private WebElement homePageIcon;

	public WebElement getHomePageIcon() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, homePageIcon, logger) == true) {
			return homePageIcon;
		} else {
			return null;
		}
	}

	@FindBy(linkText = "OVERVIEW")
	private WebElement overviewLink;

	public void waitForOverviewPage() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, overviewLink, logger) == true) {
			// logger.log(LogStatus.INFO, "Validating for Overview page load");
		} else {
			// logger.log(LogStatus.FAIL, "Overview page not loaded");
		}

	}

	public void clickLeftPanelArrow(String idValue) {
		WebElement arrow = driver.findElement(By.xpath(".//*[@id='" + idValue + "']/span/i"));

		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, arrow, logger) == true) {
			arrow.click();
		} else {
			logger.log(LogStatus.FAIL, "Unable to click Left Panel Arrow");
		}

	}

	public String getChillerAttribute(String idValue) {
		WebElement chiller = driver.findElement(By.id(idValue));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chiller, logger) == true) {
			return chiller.getAttribute("class");
		} else {
			logger.log(LogStatus.FAIL, "Chiller Detail not present");
			return null;
		}
	}

	public String getAttributes(String iD) {
		clickLeftPanelArrow(iD);
		WebElement element = driver.findElement(By.id(iD));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, element, logger) == true) {
			return driver.findElement(By.id(iD)).getAttribute("class");
		} else {
			logger.log(LogStatus.FAIL, iD + " Detail not present");
			return null;
		}

	}

	@FindBy(xpath = "//div[@class='dx-item-content dx-treeview-item-content']/span")
	private WebElement jciDefaultTab;

	public WebElement getJCIDefaultTab() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, jciDefaultTab, logger) == true) {
			return jciDefaultTab;
		} else {
			return null;
		}
	}

	// Navigation icon in Dashboard page
	@FindBy(xpath = "//span[@class='menuToggle-height']/i")
	private WebElement navigationIcon;

	public WebElement getNavigationIcon() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, navigationIcon, logger) == true) {
			return navigationIcon;
		} else {
			return null;
		}
	}

	// Arrow for JCI text in left panel
	@FindBy(xpath = "//div[contains(@class,'dx-treeview-toggle-item-visibility-opened')]")
	private WebElement jciArrow;

	public WebElement getJCIArrow() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, jciArrow, logger) == true) {
			return jciArrow;
		} else {
			return null;
		}
	}

	@FindBy(id = "home-leftPanel-Geography")
	private WebElement geographyNaUser;

	public WebElement getGeographyNaUser() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, geographyNaUser, logger) == true) {
			return geographyNaUser;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='tree-view-div']/csdtree-view/ul/li/csdtree-view/ul/li")
	private List<WebElement> geographyList;

	public List<WebElement> getGeographyListWeb() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, geographyList, logger) == true) {
			return geographyList;
		} else {
			return null;
		}
	}

	// JCI Element in the left panel
	@FindBy(xpath = "//div/span[text()='JCI']")
	private WebElement activeTabAdmin;

	public WebElement getActiveTabAdmin() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, activeTabAdmin, logger) == true) {
			return activeTabAdmin;
		} else {
			return null;
		}
	}

	// Get Element of Left Panel
	public WebElement getGeographies(String leftPanelItemName) {
		WebElement element = driver.findElement(By.xpath("//div/span[text()='" + leftPanelItemName + "']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		return element;
	}
	
	

	// Get Element of Left Panel
	public WebElement getLeftPanelElement(String leftPanelItemName, String ariaLevel) throws Exception {
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					// Wait for the condition with timeout 30 seconds
					.withTimeout(60, TimeUnit.SECONDS)
					// poll interval of 1 seconds.
					.pollingEvery(1, TimeUnit.SECONDS)
					// ignore the NoSuchElementException
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]")));
			WebElement element = driver.findElement(By.xpath(
					"//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			//getLeftPanelElementDiv(leftPanelItemName).click();
			return element;
		}
		catch(TimeoutException t){
			int ariaLevelInt = (Integer.parseInt(ariaLevel)) + 1;
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					// Wait for the condition with timeout 30 seconds
					.withTimeout(60, TimeUnit.SECONDS)
					// poll interval of 1 seconds.
					.pollingEvery(1, TimeUnit.SECONDS)
					// ignore the NoSuchElementException
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]")));
			WebElement element = driver.findElement(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			//getLeftPanelElementDiv(leftPanelItemName).click();
			return element;
		}

		catch (NoSuchElementException e) {
			try {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						// Wait for the condition with timeout 30 seconds
						.withTimeout(60, TimeUnit.SECONDS)
						// poll interval of 1 seconds.
						.pollingEvery(1, TimeUnit.SECONDS)
						// ignore the NoSuchElementException
						.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]")));
				WebElement element = driver.findElement(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]"));

//				fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[@aria-level='"
//						+ String.valueOf(ariaLevel) + "']/div/div/span[text()=\"" + leftPanelItemName + "\"]")));
//				WebElement element = driver.findElement(By.xpath(
//						"//ul/li[@aria-level='" + ariaLevel + "']/div/div/span[text()=\"" + leftPanelItemName + "\"]"));
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
				//getLeftPanelElementDiv(leftPanelItemName).click();
				return element;
			} catch (NoSuchElementException e1) {
				int ariaLevelInt = (Integer.parseInt(ariaLevel)) + 1;
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						// Wait for the condition with timeout 30 seconds
						.withTimeout(60, TimeUnit.SECONDS)
						// poll interval of 1 seconds.
						.pollingEvery(1, TimeUnit.SECONDS)
						// ignore the NoSuchElementException
						.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]")));
				WebElement element = driver.findElement(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div/span[text()=\"" + leftPanelItemName + "\"]"));

//				fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[@aria-level='"
//						+ String.valueOf(ariaLevelInt) + "']/div/div/span[text()=\"" + leftPanelItemName + "\"]")));
//				WebElement element = driver.findElement(By.xpath("//ul/li[@aria-level='" + ariaLevelInt
//						+ "']/div/div/span[text()=\"" + leftPanelItemName + "\"]"));
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
				//getLeftPanelElementDiv(leftPanelItemName).click();
				return element;
			} catch (Exception e2) {
				return null;
			}
		}
	}

	// Get LeftPanel Area Element to Click
	public WebElement getLeftPanelElementDiv(String leftPanelItemName) throws Exception {
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					// Wait for the condition with timeout 30 seconds
					.withTimeout(60, TimeUnit.SECONDS)
					// poll interval of 1 seconds.
					.pollingEvery(1, TimeUnit.SECONDS)
					// ignore the NoSuchElementException
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div")));
			WebElement element = driver
					.findElement(By.xpath("//ul/li[@aria-label=\"" + leftPanelItemName + "\"]/div/div"));
			return element;
		}

		catch (Exception e) {

			return null;
		}

	}

	@FindBy(xpath = "//div[@class=' pull-left']/ul/li[2]")
	private WebElement activeTabLocalUser;

	public WebElement getActiveTabLocal() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, activeTabLocalUser, logger) == true) {
			return activeTabLocalUser;
		} else {
			return null;
		}
	}

	// Get JCI Element
	@FindBy(xpath = "//label[contains(text(),'JCI')]")
	private WebElement jciLabel;

	public WebElement getJCILabel() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, jciLabel, logger) == true) {
			return jciLabel;
		} else {
			return null;
		}
	}

	// Click Geography Arrow
	public void geographyArrow() {
		List<String> geographyData = CEP_LeftPanel_DataBase_Action.geographyListDB();
		for (int iGeography = 0; iGeography < geographyData.size(); iGeography++) {
			Actions action = new Actions(driver);
			action.moveToElement(
					driver.findElement(By.xpath("//div/span[text()='" + geographyData.get(iGeography) + "']"))).build()
					.perform();
			driver.findElement(By.xpath("//ul/li[@aria-label='" + geographyData.get(iGeography)
					+ "']/div[contains(@class,'dx-treeview-toggle-item-visibility')]")).click();
		}
	}

	// Get List of Country
	public List<WebElement> getCountryListWeb() throws Exception {
		List<String> countryData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..AdminDetails.countryName.*");
		List<WebElement> countryList = new ArrayList<>();

		for (int iCountry = 0; iCountry < countryData.size(); iCountry++) {
			countryList
					.add(driver.findElement(By.xpath("//label[contains(text(),'" + countryData.get(iCountry) + "')]")));

		}
		return countryList;
	}

	// Click Country Arrow
	public void countryArrow() {

	}

	// Get List of Branch
	public List<WebElement> getBranchListWeb() throws Exception {
		List<String> branchData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..AdminDetails.branchName.*");
		List<WebElement> branchList = new ArrayList<>();

		for (int iBranch = 0; iBranch < branchData.size(); iBranch++) {
			branchList.add(driver.findElement(By.xpath("//label[contains(text(),'" + branchData.get(iBranch) + "')]")));

		}
		return branchList;
	}

	// Get Branch Arrow Aria Level value
	public int branchArrowAriaLevel(String branchName) {
		WebElement element = driver.findElement(By.xpath("//ul/li[@aria-label=\"" + branchName + "\"]"));
		return Integer.parseInt(element.getAttribute("aria-level"));
	}

	// Get Customer Arrow Aria Level value
	public int customerArrowAriaLevel(String customerName) {
		WebElement element = driver.findElement(By.xpath("//ul/li[@aria-label=\"" + customerName + "\"]"));
		return Integer.parseInt(element.getAttribute("aria-level"));
	}

	// Get List of Customer
	public List<WebElement> getCustomerListWeb() throws Exception {
		List<String> customerData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..AdminDetails.customerName.*");
		List<WebElement> customerList = new ArrayList<>();
		for (int iCustomer = 0; iCustomer < customerData.size(); iCustomer++) {
			customerList.add(
					driver.findElement(By.xpath("//label[contains(text(),'" + customerData.get(iCustomer) + "')]")));
		}
		return customerList;
	}

	// Click Customer Arrow
	public void customerArrowForFirstCustomer() {
		driver.findElement(By
				.xpath("//ul/li[@aria-label='CATERPILLAR ENGINE SYSTEMS  INC']/div[contains(@class,'dx-treeview-toggle-item-visibility')]"))
				.click();

	}

	// Click Customer Arrow
	public void customerArrowForFirstCustomer(String customer) {
		driver.findElement(By.xpath(
				"//ul/li[@aria-label='" + customer + "']/div[contains(@class,'dx-treeview-toggle-item-visibility')]"))
				.click();

	}

	// Click Project Arrow
	public void projectArrowForFirstSite(String site) {

		driver.findElement(By.xpath(
				"//ul/li[@aria-label='" + site + "']/div[contains(@class,'dx-treeview-toggle-item-visibility')]"))
				.click();

	}

	// Click Customer Arrow
	public void customerArrow(String ariaLevel, String customer) {
		// List<String> customerData =
		// CEP_LeftPanel_DataBase_Action.customerListDB();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//ul/li[@aria-level='" + ariaLevel + "']/div/div/span[text()=\"" + customer + "\"]"))).build()
				.perform();
		driver.findElement(By.xpath("//ul/li[@aria-label=\"" + customer + "\"][@aria-level='" + ariaLevel
				+ "']/div[@class='dx-treeview-toggle-item-visibility']")).click();

	}

	// Click Project Arrow
	public void projectArrow(String ariaLevel, String project) {
		// List<String> customerData =
		// CEP_LeftPanel_DataBase_Action.customerListDB();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//ul/li[@aria-level='" + ariaLevel + "']/div/div/span[text()=\"" + project + "\"]"))).build()
				.perform();
		driver.findElement(By.xpath("//ul/li[@aria-label=\"" + project + "\"][@aria-level='" + ariaLevel
				+ "']/div[@class='dx-treeview-toggle-item-visibility']")).click();
	}

	// SearchBox in Left Panel
	@FindBy(xpath = "//div[@class='input-group']/input")
	private WebElement searchBox;

	public WebElement getSearchBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchBox, logger) == true) {
			return searchBox;
		} else {
			return null;
		}
	}

	// Search Button in Left Panel
	@FindBy(xpath = "//div[@class='input-group-btn']/button/i")
	private WebElement searchBoxButton;

	public WebElement getSearchBoxButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchBoxButton, logger) == true) {
			return searchBoxButton;
		} else {
			return null;
		}
	}

	// Get List of Project
	public List<WebElement> getProjectListWeb() throws Exception {
		List<String> projectData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..AdminDetails.projectName.*");
		List<WebElement> projectList = new ArrayList<>();

		for (int iProject = 0; iProject < projectData.size(); iProject++) {
			projectList
					.add(driver.findElement(By.xpath("//label[contains(text(),'" + projectData.get(iProject) + "')]")));

		}
		return projectList;
	}

	// Click Project Arrow
	public void projectArrowForFirstSite() {

		driver.findElement(By
				.xpath("//ul/li[@aria-label='CATERPILLAR - THOMASVILLE']/div[contains(@class,'dx-treeview-toggle-item-visibility')]"))
				.click();

	}

	// Click Project Arrow
	public void projectArrow(String project) {
		// List<String> projectData =
		// CEP_LeftPanel_DataBase_Action.siteListDB();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div/span[text()=\"" + project + "\"]"))).build().perform();
		driver.findElement(By.xpath(
				"//ul/li[@aria-label=\"" + project + "\"]/div[contains(@class,'dx-treeview-toggle-item-visibility')]"))
				.click();

	}

	// Get List of Assets
	public List<WebElement> getAssetListWeb() throws Exception {
		List<String> assetData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..AdminDetails.assetName.*");
		List<WebElement> assetList = new ArrayList<>();

		for (int iAsset = 0; iAsset < assetData.size(); iAsset++) {
			assetList.add(driver.findElement(By.xpath("//label[contains(text(),'" + assetData.get(iAsset) + "')]")));

		}
		return assetList;
	}

	// Click Geography Arrow
	public void geographyArrowNaUser() {
		List<String> geographyData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.geographyName.*");
		for (int iGeography = 0; iGeography < geographyData.size(); iGeography++) {
			driver.findElement(By.xpath(
					"//label[contains(text(),'" + geographyData.get(iGeography) + "')]//preceding-sibling::span/i"))
					.click();
		}
	}

	// Get List of Country
	public List<WebElement> getCountryListWebNaUser() throws Exception {
		List<String> countryData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.countryName.*");
		List<WebElement> countryList = new ArrayList<>();

		for (int iCountry = 0; iCountry < countryData.size(); iCountry++) {
			countryList
					.add(driver.findElement(By.xpath("//label[contains(text(),'" + countryData.get(iCountry) + "')]")));

		}
		return countryList;
	}

	// Click Country Arrow
	public void countryArrowNaUser() {
		List<String> countryData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.countryName.*");
		for (int iCountry = 0; iCountry < countryData.size(); iCountry++) {
			driver.findElement(By
					.xpath("//label[contains(text(),'" + countryData.get(iCountry) + "')]//preceding-sibling::span/i"))
					.click();
		}
	}

	// Get List of Branch
	public List<WebElement> getBranchListWebNaUser() throws Exception {
		List<String> branchData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.branchName.*");
		List<WebElement> branchList = new ArrayList<>();

		for (int iBranch = 0; iBranch < branchData.size(); iBranch++) {
			branchList.add(driver.findElement(By.xpath("//label[contains(text(),'" + branchData.get(iBranch) + "')]")));

		}
		return branchList;
	}

	// Click Branch Arrow
	public void branchArrowNaUser() {
		List<String> branchData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.branchName.*");
		System.out.println("Branch:" + branchData.size());
		for (int iBranch = 0; iBranch < branchData.size(); iBranch++) {
			driver.findElement(
					By.xpath("//label[contains(text(),'" + branchData.get(iBranch) + "')]//preceding-sibling::span/i"))
					.click();
		}
	}

	// Get List of Customer
	public List<WebElement> getCustomerListWebNaUser() throws Exception {
		List<String> customerData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.customerName.*");
		List<WebElement> customerList = new ArrayList<>();
		for (int iCustomer = 0; iCustomer < customerData.size(); iCustomer++) {
			customerList.add(
					driver.findElement(By.xpath("//label[contains(text(),'" + customerData.get(iCustomer) + "')]")));
		}
		return customerList;
	}

	// Click Customer Arrow
	public void customerArrowNaUser() {
		List<String> customerData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.customerName.*");
		for (int iCustomer = 0; iCustomer < customerData.size(); iCustomer++) {
			driver.findElement(By.xpath(
					"//label[contains(text(),'" + customerData.get(iCustomer) + "')]//preceding-sibling::span/i"))
					.click();
		}
	}

	// Get List of Project
	public List<WebElement> getProjectListWebNaUser() throws Exception {
		List<String> projectData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.projectName.*");
		List<WebElement> projectList = new ArrayList<>();

		for (int iProject = 0; iProject < projectData.size(); iProject++) {
			projectList
					.add(driver.findElement(By.xpath("//label[contains(text(),'" + projectData.get(iProject) + "')]")));

		}
		return projectList;
	}

	// Click Project Arrow
	public void projectArrowNaUser() {
		List<String> projectData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.projectName.*");
		for (int iProject = 0; iProject < projectData.size(); iProject++) {
			driver.findElement(By
					.xpath("//label[contains(text(),'" + projectData.get(iProject) + "')]//preceding-sibling::span/i"))
					.click();
		}
	}

	// Get List of Assets
	public List<WebElement> getAssetListWebNaUser() throws Exception {
		List<String> assetData = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..LocalDetails.assetName.*");
		List<WebElement> assetList = new ArrayList<>();

		for (int iAsset = 0; iAsset < assetData.size(); iAsset++) {
			assetList.add(driver.findElement(By.xpath("//label[contains(text(),'" + assetData.get(iAsset) + "')]")));

		}
		return assetList;
	}

	// Get CEP landing/overview page URL
	public String getLandingPageURL() {
		return driver.getCurrentUrl();
	}

	// Get Widgets in the Overview tab
	@FindBy(xpath = "//div[@class='content-header']/h3[contains(text(),'CHILLER STATUS')]")
	private WebElement chillerStatusWidget;

	public WebElement getChillerStatusWidget() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerStatusWidget, logger) == true) {
			return chillerStatusWidget;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='content-header']/h3[contains(text(),'CUSTOMER LIST BY STATUS')]")
	private WebElement customerListWidget;

	public WebElement getCustomerListWidget() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerListWidget, logger) == true) {
			return customerListWidget;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='content-header']/h3[contains(text(),'CHILLER INFORMATION')]")
	private WebElement chillerInformationWidget;

	public WebElement getChillerInformationWidget() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerInformationWidget, logger) == true) {
			return chillerInformationWidget;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='content-header']/h3[contains(text(),'Status Check / Health Check')]")
	private WebElement statusHealthCheckWidget;

	public WebElement getStatusHealthCheckWidget() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, statusHealthCheckWidget, logger) == true) {
			return statusHealthCheckWidget;
		} else {
			return null;
		}
	}

	// Elements for Test Case 5
	@FindBy(id = "home-leftPanel-Country")
	private WebElement firstCountry;

	public WebElement getFirstCountry() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, firstCountry, logger) == true) {
			return firstCountry;
		} else {
			return null;
		}
	}

	@FindBy(id = "home-leftPanel-Branch")
	private WebElement firstBranch;

	public WebElement getFirstBranch() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, firstBranch, logger) == true) {
			return firstBranch;
		} else {
			return null;
		}
	}

	@FindBy(id = "home-leftPanel-Customer")
	private WebElement firstCustomer;

	public WebElement getFirstCustomer() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, firstCustomer, logger) == true) {
			return firstCustomer;
		} else {
			return null;
		}
	}

	@FindBy(id = "home-leftPanel-Project")
	private WebElement firstProject;

	public WebElement getFirstProject() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, firstProject, logger) == true) {
			return firstProject;
		} else {
			return null;
		}
	}

	@FindBy(id = "home-leftPanel-Asset")
	private WebElement firstAsset;

	public WebElement getFirstAsset() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, firstAsset, logger) == true) {
			return firstAsset;
		} else {
			return null;
		}
	}

	// Get Trend label for validating the active tab
	@FindBy(linkText = "TRENDS")
	private WebElement trendLabel;

	public WebElement getTrendLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, trendLabel, logger) == true) {
			return trendLabel;
		} else {
			return null;
		}

	}

	// Get Trend Page Equipment
	@FindBy(xpath = "//div[contains(@class,'list-inline')]/form/label[text()='Equipment']")
	private WebElement equipmentLabel;

	public WebElement getEquipmentLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, equipmentLabel, logger) == true) {
			return equipmentLabel;
		} else {
			return null;
		}

	}

	// Get list of breadcrumb elements
	@FindBy(xpath = "//div[@class=' pull-left']/ul[@class='breadcrumb']/li/a")
	private WebElement breadcrumbList;

	public WebElement getBreadCrumbList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, breadcrumbList, logger) == true) {
			return breadcrumbList;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//li[@aria-level='3']/div")
	private WebElement branchName;
	
	public WebElement getBranchName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, branchName, logger) == true) {
			return branchName;
		} else {
			return null;
		}
	}
}
