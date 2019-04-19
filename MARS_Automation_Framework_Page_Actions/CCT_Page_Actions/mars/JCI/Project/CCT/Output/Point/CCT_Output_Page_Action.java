package mars.JCI.Project.CCT.Output.Point;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.JavaTimer;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.CCT.Home.CCT_Home_Page_Action;

public class CCT_Output_Page_Action {
	

	
		/** The MARSDesktopDriver */
		public MARSDesktopDriver desktopDriver;

		/** The ExtentTest logger. */
		public ExtentTest logger;

		/** The Home page title. */
		public String homePageTitle = "CCT 10.3";
		
		/** The System page title. */
		public String systemPageTitle = "New System";
		
		/** The Output page title. */
		public String outputPageTitle = "New Module Selection";
		
		/** The text. */
		public String text = "";
		/** The text. */
		public String BaseURL = "";

		
		public CCT_Output_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger, String baseurl) {
			this.desktopDriver = desktopDriver;
			this.logger = logger;
			this.BaseURL = baseurl;
		}
		
		
		public void  cctOutputPoints() throws IOException, InterruptedException
		{
			CCT_Home_Page_Action homePA = new CCT_Home_Page_Action(desktopDriver, logger, BaseURL);

			homePA.allDLSProcessClose();

			Thread.sleep(8000);
			homePA.openCCT();
			Thread.sleep(15000);
			desktopDriver.marsMouseClick("", 14,32,1,0);
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 13,48,1,0);
			Thread.sleep(1000);
			
			if(desktopDriver.marsWinWaitActive(systemPageTitle, text, 20) > 0)
			{
				desktopDriver.marsMouseClick("",777,404,1,0);
				Thread.sleep(1000);
				desktopDriver.marsControlSend(systemPageTitle, text, "","System1");
				Thread.sleep(8000);
				desktopDriver.marsMouseClick("",875,543,1,0);
				Thread.sleep(8000);
				desktopDriver.marsMouseClick("",767,628,1,0);
				Thread.sleep(5000);
				desktopDriver.marsMouseClick("",835,629,1,0);
				Thread.sleep(20000);
				if(desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0)
				{
				desktopDriver.marsMouseClick("",1564,262,1,0);
				if(desktopDriver.marsWinWaitActive(outputPageTitle, text, 20) > 0)
				{
					Thread.sleep(1000);
					desktopDriver.marsMouseClick("",513,260,1,0);
					Thread.sleep(1000);
					desktopDriver.marsControlSend(outputPageTitle,text,"","misc");
					Thread.sleep(1000);
					desktopDriver.marsMouseClick("",458,651,5,0);
					Thread.sleep(1000);
					desktopDriver.marsMouseClick("",513,260,1,0);
					Thread.sleep(1000);
					desktopDriver.marsControlSend(outputPageTitle,text,"","{BACKSPACE 4}");
					Thread.sleep(1000);
					desktopDriver.marsControlSend(outputPageTitle,text,"","misc analog");
					Thread.sleep(1000);
					desktopDriver.marsMouseClick("",458,301,6,0);
					Thread.sleep(1000);
					desktopDriver.marsMouseClick("",832,704,1,0);
					JavaTimer.startSessionTimer();
					if(desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0)
					{
						logger.log(LogStatus.PASS,"Output points took"+JavaTimer.endSessionTimer()+ "  to reflect on Main Screen");
						
					}
				
			}
		}
		}

	}
	}



