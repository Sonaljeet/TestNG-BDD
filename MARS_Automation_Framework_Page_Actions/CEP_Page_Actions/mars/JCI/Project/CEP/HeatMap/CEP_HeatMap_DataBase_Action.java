package mars.JCI.Project.CEP.HeatMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CEP_HeatMap_DataBase_Action {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static void connectUATDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://cepusql.database.windows.net;"
				+ "databaseName=cepuatsqldb;user=jciazdeploy;password=U4LeJdwNTZVEBpSm;";
		try {
			// System.load("C:/Users/jaroraso/Downloads/MicrosoftJDBCDriver6.2forSQLServer/sqljdbc_6.2/enu/auth/x64/sqljdbc_auth.dll");
			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void connectToCEPDDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://cepdsql.database.windows.net;"
				+ "databaseName=cepdsqldb_1.1;user=jciazdeploy;password=bLFJrb5RpcDX9VMH;";
		try {

			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void connectToCEPPDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://ceppsql.database.windows.net;"
				+ "databaseName=ceppsqldb;user=jciazdeploy;password=jpv2Tur5wZpg7SJb;";
		try {

			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int healthCheckTotalGreenCount() {
		//connectUATDB();
		connectToCEPDDB();
		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseHealthStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#006400%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String healthCheckGreenCustomer() {
		//connectUATDB();
		connectToCEPDDB();
		int count = 0;
		String sql = "select ad.CustomerName from AssetDetails ad inner join tblAssetWiseHealthStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#006400%' order by ad.CustomerName;";
		ArrayList<String> customers = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customers.add(rs.getString("CustomerName"));
			}
			return customers.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int greenCountForGeography(String geography) {
		//connectUATDB();
		connectToCEPDDB();
		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseHealthStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#006400%' and ad.GeographyName='"
				+ geography + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greenCountForGeographyStatusCheck(String geography) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#006400%' and ad.GeographyName='"
				+ geography + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int yellowCountForGeographyStatusCheck(String geography) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FFFF00%' and ad.GeographyName='"
				+ geography + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int orangeCountForGeographyStatusCheck(String geography) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FFA500%' and ad.GeographyName='"
				+ geography + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greyCountForGeographyStatusCheck(String geography) {
		//connectUATDB();
		connectToCEPDDB();

		int count1 = 0;
		int count2 = 0;
		String sql1 = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where GeographyName='"
				+ geography + "';";
		String sql2 = "select count(*) as Count from AssetDetails ad left outer join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where GeographyName='"
				+ geography + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			while (rs.next()) {
				count1 = rs.getInt("Count");
			}
			st = con.createStatement();
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				count2 = rs.getInt("Count");
			}
			return count2 - count1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int redCountForGeographyStatusCheck(String geography) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FF0000%' and ad.GeographyName='"
				+ geography + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greenCountForCountryStatusCheck(String country) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#006400%' and ad.CountryName='"
				+ country + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int yellowCountForCountryStatusCheck(String country) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FFFF00%' and ad.CountryName='"
				+ country + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int orangeCountForCountryStatusCheck(String country) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FFA500%' and ad.CountryName='"
				+ country + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greyCountForCountryStatusCheck(String country) {
		//connectUATDB();
		connectToCEPDDB();

		int count1 = 0;
		int count2 = 0;
		String sql1 = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.CountryName='"
				+ country + "';";
		String sql2 = "select count(*) as Count from AssetDetails ad left outer join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.CountryName='"
				+ country + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			while (rs.next()) {
				count1 = rs.getInt("Count");
			}
			st = con.createStatement();
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				count2 = rs.getInt("Count");
			}
			return count2 - count1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int redCountForCountryStatusCheck(String country) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FF0000%' and ad.CountryName='"
				+ country + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greenCountForBranchStatusCheck(String branch) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#006400%' and ad.BranchName='"
				+ branch + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int yellowCountForBranchStatusCheck(String branch) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FFFF00%' and ad.BranchName='"
				+ branch + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int orangeCountForBranchStatusCheck(String branch) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FFA500%' and ad.BranchName='"
				+ branch + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greyCountForBranchStatusCheck(String branch) {
		//connectUATDB();
		connectToCEPDDB();

		int count1 = 0;
		int count2 = 0;
		String sql1 = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.BranchName='"
				+ branch + "';";
		String sql2 = "select count(*) as Count from AssetDetails ad left outer join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.BranchName='"
				+ branch + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			while (rs.next()) {
				count1 = rs.getInt("Count");
			}
			st = con.createStatement();
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				count2 = rs.getInt("Count");
			}
			return count2 - count1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int redCountForBranchStatusCheck(String branch) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "Select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#FF0000%' and ad.BranchName='"
				+ branch + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greenCountForCountry(String country) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseHealthStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#006400%' and ad.CountryName='"
				+ country + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int greenCountForBranch(String branch) {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseHealthStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where aw.colorCode like '%#006400%' and ad.BranchName='"
				+ branch + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String getFirstCustomerName(String columnName, String value) {
		//connectUATDB();
		connectToCEPDDB();

		String customer = null;
		String sql = "select top 1 CustomerName from AssetDetails where " + columnName + "='" + value
				+ "' order by CustomerName;";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customer = rs.getString("CustomerName");
			}
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int statusCheckTotalGreenCount() {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#006400%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int statusCheckTotalYellowCount() {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FFFF00%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int statusCheckTotalRedCount() {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FF0000%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int statusCheckTotalOrangeCount() {
		//connectUATDB();
		connectToCEPDDB();

		int count = 0;
		String sql = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FFA500%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("Count");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int statusCheckTotalGreyCount() {
		//connectUATDB();
		connectToCEPDDB();

		int count1 = 0;
		int count2 = 0;
		String sql1 = "select count(*) as Count from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50));";
		String sql2 = "select count(*) as Count from AssetDetails ad left outer join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50));";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			while (rs.next()) {
				count1 = rs.getInt("Count");
			}
			st = con.createStatement();
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				count2 = rs.getInt("Count");
			}
			return count2 - count1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// Status Check- Get Details for Red Chillers
	public static ResultSet detailsForRedChillers() {
		//connectUATDB();
		connectToCEPDDB();

		String sql = "select top 1 * from AssetDetails ad inner join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FF0000%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check- Get Details for Green Chillers
	public static ResultSet detailsForGreenChillers() {
		connectUATDB();
		//connectToCEPDDB();

		String sql = "select top 1 * from AssetDetails ad inner join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#006400%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check- Get Details for Yellow Chillers
	public static ResultSet detailsForYellowChillers() {
		//connectUATDB();
		connectToCEPDDB();

		String sql = "select top 1 * from AssetDetails ad inner join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FFFF00%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet detailsForOrangeChillers() {
		//connectUATDB();
		connectToCEPDDB();

		String sql = "select top 1 * from AssetDetails ad inner join tblAssetWiseStatus aw on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FFA500%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check- Get Chillers for Customer
	public static List<String> getChillerList(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select AssetName from assetdetails where customername='" + customer + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check- Get Sites for Customer
	public static List<String> getSiteList(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select distinct ProjectName from assetdetails where customername='" + customer + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("ProjectName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-customer list for Red Color
	public static List<String> statusCheckCustomerListJCIRed() {
		//connectUATDB();
		connectToCEPDDB();

		List<String> customerList = new ArrayList<String>();
		String sql = "select distinct CustomerName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FF0000%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customerList.add(rs.getString("CustomerName"));
			}
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-project list for Red Color
	public static List<String> statusCheckProjectListJCIRed(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select distinct ad.ProjectName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#FF0000%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("ProjectName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-asset list for Red Color
	public static List<String> statusCheckAssetListJCIRed(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#FF0000%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static List<String> statusCheckAssetListJCIRed(String customer, String project) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and ad.ProjectName='" + project + "' and aw.colorCode like '%#FF0000%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	// Status Check-customer list for Green Color
	public static List<String> statusCheckCustomerListJCIGreen() {
		//connectUATDB();
		connectToCEPDDB();

		List<String> customerList = new ArrayList<String>();
		String sql = "select distinct CustomerName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#006400%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customerList.add(rs.getString("CustomerName"));
			}
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-project list for Green Color
	public static List<String> statusCheckProjectListJCIGreen(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select distinct ad.ProjectName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#006400%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("ProjectName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-asset list for Green Color
	public static List<String> statusCheckAssetListJCIGreen(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#006400%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> statusCheckAssetListJCIGreen(String customer, String project) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and ad.ProjectName='" + project + "' and aw.colorCode like '%#006400%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-customer list for Yellow Color
	public static List<String> statusCheckCustomerListJCIYellow() {
		//connectUATDB();
		connectToCEPDDB();

		List<String> customerList = new ArrayList<String>();
		String sql = "select distinct CustomerName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FFFF00%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customerList.add(rs.getString("CustomerName"));
			}
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-project list for Yellow Color
	public static List<String> statusCheckProjectListJCIYellow(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select distinct ad.ProjectName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#FFFF00%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("ProjectName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-asset list for Yellow Color
	public static List<String> statusCheckAssetListJCIYellow(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#FFFF00%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> statusCheckAssetListJCIYellow(String customer, String project) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and ad.ProjectName='" + project + "' and aw.colorCode like '%#FFFF00%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-customer list for Orange Color
	public static List<String> statusCheckCustomerListJCIOrange() {
		//connectUATDB();
		connectToCEPDDB();

		List<String> customerList = new ArrayList<String>();
		String sql = "select distinct CustomerName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode like '%#FFA500%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customerList.add(rs.getString("CustomerName"));
			}
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-project list for Orange Color
	public static List<String> statusCheckProjectListJCIOrange(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select distinct ad.ProjectName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#FFA500%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("ProjectName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-asset list for Orange Color
	public static List<String> statusCheckAssetListJCIOrange(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and aw.colorCode like '%#FFA500%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> statusCheckAssetListJCIOrange(String customer, String project) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select ad.AssetName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where ad.customername='"
				+ customer + "' and ad.ProjectName='" + project + "' and aw.colorCode like '%#FFA500%';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-customer list for Grey Color
	public static List<String> statusCheckCustomerListJCIGrey() {
		//connectUATDB();
		connectToCEPDDB();

		List<String> customerList = new ArrayList<String>();
		String sql = "select distinct CustomerName from AssetDetails where CustomerName not in (select CustomerName from tblAssetWiseStatus aw inner join AssetDetails ad on cast(aw.assetid as varchar(50))=cast(ad.AssetId as varchar(50)) where colorCode not like '%#808080%');";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customerList.add(rs.getString("CustomerName"));
			}
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-project list for Grey Color
	public static List<String> statusCheckProjectListJCIGrey(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select distinct ProjectName from AssetDetails where customername='" + customer + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("ProjectName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Status Check-asset list for Grey Color
	public static List<String> statusCheckAssetListJCIGrey(String customer) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select AssetName from AssetDetails where customername='" + customer + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> statusCheckAssetListJCIGrey(String customer, String project) {
		//connectUATDB();
		connectToCEPDDB();

		List<String> chillerList = new ArrayList<String>();
		String sql = "select AssetName from AssetDetails where customername='" + customer + "' and projectname='"
				+ project + "';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillerList.add(rs.getString("AssetName"));
			}
			return chillerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
