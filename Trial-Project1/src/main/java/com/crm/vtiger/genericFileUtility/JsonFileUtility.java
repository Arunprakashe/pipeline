package com.crm.vtiger.genericFileUtility;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonFileUtility {
	
	@Test
	public String readDataFromJson(String key) throws IOException, ParseException {
		FileReader file = new FileReader(IpathConstant.Jsonpath);
	    JSONParser jp = new JSONParser();
	    Object parsed = jp.parse(file);
	    HashMap map = (HashMap) parsed;
	    String value = map.get(key).toString();
		return value;
		
	}

}
