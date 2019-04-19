/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebBrowser {

	private static boolean SWITCH_STATUS = false;

	/**
	 * Method switches to immediate child window. <br>
	 * Ex : New browser window opened just after login from current browser
	 * window<br>
	 * 
	 * @param driver
	 *            {@link WebDriver}
	 * @return true if child window is switched, false otherwise
	 * 
	 */
	public static boolean SwitchToImmediateChildWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		
		for (String winHandle : allWindowHandles) {
			System.out.println("Window handle is : " +winHandle);
			if (!winHandle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(winHandle);
				SWITCH_STATUS = true;
			}
		}

		return SWITCH_STATUS;
	}
}
