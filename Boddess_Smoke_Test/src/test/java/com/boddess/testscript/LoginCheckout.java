package com.boddess.testscript;

import com.boddess.utilities.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;
import com.boddess.utilities.MyMethods;

public class LoginCheckout extends Reporting {
	String CartURL = "https://www.boddess.com/checkout/cart/";
	String NoThanksId = PropReader.getProp("NoThanksId");
	String AddToBagHomepage = PropReader.getProp("AddToBagHomepage");
	String BagIconXpath = PropReader.getProp("BagIconXpath");
	String ProceedButtonMiniCart = PropReader.getProp("ProceedButtonMiniCart");
	String LoginIconXpath = PropReader.getProp("LoginIconXpath");
	String EmailForLogin = PropReader.getProp("EmailForLogin");
	String PasswordForLogin = PropReader.getProp("PasswordForLogin");
	String SubmitLoginButton = PropReader.getProp("SubmitLoginButton");
	String NextButtonItemSection = PropReader.getProp("NextButtonItemSection");
	String NextButtonAddressSection = PropReader.getProp("NextButtonAddressSection");
	String ShippingAddressBox = PropReader.getProp("ShippingAddressBox");
	String CashOnDelivery = PropReader.getProp("CashOnDelivery");
	String SendOTPbutton = PropReader.getProp("SendOTPbutton");
	String OTPsentSuccesssfulyMSG = PropReader.getProp("OTPsentSuccesssfulyMSG");
	String ContinueButtonCart = PropReader.getProp("ContinueButtonCart");

	@Test(priority = 1, description = "Verify the checkout and OTP sent msg")
	public void Login() throws InterruptedException {
		test = extent.createTest("Verify the checkout and OTP sent msg");
		String error = null;
		/*
		 * MyMethods m=new MyMethods(); m.Login();
		 */
		// navigation to homepage
		driver.get("https://www.boddess.com/");
		Thread.sleep(5000);
		// Adding item to cart from homepage
		wait(By.xpath(AddToBagHomepage));
		driver.findElement(By.xpath(AddToBagHomepage)).click();
		Thread.sleep(5000);
		wait(By.xpath(BagIconXpath));
		// navigation to minicart
		driver.findElement(By.xpath(BagIconXpath)).click();
		Thread.sleep(5000);

		wait(By.xpath(ProceedButtonMiniCart));
		// clicking on proceed button on mini cart
		driver.findElement(By.xpath(ProceedButtonMiniCart)).click();
		Thread.sleep(6000);
		

		// Clicking on next button of Item section
		wait(By.xpath(NextButtonItemSection));
		driver.findElement(By.xpath(NextButtonItemSection)).click();
		Thread.sleep(6000);

		wait(By.xpath(NextButtonAddressSection));
		driver.findElement(By.xpath(NextButtonAddressSection)).click();
		Thread.sleep(10000);

		error = "CashOnDelivery";
		wait(By.xpath(CashOnDelivery));
		Assert.assertTrue(driver.findElement(By.xpath(CashOnDelivery)).isDisplayed());
		driver.findElement(By.xpath(CashOnDelivery)).click();
		Thread.sleep(10000);

		wait(By.xpath(SendOTPbutton));
		driver.findElement(By.xpath(SendOTPbutton)).click();

		error = "OTPsentSuccesssfulyMSG";
		wait(By.xpath(OTPsentSuccesssfulyMSG));
		Assert.assertTrue(driver.findElement(By.xpath(OTPsentSuccesssfulyMSG)).isDisplayed());

	}

}