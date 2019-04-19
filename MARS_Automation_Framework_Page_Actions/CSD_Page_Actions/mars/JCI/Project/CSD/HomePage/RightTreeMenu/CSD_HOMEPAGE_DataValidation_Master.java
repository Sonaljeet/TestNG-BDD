/**
 * 
 */
package mars.JCI.Project.CSD.HomePage.RightTreeMenu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.JCI.Project.CSD.COMMONS.CSD_COMMONS_DataValidation_Master;

/**
 * @author cdeyso
 *
 */
public class CSD_HOMEPAGE_DataValidation_Master {
	
	
	private static ExtentTest logger = null;
	
	private static CSD_COMMONS_DataValidation_Master csdDataValCommon = null;
	
	public static String IsAdmin,loggedUserDB,UserID = null;
	
	public static List<String> customerNameDBList = new ArrayList<String>();
	public static List<String> customerIDDBList = new ArrayList<String>();
	
	@SuppressWarnings("static-access")
	public CSD_HOMEPAGE_DataValidation_Master(ExtentTest logger) {
		this.logger = logger;
		csdDataValCommon = new CSD_COMMONS_DataValidation_Master(logger);
	}
	
	@SuppressWarnings("static-access")
	public static void validateRightTreeEntriesWithLoggedUser(String loggedUser) 
			throws ClassNotFoundException, SQLException{
		
		loggedUserDB = loggedUser;
		csdDataValCommon.checkDBConnection();
		csdDataValCommon.checkUserAdminOrNot(loggedUserDB);
		UserID = csdDataValCommon.UserID;
		IsAdmin = csdDataValCommon.IsAdmin;
		
		if(IsAdmin.equals("1"))
	    {
			Statement statement = csdDataValCommon.conn.createStatement();
	    	logger.log(LogStatus.INFO, "The Logged In User is an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_admin = "select  Customer_Name as CustomerName,Customer_ID as CustomerId,ColorCode,TripStatus from tblCustomer where IsActive=1  and customer_id in (select distinct B.Customerid  from tblmstproject A inner join tblCustomerUserMapping B on A.BranchId=B.BranchId   and B.CustomerId=A.Customer_Id  where A.IsActive=1)  order by Customer_Name";
		    ResultSet rs_admin = statement.executeQuery(querString_admin);
		    System.out.println("Query Executed !!\n"+querString_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Manitou Option is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_admin.next()) {
		    	customerNameDBList.add(rs_admin.getString(1));
		    	customerIDDBList.add(rs_admin.getString(2));
		    }
		    
		    System.out.println("customerNameDBList "+customerNameDBList);
		    System.out.println("customerIDDBList "+customerIDDBList);
	    	
	    }else if (!IsAdmin.equals("1")) 
	    {

			Statement statement = csdDataValCommon.conn.createStatement();
	    	logger.log(LogStatus.INFO, "The Logged In User is an Admin !");
	    	logger.log(LogStatus.INFO, "Verifying whether the Proper Customer Names are Mapped or not !");
	    	String querString_admin = "select  Customer_Name as CustomerName,Customer_ID as CustomerId,ColorCode,TripStatus from tblCustomer where IsActive=1  and customer_id in (select distinct B.Customerid  from tblmstproject A inner join tblCustomerUserMapping B on A.BranchId=B.BranchId  where B.UserId='"+UserID+"' and B.CustomerId=A.Customer_Id and A.IsActive=1) order by   Customer_Name";
		    ResultSet rs_admin = statement.executeQuery(querString_admin);
		    System.out.println("Query Executed !!\n"+querString_admin);
		    logger.log(LogStatus.INFO, "Query to Check all the Properly mapped Customers according to the Manitou Option is Executed !");
		    //ResultSetMetaData metaData_admin = rs_admin.getMetaData();
		    while (rs_admin.next()) {
		    	customerNameDBList.add(rs_admin.getString(1));
		    	customerIDDBList.add(rs_admin.getString(2));
		    }
		    
		    System.out.println("customerNameDBList "+customerNameDBList);
		    System.out.println("customerIDDBList "+customerIDDBList);
		}
		
		
	}

}
