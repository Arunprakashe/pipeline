package com.crm.vtiger.genericFileUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseSelectQueryUtility {
	
	public String connectToDatabase(String query) throws SQLException {
	
	Driver driver = new Driver();

	DriverManager.registerDriver(driver);
	Connection connect = DriverManager.getConnection(IpathConstant.JDBCpath, "root", "root");
	Statement smt = connect.createStatement();
	ResultSet res = smt.executeQuery(query); 
	String value = res.getString(query);
	return value;
	
	}
}
 