/**
 * 
 */
package mars.JCI.Project.CSD.HomePage.Dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * @author cdeyso
 *
 */
public class CSD_HomePage_DataValidation_Master {
	
	private static ExtentTest logger = null;
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public static String branch_id,UserID,RoleID,IsAdmin,loggedUserApp,selectedColCode,selectedCustId,assetProjID = null;
	
	
	public static List<String> custID = new ArrayList<String>();
	public static List<String> custName = new ArrayList<String>();
	public static List<String> assetDetailsID = new ArrayList<String>();
	public static List<String> assetName = new ArrayList<String>();
	public static List<String> tripStatus = new ArrayList<String>();
	
	public static List<String> facilityProjID = new ArrayList<String>();
	public static List<String> facilityProjName = new ArrayList<String>();
	public static List<String> facilityAssetDetID = new ArrayList<String>();
	public static List<String> facilityAssetName = new ArrayList<String>();
	public static List<String> facilityTripStatus = new ArrayList<String>();
	
	public static List<String> assetAssetName = new ArrayList<String>();
	public static List<String> assetAssetDetID = new ArrayList<String>();
	public static List<String> assetTripStatus = new ArrayList<String>();
	public static List<String> assetOccTime = new ArrayList<String>();
	
	public static List<String> assetOverviewPointNames = new ArrayList<String>();
	
