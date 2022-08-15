package com.boddess.testscript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class Checkout extends Reporting {

	@Test(priority = 1, description = "Checkout>>Test Case No.1>>Verify user navigation to Cart page and COD payment")

	public void navigation_cart() throws InterruptedException {
		test = extent.createTest("Verify navigation to cart page and COD payment");
		String error = null;
		String CartURL = "https://www.boddess.com/checkout/cart/";
		String ContinueButtonCart = PropReader.getProp("ContinueButtonCart");
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
		
		
		  wait(By.id(NoThanksId)); driver.findElement(By.id(NoThanksId)).click();
		 
		
		// Adding item to cart from homepage
		wait(By.xpath(AddToBagHomepage));
		driver.findElement(By.xpath(AddToBagHomepage)).click();
		Thread.sleep(3000);
		wait(By.xpath(BagIconXpath));
		// navigation to minicart
		driver.findElement(By.xpath(BagIconXpath)).click();
		Thread.sleep(5000);
		
		wait(By.xpath(ProceedButtonMiniCart));
		// clicking on proceed button on mini cart
		driver.findElement(By.xpath(ProceedButtonMiniCart)).click();

		Thread.sleep(5000);

		/*
		 * error = "Cart navigation"; Assert.assertEquals(CartURL,
		 * "https://www.boddess.com/checkout/cart/"); Thread.sleep(8000);
		 */
		
		wait(By.xpath(ContinueButtonCart));
		driver.findElement(By.xpath(ContinueButtonCart)).click();
		Thread.sleep(8000);

		wait(By.xpath(EmailForLogin));
		driver.findElement(By.xpath(EmailForLogin)).sendKeys("boddesstest@gmail.com");
		Thread.sleep(500);
		
		wait(By.xpath(PasswordForLogin));
		driver.findElement(By.xpath(PasswordForLogin)).sendKeys("Password@123");
		driver.findElement(By.xpath(SubmitLoginButton)).click();
		Thread.sleep(10000);

		wait(By.xpath(NextButtonItemSection));
		driver.findElement(By.xpath(NextButtonItemSection)).click();
		Thread.sleep(1000);

		/*
		 * wait(By.xpath(ShippingAddressBox));
		 * driver.findElement(By.xpath(ShippingAddressBox)).click(); Thread.sleep(4000);
		 */

		wait(By.xpath(NextButtonAddressSection));
		driver.findElement(By.xpath(NextButtonAddressSection)).click();
		Thread.sleep(4000);

		error = "CashOnDelivery";
		wait(By.xpath(CashOnDelivery));
		Assert.assertTrue(driver.findElement(By.xpath(CashOnDelivery)).isDisplayed());
		driver.findElement(By.xpath(CashOnDelivery)).click();
		Thread.sleep(2000);

		wait(By.xpath(SendOTPbutton));
		driver.findElement(By.xpath(SendOTPbutton)).click();

		error = "OTPsentSuccesssfulyMSG";
		wait(By.xpath(OTPsentSuccesssfulyMSG));
		Assert.assertTrue(driver.findElement(By.xpath(OTPsentSuccesssfulyMSG)).isDisplayed());

	}
	

}

