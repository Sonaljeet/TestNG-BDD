package mars.JCI.Project.CEP.SmokeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CEP_Smoke_Database {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

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
	public static String getBranchName(String customer) {
		connectToCEPDDB();
		//connectUATDB();
		String branchName = null;
		String sql = "Select BranchName from AssetDetails where CustomerName = '"+customer+"';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);			
			while (rs.next()) {
				branchName = rs.getString("BranchName");
			}
			return branchName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
