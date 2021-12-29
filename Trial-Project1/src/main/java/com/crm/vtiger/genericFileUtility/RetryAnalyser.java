package com.crm.vtiger.genericFileUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser extends BaseClass implements IRetryAnalyzer {
	
	int count = 0;
	int retrycount = 3;

	public boolean retry(ITestResult result) {

		while(count<retrycount) {
			count++;
			return true;
		}

		return false;
	}
}
