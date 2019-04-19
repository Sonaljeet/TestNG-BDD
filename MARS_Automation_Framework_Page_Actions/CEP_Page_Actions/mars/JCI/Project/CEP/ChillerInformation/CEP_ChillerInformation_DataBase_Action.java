package mars.JCI.Project.CEP.ChillerInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CEP_ChillerInformation_DataBase_Action {
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
	
	public static ResultSet getAssetandProjectID(String customer, String chiller) {
		//connectUATDB();
		connectToCEPDDB();
		String sql = "Select AssetID, ProjectID from AssetDetails where CustomerName='"+customer+"' and AssetName='"+chiller+"';";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public static List<String> getAssetList(String project) {
		//connectUATDB();
		connectToCEPDDB();
		String sql = "select AssetName from AssetDetails where ProjectName='"+project+"';";
		List<String> assetList = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				assetList.add(rs.getString("AssetName"));
			}
			return assetList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
