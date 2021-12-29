package com.crm.vtiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class MockJdbc {

	@Test
	public void jdbc() throws SQLException {
		Driver ref = new Driver();
		DriverManager.registerDriver(ref);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_info", "root", "root");
		Statement smt = connect.createStatement();
		
		/*int res = smt.executeUpdate("create table new (name varchar(15)not null , id int , location varchar(10) not null,primary key(id))");
		if(res==0) {
		System.out.println("table created");
		}
		else {
			System.out.println("not created");
		}
		*/
		/*int rest = smt.executeUpdate("Insert into new values ('prakash',17,'vellore'),('art',20,'tvm')");
		if(rest==1) {
			System.out.println("table created");
			}
			else {
				System.out.println("not created");
			}*/
		
			ResultSet sel = smt.executeQuery("Select * from new ");
			while(sel.next()) {
			int op =sel.getInt(1);
			System.out.println(op);
			}
			}
			
		
	
}
