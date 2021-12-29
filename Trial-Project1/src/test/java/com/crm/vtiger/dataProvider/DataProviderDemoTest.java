package com.crm.vtiger.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {

	
	@Test(dataProvider="bookTicketDataProvider")
	public void ticketBooking(String source ,String destination) {

		System.out.println("Ticket confirmed from" +source + "to" + destination );
		System.out.println();
	}
	
	@DataProvider
	public Object[][] bookTicketDataProvider() {
		
		Object[][] obj = new Object[5][2];
		obj[0][0] = "chennai";
		obj[0][1] = "usa";
		
		obj[1][0] = "chennai";
		obj[1][1] = "canada";
		
		obj[2][0] = "chennai";
		obj[2][1] = "maldives";
		
		obj[3][0] = "chennai";
		obj[3][1] = "florida";
		
		
		obj[4][0] = "chennai";
		obj[4][1] = "arcot";
		
		return obj;
		
}
}