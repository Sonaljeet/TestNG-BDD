import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleDB {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	
	public static void connectToDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://M2408785\\JCISQLDATA;" + "databaseName=template_it;integratedSecurity=true";
		try {
			System.load(
					"C:/IntelliTest1/sqljdbc_7.2.1.0_enu/sqljdbc_7.2/enu/auth/x64/sqljdbc_auth.dll");
			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connectToDB();
		int total = 0;
		String sql = "Select SUM((api_pass+api_fail+api_inprogress+web_pass+web_fail+web_inprogress+android_pass+android_fail+android_inprogress+ios_pass+ios_fail+ios_inprogress)) as Total from Dashboard";
		try{
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				total = rs.getInt("Total");
			}
			System.out.println(total);
		}catch(Exception e){
			e.printStackTrace();			
		}

	}

}
