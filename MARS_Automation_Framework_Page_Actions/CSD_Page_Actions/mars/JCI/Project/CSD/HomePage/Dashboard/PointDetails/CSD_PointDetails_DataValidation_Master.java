package mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class CSD_PointDetails_DataValidation_Master {
	
	private static ExtentTest logger = null;
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;

	public static int model_id=0;
	
	public static String chiller_name_db = null;
	
	public static List<String> db_PointGroup = new ArrayList<String>();
	public static List<String> db_AttributeName = new ArrayList<String>();
	public static List<String> db_Description = new ArrayList<String>();
	public static List<String> db_PointGroupCategories = new ArrayList<String>();
	
	@SuppressWarnings("static-access")
	public CSD_PointDetails_DataValidation_Master(ExtentTest logger) {
		this.logger = logger;
	}
	
	
	public static void getCSDDBSession() 
			throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		System.out.println("Establishing Connection to CSDDB !!");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
		
		
	}
	
	//Get the Required Chiller Equipment Model ID Details for validation From DB -- Method to perform that
	public static int GetModelIdForChillerModel(String chiller_name) throws ClassNotFoundException, SQLException {
		
		if(conn == null){
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "CSD DB Connection already exists.");
		}
	
		chiller_name_db = chiller_name;
		//int model_id = 0;
		if(chiller_name != null){
		
		Statement statement = conn.createStatement();
        String queryString = "select ModelId from tblmstmodel where modelname='"+chiller_name+"'";//Point_Group,
        ResultSet rs = statement.executeQuery(queryString);
        if(rs.wasNull()){
        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated !");
        }
        else{
        	logger.log(LogStatus.PASS, "Query Executed Successfully.");
        	System.out.println("Query Executed !!\n"+queryString);
        }
        	
        
        
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
	
	//Get the Required Chiller Attribute Details from the Model ID for validation From DB -- Method to perform that
	public void GetChillerAttributeDetails() 
			throws SQLException {
		
		if(db_PointGroup.size() > 0)db_PointGroup.clear();
		if(db_AttributeName.size() > 0)db_AttributeName.clear();
		if(db_Description.size() > 0)db_Description.clear();
		
		if (model_id != 0){
			
		System.out.println("Inside GetChillerAttributeDetails MEthod!");
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
        ResultSetMetaData metaData = rs.getMetaData();
        int index = 1;
        while (rs.next()) {

        	 for (int i=1; i<=metaData.getColumnCount(); i++) {
                 System.out.print("  "  + rs.getString(i));
                 db_PointGroup.add(rs.getString(1));
                 db_AttributeName.add(rs.getString(2));
                 db_Description.add(rs.getString(3));
                
         }
         System.out.println();
        }
        
        System.out.println("Chiller Attribute Data is saved in Local Variables.");
        logger.log(LogStatus.INFO, "Chiller Attribute Data is saved in Local Variables.");
        rs.close();
        
        String queryString_2 = "select distinct(A.Point_Group) from dbo.tblAttributeLookup A inner join dbo.tblAssetAttributes B on A.AttributeName=B.AttributeName where A.Model_Id="+model_id+" order by A.Point_Group";
        ResultSet rs_2 = statement.executeQuery(queryString_2);
        System.out.println("Query Executed !!\n"+queryString_2);
        ResultSetMetaData metaData_2 = rs_2.getMetaData();
        while (rs_2.next()) {
        	 for (int i=1; i<=metaData_2.getColumnCount(); i++) {
                 System.out.print("  "  + rs_2.getString(i));
                 db_PointGroupCategories.add(rs.getString(1));
                
         }
         System.out.println();
        }
        System.out.println("Point Categories are saved in the local Variables.");
        logger.log(LogStatus.PASS, "Point Categories are saved in the local Variables.");
        rs_2.close();
        
        
		}
		else{
			logger.log(LogStatus.FAIL, "Model ID is received is NULL");
		}
        
	}
	
	
	//DataBase Validations for the Chiller Points to be mapped. -- After SCC DataImport changes are done.
	//TO DO -- 
	/*public void validatePointsSubCategoryWithDB(String chiller_att_id, String point_header,String point_sub_category) 
			throws BiffException, IOException, SQLException{
		
		System.out.println("Inside validatePointsSubCategoryWithDB Method !");
		
		File inputWorkbook = new File(project_dir+"\\PointAttributeDetails.xls");
		Workbook workbook = Workbook.getWorkbook(inputWorkbook);
		Sheet points_sheet = workbook.getSheet(2);
		String chiller_asset_id = points_sheet.getCell(3,1).getContents();
		System.out.println(chiller_asset_id);
		Statement statement = conn.createStatement();
        String queryString = "select distinct (D.Point_Category_Name),F.Description from tblPoint A inner join tblNAEName B on A.NAEId = B.naeid inner join tblpointcategoryrelation C on C.pointid=A.pointId inner join tblpointcategory D on D.Point_Category_ID=C.PointCategoryID inner join tblselpoint E on E.pointid=A.pointid inner join tblassetattributes F on F.AssetAttributesId=E.AssetAttributesId where B.AssetDetailsId="+chiller_asset_id+" and Point_Category_Name= '"+point_header+"' and Description='"+point_sub_category.toUpperCase()+"'";
        ResultSet rs = statement.executeQuery(queryString);
        System.out.println("Query to get the Point Sub Category for the Point Header Category is Executed !!");
        logger.log(LogStatus.PASS, "Query to get the Point Sub Category for the Point Header Category is Executed !!");
        if(rs.wasNull()){
        	logger.log(LogStatus.FAIL, "The Selected Point SubCategory is not Valid");
        }
        else{
        	logger.log(LogStatus.PASS, "Point SubCategory : "+point_sub_category+" is a Valid SubCategory for Point Header : "+point_header);
        }
        
        workbook.close();
        rs.close();
	}*/
}
