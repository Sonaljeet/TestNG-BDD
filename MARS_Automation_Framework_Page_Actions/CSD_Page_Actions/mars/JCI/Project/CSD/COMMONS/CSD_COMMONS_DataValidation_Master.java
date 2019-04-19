/**
 * 
 */
package mars.JCI.Project.CSD.COMMONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class CSD_COMMONS_DataValidation_Master {
	
	private static ExtentTest logger = null;
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public static String branch_id,UserID,RoleID,IsAdmin,loggedUserApp,selectedCustomerID = null;
	
	@SuppressWarnings("static-access")
	public CSD_COMMONS_DataValidation_Master(ExtentTest logger) {
		this.logger = logger;
	}
	
	public static void getCSDDBSession() 
			throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		System.out.println("Establishing Connection to CSDDB !!");
		//logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
	}
	
	public static void checkDBConnection() 
			throws ClassNotFoundException, SQLException {
		
		if (conn == null) {
			logger.log(LogStatus.INFO, "Establishing Connection to CSDDB !!");
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "Connection to CSD DB Already Exists");
		}
		
	}
	
	public static void checkUserAdminOrNot(String loggedUser) 
			throws SQLException, ClassNotFoundException {
		
		checkDBConnection();		
				
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
	    
	    //return IsAdmin;
	    
	}

}
