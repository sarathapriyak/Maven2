package db_practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
@Listeners(com.vtiger.generic.ListenerImplementation.class)
public class ListenerPractice extends BaseClass{
@Test
public void testlistener()
{
	System.out.println("Screenshot was taken");
	Assert.fail();
}
}
