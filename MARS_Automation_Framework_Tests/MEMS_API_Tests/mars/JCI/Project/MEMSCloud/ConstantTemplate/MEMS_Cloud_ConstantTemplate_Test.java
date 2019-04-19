package mars.JCI.Project.MEMSCloud.ConstantTemplate;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.ConstantTemplate.MEMSCloud_ConstantTemplate_Action;
import mars.JCI.Project.MEMS_Cloud.EquipmentConfiguration.MEMSCloud_EquipmentConfiguration_Action;
//new 
public class MEMS_Cloud_ConstantTemplate_Test extends BaseClass {
                @Test(priority=0,description="Create Template")
                public static void create_Template()  //create 
                {
                                try
                                {
                                	
                                MEMSCloud_ConstantTemplate_Action MEMSCloud_ConstantTemplate_Action=new MEMSCloud_ConstantTemplate_Action(driver, logger);
                                MEMSCloud_ConstantTemplate_Action.createTemplate();         
                                getFinalReport(driver, logger, methodName ,   true);
                                }
                                catch(Exception e)
                                {
                                                getFinalReport(driver, logger, methodName ,    false);
                                }
                }              

                
                @Test(priority=1,description="Update Template")
                public static void update_Template()
                {
                                try
                                {
                                                MEMSCloud_ConstantTemplate_Action MEMSCloud_ConstantTemplate_Action=new MEMSCloud_ConstantTemplate_Action(driver, logger);
                                                MEMSCloud_ConstantTemplate_Action.updateTemplate();      
                                                
                                                getFinalReport(driver, logger, methodName ,    true);
                                }
                                catch(Exception e)
                                {
                                                getFinalReport(driver, logger, methodName ,    false);
                                }
                }              
                
                @Test(priority=2,description="Clear Template")
                public static void clear_Template()
                {
                                try
                                {
                                                MEMSCloud_ConstantTemplate_Action MEMSCloud_ConstantTemplate_Action=new MEMSCloud_ConstantTemplate_Action(driver, logger);
                                                MEMSCloud_ConstantTemplate_Action.clearTemplate();           
                                                
                                                getFinalReport(driver, logger, methodName ,    true);
                                }
                                catch(Exception e)
                                {
                                                getFinalReport(driver, logger, methodName ,    false);
                                }
                }              
                
                
                
                
                
                @Test(priority=3,description="Custom Template")
                public static void custom_Template()
                {
                                try
                                {
                                                MEMSCloud_ConstantTemplate_Action MEMSCloud_ConstantTemplate_Action=new MEMSCloud_ConstantTemplate_Action(driver, logger);
                                                MEMSCloud_ConstantTemplate_Action.customTemplate();      
                                                
                                                getFinalReport(driver, logger, methodName ,    true);
                                }
                                catch(Exception e)
                                {
                                                getFinalReport(driver, logger, methodName ,    false);
                                }
                }
                
                @Test(priority=4,description="Delete Template")
                public static void delete_Template()
                {
                                try
                                {
                                                MEMSCloud_ConstantTemplate_Action MEMSCloud_ConstantTemplate_Action=new MEMSCloud_ConstantTemplate_Action(driver, logger);
                                                MEMSCloud_ConstantTemplate_Action.deleteTemplate();       
                                                
                                                getFinalReport(driver, logger, methodName ,    true);
                                }
                                catch(Exception e)
                                {
                                                getFinalReport(driver, logger, methodName ,    false);
                                }
                }                                      
                
}
