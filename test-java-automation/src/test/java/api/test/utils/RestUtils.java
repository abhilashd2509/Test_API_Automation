package api.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.kohsuke.rngom.parse.Parseable;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class RestUtils {
	
	

	
	public static String path; //Rest request path
	public static RequestSpecification request;
	public static Response response;
	public static Properties prop;
	
	
	 
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }
 
 
    
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }
 
    
    public static void setRequestHeader (String ContentType,String ContentSpec ){
    	request = RestAssured.given();
    	request.header(ContentType,ContentSpec);
    	
    	
    }
    
    public static void setRequestBody(JSONObject employee){
    	request.body(employee.toJSONString());
    }
    
 
    
    public static Response getMethodGETResponse(String searchURL,String empID) {
        //System.out.print("path: " + path +"\n");
    	response=request.request(Method.GET,(searchURL+"/"+empID));
    	return response;
       
    }
    
    public static Response getMethodPostResponse(String postURL){
    	response=request.request(Method.POST,postURL);
    	return response;
    }
    
    public static Response getMethodPutResponse(String putURL,String empID){
    	response = request.put(putURL+empID);
    	return response;
    	
    }
    
    public static Response getMethodDeletResponse(String deleteURL,String empID){
    	response=request.delete(deleteURL+empID);
    	return response;
    }
    
 
    public static JSONObject getJsonResponseData (Response res) {
        String json = res.asString();
        JSONParser parser = new JSONParser();
        JSONObject obj=new JSONObject();
		try {
			obj = (JSONObject)parser.parse(json);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return obj;

}	
    public static int getResponseStatusCode(Response response){
    	return response.getStatusCode();
    }
    public static ResponseBody getResponseBody(Response response){
    	return response.getBody();
    }
    
    
    
    public static Properties loadProperties(){
    	prop= new Properties();
    	try {
			prop.load(new FileInputStream(new File("/test-java-automation/src/test/resource/test.properties")));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return prop;
    }
    
}
