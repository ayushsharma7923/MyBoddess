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


public class Checkout extends Reporting
{
	
	@Test(priority = 1, description="Checkout>>Test Case No.1>>Verify user navigation to Cart page")
	public void navigation_cart() throws InterruptedException
	{
		//Closing Newsletter popup and Cookies policy
		//news_Cookie_policy();
		String error=null;
		test=extent.createTest("Verify user navigation to Cart page");
		//Navigating to Women PLP page
		Mouseover(By.xpath(ShopcategoryApparel));
		//Clicking on Women Category
		driver.findElement(By.xpath(Dresses)).click();
		try {
		//Verifying Products is displayed on PLP page
		error="Product";
		//Clicking on Product displayed
		Mouseover(By.xpath(Dress));
		WebElement prd=driver.findElement(By.xpath(Dress));
		Actions action = new Actions(driver);
		action.moveToElement(prd).click(prd).build().perform();
		//Verifying the product name displayed
		error="Product Name";
		wait(By.xpath(ProductName));
		Thread.sleep(10000);
		WebElement compbtn1=driver.findElement(By.xpath(ProductName));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", compbtn1);
		Assert.assertEquals(driver.findElement(By.xpath(ProductName)).getText(), ProdName);
		//Putting Assert on Actual Price
		String temp=driver.findElement(By.xpath(ActualPrice)).getText().replaceAll("[^a-zA-Z0-9]", "");
		actualPrice=Integer.parseInt(temp);
		//Putting Assert on Offer Price
		String temp1=driver.findElement(By.xpath(OfferPrice)).getText().replaceAll("[^a-zA-Z0-9]", "");
		offerPrice=Integer.parseInt(temp1);
		//Clicking Add to Cart button 
		WebElement cart=driver.findElement(By.xpath(AddtoCart));
		action.moveToElement(cart).click(cart).build().perform();
		Thread.sleep(20000);
		//Clicking on Cart icon
		error=CartIcon;
		WebElement ico=driver.findElement(By.xpath(CartIcon));
		action.moveToElement(ico).click(ico).build().perform();
		//Verifying Cart page for User
		wait(By.xpath(CartPage));
		error=CartPage;
		Assert.assertEquals(driver.findElement(By.xpath(CartPage)).getText(), "Order Summary");
	}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
		}

	}

	@Test(priority = 2, description="Checkout>>Test Case No.2>>Verify total, subtotal, discount")
	public void order_summary()
	{
		String error=null;
		test=extent.createTest("Verify total, subtotal, discount");
		//Verifying Cart Total should be equal to Actual Price
		String temp=driver.findElement(By.xpath(CartTotal)).getText().toString().replaceAll("[^a-zA-Z0-9]", "");
		cartTotal=Integer.parseInt(temp);
		try 
		{
			error="Cart Total is not equal to Actual Price";
			System.out.println("Cart Total is"+ " "+cartTotal);
			System.out.println("Actual Price is"+ " "+actualPrice);
			Boolean cond=false;
			if(offerPrice==cartTotal)
			{
				cond=true;
			}
			Assert.assertTrue(cond);
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
		}
	}
	
	@Test(priority = 3, description="Checkout>>Test Case No.3>>product name, qty and individual price")
	public void attributes()
	{
		String error=null;
		test=extent.createTest("product name, qty and individual price");
		try
		{
		error=ProductName;
		//Verifying Product Name
		Assert.assertEquals(driver.findElement(By.xpath(ProductNameCart)).getText(), ProdName);
		error=Quantity;
		//Verifying Quantity
		Assert.assertEquals(driver.findElement(By.xpath(Quantity)).getText(), "1");
		//Verifying Individual Price
		error=PriceCart;
		String temp=driver.findElement(By.xpath(PriceCart)).getText().replaceAll("[^a-zA-Z0-9]","");
		int temp1=Integer.parseInt(temp);
		System.out.println("Extracted price"+" "+temp);
		System.out.println("Expected price"+" "+offerPrice);
		Assert.assertEquals(temp1, offerPrice);
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
		}
	}
}