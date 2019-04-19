/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Component.Functions;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PerformanceReportGeneration {
	//Initialize Stopwatch reference    
    public static StopWatch pageLoad = new StopWatch();
    XSSFWorkbook workbook = new XSSFWorkbook(); 
    
    //Create a blank sheet
    XSSFSheet sheet = workbook.createSheet("Performance Data");
      
    //This data needs to be written (Object[])
    public static Map<String, Object[]> data = new TreeMap<String, Object[]>();
    

	public static void firstData() {
		// TODO This methos is specific for 
		/**
		* @author cupadhma
		*
		* @tags Apr 18, 2016
		*/
		
    	//Blank workbook
		data.put("1", new Object[] {"TEST", "BUILD", "DATE", "NAE", "PROTOCOL", "CLIENT", "TIME_SEC", "SAMPLE_NO"});
		
		
	}
	
	public void writeData(Map<String, Object[]> data){
		Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            XSSFRow row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("C:\\performanceData.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("performanceData written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
	
	public static void pageLoadStart(){
		pageLoad.reset();
		pageLoad.start();
	}
	
	public static double pageLoadTime(){
		pageLoadStop();
		double pageLoadTime_Seconds,pageLoadTime_ms;
		pageLoadTime_ms = pageLoad.getTime();
        return pageLoadTime_Seconds = pageLoadTime_ms / 1000;
	}
	public static void pageLoadStop(){
		pageLoad.stop();
	}
	
	public static void getData(){
		
	}
	public static String getCurrentDate(){
		//To get the current date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
}
