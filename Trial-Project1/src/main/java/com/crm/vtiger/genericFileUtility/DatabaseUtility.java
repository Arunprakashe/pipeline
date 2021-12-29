package com.crm.vtiger.genericFileUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author
 *
 */
public class DatabaseUtility {
	Connection con;
	/**
	 * 
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		
		Driver ref = new Driver();
		DriverManager.registerDriver (ref);
		 con = DriverManager.getConnection(IpathConstant.JDBCpath, IpathConstant.un, IpathConstant.pwd);
	}
	/**
	 * 
	 * @param query
	 * @param columnIndex
	 * @param expectedValue
	 * @throws SQLException
	 */
	public void create(String query,int columnIndex,String expectedValue) throws SQLException {
		Statement smt = con.createStatement();
		ResultSet val = smt.executeQuery(query);
		boolean flag = false;
			
		while(val.next()){
			String actualValue = val.getString(columnIndex);
			if(expectedValue.equalsIgnoreCase(actualValue)) {
				flag = true;
				break;
			}
			}
		if(flag == true) {
			System.out.println("found in db");
		}
		else {
			System.out.println("not found in db");
	}	
	}
	/**
	 * 
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		con.close();
		System.out.println("closed"); 
	}
	}
