package db_practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoRetry {
@Test(retryAnalyzer=com.vtiger.generic.retryAnalyser.class)
public void retry()
{
	Reporter.log("try again", true);
	Assert.fail();;
}
}
