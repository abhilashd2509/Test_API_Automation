package api.test.main;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import api.test.base.PostTestMethods;

public class TC_POSTRequest {
	
	@Test(priority=1)
	public void Post_TC01(){
		PostTestMethods.verifySuccessPostValidData();
	}
	
	@Test(priority=2)
	public void Post_TC02(){
		PostTestMethods.verifyPostDuplicateNameData();
	}
	
	@Test(priority=3)
	public void Post_TC03(){
		PostTestMethods.verifyPostDuplicateNameData();
	}
	
	@Test(priority=4)
	public void Post_TC04(){
		PostTestMethods.verifyPostNullNameData();;
	}
	
	@Test(priority=5)
	public void Post_TC05(){
		PostTestMethods.verifyPostNullAgeData();
	}
	
	@Test(priority=6)
	public void Post_TC06(){
		PostTestMethods.verifyPostNullSalaryData();
		
	}
	
	@Test(priority=7)
	public void Post_TC07(){
		PostTestMethods.verifyPostInValidNameData();
		
	}
	
	@Test(priority=8)
	public void Post_TC08(){
		PostTestMethods.verifyPostInValidSalaryData();
		
	}
	
	@Test(priority=9)
	public void Post_TC09(){
		PostTestMethods.verifyPostInValidAgeData();
		
	}
	
	
	@AfterMethod
	public void resetData(){
		PostTestMethods.resetData();
	}
}
