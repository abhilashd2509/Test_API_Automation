package api.test.main;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.test.base.PostTestMethods;
import api.test.base.PutTestMethods;
import api.test.utils.EmployeeDetails;
import api.test.utils.RestUtils;
import io.restassured.response.Response;

public class TC_PUTRequest {
	
	Response response;

	@BeforeClass
	public void doPostRequest(){
		Properties prop = RestUtils.loadProperties();
		RestUtils.setBaseURI(prop.getProperty("base_url"));
		RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
		EmployeeDetails.readEmployeJSONFile();
		JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("post_data_put").remove("test_case");
		RestUtils.setRequestBody(employee);
		response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
		
	}
	
	@Test(priority=1)
	public void TC_PUT01(){
		PutTestMethods.verifySuccessPutValidData(response);
	}
	
	@Test(priority=2)
	public void TC_PUT02(){
		PutTestMethods.verifyPutDuplicateNameRequest(response);
	}
	
	@Test(priority=3)
	public void TC_PUT03(){
		PutTestMethods.verifyPutNullNameRequest(response);
	}
	
	@Test(priority=4)
	public void TC_PUT04(){
		PutTestMethods.verifyPutNullNameRequest(response);
	}
	
	@Test(priority=5)
	public void TC_PUT05(){
		PutTestMethods.verifyPutNullSalaryRequest(response);
	}
	
	@Test(priority=6)
	public void TC_PUT06(){
		PutTestMethods.verifyPutNullAgeRequest(response);
	}
	
	@Test(priority=7)
	public void TC_PUT07(){
		PutTestMethods.verifyPutInvalidNameRequest(response);
	}
	
	@Test(priority=8)
	public void TC_PUT08(){
		PutTestMethods.verifyPutInvalidSalaryRequest(response);
	}
	
	@Test(priority=9)
	public void TC_PUT09(){
		PutTestMethods.verifyPutInvalidAgeRequest(response);
	}
	
	@AfterMethod
	public void resetData(){
		PostTestMethods.resetData();
	}
	
}
