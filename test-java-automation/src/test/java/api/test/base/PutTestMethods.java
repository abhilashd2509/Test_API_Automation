package api.test.base;

import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.Assert;

import api.test.utils.EmployeeDetails;
import api.test.utils.RestUtils;
import io.restassured.response.Response;

public class PutTestMethods {
	
	public static void verifySuccessPutValidData(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject responseParam= RestUtils.getJsonResponseData(response);
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("update_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("update_url"), responseParam.get("id").toString());
			Assert.assertEquals(200, putResponse.getStatusCode());
			Assert.assertEquals(putRequestParam.get("name"),RestUtils.getJsonResponseData(putResponse).get("name"));
			Assert.assertEquals(putRequestParam.get("salary"),RestUtils.getJsonResponseData(putResponse).get("salary"));
			Assert.assertEquals(putRequestParam.get("age"),RestUtils.getJsonResponseData(putResponse).get("age"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void verifyPutDuplicateNameRequest(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("duplicate_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("update_url"), putRequestParam.get("id").toString());
			
			Assert.assertEquals(200, putResponse.getStatusCode());
			Assert.assertEquals(putRequestParam.get("name"),RestUtils.getJsonResponseData(putResponse).get("name"));
			Assert.assertEquals(putRequestParam.get("salary"),RestUtils.getJsonResponseData(putResponse).get("salary"));
			Assert.assertEquals(putRequestParam.get("age"),RestUtils.getJsonResponseData(putResponse).get("age"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void verifyPutNullNameRequest(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("duplicate_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("null_name_put"), putRequestParam.get("id").toString());
			JSONObject childResponseJson = (JSONObject)RestUtils.getJsonResponseData(response).get("error");
			Assert.assertEquals(prop.getProperty("null_name_error"),childResponseJson.get("text") );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void verifyPutNullSalaryRequest(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("duplicate_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("null_salary_put"), putRequestParam.get("id").toString());
			JSONObject childResponseJson = (JSONObject)RestUtils.getJsonResponseData(response).get("error");
			Assert.assertEquals(prop.getProperty("null_salary_error"),childResponseJson.get("text") );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void verifyPutNullAgeRequest(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("duplicate_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("null_age_put"), putRequestParam.get("id").toString());
			JSONObject childResponseJson = (JSONObject)RestUtils.getJsonResponseData(response).get("error");
			Assert.assertEquals(prop.getProperty("null_age_error"),childResponseJson.get("text") );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void verifyPutInvalidNameRequest(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("duplicate_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("invalid_name_put"), putRequestParam.get("id").toString());
			Assert.assertNotEquals(putRequestParam.get("name"),RestUtils.getJsonResponseData(response).get("name"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void verifyPutInvalidSalaryRequest(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("duplicate_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("invalid_salary_put"), putRequestParam.get("id").toString());
			Assert.assertNotEquals(putRequestParam.get("salary"),RestUtils.getJsonResponseData(response).get("salary"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void verifyPutInvalidAgeRequest(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			JSONObject putRequestParam= new JSONObject();
			EmployeeDetails.readEmployeJSONFile();
			putRequestParam = (JSONObject) EmployeeDetails.getEmpMap().get("duplicate_data_put").remove("test_case");
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response putResponse= RestUtils.getMethodPutResponse(prop.getProperty("invalid_age_put"), putRequestParam.get("id").toString());
			Assert.assertNotEquals(putRequestParam.get("age"),RestUtils.getJsonResponseData(response).get("age"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void resetData(){
		RestUtils.resetBaseURI();
	}

}
