/**
 * 
 */
package mars.JCI.Project.CSD.SSF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * @author cdeyso
 * mars.JCI.Project.CSD.SSF.CSD_SSF_DeleteForm_Master
 *
 */
public class CSD_SSF_DeleteForm_Master {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	public static CSD_SSF_SSFGrid_Page_Action ssfGridPA = null;
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public CSD_SSF_DeleteForm_Master(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		ssfGridPA = new CSD_SSF_SSFGrid_Page_Action(driver, logger);
	}
	
	public static void getCSDDBSession() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Establishing Connection to CSDDB !!");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
		
		
	}

	@SuppressWarnings("static-access")
	public static void deleteFormIDAfterValidationComplete() 
			throws ClassNotFoundException, SQLException {
		
		if(conn==null){
			getCSDDBSession();
		}else{
			logger.log(LogStatus.INFO, "Connection to CSDDB is already open !!");
		}
		
		String deleFormID = ssfGridPA.formID;
		//getCSDDBSession();
		//Statement statement = conn.createStatement();
		//PreparedStatement statement = conn.prepareStatement(arg0);
		if (deleFormID!=null) {
			String queryString = "DELETE FROM ssf_tblssfdetails WHERE SsfDetailsId = '" + deleFormID + "'";
			PreparedStatement statement = conn.prepareStatement(queryString);
			System.out.println("Query Executed !!\n" + queryString);
			//statement.executeQuery(queryString);
			ResultSet rs = null;
			try {
				rs = statement.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				logger.log(LogStatus.INFO,
						"Required Fom ID is already deleted. Form ID is : " + deleFormID);
			}
			if(rs == null){
				logger.log(LogStatus.INFO,
					"Required Form is deleted after all the validations is complete. Form ID is : " + deleFormID);
			}
		}else{
			logger.log(LogStatus.INFO,
					"Required Fom ID does not exist. Form ID is : " + deleFormID);
		}
	    
	}

}
