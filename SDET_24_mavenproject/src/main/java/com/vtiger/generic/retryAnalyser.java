package com.vtiger.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyser implements IRetryAnalyzer   {
	int count=0;
	int retrycount=4;
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
	

}
