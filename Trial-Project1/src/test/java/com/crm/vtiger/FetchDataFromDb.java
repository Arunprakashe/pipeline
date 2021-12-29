package com.crm.vtiger;

import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.vtiger.genericFileUtility.DatabaseUtility;

public class FetchDataFromDb {
	DatabaseUtility du = new DatabaseUtility();

	@BeforeTest
	public void makeConnection() throws SQLException {
		du.connectToDB();
	}
	@Test
	public void execute() throws SQLException {
		du.create("select * from just", 1, "kiru");
	}
	@AfterTest  
	public void closeIt() throws SQLException {
		du.close();
	}
}
