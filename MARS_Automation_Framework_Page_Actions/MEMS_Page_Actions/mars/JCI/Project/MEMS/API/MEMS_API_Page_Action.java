package mars.JCI.Project.MEMS.API;
import java.text.DecimalFormat;
import java.util.List;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;

public class MEMS_API_Page_Action 
{
	private static ExtentTest logger = null; 
	
	public MEMS_API_Page_Action(ExtentTest logger) {
		this.logger = logger;
	} 
	
	public static String GetPointIDfromValueArray(String Jsonpath,String methodName) throws Exception
	{
		String Point_ID="";
		List<String> ValueArray=ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, CommonAPI_Functions.properties.getProperty("Valuearray_jsonpath"));
		if(ValueArray.size()==0){
			 logger.log(LogStatus.FAIL, "Data for Requested API is not found");
		}
		else
		{
			List<String> Point_IDs=ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, Jsonpath);
			if(Point_IDs.size() > 0)
				{
        			Point_ID = Point_IDs.get(0);
        			if(Point_ID!=null && (!Point_ID.equals(""))&& (!(Point_ID.equals("null"))))
        			{
        				logger.log(LogStatus.PASS, "Point found");
        				logger.log(LogStatus.PASS, "PointID is : "+Point_ID);
        			}
        			else
        			{
        				logger.log(LogStatus.FAIL, "Point is null");
        			}
				}
		}
		 logger.log(LogStatus.PASS, "Execution for "+methodName+ " has Completed");
		 return Point_ID;
	}
	public static String GetvalKeyvalue(String Jsonpath,String methodName) throws Exception
	{
		List<String> json_Data=ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, Jsonpath);
		String lastnodeval="";
		if(json_Data.size() > 0)
		{
			lastnodeval=String.valueOf(json_Data.get((json_Data.size())-1));
			if(lastnodeval!=null &&!(lastnodeval.equals(""))&&!(lastnodeval.equals("null")))
			{
				logger.log(LogStatus.PASS, "Val is not null && "+ "Val is ="+lastnodeval);
			}
			else
			{
				logger.log(LogStatus.FAIL, "Val is null");
			}
		}
		else
		{
			logger.log(LogStatus.FAIL, "Data for Requested API is not found");
		}
		logger.log(LogStatus.PASS, "Execution for "+methodName+ " has Completed");
		return lastnodeval;
	}
	public static long HourlyValAddition(String Jsonpath,String methodName) throws Exception
	{
		List<String> json_Data=ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, Jsonpath);
		int flag=0;
		long valaddition=0L;
		for (int i=0;i<json_Data.size();i++)
		{
			flag=1;
			String node_val = String.valueOf(json_Data.get((json_Data.size())-1));
			if(node_val !=null && (!node_val.equals("")) && (!node_val.equals("null")))
			{
				long nodevalnew=Long.parseLong(node_val);
				valaddition=valaddition+nodevalnew;
			}
		}
		if(flag==0)
		{
			logger.log(LogStatus.FAIL, "Data for Requested API is not found");
		}
		else
		{
			DecimalFormat ninedecmimal = new DecimalFormat("#0.000000000");	
			ninedecmimal.format(valaddition);
			logger.log(LogStatus.PASS, "Hourly Val is not null && "+ "Hourly Val addtion is ="+valaddition);
		}
		logger.log(LogStatus.PASS, "Execution for "+methodName+ " has Completed");
		return valaddition;	
	}	
}