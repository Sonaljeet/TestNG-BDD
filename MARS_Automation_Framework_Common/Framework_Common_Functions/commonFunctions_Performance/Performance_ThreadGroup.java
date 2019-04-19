/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.threads.ThreadGroup;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author cdeyso
 *
 */
public class Performance_ThreadGroup {

	
	private static ExtentTest logger = null;
	public static  ThreadGroup threadGroup ;
	
	public Performance_ThreadGroup(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static ThreadGroup setJMeterThreadGroup(int threadNum, int rampUpSec, LoopController loopController, String threadGroupName){
		
		threadGroup = new ThreadGroup();
        threadGroup.setName(threadGroupName);
        threadGroup.setNumThreads(threadNum); //Change the number of users to as many you want
        threadGroup.setRampUp(rampUpSec); // Change the loop count to as many you want
        threadGroup.setSamplerController(loopController);
        threadGroup.setEnabled(true);
        threadGroup.getOnErrorStopTest();
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
		
		return threadGroup;
	}
	
	
}
