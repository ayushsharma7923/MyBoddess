package com.boddess.testscript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;

import junit.framework.Assert;



@SuppressWarnings("unused")
public class Static_Pages extends Reporting
{
	@Test (priority = 1, description = "Static Pages>>TC #1: Verify About Boddess page")
	public void About_Us() throws InterruptedException
	{
		//close_newsletter();
		String error = null;
		test=extent.createTest("Verify About Boddess page");
		try {
			String About_Boddess  = PropReader.getProp("About_Boddess");
			String About_Bodess_Content  = PropReader.getProp("About_Bodess_Content");
			String AboutBoddess_Brdcrumb  = PropReader.getProp("AboutBoddess_Brdcrumb");
			//Navigate to About Us page
			WebElement aboutUs= driver.findElement(By.xpath(About_Boddess));
			aboutUs.click();
			//Verifying About Us page
			error=About_Bodess_Content;
			Assert.assertTrue(driver.findElement(By.xpath(About_Bodess_Content)).isDisplayed());
			//Verifying About Us breadcrumb
			Assert.assertTrue(driver.findElement(By.xpath(AboutBoddess_Brdcrumb)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	@Test (priority = 2, description = "Static Pages>>TC #2: Verify Terms and Conditions page")
		public void TnC() throws InterruptedException
		{
			//newsletter_Cookie_policy();
			String error = null;
			test=extent.createTest("Verify Terms and Conditions page");
			try {
				String TnC  = PropReader.getProp("TnC");
				String TnC_Content = PropReader.getProp("TnC_Content");
				String TnC_Brdcrumb  = PropReader.getProp("TnC_Brdcrumb");
				//Navigate to Terms and Conditions page
				WebElement tnc= driver.findElement(By.xpath(TnC));
				tnc.click();
				//Verifying Terms and Conditions page
				error=TnC_Content;
				Assert.assertTrue(driver.findElement(By.xpath(TnC_Content)).isDisplayed());
				//Verifying Terms and Conditions breadcrumb
				Assert.assertTrue(driver.findElement(By.xpath(TnC_Brdcrumb)).isDisplayed());
				}
			catch (AssertionError e) {
				test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
				
			}
		}
	
	


}
