/**
 * 
 */
package mars.JCI.Project.CSD.Performance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.samplers.SampleSaveConfiguration;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testbeans.gui.TestBeanGUI;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.visualizers.ViewResultsFullVisualizer;
import org.apache.jorphan.collections.HashTree;

import com.googlecode.jmeter.plugins.webdriver.config.ChromeDriverConfig;
import com.googlecode.jmeter.plugins.webdriver.config.gui.ChromeDriverConfigGui;
import com.googlecode.jmeter.plugins.webdriver.proxy.ProxyType;
import com.googlecode.jmeter.plugins.webdriver.sampler.WebDriverSampler;
import com.googlecode.jmeter.plugins.webdriver.sampler.gui.WebDriverSamplerGui;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import kg.apc.jmeter.listener.GraphsGeneratorListener;

/**
 * @author cdeyso
 *
 */
public class CSD_Performance_MUICommand_Page_Action {
	
	private static ExtentTest logger = null;
	
	public static String projdir = System.getProperty("user.dir");
	
	public static List<String> timeStamp = new ArrayList<String>();
	public static List<String> elapsed = new ArrayList<String>();
	public static List<String> label = new ArrayList<String>();
	public static List<String> responseCode = new ArrayList<String>();
	public static List<String> threadName = new ArrayList<String>();
	public static List<String> success = new ArrayList<String>();
	public static List<String> bytes = new ArrayList<String>();
	public static List<String> sentBytes = new ArrayList<String>();
	public static List<String> grpThreads = new ArrayList<String>();
	public static List<String> allThreads = new ArrayList<String>();
	public static List<String> Latency = new ArrayList<String>();
	public static List<String> SampleCount = new ArrayList<String>();
	public static List<String> ErrorCount = new ArrayList<String>();
	public static List<String> Hostname = new ArrayList<String>();
	public static List<String> IdleTime = new ArrayList<String>();
	public static List<String> Connect = new ArrayList<String>();
	
	

