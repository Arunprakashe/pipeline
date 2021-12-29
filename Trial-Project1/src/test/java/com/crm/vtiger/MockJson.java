package com.crm.vtiger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class MockJson {
	
	@Test
	public void readData() throws IOException, ParseException {
		
		FileReader read = new FileReader("./CommonDataJson.json");
		JSONParser jp = new JSONParser();
		Object par = jp.parse(read);
		HashMap map = (HashMap) par;
		
		String url = map.get("Url").toString();
		String uname = map.get("Username").toString();
		String pd = map.get("Pwd").toString();
		String br = map.get("Browser").toString();
		
		System.out.println(url);
		System.out.println(uname);
		System.out.println(pd);
		System.out.println(br);
		
		}

}
