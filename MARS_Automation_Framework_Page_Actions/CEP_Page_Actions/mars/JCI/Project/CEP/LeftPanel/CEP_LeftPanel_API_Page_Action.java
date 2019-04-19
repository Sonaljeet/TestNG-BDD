package mars.JCI.Project.CEP.LeftPanel;

import java.util.List;
import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class CEP_LeftPanel_API_Page_Action extends BaseClass {

	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	@SuppressWarnings("static-access")
	public static String getAccessToken() throws Exception {
		CommonAPIfunctions.POST_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..APICommon.tokenURL"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.authorization"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.headerContentType"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.requestBody"),
				methodName);
		List<String> responseAccessToken = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.accessTokenJsonPath"));
		return responseAccessToken.get(0);
	}
	@SuppressWarnings("static-access")
	public static String getProdAccessToken() throws Exception {
		CommonAPIfunctions.POST_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..ProdAPICommon.tokenURL"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.authorization"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.headerContentType"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.requestBody"),
				methodName);
		List<String> responseAccessToken = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.accessTokenJsonPath"));
		return responseAccessToken.get(0);
	}
	
	@SuppressWarnings("static-access")
	public static String getWebAPIAccessToken() throws Exception {
		CommonAPIfunctions.POST_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..ProdAPICommon.tokenURL"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.headerContentType"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.requestBody1"),
				"methodName");
		List<String> responseAccessToken = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.accessTokenJsonPath"));
		return responseAccessToken.get(0);
		
	}

	@SuppressWarnings("static-access")
	public static List<String> getGeographyListAPI() {
		try {
			String accessToken = getAccessToken();
			CommonAPIfunctions.Get_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..APIBranch.uri"),
					"Bearer " + accessToken,
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

			return ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APIBranch.geographyJsonPath"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("static-access")
	public static List<String> getCountryListAPI() {
		try {
			String accessToken = getAccessToken();
			CommonAPIfunctions.Get_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..APIBranch.uri"),
					"Bearer " + accessToken,
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

			return ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APIBranch.countryJsonPath"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("static-access")
	public static List<String> getBranchListAPI() {

		try {
			String accessToken = getAccessToken();
			CommonAPIfunctions.Get_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..APIBranch.uri"),
					"Bearer " + accessToken,
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

			return ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APIBranch.branchJsonPath"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("static-access")
	public static List<String> getCustomerListAPI() {
		try {
			String accessToken = getAccessToken();
			CommonAPIfunctions.Get_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..APICustomer.uri"),
					"Bearer " + accessToken,
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

			return ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APICustomer.customerNameJsonPath"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("static-access")
	public static List<String> getProjectListAPI() {
		try {
			String accessToken = getAccessToken();
			CommonAPIfunctions.Get_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..APIProject.uri"),
					"Bearer " + accessToken,
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

			return ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APIProject.projectNameJsonPath"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("static-access")
	public static List<String> getAssetListAPI() {
		try {
			String accessToken = getAccessToken();
			CommonAPIfunctions.Get_API_Request(ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..APIAsset.uri"),
					"Bearer " + accessToken,
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

			return ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APIAsset.assetNameJsonPath"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
