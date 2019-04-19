package mars.JCI.Project.DES.CustomerSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Home.DES_Home_Page_Factory;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.UsersRole.DES_UsersRole_Page_Action;

public class DES_CustomerSetup_Page_Action {
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static WebElement element = null;
	private static DES_CustomerSetup_Page_Factory custSetupPF = null;
	private static DES_DataValidation_Master_CustomerSetup custDataVal = null;
	public static DES_Login_Page_Action loginPA = null;
	public static DES_UsersRole_Page_Action rolePA = null;

	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=DESDB_QA";// ;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password";
	final static String USER = "jciazdeploy";
	final static String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	public static String name, validationMsg, CustomerId, CustomerName, Abbreviation, Address_1, Address_2,
			ContractType, Startdate, EndDate, State, City, ZipCOde = null;
	public String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";

	public DES_CustomerSetup_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		custSetupPF = new DES_CustomerSetup_Page_Factory(driver, logger);
		custDataVal = new DES_DataValidation_Master_CustomerSetup(logger);
		loginPA = new DES_Login_Page_Action(driver, logger);
		rolePA = new DES_UsersRole_Page_Action(driver, logger);
	}

	public void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingConfiguration");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void getDES_DBConnection() throws ClassNotFoundException, SQLException {
		// Load SQL-driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Establishing DB Connection with DES_QA DB");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("DB Connection Established");
		logger.log(LogStatus.INFO, "DES_QA DB Connection established successfully");

	}

	// Enter Customer name
	public void enterCustomerName(String CustomerName) {
		element = custSetupPF.getCustomerNameTextBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerName);
			logger.log(LogStatus.PASS, "\"" + CustomerName + "\" entered sucessfully in Customer Name field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Name field");
		}
	}

	public void enterCustomerAbbriviation(String CustomerAbbr) {
		element = custSetupPF.getcustomerAbbreviationTextBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerAbbr);
			logger.log(LogStatus.PASS, "\"" + CustomerAbbr + "\" entered successfully in Customer Abbriviation field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Abbriviation field");
		}
	}

	public void enterCustomerAddress1(String CustomerAddress1) {
		element = custSetupPF.getcustomerAddress1TextBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerAddress1);
			logger.log(LogStatus.PASS, "\"" + CustomerAddress1 + "\" entered sucessfully in Customer Address 1 field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Address 1 field");
		}
	}

	public void enterCustomerAddress2(String CustomerAdd2) {
		element = custSetupPF.getcustcustomerAddress2TextBox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerAdd2);
			logger.log(LogStatus.PASS, "\"" + CustomerAdd2 + "\" entered succesfully in Customer Address 2 field");
		} else {
			logger.log(LogStatus.FAIL, "Faillled to find customer Address 2 field");
		}
	}

	public void selectCustomerCountry(String country) {
		element = custSetupPF.getcustomerCountryDropdown();
		if (element != null) {
			// element.clear();
			WebDropDown.SelectElementByVisibleText(element, country);
			logger.log(LogStatus.PASS, "\"" + country + "\" Selected as Country successfully from country dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from Country dropdown");
		}
	}

	public void selectCustomerState(String state) {
		element = custSetupPF.getcustomerStateDropdown();
		if (element != null) {
			// element.clear();
			WebDropDown.SelectElementByVisibleText(element, state);
			logger.log(LogStatus.PASS, "\"" + state + "\" Selected as State successfully from state dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from State dropdown");
		}

	}

	public void selectCustomerCity(String city) {
		element = custSetupPF.getcustomerCityDropdown();
		if (element != null) {
			// element.clear();
			// WebDropDown.SelectElementByIndex(element, city);
			WebDropDown.SelectElementByVisibleText(element, city);
			logger.log(LogStatus.PASS, "\"" + city + "\" Selected as City for the Customer");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from city Dropdown");
		}
	}

	public void enterCustomerZipcode(String zipcode) {
		element = custSetupPF.getcustomerZipcode();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, zipcode);
			logger.log(LogStatus.PASS, "\" " + zipcode + "\" Entered Successfully in zipcode field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to enter the ZipCode");
		}
	}

	public void selectCustomerLogo(String logopath) {
		element = custSetupPF.getcustomerLogo();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, logopath);
			logger.log(LogStatus.PASS, "\"" + logopath + "\" File selected as Customer Logo");
		} else {
			logger.log(LogStatus.FAIL, "Failled to get logo image");
		}
	}

	public void enterCustomerContractType(String contractType) {
		element = custSetupPF.getcustomerContactTypeTextbox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, contractType);
			logger.log(LogStatus.PASS, "\"" + contractType + "\" Entered successfully in ContractType field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to enter in contract type textbox");
		}
	}

	public void selectStartDate(String startDate) {
		element = custSetupPF.getcustomercustStartDate();
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
		element = custSetupPF.getcustomercustEndDate();
		if (element != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, endDate);
			logger.log(LogStatus.PASS, "\"" + endDate + "\" Entered successfully in EndDate field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter End Date");
		}
	}

	public void enterCustomerContactName(String custName) {
		element = custSetupPF.getcustomercustName();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, custName);
			logger.log(LogStatus.PASS, "\"" + custName + "\" Entered Customer contact Name successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Customer Contact Name");
		}

	}

	public void enterCustomerDesignation(String designation) {
		element = custSetupPF.getcustomercustDesignation();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, designation);
			logger.log(LogStatus.PASS, "\"" + designation + "\" Entered Designation Succesfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Designation");
		}
	}

	public void enterContactNumber(String contactNumber) {
		element = custSetupPF.getcustomercustContact();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, contactNumber);
			logger.log(LogStatus.PASS, "\"" + contactNumber + "\" Entered Contact Number successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter Contact Number");
		}

	}

	public void enterEmailAddress(String emailAddress) {
		element = custSetupPF.getcustomercustEmail();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, emailAddress);
			logger.log(LogStatus.PASS, "\"" + emailAddress + "\" Entered email Address successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Enter email Address");
		}

	}

	public String getValidationMessageFromPage() {
		String Message = null;
		element = custSetupPF.getCustomerSuccessMessage();
		if (element != null) {
			Message = element.getText();
			System.out.println(Message + "Message Received From The Page");
			logger.log(LogStatus.PASS, "\"" + Message + "\" Message Recieved from Page");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Get the Message from Page");
		}
		return Message;
	}

	public void clickOnAddButton() {
		element = custSetupPF.getAddbtn();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked to Add button");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Click Add button");
		}
	}

	public void clickOnUpdateButton() {
		element = custSetupPF.getUpdatebtn();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked to Update button");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Click Update button");
		}
	}

	public void clickOnDeleteButton() {
		element = custSetupPF.getDeletebtn();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Click to Delete Button");
			element=custSetupPF.getOkButton();
			if(element!=null){
				waitForSpinnerToDisappear();
				element.click();
				waitForSpinnerToDisappear();
			}
		} else {
			logger.log(LogStatus.FAIL, "Failled to click Delete Button");
		}
	}

	public void clickOnClearButton() {
		element = custSetupPF.getClearbtn();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked on Clear button");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Click on Clear Button");
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

	public void getCustomerFromGrid() {
		element = custSetupPF.getCustomerNameFromGrid();
		if (element != null) {
			element.click();
			String SelectedCustomerName = element.getText();
			System.out.println(SelectedCustomerName + " Customer selected from grid");
		} else {
			System.out.println("Unable to get Element from Page " + element);
		}
	}

	public String getCustomerNameFromGrid() {
		element = custSetupPF.getCustomerNameFromGrid();
		String custName = null;
		if (element != null) {
			element.click();
			custName = element.getText();
			System.out.println(custName + " CustomerName In Grid ");
		}
		return custName;
	}

	public String getCustomerAbbriviationFromGrid() {
		element = custSetupPF.getCustomerAbbriviationFromGrid();
		String custAbb = null;
		if (element != null) {
			element.click();
			custAbb = element.getText();
			System.out.println(custAbb + "Customer Abbriviation in Grid ");
		}
		return custAbb;
	}

	public String getCustomerContractTypeFromGrid() {
		element = custSetupPF.getCustomerContractTypeFromGrid();
		String contrType = null;
		if (element != null) {
			element.click();
			contrType = element.getText();
			System.out.println(contrType + " Contract Type in Grid");
		}
		return contrType;
	}

	public String getCustomerStartDateFromGrid() {
		element = custSetupPF.getCustomerContractStartDateGrid();
		String custStartDate = null;
		if (element != null) {
			element.click();
			custStartDate = element.getText();
			System.out.println(custStartDate + "Customer StartDate in Grid");
		}
		return custStartDate;
	}

	public String getCustomerEndDateFromGrid() {
		element = custSetupPF.getCustomerContractEndDateGrid();
		String custEndDate = null;
		if (element != null) {
			element.click();
			custEndDate = element.getText();
			System.out.println(custEndDate + "Customer End Date in Grid");
		}
		return custEndDate;
	}

	public void getStartDate() {

	}

	public String getCustomerStateFromGrid() {
		element = custSetupPF.getCustomerStateFromGrid();
		String custState = null;
		if (element != null) {
			element.click();
			custState = element.getText();
			System.out.println(custState + "Customer State in Grid");
		}
		return custState;
	}

	public String getCustomerCityFromGrid() {
		element = custSetupPF.getCustomerCityFromGrid();
		String custCity = null;
		if (element != null) {
			element.click();
			custCity = element.getText();
			System.out.println(custCity + "Customer City in Grid");
		}
		return custCity;
	}

	public String getCustomerZipCodeFromGrid() {
		element = custSetupPF.getCustomerCityFromGrid();
		String custZipCode = null;
		if (element != null) {
			element.click();
			custZipCode = element.getText();
			System.out.println(custZipCode + "Customer ZipCode in Grid");
		}
		return custZipCode;
	}

	public String enterCustomerFromGrid(String searchtext) {
		String SelectedCustomerName = searchtext;
		element = custSetupPF.getCustomerNameFromGrid();
		if (element != null) {
			element.click();
			SelectedCustomerName = element.getText();
			System.out.println(SelectedCustomerName + " Customer selected from grid");
		}
		return SelectedCustomerName;
	}

	public void searchCustomerFromGrid(String custName) {
		element = custSetupPF.getgridTextBox();
		if (element != null) {
			element.clear();
			element.sendKeys(custName);
			logger.log(LogStatus.PASS, "Customer name entered successfully in customer name text box");
		} else {
			logger.log(LogStatus.FAIL, "Identifying Customer name text box webelement failed. ");
		}
	}

	public void verifyAllLabelsPresentOnCustomerPage() throws InterruptedException {
		
		//loginPA.DES_CorrectLogin();
		//DES_Home_Page_Action.clickeOnSetup();
		DES_Home_Page_Action.navigateToSetupPage();
		waitForSpinnerToDisappear();
		element = custSetupPF.getCustomerNameLabel();
		if (element != null) {
			String custName = element.getText();
			System.out.println(custName + "Present on Customer setup Page");
		}

		element = custSetupPF.getCustomerAbbrivationLabel();
		if (element != null) {
			String CustomerAbbrivationLabel = element.getText();
			System.out.println(CustomerAbbrivationLabel + " Present on Customer setup Page");
		}
		element = custSetupPF.getCustomerlblcustAddress1();
		if (element != null) {
			String CustomerAddressLabel = element.getText();
			System.out.println(CustomerAddressLabel + " Present on Customer setup Page");
		}
		element = custSetupPF.getCustomerlblcustAddress2();
		if (element != null) {
			String CustomerAddressLabel2 = element.getText();
			System.out.println(CustomerAddressLabel2 + " Present on Customer setup Page");
		}
		element = custSetupPF.getCustomerlblcustCountries();
		if (element != null) {
			String CustomerlblcustCountries = element.getText();
			System.out.println(CustomerlblcustCountries + " Present on Customer setup Page");
		}
		element = custSetupPF.getcustomerlblcustStates();
		if (element != null) {
			String customerlblcustStates = element.getText();
			System.out.println(customerlblcustStates + " Present on Customer setup Page");
		}
		element = custSetupPF.getcustomerlblcustcities();
		if (element != null) {
			String customerlblcustcities = element.getText();
			System.out.println(customerlblcustcities + " Present on Customer setup Page");
		}

		element = custSetupPF.getcustomerlblcustzipcode();
		if (element != null) {
			String customerlblcustzipcode = element.getText();
			System.out.println(customerlblcustzipcode + " Present on Customer setup Page");
		}
		element = custSetupPF.getcustomerlblcustlogo();
		if (element != null) {
			String customerlblcustlogo = element.getText();
			System.out.println(customerlblcustlogo + " Present on Customer setup Page");
		}

		element = custSetupPF.getcustomerlblcustContactType();
		if (element != null) {
			String customerlblcustContactType = element.getText();
			System.out.println(customerlblcustContactType + " Present on Customer setup Page");
		}

		element = custSetupPF.getcustomerlblcustStartDate();
		if (element != null) {
			String customerlblcustStartDate = element.getText();
			System.out.println(customerlblcustStartDate + " Present on Customer setup Page");
		}
		element = custSetupPF.getcustomerlblcustEndDate();
		if (element != null) {
			String customerlblcustEndDate = element.getText();
			System.out.println(customerlblcustEndDate + " Present on Customer setup Page");
		}
		element = custSetupPF.getcustomerlblName();
		if (element != null) {
			String customerlblName = element.getText();
			System.out.println(customerlblName + " Present on Customer setup Page");
		}

		element = custSetupPF.getcustomerlblcustdesig();
		if (element != null) {
			String customerlblcustdesig = element.getText();
			System.out.println(customerlblcustdesig + " Present on Customer setup Page");
		}

		element = custSetupPF.getcustomerlblcontact();
		if (element != null) {
			String customerlblcontact = element.getText();
			System.out.println(customerlblcontact + " Present on Customer setup Page");
		}

		element = custSetupPF.getcustomerlblemail();
		if (element != null) {
			String customerlblEmail = element.getText();
			System.out.println(customerlblEmail + " Present on Customer setup Page");
		}

		else {
			System.out.println(element + "Element is not present or visible at moment on Page");
		}
		Thread.sleep(2000);
		clickOnClearButton();

	}

	public String createCustomer() throws InterruptedException {
		String custName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
		try {
			String Userslistdata_JSONPath = "$..CustomerDetails.*";
			List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			
			WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Customer_Name",
					custName);
			enterCustomerName(custName);
			enterCustomerAbbriviation(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			enterCustomerAddress1(DES_UsersRole_Page_Action.generateRandomalphabets(10));
			enterCustomerAddress2(DES_UsersRole_Page_Action.generateRandomalphabets(10));
			selectCustomerCountry(Cust_datalist.get(0).toString());
			Thread.sleep(2000);
			selectCustomerState(Cust_datalist.get(1).toString());
			Thread.sleep(2000);
			selectCustomerCity(Cust_datalist.get(2).toString());
			enterCustomerZipcode(Cust_datalist.get(3).toString());
			selectCustomerLogo(Cust_datalist.get(4).toString());
			enterCustomerContractType(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			selectStartDate(Cust_datalist.get(5).toString());
			selectEndDate(Cust_datalist.get(6).toString());
			enterCustomerContactName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			enterCustomerDesignation(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			enterContactNumber(Cust_datalist.get(7).toString());
			enterEmailAddress(Cust_datalist.get(8).toString());
			clickOnAddButton();
			waitForSpinnerToDisappear();
			Thread.sleep(2000);

			logger.log(LogStatus.PASS, "Customer Created Successfully");
		} catch (Exception e) {
			System.out.println("Failled to Add Customer -- \n Exception Occured " + e);
			logger.log(LogStatus.FAIL, "Failled to Add Customer ");
		}
		return custName;

	}

	public void updateCustomer() throws InterruptedException {
		try {
			String userdetails_JsonPath = "$..CustomerDetails.*";
			List<String> custDetails = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), userdetails_JsonPath);
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			getCustomerFromGrid();
			waitForSpinnerToDisappear();
			WebElement custName = custSetupPF.getCustomerNameTextBox();
			String newnamePostUpdate = custName.getText();
			System.out.println("New name of the Custoemr is " + newnamePostUpdate);
			enterCustomerContactName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			enterCustomerDesignation(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			enterContactNumber(custDetails.get(7).toString());
			enterEmailAddress(custDetails.get(8).toString());
			clickOnUpdateButton();
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Customer Details Updated succsessfully ");
		} catch (Exception e) {

			logger.log(LogStatus.FAIL, "Failled to Update Customer Details because ");
		}
	}

		public void deleteCustomerFromGrid() throws InterruptedException {

		try {

			/*String Userslistdata_JSONPath = "$..CustomerDetails.*";
			String Customer_Name = ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "$..Customer_Name");*/
			String Customer_Name=createCustomer();
			searchCustomerFromGrid(Customer_Name);
			getCustomerFromGrid();
			Thread.sleep(1200);
			waitForSpinnerToDisappear();
			clickOnDeleteButton();
			//getValidationMessageFromPage();
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Deleted customer Successfully");
		} catch (Exception e) {

			logger.log(LogStatus.FAIL, "Failled to Delete the User  ");

		}

	}

	// Please select start date less than end date
	public void validateCorrectDateRange() throws InterruptedException {
		try {
			String userdetails_JsonPath = "$..CustomerDetails.*";
			List<String> custDetails = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), userdetails_JsonPath);
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			String custName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
			WriteJsonFile.writeJSONFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Customer_Name",
					custName);
			selectCustomerCountry(custDetails.get(0).toString());
			Thread.sleep(1200);
			selectCustomerState(custDetails.get(1).toString());
			Thread.sleep(1200);
			selectCustomerCity(custDetails.get(2).toString());
			selectStartDate(custDetails.get(5).toString());
			selectEndDate(custDetails.get(6).toString());
			enterCustomerContactName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			Thread.sleep(1200);
			waitForSpinnerToDisappear();
			clickOnAddButton();
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Successfully Added customer with Valid Contract Date Range");

		} catch (Exception e) {

			logger.log(LogStatus.FAIL, "Failled to Add customer with Valid Contract Date Range");
		}
	}

	public void validateInCorrectDateRange() throws InterruptedException {
		try {
			String userdetails_JsonPath = "$..CustomerDetails.*";
			List<String> custDetails = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), userdetails_JsonPath);
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			String custName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
			WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Customer_Name",custName);
			enterCustomerName(custName);
			selectCustomerCountry(custDetails.get(0).toString());
			Thread.sleep(1200);
			selectCustomerState(custDetails.get(1).toString());
			Thread.sleep(1200);
			selectCustomerCity(custDetails.get(2).toString());
			selectStartDate(custDetails.get(6).toString());
			selectEndDate(custDetails.get(5).toString());
			enterCustomerContactName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			Thread.sleep(1200);
			// enterCustomerDetails();
			waitForSpinnerToDisappear();
			clickOnAddButton();
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Successfully validated the Invalid Date Range Acceptance Criterion ");

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
			logger.log(LogStatus.FAIL, "Could not create user");
		}
	}

	public void ValidateNewCreatedCustomerFromDBandDeleted()
			throws InterruptedException, SQLException, NullPointerException {
		String validationmsg = null;
		try {
			createCustomer();
			getDES_DBConnection();
			System.out.println("Back after creating connection");
			Statement stmnt = conn.createStatement();
			String queryString = "Select * from tblCustomer where CustomerName='" + name + "'";
			// String query = “select * from userinfo where userId='” + 1 + “‘”;
			ResultSet res = stmnt.executeQuery(queryString);
			System.out.println("Query Executed Successfully");
			logger.log(LogStatus.INFO, "Query to Get the Customer Details for the Selected Branch is Executed !");

			while (res.next()) {
				CustomerName = res.getString(2);
				Abbreviation = res.getString(3);
				ContractType = res.getString(10);
				Startdate = res.getString(11);
				EndDate = res.getString(12);
				State = res.getString(6);
				City = res.getString(7);
				ZipCOde = res.getString(9);
				System.out.println("Values Saved in tblCustomer are as below \n Customer Name- " + CustomerName
						+ "\n Abbriviation- " + Abbreviation + "\n Contract Type- " + ContractType + "\n StartDate- "
						+ Startdate + "\n EndDate- " + EndDate + "\n State- " + State + "\n City- " + City
						+ "\n ZipCode- " + ZipCOde);

			}

			element = custSetupPF.getgridTextBox();
			if (element != null) {
				element.clear();
				element.sendKeys(name);
				System.out.println("Enter same Name for Seach " + name);
				waitForSpinnerToDisappear();
				getCustomerFromGrid();
				waitForSpinnerToDisappear();
				Thread.sleep(2000);
				String custName = getCustomerNameFromGrid();
				/*
				 * String custAbbrr=getCustomerAbbriviationFromGrid(); String
				 * conType=getCustomerContractTypeFromGrid(); String
				 * custContStartDate=getCustomerStartDateFromGrid(); String
				 * custContEndDate=getCustomerEndDateFromGrid(); String
				 * custState=getCustomerStateFromGrid(); String
				 * custCity=getCustomerCityFromGrid(); String
				 * custZipCode=getCustomerZipCodeFromGrid();
				 */
				if (custName.equals(CustomerName)) {
					System.out.println(custName + " And " + CustomerName
							+ " Customer Name appeared on Grid found to saved successfully in DB Table tblCustomer ");
					/*
					 * System.out.println(custAbbrr +" And " +
					 * Abbreviation+" Customer Abbriviation found to be matched"
					 * ); System.out.println(conType +" And " +
					 * ContractType+" Customer Contract Type found to be matched"
					 * ); System.out.println(custContStartDate +" And " +
					 * Startdate+" Customer Contract Start date found to be matched"
					 * );
					 */
				} else {
					System.out.println("There is Mismatch with Customer Name " + CustomerName
							+ "found in DB against the Customer Name Enter for Seach" + custName);
				}
				getCustomerFromGrid();
				Thread.sleep(2000);
				clickOnDeleteButton();
				waitForSpinnerToDisappear();
				getValidationMessageFromPage();
				logger.log(LogStatus.PASS,
						"Custome Created with Above details Validated same details in DES_QA Database and Successfully deleted same User");

			}

		} catch (Exception e) {
			System.out.println("Failled to Add , validate and Delete Customer --Exception Occured " + e
					+ "Validation Error " + validationmsg);
			logger.log(LogStatus.FAIL, "Failled to Validated the Newly created user " + validationmsg);
		}

	}

	public void ValidateFileUploadForCustomerLog() {
		String validationMSg = "";
		try {
			String Userslistdata_JSONPath = "$..CustomerDetails.*";
			List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			String custName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
			WriteJsonFile.writeJSONFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Customer_Name",
					custName);
			enterCustomerName(custName);
			enterCustomerAbbriviation(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			enterCustomerAddress1(DES_UsersRole_Page_Action.generateRandomalphabets(10));
			enterCustomerAddress2(DES_UsersRole_Page_Action.generateRandomalphabets(10));
			selectCustomerCountry(Cust_datalist.get(0).toString());
			Thread.sleep(1200);
			selectCustomerState(Cust_datalist.get(1).toString());
			Thread.sleep(1200);
			selectCustomerCity(Cust_datalist.get(2).toString());
			enterCustomerContactName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			if (custName != null) {
				System.out.println("Verify if user can upload text file ");
				selectCustomerLogo(
						"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Projects\\mars\\JCI\\Project\\DES\\TestResources\\DES_Test.txt");
				waitForSpinnerToDisappear();
				clickOnAddButton();
				validationMSg = getValidationMessageFromPage();
				
			}
			if (validationMSg != null) {
				System.out.println("Verify if user can upload Document file ");
				selectCustomerLogo(
						"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Projects\\mars\\JCI\\Project\\DES\\TestResources\\DES_Test_Doc.docx");
				waitForSpinnerToDisappear();
				clickOnAddButton();
				waitForSpinnerToDisappear();
				validationMSg = getValidationMessageFromPage();
			}
			if (validationMSg != null) {
				System.out.println("Verify if user can upload PDF file ");
				selectCustomerLogo(
						"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Projects\\mars\\JCI\\Project\\DES\\TestResources\\DES_Test_PDFFile.pdf");
				clickOnAddButton();
				waitForSpinnerToDisappear();
				validationMSg = getValidationMessageFromPage();
			}
			if (validationMSg != null) {
				System.out.println("Verify if user can upload Image format file Like JPEG ");
				selectCustomerLogo(
						"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Projects\\mars\\JCI\\Project\\DES\\TestResources\\DES_Test_Tulips.jpeg");
				Thread.sleep(2000);
				waitForSpinnerToDisappear();
				clickOnAddButton();
				waitForSpinnerToDisappear();
				System.out.println("Customer Added with Logo having  Correct File format ");
				Thread.sleep(2000);

			}
			element = custSetupPF.getgridTextBox();
			if (element != null) {
				element.clear();
				element.sendKeys(custName);
				System.out.println("Enter same Name for Seach " + custName);
				waitForSpinnerToDisappear();
				getCustomerFromGrid();
				waitForSpinnerToDisappear();
				clickOnDeleteButton();
				waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Successfully Deleted user added for test");
			}

		} catch (Exception e) {
			System.out.println("Failled to upload the Logo");

		}
	}

	public void validateClearButton() throws InterruptedException {
		try {
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			waitForSpinnerToDisappear();
			element = custSetupPF.getCustomerNameFromGrid();
			if (element != null) {
				String CustNameGrid = element.getText();
				element.click();
				System.out.println(CustNameGrid + " Selected for Validation");
				waitForSpinnerToDisappear();
				Thread.sleep(1200);
				String custName = custSetupPF.getCustomerNameTextBox().getAttribute("value");
				String abbr = custSetupPF.getcustomerAbbreviationTextBox().getAttribute("value");
				String Address1 = custSetupPF.getcustomerAddress1TextBox().getAttribute("value");
				String Address2 = custSetupPF.getcustcustomerAddress2TextBox().getAttribute("value");
				/*
				 * String
				 * country=custSetupPF.getcustomerCountryDropdown().getAttribute
				 * ("value").toString(); String
				 * State=custSetupPF.getcustomerStateDropdown().getAttribute(
				 * "value"); String
				 * City=custSetupPF.getcustomerCityDropdown().getAttribute(
				 * "value"); String
				 * ZipCode=custSetupPF.getcustomerZipcode().getAttribute("value"
				 * ); String
				 * StartDate=custSetupPF.getcustomercustStartDate().getAttribute
				 * ("value"); String
				 * EndDate=custSetupPF.getcustomercustEndDate().getAttribute(
				 * "value"); String
				 * ContactName=custSetupPF.getcustomercustName().getAttribute(
				 * "value"); String
				 * Designation=custSetupPF.getcustcustomerAddress2TextBox().
				 * getAttribute("value"); String
				 * ContactNo=custSetupPF.getcustcustomerAddress2TextBox().
				 * getAttribute("value"); String
				 * Email=custSetupPF.getcustcustomerAddress2TextBox().
				 * getAttribute("value");
				 */
				System.out.println("Values found for the Customer are as below \n " + custName + "\n " + abbr + "\n "
						+ "\n " + Address1 + "\n " + Address2);
				// Thread.sleep(2000);
				waitForSpinnerToDisappear();
				clickOnClearButton();
				String custNamecl = custSetupPF.getCustomerNameTextBox().getAttribute("value");
				String abbrcl = custSetupPF.getcustomerAbbreviationTextBox().getAttribute("value");
				String Address1cl = custSetupPF.getcustomerAddress1TextBox().getAttribute("value");
				String Address2cl = custSetupPF.getcustcustomerAddress2TextBox().getAttribute("value");
				System.out.println("Clear Button is Enabled and Cleared Data from TextBox");
				System.out.println("Values found for post Clear are  \n " + custNamecl + "\n " + abbrcl + "\n "
						+ Address1cl + "\n " + Address2cl + "Will be appeare Blank as Expected");
				Thread.sleep(1200);
				waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Clear Button cleared Data field successfully");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Clear Button doesn't clear data --Failled to clear text fields ");
		}

	}

	

	public void createDuplicateUser() throws InterruptedException {
		try {
			String Userslistdata_JSONPath = "$..CustomerDetails.*";
			List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			String custName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
			WriteJsonFile.writeJSONFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Customer_Name",
					custName);
			enterCustomerName(custName);
			enterCustomerAbbriviation(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			enterCustomerAddress1(DES_UsersRole_Page_Action.generateRandomalphabets(10));
			enterCustomerAddress2(DES_UsersRole_Page_Action.generateRandomalphabets(10));
			selectCustomerCountry(Cust_datalist.get(0).toString());
			Thread.sleep(1200);
			selectCustomerState(Cust_datalist.get(1).toString());
			Thread.sleep(1200);
			selectCustomerCity(Cust_datalist.get(2).toString());
			enterCustomerContactName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			waitForSpinnerToDisappear();
			clickOnAddButton();
			waitForSpinnerToDisappear();
			enterCustomerName(custName);// Add same name as used in above steps to
									// check if the same name can be duplicated
			selectCustomerCountry(Cust_datalist.get(0).toString());
			Thread.sleep(1200);
			selectCustomerState(Cust_datalist.get(1).toString());
			Thread.sleep(1200);
			selectCustomerCity(Cust_datalist.get(2).toString());
			enterCustomerContactName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
			waitForSpinnerToDisappear();
			clickOnAddButton();
			waitForSpinnerToDisappear();
			Thread.sleep(1200);
			element = custSetupPF.getgridTextBox();
			if (element != null) {
				element.clear();
				element.sendKeys(custName);
				System.out.println(
						"Enter same Customer Name " + custName + " for Search in Grid and to Delete the Created User ");
				waitForSpinnerToDisappear();
				getCustomerFromGrid();
				waitForSpinnerToDisappear();
				Thread.sleep(2000);
				// getCustomerFromGrid();
				clickOnDeleteButton();
				waitForSpinnerToDisappear();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getListofCustomersFromGrid() {
		List<WebElement> custList = driver.findElements(By.xpath(
				"//div[substring(@id, string-length(@id) - string-length('-uiGrid-0007-cell') +1) = '-uiGrid-0007-cell']"));
		System.out.println(custList.size() + " Number of users are present");

		Iterator<WebElement> itr = custList.iterator();
		while (itr.hasNext()) {
			logger.log(LogStatus.PASS, itr.next().getText());
		}

	}

	public void validateListOfCustomerPresentonGrid() {
		try {
			//loginPA.DES_CorrectLogin();
			//DES_Home_Page_Action.clickeOnSetup();
			DES_Home_Page_Action.navigateToSetupPage();
			getListofCustomersFromGrid();
			logger.log(LogStatus.PASS, "Successfully verified the List of user preset on Grid");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not get List of Customer from Grid");
		}

	}

}
