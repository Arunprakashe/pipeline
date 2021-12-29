package com.crm.vtiger.genericJavaUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * This is class is used for java utilities
 * @author 
 *
 */
public class JavaUtilities {
@Test
	public int getRamdomNumber() {
		
		Random rdm = new Random();
		int Rnum = rdm.nextInt(1000);
		//System.out.println(Rnum);
		return Rnum;
	}


public  String getSystemDate() {
	Date date = new Date();
	//System.out.println(date.getDate());
	String sysdate = date.toString().replace(" ", "_").replace(":", "_");
	//System.out.println(sysdate)0;
	return sysdate;
}

public void pressVirtualEnterKey(int press,int release) throws AWTException {
	Robot rb = new Robot();
	rb.keyPress(press);
	rb.keyRelease(release);
	
}
}
