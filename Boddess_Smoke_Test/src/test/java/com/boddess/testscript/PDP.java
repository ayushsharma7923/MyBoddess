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


@SuppressWarnings("unused")
public class PDP extends Reporting

{	
	public void closeHomepgaePopUp(By by)
	{
		String NoThanksId = PropReader.getProp("NoThanksId");
		String SitelogoXpath = PropReader.getProp("SitelogoXpath");
		wait(By.id(NoThanksId));
		driver.findElement(By.id(NoThanksId)).click();
		
	}
	
	public void PDP_Navigation() throws InterruptedException
	{
		driver.navigate().to("https://www.boddess.com/laneige-moist-cream-cleansers-150ml");
		
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
	public void qty_addtoCart() throws InterruptedException
	{
		test=extent.createTest("Verifying Quantity and Add to cart");
	
		String error = null;
		try{
			
			String qty_listbox = PropReader.getProp("qty_listbox");
			String addToBag_button = PropReader.getProp("addToBag_button");
		//Verifying QTY box dates is displayed
		wait(By.xpath(qty_listbox));	
		//Mouseover(By.xpath(qty_listbox));
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
	public void social() throws InterruptedException
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
	
	public void prices_pdp() throws InterruptedException
	{
		test=extent.createTest("Verifying Prices on PDP");
		String price = PropReader.getProp("price");
		try{
		
			
		//Verifying defining attributes
		Assert.assertTrue(driver.findElement(By.xpath(price)).isDisplayed());	
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Prices is not displayed", ExtentColor.RED));
		}
		
	}				
		
		
	@Test(priority = 5, description="PDP>>Test No.5>> Verify add to Wishlist is displayed")
	public void wish() throws InterruptedException
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
			String price = PropReader.getProp("price");
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
			//driver.findElement(By.xpath(PincodeUpdate)).click();
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
					String More_Information_tab = PropReader.getProp("More_Information_tab");
					
			    // verify details tab 
				wait(By.xpath(details_tab));
				error = details_tab;
				Assert.assertEquals(driver.findElement(By.xpath(details_tab)).getText(), "Details");
				  // verify details tab 
				wait(By.xpath(reviews_tab));
				error = reviews_tab;
				Assert.assertEquals(driver.findElement(By.xpath(reviews_tab)).getText(), "Reviews");
				  // verify Questions tab 
				wait(By.xpath(More_Information_tab));
				error = More_Information_tab;
				Assert.assertEquals(driver.findElement(By.xpath(More_Information_tab)).getText(), "More Information");
				
				
					} catch (AssertionError e)
					{
						test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
					}	
			}

	@Test(priority = 9, description="PDP>>Test No.9 Verifying Breadcrumbs")
	public void breadcrumbs_pdp() throws InterruptedException
	{

		String error=null;
		test=extent.createTest("Verifying Breadcrumbs");
		try{
			String breadcrumb = PropReader.getProp("breadcrumb");
			String breadcrumb_link = PropReader.getProp("breadcrumb_link");
			
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
	
	@Test(priority = 10, description="PDP Page>> Test Case No. 10>> Pincode validation check by correct pincode")
	public void Pincode_Validation_correct() throws InterruptedException
	{
		test = extent.createTest("Pincode validation check by correct pincode");
		
		String error = null;
		try {
	    String PincodeEdit = PropReader.getProp("PincodeEdit");
	    String DeliveryEstimateText = PropReader.getProp("DeliveryEstimateText");
	    
		wait(By.xpath(PincodeEdit));
		error = PincodeEdit;
		driver.findElement(By.xpath(PincodeEdit)).clear();
		error = "not able to edit pincode";
		driver.findElement(By.xpath(PincodeEdit)).sendKeys("201301");
		
		wait(By.xpath(DeliveryEstimateText));
		error = "Validation message not showing";
		Assert.assertNotEquals(driver.findElement(By.xpath(DeliveryEstimateText)).getText(), "Estimated Delivery By");
		
		
			} catch (AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
			}
	}
	
}
