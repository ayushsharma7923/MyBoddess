package com.boddess.testscript;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;


@SuppressWarnings("unused")
public class MyAccount extends Reporting {
	
	String LoginIconXpath = PropReader.getProp("LoginIconXpath");
	String EmailForLogin = PropReader.getProp("EmailForLogin");
	String PasswordForLogin = PropReader.getProp("PasswordForLogin");
	String SubmitLoginButton = PropReader.getProp("SubmitLoginButton");
	
	public void closeHomepgaePopUp()
	{
		String NoThanksId = PropReader.getProp("NoThanksId");
		String SiteloadPopupCloseButtonXpath = PropReader.getProp("SiteloadPopupCloseButtonXpath");
		String SitelogoXpath = PropReader.getProp("SitelogoXpath");
		wait(By.id(NoThanksId));
		driver.findElement(By.id(NoThanksId)).click();
		wait(By.xpath(SiteloadPopupCloseButtonXpath));
		driver.findElement(By.xpath(SiteloadPopupCloseButtonXpath)).click();
		
	}
	
	public void Login() throws InterruptedException {
		
		wait(By.xpath(LoginIconXpath));
		driver.findElement(By.xpath(LoginIconXpath)).click();
		wait(By.xpath(EmailForLogin));
		driver.findElement(By.xpath(EmailForLogin)).sendKeys("boddesstest@gmail.com");
		Thread.sleep(500);
		wait(By.xpath(PasswordForLogin));
		driver.findElement(By.xpath(PasswordForLogin)).sendKeys("Password@123");
		driver.findElement(By.xpath(SubmitLoginButton)).click();
		
	}
	
	public void MyAccountPage() throws InterruptedException {
		
		Login();
		String MyAccountIconXpath = PropReader.getProp("MyAccountIconXpath");
		String MyAccount = PropReader.getProp("MyAccount");
		
		wait(By.xpath(MyAccountIconXpath));
		driver.findElement(By.xpath(MyAccountIconXpath)).click();
		wait(By.xpath(MyAccount));
		driver.findElement(By.xpath(MyAccount)).click();
		
	}

	@Test(priority = 1, description = "My Account>> Test Case No.1>>Verify if contact information is being displayed")
	public void ContactDetails() throws InterruptedException {
		String error = null;

		try {

			test = extent.createTest("Verify if contact information is being displayed");

			String MyAccountIconXpath = PropReader.getProp("MyAccountIconXpath");
			String MyAccount = PropReader.getProp("MyAccount");
			String ContactInformation = PropReader.getProp("ContactInformation");
			
			
			/*
			 * closeHomepgaePopUp(); Login();
			 */

			wait(By.xpath(MyAccountIconXpath));
			driver.findElement(By.xpath(MyAccountIconXpath)).click();
			wait(By.xpath(MyAccount));
			driver.findElement(By.xpath(MyAccount)).click();
			wait(By.xpath(ContactInformation));
			error = "Contact Information";
			Assert.assertTrue(driver.findElement(By.xpath(ContactInformation)).isDisplayed());

		}

		catch (AssertionError e) {

			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}
	
	@Test(priority = 2, description = "My Account>> Test Case No.1>>Verify if change password and edit is being displayed")
	public void ChangePassword() throws InterruptedException {
		String error = null;

		try {

			test = extent.createTest("Verify if change password and edit is being displayed");

			String ChangePasswordLink = PropReader.getProp("ChangePasswordLink");
			String EditLink = PropReader.getProp("EditLink");
			
			/*
			 * closeHomepgaePopUp();
			 * 
			 * MyAccountPage();
			 */
			
			error="Edit Link";
			wait(By.xpath(EditLink));
			Assert.assertTrue(driver.findElement(By.xpath(EditLink)).isDisplayed());
			
			error="Change Password Link";
			wait(By.xpath(EditLink));
			Assert.assertTrue(driver.findElement(By.xpath(ChangePasswordLink)).isDisplayed());
			
			
		}

		catch (AssertionError e) {

			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}

	@Test(priority = 3, description = "My Account>> Test Case No.1>>Verify if newsletter is being displayed")
	public void Newsletter() throws InterruptedException {
		String error = null;

		try {

			test = extent.createTest("Verify if newsletter is being displayed");

			String NewsletterSection = PropReader.getProp("NewsletterSection");

			/*
			 * closeHomepgaePopUp();
			 * 
			 * MyAccountPage();
			 */
			
			
			error="Newsletter Section";
			wait(By.xpath(NewsletterSection));
			Assert.assertTrue(driver.findElement(By.xpath(NewsletterSection)).isDisplayed());
			
			
		}

		catch (AssertionError e) {

			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}

	@Test(priority = 4, description = "My Account>> Test Case No.1>>Verify if default billing address are being displayed")
	public void DefaultBillingAddress() throws InterruptedException {
		String error = null;

		try {

			test = extent.createTest("Verify if default billing address is being displayed");

			String DefaultBillingAddress = PropReader.getProp("DefaultBillingAddress");

			/*
			 * closeHomepgaePopUp();
			 * 
			 * MyAccountPage();
			 */
			
			error="Default billing address";
			wait(By.xpath(DefaultBillingAddress));
			Assert.assertTrue(driver.findElement(By.xpath(DefaultBillingAddress)).isDisplayed());
			
			
		}

		catch (AssertionError e) {

			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}
	
	@Test(priority = 5, description = "My Account>> Test Case No.1>>Verify if default shipping address is being displayed")
	public void DefaultShippingAddress() throws InterruptedException {
		String error = null;

		try {

			test = extent.createTest("Verify if default shipping address is being displayed");

			String DefaultShippingAddress = PropReader.getProp("DefaultShippingAddress");

			/*
			 * closeHomepgaePopUp();
			 * 
			 * MyAccountPage();
			 */
			
			error="Default shipping address";
			wait(By.xpath(DefaultShippingAddress));
			Assert.assertTrue(driver.findElement(By.xpath(DefaultShippingAddress)).isDisplayed());
			
			
		}

		catch (AssertionError e) {

			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}
	
	@Test(priority = 6, description = "My Account>> Test Case No.1>>Verify if manage address link is being displayed")
	public void ManageAddressLink() throws InterruptedException {
		String error = null;

		try {

			test = extent.createTest("Verify if manage address link is being displayed");

			String ManageAddressLink = PropReader.getProp("ManageAddressLink");

			/*
			 * closeHomepgaePopUp();
			 * 
			 * MyAccountPage();
			 */
			
			error="Manage address link";
			wait(By.xpath(ManageAddressLink));
			Assert.assertTrue(driver.findElement(By.xpath(ManageAddressLink)).isDisplayed());
			
			
		}

		catch (AssertionError e) {

			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}

	
}
