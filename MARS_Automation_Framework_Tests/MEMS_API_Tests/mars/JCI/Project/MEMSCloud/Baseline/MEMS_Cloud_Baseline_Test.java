package mars.JCI.Project.MEMSCloud.Baseline;

import java.util.Arrays;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Baseline.MEMSCloud_Baseline_Action;


public class MEMS_Cloud_Baseline_Test extends BaseClass{

	@Test(priority=0,description="Create baseline")
	public static void create_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.create_baseline();	
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	

	@Test(priority=1,description="Search baseline")
	public static void search_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.search_baseline();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	
	
	@Test(priority=2,description="Update baseline")
	public static void update_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.update_baseline();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	
	
	@Test(priority=3,description="Add define baseline")
	public static void add_define_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.add_define_baseline();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	@Test(priority=4,description="Clear define baseline")
	public static void clear_define_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.clear_define_baseline();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	
	@Test(priority=5,description="Update define baseline")
	public static void update_define_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.update_define_baseline();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	
	
	@Test(priority=6,description="Delete define baseline")
	public static void delete_define_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.delete_define_baseline();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	
	
	@Test(priority=7,description="Delete baseline")
	public static void delete_baseline()
	{
		try
		{
			MEMSCloud_Baseline_Action MEMSCloud_Baseline_Action = new MEMSCloud_Baseline_Action(driver, logger);
			MEMSCloud_Baseline_Action.delete_baseline();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	
}
