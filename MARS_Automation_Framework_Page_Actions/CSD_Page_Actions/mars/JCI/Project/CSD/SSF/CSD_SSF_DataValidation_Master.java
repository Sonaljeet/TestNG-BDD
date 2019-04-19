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

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_Create_SSF_Page_Factory;

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_DataValidation_Master {
	
	//private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_SSF_Create_SSF_Page_Factory ssfPageFactory = null;
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public static String cust_ARNo,customer_id,branch_id,isSSFcustomer,isCSDcustomer,countryName,stateName,cityName,timeZoneID,facilityTimeZone,ssfCustID,businessType,businessTypeVal,CFAUser_projectID = null;
	public static List<String> valid_CustFacilityNames = new ArrayList<String>();
	public static List<String> facilityAddDetails = new ArrayList<String>();
	public static List<String> chillerModelsList = new ArrayList<String>();
	public static List<String> mappedCFAUsersList = new ArrayList<String>();
	
	public static String UserID,RoleID,IsAdmin,cityID,address,country,state_prov,city,zip,contactno_office = null;
	public static List<String> admin_branches = new ArrayList<String>();
	public static List<String> branch_names = new ArrayList<String>();
	public static List<String> non_admin_branches = new ArrayList<String>();
	
	public CSD_SSF_DataValidation_Master(ExtentTest logger) {
		this.logger = logger;
	}
	
	
	public static void getCSDDBSession() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Establishing Connection to CSDDB !!");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
		
		
	}

	
	public static String validateCustomerARNumber(String selected_customer) throws SQLException {
		
		Statement statement = conn.createStatement();
		String queryString = "with cte as(select Customer_Id,Customer_Name,null as IsExists,Customer_Code,ContactNumber,EmailAddress,Customer_Id as CustId from tblCustomer where Customer_Id not in(select customer_Id from ssf_tblCustomer where customer_Id is not null)  union  select SsfCustomerID as Customer_Id,Customer_Name,case when isnull(Customer_ID,0)=0 then 1 else 1 end as IsExists, Customer_Code ,ContactNumber,EmailAddress ,Customer_Id as CustId from ssf_tblCustomer ) select row_number()over(order by Customer_Id) as Id, Customer_Id,Customer_Name,IsExists as IsSsfCustomer,Customer_Code ,ContactNumber,EmailAddress,CustId  from cte where customer_name = '"+selected_customer+"'";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!");
	    logger.log(LogStatus.INFO, "Query to get the Customer AR Number for the Selected Customer is Executed !");
	    
	    while (rs.next()) {
	    	
	    	cust_ARNo = rs.getString(5);
	    	ssfCustID = rs.getString(2);
	    	isSSFcustomer = rs.getString(4);
	    	isCSDcustomer = rs.getString(8);
	    	customer_id = rs.getString(2);
	    }
	    System.out.println("Customer AR Number for the Selected Customer is : "+cust_ARNo);
	    logger.log(LogStatus.INFO, "Customer AR Number for the Selected Customer is : "+cust_ARNo);
	    
	    if (cust_ARNo == null) {
			
	    	return cust_ARNo="";
		}
	    else{
	    	return cust_ARNo;
	    }
	}
	
	public static List<String> getEligibleFacilityNames(String selected_branch_id) throws SQLException {
		
		branch_id = selected_branch_id;
		Statement statement = conn.createStatement();
		System.out.println("Customer id for the Selected Customer is : "+customer_id+" isSSFcustomer "+isSSFcustomer+" isCSDcustomer "+isCSDcustomer);
		if (isSSFcustomer != null && isCSDcustomer == null) {
			System.out.println("Only SSF Customer");
			String queryString = "with cte as(select ssfProjectId as ProjectId,ProjectName,Address1 as Address,ZipCode,TimeZoneId,ContactNumber,Country,State,City,CustomerTypeId,case when isnull(ProjectId,0)=0 then 1 else 1 end as IsSsfFacility from ssf_tblmstproject  where BranchId='"+branch_id+"' and SsfCustomerID='"+customer_id+"' ) select row_number()over(order by ProjectId) as Id, *  from cte  order by projectname";
			ResultSet rs = statement.executeQuery(queryString);
			System.out.println("Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the New Customer(SSF Table)!");
			logger.log(LogStatus.INFO,
					"Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the New Customer(SSF Table)!");
			
			while (rs.next()) {
		    	
				CFAUser_projectID = rs.getString(2);
				countryName = rs.getString(8);
				stateName = rs.getString(9);
				cityName = rs.getString(10);
				valid_CustFacilityNames.add(rs.getString(3));
		    }
			System.out.println("valid_CustFacilityNames "+valid_CustFacilityNames);
			logger.log(LogStatus.INFO, "Valid Customer Facility Names are Retrieved -- "+valid_CustFacilityNames);
			
			return valid_CustFacilityNames;
			
		}else if(isSSFcustomer == null && isCSDcustomer != null){
			System.out.println("Only CSD Customer");
			String queryString = "with cte as(select  P.ProjectId,P.ProjectName,P.Address1 as Address,P.ZipCode,P.TimeZoneId,P.ContactNumber,V.CountryName as Country,S.Name as State,C.Name as City,P.CustomerTypeId,null as IsSsfFacility from tblmstproject P INNER JOIN View_Branch V on P.BranchId=V.BranchId left join ssf_tblMstState S on S.id=P.StateId left join ssf_tblMstcity C on C.id=P.CityId where P.ProjectId not in(select ProjectId from ssf_tblmstproject where ProjectId is not null)  and P.branchid='"+branch_id+"' and customer_id='"+customer_id+"') select row_number()over(order by ProjectId) as Id, *  from cte  order by projectname";
			ResultSet rs = statement.executeQuery(queryString);
			System.out.println("Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the Existing Customer(CSD Table)!");
			logger.log(LogStatus.INFO,
					"Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the Existing Customer(CSD Table)!");
			while (rs.next()) {
				
				CFAUser_projectID = rs.getString(2);
				countryName = rs.getString(8);
				stateName = rs.getString(9);
				cityName = rs.getString(10);
				valid_CustFacilityNames.add(rs.getString(3));
		    }
			System.out.println("valid_CustFacilityNames "+valid_CustFacilityNames);
			logger.log(LogStatus.INFO, "Valid Customer Facility Names are Retrieved");
			return valid_CustFacilityNames;
			
		}else if(isSSFcustomer != null && isCSDcustomer != null){
			System.out.println("Both SSF and CSD Customer");
			String queryString = "with cte as(select ssfProjectId as ProjectId,ProjectName,Address1 as Address,ZipCode,TimeZoneId,ContactNumber,Country,State,City,CustomerTypeId, case when isnull(ProjectId,0)=0 then 1 else 1 end as IsSsfFacility from ssf_tblmstproject  where BranchId='"+branch_id+"' and SsfCustomerID='"+customer_id+"' Union select  P.ProjectId,P.ProjectName,P.Address1 as Address,P.ZipCode,P.TimeZoneId,P.ContactNumber,V.CountryName as Country,S.Name as State,C.Name as City,P.CustomerTypeId,null as IsSsfFacility from tblmstproject P INNER JOIN View_Branch V on P.BranchId=V.BranchId left join ssf_tblMstState S on S.id=P.StateId left join ssf_tblMstcity C on C.id=P.CityId where P.ProjectId not in(select ProjectId from ssf_tblmstproject where ProjectId is not null) and P.branchid='"+branch_id+"' and customer_id='"+customer_id+"' ) select row_number()over(order by ProjectId) as Id, *  from cte order by projectname";
			ResultSet rs = statement.executeQuery(queryString);
			System.out.println("Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the New Customer(SSF Table Union CSD Table)!");
			logger.log(LogStatus.INFO,
					"Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the New Customer(SSF Table Union CSD Table)!");
			
			while (rs.next()) {
		    	
				CFAUser_projectID = rs.getString(2);
				countryName = rs.getString(8);
				stateName = rs.getString(9);
				cityName = rs.getString(10);
				valid_CustFacilityNames.add(rs.getString(3));
		    }
			System.out.println("valid_CustFacilityNames "+valid_CustFacilityNames);
			logger.log(LogStatus.INFO, "Valid Customer Facility Names are Retrieved -- "+valid_CustFacilityNames);
			
			return valid_CustFacilityNames;
			
			
		}else{
			System.err.println("Somehting Horribly went Wrong while Selecting the Eligible Facility for the Branch and Customer Site Combination!");
			logger.log(LogStatus.FATAL,
					"Somehting Horribly went Wrong while Selecting the Eligible Facility for the Branch and Customer Site Combination!");
			return valid_CustFacilityNames;
			
		}
		
	}
	
	
	public static List<String> validateFacilityAddDetails(String selected_test_facility) throws SQLException {
		
		String var = null;
		Statement statement = conn.createStatement();
		System.out.println("Customer id for the Selected Customer is : "+customer_id+" branch_id "+branch_id+" isSSFcustomer "+isSSFcustomer+" isCSDcustomer "+isCSDcustomer);
		if (isSSFcustomer != null && isCSDcustomer == null) {
			String queryString = "with cte as(select ssfProjectId as ProjectId,ProjectName,Address1 as Address,ZipCode,TimeZoneId,ContactNumber,Country,State,City,CustomerTypeId,case when isnull(ProjectId,0)=0 then 1 else 1 end as IsSsfFacility from ssf_tblmstproject  where BranchId='"+branch_id+"' and SsfCustomerID='"+customer_id+"' ) select row_number()over(order by ProjectId) as Id, *  from cte  where projectname = '"+selected_test_facility+"'";
			ResultSet rs = statement.executeQuery(queryString);
			ResultSetMetaData metadata = rs.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			System.out.println("Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the New Customer(SSF Table)!");
			logger.log(LogStatus.INFO,
					"Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the New Customer(SSF Table)!");
			
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					
					timeZoneID = rs.getString(6);
					businessType = rs.getString(11);
					var = rs.getString(i);
					if(var == null){
						var =  "";
					}
					facilityAddDetails.add(var);
				}
				
		    }
			System.out.println("valid_CustFacilityNames "+facilityAddDetails);
			logger.log(LogStatus.INFO, "Valid Customer Facility Names are Retrieved");
			
			return facilityAddDetails;
			
		}else if(isSSFcustomer == null && isCSDcustomer != null){
			String queryString = "with cte as(select  P.ProjectId,P.ProjectName,P.Address1 as Address,P.ZipCode,P.TimeZoneId,P.ContactNumber,V.CountryName as Country,S.Name as State,C.Name as City,P.CustomerTypeId,null as IsSsfFacility from tblmstproject P INNER JOIN View_Branch V on P.BranchId=V.BranchId left join ssf_tblMstState S on S.id=P.StateId left join ssf_tblMstcity C on C.id=P.CityId where P.ProjectId not in(select ProjectId from ssf_tblmstproject where ProjectId is not null)  and P.branchid='"+branch_id+"' and customer_id='"+customer_id+"') select row_number()over(order by ProjectId) as Id, *  from cte  order by projectname";
			ResultSet rs = statement.executeQuery(queryString);
			ResultSetMetaData metadata = rs.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			System.out.println("Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the Existing Customer(CSD Table)!");
			logger.log(LogStatus.INFO,
					"Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the Existing Customer(CSD Table)!");
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					
					timeZoneID = rs.getString(6);
					businessType = rs.getString(11);
					var = rs.getString(i);
					if(var == null){
						var =  "";
					}
					facilityAddDetails.add(var);
				}
				
		    }
			System.out.println("valid_CustFacilityNames "+facilityAddDetails);
			logger.log(LogStatus.INFO, "Valid Customer Facility Names are Retrieved");
			return facilityAddDetails;
			
		}else if(isSSFcustomer != null && isCSDcustomer != null){

			String queryString = " with cte as(select ssfProjectId as ProjectId,ProjectName,Address1 as Address,ZipCode,TimeZoneId,ContactNumber,Country,State,City,CustomerTypeId, case when isnull(ProjectId,0)=0 then 1 else 1 end as IsSsfFacility from ssf_tblmstproject  where BranchId='"+branch_id+"' and SsfCustomerID='"+customer_id+"' Union select  P.ProjectId,P.ProjectName,P.Address1 as Address,P.ZipCode,P.TimeZoneId,P.ContactNumber,V.CountryName as Country,S.Name as State,C.Name as City,P.CustomerTypeId,null as IsSsfFacility from tblmstproject P INNER JOIN View_Branch V on P.BranchId=V.BranchId left join ssf_tblMstState S on S.id=P.StateId left join ssf_tblMstcity C on C.id=P.CityId where P.ProjectId not in(select ProjectId from ssf_tblmstproject where ProjectId is not null) and P.branchid='"+branch_id+"' and customer_id='"+customer_id+"' ) select row_number()over(order by ProjectId) as Id, *  from cte order by projectname";
			ResultSet rs = statement.executeQuery(queryString);
			ResultSetMetaData metadata = rs.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			System.out.println("Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the Existing Customer(SSF and CSD Table)!");
			logger.log(LogStatus.INFO,
					"Query to get the Eligible Facility  for the Selected Customer on the specified Branch is Executed for the Existing Customer(SSF and CSD Table)!");
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					
					timeZoneID = rs.getString(6);
					businessType = rs.getString(11);
					var = rs.getString(i);
					if(var == null){
						var =  "";
					}
					facilityAddDetails.add(var);
				}
				
		    }
			System.out.println("valid_CustFacilityNames "+facilityAddDetails);
			logger.log(LogStatus.INFO, "Valid Customer Facility Names are Retrieved");
			return facilityAddDetails;
			
		}else{
			logger.log(LogStatus.FATAL,
					"Somehting Horribly went Wrong while Selecting the Eligible Facility for the Branch and Customer Site Combination!");
			return facilityAddDetails;
			
		}
		
	}
		
	
	public static String getTimeZoneForSelectedFacility() throws SQLException {
		
		Statement statement = conn.createStatement();
		String queryString = "select TimeZoneID,TimezoneName from tblTimeZone  where TimeZoneID='"+timeZoneID+"'";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!");
	    logger.log(LogStatus.INFO, "Query to get the TimeZone for the Selected Customer Facility is Executed !");
	    
	    while (rs.next()) {
	    	
	    	facilityTimeZone = rs.getString(2);
	    }
	    System.out.println("Mapped TimeZone for the Selected Facility at the BackEnd is : "+facilityTimeZone);
	    logger.log(LogStatus.INFO, "Mapped TimeZone for the Selected Facility at the BackEnd is : "+facilityTimeZone);
		
	    return facilityTimeZone;
	}
	
	public static String getBusinessTypeForSelectedSite() throws SQLException {
		
		Statement statement = conn.createStatement();
		String queryString = "Select CustomerTypeId,CustomerTypeName from tblMstCutomerType where  CustomerTypeId='"+businessType+"'";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!");
	    logger.log(LogStatus.INFO, "Query to get the Type of Business for the Selected Customer Facility is Executed !");
	    
	    while (rs.next()) {
	    	
	    	businessTypeVal = rs.getString(2);
	    }
	    System.out.println("Mapped Type of Business for the Selected Facility at the BackEnd is : "+businessTypeVal);
	    logger.log(LogStatus.INFO, "Mapped Type of Business for the Selected Facility at the BackEnd is : "+businessTypeVal);
		
		return businessTypeVal;
	}
	
	public static List<String> validateChillerModelDropDownEntries(String controlPanelType, String modelGroup) throws SQLException {
		
		Statement statement = conn.createStatement();
		String queryString = "select * from  tblMstModel where IsSCCModel=1 and MakeId in (select  MakeId from tblMstMake where   MakeId in(select MakeId from tblMstModel where IsSCCModel=1)  and EquipmentTypeId in (select EquipmentTypeId from tblMstEquipmentType ))  and ControlPanelTypeId in (select [ControlPanelTypeId] as ControlPanelId from [tblMstControlPanelType]  where ControlPanelTypeId in(select distinct(ControlPanelTypeId) from tblmstmodel where IsSCCModel=1) and [ControlPanelType] = '"+controlPanelType+"')  and ModelGroupId in (select ModelGroupId from tblMstModelGroup  where ModelGroup = '"+modelGroup+"')  order by modelname";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!");
	    logger.log(LogStatus.INFO, "Query to get the TimeZone for the Selected Customer Facility is Executed !");
	    System.out.println("chillerModelsList size "+chillerModelsList.size());
	    if(chillerModelsList.size() >= 1){ chillerModelsList.clear();} System.out.println("chillerModelsList "+chillerModelsList);
	    while (rs.next()) {
	    	
	    	chillerModelsList.add(rs.getString(3));
	    }
	    System.out.println("Valid Chiller Models for the Make/Model Combination are : "+chillerModelsList);
	    logger.log(LogStatus.INFO, "Valid Chiller Models for the Make/Model Combination are : "+chillerModelsList);
		
	    return chillerModelsList;
		
	}
	
	
	//####################################################################### L1 USER VERIFICATION DETAILS  ###################################################
	
	public static String l1UserID,l1UserTypeID,isL1UserAdmin = null;
	
	
	public static void getUserTypeIDForLoggedInL1User(String l1UserName) throws SQLException {

		Statement statement = conn.createStatement();
		String queryString = "select U.*,R.* from tblMstUser U inner join tblmstrole R on U.roleid=R.roleid where U.firstname = '"+l1UserName+"'";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!");
	    logger.log(LogStatus.INFO, "Query to get the UserTypeID for the LoggedIN L1 user is Executed !");
	    
	    while (rs.next()) {
	    	
	    	l1UserID = rs.getString(1);
	    	l1UserTypeID = rs.getString(12);
	    	isL1UserAdmin = rs.getString(17);
	    }
	    System.out.println("User Type ID for the LoggedIn user is "+l1UserTypeID);
	    logger.log(LogStatus.INFO, "User Type ID for the LoggedIn user is "+l1UserTypeID);
		
	}
	
	
	// Check if all the Eligible branches are mapped to the Logged in Impersonate L1 user
	public static void verifyIfEligibleBrancesAreMappedForL1User() {
		
		
		if (l1UserTypeID.equals("2") || l1UserTypeID.equals("3")) {
			if (isL1UserAdmin.equals("1")) {
				
				
				
			} else {

			} 
		}else if(l1UserTypeID.equals("4")){
			if (isL1UserAdmin.equals("1")) {
				
				
			} else {

			} 
		}else if(l1UserTypeID.equals("5")){
			if (isL1UserAdmin.equals("1")) {
				
				
			} else {

			} 
		}
		
	}
	
	//Validate if any existing CFA users are mapped to the Facility
	public static List<String> checkIfFacilityHasExistingCFAUsers() throws SQLException {

		Statement statement = conn.createStatement();
		String queryString = "SELECT * from [SSF_tblSSFMstUser] where UserId in (select UserId from [SSF_tblSSFUserMapping] where ProjectId ='"+CFAUser_projectID+"')";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!"+queryString);
	    logger.log(LogStatus.INFO, "Query to get the TimeZone for the Selected Customer Facility is Executed !");
	    
	    while (rs.next()) {
	    	
	    	mappedCFAUsersList.add(rs.getString(2));
	    }
	    System.out.println("Valid Chiller Models for the Make/Model Combination are : "+chillerModelsList);
	    logger.log(LogStatus.INFO, "Valid Chiller Models for the Make/Model Combination are : "+chillerModelsList);
		
	    return  mappedCFAUsersList;
		
	}
	
	//Validate all the Branches displayed are of relevance to the logged in User 
	@SuppressWarnings("static-access")
	public static List<String> checkIfValidBranchesAreDisplayedForLoggedUser(String userName) 
			throws ClassNotFoundException, SQLException, InterruptedException {
		
		
		Statement statement = conn.createStatement();
		String queryString = "select * from tblmstuser where firstname= '"+userName+"'";
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
		    System.out.println("Query Executed !!");
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
		    return admin_branches;
	    	
	    }
	    else if (!IsAdmin.equals("1")) 
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is NOT an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Branches are Mapped or not !");
	    	String querString_non_admin = "select VB.GeographyId,VB.GeographyName,VB.CountryId,VB.CountryName,VB.RegionId,VB.RegionName,VB.BranchId,VB.BranchName,VB.Longitude,VB.Lattitude,VB.Address1,VB.Address2,VB.City,VB.[State],VB.ZipCode,VB.PhoneCovHours,VB.TimeZone,VB.TollFree,VB.Branch_Code,CB.ContactDetailsId,CB.ContactNumberMobile,CB.ContactNumberOffice,CB.ContactPerson,CB.EmailAddress from View_Branch  VB left join tblMstBranchContactDetails  CB  on  VB.BranchId=  CB.BranchId  order by branchname ";
		    ResultSet rs_non_admin = statement.executeQuery(querString_non_admin);
		    System.out.println("Query Executed !!");
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
		    return non_admin_branches;
		}
	    
		return null;
	    
		
	}
	

}
