package mars.JCI.Project.CEP.WebAPI;

import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.getAccessToken;

import org.testng.annotations.Test;

import commonFunctionsAPI.CommonAPI_Functions;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import mars.Component.Functions.BaseClass;

public class CEP_WebAPI_Page_Actions extends BaseClass {
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";

	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest1() throws Exception{
		// TODO Auto-generated method stub
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest2() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest3() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest4() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest5() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest6() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest7() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest8() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest9() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}
	@Test
	@SuppressWarnings("static-access")
	public static void entityLoadTest10() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(8000);
		String url = "https://uat-api.digitalvault.cloud/entity/api/v2.2/models?$select=id,name";
		String accessToken = getAccessToken();
		long start = System.nanoTime();
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", "Bearer " + accessToken).header("org", "connectedequipment.uat")
				.header("content-type", "application/json").header("appname","CE").get(url);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Time in nanoseconds:"+elapsedTime);
		System.out.println("Time in Seconds:"+((double) elapsedTime) / 1E9);
		int statusCode = API_response.getStatusCode();
		System.out.println(statusCode);
		
	}

}
