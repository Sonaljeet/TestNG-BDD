/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import org.openqa.selenium.WebElement;

public class WebRadioButton {

	private static Boolean isRadioButtonChecked = false;

	/**
	 * <h1> Checks if radio button is checked </h1><br>
	 *
	 * @param element
	 *            {@link WebElement}
	 * @return true if radio button is checked, otherwise false.
	 */
	public static Boolean isRadioButtonChecked(WebElement element) {
		isRadioButtonChecked = element.isSelected();

		if (isRadioButtonChecked) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * <h1>Select radio button based on the web element name </h1>
	 *<br>
	 * @param element {@link WebElement}
	 * @return 
	 * true if radio button is Selected successfully<br>
	 * false otherwise
	 */
	public static Boolean SelectRadioButton(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			return true;
		} else {
			return false;
		}
	}
}
