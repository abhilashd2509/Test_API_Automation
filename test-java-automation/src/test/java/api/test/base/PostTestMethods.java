package api.test.base;

import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.Assert;

import api.test.utils.EmployeeDetails;
import api.test.utils.RestUtils;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class PostTestMethods {
	
	
	public static void verifySuccessPostValidData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("valid_data").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			Assert.assertEquals(200, RestUtils.getResponseStatusCode(response));
			Assert.assertEquals(employee.get("name"),RestUtils.getJsonResponseData(response).get("name"));
			Assert.assertEquals(employee.get("salary"),RestUtils.getJsonResponseData(response).get("salary"));
			Assert.assertEquals(employee.get("age"),RestUtils.getJsonResponseData(response).get("age"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void verifyPostDuplicateNameData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("valid_data").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			JSONObject childResponseJson = (JSONObject)RestUtils.getJsonResponseData(response).get("error");
			Assert.assertEquals(prop.getProperty("duplicate_error"),childResponseJson.get("text"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void verifyPostNullNameData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("null_name").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			JSONObject childResponseJson = (JSONObject)RestUtils.getJsonResponseData(response).get("error");
			Assert.assertEquals(prop.getProperty("null_name_error"),childResponseJson.get("text"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void verifyPostNullSalaryData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("null_name").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			JSONObject childResponseJson = (JSONObject)RestUtils.getJsonResponseData(response).get("error");
			Assert.assertEquals(prop.getProperty("null_salary_error"),childResponseJson.get("text"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void verifyPostNullAgeData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("null_name").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			JSONObject childResponseJson = (JSONObject)RestUtils.getJsonResponseData(response).get("error");
			Assert.assertEquals(prop.getProperty("null_age_error"),childResponseJson.get("text"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void verifyPostInValidNameData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("invalid_name").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			Assert.assertNotEquals(employee.get("name"),RestUtils.getJsonResponseData(response).get("name"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	public static void verifyPostInValidSalaryData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("invalid_salary").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			Assert.assertNotEquals(employee.get("salary"),RestUtils.getJsonResponseData(response).get("salary"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void verifyPostInValidAgeData(){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			EmployeeDetails.readEmployeJSONFile();
			JSONObject employee =(JSONObject) EmployeeDetails.getEmpMap().get("invalid_age").remove("test_case");
			RestUtils.setRequestBody(employee);
			Response response= RestUtils.getMethodPostResponse(prop.getProperty("create_url"));
			Assert.assertNotEquals(employee.get("age"),RestUtils.getJsonResponseData(response).get("age"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void resetData(){
		RestUtils.resetBaseURI();
	}
	
}
