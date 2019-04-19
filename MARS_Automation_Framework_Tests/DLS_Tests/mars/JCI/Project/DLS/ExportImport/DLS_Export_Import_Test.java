package mars.JCI.Project.DLS.ExportImport;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Export_Import_Test extends BaseClass {
	
	@Parameters({ "filename", "password"})
	@Test(priority=1,description = "Export User Account File")
	public void testExport(String filename, String password) throws IOException {
		try {
			DLS_Export_Import_Page_Action importExportPA = new DLS_Export_Import_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			importExportPA.exportFile(filename);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
	
	
	
	@Parameters({ "filename", "password"})
	@Test(priority=2,description = "Import User Account File")
	public void testImport(String filename, String password) throws IOException {
		try {
			DLS_Export_Import_Page_Action importExportPA = new DLS_Export_Import_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			importExportPA.importFile(filename);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
	

}
