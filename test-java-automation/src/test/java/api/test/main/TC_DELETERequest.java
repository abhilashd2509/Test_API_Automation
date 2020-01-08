package api.test.main;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.test.base.DeleteTestMethods;
import api.test.base.PostTestMethods;
import api.test.utils.EmployeeDetails;
import api.test.utils.RestUtils;
import io.restassured.response.Response;

public class TC_DELETERequest {
	
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
	public void TC_DELETE01(){
		DeleteTestMethods.verifyValidDelete(response);
	}
	
	@Test(priority=2)
	public void TC_DELETE02(){
		DeleteTestMethods.verifyTogetDeletedRecord(response);
	}
	
	@AfterMethod
	public void resetData(){
		PostTestMethods.resetData();
	}
}
