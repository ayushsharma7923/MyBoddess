package com.boddess.testscript;




import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;




public class Homepage extends Reporting

{
	
	
	
	@Test(priority = 1, description="Homepage>> Test Case No.1>> Verify Boddess logo on Homepage")
	public void Header_Links()
	{
		test=extent.createTest("Verify Boddess Logo is displaying");
		String error = null;
		try {
		String NoThanksId = PropReader.getProp("NoThanksId");
		String SiteloadPopupCloseButtonXpath = PropReader.getProp("SiteloadPopupCloseButtonXpath");
		String SitelogoXpath = PropReader.getProp("SitelogoXpath");
		wait(By.id(NoThanksId));
		driver.findElement(By.id(NoThanksId)).click();
		wait(By.xpath(SiteloadPopupCloseButtonXpath));
		driver.findElement(By.xpath(SiteloadPopupCloseButtonXpath)).click();
		wait(By.xpath(SitelogoXpath));
		error = "Site logo";
		Assert.assertTrue(driver.findElement(By.xpath(SitelogoXpath)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}
	
}