	@SuppressWarnings("static-access")
	public CSD_HomePage_DataValidation_Master(ExtentTest logger) {
		this.logger = logger;
	}
	
	
	public static void getCSDDBSession() throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		System.out.println("Establishing Connection to CSDDB !!");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
		
		
	}
	
	//List<String>
	public static void checkIfValidCustNamesAreDisplayedForLoggedUser(String loggedUser, String colCode) 
			throws ClassNotFoundException, SQLException, InterruptedException {
		
		if(custID.size() > 0)custID.clear();
		if(custName.size() > 0)custName.clear();
		if(assetDetailsID.size() > 0)assetDetailsID.clear();
		if(assetName.size() > 0)assetName.clear();
		if(tripStatus.size() > 0)tripStatus.clear();
		
		loggedUserApp = loggedUser;
		selectedColCode = colCode;
		
		Statement statement = conn.createStatement();
		String queryString = "select * from tblmstuser where firstname= '"+loggedUserApp+"'";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!"+queryString);
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
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_admin = " with CTE as (select cust.Customer_Id,cust.Customer_name,Max(OccuranceDateTime) as OccuranceDateTime, ISNULL(assdet.ColorCode,'#666666') as TripColorCode, assdet.AssetDetailsId,assdet.AssetName,assdet.TripStatus ,convert(int,row_number()OVER(partition by cust.Customer_Id,assdet.ColorCode order by OccuranceDateTime desc)) as CountId,cust.IsActive ,proj.IsActive as projectActive   ,tblTimeConversion.DateTimeOffset from tblCustomer cust inner join tblmstproject proj on  cust.Customer_Id=proj.Customer_Id inner join tblassetgroup ass  on  ass.ProjectId=proj.ProjectId inner join tblassetdetails assdet on  assdet.AssetGroupId=ass.AssetGroupId inner join tblAssetStatus on tblAssetStatus.AssetDetailsId=assdet.AssetDetailsId left  join tblTimeConversion on proj.TimeZoneId=tblTimeConversion.TimeZoneId and tblTimeConversion.EffectiveDatetime<=Getdate() and tblTimeConversion.EndDateTime>=Getdate() where tblAssetStatus.NodeTypeId=7 and tblAssetStatus.IsAssetActive='True' group by cust.Customer_Id,cust.Customer_name,assdet.ColorCode,assdet.AssetDetailsId,assdet.AssetName, assdet.TripStatus,OccuranceDateTime,cust.IsActive,proj.IsActive,tblTimeConversion.DateTimeOffset ) select Customer_Id,Customer_name,AssetDetailsId,AssetName,TripColorCode,TripStatus,OccuranceDateTime,IsActive ,DateTimeOffset from CTE where  TripColorCode = '"+selectedColCode+"' and CountId=1 and IsActive=1 and projectActive=1 order by OccuranceDateTime desc";
		    ResultSet rs_admin = statement.executeQuery(querString_admin);
		    System.out.println("Query Executed !!");
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Colour Code is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_admin.next()) {
		    	custID.add(rs_admin.getString(1)); 
		    	custName.add(rs_admin.getString(2));
		    	assetDetailsID.add(rs_admin.getString(3));
		    	assetName.add(rs_admin.getString(4));
		    	tripStatus.add(rs_admin.getString(6));
		    }
		    
		    System.out.println("custID "+custID);
		    System.out.println("custName "+custName);
		    System.out.println("assetDetailsID "+assetDetailsID);
		    System.out.println("assetName "+assetName);
		    System.out.println("tripStatus "+tripStatus);
	    	
	    }
	    else if (!IsAdmin.equals("1")) 
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is NOT an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_non_admin = " with CTE as (select cust.Customer_Id,cust.Customer_name,Max(OccuranceDateTime) as OccuranceDateTime, ISNULL(assdet.ColorCode,'#666666') as TripColorCode, assdet.AssetDetailsId,assdet.AssetName,assdet.TripStatus ,convert(int,row_number()OVER(partition by cust.Customer_Id,assdet.ColorCode order by OccuranceDateTime desc)) as CountId,cust.IsActive ,proj.IsActive as projectActive, tblTimeConversion.DateTimeOffset from tblCustomer cust inner join tblmstproject proj on  cust.Customer_Id=proj.Customer_Id inner join tblassetgroup ass on ass.ProjectId=proj.ProjectId inner join tblassetdetails assdet on  assdet.AssetGroupId=ass.AssetGroupId inner join tblAssetStatus on tblAssetStatus.AssetDetailsId=assdet.AssetDetailsId left  join tblTimeConversion on proj.TimeZoneId=tblTimeConversion.TimeZoneId and tblTimeConversion.EffectiveDatetime<=Getdate() and tblTimeConversion.EndDateTime>=Getdate() where cust.customer_id in ( select distinct B.Customerid  from tblmstproject A inner join tblCustomerUserMapping B on A.BranchId=B.BranchId where B.UserId='"+UserID+"' and B.Customerid=A.Customer_id and A.IsActive=1) and proj.BranchId in (Select BranchId from tblCustomerUserMapping where UserId='"+UserID+"') and tblAssetStatus.NodeTypeId=7 and tblAssetStatus.IsAssetActive='True' group by cust.Customer_Id,cust.Customer_name,assdet.ColorCode,assdet.AssetDetailsId,assdet.AssetName, assdet.TripStatus,OccuranceDateTime,cust.IsActive,proj.IsActive,tblTimeConversion.DateTimeOffset ) select Customer_Id,Customer_name,AssetDetailsId,AssetName,TripColorCode,TripStatus,OccuranceDateTime,IsActive , DateTimeOffset from CTE where  TripColorCode = '"+selectedColCode+"' and CountId=1 and IsActive=1 and projectActive=1 order by OccuranceDateTime desc";
		    ResultSet rs_non_admin = statement.executeQuery(querString_non_admin);
		    System.out.println("Query Executed !!");
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Colour Code is Executed !");
		    while (rs_non_admin.next()) {
		    	custID.add(rs_non_admin.getString(1)); 
		    	custName.add(rs_non_admin.getString(2));
		    	assetDetailsID.add(rs_non_admin.getString(3));
		    	assetName.add(rs_non_admin.getString(4));
		    	tripStatus.add(rs_non_admin.getString(6));
		    }
		    
		    System.out.println("custID "+custID);
		    System.out.println("custName "+custName);
		    System.out.println("assetDetailsID "+assetDetailsID);
		    System.out.println("assetName "+assetName);
		    System.out.println("tripStatus "+tripStatus);
		}
	}

	public static List<String> checkIfValidFacilityNamesAreDisplayedForLoggedUser(String CustId) throws SQLException {
		
		selectedCustId = CustId;
		
		if(facilityProjID.size() > 0)facilityProjID.clear();
		if(facilityProjName.size() > 0)facilityProjName.clear();
		if(facilityAssetDetID.size() > 0)facilityAssetDetID.clear();
		if(facilityAssetName.size() > 0)facilityAssetName.clear();
		if(facilityTripStatus.size() > 0)facilityTripStatus.clear();
		
		Statement statement = conn.createStatement();
		 if(IsAdmin.equals("1"))
		    {
		    	logger.log(LogStatus.INFO, "The Logged In User is an Admin !");
		    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
		    	String querString_admin = "with CTE as (select proj.ProjectId,proj.ProjectName,Max(OccuranceDateTime) as OccuranceDateTime,ISNULL(assdet.ColorCode,'#666666') as TripColorCode, assdet.AssetDetailsId,assdet.AssetName,assdet.TripStatus ,convert(int,row_number()OVER(partition by proj.ProjectId,assdet.ColorCode order by OccuranceDateTime desc)) as CountId,proj.IsActive , tblTimeConversion.DateTimeOffset from tblmstproject proj inner join tblassetgroup ass on ass.ProjectId=proj.ProjectId  inner join tblassetdetails assdet on  assdet.AssetGroupId=ass.AssetGroupId inner join tblAssetStatus on tblAssetStatus.AssetDetailsId=assdet.AssetDetailsId  left   join tblTimeConversion on proj.TimeZoneId=tblTimeConversion.TimeZoneId and tblTimeConversion.EffectiveDatetime<=Getdate() and tblTimeConversion.EndDateTime>=Getdate() where Customer_id='"+selectedCustId+"' and tblAssetStatus.NodeTypeId=7 and tblAssetStatus.IsAssetActive='True'  group by proj.ProjectId,proj.ProjectName,assdet.ColorCode,assdet.AssetDetailsId,assdet.AssetName, assdet.TripStatus,OccuranceDateTime,proj.IsActive , tblTimeConversion.DateTimeOffset ) select ProjectId,ProjectName,AssetDetailsId,AssetName,TripColorCode,TripStatus,IsActive ,DateTimeOffset from CTE where TripColorCode = '"+selectedColCode+"' and IsActive=1 and CountId=1 order by OccuranceDateTime desc ";
			    ResultSet rs_admin = statement.executeQuery(querString_admin);
			    System.out.println("Query Executed !!\n"+ querString_admin);
			    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Colour Code is Executed !");
			    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
			    while (rs_admin.next()) {
			    	facilityProjID.add(rs_admin.getString(1)); 
			    	facilityProjName.add(rs_admin.getString(2));
			    	facilityAssetDetID.add(rs_admin.getString(3));
			    	facilityAssetName.add(rs_admin.getString(4));
			    	facilityTripStatus.add(rs_admin.getString(6));
			    }
			    
			    System.out.println("facilityProjID "+facilityProjID);
			    System.out.println("facilityProjName "+facilityProjName);
			    System.out.println("facilityAssetDetID "+facilityAssetDetID);
			    System.out.println("facilityAssetName "+facilityAssetName);
			    System.out.println("facilityTripStatus "+facilityTripStatus);
		    	
		    }
		    else if (!IsAdmin.equals("1")) 
		    {
		    	logger.log(LogStatus.INFO, "The Logged In User is NOT an Admin !");
		    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
		    	String querString_non_admin = "with CTE as (select proj.ProjectId,proj.ProjectName,Max(OccuranceDateTime) as OccuranceDateTime,ISNULL(assdet.ColorCode,'#666666') as TripColorCode,   assdet.AssetDetailsId,assdet.AssetName,assdet.TripStatus  ,convert(int,row_number()OVER(partition by proj.ProjectId,assdet.ColorCode order by OccuranceDateTime desc)) as CountId,proj.IsActive , tblTimeConversion.DateTimeOffset from tblmstproject proj inner join tblassetgroup ass on ass.ProjectId=proj.ProjectId inner join tblassetdetails assdet on   assdet.AssetGroupId=ass.AssetGroupId  inner join tblAssetStatus on tblAssetStatus.AssetDetailsId=assdet.AssetDetailsId  left  join tblTimeConversion on proj.TimeZoneId=tblTimeConversion.TimeZoneId and tblTimeConversion.EffectiveDatetime<=Getdate() and tblTimeConversion.EndDateTime>=Getdate()   where Customer_id='"+selectedCustId+"'  and proj.BranchId in (Select distinct(BranchId) from tblCustomerUserMapping where UserId='"+UserID+"' and CustomerId='"+selectedCustId+"') and tblAssetStatus.NodeTypeId=7 and tblAssetStatus.IsAssetActive='True' group by proj.ProjectId,proj.ProjectName,assdet.ColorCode,assdet.AssetDetailsId,assdet.AssetName, assdet.TripStatus,OccuranceDateTime,proj.IsActive , tblTimeConversion.DateTimeOffset ) select ProjectId,ProjectName,AssetDetailsId,AssetName,TripColorCode,TripStatus,IsActive  , DateTimeOffset from CTE where TripColorCode = '"+selectedColCode+"' and IsActive=1 and CountId=1 order by OccuranceDateTime desc";
			    ResultSet rs_non_admin = statement.executeQuery(querString_non_admin);
			    System.out.println("Query Executed !!\n"+querString_non_admin);
			    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Colour Code is Executed !");
			    while (rs_non_admin.next()) {
			    	facilityProjID.add(rs_non_admin.getString(1)); 
			    	facilityProjName.add(rs_non_admin.getString(2));
			    	facilityAssetDetID.add(rs_non_admin.getString(3));
			    	facilityAssetName.add(rs_non_admin.getString(4));
			    	facilityTripStatus.add(rs_non_admin.getString(6));
			    }
			    
			    System.out.println("facilityProjID "+facilityProjID);
			    System.out.println("facilityProjName "+facilityProjName);
			    System.out.println("facilityAssetDetID "+facilityAssetDetID);
			    System.out.println("facilityAssetName "+facilityAssetName);
			    System.out.println("facilityTripStatus "+facilityTripStatus);
			}
		
		return null;
	}
	
	public static List<String> checkIfValidAssetNamesAreDisplayedForLoggedUser(String projID) throws SQLException {
		
				assetProjID = projID;
				Statement statement = conn.createStatement();
		    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
		    	String querString_admin = "with CTE as (select assdet.AssetName,assdet.AssetDetailsId,Max(OccuranceDateTime) as OccuranceDateTime,ISNULL(assdet.ColorCode,'#666666') as TripColorCode,assdet.DefaultValue,assdet.TripStatus  from tblassetgroup ass inner join tblassetdetails assdet on assdet.AssetGroupId=ass.AssetGroupId  inner join tblAssetStatus on tblAssetStatus.AssetDetailsId=assdet.AssetDetailsId where ass.ProjectId='"+assetProjID+"' and tblAssetStatus.NodeTypeId=7 and tblAssetStatus.IsAssetActive='True' group by assdet.AssetName,assdet.AssetDetailsId,assdet.ColorCode,assdet.DefaultValue,assdet.TripStatus) select AssetName,AssetDetailsId,TripColorCode,TripStatus,DefaultValue,OccuranceDateTime from CTE where TripColorCode = '"+selectedColCode+"' order by OccuranceDateTime desc ";
			    ResultSet rs_admin = statement.executeQuery(querString_admin);
			    System.out.println("Query Executed !!\n"+ querString_admin);
			    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Assets according to the Colour Code is Executed !");
			    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
			    while (rs_admin.next()) {
			    	assetAssetName.add(rs_admin.getString(1)); 
			    	assetAssetDetID.add(rs_admin.getString(2));
			    	assetTripStatus.add(rs_admin.getString(4));
			    	assetOccTime.add(rs_admin.getString(6));
			    }
			    
			    System.out.println("assetAssetName "+assetAssetName);
			    System.out.println("assetAssetDetID "+assetAssetDetID);
			    System.out.println("assetTripStatus "+assetTripStatus);
			    System.out.println("assetOccTime "+assetOccTime);
			    
		return null;
	}
	
	public static void validateAssetOverviewPointNames() 
			throws SQLException {
		
		String sel_assetDetID = assetAssetDetID.get(0);
		Statement statement = conn.createStatement();
		logger.log(LogStatus.INFO, "Verifying whether the Proper Asset Overview Point Names are Mapped or not !");
		String querString_admin = "select distinct SP.PointId,   PC.Point_category_ID ,PC.Point_category_Name ,att.[Description] as PointName  ,att.AttributeName as 'SingleAttributeName' ,U.UnitType, REPLACE( REPLACE( att.AttributeName, '-','_'),' ','_') as 'SingleAttributeNameSub', lower( REPLACE( REPLACE( att.AttributeName, '-','_'),' ','_')) as 'SingleAttributeNameLower' from tblselpoint SP inner join tblPointCategoryRelation PCR on SP.PointId = PCR.PointId  inner join tblPointCategory PC on PCR.PointCategoryId = PC.Point_Category_ID inner join tblpoint P on P.PointId=SP.PointId  inner join tblmstfromunit fu on fu.FromUnitTypeId=P.FromUnitId inner join tblnaename nm on nm.naeid=P.naeid  inner join View_SelectedUnit U on  U.UnitTypeId = fu.UnitTypeId and U.AssetDetailsId = nm.AssetDetailsId inner join tblassetattributes att on att.AssetAttributesId=SP.AssetAttributesId where nm.AssetDetailsId= '"+sel_assetDetID+"' and   PC.Point_category_Name  = 'Overview' and att.isviewdashboard=1 ";
	    ResultSet rs_admin = statement.executeQuery(querString_admin);
	    System.out.println("Query Executed !!\n"+ querString_admin);
	    logger.log(LogStatus.INFO, "Query to Check all the Proper Asset Overview Point Names are Mapped or not is Executed !");
	    while (rs_admin.next()) {
	    	
	    	assetOverviewPointNames.add(rs_admin.getString(4));
	    }
	    
	    System.out.println("assetOverviewPointNames "+assetOverviewPointNames);
	    
	}
}
