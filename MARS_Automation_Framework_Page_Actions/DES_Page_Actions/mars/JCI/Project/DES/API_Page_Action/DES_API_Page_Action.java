package mars.JCI.Project.DES.API_Page_Action;

import java.util.List;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.xml.internal.fastinfoset.util.ValueArray;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;

public class DES_API_Page_Action {
	private static ExtentTest logger = null;

	public DES_API_Page_Action(ExtentTest logger) {
		this.logger = logger;
	}

	public String GetPointIDfromValueArray(String jsonPath, String methodName) {
		String POINT_ID = "";
		List<String> valueArray = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
				CommonAPI_Functions.properties.getProperty("Valuearray_jsonpath"));
		if (valueArray.size() == 0) {
			logger.log(LogStatus.FAIL, "Data for requested API does not found");
		} else {
			List<String> POINT_IDs = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, jsonPath);
			POINT_ID = POINT_IDs.get(0);
			System.out.println(POINT_ID = POINT_IDs.get(0));
			if (!POINT_ID.equals("") && !POINT_ID.equals("null")) {
				logger.log(LogStatus.PASS, "Point found");
				logger.log(LogStatus.PASS, "PointID is : " + POINT_ID);
			} else {
				logger.log(LogStatus.FAIL, "Point is null");
			}
		}
		logger.log(LogStatus.PASS, "Execution for "+methodName+ " has Completed");
		return POINT_ID;
	}
	
	public String getPointValueFromTimeSeries(String jsonPath, String methodName){
		String SOC_val="";
		List<String> jsonData= ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, jsonPath);
		int flag=0;
		for(int i=0;i<=jsonData.size()-1;i++){
			flag=1;
			SOC_val = String.valueOf(jsonData.get((jsonData.size())-1));
			if(SOC_val !=null && (!SOC_val.equals("")) && (!SOC_val.equals("null")))
			{
				logger.log(LogStatus.PASS, "Value received from timeSeries is "+SOC_val);
			}else{
				logger.log(LogStatus.FAIL, "Data for Requested API is not found");
			}
		}
		
		return SOC_val;
		
	}
	
	

}
