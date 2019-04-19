package mars.JCI.Project.MEMSCloud.EquipmentConfiguration;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.EquipmentConfiguration.MEMSCloud_EquipmentConfiguration_Action;

public class MEMS_Cloud_EquipmentConfiguration_Test extends BaseClass{
	
	@Test(priority=0,description="Create Equipment")
	public static void create_Equipment()
	{
		try
		{
			MEMSCloud_EquipmentConfiguration_Action MEMSCloud_EquipmentConfiguration_Action = new MEMSCloud_EquipmentConfiguration_Action(driver, logger);
			MEMSCloud_EquipmentConfiguration_Action.createEquipment();	
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	
	
	@Test(priority=1,description="Clear Equipement")
	public static void clear_Equipment()
	{
		try
		{
			MEMSCloud_EquipmentConfiguration_Action MEMSCloud_EquipmentConfiguration_Action = new MEMSCloud_EquipmentConfiguration_Action(driver, logger);
			MEMSCloud_EquipmentConfiguration_Action.clearEquipment();	
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	@Test(priority=2,description="Update Equipement")
	public static void update_Equipment()
	{
		try
		{
			MEMSCloud_EquipmentConfiguration_Action MEMSCloud_EquipmentConfiguration_Action = new MEMSCloud_EquipmentConfiguration_Action(driver, logger);
			MEMSCloud_EquipmentConfiguration_Action.updateEquipment();	
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	
	
	@Test(priority=3,description="Delete Equipement")
	public static void delete_Equipment()
	{
		try
		{
			MEMSCloud_EquipmentConfiguration_Action MEMSCloud_EquipmentConfiguration_Action = new MEMSCloud_EquipmentConfiguration_Action(driver, logger);
			MEMSCloud_EquipmentConfiguration_Action.deleteEquipment();		
			getFinalReport(driver, logger, methodName ,	true);
		}
		catch(Exception e)
		{
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
