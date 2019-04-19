package mars.JCI.Project.MUI.AlarmAnnouncement;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mars.Component.Functions.BaseClass;

public class CEP_Tablet_Login_Test extends BaseClass{
	
//	MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);	
//	MUI_Home_Page_Action homePA;
//	MUI_AlarmAnnouncement_Mobile_Page_Action alarmAnnouncementPA = new MUI_AlarmAnnouncement_Mobile_Page_Action(driver, logger);	
	@Test(priority=0, description="Login - As a CEP User, I can login Succesfully.")
	public void CEPLogin() throws IOException {
		try{
			DesiredCapabilities capabilities = DesiredCapabilities.android();

			capabilities.setCapability("chromedriverExecutable", "C:\\MARS_FRAMEWORK\\Drivers\\chromedriver02.exe");
			
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
			
			capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
			
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "33006f8b560fa2dd");//Mob 33006f8b560fa2dd  //Tab 8a9c5032
			
			capabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
			
			URL url = new URL("http://0.0.0.0:4723/wd/hub");   // 127.0.0.1 In Appium v1.6.5, default localhost is 0.0.0.0
			WebDriver driver = new AndroidDriver(url, capabilities);

			
			
			driver.get("https://cepu-ui.azurewebsites.net");
			logger.log(LogStatus.PASS, "CEP URL Opened Succesfully");  
			
			Thread.sleep(4000);
			
			driver.findElement(By.cssSelector("input[id='username']")).sendKeys("ceuser");
			logger.log(LogStatus.PASS, "User ID Entered succesfully to User Name field.");  
			
			
			driver.findElement(By.cssSelector("input[id='password']")).sendKeys("ceuser");
			logger.log(LogStatus.PASS, "Passsword Entered succesfully to Password Field.");  

			
			driver.findElement(By.cssSelector("button[class='btn pull-right login-button login-group']")).click();
			logger.log(LogStatus.PASS, "SignIN Clicked Successfully");  
			
			Thread.sleep(10000);
			
			if(driver.getTitle().equalsIgnoreCase("Connected Equipment")){
				logger.log(LogStatus.PASS, "CEP Login Title Matched.");  
				getFinalReport(driver, logger, methodName ,	true);
			}else{
				logger.log(LogStatus.FAIL, "CEP Title is not matched.");  
				getFinalReport(driver, logger, methodName ,	false);
			}
			//driver.close();
			
			driver.close();
		} catch (Exception e) {
			//System.out.println(e);
			getFinalReport(driver, logger, methodName ,	false);
			
		}
	}
}

	