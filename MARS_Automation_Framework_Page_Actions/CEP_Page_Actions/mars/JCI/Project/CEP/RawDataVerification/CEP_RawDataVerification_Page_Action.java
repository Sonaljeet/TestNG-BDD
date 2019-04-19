package mars.JCI.Project.CEP.RawDataVerification;

import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.getProdAccessToken;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.RunHoursVerification.CEP_RunHours_DataBase;

public class CEP_RawDataVerification_Page_Action extends BaseClass {

	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	@SuppressWarnings("static-access")
	public void validateRawData() {
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		List<String> assetName = new ArrayList<String>();
		List<String> assetID = new ArrayList<String>();
		List<String> projectID = new ArrayList<String>();
		List<String> pointID = new ArrayList<String>();
		List<String> attributeName = new ArrayList<String>();
		List<String> timeStamp = new ArrayList<String>();
		int statusCode = 0;
		try {
			CEP_RunHours_DataBase objD = new CEP_RunHours_DataBase();
			ResultSet rs = null;
			rs = objD.userFetchedAssetDetailsForRawData();
			while (rs.next()) {
				customerName.add(rs.getString("CustomerName"));
				projectName.add(rs.getString("ProjectName"));
				assetName.add(rs.getString("AssetName"));
				assetID.add(rs.getString("AssetID").toLowerCase());
				projectID.add(rs.getString("ProjectID").toLowerCase());
			}
			String accessToken = null;
			String entityURI = null;
			String uri = null;
			for (int iCount = 1616; iCount < 1617; iCount++) {
				System.out.println("iCount" + iCount);
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
				pointID = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.pointID"));
				attributeName = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.attributeName"));
				for (int i = 0; i < pointID.size(); i++) {
					if ((attributeName.get(i).contains("CHWR-T")) || (attributeName.get(i).contains("CHWS-T"))) {
						uri = ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..DataVerification.uri1")
								+ pointID.get(i)
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri2")
								+ "2018-12-20 00:00:00"
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri3")
								+ "2018-12-21 23:59:59"
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri4")
								+ "Raw"
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri5");
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
						statusCode = CommonAPIfunctions.responseCode;
						if(statusCode!=200){
							CEP_RunHours_DataBase.addDataToRawDataTable(customerName.get(iCount), projectName.get(iCount),
									assetName.get(iCount), assetID.get(iCount), pointID.get(i), attributeName.get(i),-statusCode);
						}
						else{
							timeStamp = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..timestamp");
							CEP_RunHours_DataBase.addDataToRawDataTable(customerName.get(iCount), projectName.get(iCount),
									assetName.get(iCount), assetID.get(iCount), pointID.get(i), attributeName.get(i),timeStamp.size());
						}
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