	public static int total_time_elapsed = 0;
	public static float final_throughput = 0;
	public static int total_bytes_sent = 0;
	public static String start_timestamp = null;
	
	
	@SuppressWarnings("static-access")
	public CSD_Performance_MUICommand_Page_Action(ExtentTest logger) {
		this.logger = logger;
	}
	
	
	public static void ExecuteJMeter(int loopCount, int userThreads) throws Exception {

		//Set jmeter home for the jmeter utils to load
        File jmeterHome = new File("C:\\Users\\cdeyso\\Desktop\\RnD\\JMeter\\apache-jmeter-3.1");
        String slash = System.getProperty("file.separator");
        //Set all the other variables to be used in the program.
        String projdir = System.getProperty("user.dir");
        String chrome_path = "C:\\Users\\cdeyso\\Desktop\\RnD\\JMeter Stuff\\chromedriver_win32\\chromedriver.exe";
        String file_graph = projdir+"\\graphResult.xml";
        
        FileUtils.cleanDirectory(new File(projdir+"\\reports\\"));

        if (jmeterHome.exists()) {
            File jmeterProperties = new File(jmeterHome.getPath() + slash + "bin" + slash + "jmeter.properties");
            if (jmeterProperties.exists()) {
                //JMeter Engine
                StandardJMeterEngine jmeter = new StandardJMeterEngine();

                //JMeter initialization (properties, log levels, locale, etc)
                JMeterUtils.setJMeterHome(jmeterHome.getPath());
                JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
                JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
                JMeterUtils.initLocale();

                // JMeter Test Plan, basically JOrphan HashTree
                HashTree testPlanTree = new HashTree();

                // First HTTP Sampler - open uttesh.com
                HTTPSamplerProxy examplecomSampler = new HTTPSamplerProxy();
                examplecomSampler.setDomain("google.co.in");
                examplecomSampler.setPort(80);
                examplecomSampler.setPath("/");
                examplecomSampler.setMethod("GET");
                examplecomSampler.setName("Open Google.com");
                examplecomSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
                examplecomSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
                
                //creating user defined Variables as in My own MUI program
                Arguments sample_VarData = new Arguments();
                sample_VarData.setName("Sample User Defined Variables");
                sample_VarData.setEnabled(true);
                sample_VarData.addArgument("envurl", "https://10.109.210.141/UI", "=", "MUI Login URL -- TEST");
                sample_VarData.addArgument("user", "Metasyssysagent", "=", "MUI Login USER -- TEST");
                sample_VarData.addArgument("pass", "Hello@123", "=", "MUI Login PASS -- TEST");
                sample_VarData.addArgument("command_adjust_val", "22", "=", "Adjust Value");
                sample_VarData.addArgument("search_text", "ahu", "=", "Search Test for AHU");
                sample_VarData.setProperty(TestElement.TEST_CLASS, Arguments.class.getName());
                sample_VarData.setProperty(TestElement.GUI_CLASS, ArgumentsPanel.class.getName());
                
                //Add a chromedriverConfig Test Step to get the Server UP and Running
                ChromeDriverConfig sample_chromeconfig = new ChromeDriverConfig();
                sample_chromeconfig.setName("Sample ChromeDriver config");
                sample_chromeconfig.setEnabled(true);
                sample_chromeconfig.setProxyType(ProxyType.SYSTEM);
                sample_chromeconfig.setBrowserMaximized(true);
                sample_chromeconfig.setRecreateBrowserOnIterationStart(false);
                sample_chromeconfig.setDevMode(true);
                sample_chromeconfig.setChromeDriverPath(chrome_path);
                sample_chromeconfig.setProperty(TestElement.TEST_CLASS, ChromeDriverConfig.class.getName());
                sample_chromeconfig.setProperty(TestElement.GUI_CLASS, ChromeDriverConfigGui.class.getName());
                
                //Attempting to create a WebDriverSampler for the Logic using JAVA --- Attempted by Souvik !!
                String script = "var pkg = JavaImporter(org.openqa.selenium, org.openqa.selenium.support.ui)\n"+
                		"var support_ui = JavaImporter(org.openqa.selenium.support.ui.WebDriverWait)\n"+
					    "WDS.browser.manage().deleteAllCookies();\n"+
					    "WDS.log.info('Deleting all the cookies')\n"+
					    "WDS.browser.get('${envurl}')\n"+
					    "var wait = new support_ui.WebDriverWait(WDS.browser, 5000)\n"+
					    "var loadpage=0\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.id('UserNameClone0')))\n"+
					    "var uname = WDS.browser.findElement(pkg.By.id('UserNameClone0'))\n"+
					    "uname.sendKeys('${user}')\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.name('Password')))\n"+
					    "var pass = WDS.browser.findElement(pkg.By.name('Password'))\n"+
					    "pass.sendKeys('${pass}')\n"+
					    //wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(".//*[@id='login_content']/form/div[4]/button'")))
					    "var submit = WDS.browser.findElement(pkg.By.cssSelector(\".btn.btn-primary.pull-right.login_button.ng-binding\"))\n"+
					    
					    "WDS.sampleResult.sampleStart()\n"+
					    //WDS.sampleResult.subSampleStart('Goto Home Page')
					    "WDS.log.info(\"Button Detected!\")\n"+
					    "submit.click()\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.cssSelector(\"#Chiller3 > svg > path\")))\n"+ //.facility-select.ng-pristine.ng-valid //#svg_12
					    "var results = WDS.browser.findElement(pkg.By.cssSelector(\"#Chiller3 > svg > path\"))\n"+ //.facility-select.ng-pristine.ng-valid //#svg_12
					    "if(!results.empty)\n"+ 
					    "{\n"+
					        //WDS.sampleResult.subSampleEnd(true)
					        "WDS.sampleResult.sampleEnd()\n"+
					        "WDS.log.info(\"WEBPAGE IS LOADED!\")\n"+
					        //WDS.sampleResult.successful = false
					        //WDS.sampleResult.responseMessage = 'WebPage is Still Loading!'
					    "}\n";
                
                String script_2 = "var pkg = JavaImporter(org.openqa.selenium, org.openqa.selenium.support.ui)\n"+
                		"var support_ui = JavaImporter(org.openqa.selenium.support.ui.WebDriverWait)\n"+
					    "var wait = new support_ui.WebDriverWait(WDS.browser, 5000)\n"+
					    "WDS.log.info(\"Inside MUI-Commanding !\")\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@id='site-menu']/bas-spaces-tree/ol/li/ol/li[2]/a\")))\n"+
					    "var engg_facility =WDS.browser.findElement(pkg.By.xpath(\"//*[@id='site-menu']/bas-spaces-tree/ol/li/ol/li[2]/a\"))\n"+
					    "engg_facility.click()\n"+
					    "WDS.log.info(\"Engineering Facility Selected !\")\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='dashboard-page-btn']\")))\n"+
					    "var toggle_results = WDS.browser.findElement(pkg.By.xpath(\"//*[@test-id='dashboard-page-btn']\"))\n"+
					    //var select_command_adjust = new pkg.Select(toggle_results)
					    "toggle_results.click()//selectByIndex(1)\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@id='dashboard']/div[1]/bas-dashboard-page-selector/div/ul/li[2]/a/span\")))\n"+
					    "var toggle_results_select = WDS.browser.findElement(pkg.By.xpath(\"//*[@id='dashboard']/div[1]/bas-dashboard-page-selector/div/ul/li[2]/a/span\"))\n"+//
					    "toggle_results_select.click()\n"+
					    "WDS.log.info(\"Space DashBoard Selected !\")\n"+
					    //WDS.sampleResult.sampleEnd()
					    //#widget-5 > div.widget-placeholder > bas-schedules > section > bas-schedule-summary > div > div.header-actions.form-inline > div.header-actions-right > label > span
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\".//*[@id='widget-4']/div[4]/bas-equipment-summary/section/div/div[1]/div/div/select\")))\n"+
					    "var widget_one = WDS.browser.findElement(pkg.By.xpath(\".//*[@id='widget-4']/div[4]/bas-equipment-summary/section/div/div[1]/div/div/select\"))\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='filter-button']\")))\n"+
					    "var widget_two = WDS.browser.findElement(pkg.By.xpath(\"//*[@test-id='filter-button']\"))\n"+
					    "java.lang.Thread.sleep(3000)\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='point-value']\")))\n"+
					    "var widget_three = WDS.browser.findElement(pkg.By.xpath(\"//*[@test-id='point-value']\"))\n"+
					    "WDS.log.info(\"Space DashBoard -- About to Adjust Value -- Selected !\")\n"+
					    "widget_three.click()\n"+
					    //Set the Commanding Value
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='trend-btn']\")))\n"+
					    "WDS.log.info(\"Space DashBoard Selected -- 1  !\")\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='cmd-options']\")))\n"+
					    "WDS.log.info(\"Space DashBoard Selected -- 2  !\")\n"+
					    "var command_adjust = WDS.browser.findElement(pkg.By.xpath(\"//select[@test-id='cmd-options']\"))\n"+
					    //var select_command_adjust = new pkg.Select(WDS.browser.findElement(pkg.By.xpath(\"//*[@test-id='cmd-options']\")))
					    "WDS.log.info(\"Space DashBoard Selected -- 3  !\")\n"+
					    "command_adjust.click()\n"+
					    "command_adjust.sendKeys(pkg.Keys.ARROW_DOWN)\n"+//.click()\n"+
					    "command_adjust.sendKeys(pkg.Keys.ENTER)\n"+
					    //select_command_adjust.selectByIndex(0)
					    "WDS.log.info(\"Space DashBoard Selected -- 4  !\")\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\".//*[@test-id='cmd-val-input-field']\")))\n"+
					    "var command_adjust_set_val = WDS.browser.findElement(pkg.By.xpath(\".//*[@test-id='cmd-val-input-field']\"))\n"+
					    "WDS.log.info(\"Space DashBoard Selected -- 5  !\")\n"+
					    "command_adjust_set_val.clear()\n"+
					    "WDS.log.info(\"Space DashBoard Selected -- 6  !\")\n"+
					    /*wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='cmd-val-up']\")))
					    var command_adjust_set_val_up = WDS.browser.findElement(pkg.By.xpath(\"//*[@test-id='cmd-val-up']\"))
					    command_adjust_set_val_up.click()*/
					    "command_adjust_set_val.sendKeys('${command_adjust_val}')\n"+
					    "WDS.log.info(\"Space DashBoard Selected -- 7  !\")\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='cmd-save-btn']\")))\n"+
					    "var command_adjust_submit = WDS.browser.findElement(pkg.By.xpath(\"//*[@test-id='cmd-save-btn']\"))\n"+
					    "WDS.log.info(\"Space DashBoard Selected -- 8  !\")\n"+
					    "command_adjust_submit.click()\n"+
					    //"WDS.sampleResult.sampleStart()\n"+
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.xpath(\"//*[@test-id='point-value']\")))\n"+
					    //"WDS.sampleResult.sampleEnd()\n"+
					    "var command_adjust_val_check = WDS.browser.findElement(pkg.By.xpath(\"//*[@test-id='point-value']\"))\n"+
					    "var command_adjust_val_check_val = command_adjust_val_check.getText()\n"+
					    "var check_val = command_adjust_val_check_val.substring(0, 2)\n"+
					    "WDS.log.info(\"value from UI is \"+check_val)\n"+
					    "if(check_val.equals('${command_adjust_val}'))\n"+
					    "{\n"+
					       " WDS.log.info(command_adjust_val_check_val.substring(0, 2))\n"+
					      " WDS.log.info(\"Value adjusted successfully !\")\n"+
					    "}\n";
					    ////*[@test-id='point-value']
    
                
                WebDriverSampler sample_WDS = new WebDriverSampler();
                sample_WDS.setName("MUI Command!");
                sample_WDS.setScriptLanguage("javascript");
                sample_WDS.setEnabled(true);
                sample_WDS.setScript(script+script_2);
                sample_WDS.setProperty(TestElement.TEST_CLASS, WebDriverSampler.class.getName());
                sample_WDS.setProperty(TestElement.GUI_CLASS, WebDriverSamplerGui.class.getName());
                
                
                //Resultcollector Sampler Test Step -- Attempt to create one by Souvik
                ResultCollector sample_ResultColl = new ResultCollector();
                
                SampleSaveConfiguration saveConfig = new SampleSaveConfiguration();//To set all the required properties of the View Results Sampler.
                saveConfig.setTime(true);
                saveConfig.setLatency(true);
                saveConfig.setTimestamp(true);
                saveConfig.setSuccess(true);
                saveConfig.setLabel(true);
                saveConfig.setCode(true);
                saveConfig.setMessage(false);
                saveConfig.setThreadName(true);
                saveConfig.setDataType(false);
                saveConfig.setEncoding(false);
                saveConfig.setAssertions(true);
                saveConfig.setSubresults(false);
                saveConfig.setResponseData(false);
                saveConfig.setSamplerData(false);
                saveConfig.setAsXml(false);
                saveConfig.setFieldNames(true);
                saveConfig.setResponseHeaders(false);
                saveConfig.setRequestHeaders(false);
                saveConfig.setResponseData(true); // in XML -- <responseDataOnError>false</responseDataOnError>
                saveConfig.saveAssertionResultsFailureMessage();
                saveConfig.assertionsResultsToSave();
                saveConfig.setBytes(true);
                saveConfig.setSentBytes(true);
                saveConfig.setHostname(true);
                saveConfig.setThreadCounts(true);
                saveConfig.setSampleCount(true);
                saveConfig.setIdleTime(true);
                saveConfig.setConnectTime(true);
                
                sample_ResultColl.setName("Sample Result Collector");
                sample_ResultColl.setEnabled(true);
                sample_ResultColl.setErrorLogging(false);
                sample_ResultColl.setSaveConfig(saveConfig);
                sample_ResultColl.setProperty(TestElement.TEST_CLASS, ResultCollector.class.getName());
                sample_ResultColl.setProperty(TestElement.GUI_CLASS, ViewResultsFullVisualizer.class.getName());
                
                //Generate a Graph Result Test Step Sampler
                ResultCollector sample_GraphResult = new ResultCollector();
                
                SampleSaveConfiguration saveConfig_graph = new SampleSaveConfiguration();
                saveConfig_graph.setTime(true);
                saveConfig_graph.setLatency(true);
                saveConfig_graph.setTimestamp(true);
                saveConfig_graph.setSuccess(true);
                saveConfig_graph.setLabel(true);
                saveConfig_graph.setCode(true);
                saveConfig_graph.setMessage(false);
                saveConfig_graph.setThreadName(true);
                saveConfig_graph.setDataType(false);
                saveConfig_graph.setEncoding(false);
                saveConfig_graph.setAssertions(true);
                saveConfig_graph.setSubresults(false);
                saveConfig_graph.setResponseData(false);
                saveConfig_graph.setSamplerData(false);
                saveConfig_graph.setAsXml(false);
                saveConfig_graph.setFieldNames(true);
                saveConfig_graph.setResponseHeaders(false);
                saveConfig_graph.setRequestHeaders(false);
                saveConfig_graph.setResponseData(true); // in XML -- <responseDataOnError>false</responseDataOnError>
                saveConfig_graph.saveAssertionResultsFailureMessage();
                saveConfig_graph.assertionsResultsToSave();
                saveConfig_graph.setBytes(true);
                saveConfig_graph.setSentBytes(true);
                saveConfig_graph.setHostname(true);
                saveConfig_graph.setThreadCounts(true);
                saveConfig_graph.setSampleCount(true);
                saveConfig_graph.setIdleTime(true);
                saveConfig_graph.setConnectTime(true);
                
                
                sample_GraphResult.setName("Sample Graph Result");
                sample_GraphResult.setEnabled(true);
                sample_GraphResult.setErrorLogging(false);
                sample_GraphResult.setSaveConfig(saveConfig_graph);
                sample_GraphResult.flushFile();
                sample_GraphResult.setFilename(file_graph);
                sample_GraphResult.setProperty(TestElement.TEST_CLASS, ResultCollector.class.getName());
                sample_GraphResult.setProperty(TestElement.GUI_CLASS, ResultCollector.class.getName());
                
                //Create a sample dataWriter using JAVA Code --Souvik ########################################### YET TO DO -- START ############################################
                ResultCollector sample_datawriter = new ResultCollector();
                
                SampleSaveConfiguration saveConfig_datawriter = new SampleSaveConfiguration();
                
                
                sample_datawriter.setName("Sample Data Writer");
                sample_datawriter.setErrorLogging(false);
                sample_datawriter.setSaveConfig(saveConfig_datawriter);
                //########################################### YET TO DO -- END ############################################
                
                
                
                // Result collector 
                ResultCollector resultCollector = new ResultCollector(); 
                resultCollector.setFilename(projdir+"\\First_report.jtl"); 
                SampleSaveConfiguration saveConfiguration = new SampleSaveConfiguration(); 
                saveConfiguration.setAsXml(true); 
                saveConfiguration.setCode(true); 
                saveConfiguration.setLatency(true); 
                saveConfiguration.setTime(true); 
                saveConfiguration.setTimestamp(true); 
                resultCollector.setSaveConfig(saveConfiguration); 
                
                //the jp@gc - Graphs Generator Listener
                GraphsGeneratorListener sample_gglistener = new GraphsGeneratorListener();
                sample_gglistener.setName("jp@gc - Graphs Generator Listener");
                sample_gglistener.setEnabled(true);
                //SampleSaveConfiguration sample_gglistener_conf = new SampleSaveConfiguration();
                
                
                sample_gglistener.setProperty("outputBaseFolder", projdir+"\\GraphsGeneratorListenerResult\\");
                sample_gglistener.setProperty("resultsFileName", projdir+"\\reports\\report.jtl");//report.jtl
                sample_gglistener.setProperty("exportMode", 0);
                sample_gglistener.setProperty("filePrefix", "SD-");
                sample_gglistener.setProperty("graphWidth", 800);
                sample_gglistener.setProperty("graphHeight", 600);
                sample_gglistener.setProperty("paintMarkers", "Undefined");
                sample_gglistener.setProperty("paintZeroing", true);
                sample_gglistener.setProperty("paintGradient", true);
                sample_gglistener.setProperty("preventOutliers", false);
                sample_gglistener.setProperty("relativeTimes", false);
                sample_gglistener.setProperty("autoScaleRows", false);
                sample_gglistener.setProperty("limitRows", "150");
                sample_gglistener.setProperty("granulation", 1000);
                sample_gglistener.setProperty("aggregateRows", false);
                sample_gglistener.setProperty("includeSamplesWithRegex", false);
                sample_gglistener.setProperty("excludeSamplesWithRegex", false);
                
                sample_gglistener.setProperty(TestElement.TEST_CLASS, GraphsGeneratorListener.class.getName());
                sample_gglistener.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());
                
                // Loop Controller
                LoopController loopController = new LoopController();
                loopController.setLoops(loopCount); // Change loop count to as many you want 
                loopController.setFirst(true);
                loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
                loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
                loopController.initialize();

                // Thread Group
                ThreadGroup threadGroup = new ThreadGroup();
                threadGroup.setName("Sample Thread Group");
                threadGroup.setNumThreads(userThreads); //Change the number of users to as many you want
                threadGroup.setRampUp(1); // Change the loop count to as many you want
                threadGroup.setSamplerController(loopController);
                threadGroup.setEnabled(true);
                threadGroup.getOnErrorStopTest();
                threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
                threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
                

                // Test Plan
                TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
                
                testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
                testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
                testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

                // Construct Test Plan from previously initialized elements
                testPlanTree.add(testPlan);
                HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
                //threadGroupHashTree.add(examplecomSampler);
                threadGroupHashTree.add(sample_VarData);// Add the User Defined variable test step
                threadGroupHashTree.add(sample_chromeconfig);//Add the chromedriverconfig element
                threadGroupHashTree.add(sample_WDS); // Adding the WebDriverSampler into the TestPlan for it to be executed!
                threadGroupHashTree.add(sample_ResultColl);//Adding the Sample ResultTree Viewer
                threadGroupHashTree.add(sample_GraphResult);
                //threadGroupHashTree.add(resultCollector);
                threadGroupHashTree.add(sample_gglistener);//Adding the jp@gc graph generator listener

                // save generated test plan to JMeter's .jmx file format
                SaveService.saveTree(testPlanTree, new FileOutputStream(projdir+"\\SD_jmeter_api_sample.jmx")); //testPlanTree

                //add Summarizer output to get test progress in stdout like:
                // summary =      2 in   1.3s =    1.5/s Avg:   631 Min:   290 Max:   973 Err:     0 (0.00%)
                Summariser summer = null;
                String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
                if (summariserName.length() > 0) {
                    summer = new Summariser(summariserName);
                }


                // Store execution results into a .jtl file, we can save file as csv also
                String reportFile = projdir+"\\reports\\report.jtl";
                String csvFile = projdir+"\\reports\\report.csv";
                //String htmlFile = projdir+"\\HTMLReport\\report.html";
                ResultCollector rc_logger = new ResultCollector(summer);
                rc_logger.setFilename(reportFile);
                ResultCollector csvlogger = new ResultCollector(summer);
                csvlogger.setFilename(csvFile);
                testPlanTree.add(testPlanTree.getArray()[0], rc_logger);
                testPlanTree.add(testPlanTree.getArray()[0], csvlogger);
                // Run Test Plan
               // try {
                	logger.log(LogStatus.INFO, "Initializing JMeter!");
					jmeter.configure(testPlanTree);//testPlanTree
					logger.log(LogStatus.INFO, "JMeter is UP and Running !");
					jmeter.run();//runTest();//
				/*} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.err.println("There was an error Shutting Down [Can be Ignored]");
				}*/
				logger.log(LogStatus.INFO, "Summary Details "+summer);
				logger.log(LogStatus.PASS, "Test completed. See " + projdir + slash + "report.jtl file for results");
                System.out.println("Test completed. See " + projdir + slash + "report.jtl file for results");
                logger.log(LogStatus.PASS, "JMeter .jmx script is available at " + projdir + slash + "SD_jmeter_api_sample.jmx");
                System.out.println("JMeter .jmx script is available at " + projdir + slash + "SD_jmeter_api_sample.jmx");
                //System.exit(0);
               

            }
        }else {
        logger.log(LogStatus.FATAL, "jmeterHome property is not set or pointing to incorrect location");
        System.err.println("jmeterHome property is not set or pointing to incorrect location");
        //System.exit(1);
        }
        
		}
	
}
