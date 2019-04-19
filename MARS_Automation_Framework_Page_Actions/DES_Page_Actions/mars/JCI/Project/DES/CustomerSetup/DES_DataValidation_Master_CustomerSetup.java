package mars.JCI.Project.DES.CustomerSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DES_DataValidation_Master_CustomerSetup {
	private static ExtentTest logger = null;

	private static DES_CustomerSetup_Page_Factory custSetupPF = null;

	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=DESDB_QA";// ;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password";
																											// //61448
	final static String USER = "jciazdeploy";
	final static String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	public static String CustomerId,CustomerName,Abbreviation,Address_1,Address_2,ContractType;
	public DES_DataValidation_Master_CustomerSetup(ExtentTest logger) {
		this.logger = logger;
	}

	public static void getDES_DBConnection() throws ClassNotFoundException, SQLException {
		// Load SQL-driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Establishing DB Connection with DES_QA DB");
		Connection conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("DB Connection Established");
		logger.log(LogStatus.INFO, "DES_QA DB Connection established successfully");

	}
	
	public static String verifyCustomerName(String customerName) throws SQLException{
		//Create statement object
		Statement stmnt=conn.createStatement();
		//Create Query to be Executed
		String query="select CustomerName from tblCustomer where customer_name = '"+customerName+"'";
		//Create ResultSet Object
		ResultSet res=stmnt.executeQuery(query);
		System.out.println("Query Executed");
		logger.log(LogStatus.INFO, "query to select customer name from customer table executed");
		
		while(res.next()){
			CustomerId=res.getString(1);
			CustomerName=res.getString(2);
			Abbreviation=res.getString(3);
			
		}
		System.out.println("Customer Name for the Seected customer is " +CustomerName);
		System.out.println("Details off Customer are " +CustomerId + CustomerName+ Abbreviation);
		logger.log(LogStatus.PASS, "Customer Name for the selected customer is " + CustomerName);
		
		if (CustomerName == null) {
			
	    	return CustomerName="";
		}
	    else{
	    	return CustomerName;
	    }
	}

}
