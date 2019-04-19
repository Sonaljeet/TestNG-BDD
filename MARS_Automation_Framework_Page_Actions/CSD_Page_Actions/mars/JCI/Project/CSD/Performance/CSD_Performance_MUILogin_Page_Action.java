/**
 * 
 */
package mars.JCI.Project.CSD.Performance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
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
import mars.JCI.Project.CSD.Performance.JMeterUtils;
//import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.visualizers.ViewResultsFullVisualizer;
import org.apache.jorphan.collections.HashTree;
//import org.openqa.selenium.WebDriver;

import com.googlecode.jmeter.plugins.webdriver.config.ChromeDriverConfig;
import com.googlecode.jmeter.plugins.webdriver.config.gui.ChromeDriverConfigGui;
import com.googlecode.jmeter.plugins.webdriver.proxy.ProxyType;
import com.googlecode.jmeter.plugins.webdriver.sampler.WebDriverSampler;
import com.googlecode.jmeter.plugins.webdriver.sampler.gui.WebDriverSamplerGui;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import kg.apc.jmeter.listener.GraphsGeneratorListener;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.sql.Time;



/**
 * @author cdeyso
 *
 */
public class CSD_Performance_MUILogin_Page_Action {
	
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
	public CSD_Performance_MUILogin_Page_Action(ExtentTest logger) {
		this.logger = logger;
	}
	
	
	public static void ExecuteJMeter(int loopCount, int userThreads) throws Exception {

		//Set jmeter home for the jmeter utils to load
		String url = "http://10.117.16.108/JMeter/apache-jmeter-3.1"; //\\\\10.117.16.108\\JMeter\\apache-jmeter-3.1
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "testlabpc3", "1");
        SmbFile jmeterHome = new SmbFile(url, auth);
        System.out.println("jmeterHome "+jmeterHome);
        String slash = System.getProperty("file.separator");
        //Set all the other variables to be used in the program.
        String projdir = System.getProperty("user.dir");
        String chrome_path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Tests/Drivers/chromedriver.exe";
        String file_graph = projdir+"\\graphResult.xml";
        
        FileUtils.cleanDirectory(new File(projdir+"\\reports\\"));
        
