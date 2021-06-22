package com.boddess.testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;

@SuppressWarnings("unused")
public class Login_Reg extends Reporting {
	
	@Test(priority = 1, description="Login and Reg>> Verify user is able to login")
	public void Login() throws InterruptedException {
		test = extent.createTest("Verify user is logged In");
		String LoginIconXpath = PropReader.getProp("LoginIconXpath");
		String EmailForLogin = PropReader.getProp("EmailForLogin");
		String PasswordForLogin = PropReader.getProp("PasswordForLogin");
		String SubmitLoginButton = PropReader.getProp("SubmitLoginButton");
		String LogoutXpath = PropReader.getProp("LogoutXpath");	
		String LoginIconXpathAfterLogin = PropReader.getProp("LoginIconXpathAfterLogin");	
		String NoThanksId = PropReader.getProp("NoThanksId");
		String SiteloadPopupCloseButtonXpath = PropReader.getProp("SiteloadPopupCloseButtonXpath");
		String SitelogoXpath = PropReader.getProp("SitelogoXpath");
		
		/*
		 * wait(By.id(NoThanksId)); driver.findElement(By.id(NoThanksId)).click();
		 * wait(By.xpath(SiteloadPopupCloseButtonXpath));
		 * driver.findElement(By.xpath(SiteloadPopupCloseButtonXpath)).click();
		 * wait(By.xpath(SitelogoXpath));
		 */
		 
		
		
		wait(By.xpath(LoginIconXpath));
		driver.findElement(By.xpath(LoginIconXpath)).click();
		wait(By.xpath(EmailForLogin));
		driver.findElement(By.xpath(EmailForLogin)).sendKeys("boddesstest@gmail.com");
		Thread.sleep(500);
		wait(By.xpath(PasswordForLogin));
		driver.findElement(By.xpath(PasswordForLogin)).sendKeys("Password@123");
		driver.findElement(By.xpath(SubmitLoginButton)).click();
		Thread.sleep(3000);
		clickablewait(By.xpath(LoginIconXpathAfterLogin));
		driver.findElement(By.xpath(LoginIconXpathAfterLogin)).click();
		Thread.sleep(500);
		wait(By.xpath(LogoutXpath));
		try {
			Assert.assertEquals(driver.findElement(By.xpath(LogoutXpath)).getText(), "Sign Out");
		} catch (AssertionError e) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("User is not logged in as logout is not showing", ExtentColor.RED));
		}

	}
}