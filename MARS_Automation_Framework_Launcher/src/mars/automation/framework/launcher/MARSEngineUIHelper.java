/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.automation.framework.launcher;

import java.util.ArrayList;

/**
 * The Class MARSEngineUIHelper.
 */
public class MARSEngineUIHelper {

	/** The chrome browser. */
	private static String chromeBrowser;

	/** The fire fox browser. */
	private static String fireFoxBrowser;

	/** The ie browser. */
	private static String ieBrowser;

	/** The send email. */
	private static boolean sendEmail;

	/** The db access required. */
	private static boolean dbAccessRequired;

	/** The project config. */
	private static String projectConfig = null;

	/** The email config. */
	private static String emailConfig = null;

	/** The db config. */
	private static String dbConfig = null;

	/**
	 * Instantiates a new MARS engine UI helper.
	 */
	public MARSEngineUIHelper() {

	}

	/**
	 * Gets the chrome browser.
	 *
	 * @return the chrome browser
	 */
	public String getChromeBrowser() {
		return chromeBrowser;

	}

	/**
	 * Sets the chrome browser.
	 *
	 * @param chromeBrowser
	 *            the new chrome browser
	 */
	public void setChromeBrowser(String chromeBrowser) {
		System.out.println(chromeBrowser);
		MARSEngineUIHelper.chromeBrowser = chromeBrowser;
	}

	/**
	 * Gets the send email.
	 *
	 * @return the send email
	 */
	public boolean getSendEmail() {
		return sendEmail;
	}

	/**
	 * Sets the send email.
	 *
	 * @param sendEmail
	 *            the new send email
	 */
	public void setSendEmail(boolean sendEmail) {
		MARSEngineUIHelper.sendEmail = sendEmail;
	}

	/**
	 * Gets the fire fox browser.
	 *
	 * @return the fire fox browser
	 */
	public String getFireFoxBrowser() {
		return fireFoxBrowser;
	}

	/**
	 * Sets the fire fox browser.
	 *
	 * @param fireFoxBrowser
	 *            the new fire fox browser
	 */
	public void setFireFoxBrowser(String fireFoxBrowser) {
		System.out.println(fireFoxBrowser);
		MARSEngineUIHelper.fireFoxBrowser = fireFoxBrowser;
	}

	/**
	 * Gets the ie browser.
	 *
	 * @return the ie browser
	 */
	public String getIeBrowser() {
		return ieBrowser;
	}

	/**
	 * Sets the ie browser.
	 *
	 * @param ieBrowser
	 *            the new ie browser
	 */
	public void setIeBrowser(String ieBrowser) {
		System.out.println(ieBrowser);
		MARSEngineUIHelper.ieBrowser = ieBrowser;
	}

	/**
	 * Checks if is db access required.
	 *
	 * @return true, if is db access required
	 */
	public boolean isDbAccessRequired() {
		return dbAccessRequired;
	}

	/**
	 * Sets the db access required.
	 *
	 * @param dbAccessRequired
	 *            the new db access required
	 */
	public void setDbAccessRequired(boolean dbAccessRequired) {
		MARSEngineUIHelper.dbAccessRequired = dbAccessRequired;
	}

	/** The browser names. */
	private ArrayList<String> browserNames = new ArrayList<String>();

	/**
	 * Gets the browser details.
	 *
	 * @return the browser details
	 */
	public ArrayList<String> getBrowserDetails() {

		/*
		 * browserNames.add(0, "chrome"); browserNames.add(1, "firefox");
		 * browserNames.add(2, "ie");
		 */

		browserNames.add(0, getChromeBrowser());
		browserNames.add(1, getFireFoxBrowser());
		browserNames.add(2, getIeBrowser());

		return browserNames;
	}

	/**
	 * Gets the project config.
	 *
	 * @return the project config
	 */
	public static String getProjectConfig() {
		return projectConfig;
	}

	/**
	 * Sets the project config.
	 *
	 * @param projectConfig
	 *            the new project config
	 */
	public static void setProjectConfig(String projectConfig) {
		MARSEngineUIHelper.projectConfig = projectConfig;
	}

	/**
	 * Gets the email config.
	 *
	 * @return the email config
	 */
	public static String getEmailConfig() {
		return emailConfig;
	}

	/**
	 * Sets the email config.
	 *
	 * @param emailConfig
	 *            the new email config
	 */
	public static void setEmailConfig(String emailConfig) {
		MARSEngineUIHelper.emailConfig = emailConfig;
	}

	/**
	 * Gets the db config.
	 *
	 * @return the db config
	 */
	public static String getDbConfig() {
		return dbConfig;
	}

	/**
	 * Sets the db config.
	 *
	 * @param dbConfig
	 *            the new db config
	 */
	public static void setDbConfig(String dbConfig) {
		MARSEngineUIHelper.dbConfig = dbConfig;
	}

}
