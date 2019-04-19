package mars.JCI.Project.CEP.Login;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebInputTextBox;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

import static mars.Component.Functions.BaseClass.projectPropertiesFile;

public class CEP_Login_Page_Action{

	private static WebDriver driver;
	private static ExtentTest logger;
	public String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";

	@SuppressWarnings("static-access")
	public CEP_Login_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	// CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);

	@Given("^user is on CEP login page$")
	public void validateLoginPage() throws Exception {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		// driver.get("http://cepu-ui.azurewebsites.net/");
		if (objLogin.getUserName() != null) {
			if (objLogin.getUserName().isDisplayed()) {
				logger.log(LogStatus.PASS, "Login Page loaded");
			}
		} else {
			logger.log(LogStatus.FAIL, "User not on login page");
		}
	}

	@When("^user enters admin username and password$")
	public void enterAdminCredential() throws Exception {

		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		if (objLogin.getUserName() != null) {
			if (objLogin.getUserName().isDisplayed()) {
				WebInputTextBox.watermarkedTextMatch(driver, logger, objLogin.getUserName(), "Username");
				// objLogin.getUserName().clear();
				System.out.println(ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..AdminLogin.username"));
				WebInputTextBox.SendInputTextBox(driver, objLogin.getUserName(),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..AdminLogin.username"));
				// logger.log(LogStatus.PASS, "User ID Entered succesfully to
				// User Name WebElement");
			}
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");
		}
		if (objLogin.getPassWord() != null) {
			if (objLogin.getPassWord().isDisplayed()) {
				WebInputTextBox.watermarkedTextMatch(driver, logger, objLogin.getPassWord(), "Username");
				// objLogin.getPassWord().clear();
				WebInputTextBox.SendInputTextBox(driver, objLogin.getPassWord(),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..AdminLogin.password"));
				// logger.log(LogStatus.PASS, "Password Entered succesfully to
				// Password WebElement");
			}
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");
		}

	}

	@When("^user enters local user username and password$")
	public void enterNaUserCredential() throws Exception {

		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		if (objLogin.getUserName() != null) {
			if (objLogin.getUserName().isDisplayed()) {
				WebInputTextBox.watermarkedTextMatch(driver, logger, objLogin.getUserName(), "Username");
				objLogin.getUserName().clear();
				WebInputTextBox.SendInputTextBox(driver, objLogin.getUserName(),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..UserLogin.username"));
				logger.log(LogStatus.PASS, "User ID Entered succesfully to User Name WebElement");
			}
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");
		}
		if (objLogin.getPassWord() != null) {
			if (objLogin.getPassWord().isDisplayed()) {
				WebInputTextBox.watermarkedTextMatch(driver, logger, objLogin.getPassWord(), "Username");
				objLogin.getPassWord().clear();
				WebInputTextBox.SendInputTextBox(driver, objLogin.getPassWord(),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..UserLogin.password"));
				logger.log(LogStatus.PASS, "Password Entered succesfully to Password WebElement");
			}
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");
		}

	}

	public boolean verifyLogInEnabled() throws Exception {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		boolean verifyLogInEnabled = false;
		if (objLogin.getButton() != null) {
			if (objLogin.getButton().isEnabled()) {
				verifyLogInEnabled = true;
				// logger.log(LogStatus.PASS, "Verified Log In Is Enabled before
				// clicking");
			} else {
				logger.log(LogStatus.FAIL, "Verified Log In Is NOT Enabled.");
			}
		} else {
			logger.log(LogStatus.FAIL, " Log In Element returns NULL.");
		}
		return verifyLogInEnabled;
	}

	@Then("^user should be able to login$")
	public void clickLogin() throws Exception {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		if (objLogin.getButton() != null) {
			if (objLogin.getButton() != null) {
				if (verifyLogInEnabled()) {
					WebButton.Button_Click(driver, objLogin.getButton());
					// logger.log(LogStatus.PASS, "Clicked succesfully to Log In
					// WebElement");
					logger.log(LogStatus.PASS, "Successfully Logged In to CEP Application");
				} else {
					logger.log(LogStatus.FAIL, "Sign In WebElement is not enabled");
				}
			} else {
				logger.log(LogStatus.ERROR, "Identifying WebElement for Sign In Field Failed");
			}
		}
	}

	@And("^CEP homepage should get displayed$")
	public void validateHomePage() throws Exception {
		assertEquals(driver.getCurrentUrl(), ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("url"));
	}

	public void loginToCEPWithAdmin() {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		try {
			if (objLogin.getUserName() != null) {
				if (objLogin.getUserName().isDisplayed()) {
					System.out.println(ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..AdminLogin.username"));
					WebInputTextBox.SendInputTextBox(driver, objLogin.getUserName(),
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..AdminLogin.username"));
				}
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");
			}
			if (objLogin.getPassWord() != null) {
				if (objLogin.getPassWord().isDisplayed()) {
					WebInputTextBox.SendInputTextBox(driver, objLogin.getPassWord(),
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..AdminLogin.password"));
				}
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");
			}
			if (objLogin.getButton() != null) {
				if (objLogin.getButton() != null) {
					if (verifyLogInEnabled()) {
						WebButton.Button_Click(driver, objLogin.getButton());
						// logger.log(LogStatus.PASS, "Clicked succesfully to
						// Log In
						// WebElement");
						logger.log(LogStatus.PASS, "Successfully entered username and password.");
						logger.log(LogStatus.PASS, "Successfully Logged In to CEP Application");
					} else {
						logger.log(LogStatus.FAIL, "Sign In WebElement is not enabled");
					}
				} else {
					logger.log(LogStatus.ERROR, "Identifying WebElement for Sign In Field Failed");
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Log In Failed");
			logger.log(LogStatus.INFO, e.toString());
		}

	}
	public void loadOveriviewPage(){
		driver.get("http://cepu-ui.azurewebsites.net/csdoverviews");
	}

	public void closeModal() {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		try {
			WebElement element = objLogin.getModalCloseButton();
			if (element != null) {
				element.click();
				logger.log(LogStatus.PASS, "Modal dialog box present and closed.");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Modal dialog box not present.");
		}

	}

	public void loginToCEPWithOneGeographyUser() {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		try {
			WebElement signInButton = objLogin.getInternalSignInButton();
			if (signInButton != null) {
				if (signInButton.isDisplayed()) {
					WebButton.Button_Click(driver, signInButton);
					logger.log(LogStatus.PASS, "Successfully clicked on Sign-In button.");
				}
			} else {
				logger.log(LogStatus.FAIL, "Internal Sign In Button is not present.");
			}
			WebElement email = objLogin.getEmailTextBox();
			if (email != null) {
				if (email.isDisplayed()) {
					WebInputTextBox.SendInputTextBox(driver, email,
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..UserLogin.username"));
					logger.log(LogStatus.PASS, "Email text box is present. Successfully entered email.");
				}
			} else {
				logger.log(LogStatus.FAIL, "Email Text Box is not present for internal user.");
			}
			WebElement nextButton = objLogin.getNextButton();
			if (nextButton != null) {

				WebButton.Button_Click(driver, nextButton);

			} else {
				logger.log(LogStatus.ERROR, "Next button is not present for internal user.");
			}
			Thread.sleep(6000);
			// WebElement password = objLogin.getPasswordTextBox();
			// if (password != null) {
			// WebInputTextBox.SendInputTextBox(driver, password,
			// ReadJsonFile.readJsonFileDynamic_firstentry(
			// ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
			// "$..UserLogin.password"));
			// } else {
			// logger.log(LogStatus.ERROR, "Password Text Box is not present for
			// internal user.");
			// }
			// WebElement signIn = objLogin.getSignInButtonForInternalUser();
			// if (signIn != null) {
			//
			// WebButton.Button_Click(driver, signIn);
			// logger.log(LogStatus.PASS, "Successfully Logged In to CEP
			// Application");
			// } else {
			// logger.log(LogStatus.ERROR, "Sign In Button is not present for
			// internal user.");
			// }
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Log In Failed");
			logger.log(LogStatus.INFO, e.toString());
		}
	}
	
	public void loginToCEPQWithAdmin() {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		//driver.get("http://cepq-ui.azurewebsites.net/");
		try {
			if (objLogin.getUserName() != null) {
				if (objLogin.getUserName().isDisplayed()) {
					System.out.println(ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..AdminLogin.username"));
					WebInputTextBox.SendInputTextBox(driver, objLogin.getUserName(),
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..AdminLogin.username"));
				}
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");
			}
			if (objLogin.getPassWord() != null) {
				if (objLogin.getPassWord().isDisplayed()) {
					WebInputTextBox.SendInputTextBox(driver, objLogin.getPassWord(),
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..AdminLogin.password"));
				}
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");
			}
			if (objLogin.getButton() != null) {
				if (objLogin.getButton() != null) {
					if (verifyLogInEnabled()) {
						WebButton.Button_Click(driver, objLogin.getButton());
						// logger.log(LogStatus.PASS, "Clicked succesfully to
						// Log In
						// WebElement");
						
					} else {
						logger.log(LogStatus.FAIL, "Sign In WebElement is not enabled");
					}
				} else {
					logger.log(LogStatus.ERROR, "Identifying WebElement for Sign In Field Failed");
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Log In Failed");
			logger.log(LogStatus.INFO, e.toString());
		}

	}
	
	public void loginToCEPPWithAdmin() {
		CEP_Login_Page_Factory objLogin = new CEP_Login_Page_Factory(driver);
		driver.get("http://cepp-ui.azurewebsites.net/");
		try {
			if (objLogin.getUserName() != null) {
				if (objLogin.getUserName().isDisplayed()) {
					System.out.println(ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..AdminLogin.username"));
					WebInputTextBox.SendInputTextBox(driver, objLogin.getUserName(),
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..AdminLogin.username"));
				}
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");
			}
			if (objLogin.getPassWord() != null) {
				if (objLogin.getPassWord().isDisplayed()) {
					WebInputTextBox.SendInputTextBox(driver, objLogin.getPassWord(),
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..AdminLogin.password"));
				}
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");
			}
			if (objLogin.getButton() != null) {
				if (objLogin.getButton() != null) {
					if (verifyLogInEnabled()) {
						WebButton.Button_Click(driver, objLogin.getButton());
						// logger.log(LogStatus.PASS, "Clicked succesfully to
						// Log In
						// WebElement");
						
					} else {
						logger.log(LogStatus.FAIL, "Sign In WebElement is not enabled");
					}
				} else {
					logger.log(LogStatus.ERROR, "Identifying WebElement for Sign In Field Failed");
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Log In Failed");
			logger.log(LogStatus.INFO, e.toString());
		}

	}

	public CEP_Login_Page_Action() {
		this(driver, logger);
	}

}
