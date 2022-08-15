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

	@Test(priority = 1, description = "Login and Reg>> Verify user is able to login")
	public void Login() throws InterruptedException {
		test = extent.createTest("Verify user is logged In");
		String LoginIconXpath = PropReader.getProp("LoginIconXpath");
		String EmailForLogin = PropReader.getProp("EmailForLogin");
		String PasswordForLogin = PropReader.getProp("PasswordForLogin");
		String SubmitLoginButton = PropReader.getProp("SubmitLoginButton");
		String LogoutXpath = PropReader.getProp("LogoutXpath");
		String LoginIconXpathAfterLogin = PropReader.getProp("LoginIconXpathAfterLogin");
		String ProceedButtonAfterEmail = PropReader.getProp("ProceedButtonAfterEmail");
		String SignInViaPWD = PropReader.getProp("SignInViaPWD");
		wait(By.xpath(LoginIconXpath));
		driver.findElement(By.xpath(LoginIconXpath)).click();
		wait(By.xpath(EmailForLogin));
		driver.findElement(By.xpath(EmailForLogin)).sendKeys("boddesstest@gmail.com");
		Thread.sleep(500);
		driver.findElement(By.xpath(ProceedButtonAfterEmail)).click();
		wait(By.xpath(SignInViaPWD));
		driver.findElement(By.xpath(SignInViaPWD)).click();

		
		  wait(By.xpath(PasswordForLogin));
		  driver.findElement(By.xpath(PasswordForLogin)).sendKeys("Password@123");
		  driver.findElement(By.xpath(SubmitLoginButton)).click(); Thread.sleep(6000);
		  wait(By.xpath(LoginIconXpathAfterLogin));
		  driver.findElement(By.xpath(LoginIconXpathAfterLogin)).click();
		  Thread.sleep(10000); 
		  wait(By.xpath(LogoutXpath));
		 
	}
}