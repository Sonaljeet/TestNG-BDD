package mars.JCI.Project.CEP.LeftPanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CEP_LeftPanel_DataBase_Action {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

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

	public static ArrayList<String> geographyListDB() {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select distinct GeographyName from AssetDetails order by GeographyName desc;";
		ArrayList<String> geographies = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				geographies.add(rs.getString("GeographyName"));
			}
			return geographies;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<String> countryListDB() {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select distinct CountryName from AssetDetails;";
		ArrayList<String> countries = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				countries.add(rs.getString("CountryName"));
			}
			return countries;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<String> branchListDB() {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select distinct BranchName from AssetDetails order by branchName asc;";
				//"select distinct BranchName from AssetDetails where BranchName in ('Abu Dhabi Service','ADELAIDE')";
//				"Select distinct BranchName from AssetDetails order by branchName asc;";
		ArrayList<String> branches = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				branches.add(rs.getString("BranchName"));
			}
			return branches;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<String> customerListDB() {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select distinct CustomerName from AssetDetails order by CustomerName;";
				//"select distinct CustomerName from AssetDetails where BranchName in ('Abu Dhabi Service','ADELAIDE')";
//				"Select distinct CustomerName from AssetDetails order by CustomerName;";
		ArrayList<String> customers = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customers.add(rs.getString("CustomerName"));
			}
			return customers;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static ArrayList<String> customerListDB(String branchName) {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select distinct CustomerName from AssetDetails where BranchName='"+branchName+"' order by CustomerName;";
		ArrayList<String> customers = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				customers.add(rs.getString("CustomerName"));
			}
			return customers;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<String> siteListDB() {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select distinct ProjectName from AssetDetails order by ProjectName;";
				//"select distinct ProjectName from AssetDetails where BranchName in ('Abu Dhabi Service','ADELAIDE') and CustomerName in ('AL AIN UNIVERSITY','CENTRO ARNDALE','HAMPSTEAD HOSPITAL','PLAYFORD NORTH','SPORT PARK 2','STAMFORD PLAZA')"; 
//				"Select distinct ProjectName from AssetDetails order by ProjectName;";
		ArrayList<String> sites = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				sites.add(rs.getString("ProjectName"));
			}
			return sites;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static ArrayList<String> siteListDB(String customer) {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select distinct ProjectName from AssetDetails where CustomerName='"+customer+"';";
		ArrayList<String> sites = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				sites.add(rs.getString("ProjectName"));
			}
			return sites;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public static ArrayList<String> chillerListDB() {
	connectToCEPDDB();
		//connectUATDB();
		String sql ="Select distinct AssetName from AssetDetails order by AssetName;";
//				"select distinct AssetName from AssetDetails where BranchName in ('Abu Dhabi Service','ADELAIDE') and CustomerName in ('AL AIN UNIVERSITY','CENTRO ARNDALE','HAMPSTEAD HOSPITAL','PLAYFORD NORTH','SPORT PARK 2','STAMFORD PLAZA') and ProjectName in ('AL AIN UNIVERSITY','CENTRO ARNDALE','HAMPSTEAD HOSPITAL','PLAYFORD NORTH','SPORT PARK 2','STAMFORD PLAZA')"; 
//				"Select distinct AssetName from AssetDetails order by AssetName;";
		ArrayList<String> chillers = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillers.add(rs.getString("AssetName"));
			}
			return chillers;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static ArrayList<String> chillerListDB(String customer) {
	connectToCEPDDB();
		//connectUATDB();
		String sql ="Select distinct AssetName from AssetDetails where CustomerName='"+customer+"';";
//				"select distinct AssetName from AssetDetails where BranchName in ('Abu Dhabi Service','ADELAIDE') and CustomerName in ('AL AIN UNIVERSITY','CENTRO ARNDALE','HAMPSTEAD HOSPITAL','PLAYFORD NORTH','SPORT PARK 2','STAMFORD PLAZA') and ProjectName in ('AL AIN UNIVERSITY','CENTRO ARNDALE','HAMPSTEAD HOSPITAL','PLAYFORD NORTH','SPORT PARK 2','STAMFORD PLAZA')"; 
//				"Select distinct AssetName from AssetDetails order by AssetName;";
		ArrayList<String> chillers = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				chillers.add(rs.getString("AssetName"));
			}
			return chillers;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String branchNameForUS(){
	connectToCEPDDB();
		//connectUATDB();
		String sql ="select distinct BranchName from AssetDetails where CountryName='United States' order By BranchName;";
//				"select distinct AssetName from AssetDetails where BranchName in ('Abu Dhabi Service','ADELAIDE') and CustomerName in ('AL AIN UNIVERSITY','CENTRO ARNDALE','HAMPSTEAD HOSPITAL','PLAYFORD NORTH','SPORT PARK 2','STAMFORD PLAZA') and ProjectName in ('AL AIN UNIVERSITY','CENTRO ARNDALE','HAMPSTEAD HOSPITAL','PLAYFORD NORTH','SPORT PARK 2','STAMFORD PLAZA')"; 
//				"Select distinct AssetName from AssetDetails order by AssetName;";
		ArrayList<String> branch = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				branch.add(rs.getString("BranchName"));
			}
			return branch.get(0);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public static ResultSet getRecordsForCustomer(String customerName) {
	connectToCEPDDB();
		//connectUATDB();
		String sql = "Select * from AssetDetails where CustomerName = '"+customerName+"';";
				//"select distinct CustomerName from AssetDetails where BranchName in ('Abu Dhabi Service','ADELAIDE')";
//				"Select distinct CustomerName from AssetDetails order by CustomerName;";
		ArrayList<String> customers = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
