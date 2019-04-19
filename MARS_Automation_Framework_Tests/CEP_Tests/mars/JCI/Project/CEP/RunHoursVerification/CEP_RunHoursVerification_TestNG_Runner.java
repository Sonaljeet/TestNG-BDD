package mars.JCI.Project.CEP.RunHoursVerification;

import org.testng.annotations.Test;

public class CEP_RunHoursVerification_TestNG_Runner {

	@Test(description="RunHours-Track the false and no data attributes of Chillers")
	public void validateFalseAndNoData() {
		try{
			CEP_RunHours_Page_Action obj = new CEP_RunHours_Page_Action();
			obj.getAttributeID();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
