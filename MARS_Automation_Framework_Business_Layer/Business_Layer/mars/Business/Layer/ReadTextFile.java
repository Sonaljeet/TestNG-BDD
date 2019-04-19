/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Business.Layer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	private static BufferedReader br=null;
	private static String messageText=null;
	public static String readFile(String filePath){
		try {
			//FileInputStream fis=new FileInputStream(new File(filePath));
			br=new BufferedReader(new FileReader(filePath));
			StringBuilder sb=new StringBuilder();
			String line=br.readLine();
			while(line !=null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line=br.readLine();
			}
			messageText=sb.toString();
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageText;
	}
}
