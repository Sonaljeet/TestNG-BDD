package mars.JCI.Project.DES.COMMONS;
/**
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class DES_COMMONS_ValidationMethods {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	@SuppressWarnings("static-access")
	public DES_COMMONS_ValidationMethods(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	//Get a Random Number between a provided range for further Random Cross Testing.
	public static int getRamdomNoBetweenRange(int min,int max) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}

	// To Select the specified textfrom the drop Down
	public static void selectByVisibleText(WebElement element, String text) {

		try {
			System.out.println("element " + element + "text " + text);
			new Select(element).selectByVisibleText(text);
			System.out.println(text.toUpperCase() + " Option is Selected");
			logger.log(LogStatus.INFO, text.toUpperCase() + " Option is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
		}
	}

	// To Select the specified textfrom the drop Down
	public static void selectByDesiredIndex(WebElement element, int index) {

		try {
			System.out.println("element " + element + "index " + index);
			new Select(element).selectByIndex(index);
			System.out.println("Option No." + index + " is Selected");
			logger.log(LogStatus.INFO, "Option No." + index + " is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
		}
	}

	// To get all the Values under a dropdown
	public static List<String> getAllOptions(WebElement element) {
		List<String> options = new ArrayList<String>();
		for (WebElement option : new Select(element).getOptions()) {
			String txt = option.getText();
			if (option.getAttribute("value") != "")
				options.add(option.getText());
		}
		return options;
	}

	// Get Selected Option From DropDown
	public static String getSelectedOptionFromDropDown(WebElement element) {

		Select sel_element_Val = new Select(element);
		String element_Val_text = sel_element_Val.getFirstSelectedOption().getText();
		return element_Val_text;
	}

}
