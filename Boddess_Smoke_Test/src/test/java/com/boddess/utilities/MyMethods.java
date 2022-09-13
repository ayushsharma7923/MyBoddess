package com.boddess.utilities;

import org.openqa.selenium.By;

import com.boddess.reporting.Reporting;
import com.boddess.testscript.PropReader;

public class MyMethods extends Reporting {

	public void Login() throws InterruptedException {
		String LoginIconXpath = PropReader.getProp("LoginIconXpath");
		String EmailForLogin = PropReader.getProp("EmailForLogin");
		String PasswordForLogin = PropReader.getProp("PasswordForLogin");
		String SubmitLoginButton = PropReader.getProp("SubmitLoginButton");
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
		driver.findElement(By.xpath(SubmitLoginButton)).click();
		Thread.sleep(6000);

	}

}
