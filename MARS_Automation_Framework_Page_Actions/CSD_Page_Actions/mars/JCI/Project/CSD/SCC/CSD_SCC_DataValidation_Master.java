package mars.JCI.Project.CSD.SCC;

import java.io.IOException;
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

import mars.JCI.Project.CSD.SCC.CSD_SCC_SccDataImport_Page_Action;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CSD_SCC_DataValidation_Master {
	
	private static ExtentTest logger = null;
	private static WebDriver driver = null;
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public static List<String> assetPointNames = new ArrayList<String>();
	

	public static String branch_id,UserID,RoleID,IsAdmin,loggedUserApp,selectedColCode,selectedCustId,assetProjID,chiller_asset_id_db = null;
	
	public static Set<String> dbPointGroupList = new HashSet<String>();
	public static List<String> dbAttributeNameList = new ArrayList<String>();
	public static List<String> dbDescriptionList = new ArrayList<String>();
	
	public static List<String> dbPointIDList = new ArrayList<String>();
	public static List<String> dbNameList = new ArrayList<String>();
	public static List<String> dbPointNameList = new ArrayList<String>();
	//public static List<String> dbAssetDetailsIDList = new ArrayList<String>();
	
	
	

	//private static CSD_SCC_SccDataImport_Page_Action scc_dataImport_pa = null;
	
	@SuppressWarnings("static-access")
	public CSD_SCC_DataValidation_Master(WebDriver driver,ExtentTest logger) {
		this.logger = logger;
		//scc_dataImport_pa = new CSD_SCC_SccDataImport_Page_Action(driver, logger);
	}
	
	public static void getCSDDBSession() throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		System.out.println("Establishing Connection to CSDDB !!");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
		
	}
	
	
	//Validate the values of the Points after Import is done from the DataBase for the Particular Chiller
	public static void saveSelectedChillerPointsFromDB(String[] owner_device_info) 
			throws ClassNotFoundException, SQLException, IOException {
		
		if(conn == null){
			getCSDDBSession();
		}else{
			logger.log(LogStatus.PASS, "Connection to CSDDB already exists !!");
		}
		
		if (assetPointNames.size() > 0) {assetPointNames.clear();}
		
		Statement statement = conn.createStatement();
		String owner_name = owner_device_info[0];
		String device_name = owner_device_info[1];
		String macid_value = owner_device_info[2];
		String attDetails_id = null,queryString = null;
		if(macid_value.equals("")){

			queryString = "select assetdetailsid from tblsccownerdevicedata where owner='"+owner_name+"' and device='"+device_name+"';";// and macid='"+macid_value+"';";
		}else{

			queryString = "select assetdetailsid from tblsccownerdevicedata where owner='"+owner_name+"' and device='"+device_name+"' and macid='"+macid_value+"';";
		}
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("Query Executed !!\n"+queryString);
	    logger.log(LogStatus.PASS, "Query to Get the Asset Details ID for the Selected Chiller from DataBase based on Owner,Device and MAC ID is Executed !!");
	    ResultSetMetaData metaData = rs.getMetaData();
	    while (rs.next()) {
            for (int i=1; i<=metaData.getColumnCount(); i++) {
                    System.out.print("  "  + rs.getString(i));
                    attDetails_id = rs.getString(i);
                    logger.log(LogStatus.PASS, "AssetDetailsID for the Selected Chiller is "+attDetails_id);
            }
            System.out.println();
	    }
	    rs.close();
	    if(attDetails_id != null)
		{
			
	    	String equipment_type_val = owner_device_info[3];
	    	System.out.println("The Equipment Type is "+equipment_type_val);
	    	logger.log(LogStatus.PASS, "The Equipment Type is :"+equipment_type_val);	    	
	    	ResultSet rs_2 = null;
	    	if(equipment_type_val != "CPO5")
	    	{
	    		//For NON CPO5 Equipment
	    		System.out.println("equipment_type_val "+equipment_type_val+" and attDetails_id :"+attDetails_id);//B.DataSourceId,
			    String queryString_2 = "select B.selpointid,C.Attributename,A.pointname,A.pointid from tblpoint A Inner join tblselpoint B on A.pointId=B.Pointid inner join tblassetattributes C on C.AssetAttributesId=B.AssetAttributesId inner join tblnaename D on D.naeid=A.naeid where D.assetdetailsid='"+attDetails_id+"' and A.ismanual=0 and C.Attributename not in (select distinct attributename from tblattributelookup where cpoType is not null) order by C.Attributename;"; //and B.DataSourceId=127 
				rs_2 = statement.executeQuery(queryString_2);
				System.out.println("Query Executed for Non CPO5 Equipment!!\n"+queryString_2);
			    logger.log(LogStatus.PASS, "Query to Get the Point Details for the Selected Chiller from DataBase based on Owner,Device and MAC ID is Executed !!");
			    ResultSetMetaData metaData_2 = rs_2.getMetaData();
			    while (rs_2.next()) {
					for (int i=1; i<=metaData_2.getColumnCount(); i++) {
						System.out.print("  "  + rs_2.getString(i));
						attDetails_id = rs_2.getString(i);
						/*String attDetails_point = rs_2.getString(3);
						assetPointNames.add(attDetails_point);*/
						//logger.log(LogStatus.PASS, "AssetDetailsID for the Selected Chiller is "+attDetails_id);
					}
					System.out.println();
					String attDetails_point = rs_2.getString(3);
					assetPointNames.add(attDetails_point);
		        }
		        //rs_2.close();
	    	}
	    	if(equipment_type_val.equalsIgnoreCase("CPO5"))//equipment_type_val == "CPO5" --else 
	    	{
	    		//For CPO5 Equipment
	    		System.out.println("equipment_type_val "+equipment_type_val+" and attDetails_id :"+attDetails_id);//B.DataSourceId,
	    		//String queryString_2 = "select B.selpointid,C.Attributename,A.pointname,A.pointid from tblpoint A Inner join tblselpoint B on A.pointId=B.Pointid inner join tblassetattributes C on C.AssetAttributesId=B.AssetAttributesId inner join tblnaename D on D.naeid=A.naeid where D.assetdetailsid='"+attDetails_id+"' and A.ismanual=0 and B.DataSourceId=127 order by C.Attributename;";
	    		String queryString_2 = "select B.selpointid,C.Attributename,A.pointname,A.pointid from tblpoint A Inner join tblselpoint B on A.pointId=B.Pointid inner join tblassetattributes C on C.AssetAttributesId=B.AssetAttributesId inner join tblnaename D on D.naeid=A.naeid where D.assetdetailsid='"+attDetails_id+"' and A.ismanual=0 order by C.Attributename;"; //and B.DataSourceId=127 
	    		rs_2 = statement.executeQuery(queryString_2);
				System.out.println("Query for CPO5 Equipment Executed !!\n"+queryString_2);
			    logger.log(LogStatus.PASS, "Query to Get the Point Details for the Selected CPO5 Equipment from DataBase based on Owner,Device and MAC ID is Executed !!");
			    ResultSetMetaData metaData_2 = rs_2.getMetaData();
			    while (rs_2.next()) {
					for (int i=1; i<=metaData_2.getColumnCount(); i++) {
						System.out.print("  "  + rs_2.getString(i));
						attDetails_id = rs_2.getString(i);
						/*String attDetails_point = rs_2.getString(3);
						assetPointNames.add(attDetails_point);*/
						//logger.log(LogStatus.PASS, "AssetDetailsID for the Selected Chiller is "+attDetails_id);
					}
					System.out.println();
					String attDetails_point = rs_2.getString(3);
					assetPointNames.add(attDetails_point);
		        }
		        //rs_2.close();
	    	}
		    
	    	rs_2.close();
	    	System.out.println("assetPointNames : "+assetPointNames);
	    }
	    
	    else
	    {
	    	logger.log(LogStatus.FAIL, "The AssetDetailsID for the Selected Chiller is NULL !!");
	    }
	    
	    
	    //conn.close();
	}
	
	
	
	//Check whether the logged in user is a Admin or not 
	public static void checkProfileForLoggedInUser(String loggedUser) 
			throws SQLException, ClassNotFoundException {
		
		if(conn == null){
			getCSDDBSession();
		}else{
			logger.log(LogStatus.PASS, "Connection to CSDDB already exists !!");
		}
		
		loggedUserApp = loggedUser;
		
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
	}
	
	
	//Get the Required Chiller Equipment Model ID Details for validation From DB -- Method to perform that
	public static int GetModelIdForChillerModel(String chiller_name) 
			throws ClassNotFoundException, SQLException {
		
		if(conn == null){
			getCSDDBSession();
		}else{
			logger.log(LogStatus.PASS, "Connection to CSDDB already exists !!");
		}
		int model_id = 0;
		
		if(chiller_name != null){
			getCSDDBSession();
			Statement statement = conn.createStatement();
	        String queryString = "select ModelId from tblmstmodel where modelname='"+chiller_name+"'";//Point_Group,
	        ResultSet rs = statement.executeQuery(queryString);
	        if(rs.wasNull()){
	        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated !");
	        }
	        else{
	        	logger.log(LogStatus.PASS, "Query Executed Successfully.");
	        }
	        	
	        System.out.println("Query Executed !!");
	        
	        ResultSetMetaData metaData = rs.getMetaData();
	        //int rowIndex = 0;
	        while (rs.next()) {
	            /*for (int i=1; i<=metaData.getColumnCount(); i++) {
	                    System.out.print("  "  + rs.getString(i));
	                    model_id = rs.getString(i).to;*/
	        	model_id = rs.getInt("ModelId");
	            }
	           System.out.println();
		
		}
		else{
			logger.log(LogStatus.FAIL, "Chiller Name Received is NULL");
		}
			
		return model_id;
		
		
	}
	
	
	//Get the Asset Attribute Details -- All the Points Related to the asset
	public static void GetChillerAttributeDetails(int model_id) 
			throws ClassNotFoundException, SQLException {
		
		if(conn == null){
			getCSDDBSession();
		}else{
			logger.log(LogStatus.PASS, "Connection to CSDDB already exists !!");
		}
		
		if(dbPointGroupList.size() > 0) dbPointGroupList.clear();
		if(dbAttributeNameList.size() > 0) dbAttributeNameList.clear();
		if(dbDescriptionList.size() > 0) dbDescriptionList.clear();
		
		if(model_id!=0){
			
			Statement statement = conn.createStatement();
	        String queryString = "select A.Point_Group,A.Attributename,B.Description from dbo.tblAttributeLookup A inner join dbo.tblAssetAttributes B on A.AttributeName=B.AttributeName where A.Model_Id="+model_id+" order by A.Point_Group";//Point_Group,
	        ResultSet rs = statement.executeQuery(queryString);
	        System.out.println("Query Executed !!\n"+queryString);
	        if(rs.wasNull()){
	        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated !");
	        }
	        else{
	        	logger.log(LogStatus.PASS, "Query Executed Successfully.");
	        }
	        
	        while (rs.next()) {

	        	dbPointGroupList.add(rs.getString(1));
	        	dbAttributeNameList.add(rs.getString(2));
	        	dbDescriptionList.add(rs.getString(3));
	        }
	        rs.close();
	        System.out.println("dbPointGroupList : "+dbPointGroupList);
	        System.out.println("dbAttributeNameList : "+dbAttributeNameList);
	        System.out.println("dbDescriptionList : "+dbDescriptionList);
	        
	        
			
		}else{
			logger.log(LogStatus.FAIL, "Value Received for Model ID is NULL");
		}
		
	}
	
	
	//
	
	public void getAssetDetailsForSelectedChiller(String chiller_asset_id)
			throws SQLException, IOException, ClassNotFoundException {
		
		if(conn == null){
			getCSDDBSession();
		}else{
			logger.log(LogStatus.PASS, "Connection to CSDDB already exists !!");
		}
		
		chiller_asset_id_db = chiller_asset_id;
		if(chiller_asset_id != null)
		{
			
			Statement statement = conn.createStatement();
	        String queryString = "select A.pointid,A.name,A.pointname from tblPoint A inner join tblNAEName B on A.NAEId = B.naeid where B.AssetDetailsId="+chiller_asset_id;
	        ResultSet rs = statement.executeQuery(queryString);
	        System.out.println("Query Executed !!\n"+queryString);
	        if(rs.wasNull()){
	        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated !");
	        }
	        else{
	        	logger.log(LogStatus.PASS, "Query to get the PointID and PointName details is Executed Successfully.");
	        }
	        
	        while (rs.next()) {
	        	
	        	dbPointIDList.add(rs.getString(1));
	        	dbNameList.add(rs.getString(2));
	        	dbPointNameList.add(rs.getString(3));
	        }
	        rs.close();
	        System.out.println("dbPointIDList : "+dbPointIDList);
	        System.out.println("dbNameList : "+dbNameList);
	        System.out.println("dbPointNameList : "+dbPointNameList);
			
		}else{
			logger.log(LogStatus.FAIL, "Value Received for Chiller Asset ID is NULL");
		}
		
		
	}
	
	
}
