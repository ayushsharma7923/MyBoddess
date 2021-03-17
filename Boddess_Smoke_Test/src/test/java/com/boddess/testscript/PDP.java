package com.boddess.testscript;
import org.openqa.selenium.By;
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
		String CategoriesTopMenu = PropReader.getProp("CategoriesTopMenu");
		String SkinCategory = PropReader.getProp("SkinCategory");
		//String PLP_SkinBrightening = PropReader.getProp("PLP_SkinBrightening");
		String prd = PropReader.getProp("prd");
		
		//Waiting for Top Category is displayed
		wait(By.xpath(CategoriesTopMenu));
		//Mouse hover on CategoriesTopMenu 
		Mouseover(By.xpath(CategoriesTopMenu));
		//Waiting for Top Category is displayed
		wait(By.xpath(SkinCategory));
		//Mouseover(By.xpath(SkinCategory));
		//Clicking on Skin
		//wait(By.xpath(PLP_SkinBrightening));
		driver.findElement(By.xpath(SkinCategory)).click();
				
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
			String prdname = PropReader.getProp("prdname");			
		//Verifying Product Name is displayed
		wait(By.xpath(prdname));
		Assert.assertTrue(driver.findElement(By.xpath(prdname)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Product Name is not displayed", ExtentColor.RED));
		}
		
	}
	
	@Test(priority = 2, description="PDP>>Test No.2 Verifying Quantity and Add to cart")
	public void qty_addtoCart()
	{
		test=extent.createTest("Verifying Quantity and Add to cart");
		String error = null;
		try{
			String qty_listbox = PropReader.getProp("qty_listbox");
			String addToBag_button = PropReader.getProp("addToBag_button");
		//Verifying Delivery dates is displayed
		wait(By.xpath(qty_listbox));	
		Mouseover(By.xpath(qty_listbox));
		Assert.assertTrue(driver.findElement(By.xpath(qty_listbox)).isDisplayed());
		//Verifying Add to Cart
		wait(By.xpath(addToBag_button));
		Assert.assertTrue(driver.findElement(By.xpath(addToBag_button)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not working", ExtentColor.RED));
		}
		
	}
		
	@Test(priority = 3, description="PDP>>Test No.3 Verifying Social Media icon displayed on PDP Page")
	public void social()
	{
		test=extent.createTest("Verifying Social Media icon displayed on PDP Page");
		String error = null;
		try{
			String facebook = PropReader.getProp("facebook");
			String twitter = PropReader.getProp("twitter");
		//verify on facebook icon
		wait(By.xpath(facebook));
		//Verifying FaceBook icon
		Assert.assertTrue(driver.findElement(By.xpath(facebook)).isDisplayed());
		//verify on twitter icon
		wait(By.xpath(twitter));
		//Verifying FaceBook icon
		Assert.assertTrue(driver.findElement(By.xpath(twitter)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not working", ExtentColor.RED));
		}
				
	}
	
	@Test(priority = 4, description="PDP>>Test No.4 Verifying Prices on PDP")
	public void prices_pdp()
	{
		test=extent.createTest("Verifying Prices on PDP");
		try{
			String price = PropReader.getProp("price");
		//Verifying defining attributes
		Assert.assertTrue(driver.findElement(By.xpath(price)).isDisplayed());	
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Prices is not displayed", ExtentColor.RED));
		}
		
	}				
		
		
	@Test(priority = 5, description="PDP>>Test No.5>> Verify add to Wishlist is displayed")
	public void wish()
	{
		test=extent.createTest("Verify add to Wishlist is displayed");
		try
		{
			String wish = PropReader.getProp("wish");
			//Verifying Wishlist icon is displayed
			wait(By.xpath(wish));
			Assert.assertTrue(driver.findElement(By.xpath(wish)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Wishlist icon is not displayed", ExtentColor.RED));
		}
		
	}
	
	@Test(priority = 6, description="PDP Page>> Test Case No.6>> Verify Product image displayed")
	public void Product_Image() throws InterruptedException
	{
		test = extent.createTest("Verify Product Image");
		String error = null;
		try {
		
			String PDPItemImage = PropReader.getProp("PDPItemImage");
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
	
	
		@Test(priority = 7, description="PDP Page>> Test Case No. 7>> Pincode validation")
		public void Pincode_Validation() throws InterruptedException
		{
			test = extent.createTest("Verify pincode");
			String error = null;
			try {
		    String PincodeEdit = PropReader.getProp("PincodeEdit");
		    String PincodeUpdate = PropReader.getProp("PincodeUpdate");
		    String Pincodevalidation = PropReader.getProp("Pincodevalidation");
		    
			wait(By.xpath(PincodeEdit));
			error = PincodeEdit;
			driver.findElement(By.xpath(PincodeEdit)).clear();
			error = "not able to edit pincode";
			driver.findElement(By.xpath(PincodeEdit)).sendKeys("123");
			error = PincodeUpdate;
			driver.findElement(By.xpath(PincodeUpdate)).click();
			wait(By.xpath(Pincodevalidation));
			error = "Validation message not showing";
			Assert.assertEquals(driver.findElement(By.xpath(Pincodevalidation)).getText(), "Minimum length of this field should be 6 digits. Only numbers allowed.");
			
				} catch (AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
				}	
		}
		
        @Test(priority = 8, description="PDP Page>> Test Case No. 8>> Verify Product Detail Section")
			public void ProductDetailSection() throws InterruptedException
			{
				test = extent.createTest("Verify product detail section");
				String error = null;
				try {
					String details_tab = PropReader.getProp("details_tab");
					String reviews_tab = PropReader.getProp("reviews_tab");
					String Questions_tab = PropReader.getProp("Questions_tab");
			    // verify details tab 
				wait(By.xpath(details_tab));
				error = details_tab;
				Assert.assertEquals(driver.findElement(By.xpath(details_tab)).getText(), "Details");
				  // verify details tab 
				wait(By.xpath(reviews_tab));
				error = reviews_tab;
				Assert.assertEquals(driver.findElement(By.xpath(reviews_tab)).getText(), "Reviews");
				  // verify Questions tab 
				wait(By.xpath(Questions_tab));
				error = Questions_tab;
				Assert.assertEquals(driver.findElement(By.xpath(Questions_tab)).getText(), "Questions");
				
				
					} catch (AssertionError e)
					{
						test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
					}	
			}

	//@Test(priority = 9, description="PDP>>Test No.9 Verifying Breadcrumbs")
	public void breadcrumbs_pdp()
	{
		String error=null;
		test=extent.createTest("Verifying Breadcrumbs");
		try{
			String breadcrumb = PropReader.getProp("breadcrumb");
			String breadcrumb_link = PropReader.getProp("breadcrumb_link");
			//String plp_Page = PropReader.getProp("plp_Page");
			
		//Verifying Breadcrumb is displayed
			error=breadcrumb;
		Assert.assertTrue(driver.findElement(By.xpath(breadcrumb)).isDisplayed());
		//Verifying Navigation
		error=breadcrumb_link;
		Assert.assertTrue(driver.findElement(By.xpath(breadcrumb_link)).isDisplayed());
		//WebElement brd=driver.findElement(By.xpath(breadcrumb_link));
		//Actions act=new Actions(driver);
		//act.moveToElement(brd).click().build().perform();
		//Verifying User lands on PLP
		//error=plp_Page;
		//Assert.assertTrue(driver.findElement(By.xpath(plp_Page)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
		}
		
	}
		
		
		
		
	
	
	
}
