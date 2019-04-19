package mars.JCI.Project.CEP.DailyDataCheckList;

import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.getProdAccessToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class CEP_ChillerWiseDataDelay_Page_Action extends BaseClass {
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);
	private final String FILEPATH = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/ChillerWiseDataDelayReport.xlsx";
	private List<String> attributeName = new ArrayList<String>();

	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public void connectToCEPPDB() {
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

	public ResultSet userFetchedAssetDetails() {
		String sql = "Select AssetId, ProjectId, CustomerName, AssetName, TimezoneName from AssetDetails order by CustomerName;";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("static-access")
	public void getPointID() {
		connectToCEPPDB();
		List<String> assetID = new ArrayList<String>();
		List<String> projectID = new ArrayList<String>();
		List<String> assetName = new ArrayList<String>();
		List<String> customerName = new ArrayList<String>();
		List<String> pointIDE = new ArrayList<String>();
		List<String> timezone = new ArrayList<String>();
		List<String> pointID = new ArrayList<String>();
		ResultSet getAssetDetails = userFetchedAssetDetails();
		String entityURI = null;
		int iRowNumber = 1;
		try {
			while (getAssetDetails.next()) {
				assetID.add(getAssetDetails.getString("AssetId").toLowerCase());
				projectID.add(getAssetDetails.getString("ProjectId").toLowerCase());
				customerName.add(getAssetDetails.getString("CustomerName"));
				assetName.add(getAssetDetails.getString("AssetName"));
				timezone.add(getAssetDetails.getString("TimezoneName"));
			}
			String accessToken = getProdAccessToken();
			int i = 100;
			for (int iCount = 0; iCount < assetID.size(); iCount++) {
				if ((iCount == i) || (iCount == i + 100) || (iCount == i + 200) || (iCount == i + 300)
						|| (iCount == i + 400) || (iCount == i + 500) || (iCount == i + 600) || (iCount == i + 700)
						|| (iCount == i + 800) || (iCount == i + 900) || (iCount == i + 1000) || (iCount == i + 1100)
						|| (iCount == i + 1200) || (iCount == i + 1300) || (iCount == i + 1400) || (iCount == i + 1500)
						|| (iCount == i + 1600) || (iCount == i + 1700) || (iCount == i + 1800) || (iCount == i + 1900)
						|| (iCount == i + 2000) || (iCount == i + 2100) || (iCount == i + 2200) || (iCount == i + 2300)
						|| (iCount == i + 2400) || (iCount == i + 2500) || (iCount == i + 2600) || (iCount == i + 2700)
						|| (iCount == i + 2800) || (iCount == i + 2900) || (iCount == i + 3000) || (iCount == i + 3100)
						|| (iCount == i + 3200) || (iCount == i + 3300) || (iCount == i + 3400) || (iCount == i + 3500)
						|| (iCount == i + 3600) || (iCount == i + 3700) || (iCount == i + 3800)
						|| (iCount == i + 3900)) {
					accessToken = getProdAccessToken();
					connectToCEPPDB();
				}
				entityURI = ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..EntityAPIFiltered.uri1") + "('" + assetID.get(iCount)
						+ "')"
						+ ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.uri2");

				System.out.println(entityURI);
				CommonAPIfunctions.Get_API_Request_TimeSeries(entityURI, "Bearer " + accessToken,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter1"),
						projectID.get(iCount),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter2"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparametervalue2"),
						methodName);
				pointIDE = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.pointID"));
				attributeName = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.attributeName"));
				for (int j = 0; j < attributeName.size(); j++) {
					String name = attributeName.get(j);
					if (name.equalsIgnoreCase("CHWR-T") || name.equalsIgnoreCase("CHWS-T")
							|| name.equalsIgnoreCase("CWS-T") || name.equalsIgnoreCase("CWR-T")
							|| name.equalsIgnoreCase("MOT-FLA") || name.equalsIgnoreCase("FLAMPS1")
							|| name.equalsIgnoreCase("FLAMPS2") || name.equalsIgnoreCase("FLAMPS3")
							|| name.equalsIgnoreCase("FLAMPS4") || name.equalsIgnoreCase("SUC-P4")
							|| name.equalsIgnoreCase("DISC-P1") || name.equalsIgnoreCase("DISC-P2")
							|| name.equalsIgnoreCase("DISC-P3") || name.equalsIgnoreCase("DISC-P4")
							|| name.equalsIgnoreCase("COND-P") || name.equalsIgnoreCase("EVAP-P")) {
						pointID.add(pointIDE.get(j));
					}
					if (pointID.size() >= 16)
						break;
				}
				getTime(pointID, assetName.get(iCount), assetID.get(iCount), projectID.get(iCount), customerName.get(iCount),timezone.get(iCount), iRowNumber);
				pointID.clear();
				iRowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<String> timestamp = new ArrayList<String>();

	@SuppressWarnings("static-access")
	public void getTime(List<String> pointID, String assetName, String assetID, String projectID, String customerName, String timezone, int iRowNumber) {
		String uri = null;
		List<String> time = new ArrayList<String>();
		try {
			String accessToken = getProdAccessToken();
			for (int i = 0; i < pointID.size(); i++) {
				uri = ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.uri1")
						+ pointID.get(i)
						+ ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..DataVerification.uri4")
						+ "Raw" + "&limit=1"
						+ ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..DataVerification.uri5");
				System.out.println(uri);
				CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter1"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparametervalue1"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter2"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparametervalue2"),
						methodName);
				timestamp = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..DataVerification.time"));
				if (timestamp.size() > 0)
					time.add(timestamp.get(0));
			}
			if (time.size() > 0)
				addDataToDB(time, assetID, timezone, assetName,projectID,customerName);
			// updateExcel(time, timezone, iRowNumber);
			else
				addNoDataToDB("No Data", assetID,assetName,projectID,customerName);
			// updateExcelNoData("NoData", iRowNumber);
			iRowNumber++;
			time.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String serverUAT = "13.68.85.191";
	private int port = 8125;

	public void addDataToDB(List<String> timeAPI, String assetID, String timeZone,String assetName,String projectID,String customerName) {
		long max = 0, min = 0;
		long duration = 0;
		boolean flag1 = false;
		long time[] = new long[timeAPI.size()];
		try {
			String s = timeZone.substring(4, 7);
			String utc = utcTime(s);
			String s3 = utc.replace(" ", "T");
			String s4 = s3.concat("Z");
			Instant iTime1 = Instant.parse(s4);
			for (int i = 0; i < timeAPI.size(); i++) {
				String s1 = timeAPI.get(i).substring(0, 19);
				String s2 = s1.concat("Z");
				Instant iTime = Instant.parse(s2);
				duration = Duration.between(iTime, iTime1).toMinutes();
				time[i] = duration;
			}
			Arrays.sort(time);
			max = time[time.length - 1];
			min = time[0];
			if(min>1440){
				flag1=false;
				StatsDClient statsd = new NonBlockingStatsDClient("cepp.jobs.chillerMonitoring."+assetName+"."+assetID+"."+projectID,serverUAT,port);
				statsd.gauge(customerName, min);
			}
			else
				flag1=true;
			String sql = "IF Exists(Select * from AssetWiseDelayDataReport where AssetId = '" + assetID
					+ "') BEGIN Update AssetWiseDelayDataReport set MaxDelayDurationMinutes=" + max
					+ ", MinDelayDurationMinutes=" + min + ",RunDate='" + LocalDate.now() + "',Flag='"+flag1+"' where AssetId = '"
					+ assetID + "' END ELSE BEGIN INSERT INTO AssetWiseDelayDataReport values('" + assetID + "'," + max
					+ "," + min + ",'" + LocalDate.now() + "','"+flag1+"') END;";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNoDataToDB(String s, String assetID,String assetName,String projectID,String customerName) {
		try {
			boolean flag1=false;
			StatsDClient statsd = new NonBlockingStatsDClient("cepp.jobs.chillerMonitoring."+assetName+"."+assetID+"."+projectID,serverUAT,port);
			statsd.gauge(customerName, 0);
			String sql = "IF Exists(Select * from AssetWiseDelayDataReport where AssetId = '" + assetID
					+ "' ) BEGIN Update AssetWiseDelayDataReport set MaxDelayDurationMinutes=NULL, MinDelayDurationMinutes=NULL,RunDate='"
					+ LocalDate.now() + "',Flag='"+flag1+"' where AssetId = '" + assetID
					+ "' END ELSE BEGIN INSERT INTO AssetWiseDelayDataReport values('" + assetID + "',NULL,NULL,'"
					+ LocalDate.now() + "','"+flag1+"') END;";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateExcelNoData(String s, int iRowNumber) {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell maxDelay, minDelay, runTime;
		Sheet sheet;
		try {
			ZipSecureFile.setMinInflateRatio(0);
			fis = new FileInputStream(FILEPATH);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");
			row = sheet.getRow(iRowNumber);
			maxDelay = row.createCell(4);
			maxDelay.setCellValue(s);
			minDelay = row.createCell(5);
			minDelay.setCellValue(s);
			runTime = row.createCell(6);
			runTime.setCellValue(LocalDate.now().toString());
			FileOutputStream fos = new FileOutputStream(FILEPATH);
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String utcTime(String timezone) {
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		if (timezone.contains("-"))
			cal.add(Calendar.HOUR, -Integer.parseInt(timezone.substring(2)));
		else
			cal.add(Calendar.HOUR, +Integer.parseInt(timezone.substring(2)));
		currentDate = cal.getTime();
		return currentDateFormat.format(currentDate);
	}

	public void updateExcel(List<String> timeAPI, String timeZone, int iRowNumber) {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		long max = 0, min = 0;
		Cell maxDelay, minDelay, runTime;
		Sheet sheet;
		long duration = 0;
		long time[] = new long[timeAPI.size()];
		try {
			String s = timeZone.substring(4, 7);
			String utc = utcTime(s);
			String s3 = utc.replace(" ", "T");
			String s4 = s3.concat("Z");
			Instant iTime1 = Instant.parse(s4);
			for (int i = 0; i < timeAPI.size(); i++) {
				String s1 = timeAPI.get(i).substring(0, 19);
				String s2 = s1.concat("Z");
				Instant iTime = Instant.parse(s2);
				duration = Duration.between(iTime, iTime1).toMinutes();
				time[i] = duration;
			}
			Arrays.sort(time);
			max = time[time.length - 1];
			min = time[0];
			ZipSecureFile.setMinInflateRatio(0);
			fis = new FileInputStream(FILEPATH);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");
			row = sheet.getRow(iRowNumber);
			maxDelay = row.createCell(4);
			maxDelay.setCellValue(max);
			minDelay = row.createCell(5);
			minDelay.setCellValue(min);
			runTime = row.createCell(6);
			runTime.setCellValue(LocalDate.now().toString());
			FileOutputStream fos = new FileOutputStream(FILEPATH);
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
