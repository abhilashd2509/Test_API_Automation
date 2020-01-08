package api.test.base;

import java.util.Properties;

import org.testng.Assert;

import api.test.utils.RestUtils;
import io.restassured.response.Response;

public class DeleteTestMethods {

	
	public static void verifyValidDelete(Response response){
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response deleteResponse= RestUtils.getMethodDeletResponse(prop.getProperty("delete_url"), RestUtils.getJsonResponseData(response).get("id").toString());
			Assert.assertEquals(200, deleteResponse.getStatusCode());
			Assert.assertEquals(deleteResponse.asString().contains("successfully! deleted Records"), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public static void verifyTogetDeletedRecord(Response response){
		
		try {
			Properties prop = RestUtils.loadProperties();
			RestUtils.setBaseURI(prop.getProperty("base_url"));
			RestUtils.setRequestHeader(prop.getProperty("content_type"), prop.getProperty("content_spec"));
			Response getResponse = RestUtils.getMethodGETResponse(prop.getProperty("search_url"),RestUtils.getJsonResponseData(response).get("id").toString());
			Assert.assertNotEquals(RestUtils.getJsonResponseData(response).get("id").toString(), RestUtils.getJsonResponseData(getResponse).get("id").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}


