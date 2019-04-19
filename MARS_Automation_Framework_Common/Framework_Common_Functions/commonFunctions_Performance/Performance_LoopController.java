/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_LoopController {
	
	private static ExtentTest logger = null;
	public static  LoopController loopController = null;
	
	public Performance_LoopController(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static LoopController setJMeterLoopController(int threads){
		
		loopController = new LoopController();
        loopController.setLoops(threads); // Change loop count to as many you want 
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();
		
		logger.log(LogStatus.INFO, "LoopControl for the Session is Set!");
		return loopController;
	}

}
