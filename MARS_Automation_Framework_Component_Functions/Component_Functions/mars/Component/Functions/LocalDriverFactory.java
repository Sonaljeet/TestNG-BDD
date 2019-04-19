/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Component.Functions;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mars.Component.Validator.Routines.UrlValidator;
import mars.Component.Validator.Routines.WindowBuilder;
import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class LocalDriverFactory {
	public static WebDriver driver = null;
	public static WebDriver createInstance(String url,String browserName) {
		WindowBuilder windowBuilder = null;
		try {
			if (browserName.toLowerCase().contains("firefox")) {
				driver = new FirefoxDriver();
				validateURL(driver, url);
				//Resize the current window to specific dimension
				driver.manage().window().setSize(new Dimension(1250,700));
				//windowBuilder = new WindowBuilder(driver, url);
				driver.get(url);
				return driver;
			}
			if (browserName.toLowerCase().contains("ie")) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				File file = new File("Drivers/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
				validateURL(driver, url);
				//Resize the current window to specific dimension
				driver.manage().window().setSize(new Dimension(1250,700));
				//windowBuilder = new WindowBuilder(driver, url);
			    driver.get(url);
				return driver;
			}
			if (browserName.toLowerCase().contains("chrome")) {

				System.setProperty("webdriver.chrome.driver", BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Tests/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			    validateURL(driver, url);
				//Resize the current window to specific dimension
				//driver.manage().window().setSize(new Dimension(1250,700));

			    //windowBuilder = new WindowBuilder(new ChromeDriver(capabilities), url);
			    driver.manage().window().maximize();
			    driver.get(url);
				return driver;
			}
			
			if (browserName.toLowerCase().contains("android")) {
				DesiredCapabilities capabilities = DesiredCapabilities.android();

	    		capabilities.setCapability("chromedriverExecutable", BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Tests/Drivers/chromedriver.exe");
	    		
	    		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
	    		
	    		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
	    		
	    		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

	    		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "33006f8b560fa2dd");//33006f8b560fa2dd
	    		
	    		capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
	    		
	    		URL appium_url = new URL("http://127.0.0.1:4723/wd/hub");
	    		driver = new AndroidDriver(appium_url, capabilities);

				driver.get(url);
				Thread.sleep(15000);
				return driver;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creating browser instance...\n" + e.getMessage());
			e.printStackTrace();
		}
		return driver;
	}
	
	public static MARSDesktopDriver createDesktopInstance(String BaseURL,String browserName) {
		MARSDesktopDriver desktopDriver = null;
		try {
			if (browserName.toLowerCase().contains("desktop")) {
				
				desktopDriver = new MARSDesktopDriver();
				//desktopDriver.marsRun(BaseURL);
				return desktopDriver;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creating browser instance...\n" + e.getMessage());
			e.printStackTrace();
		}
		return desktopDriver;
	}
	private static void validateURL(WebDriver driver, String url)
	{
		if (url == null) throw new NullPointerException("URL must not be Null");
		UrlValidator validate = new UrlValidator(new String[]{"http", "https"});
		if (!validate.isValid(url)) {
			driver.close();
			throw new IllegalArgumentException("Url '" + url + "' is invalid.");
		}
	}
}
