package api.test.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EmployeeDetails {
	
	static JSONParser jsonParser;
	static JSONArray employeeList;
	JSONObject employee;
	static Map<String,JSONObject> empMap;
	
	
	public static void readEmployeJSONFile(){
		
		try {
			FileReader  reader = new FileReader("/test-java-automation/src/test/resource/employee.json");
			Object obj = jsonParser.parse(reader);
			employeeList = (JSONArray) obj;
			empMap = new HashMap<String,JSONObject>(); 
			employeeList.forEach(emp -> storeEmpDetailMAP((JSONObject)emp));
			
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
	public static void storeEmpDetailMAP(JSONObject employee){
		empMap.put(employee.get("Test_Case").toString(), employee);
		
	}
	public static Map<String, JSONObject> getEmpMap() {
		return empMap;
	}
}
