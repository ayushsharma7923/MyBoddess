package com.boddess.testscript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;



public class PDP extends Reporting
{	
	
	public void PDP_Navigation() throws InterruptedException
	{
		//Closing Newsletter and Cookie Policy
		//news_Cookie_policy();
		//Navigating to Homepage
		//navHomepage();
		//Mouse hover on Apparel Category
		Mouseover(By.xpath(Apparel_Category));
		//Clicking on Dresses
		driver.findElement(By.xpath(PLP_Women_Dresses)).click();
		//Clicking on Product Name
		Mouseover(By.xpath(prd));
		WebElement temp=driver.findElement(By.xpath(prd));
		Actions action = new Actions(driver);
		action.moveToElement(temp).click(temp).build().perform();
	}
	
	@Test(priority = 1, description="PDP>>Test No.1 Verifying item name displayed on PDP Page")
	public void prd_name() throws InterruptedException
	{
		test=extent.createTest("Verifying item name displayed on PDP Page");
		//Navigation to PDP
		PDP_Navigation();
		try{
		//Verifying Product Name is displayed
		wait(By.xpath(prdname));
		Assert.assertTrue(driver.findElement(By.xpath(prdname)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Product Name is not displayed", ExtentColor.RED));
		}
		
	}
	
	//@Test(priority = 2, description="PDP>>Test No.2 Verifying unique id displayed on PDP Page")
	public void unq_name()
	{
		test=extent.createTest("Verifying unique id displayed on PDP Page");
		try{
		//Verifying Product Name is displayed
		wait(By.xpath(unqid));
		Assert.assertTrue(driver.findElement(By.xpath(unqid)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Unique Id of product is not displayed", ExtentColor.RED));
		}
	}
	
	@Test(priority = 3, description="PDP>>Test No.3 Verifying Social Media icon displayed on PDP Page")
	public void social()
	{
		test=extent.createTest("Verifying Social Media icon displayed on PDP Page");
		String error = null;
		try{
		//Verifying on Mouse hover Social Icons is displayed
		Assert.assertTrue(driver.findElement(By.xpath(social_icon)).isDisplayed());
		//Mouse Hover on icon
		Mouseover(By.xpath(social_icon));
		//Verifying FaceBook icon
		Assert.assertTrue(driver.findElement(By.xpath(facebook)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not working", ExtentColor.RED));
		}
		
	}
	
					
	@Test(priority = 4, description="PDP>>Test No.4 Verifying Quantity and Add to cart")
	public void qun_addtoCart()
	{
		test=extent.createTest("Verifying Quantity and Add to cart");
		String error = null;
		try{
		//Verifying Delivery dates is displayed
		wait(By.xpath(quan));	
		Mouseover(By.xpath(quan));
		Assert.assertTrue(driver.findElement(By.xpath(quan)).isDisplayed());
		//Verifying Add to Cart
		wait(By.xpath(Cart));
		Assert.assertTrue(driver.findElement(By.xpath(Cart)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not working", ExtentColor.RED));
		}
		
	}
	
			
	//@Test(priority = 5, description="PDP>>Test No.5 Verifying defining attributes/Swatches")
	public void swatches_pdp()
	{
		String error=null;
		test=extent.createTest("Verifying defining attributes/Swatches");
		try{
			error=att;
		//Verifying defining attributes
		Assert.assertTrue(driver.findElement(By.xpath(att)).isDisplayed());	
		//Verifying Swatches is displayed
		error=swatches;
		Assert.assertTrue(driver.findElement(By.xpath(swatches)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
		}
		
	}
	
	
	@Test(priority = 6, description="PDP>>Test No.6 Verifying Prices on PDP")
	public void prices_pdp()
	{
		test=extent.createTest("Verifying Prices on PDP");
		try{
		//Verifying defining attributes
		Assert.assertTrue(driver.findElement(By.xpath(price)).isDisplayed());	
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Prices is not displayed", ExtentColor.RED));
		}
		
	}
	
	@Test(priority = 7, description="PDP>>Test No.7 Verify add to Wishlist is displayed")
	public void wish()
	{
		test=extent.createTest("Verify add to Wishlist is displayed");
		try
		{
			//Navigation to PDP page
			//Navigating to Sofa PLP page
			//Mouse hover on Apparel Category
			Mouseover(By.xpath(Apparel_Category));
			//Clicking on Dresses
			driver.findElement(By.xpath(PLP_Women_Dresses)).click();
			//Clicking on Product Name
			Mouseover(By.xpath(prd));
			WebElement temp=driver.findElement(By.xpath(prd));
			Actions action = new Actions(driver);
			action.moveToElement(temp).click(temp).build().perform();
			//Verifying Wishlist icon is displayed
			wait(By.xpath(wish));
			Assert.assertTrue(driver.findElement(By.xpath(wish)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Wishlist icon is not displayed", ExtentColor.RED));
		}
		
	}
	
	@Test(priority = 8, description="PDP>>Test No.8 Verifying Breadcrumbs")
	public void breadcrumbs_pdp()
	{
		String error=null;
		test=extent.createTest("Verifying Breadcrumbs");
		try{
		//Verifying Breadcrumb is displayed
			error=breadcrumb;
		Assert.assertTrue(driver.findElement(By.xpath(breadcrumb)).isDisplayed());
		//Verifying Navigation
		error=breadcrumb_link;
		Assert.assertTrue(driver.findElement(By.xpath(breadcrumb_link)).isDisplayed());
		WebElement brd=driver.findElement(By.xpath(breadcrumb_link));
		Actions act=new Actions(driver);
		act.moveToElement(brd).click().build().perform();
		//Verifying User lands on PLP
		error=plp_Page;
		Assert.assertTrue(driver.findElement(By.xpath(plp_Page)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
		}
		
	}
		@Test(priority = 9, description="PDP Page>> Test Case No.9>> Verify Product image displayed")
		public void Product_Image() throws InterruptedException
		{
			test = extent.createTest("Verify Product Image");
			String error = null;
			try {
			
			//WebDriverWait wait=new WebDriverWait(driver, 60);
			error = ShopCategory;
			// waiting for shop category element
			wait(By.xpath(ShopCategory));
			// mouse hover at apparel shop category
			Mouseover(By.xpath(ShopCategory));
			Thread.sleep(2000);
			error = Shopsubcategory;
			// clicking on subcategory link
			driver.findElement(By.xpath(Shopsubcategory)).click();
			error = ShoesOnPlp;
			clickablewait(By.xpath(ShoesOnPlp));
			// clicking on PLP item to open PDP
			driver.findElement(By.xpath(ShoesOnPlp)).click();
			wait(By.xpath(PDPItemImage));
			error = "Image not found on PDP";
			// Getting link of image showing on PDP
			String ImageLinkPDP = driver.findElement(By.xpath(PDPItemImage)).getAttribute("src");
				Assert.assertTrue(ImageLinkPDP.contains(".jpg"));
				} catch (AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
				}	
		}
		
		
		
		@Test(priority = 11, description="PDP Page>> Test Case No. 11>> Verify Product Detail Section")
		public void ProductDetailSection() throws InterruptedException
		{
			test = extent.createTest("Verify product detail section");
			String error = null;
			try {
		    // waiting for shop category element
			error = ShopCategory;
			wait(By.xpath(ShopCategory));
			// mouse hover at apparel shop category
			Mouseover(By.xpath(ShopCategory));
			Thread.sleep(2000);
			error = Shopsubcategory;
			// clicking on subcategory link
			driver.findElement(By.xpath(Shopsubcategory)).click();
			error = ShoesOnPlp;
			// clicking on PLP item to open PDP
			driver.findElement(By.xpath(ShoesOnPlp)).click();
			error = ProductDescriptionTitle;
			Assert.assertEquals(driver.findElement(By.xpath(ProductDescriptionTitle)).getText(), "Product description");
			
				} catch (AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
				}	
		}
		
		@Test(priority = 12, description="PDP Page>> Test Case No. 12>> Pincode validation")
		public void Pincode_Validation() throws InterruptedException
		{
			test = extent.createTest("Verify pincode");
			String error = null;
			try {
		    // waiting for shop category element
			error = ShopCategory;
			wait(By.xpath(ShopCategory));
			// mouse hover at apparel shop category
			Mouseover(By.xpath(ShopCategory));
			Thread.sleep(2000);
			error = Shopsubcategory;
			// clicking on subcategory link
			driver.findElement(By.xpath(Shopsubcategory)).click();
			error = ShoesOnPlp;
			wait(By.xpath(ShoesOnPlp));
			driver.findElement(By.xpath(ShoesOnPlp)).click();
			wait(By.xpath(PincodeEdit));
			error = PincodeEdit;
			driver.findElement(By.xpath(PincodeEdit)).clear();
			error = "not able to edit pincode";
			driver.findElement(By.xpath(PincodeEdit)).sendKeys("123");
			error = PincodeUpdate;
			driver.findElement(By.xpath(PincodeUpdate)).click();
			wait(By.xpath(Pincodevalidation));
			error = "Validation message not showing";
			Assert.assertEquals(driver.findElement(By.xpath(Pincodevalidation)).getText(), "Please enter valid Zipcode");
			
				} catch (AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
				}	
		}

	
}
