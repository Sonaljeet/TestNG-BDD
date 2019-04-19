package mars.JCI.Project.CEP.RunHoursVerification;

import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.getProdAccessToken;
import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class CEP_RunHours_Page_Action extends BaseClass {
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	@SuppressWarnings("static-access")
	public void getAttributeID() {
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		List<String> assetName = new ArrayList<String>();
		List<String> assetID = new ArrayList<String>();
		List<String> projectID = new ArrayList<String>();
		List<String> attributeID = new ArrayList<String>();
		List<String> attributeName = new ArrayList<String>();
		String entityURI = null;
		CEP_RunHours_DataBase objD = new CEP_RunHours_DataBase();
		ResultSet rs = null;
		try {
			rs = objD.userFetchedAssetDetails();
			while (rs.next()) {
				customerName.add(rs.getString("CustomerName"));
				projectName.add(rs.getString("ProjectName"));
				assetName.add(rs.getString("AssetName"));
				assetID.add(rs.getString("AssetID").toLowerCase());
				projectID.add(rs.getString("ProjectID").toLowerCase());
			}
			String accessToken = null;
			String accessToken1 = null;
			for (int iCount = 0; iCount < assetID.size(); iCount++) {
				accessToken = getProdAccessToken();

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
				attributeName = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.attributeName"));
				attributeID = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.id"));
				accessToken1 = getWebAPIAccessToken();
				for (int k = 0; k < attributeName.size(); k++) {
					if ((attributeName.get(k).contains("RUN-HRS1")) || (attributeName.get(k).contains("RUN-HRS2"))
							|| (attributeName.get(k).contains("RUN-HRS3"))
							|| (attributeName.get(k).contains("RUN-HRS4"))
							|| (attributeName.get(k).contains("ACC OP HRS"))) {
						getAPIFalseData(accessToken1, customerName.get(iCount),projectName.get(iCount),assetName.get(iCount),assetID.get(iCount), attributeID.get(k));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public void getAPIFalseData(String accessToken, String customerName,String projectName,String assetName,String assetID, String attributeID) {
		List<Double> dailyDeltaValue = new ArrayList<Double>();
		List<Double> rawDataValue = new ArrayList<Double>();
		List<String> isDailyDelta = new ArrayList<String>();
		List<String> isRawData = new ArrayList<String>();
		List<Boolean> isEqual = new ArrayList<Boolean>();
		List<String> date = new ArrayList<String>();
		try {
			String url = "https://cepu-web-api.azurewebsites.net/api/AssetEntity/GetRawAndDailyComparedResult";
			String requestBody = "AssetId=" + assetID + "&attributeId=" + attributeID
					+ "&fromDate=2018-10-01 00:00:00&toDate=2018-12-26 23:59:59";
			CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/x-www-form-urlencoded",
					requestBody, methodName);
			date = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..dateTime");
			isEqual = ReadJsonFile.readJsonFileDynamicBoolean(CommonAPI_Functions.FILENAME, "$..isEqual");
			isRawData = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..isRawData");
			isDailyDelta = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..isDailyDeltaData");
			rawDataValue = ReadJsonFile.readJsonFileDynamicDouble(CommonAPI_Functions.FILENAME, "$..rawDataValue");
			dailyDeltaValue = ReadJsonFile.readJsonFileDynamicDouble(CommonAPI_Functions.FILENAME, "$..dailyDataValue");
			for (int i = 0; i < isEqual.size(); i++) {
				CEP_RunHours_DataBase.addDataToTable(customerName,projectName,assetName,assetID, attributeID, dailyDeltaValue.get(i), rawDataValue.get(i),
						isDailyDelta.get(i), isRawData.get(i), isEqual.get(i), date.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// logger.log(LogStatus.ERROR, "No proper response received from
			// API.");
		}

	}
}
