/**
 * 
 */
package mars.JCI.Project.CSD.SSF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_Create_SSF_Page_Factory;

/**
 * @author cdeyso
 *
 */
/**
 * @author cdeyso
 *
 */
public class CSD_SSF_Create_SSF_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	private static CSD_SSF_Create_SSF_Page_Factory ssfPageFactory = null;
	private static CSD_SSF_DataValidation_Master ssf_DataValMaster = null;
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public static String branch_id,UserID,RoleID,IsAdmin,cityID,address,country,state_prov,city,zip,contactno_office = null;
	public static List<String> admin_branches = new ArrayList<String>();
	public static List<String> branch_names = new ArrayList<String>();
	public static List<String> non_admin_branches = new ArrayList<String>();
	public static String branch_name = "Automation_TestBranch";// Houston, TX Service -- Test_SSFbranch
	
	public static String project_dir = "C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Projects\\mars\\JCI\\Project\\CSD\\TestResources";

	public CSD_SSF_Create_SSF_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		ssfPageFactory = new CSD_SSF_Create_SSF_Page_Factory(driver, logger);
		ssf_DataValMaster = new CSD_SSF_DataValidation_Master(logger);
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	public static List<String> getAllOptions(WebElement element) {
	    List<String> options = new ArrayList<String>();
	    for (WebElement option : new Select(element).getOptions()) {
	        String txt = option.getText();
	        if (option.getAttribute("value") != "") options.add(option.getText());
	    }
	    return options;
	}
	
	public static void selectByVisibleText(WebElement element, String text) {
		
		try {
			System.out.println("element "+element+"text "+text);
			new Select(element).selectByVisibleText(text);
			System.out.println(text.toUpperCase()+" Option is Selected");
			logger.log(LogStatus.INFO, text.toUpperCase()+" Option is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
		}
	}
	
	public static String getSelectedOptionFromDropDown(WebElement element) {
		
		Select sel_element_Val = new Select(element);
		String element_Val_text = sel_element_Val.getFirstSelectedOption().getText();
		return element_Val_text;
	}
	
	public static void getCSDDBSession() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Establishing Connection to CSDDB !!");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
		
		
	}
	

	//==========WebElement related metods--START
	
	//Click on the Site Setup Tab of the Left Sided Tree
	public static void clickOnSiteSetupLink(){
		WebElement element=ssfPageFactory.get_ssfTab_SiteSetupLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Site Setup Link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Site Setup Link");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Click on the SSF Tab of the Left Sided Tree
	public static void clickOnSSFLink(){
		WebElement element=ssfPageFactory.get_ssfTab_SSFTabLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "SSF Link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find SSF Link");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Click on the Create SSF Tab 
	public static void clickOnCreateSSFLink(){
		WebElement element=ssfPageFactory.get_ssfTab_CreateSSFLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Create SSF Link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find  Create SSF Link");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Check if SSF Form is loaded or not and get all the Values from the Branch DropDown
	public static void checkOnContractInformationPage(){
		WebElement element=ssfPageFactory.get_ssfTab_CI_BranchLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			branch_names = getAllOptions(element);
			System.out.println(branch_names);
			//element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Create SSF Form opened successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to open  Create SSF Form");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	/*//Get all the Values from the Branch DropDown
	public static void getAllBranchValues(){
		WebElement element=ssfPageFactory.get_ssfTab_CI_BranchLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			System.out.println("Inside getAllBranchValues");
			List<String> branch_names = getAllOptions(element);
			System.out.println(branch_names);
			//element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "All Branch Values are Collected successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to collect all Branch values");
			elementStatus=false;
		}
		//return elementStatus;
	}*/
	
	//Verify the Eligible Branches are displayed only while The user is Logged IN.
	@SuppressWarnings("static-access")
	public static void checkIfValidBranchesAreDisplayedForLoggedUser() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		
		getCSDDBSession();//ssf_DataValMaster.getCSDDBSession();
		
		if(admin_branches.size()>0)admin_branches.clear();
		if(non_admin_branches.size()>0)non_admin_branches.clear();
		/*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Establishing Connection to CSDDB !!");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		Connection conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");*/
				
		Statement statement = conn.createStatement();
		String queryString = "select * from tblmstuser where firstname= 'souvik'";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!");
	    logger.log(LogStatus.PASS, "Query to get the UserID and Role ID from the Loggged In user is Executed !");
	    ResultSetMetaData metaData = rs.getMetaData();
	    while (rs.next()) {
            for (int i=1; i<=metaData.getColumnCount(); i++) {
                    System.out.print("  "  + rs.getString(i));
                    UserID = rs.getString(1);
                    RoleID = rs.getString(4);
                   
            }
            System.out.println();
	    }
	    System.out.println("UserID for the Logged IN User is "+UserID+" and the  Role ID is "+RoleID);
	    logger.log(LogStatus.PASS, "UserID for the Logged IN User is "+UserID+" and the  Role ID is "+RoleID);
	    rs.close();
	    
	    String querString_2 = "select * from tblmstrole where roleid = '"+RoleID+"'";
	    ResultSet rs_2 = statement.executeQuery(querString_2);
	    System.out.println("Query Executed !!");
	    logger.log(LogStatus.PASS, "Query to Check whether the user is Admin or not is Executed !");
	    ResultSetMetaData metaData_2 = rs_2.getMetaData();
	    while (rs_2.next()) {
            for (int i=1; i<=metaData_2.getColumnCount(); i++) {
                    System.out.print("  "  + rs_2.getString(i));
                    IsAdmin = rs_2.getString(4);
                   
            }
            System.out.println();
	    }
	    
	    if(IsAdmin.equals("1"))
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is an Admin !");
	    	//logger.log(LogStatus.INFO, "Verifying whether the Proper Branches are Mapped or not !");
	    	String querString_admin = "select VB.GeographyId,VB.GeographyName,VB.CountryId,VB.CountryName,VB.RegionId,VB.RegionName,VB.BranchId,VB.BranchName,VB.Longitude,VB.Lattitude,VB.Address1,VB.Address2,VB.City,VB.[State],VB.ZipCode,VB.PhoneCovHours,VB.TimeZone,VB.TollFree,VB.Branch_Code,CB.ContactDetailsId,CB.ContactNumberMobile,CB.ContactNumberOffice,CB.ContactPerson,CB.EmailAddress from View_Branch  VB left join tblMstBranchContactDetails  CB  on  VB.BranchId=  CB.BranchId  order by branchname ";
		    ResultSet rs_admin = statement.executeQuery(querString_admin);
		    System.out.println("Query Executed !!\n"+querString_admin);
		    logger.log(LogStatus.PASS, "Query to Check all the Properly mapped Branches is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_admin.next()) {
	         //   for (int i=1; i<=metaData_admin.getColumnCount(); i++) {
	                    //System.out.print("  "  + rs_admin.getString(i));
	                    //System.out.println("rs_admin.getString(8)"+rs_admin.getString(8));
	                    //Thread.sleep(2000);
	                    admin_branches.add(rs_admin.getString(8));
	                    branch_id = rs_admin.getString(7);
	           // }
	           // System.out.println();
		    }
		    
		    System.out.println("admin_branches "+admin_branches);
		    
		    checkForValidBranchedMappedForLoggedInUser(admin_branches);
		    
	    	
	    }
	    else if (!IsAdmin.equals("1")) 
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is NOT an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Branches are Mapped or not !");
	    	String querString_non_admin = "with cte as(select VB.GeographyId,VB.GeographyName,VB.CountryId,VB.CountryName,VB.RegionId,VB.RegionName,VB.BranchId,VB.BranchName,VB.Longitude,VB.Lattitude,VB.Address1,VB.Address2,VB.City,VB.[State],VB.ZipCode,VB.PhoneCovHours,VB.TimeZone,VB.TollFree,VB.Branch_Code,CB.ContactDetailsId,CB.ContactNumberMobile,CB.ContactNumberOffice,CB.ContactPerson,CB.EmailAddress,ROW_NUMBER() OVER(ORDER BY CB.branchid) as Id from View_Branch  VB left join tblMstBranchContactDetails  CB on  VB.BranchId=  CB.BranchId inner join tblCustomerUserMapping CU on CU.Branchid=VB.BranchId where CU.Userid="+UserID+")select GeographyId,GeographyName,CountryId,CountryName,RegionId,RegionName,BranchId,BranchName,Longitude,  Lattitude,Address1,Address2,City,[State],ZipCode,PhoneCovHours,TimeZone,TollFree,Branch_Code, ContactDetailsId,ContactNumberMobile,ContactNumberOffice,ContactPerson,EmailAddress from cte where id in (select min(id) from cte group by branchid) order by BranchName ";
		    ResultSet rs_non_admin = statement.executeQuery(querString_non_admin);
		    System.out.println("Query Executed !!\n"+querString_non_admin);
		    logger.log(LogStatus.PASS, "Query to Check whether the user is Admin or not is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_non_admin.next()) {
	         //   for (int i=1; i<=metaData_admin.getColumnCount(); i++) {
	                    //System.out.print("  "  + rs_admin.getString(i));
	                    //System.out.println("rs_admin.getString(8)"+rs_admin.getString(8));
	                    //Thread.sleep(2000);
	                    non_admin_branches.add(rs_non_admin.getString(8));
	           // }
	           // System.out.println();
		    }
		    
		    System.out.println("non_admin_branches "+non_admin_branches);
	    	
	    	checkForValidBranchedMappedForLoggedInUser(non_admin_branches);
		}
	    
		
	}
	
	public static void checkForValidBranchedMappedForLoggedInUser(List<String> var_branches) {
		
		System.out.println("Inside checkForValidBranchedMappedForLoggedInUser Method !");
		logger.log(LogStatus.INFO, "Verifying whether the Proper Branches are Mapped or not !");
		
		int admin_branches_length = var_branches.size();
		int ssf_branch_length = branch_names.size();
		
		System.out.println("admin_branches_length "+admin_branches_length);
		System.out.println("ssf_branch_length "+ssf_branch_length);
		
		if(ssf_branch_length - 1 == admin_branches_length)
		{
			logger.log(LogStatus.PASS, "All the eligible Branches are Mapped to the Logged IN User!");
			for (int i = 0; i < admin_branches_length; i++) {
				if (var_branches.get(i).contains(branch_names.get(i+1))) {
					System.out.println("Branch : "+var_branches.get(i)+" is Present and is mapped properly in the SSF Form -- "+i);
					logger.log(LogStatus.PASS, "Branch : "+var_branches.get(i)+" is Present and is mapped properly in the SSF Form !");
				}
				
			}
		}
		else
		{
			logger.log(LogStatus.FAIL, "All the eligible Branches are  NOT Mapped to the Logged IN User!");
			logger.log(LogStatus.FAIL, "Branches Mapped : "+(ssf_branch_length - 1)+" and Eligible Branches : "+admin_branches_length);
		}
		
	}
	
	//Select Branch
	public static void selectBranch(){
		WebElement element=ssfPageFactory.get_ssfTab_CI_BranchLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			selectByVisibleText(element, branch_name);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Branch is selected successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Branch");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Select Contract Type
	public static void selectContractType() {
		WebElement element=ssfPageFactory.get_ssfTab_CI_ContractTypeLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			selectByVisibleText(element, "New PSA Retrofit (hosting charge of $27/month/chiller)");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Contract Type is selected successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Contract Type");
			elementStatus=false;
		}
		//return elementStatus;
		
	}
	
	//Set PSA Agreement Value
	public static void setPSAAgreementValue() {
		WebElement element=ssfPageFactory.get_ssfTab_CI_PSAAgreementLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			element.sendKeys("abcd1234");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "PSA Agreement Value is set selected successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to set PSA Agreement Value");
			elementStatus=false;
		}
		//return elementStatus;
		
	}
	
	//Check Status of PO Number
	public static void checkPONumberStatus() {
		WebElement element=ssfPageFactory.get_ssfTab_CI_PONumberLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			try {
				elementStatus = element.isEnabled();
				if (elementStatus == true) {
					logger.log(LogStatus.INFO, "Logged IN User has permission to edit the PO Number Box.");
					element.sendKeys("abcd1234");
				}
				
			} catch (InvalidElementStateException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				logger.log(LogStatus.INFO, "Logged IN User does not have permission to edit the PO Number Box.");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to set PSA Agreement Value");
			//elementStatus=false;
		}
		//return elementStatus;
		
	}
	
	//validate primary contact no , name and email for the selected branch
	public static void validatePrimaryContactDetails() throws SQLException, ClassNotFoundException {
		WebElement element_name=ssfPageFactory.get_ssfTab_CI_BPCNLink();
		WebElement element_phone=ssfPageFactory.get_ssfTab_CI_BPCPLink();
		WebElement element_email=ssfPageFactory.get_ssfTab_CI_BPCELink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element_name !=null) {
			String pc_name = element_name.getAttribute("value");
			String pc_contact = element_phone.getAttribute("value");
			String pc_email= element_email.getAttribute("value");
			
			System.out.println(pc_name+" "+pc_contact+" "+pc_email);
			if(pc_name.equals("") && pc_contact.equals("") && pc_email.equals(""))
			{
				logger.log(LogStatus.INFO, "Selected Branch doesn't Have any Personal Contact Details Updated.");
				getCSDDBSession();
				logger.log(LogStatus.INFO, "Getting the CityID Details for Further Reference !");
				Statement statement = conn.createStatement();
		    	String querString_non_admin = "select VB.GeographyId,VB.GeographyName,VB.CountryId,VB.CountryName,VB.RegionId,VB.RegionName,VB.BranchId,VB.BranchName,VB.Longitude,VB.Lattitude,VB.Address1,VB.Address2,VB.City,VB.CityId,VB.[State],VB.[StateId],VB.ZipCode,VB.PhoneCovHours,VB.TimeZone,VB.TollFree,VB.Branch_Code,CB.ContactDetailsId,CB.ContactNumberMobile,CB.ContactNumberOffice,CB.ContactPerson,CB.EmailAddress  from View_Branch  VB left join tblMstBranchContactDetails  CB  on  VB.BranchId=  CB.BranchId   where branchname= '"+branch_name+"' order by branchname ";
			    ResultSet rs = statement.executeQuery(querString_non_admin);
			    System.out.println("Query Executed !!");
			    logger.log(LogStatus.PASS, "Query to Check the CityID for Shipping Information Validation is Executed !");
			    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
			    while (rs.next()) {
			    	
			    			address = rs.getString(11);//System.out.println("address "+address);
			    			cityID = rs.getString(14);//System.out.println("cityID "+cityID);
			    			zip = rs.getString(17);//System.out.println("zip "+zip);
			    			contactno_office = rs.getString(24);
			    }
			}
			else
			{
			getCSDDBSession();
			logger.log(LogStatus.INFO, "Verifying whether the Proper Branches are Mapped or not !");
			Statement statement = conn.createStatement();
	    	String querString_non_admin = "select VB.GeographyId,VB.GeographyName,VB.CountryId,VB.CountryName,VB.RegionId,VB.RegionName,VB.BranchId,VB.BranchName,VB.Longitude,VB.Lattitude,VB.Address1,VB.Address2,VB.City,VB.CityId,VB.[State],VB.[StateId],VB.ZipCode,VB.PhoneCovHours,VB.TimeZone,VB.TollFree,VB.Branch_Code,CB.ContactDetailsId,CB.ContactNumberMobile,CB.ContactNumberOffice,CB.ContactPerson,CB.EmailAddress  from View_Branch  VB left join tblMstBranchContactDetails  CB  on  VB.BranchId=  CB.BranchId   where branchname= '"+branch_name+"' order by branchname ";
		    ResultSet rs = statement.executeQuery(querString_non_admin);
		    System.out.println("Query Executed !!");
		    logger.log(LogStatus.PASS, "Query to Check whether the user is Admin or not is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs.next()) {
		    	
		    			address = rs.getString(11);System.out.println("address "+address);
		    			cityID = rs.getString(14);System.out.println("cityID "+cityID);
		    			zip = rs.getString(17);System.out.println("zip "+zip);
		    	
		    			if(pc_name.equals(rs.getString(25)));
		    			logger.log(LogStatus.PASS, "Primary Contact Name Value is mapped properly");
		    			if(pc_contact.equals(rs.getString(24)));
		    			logger.log(LogStatus.PASS, "Primary Contact Number Value is mapped properly");
		    			if(pc_email.equals(rs.getString(26)));
		    			logger.log(LogStatus.PASS, "Primary Contact Email Value is mapped properly");
		    			
		    }
			}
		    
			//element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Primary Contact Details Validated successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to validate Primary Contact Details ");
			elementStatus=false;
		}
		//return elementStatus;
		
	}
	
	//Set Sales Order # for the Customer Branch
	public static void setSalesOrderNo() throws InterruptedException {
		WebElement element=ssfPageFactory.get_ssfTab_CI_SalesOrderLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null) {
			element.sendKeys("abcd0987");;
			//element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Sales Order # is set successfully");
			elementStatus=true;
			Thread.sleep(10000);
		}else{
			logger.log(LogStatus.FAIL, "Failed to set Sales Order # ");
			elementStatus=false;
		}
		//return elementStatus;
		
	}
	
	//
	public static void setBranchAddress(boolean flag) throws InterruptedException, ClassNotFoundException, SQLException {
		
		if (flag == true) {
			setBranchAddress_sameAddress();
			validateBranchAddressDetails();
			setShipToLocationForTheBranch();
		}
		else if (flag == false){
			setBranchAddress_newAddress();
		}
	}
	
	
	//Update Shipping Information Section for New SSF form -- with the same address
	public static void setBranchAddress_sameAddress() throws InterruptedException {
		WebElement element_SI_expand=ssfPageFactory.get_ssfTab_SI_ExpandLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element_SI_expand !=null) {
			element_SI_expand.click();
			waitForSpinnerToDisappear();
			WebElement element_SI_add=ssfPageFactory.get_ssfTab_SI_SameAddressTypeLink();
			element_SI_add.click();
			try {
				WebElement element_SI_popup = ssfPageFactory.get_ssfTab_SI_PopUpLink();
				if(element_SI_popup != null ){
				element_SI_add.click();
				logger.log(LogStatus.INFO, "The Selected Branch Doesn't have any Contact Information Details defined at Master Table !");
				}
				else{
					logger.log(LogStatus.PASS, "Shipping Information Section is set selected successfully");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.PASS, "Shipping Information Section is set selected successfully");
			}
			//element.click();
			/*WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Shipping Information Section is set selected successfully");*/
			elementStatus=true;
			//Thread.sleep(10000);
		}else{
			logger.log(LogStatus.FAIL, "Failed to Update Shipping Info Section");
			elementStatus=false;
		}
		//return elementStatus;
		
	}
	
	//Set the New Shipping Address
	public static void setBranchAddress_newAddress() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement element_SI_expand=ssfPageFactory.get_ssfTab_SI_ExpandLink();
		element_SI_expand.click();
		WebElement add_shipTo=ssfPageFactory.get_ssfTab_SI_ShipToLink();
		if (add_shipTo !=null) {
			add_shipTo.sendKeys("Test Ship To");
			waitForSpinnerToDisappear();
			WebElement add_shippingAddress=ssfPageFactory.get_ssfTab_SI_ShippingAddressLink();
			add_shippingAddress.sendKeys("Test address");
			WebElement add_shippingCountry=ssfPageFactory.get_ssfTab_SI_ShippingCountyLink();
			selectByVisibleText(add_shippingCountry, "United States");
			waitForSpinnerToDisappear(); Thread.sleep(2000);
			WebElement add_shippingState=ssfPageFactory.get_ssfTab_SI_ShippingStateLink();
			selectByVisibleText(add_shippingState, "Arizona");
			waitForSpinnerToDisappear(); Thread.sleep(2000);
			WebElement add_shippingCity=ssfPageFactory.get_ssfTab_SI_ShippingCityLink();
			selectByVisibleText(add_shippingCity, "Florence");
			waitForSpinnerToDisappear();
			WebElement add_shippingZip=ssfPageFactory.get_ssfTab_SI_ShippingZipCodeLink();
			add_shippingZip.sendKeys("12345");
			waitForSpinnerToDisappear();
			WebElement add_attentionTo = ssfPageFactory.get_ssfTab_SI_ShippingAttentionToLink();
			add_attentionTo.sendKeys("Souvik Dey");
			
			logger.log(LogStatus.PASS, "New Shipping Information Section is set selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to Update Shipping Info Section");
		}
	}
	
	//Validate the Contact Information Details for the Selected Branch.
	public static void validateBranchAddressDetails() throws InterruptedException, ClassNotFoundException, SQLException {
		
		waitForSpinnerToDisappear();
		WebElement element_add=ssfPageFactory.get_ssfTab_SI_ShippingAddressLink();
		WebElement element_country=ssfPageFactory.get_ssfTab_SI_ShippingCountyLink();
		WebElement element_state_prov=ssfPageFactory.get_ssfTab_SI_ShippingStateLink();
		WebElement element_city=ssfPageFactory.get_ssfTab_SI_ShippingCityLink();
		WebElement element_zip=ssfPageFactory.get_ssfTab_SI_ShippingZipCodeLink();
		WebElement element_phno=ssfPageFactory.get_ssfTab_SI_ShippingPhoneNumberLink();
		
		getCSDDBSession();
		Statement statement = conn.createStatement();
		String querString_non_admin = "Select c.CountryId as CountryId,c.CountryName as CountryName,s.id as StateId,s.Name as StateName,city.id as CityId,city.Name as CityName from tblMstCountry c inner join ssf_tblMstState s on c.CountryId=s.countryid inner join ssf_tblMstcity city on s.id=city.stateid where city.id ='"+cityID+"'";
	    ResultSet rs = statement.executeQuery(querString_non_admin);
	    System.out.println("Query Executed !!");
	    logger.log(LogStatus.PASS, "Query to Get the Address Details for the Selected Branch is Executed !");
	    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
	    while (rs.next()) {
	    	
	    			country = rs.getString(2);
	    			state_prov = rs.getString(4);
	    			city = rs.getString(6);
	    }
		
		boolean elementStatus=false;
		if (element_add !=null) {
			String add_val = element_add.getAttribute("value");
			if(!add_val.equals("")){
				if(add_val.equals(address))
					logger.log(LogStatus.PASS, "Address Value for the Selected Branch is populated Properly with Value :"+address);
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to fetch the Address Value for the Branch ");
			elementStatus=false;
		}
		if (element_country !=null) {
			
			String country_Val_text = getSelectedOptionFromDropDown(element_country);
			if(!country_Val_text.equals("")){
				if(country_Val_text.equals(country))
					logger.log(LogStatus.PASS, "Country Value for the Selected Branch is populated Properly with Value : "+country);
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to fetch the Country Value for the Branch ");
			elementStatus=false;
		}
		if (element_state_prov !=null) {
			
			String state_prov_Val_text = getSelectedOptionFromDropDown(element_state_prov);
			if(!state_prov_Val_text.equals("")){
				if(state_prov_Val_text.equals(state_prov))
					logger.log(LogStatus.PASS, "State/Province Value for the Selected Branch is populated Properly with Value : "+state_prov);
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to fetch the State/Province Value for the Branch ");
			elementStatus=false;
		}
		if (element_city !=null) {
			
			String city_Val_text = getSelectedOptionFromDropDown(element_city);
			if(!city_Val_text.equals("")){
				if(city_Val_text.equals(city))
					logger.log(LogStatus.PASS, "City Value for the Selected Branch is populated Properly with Value : "+city);
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to fetch the City Value for the Branch ");
			elementStatus=false;
		}
		if (element_zip !=null) {
			String zip_val = element_zip.getAttribute("value");
			if(!zip_val.equals("")){
				if(zip_val.equals(zip))
					logger.log(LogStatus.PASS, "ZIP Value for the Selected Branch is populated Properly with Value : "+zip);
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to fetch the ZIP Value for the Branch ");
			elementStatus=false;
		}
		if (element_phno !=null) {
			String phone_val = element_phno.getAttribute("value");
			if(!phone_val.equals("")){
				if(phone_val.equals(contactno_office))
					logger.log(LogStatus.PASS, "Office Contact No. Value for the Selected Branch is populated Properly with Value : "+contactno_office);
			}
			else if(phone_val.equals("")){
				if(phone_val.equals(contactno_office))
					logger.log(LogStatus.PASS, "Office Contact No. Value for the Selected Branch is populated Properly with Value : "+contactno_office);
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to fetch the Office Contact No. Value for the Branch ");
			elementStatus=false;
		}
		
	}
	
	//Set the Ship To Location for the Selected Branch
	public static void setShipToLocationForTheBranch() {
		
		WebElement element=ssfPageFactory.get_ssfTab_SI_ShipToLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.sendKeys("Test_ShipTo");
			waitForSpinnerToDisappear();
			WebElement add_attentionTo = ssfPageFactory.get_ssfTab_SI_ShippingAttentionToLink();
			add_attentionTo.sendKeys("Souvik Dey");
			//element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Ship To Location is set successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to set Ship To Location");
		}
		
	}
	
	
	//Expand Customer Site Information Section
	public static void expandCustomerSiteInfoSection() {
		
		WebElement element=ssfPageFactory.get_ssfTab_CSI_ExpandLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Customer Site Information Section Expanded Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to Expand Customer Site Information Section");
		}
		
	}
	
	//Select NEW Customer for the Customer Site Information Section
	public static void selectNewSSFCustomer() throws InterruptedException {
		
		WebElement select_cus_element=ssfPageFactory.get_ssfTab_CSI_SelectCustomerLink();
		waitForSpinnerToDisappear();
		if (select_cus_element !=null) {
			select_cus_element.click();
			waitForSpinnerToDisappear();
			WebElement newCust_element = ssfPageFactory.get_ssfTab_CSI_NewCustomerLink();
			if(newCust_element.isSelected()){
				waitForSpinnerToDisappear();
				WebElement newCustName_element = ssfPageFactory.get_ssfTab_CSI_NewCustomerNameLink(); 
				Thread.sleep(2000);
				newCustName_element.sendKeys("NewTestCustomer");
				String temp_var = newCustName_element.getAttribute("value");
				if(temp_var.equals("NewTestCustomer")){
					logger.log(LogStatus.INFO, "New Customer Name is Entered!");
				}else{
					newCustName_element.sendKeys("NewTestCustomer");
					logger.log(LogStatus.INFO, "New Customer Name is Entered!");
				}
				WebElement newCustName_set = ssfPageFactory.get_ssfTab_CSI_SetCustomerNameLink(); 
				newCustName_set.click();
				logger.log(LogStatus.INFO, "New Customer Name is Set!");
			}else{
				waitForSpinnerToDisappear();
				newCust_element.click();
				WebElement newCustName_element = ssfPageFactory.get_ssfTab_CSI_NewCustomerNameLink();
				//newCustName_element.clear();
				Thread.sleep(2000);
				newCustName_element.sendKeys("NewTestCustomer");
				WebElement newCustName_set = ssfPageFactory.get_ssfTab_CSI_SetCustomerNameLink(); 
				newCustName_set.click();
				logger.log(LogStatus.INFO, "New Customer Name is Set!");
			}
			validateCustNamePopulatedOrNot("NewTestCustomer");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Desired Customer Name is Updated Properly");
		}else{
			logger.log(LogStatus.FAIL, "Failed to set Customer Name");
		}
		
	}
	
	
	//Set AR Number for New Created Customer
	public static void setARNoForNewSSFCustomer() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement custArNo_element = ssfPageFactory.get_ssfTab_CSI_CustomerARLink();
		if (custArNo_element !=null) {
			waitForSpinnerToDisappear();
			System.out.println("Cust AR No "+custArNo_element.getAttribute("value"));
			if(custArNo_element.getAttribute("value") != ""){ 
				logger.log(LogStatus.INFO, "Customer Already Contains a AR Number!");
			}else{
				custArNo_element.sendKeys("123789");
				logger.log(LogStatus.INFO, "New Customer AR Number is Set!");
			}
			logger.log(LogStatus.PASS, "Desired Customer AR Number is Updated Properly");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update Customer AR Number");
		}
	}
	
	//Set New Site/Facility for the Created Customer
	public static void setNewFacilityForCustomer() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement select_cus_element=ssfPageFactory.get_ssfTab_CSI_SetFacilityNameLink();
		waitForSpinnerToDisappear();
		if (select_cus_element !=null) {
			select_cus_element.click();
			waitForSpinnerToDisappear();
			WebElement newCust_element = ssfPageFactory.get_ssfTab_CSI_SetNewFacilityNameLink();
			if(newCust_element.isSelected()){
				waitForSpinnerToDisappear();
				WebElement newCustName_element = ssfPageFactory.get_ssfTab_CSI_SetNewFacilityNameTextBoxLink(); 
				//newCustName_element.clear();
				Thread.sleep(2000);
				newCustName_element.sendKeys("NewTestCustomerFacility");
				String temp_var = newCustName_element.getAttribute("value");
				if(temp_var.equals("NewTestCustomerFacility")){
					logger.log(LogStatus.INFO, "New Customer Facility Name is Entered!");
				}else{
					Thread.sleep(2000);
					newCustName_element.sendKeys("NewTestCustomerFacility");
					logger.log(LogStatus.INFO, "New Customer Facility Name is Entered!");
				}
				WebElement newCustName_set = ssfPageFactory.get_ssfTab_CSI_SetFacilityLink();
				newCustName_set.click();
				logger.log(LogStatus.INFO, "New Customer Facility Name is Set!");
			}else{
				waitForSpinnerToDisappear();
				newCust_element.click();
				WebElement newCustName_element = ssfPageFactory.get_ssfTab_CSI_SetNewFacilityNameTextBoxLink(); 
				//newCustName_element.clear();
				Thread.sleep(2000);
				newCustName_element.sendKeys("NewTestCustomerFacility");
				WebElement newCustName_set = ssfPageFactory.get_ssfTab_CSI_SetFacilityLink();
				newCustName_set.click();
				logger.log(LogStatus.INFO, "New Customer Facility Name is Set!");
			}
			validateFacilityNamePopulatedOrNot("NewTestCustomerFacility");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Desired Customer Facility Name is Updated Properly");
		}else{
			logger.log(LogStatus.FAIL, "Failed to set Customer Name Facility");
		}
		
	}
	
	//Check if the PopUP confirmation is present or not 
	public static void checkForConfirmationPopUp() {
		
		waitForSpinnerToDisappear();
		WebElement popup_element=ssfPageFactory.get_ssfTab_SaveConfirmLink();
		if(popup_element != null){
			popup_element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Pop Up is Handled");			
		}else{
			logger.log(LogStatus.FAIL, "Error Handling Pop Up");
		}
		
	}
	
	//Set Customer and Site Info Details -- Mendatory Fields
	public static void setMendatoryCustomerSiteInfoDetailsNew() throws InterruptedException {
		
		Thread.sleep(2000);
		waitForSpinnerToDisappear();
		checkForConfirmationPopUp();
		WebElement timezone_element=ssfPageFactory.get_ssfTab_CSI_CustomerTimeZOneLink();
		if(timezone_element != null){
			waitForSpinnerToDisappear();
			selectByVisibleText(timezone_element, "(GMT) Casablanca, Monrovia");
			logger.log(LogStatus.INFO, "Site TimeZone is Selected");
			WebElement address_element=ssfPageFactory.get_ssfTab_CSI_FacilityAddressLink();
			address_element.sendKeys("TestFacilityAdd");
			logger.log(LogStatus.INFO, "Site Address is Set properly");
			WebElement country_element=ssfPageFactory.get_ssfTab_CSI_FaciltiyCountyLink();
			selectByVisibleText(country_element, "United States");
			logger.log(LogStatus.INFO, "Site Country is Selected");
			Thread.sleep(2000);
			WebElement state_element=ssfPageFactory.get_ssfTab_CSI_facilityStateLink();
			selectByVisibleText(state_element, "Arizona");
			logger.log(LogStatus.INFO, "Site State is Selected");
			Thread.sleep(2000);
			WebElement city_element=ssfPageFactory.get_ssfTab_CSI_facilityCityLink();
			selectByVisibleText(city_element, "Phoenix");
			logger.log(LogStatus.INFO, "Site City is Selected");
			WebElement zip_element=ssfPageFactory.get_ssfTab_CSI_FacilityZipCodeLink();
			zip_element.sendKeys("98765");
			logger.log(LogStatus.INFO, "Site Zip is Set properly");
			WebElement typeofBusiness_element=ssfPageFactory.get_ssfTab_CSI_facilityVerticalLink();
			selectByVisibleText(typeofBusiness_element, "HOTEL");
			logger.log(LogStatus.INFO, "Site Type of Business is Selected");
			
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Customer and Site Info Details are updated Properly for the New Customer");			
		}else{
			logger.log(LogStatus.FAIL, "Failed to Update Customer and Site Details");
		}
		
	}
	
	//Select Existing Customer for the Customer Site Information Section
	public static void selectExistingCustomerFromDropdown() throws InterruptedException {
		
		WebElement select_cus_element=ssfPageFactory.get_ssfTab_CSI_SelectCustomerLink();
		waitForSpinnerToDisappear();
		if (select_cus_element !=null) {
			select_cus_element.click();
			waitForSpinnerToDisappear();
			Thread.sleep(5000);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Select Customer button is Clicked Successfully!");
			WebElement existing_cus_option = ssfPageFactory.get_ssfTab_CSI_ExistingCustomerLink();
			if (existing_cus_option !=null)
			existing_cus_option.click();
			logger.log(LogStatus.PASS, "Existing Customer option is selected Successfully!");
			waitForSpinnerToDisappear();
			WebElement existing_cus_name = ssfPageFactory.get_ssfTab_CSI_ExistingCustomerNameLink();
			existing_cus_option.click();
			waitForSpinnerToDisappear();
			existing_cus_option.click();
			selectByVisibleText(existing_cus_name, "Automation_TestCustomer"); //ATRIUM MEDICAL CENTER -- Automation_TestCustomer
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//select[@name='ddlCustName']/option[contains(text(),'Automation_TestCustomer')]")));
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Desired Customer Name is Selected From the Dropdown");
			WebElement set_cus_name = ssfPageFactory.get_ssfTab_CSI_SetCustomerNameLink();
			set_cus_name.click();	
			validateCustNamePopulatedOrNot("Automation_TestCustomer");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Desired Customer Name is Set Properly");
		}else{
			logger.log(LogStatus.FAIL, "Failed to set Customer Name");
		}
		
	}
	
	//Validate if the proper Customer as selected is displaying on the TextBox
	public static void validateCustNamePopulatedOrNot(String custName) throws InterruptedException {
		
		waitForSpinnerToDisappear();
		Thread.sleep(2000);
		WebElement custName_element=ssfPageFactory.get_ssfTab_CSI_CustomerNameTextBoxLink();
		if (custName_element!=null && !custName_element.isEnabled()) {
			String ui_CustName = custName_element.getAttribute("value"); System.out.println("ui_CustName "+ui_CustName);
			if (ui_CustName.equals(custName)) {
				logger.log(LogStatus.PASS, "Desired Customer Name is Successfully populated on the textbox.");
			} 
		}else{
			logger.log(LogStatus.FAIL, "An error occured while setting the Customer Name");
		}
	}
	
	//Validate Customer AR Number Text Box that is Auto Populated
	@SuppressWarnings("static-access")
	public static void validateCustomerARNumber() throws SQLException, ClassNotFoundException, InterruptedException {
		
		WebElement custArNo_element = ssfPageFactory.get_ssfTab_CSI_CustomerARLink();
		String custArNo_val = custArNo_element.getAttribute("value");
		ssf_DataValMaster.getCSDDBSession();
		String custArNo_DB_val = ssf_DataValMaster.validateCustomerARNumber("Automation_TestCustomer");
		Thread.sleep(2000);
		if (custArNo_DB_val!=null) {
			System.out.println("Values are : -" + custArNo_val + "- " + custArNo_DB_val);
			if (custArNo_val.equals(custArNo_DB_val)) {
				System.out.println("Values are Equal for Customer AR No : " + custArNo_val + " " + custArNo_DB_val);
				logger.log(LogStatus.PASS, "Customer AR Number for the Selected Customer is Mapped Properly!");

			} else {
				System.out.println("Values are Equal for Customer AR No : '" + custArNo_val + "' " + custArNo_DB_val);
				logger.log(LogStatus.FAIL, "Customer AR Number for the Selected Customer is NOT Mapped Properly!");

			} 
		}else{
			logger.log(LogStatus.INFO, "Customer has no AR number mapped to it.");
		}
		
	}
	
	//Validate all the Dropdowns in the Facility are MApped properly
	@SuppressWarnings("static-access")
	public static void validateFacilityDropDownEntries() throws InterruptedException, SQLException {
		
		WebElement facility_element=ssfPageFactory.get_ssfTab_CSI_SetFacilityNameLink();
		waitForSpinnerToDisappear();
		if (facility_element !=null && facility_element.isEnabled()) {
			waitForSpinnerToDisappear();
			facility_element.click();
			waitForSpinnerToDisappear();
			Thread.sleep(5000);
			WebElement exst_facility = ssfPageFactory.get_ssfTab_CSI_SetExistingFacilityNameLink();
			exst_facility.click();
			WebElement facility_name = ssfPageFactory.get_ssfTab_CSI_SetExistingFacilityDropDownLink();
			List<String> facility_Vals =  getAllOptions(facility_name);System.out.println("facility_Vals"+facility_Vals);
			List<String> facility_Vals_db = ssf_DataValMaster.getEligibleFacilityNames("206");System.out.println("facility_Vals_db"+facility_Vals_db);//branch_id
			if(facility_Vals.size()-1 == facility_Vals_db.size())
			{
				logger.log(LogStatus.INFO, "Valid Number of Facilities are displayed under the Dropdown!");
				for (int i = 0; i < facility_Vals_db.size(); i++) {
					if(facility_Vals.get(i+1).equals(facility_Vals_db.get(i))){
						logger.log(LogStatus.PASS, facility_Vals_db.get(i)+" - valid entry is displayed under the DropDown");
					}
					else{
						logger.log(LogStatus.FAIL, facility_Vals_db.get(i)+" - entry is NOT displayed under the DropDown");
					}
					
				}
			}
			logger.log(LogStatus.PASS, "All the Valid Facilities are Displayed under the DropDown");
		}else{
			logger.log(LogStatus.FAIL, "Error in Displaying all the facilities under the Dropdown");

		}
		
		
	}
	
	//==================================================== temp ==================================================
	
	
	
	//Select Existing Customer Facility for the Customer Site Information Section
	public static void selectExistingCusFacilityFromDropDown() throws InterruptedException {
		
		//WebElement facility_element=ssfPageFactory.get_ssfTab_CSI_SetFacilityNameLink();
		waitForSpinnerToDisappear();
		WebElement facility_name = ssfPageFactory.get_ssfTab_CSI_SetExistingFacilityDropDownLink();
		if (facility_name !=null) {
			waitForSpinnerToDisappear();
			selectByVisibleText(facility_name,"Automation_TestFacility");
			WebElement set_facility = ssfPageFactory.get_ssfTab_CSI_SetFacilityLink();
			set_facility.click();
			validateFacilityNamePopulatedOrNot("Automation_TestFacility");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Customer Site Facility is selected Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Customer Site Facility");
		}
		
	}
	
	//Validate if the proper Facility as selected is displaying on the TextBox
	public static void validateFacilityNamePopulatedOrNot(String custName) throws InterruptedException {
		
		waitForSpinnerToDisappear();
		Thread.sleep(2000);
		WebElement custName_element=ssfPageFactory.get_ssfTab_CSI_FacilityNameTextBoxLink();
		if (custName_element!=null && !custName_element.isEnabled()) {
			String ui_CustName = custName_element.getAttribute("value"); System.out.println("ui_CustName '"+ui_CustName+"'");
			if (ui_CustName.equals(custName)) {
				logger.log(LogStatus.PASS, "Desired Facility Name is Successfully populated on the textbox.");
			} else{
				logger.log(LogStatus.FAIL, "An error occured while Validating the Facility Name");
			}
		}else{
			logger.log(LogStatus.FAIL, "An error occured while setting the Facility Name");
		}
	}
	
	//Verify the Customer Site Information AutoPopulated Details
	@SuppressWarnings("static-access")
	public static void verifyCustSiteInfoDetails() throws SQLException, InterruptedException {
		
		/*Thread.sleep(5000);
		WebElement facility_name = ssfPageFactory.get_ssfTab_CSI_SetExistingFacilityDropDownLink();
		String selected_facility_val = getSelectedOptionFromDropDown(facility_name);System.out.println("selected_facility_val "+selected_facility_val);*/
		
		String selected_facility_val = ssfPageFactory.get_ssfTab_CSI_FacilityNameTextBoxLink().getAttribute("value");
		System.out.println("selected_facility_val "+selected_facility_val);
		Thread.sleep(5000);
		
		List<String> facilityAddDetails_DB = ssf_DataValMaster.validateFacilityAddDetails(selected_facility_val); 
		System.out.println("facilityAddDetails_DB "+facilityAddDetails_DB);
		waitForSpinnerToDisappear();
		WebElement address_element=ssfPageFactory.get_ssfTab_CSI_FacilityAddressLink();
		String facility_add_val = address_element.getAttribute("value");
		if(facilityAddDetails_DB.get(3).equals(facility_add_val)){
			logger.log(LogStatus.PASS, "Facility Address : "+facility_add_val+" is autopopulated successfully!");
		}else{
			logger.log(LogStatus.FAIL, "ERROR Encountered while AutoPopulating Facility Address From Backend");
		}
		waitForSpinnerToDisappear();
		WebElement country_element=ssfPageFactory.get_ssfTab_CSI_FaciltiyCountyLink();
		String selected_country_val = getSelectedOptionFromDropDown(country_element);System.out.println("selected_country_val "+selected_country_val);
		if(facilityAddDetails_DB.get(7).equals(selected_country_val)){
			logger.log(LogStatus.PASS, "Facility Country : "+selected_country_val+" is autopopulated successfully!");
		}else{
			logger.log(LogStatus.FAIL, "ERROR Encountered while AutoPopulating Facility Country From Backend");
		}
		waitForSpinnerToDisappear();
		WebElement state_element=ssfPageFactory.get_ssfTab_CSI_facilityStateLink();
		String selected_state_val = getSelectedOptionFromDropDown(state_element);System.out.println("selected_state_val "+selected_state_val);
		if(facilityAddDetails_DB.get(8).equals(selected_state_val)){
			logger.log(LogStatus.PASS, "Facility State : "+selected_state_val+" is autopopulated successfully!");
		}else{
			logger.log(LogStatus.FAIL, "ERROR Encountered while AutoPopulating Facility State From Backend");
		}
		waitForSpinnerToDisappear();
		WebElement city_element=ssfPageFactory.get_ssfTab_CSI_facilityCityLink();
		String selected_city_val = getSelectedOptionFromDropDown(city_element);System.out.println("selected_city_val "+selected_city_val);
		if(facilityAddDetails_DB.get(9).equals(selected_city_val)){
			logger.log(LogStatus.PASS, "Facility City : "+selected_city_val+" is autopopulated successfully!");
		}else{
			logger.log(LogStatus.FAIL, "ERROR Encountered while AutoPopulating Facility City From Backend");
		}
		waitForSpinnerToDisappear();
		WebElement zip_element=ssfPageFactory.get_ssfTab_CSI_FacilityZipCodeLink();
		String selected_zip_val = zip_element.getAttribute("value");System.out.println("selected_zip_val "+selected_zip_val+" facilityAddDetails_DB.get(5) "+facilityAddDetails_DB.get(4));
		if(facilityAddDetails_DB.get(4).equals(selected_zip_val)){
			logger.log(LogStatus.PASS, "Facility ZIP : "+selected_zip_val+" is autopopulated successfully!");
		}else{
			logger.log(LogStatus.FAIL, "ERROR Encountered while AutoPopulating Facility ZIP From Backend");
		}
		waitForSpinnerToDisappear();
		WebElement phone_element=ssfPageFactory.get_ssfTab_CSI_SitePhoneLink();
		String selected_phone_val = phone_element.getAttribute("value");System.out.println("selected_phone_val "+selected_phone_val+" facilityAddDetails_DB.get(7) "+facilityAddDetails_DB.get(6));
		if(facilityAddDetails_DB.get(6).equals(selected_phone_val)){
			logger.log(LogStatus.PASS, "Facility Phone : "+selected_phone_val+" is autopopulated successfully!");
		}else{
			logger.log(LogStatus.FAIL, "ERROR Encountered while AutoPopulating Facility Phone From Backend");
		}
		WebElement timezone_element=ssfPageFactory.get_ssfTab_CSI_CustomerTimeZOneLink();
		String selected_timeZone = getSelectedOptionFromDropDown(timezone_element);
		String db_timeZone = ssf_DataValMaster.getTimeZoneForSelectedFacility();
		if(selected_timeZone.equals(db_timeZone)){
			logger.log(LogStatus.PASS, "Selected TimeZone is : "+selected_timeZone+" and is Successfully Mapped!");
		}
		else{
			logger.log(LogStatus.FAIL, "ERROR occured in Mapping the TimeZone for the Selected Facility");
		}
		WebElement typeofBusiness_element=ssfPageFactory.get_ssfTab_CSI_facilityVerticalLink();
		String selected_typeofBusiness = getSelectedOptionFromDropDown(typeofBusiness_element);
		String db_typeofBusiness = ssf_DataValMaster.getBusinessTypeForSelectedSite();
		if(selected_typeofBusiness.equals(db_typeofBusiness)){
			logger.log(LogStatus.PASS, "Selected Type of Business is : "+selected_typeofBusiness+" and is Successfully Mapped!");
		}
		else{
			logger.log(LogStatus.FAIL, "ERROR occured in Mapping the Type of Business for the Selected Facility");
		}
	}
	
	
	//----- Smart Connected Chiller Dashboard ----- Add L1 User to the SSF Details
	public static void addL1UserToSSFDetails() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement expand_element = ssfPageFactory.get_ssfTab_SCCDC_ExpandLink();
		if (expand_element !=null) {
			expand_element.click();
			waitForSpinnerToDisappear();
			WebElement addUser_Element = ssfPageFactory.get_ssfTab_SCCDC_UserSaveLink();
			addUser_Element.click();
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			WebElement addUser_name_Element = ssfPageFactory.get_ssfTab_SCCDC_UserNameLink();
			addUser_name_Element.sendKeys("L1 User");
			WebElement addUser_Uname_Element = ssfPageFactory.get_ssfTab_SCCDC_UserContactNoLink();
			addUser_Uname_Element.sendKeys("1234567890");
			WebElement addUser_email_Element = ssfPageFactory.get_ssfTab_SCCDC_UserUserEmailLink();
			addUser_email_Element.sendKeys("L1User@jci.com");
			WebElement addUser_save_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsSaveLink();
			addUser_save_Element.click();
			waitForSpinnerToDisappear();
			WebElement addUser_popup_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
			addUser_popup_Element.click();
			validateCFAUserAddition("L1 User");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "L1 User to the SSF Details is added Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update L1 User to the SSF Details");
		}		
	}
	
	//----- Smart Connected Chiller Dashboard ----- Add L2 User to the SSF Details
	public static void addL2UserToSSFDetails() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		Thread.sleep(2000);
		WebElement addUser_Element = ssfPageFactory.get_ssfTab_SCCDC_UserSaveLink();
		if (addUser_Element !=null) {
			addUser_Element.click();
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			WebElement addUser_name_Element = ssfPageFactory.get_ssfTab_SCCDC_UserNameLink();
			addUser_name_Element.sendKeys("L2 User");
			WebElement addUser_Uname_Element = ssfPageFactory.get_ssfTab_SCCDC_UserContactNoLink();
			addUser_Uname_Element.sendKeys("1234567890");
			WebElement addUser_email_Element = ssfPageFactory.get_ssfTab_SCCDC_UserUserEmailLink();
			addUser_email_Element.sendKeys("L2User@jci.com");
			WebElement addUser_save_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsSaveLink();
			addUser_save_Element.click();
			waitForSpinnerToDisappear();
			WebElement addUser_popup_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
			addUser_popup_Element.click();
			validateCFAUserAddition("L2 User");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "L2 User to the SSF Details is added Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update L2 User to the SSF Details");
		}		
	}
	
	//Check whether the CFA User added is reflecting under the Grid
	public static void validateCFAUserAddition(String userName) {
		
		waitForSpinnerToDisappear();
		int ui_addedCFAUsers = driver.findElements(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr")).size() - 2;
		System.out.println("ui_addedCFAUsers "+ui_addedCFAUsers);
		if(ui_addedCFAUsers > 0){
			for(int i = 1; i<= ui_addedCFAUsers; i++){
				int j = 1+i;
				String CFAUserName = driver.findElement(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr:nth-child("+j+") > td:nth-child(1) > label > span")).getText();
				if(CFAUserName.equals(userName)){
					logger.log(LogStatus.PASS, "The CFA User is successfully reflected under the Users Grid! User Name is : "+userName);
				}
			}
				//logger.log(LogStatus.INFO, "The CFA User to be Updated Does not Exist in the Users Grid!");
		}else{
			logger.log(LogStatus.INFO, "The CFA User to be Updated Does not Exist in the Users Grid!");
		}
	}
	
	//----- Smart Connected Chiller Dashboard ----- Add Sample User to the SSF Details -- For Deletion
	public static void addSampleUserToSSFDetails() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement addUser_Element = ssfPageFactory.get_ssfTab_SCCDC_UserSaveLink();
		if (addUser_Element !=null) {
			addUser_Element.click();
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			WebElement addUser_name_Element = ssfPageFactory.get_ssfTab_SCCDC_UserNameLink();
			addUser_name_Element.sendKeys("Sample User");
			WebElement addUser_Uname_Element = ssfPageFactory.get_ssfTab_SCCDC_UserContactNoLink();
			addUser_Uname_Element.sendKeys("1234567890");
			WebElement addUser_email_Element = ssfPageFactory.get_ssfTab_SCCDC_UserUserEmailLink();
			addUser_email_Element.sendKeys("SampleUser@jci.com");
			WebElement addUser_save_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsSaveLink();
			addUser_save_Element.click();
			waitForSpinnerToDisappear();
			WebElement addUser_popup_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
			addUser_popup_Element.click();
			validateCFAUserAddition("Sample User");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Sample User to the SSF Details is added Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update Sample User to the SSF Details");
		}		
	}
	
	//----- Smart Connected Chiller Dashboard ----- Update one  User From the Grid
	public static void updateSampleUserFromSSFDetails() throws InterruptedException{
		
		waitForSpinnerToDisappear();
		int ui_addedCFAUsers = driver.findElements(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr")).size() - 2;
		System.out.println("ui_addedCFAUsers "+ui_addedCFAUsers);
		if(ui_addedCFAUsers > 0){
			for(int i = 1; i<= ui_addedCFAUsers; i++){
				int j = 1+i;
				String CFAUserName = driver.findElement(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr:nth-child("+j+") > td:nth-child(1) > label > span")).getText();
				if(CFAUserName.equals("Sample User")){
					logger.log(LogStatus.INFO, "The CFA User to be Updated exists in the Users Grid!");
					driver.findElement(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr:nth-child("+j+") > td:nth-child(6) > span > i[automation-id='btnEditUser']")).click();
					waitForSpinnerToDisappear();
					waitForSpinnerToDisappear();
					Thread.sleep(2000);
					WebElement addUser_name_Element = ssfPageFactory.get_ssfTab_SCCDC_UserNameLink();
					addUser_name_Element.sendKeys(" Update");
					WebElement delUser_popup_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsUpdateLink();
					delUser_popup_Element.click();
					waitForSpinnerToDisappear();
					WebElement delUser_popupConfirm_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
					delUser_popupConfirm_Element.click();
					logger.log(LogStatus.PASS, "The CFA User is successfully Updated from the Users Grid!");
				}else{
					logger.log(LogStatus.INFO, "The CFA User to be Updated Does not Exist in the Users Grid!");
				}
			}
		}else{
			logger.log(LogStatus.INFO, "The CFA User to be Updated Does not Exist in the Users Grid!");
		}
	}
	
	
	//----- Smart Connected Chiller Dashboard ----- Delete one  User From the Grid
	public static void deleteSampleUserFromSSFDetails() {
		
		waitForSpinnerToDisappear();
		int ui_addedCFAUsers = driver.findElements(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr")).size() - 2;
		if(ui_addedCFAUsers > 0){
			for(int i = 1; i<= ui_addedCFAUsers; i++){
				int j = 1+i;
				String CFAUserName = driver.findElement(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr:nth-child("+j+") > td:nth-child(1) > label > span")).getText();
				if(CFAUserName.contains("Sample User")){
					logger.log(LogStatus.INFO, "The CFA User to be deleted exists in the Users Grid!");
					driver.findElement(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr:nth-child("+j+") > td:nth-child(6) > i[automation-id='btnDeleteUser']")).click();
					waitForSpinnerToDisappear();
					WebElement delUser_popup_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
					delUser_popup_Element.click();
					waitForSpinnerToDisappear();
					WebElement delUser_popupConfirm_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
					delUser_popupConfirm_Element.click();
					logger.log(LogStatus.PASS, "The CFA User is successfully deleted from the Users Grid!");
				}else{
					logger.log(LogStatus.INFO, "The CFA User to be deleted Does not Exist in the Users Grid!");
				}
			}
		}else{
			logger.log(LogStatus.INFO, "The CFA User to be deleted Does not Exist in the Users Grid!");
		}
	}
	
	
	// --------------------------- CFA Customers ----------------------- check for already existing Users attached to the Facility
	@SuppressWarnings("static-access")
	public static void checkMappedCFAUsers() throws SQLException, ClassNotFoundException, InterruptedException {
		
		ssf_DataValMaster.getCSDDBSession();
		List<String> mappedCFAUsers_db = ssf_DataValMaster.checkIfFacilityHasExistingCFAUsers();
		System.out.println("mappedCFAUsers_db "+mappedCFAUsers_db);
		if (mappedCFAUsers_db.size() > 0) {
			System.out.println("Facility has Existing Mapped CFA Users");
			logger.log(LogStatus.INFO, "Facility has Existing Mapped CFA Users");	
			Thread.sleep(2000);
			validateMappedCFAUsers(mappedCFAUsers_db);
		}else if (mappedCFAUsers_db.size() == 0){
			System.out.println("Facility has NO Existing Mapped CFA Users");
			logger.log(LogStatus.INFO, "Facility has NO Existing Mapped CFA Users!");	
			addL1UserToSSFDetails();
			addL2UserToSSFDetails();
			addSampleUserToSSFDetails();
			updateSampleUserFromSSFDetails();
			deleteSampleUserFromSSFDetails();
		}
	}
	
	public static void validateMappedCFAUsers(List<String> db_values) 
			throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement expand_element = ssfPageFactory.get_ssfTab_SCCDC_ExpandLink();
		if (expand_element!=null && expand_element.isEnabled()) {
			Thread.sleep(3000);
			expand_element.click();
			int ui_existingCFAUsers = driver
					.findElements(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr"))
					.size() - 2;
			if (ui_existingCFAUsers > 0) {
				logger.log(LogStatus.INFO, "Existing CFA Users are Reflected on the UI!");
				System.out.println("db_values.size() " + db_values.size());
				if (ui_existingCFAUsers == db_values.size()) {
					for (int i = 1; i <= ui_existingCFAUsers; i++) {
						int j = i+1;
						String CFAUserName = driver.findElement(
								By.cssSelector("table[automation-id='tblUserTable'] > tbody > tr:nth-child("+j+") > td:nth-child(1) > label > span"))
								.getText();
						System.out.println("CFAUserName "+CFAUserName+" and db_values.get(i - 1) "+db_values.get(i - 1));
						if (CFAUserName.equals(db_values.get(i - 1)))
							logger.log(LogStatus.INFO,
									"Existing CFA USER :" + db_values.get(i-1) + " is Reflected in the UI");
					}
					logger.log(LogStatus.PASS, "Existing CFA User Mapping is Validated!");
				}
			} else {
				logger.log(LogStatus.INFO, "NO Existing CFA Users are Reflected on the UI!");
			} 
		}
		
	}
	
	//----- Internet Connectivity ----- CheckConnection Type -- Cell Modem
	public static void selectConnectionType_CellModem() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement expand_element = ssfPageFactory.get_ssfTab_IC_ExpandLink();
		if (expand_element !=null) {
			expand_element.click();
			waitForSpinnerToDisappear();
			WebElement cellModem_element = ssfPageFactory.get_ssfTab_IC_CellModemLink();
			if(cellModem_element.isSelected()){
				logger.log(LogStatus.INFO, "Cell Modem Option is Already Selected!");
				WebElement CM_provider_element = ssfPageFactory.get_ssfTab_IC_ProviderLink();
				selectByVisibleText(CM_provider_element, "Verizon");
			}else{
				logger.log(LogStatus.INFO, "Selecting Cell Modem Option");
				cellModem_element.click();
				WebElement CM_provider_element = ssfPageFactory.get_ssfTab_IC_ProviderLink();
				selectByVisibleText(CM_provider_element, "Verizon");
			}
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Cell Modem Option is selected Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Cell Modem Option");
		}
	}
	
	
	//----- Internet Connectivity ----- CheckConnection Type -- Cell Modem
	public static void selectConnectionType_CustomerNetwork() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement expand_element = ssfPageFactory.get_ssfTab_IC_ExpandLink();
		if(expand_element != null){
			expand_element.click();
			waitForSpinnerToDisappear();
			WebElement custNW_element = ssfPageFactory.get_ssfTab_IC_CustomerNetworkLink();
			custNW_element.click();
			//To check if N/A is Displayed or not 
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Customer Network Option is selected Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Customer Network Option");
		}
	}
	
	//----- Equipment ----- Add Equipment -- EXPAND
	public static void addAssetDetails_expand() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement expand_element = ssfPageFactory.get_ssfTab_Equip_ExpandLink();
		if(expand_element != null){
			expand_element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Equipment Section is expanded Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to expanded Equipment Section");
		}
	}
	
	//----- Equipment ----- Add Equipment -- Select Chiller and Add Asset
	public static void addAssetDetails_ChillerAsset(int noOfAssets) 
			throws InterruptedException, SQLException, ClassNotFoundException {
		
		for (int i = 1; i <= noOfAssets; i++) {
			waitForSpinnerToDisappear();
			WebElement assetType_element = ssfPageFactory.get_ssfTab_Equip_EquipmentTypeLink();
			if (assetType_element != null) {
				selectByVisibleText(assetType_element, "SET_CHILLER");
				WebElement addAsset_element = ssfPageFactory.get_ssfTab_Equip_AddChillerLink();
				addAsset_element.click();
				waitForSpinnerToDisappear();
				addAssetDetails_ChillerAsset_setDetails("TestAssetName"+i);
				waitForSpinnerToDisappear();
				WebElement assetSAVE_element = ssfPageFactory.get_ssfTab_Equip_SaveAssetLink();
				assetSAVE_element.click();
				waitForSpinnerToDisappear();
				WebElement assetPopUp_element = ssfPageFactory.get_ssfTab_Equip_AssetPopUpLink();
				assetPopUp_element.click();
				waitForSpinnerToDisappear();
				verifyNewAssetIsAdded(i);
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.PASS, "A new Chiller Equipment is now Selected!");
			} else {
				logger.log(LogStatus.FAIL, "Failed to select a new Chiller Equipment");
			} 
		}
	}
	
	//----- Equipment ----- Add Equipment -- Select Chiller and Add Asset
	/*public static void addAssetDetails_ChillerAsset_2() throws InterruptedException, SQLException, ClassNotFoundException {
		
		waitForSpinnerToDisappear();
		WebElement assetType_element = ssfPageFactory.get_ssfTab_Equip_EquipmentTypeLink();
		if(assetType_element != null){
			selectByVisibleText(assetType_element, "SET_CHILLER");
			WebElement addAsset_element = ssfPageFactory.get_ssfTab_Equip_AddChillerLink();
			addAsset_element.click();
			waitForSpinnerToDisappear();
			addAssetDetails_ChillerAsset_setDetails("TestAssetName2");
			waitForSpinnerToDisappear();
			WebElement assetSAVE_element = ssfPageFactory.get_ssfTab_Equip_SaveAssetLink();
			assetSAVE_element.click();
			waitForSpinnerToDisappear();
			WebElement assetPopUp_element = ssfPageFactory.get_ssfTab_Equip_AssetPopUpLink();
			assetPopUp_element.click();
			waitForSpinnerToDisappear();
			verifyNewAssetIsAdded(2);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "A new Chiller Equipment is now Selected!");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select a new Chiller Equipment");
		}
	}*/
	
	
	//----- Equipment ----- Add Equipment -- Select Chiller and Add Asset -- SET ASSET DETAILS
	/*@SuppressWarnings("static-access")
	public static void addAssetDetails_ChillerAsset_setDetails() throws InterruptedException, SQLException, ClassNotFoundException {
		
		waitForSpinnerToDisappear();
		WebElement assetName_element = ssfPageFactory.get_ssfTab_Equip_AssetNameink();
		if(assetName_element != null){
			waitForSpinnerToDisappear();
			ssf_DataValMaster.getCSDDBSession();
			assetName_element.sendKeys("TestAssetName");//------------------ to make Dynamic
			waitForSpinnerToDisappear();
			WebElement assetMake_element = ssfPageFactory.get_ssfTab_Equip_AssetMakeLink();
			selectByVisibleText(assetMake_element, "York");//------------------ to make Dynamic
			waitForSpinnerToDisappear();
			WebElement assetModelGroup_element = ssfPageFactory.get_ssfTab_Equip_ModelGroupLink();
			selectByVisibleText(assetModelGroup_element, "YB");//------------------ to make Dynamic
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			WebElement assetControlPanel_element = ssfPageFactory.get_ssfTab_Equip_ControlPanelLink();
			selectByVisibleText(assetControlPanel_element, "Non-Optiview");//------------------ to make Dynamic
			Thread.sleep(3000);
			WebElement assetModel_element = ssfPageFactory.get_ssfTab_Equip_ModelLink();
			List<String> modelList_UI = new ArrayList<String>();
			if(modelList_UI.size() > 1) modelList_UI.clear();
			modelList_UI = getAllOptions(assetModel_element);
			//ssf_DataValMaster.getCSDDBSession();
			List<String> modelList_DB = ssf_DataValMaster.validateChillerModelDropDownEntries("Non-Optiview", "YB");
			if (modelList_UI.size() - 1 == modelList_DB.size()) {
				logger.log(LogStatus.INFO, "All the Valid Options Are Mapped to UI Properly!");
				for (int i = 0; i < modelList_DB.size(); i++) {
					if (modelList_UI.get(i+1).equals(modelList_DB.get(i))) {
						System.out.println(modelList_UI.get(i+1)+" is a Valid Chiller Model for the Selected Combination and is Mapped Properly to UI!");
						logger.log(LogStatus.PASS, modelList_UI.get(i+1)+" is a Valid Chiller Model for the Selected Combination and is Mapped Properly to UI!");
						
					}else{
						logger.log(LogStatus.FAIL, modelList_UI.get(i+1)+" is an INVALID Valid Chiller Model for the Selected Combination!");
						
					}
				}
				selectByVisibleText(assetModel_element, "YB-All Types");
				logger.log(LogStatus.INFO, "Chiller Model is Selected for the Asset Successfully");
			}else{
				logger.log(LogStatus.FAIL, "All the Valid Options Are NOT Mapped to UI Properly!");
			}
			waitForSpinnerToDisappear();
			WebElement assetModelNo_element = ssfPageFactory.get_ssfTab_Equip_ModelNoLink();
			assetModelNo_element.sendKeys("TestModel1234");
			WebElement assetSerialNo_element = ssfPageFactory.get_ssfTab_Equip_SerialLink();
			assetSerialNo_element.sendKeys("TestSerial1234");
			WebElement assetAssetNo_element = ssfPageFactory.get_ssfTab_Equip_AssetNoLink();
			assetAssetNo_element.sendKeys("TestAsset1234");
			WebElement assetMACAdd_element = ssfPageFactory.get_ssfTab_Equip_MacAddressLink();
			assetMACAdd_element.sendKeys("TestMACAdd1234");
			waitForSpinnerToDisappear();
			WebElement assetMendatoryFields = ssfPageFactory.get_ssfTab_Equip_AssetMendatoryLink();
			if(assetMendatoryFields!=null){
				logger.log(LogStatus.INFO, "All the Mendatory Fields are not Filled. Checking for Missed Entries.");
				selectByVisibleText(assetModel_element, "YB-All Types");
				logger.log(LogStatus.INFO, "Chiller Model is Selected for the Asset Successfully");
			}else {
				logger.log(LogStatus.INFO, "All the Mendatory Fields are Filled Properly");
			}
			
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "All the Required Fields are Updated for the New Chiller Equipment");
		}else{
			logger.log(LogStatus.FAIL, "Something Went Wrong while updating the Details for the Chiller!");
		}
	}*/
	
	//----- Equipment ----- Add Equipment -- Select Chiller and Add Asset -- SET ASSET DETAILS -- 2nd Set
	@SuppressWarnings("static-access")
	public static void addAssetDetails_ChillerAsset_setDetails(String assetName) throws InterruptedException, SQLException, ClassNotFoundException {
		
		waitForSpinnerToDisappear();
		WebElement assetName_element = ssfPageFactory.get_ssfTab_Equip_AssetNameink();
		if(assetName_element != null){
			waitForSpinnerToDisappear();
			ssf_DataValMaster.getCSDDBSession();
			assetName_element.sendKeys(assetName);//------------------ to make Dynamic
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			WebElement assetMake_element = ssfPageFactory.get_ssfTab_Equip_AssetMakeLink();
			selectByVisibleText(assetMake_element, "York");//------------------ to make Dynamic
			waitForSpinnerToDisappear();
			WebElement assetModelGroup_element = ssfPageFactory.get_ssfTab_Equip_ModelGroupLink();
			selectByVisibleText(assetModelGroup_element, "YB");//------------------ to make Dynamic
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			WebElement assetControlPanel_element = ssfPageFactory.get_ssfTab_Equip_ControlPanelLink();
			selectByVisibleText(assetControlPanel_element, "Non-Optiview");//------------------ to make Dynamic
			Thread.sleep(3000);
			WebElement assetModel_element = ssfPageFactory.get_ssfTab_Equip_ModelLink();
			List<String> modelList_UI = new ArrayList<String>();
			if(modelList_UI.size() >= 1) modelList_UI.clear();
			modelList_UI = getAllOptions(assetModel_element);
			//ssf_DataValMaster.getCSDDBSession();
			List<String> modelList_DB = ssf_DataValMaster.validateChillerModelDropDownEntries("Non-Optiview", "YB");
			if (modelList_UI.size() - 1 == modelList_DB.size()) {
				logger.log(LogStatus.INFO, "All the Valid Options Are Mapped to UI Properly!");
				for (int i = 0; i < modelList_DB.size(); i++) {
					if (modelList_UI.get(i+1).equals(modelList_DB.get(i))) {
						System.out.println(modelList_UI.get(i+1)+" is a Valid Chiller Model for the Selected Combination and is Mapped Properly to UI!");
						logger.log(LogStatus.PASS, modelList_UI.get(i+1)+" is a Valid Chiller Model for the Selected Combination and is Mapped Properly to UI!");
						
					}else{
						logger.log(LogStatus.FAIL, modelList_UI.get(i+1)+" is an INVALID Valid Chiller Model for the Selected Combination!");
						
					}
				}
				Thread.sleep(2000);
				selectByVisibleText(assetModel_element, "YB-All Types");
				logger.log(LogStatus.INFO, "Chiller Model is Selected for the Asset Successfully");
			}else{
				logger.log(LogStatus.FAIL, "All the Valid Options Are NOT Mapped to UI Properly!");
			}
			waitForSpinnerToDisappear();
			WebElement assetModelNo_element = ssfPageFactory.get_ssfTab_Equip_ModelNoLink();
			assetModelNo_element.sendKeys("TestModel1234");
			WebElement assetSerialNo_element = ssfPageFactory.get_ssfTab_Equip_SerialLink();
			assetSerialNo_element.sendKeys("TestSerial1234");
			WebElement assetAssetNo_element = ssfPageFactory.get_ssfTab_Equip_AssetNoLink();
			assetAssetNo_element.sendKeys("TestAsset1234");
			WebElement assetMACAdd_element = ssfPageFactory.get_ssfTab_Equip_MacAddressLink();
			assetMACAdd_element.sendKeys("TestMACAdd1234");
			waitForSpinnerToDisappear();
			WebElement assetMendatoryFields = ssfPageFactory.get_ssfTab_Equip_AssetMendatoryLink();
			if(assetMendatoryFields!=null){
				logger.log(LogStatus.INFO, "All the Mendatory Fields are not Filled. Checking for Missed Entries.");
				selectByVisibleText(assetModel_element, "YB-All Types");
				logger.log(LogStatus.INFO, "Chiller Model is Selected for the Asset Successfully");
			}else {
				logger.log(LogStatus.INFO, "All the Mendatory Fields are Filled Properly");
			}
			
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "All the Required Fields are Updated for the New Chiller Equipment");
		}else{
			logger.log(LogStatus.FAIL, "Something Went Wrong while updating the Details for the Chiller!");
		}
	}
	
	//Verify if the added chiller is displayed under the Grid view
	public static void verifyNewAssetIsAdded(int rowNo) {
		
		waitForSpinnerToDisappear();
		WebElement ssfAssetTable_element = ssfPageFactory.get_ssfTab_Equipment_AssetTableLink();
		if(ssfAssetTable_element != null){
			List<WebElement> table_element = driver.findElements(By.cssSelector("table[automation-id='tblAssetTable'] > tbody > tr"));
			int temp_var = table_element.size();
			if(temp_var > 2){
				for (int i = 1; i <= rowNo; i++) {
					int j = i+1;
					logger.log(LogStatus.INFO, "Asset Added Details are added under the Table Grid");
					WebElement assetName_element = driver.findElement(By.cssSelector(
							"table[automation-id='tblAssetTable'] > tbody > tr:nth-child("+j+") > td > label > span"));
					if (assetName_element.getText().equals("TestAssetName1")) {
						logger.log(LogStatus.INFO, "Asset Name : " + assetName_element.getText());
						logger.log(LogStatus.PASS,
								"Proper Asset Details are updated under the Table Grid. Asset Added Details are reflecting Properly under the Asset Details Table");
					}else if (assetName_element.getText().equals("TestAssetName2")) {
						logger.log(LogStatus.INFO, "Asset Name : " + assetName_element.getText());
						logger.log(LogStatus.PASS,
								"Proper Asset Details are updated under the Table Grid. Asset Added Details are reflecting Properly under the Asset Details Table");
					} else {
						logger.log(LogStatus.FAIL, "Error encountered while adding Asset Details");
					} 
				}
			}else{
				logger.log(LogStatus.FAIL, "Error encountered while adding Asset Details. Table Grid is not updated with the Added Entry.");
			}
			//logger.log(LogStatus.PASS, "Asset Added Details are reflecting Properly under the Asset Details Table");
		}else{
			logger.log(LogStatus.FAIL, "Error Encountered in Adding Asset Details to the SSF Form!");
		}
	}
	
	//Verify if the added chiller can be edited under the Grid view
	public static void verifyNewAssetEdit() throws InterruptedException{
		
		waitForSpinnerToDisappear();
		driver.findElement(By.cssSelector("table[automation-id='tblAssetTable'] > tbody > tr:nth-child(2) > td:nth-child(7) > i[automation-id='btnEditAsset']")).click();
		Thread.sleep(2000);
		WebElement assetName_element = ssfPageFactory.get_ssfTab_Equip_AssetNameink();
		assetName_element.sendKeys(" Update");
		waitForSpinnerToDisappear();
		WebElement assetUpdate_element = ssfPageFactory.get_ssfTab_Equip_AssetUpdateLink();
		assetUpdate_element.click();
		waitForSpinnerToDisappear();
		WebElement assetPopUp_element = ssfPageFactory.get_ssfTab_Equip_AssetPopUpLink();
		assetPopUp_element.click();
		logger.log(LogStatus.PASS, "An Asset Detail is Edited Successfully");
	}
	
	//Verify if the added chiller can be deleted under the Grid view
	public static void verifyNewAssetDelete() throws InterruptedException{
		
		waitForSpinnerToDisappear();
		driver.findElement(By.cssSelector("table[automation-id='tblAssetTable'] > tbody > tr:nth-child(3) > td:nth-child(7) > i[automation-id='btnDeleteAsset']")).click();
		waitForSpinnerToDisappear();
		WebElement assetDelete_element = ssfPageFactory.get_ssfTab_Equip_AssetPopUpLink();
		assetDelete_element.click();
		waitForSpinnerToDisappear();
		WebElement assetDelPopUp_element = ssfPageFactory.get_ssfTab_Equip_AssetPopUpLink();
		assetDelPopUp_element.click();
		logger.log(LogStatus.PASS, "An Asset Detail is Deleted Successfully");
	}
	
	
	//Add notes to the SSF Form Details
	public static void ssfFormAddNotes() throws InterruptedException, SQLException, ClassNotFoundException {
		
		waitForSpinnerToDisappear();
		WebElement ssfNotes_element = ssfPageFactory.get_ssfTab_Bottom_TextNotesLink();
		if(ssfNotes_element != null){
			ssfNotes_element.sendKeys("Updated by the Automation Script!");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "A Note Snippet is added to the SSF Form");
		}else{
			logger.log(LogStatus.FAIL, "Error Encountered in Adding a Note to the SSF Form");
		}
	}
	
	//Check if all the Mendatory fields are updated
	public static void checkMendatoryFields() {
		
		waitForSpinnerToDisappear();
		WebElement ssfmend_element = ssfPageFactory.get_ssfTab_MendatoryFieldsLink();
		if(ssfmend_element == null){
			
			logger.log(LogStatus.PASS, "All the Mendatory Fields are updated");
		}else{
			logger.log(LogStatus.FAIL, "Please Fill all the mendatory Fields");
		}
		
	}
	
	//SAVE the updated SSF Form
	public static void ssfFormSAVE() throws InterruptedException, SQLException, ClassNotFoundException {
		
		waitForSpinnerToDisappear();
		WebElement ssfSAVE_element = ssfPageFactory.get_ssfTab_Bottom_SaveBtnLink();
		Thread.sleep(2000);
		if(ssfSAVE_element != null && ssfSAVE_element.isEnabled()){
			ssfSAVE_element.click();
			System.out.println("Save button clicked!");
			waitForSpinnerToDisappear();
			WebElement ssfSAVE_PopUP_element = ssfPageFactory.get_ssfTab_SaveConfirmLink();
			ssfSAVE_PopUP_element.click();
			System.out.println("Confirm Save button clicked!");
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			WebElement ssfSAVE_confirm_element = ssfPageFactory.get_ssfTab_SaveConfirmLink();
			ssfSAVE_confirm_element.click();
			System.out.println("Confirm OK Save button clicked!");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "SSF Form is SAVED Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Error Encountered while saving the SSF Form");
		}
	}

}
