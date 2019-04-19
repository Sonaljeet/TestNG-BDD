/**
 * 
 */
package commonFunctions_Performance;

import java.io.BufferedReader;
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

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_HandleJTLFile {
	
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
	public static double final_throughput = 0;
	public static int total_bytes_sent = 0;
	public static String start_timestamp = null;
	
	
	@SuppressWarnings("static-access")
	public Performance_HandleJTLFile(ExtentTest logger) {
		this.logger = logger;
	}
	
	public static void clearAllTheStaticArrayLists() {
		
		if(timeStamp.size() > 1) timeStamp.clear();
		if(elapsed.size() > 1) elapsed.clear();
		if(label.size() > 1) label.clear();
		if(responseCode.size() > 1) responseCode.clear();
		if(threadName.size() > 1) threadName.clear();
		if(success.size() > 1) success.clear();
		if(bytes.size() > 1) bytes.clear();
		if(sentBytes.size() > 1) sentBytes.clear();
		if(grpThreads.size() > 1) grpThreads.clear();
		if(allThreads.size() > 1) allThreads.clear();
		if(Latency.size() > 1) Latency.clear();
		if(SampleCount.size() > 1) SampleCount.clear();
		if(ErrorCount.size() > 1) ErrorCount.clear();
		if(Hostname.size() > 1) Hostname.clear();
		if(IdleTime.size() > 1) IdleTime.clear();
		if(Connect.size() > 1) Connect.clear();
	}
	
	public static void ReadReportsJTLFile() {
		
		String reportFile = projdir+"\\reports\\report.jtl";
		System.err.println("jtlreportFile "+reportFile);
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(reportFile);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(reportFile));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				splitStringFromJTL(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}
		
	}
	
	public static void splitStringFromJTL(String string_line) {
		
		String[] parts = string_line.split(";");
		
		timeStamp.add(parts[0]); System.out.println(timeStamp);// = parts[0].toString(); syso
		elapsed.add(parts[1]);System.out.println(elapsed);
		label.add(parts[2]);System.out.println(label);
		responseCode.add(parts[3]);System.out.println(responseCode);
		threadName.add(parts[4]);System.out.println(threadName);
		success.add(parts[5]);System.out.println(success);
		bytes.add(parts[6]);System.out.println(bytes);
		sentBytes.add(parts[7]);System.out.println(sentBytes);
		grpThreads.add(parts[8]);System.out.println(grpThreads);
		allThreads.add(parts[9]);System.out.println(allThreads);
		Latency.add(parts[10]);System.out.println(Latency);
		SampleCount.add(parts[11]);System.out.println(SampleCount);
		ErrorCount.add(parts[12]);System.out.println(ErrorCount);
		Hostname.add(parts[13]);System.out.println(Hostname);
		IdleTime.add(parts[14]);System.out.println(IdleTime);
		Connect.add(parts[15]);System.out.println(Connect);
		
	}
	
	public static void calculateThroughput() {
		
		int total_users = elapsed.size() - 1; System.out.println("total_users "+total_users);
		for (int i = 1; i < elapsed.size(); i++) {
			System.out.println("elapsed "+elapsed.get(i));
			if (!elapsed.get(i).equals(elapsed.get(0))) {
				total_time_elapsed = Integer.parseInt(elapsed.get(i));
				total_time_elapsed += total_time_elapsed;
			}
			
		}
		
		for (int i = 1; i < bytes.size(); i++) {
			System.out.println(bytes.get(i));
			if (!bytes.get(i).equals(bytes.get(0))) {
				total_bytes_sent = Integer.parseInt(bytes.get(i));
				total_bytes_sent += total_bytes_sent;
			}
			
		}
		System.out.println("===============================================================================");
		System.err.println("Toatal Bytes Sent : "+total_bytes_sent);
		System.err.println("Total Time Elapsed in MS : "+total_time_elapsed);
		
		int average_time = total_time_elapsed / total_users ; 
		System.err.println("Average Time per Request :"+average_time);
		int total_bits = total_bytes_sent / 8;
		System.err.println("total_bits : "+total_bits);
		final_throughput = total_bits /  ((double) total_time_elapsed) ;  // / 1000
		System.err.println("Final Throughput : "+ final_throughput+"/ms");
		logger.log(LogStatus.INFO, "Throughput for the Execution : "+ final_throughput+"/ms");
		System.out.println("===============================================================================");
	}
	
	@SuppressWarnings("deprecation")
	public static void calculateTotalTimeTaken() throws ParseException {
		
		for (int i = 1; i < timeStamp.size(); i++) {
			System.out.println(timeStamp.get(i));
			if (!timeStamp.get(i).equals(timeStamp.get(0))) {
				start_timestamp = timeStamp.get(i);
				//start_timestamp += start_timestamp;
				Date start_date = convertStringToDate(start_timestamp);
				System.out.println("Start Time: " + start_date);
				getTheFinalStartTime(i, start_date.toString());
				Date selapsed_time = convertStringToDate(calculateTimeFromMillisec(i));
				long sum = start_date.getTime() + selapsed_time.getTime();
				Date end_date = new Date(sum);
				System.out.println("end_date " + end_date.toString());
				getTheFinalEndTime(i, end_date.toString());
				//start_timestamp += start_timestamp;
			}
			
			/*Time start_time = convertStringToDateSQLFormat(start_timestamp); 
			Time elapsed_time = convertStringToDateSQLFormat(calculateTimeFromMillisec(i)); 
			long sum_time  = start_time.getTime() + elapsed_time.getTime();
			Time end_time = new Time(sum_time);
			System.out.println("end_time "+end_time);*/
		}
		
	}
	

	public static String calculateTimeFromMillisec(int iterator) {
		
		int elapsed_time =  Integer.parseInt(elapsed.get(iterator));
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss"); //yyyy.MM.dd.HH.mm.ss -- hh:mm:ss
		String dateString = formatter.format(new Date(elapsed_time));
		//System.out.println("dateString "+dateString);
		return dateString;
		
	}
	
	public static Date convertStringToDate(String str_date) throws ParseException {
		
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Date date = sdf.parse(str_date);
		return date;
	}
	
	public static Time convertStringToDateSQLFormat(String str_date) throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Time timeValue = new Time(formatter.parse(start_timestamp).getTime());
		System.out.println("timeValue "+timeValue);
		return timeValue;
	}
	
	public static void getTheFinalStartTime(int i,String date_start) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		
		String date = df.format(calobj.getTime()).toString();
		String var_date = date_start.substring(11, 19);
		System.err.println("Start Time for the Sampler "+date+" "+var_date);
		logger.log(LogStatus.INFO, "Start Time for the Sampler No."+i+" is : "+date+" "+var_date);
	}
	
	public static void getTheFinalEndTime(int i,String date_end) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		
		String date = df.format(calobj.getTime()).toString();
		String var_date = date_end.substring(11, 19);
		System.err.println("Final Proper End Time for the Sampler "+date+" "+var_date);
		logger.log(LogStatus.INFO, "Final Proper End Time for the Sampler No."+i+" is : "+date+" "+var_date);
	}
	
	public static void sentKiloBytesPerSec() {
		
		for (int i = 1; i < bytes.size(); i++) {
			System.out.println(bytes.get(i));
			if (!bytes.get(i).equals(bytes.get(0))) {
				total_bytes_sent = Integer.parseInt(bytes.get(i));
				total_bytes_sent += total_bytes_sent;
			}
			
		}
		
		 double kb_sent = total_bytes_sent/1024.0;
		 System.out.println("kb_sent "+kb_sent);
		 
		 
		 long seconds_elapsed = total_time_elapsed/1000;
		 System.out.println("seconds_elapsed "+seconds_elapsed);
		 
		 double kb_per_sec = kb_sent / (double) seconds_elapsed;
		 System.err.println("kb_per_sec "+kb_per_sec);
		logger.log(LogStatus.INFO, "Average KiloBytes/sec "+kb_per_sec);
	}
	
	public static void getMinTimeTaken() {
		
		List<Integer> time_elapsed_list = new ArrayList<Integer>();
		
		for (int i = 1; i < elapsed.size(); i++) {
			System.out.println(elapsed.get(i));
			if (!elapsed.get(i).equals(elapsed.get(0))) {
				time_elapsed_list.add(Integer.parseInt(elapsed.get(i)));
			}
		}
		
		System.out.println("time_elapsed_list "+time_elapsed_list);
		
		int minIndex = time_elapsed_list.indexOf(Collections.min(time_elapsed_list));
		System.out.println("minIndex "+minIndex);
		System.err.println("Minimum Value : "+time_elapsed_list.get(minIndex));
		logger.log(LogStatus.INFO, "Minimum time taken in millis : "+time_elapsed_list.get(minIndex));
	}
	
	

}
