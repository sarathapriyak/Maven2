package com.vtiger.generic;

import java.util.Random;

public class JavaUtility {

	public String Randomnum()
	{
		Random ran=new Random();
		int rnum = ran.nextInt(1000);
		return ""+rnum;
	}
}