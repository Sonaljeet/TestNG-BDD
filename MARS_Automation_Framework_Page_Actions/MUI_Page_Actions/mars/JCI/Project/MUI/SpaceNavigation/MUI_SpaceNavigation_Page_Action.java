package mars.JCI.Project.MUI.SpaceNavigation;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.WebElementCommon;
import commonFunctions.WebLink;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Action;

/**
 * The Class MUI_SpaceNavigation_Page_Action.
 */
public class MUI_SpaceNavigation_Page_Action {
	
	/** The driver. */
	public static WebDriver driver = null;
	
	/** The logger. */
	private static ExtentTest logger = null;
	
	/** The element. */
	private static WebElement element;
	
	/** The elements. */
	private static List<WebElement> elements;
	
	/** The element text. */
	private String elementText;
	
	// Constructor

	/**
	 * Instantiates a new MU I space navigation page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MUI_SpaceNavigation_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	/**
	 * Gets the current space.
	 *
	 * @return the current space
	 */
	public String getCurrentSpace() {
		MUI_SpaceNavigation_Page_Factory spaceNavigationPF = new MUI_SpaceNavigation_Page_Factory(driver);
		element = spaceNavigationPF.getCurrentSpaceMenu();
		if(element!= null){
			elementText = WebElementCommon.getElementText(driver, element, logger);			
			logger.log(LogStatus.PASS, "Get the Current Space Name");   
		}else{
			logger.log(LogStatus.ERROR, "Getting current Space Name is Failed");   
		}
		return elementText;
		
	}
	
	/**
	 * Space header displayed.
	 *
	 * @param spaceHeaderName the space header name
	 * @return true, if successful
	 */
	public static boolean spaceHeaderDisplayed(String spaceHeaderName) {
		MUI_SpaceNavigation_Page_Factory spaceNavigationPF = new MUI_SpaceNavigation_Page_Factory(driver);
		boolean spaceHeaderDisplay = false;
		if(spaceNavigationPF.getSpaceHeader()!=null){
			if(spaceHeaderMatched(spaceHeaderName)!=false)
				spaceHeaderDisplay = true;
		}
		return spaceHeaderDisplay;
    }
	
	/**
	 * Space header matched.
	 *
	 * @param spaceHeaderName the space header name
	 * @return true, if successful
	 */
	public static boolean spaceHeaderMatched(String spaceHeaderName) {
		MUI_SpaceNavigation_Page_Factory spaceNavigationPF = new MUI_SpaceNavigation_Page_Factory(driver);
		boolean spaceHeaderMatch = false;
		element = spaceNavigationPF.getSpaceHeader();
		if(element!=null){
			WebElementCommon.staticWait(1000);
			if(WebElementCommon.getElementText(driver, element, logger).equals(spaceHeaderName)){
				logger.log(LogStatus.PASS, "Page Header - "+element.getText()+" matched with current space selected - "+spaceHeaderName);  
				spaceHeaderMatch = true;
			}else{
				logger.log(LogStatus.FAIL, "Page Header - "+element.getText()+" NOT matched with current space selected - "+spaceHeaderName);   
			}
		}
		return spaceHeaderMatch;
    }

	/**
	 * Navigate to given space by linktext
	 * We need to pass spaceName as a String argument, which will split
	 * Into separate linktext. This method will identify space Name by 
	 * LinkText then clicked if identify
	 *
	 * @param spaceName the space name
	 * @return the MU I home page action
	 */
	public MUI_Home_Page_Action navigateToGivenSpace(String spaceName) {
		String result[] = splitSpace(spaceName);
        for(String space:result){
        	if(WebLink.SendClickToLink(driver, space)!=false){
        		if(spaceHeaderDisplayed(space)!=false)
        			logger.log(LogStatus.PASS, "Successfully Navigated to Space -- "+ space);
        	}
        }
		return new MUI_Home_Page_Action(driver, logger);
    }
	
	public void navigateToSpace(String spaceName) {
		MUI_SpaceNavigation_Page_Factory spaceNavigationPF = new MUI_SpaceNavigation_Page_Factory(driver);
		String result[] = splitSpace(spaceName);
		int resultLength = 1;
        for(String space:result){
        	if(spaceHeaderDisplayed(space)!=false && resultLength<=result.length - 1){
	        	element = spaceNavigationPF.getChildSpaceMenu();
	        	if(element!=null){
		        	if(WebLink.SendClickToLink(driver, element, space)!=false){
		        			logger.log(LogStatus.PASS, "Successfully Navigated to Space -- "+ space);
		        	}
	        	}
        	}
        	resultLength++;
		}
    }
	
	/**
	 * Split Given input into separated space.
	 *
	 * @param text the text
	 * @return the string[]
	 */
	public static String[] splitSpace(String text) {
        java.util.List<String> parts = new java.util.ArrayList<String>();
        String delimiter = "$";
        text += delimiter;

        for (int i = text.indexOf(delimiter), j=0; i != -1;) {
            String temp = text.substring(j,i);
            if(temp.trim().length() != 0) {
                parts.add(temp);
            }
            j = i + delimiter.length();
            i = text.indexOf(delimiter,j);
        }

        return parts.toArray(new String[0]);
    }
	
}
