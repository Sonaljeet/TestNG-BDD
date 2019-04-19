package mars.JCI.Project.BCMET.Engineering;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebCheckBox;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import commonFunctions.WebLink;
import commonFunctions.WebTable;

public class BCMET_Engineering_ActiveProjectList_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static final By IMAGELOADER = By.id("imgLoadingIcon");
	private static BCMET_Engineering_ActiveProjectList_Page_Factory activePageListFactory = null;

	public BCMET_Engineering_ActiveProjectList_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		activePageListFactory = new BCMET_Engineering_ActiveProjectList_Page_Factory(driver, logger);
	}

	// Test Methods start
	public void testAllLink() {
		/*
		 * clickOnAdminLink(); System.out.println("Admin link click success");
		 * 
		 * clickOnMasterLink(); System.out.println("Master link click success");
		 */

		clickOnEngineeringLink();
		System.out.println("Engineering link click success");

		clickOnActiveProjectListLink();
		System.out.println("ProjectList Link click success");

		enterProjectNameInSearchBox("Hello World");
		clickOnSearchButton();
	}

	public boolean verifySearchProjectFunctionality(String projectNameToSearch) {
		boolean projectFound = false;
		enterProjectNameInSearchBox(projectNameToSearch);
		clickOnSearchButton();
		List<WebElement> rowList = WebTable.getTableRowWebElements(activePageListFactory.get_projectSummaryTable());
		if (rowList.size() > 0) {
			List<WebElement> columnsList = WebTable.getColumnRows(rowList.get(0));
			for (int i = 0; i < columnsList.size(); i++) {
				if (columnsList.get(i).getText().trim().equalsIgnoreCase(projectNameToSearch)) {
					projectFound = true;
					break;
				}
			}
		}
		if (projectFound) {
			String str = "Project \"" + projectNameToSearch + "\"" + " found successfully in the project list";
			logger.log(LogStatus.PASS, str);
		}
		if (!projectFound) {
			String str1 = "Failed to find the project \"" + projectNameToSearch + "\"" + " in project list";
			logger.log(LogStatus.FAIL, str1);
		}
		return projectFound;
	}

	public boolean verifySearchForNotExistingProject(String projectNameToSearch) {
		boolean projectFound = false;
		enterProjectNameInSearchBox(projectNameToSearch);
		clickOnSearchButton();
		List<WebElement> rowList = WebTable.getTableRowWebElements(activePageListFactory.get_projectSummaryTable());
		if (rowList.size() > 0) {
			List<WebElement> columnsList = WebTable.getColumnRows(rowList.get(0));
			for (int i = 0; i < columnsList.size(); i++) {
				if (columnsList.get(i).getText().trim().equalsIgnoreCase("There are no records to display")) {
					projectFound = true;
					break;
				}
			}
		}
		if (projectFound) {
			String str = "Successfully verified message\"" + "There are no records to display\"";
			logger.log(LogStatus.PASS, str);
		}
		if (!projectFound) {
			String str1 = "Failed to find the message \"" + "There are no records to display\"";
			logger.log(LogStatus.FAIL, str1);
		}
		return projectFound;
	}

	public boolean verifyDeleteExistingProjectFunctionality(String projectToDelete) {
		boolean deleteStatus = false, deleteChkBoxSelected = false;
		enterProjectNameInSearchBox(projectToDelete);
		clickOnSearchButton();
		List<WebElement> rowList = WebTable.getTableRowWebElements(activePageListFactory.get_projectSummaryTable());
		if (rowList.size() > 0) {
			List<WebElement> columnsList = WebTable.getColumnRows(rowList.get(0));
			for (int i = 0; i < columnsList.size(); i++) {

				if (!columnsList.get(i).findElement(By.tagName("input")).isSelected()) {
					WebCheckBox.Select_The_Checkbox(columnsList.get(i), logger);
					deleteChkBoxSelected = true;
					break;
				}
			}
		}
		if (deleteChkBoxSelected) {
			clickOnDeleteProjectButton();
			clickOnDeletePopupYesButton();
			WebElementCommon.staticWait(3000);
			if (getErrorInfoMessage().equalsIgnoreCase("Active Project deleted successfully")) {
				clickOnPopupOkButton();
				deleteStatus = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to delete the project");
			}
		}
		return deleteStatus;
	}

	public boolean verifyActiveProjectCanBeArchived() {
		boolean testStatus = false;
		
		WebElementCommon.waitForElementPresent(driver, getProjectSummaryGrid(), logger);

		try {
			if (driver.findElement(By.tagName("body")).getText().contains("There are no records to display")) {
				testStatus = false;
				logger.log(LogStatus.WARNING, "No project to archive");
				System.out.println("Inside if condition");
			} else {
				WebElement projectSummaryGrid = getProjectSummaryGrid();
				List<WebElement> projectListRows = WebTable.getTableRowWebElements(projectSummaryGrid);

				List<WebElement> projectListColumns = WebTable.getColumnRows(projectListRows.get(0));
				WebElement projectCheckbox = projectListColumns.get(0); //Fisrt index is of chceckbox to select the project for archive
				String activeProjectToArchive = projectListColumns.get(1).getText();
				System.out.println("activeProjectToArchive=" + activeProjectToArchive);
				WebCheckBox.Select_The_Checkbox(projectCheckbox, logger);
				clickOnArchiveProjectButton();
				clickOnDeletePopupYesButton();
				clickOnPopupOkButton();
				clickOnArchiveProjectListLink();

				WebElement archiveProjectSummaryDataGrid = getArchiveProjectSummaryGrid();
				List<WebElement> archiveProjectListRows = WebTable.getTableRowWebElements(archiveProjectSummaryDataGrid);
				List<WebElement> archiveProjectListColumns = WebTable.getColumnRows(archiveProjectListRows.get(0));
				String archivedProjectName = archiveProjectListColumns.get(1).getText();
				System.out.println("archivedProjectName=" + archivedProjectName);
				if (archivedProjectName.contentEquals(activeProjectToArchive)) {
					testStatus = true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testStatus;
	}
	
	public boolean verifyArchivedProjectCanBeActivated() {
		boolean testStatus = false;
		clickOnArchiveProjectListLink();
		WebElementCommon.waitForElementPresent(driver, getArchiveProjectSummaryGrid(), logger);
		WebElement archiveProjectSummaryGrid = getArchiveProjectSummaryGrid();//getProjectSummaryGrid();
		
		if (driver.findElement(By.tagName("body")).getText().contains("There are no records to display")) {
			testStatus = false;
			logger.log(LogStatus.WARNING, "No project to activate");
			System.out.println("Inside if condition");
		} else {
			List<WebElement> archiveProjectListRows = WebTable.getTableRowWebElements(archiveProjectSummaryGrid);
			List<WebElement> archiveProjectListRowsListColumns = WebTable.getColumnRows(archiveProjectListRows.get(0));
			WebElement archiveProjectCheckbox = archiveProjectListRowsListColumns.get(0); //Fisrt index is of chceckbox to select the project for archive
			String archiveToActivate = archiveProjectListRowsListColumns.get(1).getText();
			System.out.println("Archive to activate=" + archiveToActivate);
			WebCheckBox.Select_The_Checkbox(archiveProjectCheckbox, logger);
			
			clickOnMoveToActiveProjectListBtn();
			clickOnDeletePopupYesButton();
			clickOnPopupOkButton();
			clickOnActiveProjectListLink();
			WebElement activeProjectSummaryDataGrid = getProjectSummaryGrid();
			List<WebElement> activeProjectListRows = WebTable.getTableRowWebElements(activeProjectSummaryDataGrid);
			List<WebElement> activeProjectListColumns = WebTable.getColumnRows(activeProjectListRows.get(0));
			String activeProjectName = activeProjectListColumns.get(1).getText();
			System.out.println("archivedProjectName=" + activeProjectName);
			if (archiveToActivate.contentEquals(activeProjectName)) {
				testStatus = true;
			}
		}

		return testStatus;
	}

	// TODO Implement this once AutoIT is implemented
	public void verifyBackupExistingProject(String projectNameToBackup) {
		
	}

	public boolean verifyCreateNewProjectFunctionality() {
		boolean testStatus = false;
		clickOnCreateNewProjectButton();
		System.out.println("Page title-" + driver.getTitle().trim());
		if (driver.getTitle().trim().equalsIgnoreCase("Project Monitor")) {

			testStatus = true;
		}
		return testStatus;
	}

	public boolean verifyErrorMessageForBlankProjectDelete(String projectToDelete) {
		boolean deleteStatus = false;
		enterProjectNameInSearchBox(projectToDelete);
		clickOnSearchButton();
		clickOnDeleteProjectButton();
		WebElementCommon.staticWait(3000);
		if (getErrorInfoMessage().equalsIgnoreCase("Please select row")) {
			deleteStatus = true;
		}
		return deleteStatus;
	}
	
	public boolean clickOnSearchedProjectInProjectList(String projectNameToSelect){
		boolean projectFound = false;
		//enterProjectNameInSearchBox(projectNameToSelect);
		//clickOnSearchButton();
		List<WebElement> rowList = WebTable.getTableRowWebElements(activePageListFactory.get_projectSummaryTable());
		if (rowList.size() > 0) {
			List<WebElement> columnsList = WebTable.getColumnRows(rowList.get(0));
			for (int i = 0; i < columnsList.size(); i++) {
				if (columnsList.get(i).getText().trim().equalsIgnoreCase(projectNameToSelect)) {
					projectFound = true;
					WebButton.Button_Click(driver, columnsList.get(i));
					break;
				}
			}
		}
		if (projectFound) {
			String str = "Project \"" + projectNameToSelect + "\"" + " found successfully in the project list";
			logger.log(LogStatus.PASS, str);
		}
		if (!projectFound) {
			String str1 = "Failed to find the project \"" + projectNameToSelect + "\"" + " in project list";
			logger.log(LogStatus.FAIL, str1);
		}
		return projectFound;
		
	}

	// Test Methods end

	// WebElement getters start
	public static void clickOnEngineeringLink() {
		WebElement element = null;
		element = activePageListFactory.get_EngineeringLink();
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Engineering Link clicked successfully");
			System.out.println("Engineering Link clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Engineering Link");
		}
	}

	public static void clickOnActiveProjectListLink() {
		WebElement element = null;
		element = activePageListFactory.get_ActiveProjectListTab();
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, element.getText() + " clicked successfully");
			System.out.println(element.getText() + " clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the link");
		}
	}

	public static void clickOnArchiveProjectListLink() {
		WebElement element = null;
		element = activePageListFactory.get_ArchiveProjectListTab();
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, element.getText() + " clicked successfully");
			System.out.println(element.getText() + " clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the link");
		}
	}

	public static void clickOnMasterLink() {
		WebElement element = null;
		element = activePageListFactory.get_MasterLink();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, element.getText() + " clicked successfully");
			System.out.println(element.getText() + " clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the link");
		}
	}

	public void clickOnAdminLink() {
		WebElement element = null;
		element = activePageListFactory.get_AdminLink();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Admin link clicked successfully");
			System.out.println(element.getText() + " clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Admin link");
		}
	}

	public void clickOnCreateNewProjectButton() {
		WebElement element = null;
		element = activePageListFactory.get_CreateNewProjectButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Create New Project button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Create New Project button not found");
		}

	}

	public static void clickOnArchiveProjectButton() {
		WebElement element = null;
		element = activePageListFactory.get_ArchiveProjectListButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Archive Project button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Archive Project button not found");
		}
	}

	public static void clickOnDeleteProjectButton() {
		WebElement element = null;
		element = activePageListFactory.get_DeleteProjectButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete Project button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Delete Project button not found");
		}
	}

	public static void clickOnCreateBCMETBackupButton() {
		WebElement element = null;
		element = activePageListFactory.get_CreateBCMETBackupButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Create backup button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Create backup button not found");
		}
	}

	public static void clickOnRestoreBCMETBackupButton() {
		WebElement element = null;
		element = activePageListFactory.get_RestoreBCMETBackupButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Restore Backup button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Restore Backup button not found");
		}
	}

	public static void clickOnLogoutDDArrow() {
		WebElement element = null;
		element = activePageListFactory.get_LogoutDDArrow();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}
	}

	public static void clickOnLogOutLink() {
		WebElement element = null;
		element = activePageListFactory.get_LogoutLink();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Logout link clicked successfully");
			System.out.println("Logout link clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the logout linklink");
		}
	}

	public void enterProjectNameInSearchBox(String textToSearch) {
		WebElement element = null;
		element = activePageListFactory.get_ProjectNameSearchBox();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, textToSearch);
			logger.log(LogStatus.PASS, textToSearch + " entered successfully in project search box");
		} else {
			logger.log(LogStatus.FAIL, "Search box field not found");
		}
	}

	public static void clickOnSearchButton() {
		WebElement element = null;
		element = activePageListFactory.get_ProjectSearchButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Search button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Search button not found");
		}
	}

	public static String getErrorInfoMessage() {
		String errorInfo = null;
		WebElement element = null;
		element = activePageListFactory.get_ActiveProList_PopInfoMsg();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			errorInfo = WebElementCommon.getElementText(driver, element, logger).trim();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}
		return errorInfo;
	}

	public static void clickOnPopupOkButton() {
		WebElement element = null;
		element = activePageListFactory.get_ActiveProList_PopOkButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "OK button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "OK button not found");
		}
	}

	public static void clickOnDeletePopupYesButton() {
		WebElement element = null;
		element = activePageListFactory.get_DeleteProject_PopYesButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Yes button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Yes button not found");
		}
	}

	
	public static WebElement getProjectSummaryGrid() {
		return activePageListFactory.get_projectSummaryTable();
	}
	
	public static WebElement getArchiveProjectSummaryGrid() {
		return activePageListFactory.get_ArchiveProjectListDataGrid();
	}
	
	public static WebElement getPageBody() {
		return activePageListFactory.get_pageBody();
	}
	
	public static void clickOnMoveToActiveProjectListBtn() {
		WebElement element = null;
		element = activePageListFactory.get_MoveToActiveProjectListBtn();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Move To Active Project List button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Move To Active Project List button not found");
		}
	}
	//get_pageBody
	
	// WebElement getters end
}
