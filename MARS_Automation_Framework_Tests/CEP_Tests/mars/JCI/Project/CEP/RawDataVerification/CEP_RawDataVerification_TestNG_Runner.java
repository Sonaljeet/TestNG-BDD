package mars.JCI.Project.CEP.RawDataVerification;

import org.testng.annotations.Test;

public class CEP_RawDataVerification_TestNG_Runner {

	@Test(description="RawData-Validate the count of IDs for each day for all Assets")
	public void validateCountOfIDs() {
		try{
			CEP_RawDataVerification_Page_Action obj = new CEP_RawDataVerification_Page_Action();
			obj.validateRawData();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
