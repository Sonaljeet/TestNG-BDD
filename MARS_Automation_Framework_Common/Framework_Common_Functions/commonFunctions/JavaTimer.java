package commonFunctions;

import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JavaTimer  {
	
	
	
	public static long startTime,endTime,sessionTime = 0;
	public static String timerTimestamp = null;
	
	public JavaTimer(){
	
	}

	public static void startSessionTimer() {
		
		startTime = System.currentTimeMillis();
		System.out.println("timer_startTime : "+startTime);
		//logger.log(LogStatus.INFO, "Session Timer Started. Start Time is : "+startTime);
	}
	
	
	public static String  endSessionTimer() {
		
		endTime = System.currentTimeMillis();
		System.out.println("timer_endTime : "+endTime);
		//logger.log(LogStatus.INFO, "Session Timer Ended. End Time is : "+endTime);
		return calculateSessionDuration();
	}
	
	public static String  calculateSessionDuration() {
		
		sessionTime = endTime - startTime;
		System.out.println("timer_sessionTime : "+sessionTime);
		//logger.log(LogStatus.INFO, "Session Time is : "+sessionTime);
		return convertMillisToTimestamp();
	}
	
	public static String convertMillisToTimestamp() {
		
		timerTimestamp = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(sessionTime),
		            TimeUnit.MILLISECONDS.toMinutes(sessionTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(sessionTime)),
		            TimeUnit.MILLISECONDS.toSeconds(sessionTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sessionTime)));
		    System.out.println("timerTimestamp : "+timerTimestamp);
		    //logger.log(LogStatus.INFO, "Session Duration is : "+timerTimestamp);
		    return timerTimestamp;
	}
}
