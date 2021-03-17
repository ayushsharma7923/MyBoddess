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
	//@Test (priority = 2, description = "Static Pages>>TC #2: Verify Careers page")
	public void Careers() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Careers page");
		try {
			
			//Navigate to Careers page
			WebElement careers= driver.findElement(By.xpath(Careers));
			careers.click();
			//Verifying Careers page
			error=Careers_Content;
			Assert.assertTrue(driver.findElement(By.xpath(Careers_Content)).isDisplayed());
			//Verifying Careers breadcrumb
			Assert.assertTrue(driver.findElement(By.xpath(Careers_Brdcrumb)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	//@Test (priority = 3, description = "Static Pages>>TC #3: Verify Stores page")
	public void Stores() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Stores page");
		WebDriverWait wait=new WebDriverWait(driver, 60);
		try {
			//Navigate to Stores page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Store)));
			WebElement stores= driver.findElement(By.xpath(Store));
			stores.click();
			//Verifying Stores page
			error=Store_ClosetTitle;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Store_ClosetTitle)));
			Assert.assertTrue(driver.findElement(By.xpath(Store_ClosetTitle)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	//@Test (priority = 4, description = "Static Pages>>TC #4: Verify Quick_Orders page")
	public void Quick_Orders() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Quick_Orders page");
		WebDriverWait wait=new WebDriverWait(driver, 50);
		try {
			//Navigate to Quick_Orders page
			WebElement qc= driver.findElement(By.xpath(Quick_Orders));
			qc.click();
			Thread.sleep(3000);
			//Verifying Quick_Orders page
			error=QO_Content;
			Assert.assertTrue(driver.findElement(By.xpath(QO_Content)).isDisplayed());
			//Verifying Quick_Orders banner
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QO_Banner)));
			Assert.assertTrue(driver.findElement(By.xpath(QO_Banner)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	//@Test (priority = 5, description = "Static Pages>>TC #5: Verify Contact Site page")
	public void Contact_Site() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Contact Site page");
		try {
			//Navigate to Contact Site page
			WebElement Contact= driver.findElement(By.xpath(Contact_Site));
			Contact.click();
			//Verifying Contact Site page
			error=Contact_Content;
			Assert.assertTrue(driver.findElement(By.xpath(Contact_Content)).isDisplayed());
			//Verifying Contact Site breadcrumb
			Assert.assertTrue(driver.findElement(By.xpath(Contact_Brdcrumb)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	//@Test (priority = 6, description = "Static Pages>>TC #6: Verify Privacy_Policy page")
	public void Privacy_Policy() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Privacy_Policy page");
		try {
			//Navigate to Careers page
			WebElement privacy= driver.findElement(By.xpath(Privacy_Policy));
			privacy.click();
			//Verifying Careers page
			error=Privacy_Content;
			Assert.assertTrue(driver.findElement(By.xpath(Privacy_Content)).isDisplayed());
			//Verifying Careers breadcrumb
			Assert.assertTrue(driver.findElement(By.xpath(Privacy_Brdcrumb)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	//@Test (priority = 7, description = "Static Pages>>TC #7: Verify Payment FAQ page")
	public void FAQs() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Payment FAQ page");
		try {
			//Navigate to FAQs page
			WebElement faqs= driver.findElement(By.xpath(FAQs));
			faqs.click();
			//Verifying FAQs page
			error=FAQs_Content;
			Assert.assertTrue(driver.findElement(By.xpath(FAQs_Content)).isDisplayed());
			//Verifying FAQs breadcrumb
			Assert.assertTrue(driver.findElement(By.xpath(FAQs_Brdcrumb)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	//@Test (priority = 8, description = "Static Pages>>TC #8: Verify Payment page")
	public void Payment() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Payment page");
		try {
			//Navigate to Payment page
			WebElement payment= driver.findElement(By.xpath(Payment));
			payment.click();
			Thread.sleep(3000);
			//Verifying Payment page
			error=Payment_Content;
			Assert.assertTrue(driver.findElement(By.xpath(Payment_Content)).isDisplayed());
			//Verifying Payment breadcrumb
			Assert.assertTrue(driver.findElement(By.xpath(Payment_Brdcrumb)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	
	//@Test (priority = 10, description = "Static Pages>>TC #10: Verify Quick Stock Check page")
	public void QSC() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Quick Stock Check page");
		WebDriverWait wait=new WebDriverWait(driver, 50);
		try {
			//Navigate to Quick Stock Check page
			WebElement qc= driver.findElement(By.xpath(QSC));
			qc.click();
			Thread.sleep(3000);
			//Verifying Quick Stock Check page
			error=QSC_Content;
			Assert.assertTrue(driver.findElement(By.xpath(QSC_Content)).isDisplayed());
			//Verifying Quick Stock Check banner
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QSC_Banner)));
			Assert.assertTrue(driver.findElement(By.xpath(QSC_Banner)).isDisplayed());
			}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	
	//@Test (priority = 11, description = "Static Pages>>TC #11: Verify Contact Us Section on Homepage")
	public void ContSect() throws InterruptedException
	{
		String error=null;
		navHomepage();
		try
		{
		error="Contact Us Section";
		//Verifying Contact Us section is displayed
		wait(By.xpath(ContUs));
		}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			
		}
	}
	


}