        if (jmeterHome.exists()) {
        	System.out.println("jmeterHome "+jmeterHome);
        	String jmeterPropFile = "http://10.117.16.108/JMeter/apache-jmeter-3.1/bin/jmeter.properties"; // -- jmeterHome.getPath() + slash + "bin" + slash + 
        	SmbFile jmeterPropFile2 = new SmbFile(jmeterPropFile, auth);
        	//File jmeterProperties = new File(new URL("http://10.117.16.108/JMeter/apache-jmeter-3.1/bin/jmeter.properties"));
        	/*String paramValue = "\\JMeter\\apache-jmeter-3.1\\bin\\jmeter.properties";
        	String yourURLStr = "http://10.117.16.108" + java.net.URLEncoder.encode(paramValue, "UTF-8");
        	java.net.URL url2 = new java.net.URL(yourURLStr);
        	File jmeterProperties = new File(url2.getFile());*/
        	//SmbFileInputStream jmeterProperties = new SmbFileInputStream(jmeterPropFile2);
            //File jmeterProperties = new File(jmeterHome.getPath() + slash + "bin" + slash + "jmeter.properties");
           if (jmeterPropFile2.exists()) {
        	   System.out.println("jmeterProperties "+jmeterPropFile2);
        	   System.out.println("jmeterPropFile2.getCanonicalPath() "+ jmeterPropFile2.getUncPath());
                //JMeter Engine
                StandardJMeterEngine jmeter = new StandardJMeterEngine();

                
                //JMeter initialization (properties, log levels, locale, etc)
                JMeterUtils.setJMeterHome(jmeterHome.getPath());
                JMeterUtils.loadJMeterProperties(jmeterPropFile2.getUncPath());//.getPath() // .getCanonicalPath()
                JMeterUtils.loadProperties("user.properties");
                JMeterUtils.setProperty("saveservice_properties", "http://10.117.16.108/JMeter/apache-jmeter-3.1/bin/saveservice.properties");
                //JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
                JMeterUtils.initLocale();
                
                System.out.println("Jmeter Home : "+JMeterUtils.getJMeterHome());
                System.out.println("Jmeter Bin : "+JMeterUtils.getJMeterBinDir());

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
					    "wait.until(pkg.ExpectedConditions.presenceOfElementLocated(pkg.By.cssSelector(\"#Chiller3 > svg > path\")))\n"+ //.facility-select.ng-pristine.ng-valid //#svg_12 -- //#Chiller3 > svg > path -- xpath(\"//*[@id='svg_103']\")
					    "var results = WDS.browser.findElement(pkg.By.cssSelector(\"#Chiller3 > svg > path\"))\n"+ //.facility-select.ng-pristine.ng-valid //#svg_12
					    "if(!results.empty)\n"+ 
					    "{\n"+
					        //WDS.sampleResult.subSampleEnd(true)
					        "WDS.sampleResult.sampleEnd()\n"+
					        "WDS.log.info(\"WEBPAGE IS LOADED!\")\n"+
					        //WDS.sampleResult.successful = false
					        //WDS.sampleResult.responseMessage = 'WebPage is Still Loading!'
					    "}\n";
                
                WebDriverSampler sample_WDS = new WebDriverSampler();
                sample_WDS.setName("MUI Login!");
                sample_WDS.setScriptLanguage("javascript");
                sample_WDS.setEnabled(true);
                sample_WDS.setScript(script);
                sample_WDS.setProperty(TestElement.TEST_CLASS, WebDriverSampler.class.getName());
                sample_WDS.setProperty(TestElement.GUI_CLASS, WebDriverSamplerGui.class.getName());
                
                
               /* //Resultcollector Sampler Test Step -- Attempt to create one by Souvik
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
                resultCollector.setSaveConfig(saveConfiguration); */
                
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
                //threadGroupHashTree.add(sample_ResultColl);//Adding the Sample ResultTree Viewer
                //threadGroupHashTree.add(sample_GraphResult);
                //threadGroupHashTree.add(resultCollector);
                threadGroupHashTree.add(sample_gglistener);//Adding the jp@gc graph generator listener

                // save generated test plan to JMeter's .jmx file format
                //SaveService.saveTree(testPlanTree, new FileOutputStream(projdir+"\\SD_jmeter_api_sample.jmx")); //testPlanTree

                //add Summarizer output to get test progress in stdout like:
                // summary =      2 in   1.3s =    1.5/s Avg:   631 Min:   290 Max:   973 Err:     0 (0.00%)
               /* Summariser summer = null;
                String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
                if (summariserName.length() > 0) {
                    summer = new Summariser(summariserName);
                }*/


                // Store execution results into a .jtl file, we can save file as csv also
               /* String reportFile = projdir+"\\reports\\report.jtl";
                String csvFile = projdir+"\\reports\\report.csv";
                //String htmlFile = projdir+"\\HTMLReport\\report.html";
                ResultCollector rc_logger = new ResultCollector(summer);
                rc_logger.setFilename(reportFile);
                ResultCollector csvlogger = new ResultCollector(summer);
                csvlogger.setFilename(csvFile);
                testPlanTree.add(testPlanTree.getArray()[0], rc_logger);
                testPlanTree.add(testPlanTree.getArray()[0], csvlogger);*/
                // Run Test Plan
               // try {
                	logger.log(LogStatus.INFO, "Initializing JMeter!");
					jmeter.configure(testPlanTree);//testPlanTree
					logger.log(LogStatus.INFO, "JMeter is UP and Running !");
					System.out.println("JMeter is UP and Running !");
					jmeter.run();//runTest();//
				/*} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.err.println("There was an error Shutting Down [Can be Ignored]");
				}*/
				//logger.log(LogStatus.INFO, "Summary Details "+summer);
				logger.log(LogStatus.PASS, "Test completed. See " + projdir + slash + "report.jtl file for results");
                System.out.println("Test completed. See " + projdir + slash + "report.jtl file for results");
                logger.log(LogStatus.PASS, "JMeter .jmx script is available at " + projdir + slash + "SD_jmeter_api_sample.jmx");
                System.out.println("JMeter .jmx script is available at " + projdir + slash + "SD_jmeter_api_sample.jmx");
                //System.exit(0);
               

            }
            else {
                logger.log(LogStatus.FATAL, "jmeter.property file is not set or pointing to incorrect location");
                System.err.println("jmeter.property file is not set or pointing to incorrect location");
            }
        }else {
        logger.log(LogStatus.FATAL, "jmeterHome property is not set or pointing to incorrect location");
        System.err.println("jmeterHome property is not set or pointing to incorrect location");
        //System.exit(1);
        }
        
		}
	

}
