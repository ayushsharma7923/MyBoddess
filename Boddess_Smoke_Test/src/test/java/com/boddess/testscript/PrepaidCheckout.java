package com.boddess.testscript;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import com.boddess.utilities.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;
import com.boddess.utilities.MyMethods;

public class PrepaidCheckout extends Reporting {

	@Test(priority = 2, description = "Checkout>> Test Case No.2>>Verify if user is redirected to PayU page for prepaid order")
	public void PrePaidCheckout() throws InterruptedException {
		String AddToBagHomepage = PropReader.getProp("AddToBagHomepage");
		String BagIconXpath = PropReader.getProp("BagIconXpath");
		String ProceedButtonMiniCart = PropReader.getProp("ProceedButtonMiniCart");
		String NextButtonItemSection = PropReader.getProp("NextButtonItemSection");
		String NextButtonAddressSection = PropReader.getProp("NextButtonAddressSection");
		String NetBankingXpath = PropReader.getProp("NetBankingXpath");
		String AxisBankXpath = PropReader.getProp("AxisBankXpath");
		String PlaceOrderbuttonXpath = PropReader.getProp("PlaceOrderbuttonXpath");

		test = extent.createTest("Verify navigation to payu payment page");
		String error = null;
		Thread.sleep(2000);
		try {
			/*
			 * MyMethods m = new MyMethods(); m.Login();
			 */
			driver.get("https://www.boddess.com/");
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

			wait(By.xpath(NetBankingXpath));
			driver.findElement(By.xpath(NetBankingXpath)).click();
			Thread.sleep(10000);

			wait(By.xpath(AxisBankXpath));
			driver.findElement(By.xpath(AxisBankXpath)).click();
			Thread.sleep(10000);

			wait(By.xpath(PlaceOrderbuttonXpath));
			driver.findElement(By.xpath(PlaceOrderbuttonXpath)).click();
			Thread.sleep(10000);

			String PayU_Title = driver.getTitle();
			System.out.println(PayU_Title);

			// check is it correct page opened or not (e.g. check page's title)
			error = "Payment page";
			Assert.assertEquals(PayU_Title, "Payment Page");
		} catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not opened", ExtentColor.RED));
		}

	}
}
