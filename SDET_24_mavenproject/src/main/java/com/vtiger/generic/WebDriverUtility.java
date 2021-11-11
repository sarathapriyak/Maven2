package com.vtiger.generic;

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Saratha
 *
 */

public class WebDriverUtility{
	/**
	 * 
	 * @param driver
	 * @param time
	 */
public void ImplicitWait(WebDriver driver,int time)
{
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
}
/**
 * 
 * @param driver
 * @param time
 * @param element
 */
public void ExplicitWait(WebDriver driver,int time,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,time );
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * 
 * @param driver
 * @param winTitle
 */
public void SwitchWindow(WebDriver driver,String winTitle)

{
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> it = windows.iterator();
	while(it.hasNext())
	{
		String winid = it.next();
		driver.switchTo().window(winid);
		String title = driver.getTitle();
		if(title.contains(winTitle))
		{
			break;
		}
	}
}
/**
 * 
 * @param driver
 * @param element
 * @param text2
 */
public void Actionmove(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();
	//driver.findElement(By.partialLinkText(text2)).click();
}
public void customwait(WebElement element) throws InterruptedException
{
	int count=0;
	while(count<20) {
		try {
			element.click();
			break;
			
		}
		catch(Throwable e) {
			Thread.sleep(1000);
			count++;
		}
	}
		
}

}
