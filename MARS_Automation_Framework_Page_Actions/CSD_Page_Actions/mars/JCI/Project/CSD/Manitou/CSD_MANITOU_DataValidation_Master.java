/**
 * 
 */
package mars.JCI.Project.CSD.Manitou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class CSD_MANITOU_DataValidation_Master {
	
	private static ExtentTest logger = null;
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public static String branch_id,UserID,RoleID,IsAdmin,loggedUserApp,selectedCustomerID = null;
	
	public static List<String> custID = new ArrayList<String>();
	public static List<String> custName = new ArrayList<String>();
	public static List<String> isManitouEnabled = new ArrayList<String>();
	
	public static List<String> projID = new ArrayList<String>();
	public static List<String> projName = new ArrayList<String>();
	
	public static List<String> asset_assetDetID = new ArrayList<String>();
	public static List<String> asset_assetName = new ArrayList<String>();
	public static List<String> asset_owner = new ArrayList<String>();
	public static List<String> asset_Device = new ArrayList<String>();
	public static List<String> asset_reference = new ArrayList<String>();
	public static List<String> asset_dataSourceID = new ArrayList<String>();
	public static List<String> asset_modelID = new ArrayList<String>();
	public static List<String> asset_ModelName = new ArrayList<String>();
	public static List<String> asset_MACID = new ArrayList<String>();
	public static List<String> asset_UnitName = new ArrayList<String>();
	public static List<String> asset_Modeltype = new ArrayList<String>();
	
	public static List<String> alarm_ID = new ArrayList<String>();
	public static List<String> alarm_assetAttID = new ArrayList<String>();
	public static List<String> alarm_attName = new ArrayList<String>();
	public static List<String> alarm_Value = new ArrayList<String>();
	public static List<String> alarm_attID = new ArrayList<String>();
	public static List<String> alarm_pointRef = new ArrayList<String>();
	public static List<String> alarm_description = new ArrayList<String>();
	public static List<String> alarm_tripStatus = new ArrayList<String>();
	
	public static Set<String> uniq_attName = null;

	@SuppressWarnings("static-access")
	public CSD_MANITOU_DataValidation_Master(ExtentTest logger) {
		this.logger = logger;
	}
	
	
	public static void getCSDDBSession() throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		System.out.println("Establishing Connection to CSDDB !!");
		//logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
	}
	
	public static void checkIfValidManitouCustomerAreReflected(String loggedUser) 
			throws SQLException, ClassNotFoundException {
		
		if (conn == null) {
			logger.log(LogStatus.INFO, "Establishing Connection to CSDDB !!");
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "Connection to CSD DB Already Exists");
		}
		
		if(isManitouEnabled.size() > 0){isManitouEnabled.clear();}
		if(custName.size() > 0){custName.clear();}
		if(custID.size() > 0){custID.clear();}
		
		loggedUserApp = loggedUser;
		Statement statement = conn.createStatement();
		String queryString = "select * from tblmstuser where firstname= '"+loggedUserApp+"'";
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!\n"+queryString);
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
	    System.out.println("Query Executed !!\n"+querString_2);
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
	    	String querString_admin = "SELECT DISTINCT A.Customer_Id ,A.Customer_Name,    ( select convert(bit,case when(isnull(count(x.ismanitouenable),0)>0) then 1 else 0 end) from tblsccdetails x inner join view_assetdetails y on x.assetdetailsid=y.assetdetailsid where y.customer_id=A.customer_id and x.ismanitouenable=1 ) as IsManitouEnable FROM view_assetdetails A  INNER JOIN tblsccownerdevicedata B ON A.AssetDetailsId = B.AssetDetailsId  WHERE A.IsAssetActive = 1 order by A.Customer_Name";
		    ResultSet rs_admin = statement.executeQuery(querString_admin);
		    System.out.println("Query Executed !!\n"+querString_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Manitou Option is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_admin.next()) {
		    	if (rs_admin.getString(3).equals("1")) {
					custID.add(rs_admin.getString(1));
					custName.add(rs_admin.getString(2));
					isManitouEnabled.add(rs_admin.getString(3));
				}
		    }
		    
		    System.out.println("custID "+custID);
		    System.out.println("custName "+custName);
		    System.out.println("assetDetailsID "+isManitouEnabled);
	    	
	    }
	    else if (!IsAdmin.equals("1")) 
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is NOT an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_non_admin = "SELECT DISTINCT A.Customer_Id   ,A.Customer_Name,  (  select convert(bit,case when(isnull(count(x.ismanitouenable),0)>0) then 1 else 0 end) from tblsccdetails x inner join view_assetdetails y on x.assetdetailsid=y.assetdetailsid  where y.customer_id=A.customer_id and x.ismanitouenable=1   ) as IsManitouEnable  FROM view_assetdetails A  INNER JOIN tblsccownerdevicedata B ON A.AssetDetailsId = B.AssetDetailsId INNER JOIN tblcustomerusermapping C ON C.BranchId = A.BranchId  WHERE A.IsAssetActive = 1  and C.CustomerId=A.Customer_Id and C.UserId='"+UserID+"' order by A.Customer_Name";
		    ResultSet rs_non_admin = statement.executeQuery(querString_non_admin);
		    System.out.println("Query Executed !!\n"+querString_non_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Manitou Option is Executed !");
		    while (rs_non_admin.next()) {
		    	if (rs_non_admin.getString(3).equals("1")) {
					custID.add(rs_non_admin.getString(1));
					custName.add(rs_non_admin.getString(2));
					isManitouEnabled.add(rs_non_admin.getString(3));
				}
		    }
		    
		    System.out.println("custID "+custID);
		    System.out.println("custName "+custName);
		    System.out.println("assetDetailsID "+isManitouEnabled);
		}
		
	}
	
	
	public static void checkIfValidManitouCustomerAreReflected_2(String loggedUser){
		
		
	}
	
	
	public static void checkIfValidManitouFacilityAreReflected(String selCustID) 
			throws ClassNotFoundException, SQLException {
		
		if (conn == null) {
			logger.log(LogStatus.INFO, "Establishing Connection to CSDDB !!");
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "Connection to CSD DB Already Exists");
		}
		
		if(isManitouEnabled.size() > 0){isManitouEnabled.clear();}
		if(projName.size() > 0){projName.clear();}
		if(projID.size() > 0){projID.clear();}
		
		selectedCustomerID = selCustID;
		
		Statement statement = conn.createStatement();
		if(IsAdmin.equals("1"))
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_admin = "SELECT DISTINCT A.ProjectId  ,A.ProjectName,  ( select convert(bit,case when(isnull(count(x.ismanitouenable),0)>0) then 1 else 0 end) from tblsccdetails x inner join view_assetdetails y on x.assetdetailsid=y.assetdetailsid where y.ProjectId=A.ProjectId and x.ismanitouenable=1  ) as IsManitouEnable FROM view_assetdetails A INNER JOIN tblsccownerdevicedata B ON A.AssetDetailsId = B.AssetDetailsId WHERE A.Customer_Id = '"+selectedCustomerID+"'  AND A.IsAssetActive = 1 order by A.ProjectName";
		    ResultSet rs_admin = statement.executeQuery(querString_admin);
		    System.out.println("Query Executed !!\n"+querString_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Facility according to the Manitou Option is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_admin.next()) {
		    	if (rs_admin.getString(3).equals("1")) {
		    		projID.add(rs_admin.getString(1));
					projName.add(rs_admin.getString(2));
					isManitouEnabled.add(rs_admin.getString(3));
				}
		    }
		    
		    System.out.println("projID "+projID);
		    System.out.println("projName "+projName);
		    System.out.println("assetDetailsID "+isManitouEnabled);
	    	
	    }
	    else if (!IsAdmin.equals("1")) 
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is NOT an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_non_admin = "SELECT DISTINCT A.ProjectId  ,A.ProjectName,  (   select convert(bit,case when(isnull(count(x.ismanitouenable),0)>0) then 1 else 0 end) from tblsccdetails x inner join view_assetdetails y on x.assetdetailsid=y.assetdetailsid  where y.ProjectId=A.ProjectId and x.ismanitouenable=1 ) as IsManitouEnable FROM view_assetdetails A  INNER JOIN tblsccownerdevicedata B ON A.AssetDetailsId = B.AssetDetailsId  INNER JOIN tblcustomerusermapping C ON C.BranchId = A.BranchId  WHERE A.Customer_Id = '"+selectedCustomerID+"'  AND A.IsAssetActive = 1 and C.UserId='"+UserID+"' order by A.ProjectName";
		    ResultSet rs_non_admin = statement.executeQuery(querString_non_admin);
		    System.out.println("Query Executed !!\n"+querString_non_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Faciity according to the Manitou Option is Executed !");
		    while (rs_non_admin.next()) {
		    	if (rs_non_admin.getString(3).equals("1")) {
		    		projID.add(rs_non_admin.getString(1));
		    		projName.add(rs_non_admin.getString(2));
					isManitouEnabled.add(rs_non_admin.getString(3));
				}
		    }
		    
		    System.out.println("projID"+projID);
		    System.out.println("projName "+projName);
		    System.out.println("assetDetailsID "+isManitouEnabled);
		}
		
		
	}

	public static void checkIfValidManitouAssetsAreReflected() 
			throws ClassNotFoundException, SQLException {
		
		String selProjID = projID.get(0);
		
		if (conn == null) {
			logger.log(LogStatus.INFO, "Establishing Connection to CSDDB !!");
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "Connection to CSD DB Already Exists");
		}
		
		
		Statement statement = conn.createStatement();
		if(IsAdmin.equals("1"))
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_admin = "SELECT DISTINCT A.AssetDetailsId  ,A.AssetName ,B.Owner ,B.Device ,B.reference ,C.DataSourceId ,A.ModelId  ,A.ModelName ,B.MacId , ( select top 1 case when (count(id)=0) then 'Metric' else 'Imperial' end as UnitName from tblattributelookup where model_id=A.ModelId and imperial_UOM in( select distinct UnitName from view_selpoints where assetdetailsid=A.AssetDetailsId and unittype='Temperature' )) as UnitName,( select top 1 D.ModelType from tblassetdetails x inner join tblmstModel B on x.ModelId=B.ModelId inner join tblModelModelTypeMapping C on C.ModelId=B.ModelId  inner join tblMstModelType D on D.ModelTypeId=C.ModelTypeId where x.AssetdetailsId=A.AssetDetailsId ) as ModelType,( select convert(bit,case when(isnull(count(x.ismanitouenable),0)>0) then 1 else 0 end)from tblsccdetails x inner join view_assetdetails y on x.assetdetailsid=y.assetdetailsid where y.AssetDetailsId=A.AssetDetailsId and x.ismanitouenable=1 ) as IsManitouEnable FROM view_assetdetails A INNER JOIN tblsccownerdevicedata B ON A.AssetDetailsId = B.AssetDetailsId INNER JOIN tblNaeName C on A.AssetDetailsId = C.AssetDetailsId WHERE A.ProjectId = '"+selProjID+"' AND A.IsAssetActive = 1 order by A.AssetName";
		    ResultSet rs_admin = statement.executeQuery(querString_admin);
		    System.out.println("Query Executed !!\n"+querString_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Assets according to the Manitou Option is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_admin.next()) {
		    	if (rs_admin.getString(12).equals("1")) {
		    		asset_assetDetID.add(rs_admin.getString(1));
		    		asset_assetName.add(rs_admin.getString(2));
		    		asset_owner.add(rs_admin.getString(3));
		    		asset_Device.add(rs_admin.getString(4));
		    		asset_reference.add(rs_admin.getString(5));
		    		asset_dataSourceID.add(rs_admin.getString(6));
		    		asset_modelID.add(rs_admin.getString(7));
		    		asset_ModelName.add(rs_admin.getString(8));
		    		asset_MACID.add(rs_admin.getString(9));
		    		asset_UnitName.add(rs_admin.getString(10));
		    		asset_Modeltype.add(rs_admin.getString(11));
				}
		    }
		    
		    System.out.println("asset_assetDetID "+asset_assetDetID);
		    System.out.println("asset_assetName "+asset_assetName);
		    System.out.println("asset_owner "+asset_owner);
		    System.out.println("asset_Device "+asset_Device);
		    System.out.println("asset_reference "+asset_reference);
		    System.out.println("asset_dataSourceID "+asset_dataSourceID);
		    System.out.println("asset_modelID "+asset_modelID);
		    System.out.println("asset_ModelName "+asset_ModelName);
		    System.out.println("asset_MACID "+asset_MACID);
		    System.out.println("asset_UnitName "+asset_UnitName);
		    System.out.println("asset_Modeltype "+asset_Modeltype);
	    }
	    else if (!IsAdmin.equals("1")) 
	    {
	    	logger.log(LogStatus.INFO, "The Logged In User is NOT an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_non_admin = "SELECT DISTINCT A.AssetDetailsId  ,A.AssetName ,B.Owner ,B.Device ,B.reference ,C.DataSourceId ,A.ModelId  ,A.ModelName ,B.MacId , ( select top 1 case when (count(id)=0) then 'Metric' else 'Imperial' end as UnitName from tblattributelookup where model_id=A.ModelId and imperial_UOM in( select distinct UnitName from view_selpoints where assetdetailsid=A.AssetDetailsId and unittype='Temperature' )) as UnitName,( select top 1 D.ModelType from tblassetdetails x inner join tblmstModel B on x.ModelId=B.ModelId inner join tblModelModelTypeMapping C on C.ModelId=B.ModelId  inner join tblMstModelType D on D.ModelTypeId=C.ModelTypeId where x.AssetdetailsId=A.AssetDetailsId ) as ModelType,( select convert(bit,case when(isnull(count(x.ismanitouenable),0)>0) then 1 else 0 end)from tblsccdetails x inner join view_assetdetails y on x.assetdetailsid=y.assetdetailsid where y.AssetDetailsId=A.AssetDetailsId and x.ismanitouenable=1 ) as IsManitouEnable FROM view_assetdetails A INNER JOIN tblsccownerdevicedata B ON A.AssetDetailsId = B.AssetDetailsId INNER JOIN tblNaeName C on A.AssetDetailsId = C.AssetDetailsId WHERE A.ProjectId = '"+selProjID+"' AND A.IsAssetActive = 1  and C.UserId='"+UserID+"' order by A.AssetName ";
		    ResultSet rs_non_admin = statement.executeQuery(querString_non_admin);
		    System.out.println("Query Executed !!\n"+querString_non_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Faciity according to the Manitou Option is Executed !");
		    while (rs_non_admin.next()) {
		    	if (rs_non_admin.getString(12).equals("1")) {
		    		asset_assetDetID.add(rs_non_admin.getString(1));
		    		asset_assetName.add(rs_non_admin.getString(2));
		    		asset_owner.add(rs_non_admin.getString(3));
		    		asset_Device.add(rs_non_admin.getString(4));
		    		asset_reference.add(rs_non_admin.getString(5));
		    		asset_dataSourceID.add(rs_non_admin.getString(6));
		    		asset_modelID.add(rs_non_admin.getString(7));
		    		asset_ModelName.add(rs_non_admin.getString(8));
		    		asset_MACID.add(rs_non_admin.getString(9));
		    		asset_UnitName.add(rs_non_admin.getString(10));
		    		asset_Modeltype.add(rs_non_admin.getString(11));
				}
		    }
		    
		    System.out.println("asset_assetDetID "+asset_assetDetID);
		    System.out.println("asset_assetName "+asset_assetName);
		    System.out.println("asset_owner "+asset_owner);
		    System.out.println("asset_Device "+asset_Device);
		    System.out.println("asset_reference "+asset_reference);
		    System.out.println("asset_dataSourceID "+asset_dataSourceID);
		    System.out.println("asset_modelID "+asset_modelID);
		    System.out.println("asset_ModelName "+asset_ModelName);
		    System.out.println("asset_MACID "+asset_MACID);
		    System.out.println("asset_UnitName "+asset_UnitName);
		    System.out.println("asset_Modeltype "+asset_Modeltype);
		}
		
		
	}

	public static void checkIfValidManitouAlarmTypesAreReflected(int assetIDIndex) 
			throws ClassNotFoundException, SQLException {
		
		String selAssetID = asset_assetDetID.get(assetIDIndex);
		
		if (conn == null) {
			logger.log(LogStatus.INFO, "Establishing Connection to CSDDB !!");
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "Connection to CSD DB Already Exists");
		}
		
		Statement statement = conn.createStatement();
		String querString_admin = "with cte as(   select distinct J.AssetAttributesId,J.Attributename,K.Value,L.AttributeId,L.pointRef,J.Description,M.TripStatus from tblassetdetails D inner join tblnaename F on F.assetdetailsId=D.assetdetailsId inner join tblpoint G on G.naeid=F.naeId inner join tblsccpointrule H on H.pointId=G.pointId  inner join tblselpoint I on I.pointId=G.pointId inner join tblassetattributes J on J.AssetAttributesId=I.AssetAttributesId inner join tblSccAttributelookup K on K.Id=H.SccAttributeId  inner join tblsccpointMapping L on L.pointId=H.PointId inner join tbltripstatus M on M.AsetsMadelId=D.ModelId inner join tblmstalarmType N on N.AlarmType=J.Attributename and N.AlarmTypeId=M.AlarmTypeId and M.DefaultValue=K.Value where D.AssetdetailsId='"+selAssetID+"' )select row_number() over(order by AssetAttributesId) as Id,* from  cte ";
	    ResultSet rs_admin = statement.executeQuery(querString_admin);
	    System.out.println("Query Executed !!\n"+querString_admin);
	    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Assets according to the Manitou Option is Executed !");
	    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
	    while (rs_admin.next()) {
	    		alarm_ID.add(rs_admin.getString(1));
	    		alarm_assetAttID.add(rs_admin.getString(2));
	    		alarm_attName.add(rs_admin.getString(3));
	    		alarm_Value.add(rs_admin.getString(4));
	    		alarm_attID.add(rs_admin.getString(5));
	    		alarm_pointRef.add(rs_admin.getString(6));
	    		alarm_description.add(rs_admin.getString(7));
	    		alarm_tripStatus.add(rs_admin.getString(8));
	    }
	    
	    uniq_attName = new HashSet<String>(alarm_attName);
	    
	    System.out.println("alarm_ID "+alarm_ID);
	    System.out.println("alarm_assetAttID "+alarm_assetAttID);
	    System.out.println("alarm_attName "+alarm_attName);
	    System.out.println("asset_Device "+asset_Device);
	    System.out.println("alarm_Value "+alarm_Value);
	    System.out.println("alarm_attID "+alarm_attID);
	    System.out.println("alarm_pointRef "+alarm_pointRef);
	    System.out.println("alarm_description "+alarm_description);
	    System.out.println("alarm_tripStatus "+alarm_tripStatus);
	    System.out.println("uniq_attName "+uniq_attName);
	}
	
	public static void checkIfValidManitouAlarmValuesAreReflected(int assetIDIndex,String alarmTypeName) 
			throws ClassNotFoundException, SQLException {
		
		String selAssetID = asset_assetDetID.get(assetIDIndex);
		
		if (conn == null) {
			logger.log(LogStatus.INFO, "Establishing Connection to CSDDB !!");
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "Connection to CSD DB Already Exists");
		}
		
		if (alarm_Value.size() > 0){alarm_Value.clear();}
		
		Statement statement = conn.createStatement();
		String querString_admin = "with cte as(   select distinct J.AssetAttributesId,J.Attributename,K.Value,L.AttributeId,L.pointRef,J.Description,M.TripStatus from tblassetdetails D inner join tblnaename F on F.assetdetailsId=D.assetdetailsId inner join tblpoint G on G.naeid=F.naeId inner join tblsccpointrule H on H.pointId=G.pointId  inner join tblselpoint I on I.pointId=G.pointId inner join tblassetattributes J on J.AssetAttributesId=I.AssetAttributesId inner join tblSccAttributelookup K on K.Id=H.SccAttributeId  inner join tblsccpointMapping L on L.pointId=H.PointId inner join tbltripstatus M on M.AsetsMadelId=D.ModelId inner join tblmstalarmType N on N.AlarmType=J.Attributename and N.AlarmTypeId=M.AlarmTypeId and M.DefaultValue=K.Value where D.AssetdetailsId='"+selAssetID+"' )select row_number() over(order by AssetAttributesId) as Id,* from  cte where attributename='"+alarmTypeName+"'";
	    ResultSet rs_admin = statement.executeQuery(querString_admin);
	    System.out.println("Query Executed !!\n"+querString_admin);
	    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Assets according to the Manitou Option is Executed !");
	    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
	    while (rs_admin.next()) {
	    		
	    		alarm_Value.add(rs_admin.getString(4));
	    }
	    System.out.println("alarm_Value "+alarm_Value);
	}
	
	
	//Store the Generated XML into an XML File
	
}
