package com.boddess.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;

import junit.framework.Assert;






public class PLP extends Reporting 
{
	
	public void PLP_Navigation() throws InterruptedException
	{ 
		String CategoriesTopMenu = PropReader.getProp("CategoriesTopMenu");
		String SkinCategory = PropReader.getProp("SkinCategory");
		//String PLP_SkinBrightening = PropReader.getProp("PLP_SkinBrightening");
		
		
		//Waiting for Top Category is displayed
		wait(By.xpath(CategoriesTopMenu));
		//Mouse hover on CategoriesTopMenu 
		Mouseover(By.xpath(CategoriesTopMenu));
		//Waiting for Top Category is displayed
		wait(By.xpath(SkinCategory));
		//Mouse hover on CategoriesTopMenu 
		//Mouseover(By.xpath(SkinCategory));
		//Clicking on Skin
		//wait(By.xpath(PLP_SkinBrightening));
		driver.findElement(By.xpath(SkinCategory)).click();
	}
	
	@Test(priority = 1, description="PLP>>Test No.1 Verifying if Banner is displayed on PLP Page")
	public void plp() throws InterruptedException
	{
		test=extent.createTest("Verifying if Banner is displayed on PLP Page");
		//Navigation to PLP
		PLP_Navigation();
		try {
			String Skin_banner = PropReader.getProp("Skin_banner");
			
			
			//Verifying PLP Banner
			Mouseover(By.xpath(Skin_banner));
			wait(By.xpath(Skin_banner));
			Assert.assertTrue(driver.findElement(By.xpath(Skin_banner)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("PLP Banner is not displayed", ExtentColor.RED));
		}
	}
	
	
	@Test(priority = 2, description="PLP>>Test No.2 Verifying Breadcrumb on PLP Page")
	public void bread_plp() throws InterruptedException
	{
		String error=null;
		test=extent.createTest("Verifying Breadcrumb on PLP Page");
		try {
			String CategoriesTopMenu  = PropReader.getProp("CategoriesTopMenu");
			String Skin_Brightening_SubCat = PropReader.getProp("Skin_Brightening_SubCat");
			String SkinCategory = PropReader.getProp("SkinCategory");
			String bread_plp = PropReader.getProp("bread_plp");
			String bread_link = PropReader.getProp("bread_link");
			String Skin_banner = PropReader.getProp("Skin_banner");
			
			//Mouse hover on Products
			Mouseover(By.xpath(CategoriesTopMenu));
			//Waiting for SkinCategory Category is displayed
			wait(By.xpath(SkinCategory));
			Mouseover(By.xpath(SkinCategory));
			//Clicking on Skin_Brightening_Sub Category
			driver.findElement(By.xpath(Skin_Brightening_SubCat)).click();
			//Verifying PLP Banner
			error="Breadcrumb is not displayed";
			Mouseover(By.xpath(bread_plp));
			wait(By.xpath(bread_plp));
			//clicking on Skin link on Breadcrumb
			error="Skin link is not displayed";
			wait(By.xpath(bread_link));
			//Clicking on Skin from breadcrumb
			driver.findElement(By.xpath(bread_link)).click();
			//WebElement temp=driver.findElement(By.xpath(bread_link));
			//Actions act=new Actions(driver);
			//act.moveToElement(temp).click().build().perform();
			//Verifying Skin_banner  is displayed
			error="Not redirected to Skin page";
			wait(By.xpath(Skin_banner));
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.RED));
		}
	}
	
	//@Test(priority = 3, description="PLP>>Test No.3 Verifying Breadcrumb and redirection on respective pages")
		public void bread_crumb	() throws InterruptedException
		{
		test=extent.createTest("Verifying Breadcrumb and redirection on respective pages");
		//Navigating to Homepage
		navHomepage();
		String error = null;
		try {
			//Mouse hover on Products
			wait(By.xpath(Apparel_Category));
			Mouseover(By.xpath(Apparel_Category));
			//Clicking on PLP_Women_Dresses
			driver.findElement(By.xpath(PLP_Women_Dresses)).click();
			//Verifying Breadcrumb 
			error=breadcrumb;
			wait(By.xpath(breadcrumb));
			//Clicking on Home page link on Breadcrumb
			WebElement temp=driver.findElement(By.xpath("//a[contains(text(),'Home >')]"));
			Actions act=new Actions(driver);
			act.moveToElement(temp).click().build().perform();
			//Verifying user landed on Homepage
			error=Homepage_banner;
			wait(By.xpath(Homepage_banner));
			Assert.assertTrue(driver.findElement(By.xpath(Homepage_banner)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
		}
	}
	
	@Test(priority = 4, description="PLP>>Test No.4 Verifying Static Text on PLP Page")
	public void static_plp() throws InterruptedException
	{
		test=extent.createTest("Verifying Static Text on PLP Page");
		try {
			String CategoriesTopMenu  = PropReader.getProp("CategoriesTopMenu");
			String Skin_Brightening_SubCat = PropReader.getProp("Skin_Brightening_SubCat");
			String SkinCategory = PropReader.getProp("SkinCategory");
			String static_plp = PropReader.getProp("static_plp");
			
			//Mouse hover on Products
			Mouseover(By.xpath(CategoriesTopMenu));
			//Waiting for SkinCategory Category is displayed
			wait(By.xpath(SkinCategory));
			Mouseover(By.xpath(SkinCategory));
			//Clicking on Skin_Brightening_Sub Category
			driver.findElement(By.xpath(Skin_Brightening_SubCat)).click();
			//Verifying PLP Tile 
			wait(By.xpath(static_plp));
			Mouseover(By.xpath(static_plp));
			Assert.assertTrue(driver.findElement(By.xpath(static_plp)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Static text is not displayed", ExtentColor.RED));
		}
	}	
	
	// @Test(priority=5, description = "PLP>>Test No.5 Verifying Price Sorting Option")
		public void subCategorySortAsc() throws InterruptedException
		{
			test = extent.createTest("PLP>>Verifying Sorting Options from low to high");
			String Error=null;
			try
			{
				String sortopt = PropReader.getProp("sortopt");
				String ProductPrice = PropReader.getProp("ProductPrice");
				String sortPrice = PropReader.getProp("sortPrice");
				//String  = PropReader.getProp("");
			//Clicking on Sort option
			WebElement sort=driver.findElement(By.xpath(sortopt));
			sort.click();
			//Clicking on Price Sort 
			WebElement sort1=driver.findElement(By.xpath(sortPrice));
			sort1.click();
			//Verifying Sort Option got selected
			String temp=driver.findElement(By.xpath(sortopt)).getText();
			Assert.assertEquals(temp, "Price");
			//Verifying Prices
			ArrayList<WebElement> Prices = (ArrayList<WebElement>)driver.findElements(By.xpath(ProductPrice));
			for(int i=0;i<Prices.size()-1;i++)
			{
				double temp2=Double.parseDouble(Prices.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
				double temp3=Double.parseDouble(Prices.get(i+1).getText().replaceAll("[^a-zA-Z0-9]", ""));
				if(temp2>temp3)		
				{
					Error="Sorting Failed";
					break;
				}
			}
			}
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(Error, ExtentColor.RED));
			}
		}
	 
	//@Test(priority=6, description = "PLP>>Test No.6 Verify filters displayed and its application and Removal")
	public void filter()
	{
		String error=null;
		test = extent.createTest("Verify the filters displayed and its application and Removal");
		try {
			//Verifying Product is displayed 
			wait(By.xpath(prd));
			error=Pricefilter;
			//Clicking on Filter options
			WebElement fil=driver.findElement(By.xpath(Pricefilter));
			fil.click();
			fil.click();
			error=Price_Range_filter;
			//Selecting Price Range filter
			WebElement pinefil=driver.findElement(By.xpath(Price_Range_filter));
			pinefil.click();
			error=Savebtn;
			//Clicking on Save button
			wait(By.xpath(Savebtn));
			driver.findElement(By.xpath(Savebtn)).click();
			//Verifying first product is removed
			//wait(By.xpath(prd));
			//Clicking on Close button
			driver.findElement(By.xpath(cls)).click();
			//Verifying Product gets displayed
			wait(By.xpath(prd));
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
		}		
	}
		
		
	
	//@Test(priority =7, description = "PLP>>Test No.7 Verify User Navigation to wishlist as Guest")
	public void wishlist_Guest_User() throws InterruptedException
	{
		test = extent.createTest("Verify User Navigation to wishlist as Guest");
		try {
			WebDriverWait wait=new WebDriverWait(driver, 120);
			wait(By.xpath(homepage_Wishlist));
			//Verifying on clicking Wishlist Login form is displayed
			WebElement wishlogo= driver.findElement(By.xpath(homepage_Wishlist));
			Actions act=new Actions(driver);
			act.moveToElement(wishlogo).click().build().perform();
			//Putting assertion that login pop-up is displayed
			wait(By.xpath(LoginPopup));
			//Closing the login pop-up
			WebElement close=driver.findElement(By.xpath(LoginPopupClose));
			close.click();
			wait.until(ExpectedConditions.invisibilityOf(close));
			
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Login pop-up not displayed on clicking Wishlist as Guest", ExtentColor.RED));
		}		
		
	}

    //  @Test(priority = 8, description = "PLP>>Test No.8 Verify User Navigation to wishlist as Logged In")
     public void wishlist_loggedIn() throws InterruptedException
     {
	  test = extent.createTest("Verify User Navigation to wishlist as Logged In");
	  try {
		//Calling Login Function
		login();
		//Putting wait on 1st product to be displayed
		Mouseover(By.xpath(prd));
		wait(By.xpath(wishlistico));
		//Verifying Wishlist icon/Navigation
		wait(By.xpath(homepage_Wishlist));
		WebElement wishlogo= driver.findElement(By.xpath(homepage_Wishlist));
		Actions act=new Actions(driver);
		act.moveToElement(wishlogo).click().build().perform();
		//putting assertion on wishlist empty page
		wait(By.xpath(wishlistEmpty));
		//Mousehover on My Account Icon
		Mouseover(By.xpath(MyAccountIconXpath));
		//Sign Out
		driver.findElement(By.xpath(SignOut)).click();
		close_newsletter();
		
	  }
	catch(AssertionError e)
	{
		test.log(Status.FAIL, MarkupHelper.createLabel("Wishlist Page not displayed for Logged In User", ExtentColor.RED));
	}		
	
}
      

	//@Test(priority=9, description = "PLP>>Test No.9 Verifying sub category sorting from high to low")
	public void subCategorySortDsc() throws InterruptedException
	{
		//Mouse hover on Products
		wait(By.xpath(Apparel_Category));
		Mouseover(By.xpath(Apparel_Category));
		//Clicking on PLP_Women_Dresses
		driver.findElement(By.xpath(PLP_Women_Dresses)).click();
		test = extent.createTest("Verifying sub category sorting from high to low");
		String Error=null;
		try
		{
		//Clicking on Sort option
		WebElement sort=driver.findElement(By.xpath(PLPsort));
		Thread.sleep(5000);
		sort.click();
		//Clicking on Sort Low to High
		WebElement sort1=driver.findElement(By.xpath(sortHtoLX));
		sort1.click();
		//Verifying Sort Option got selected
		String temp=driver.findElement(By.xpath(sortopt)).getText();
		Assert.assertEquals(temp, "Price High to Low");
		//Verifying Prices
		ArrayList<WebElement> Prices = (ArrayList<WebElement>)driver.findElements(By.xpath(prices));
		for(int i=0;i<Prices.size()-1;i++)
		{
			double temp2=Double.parseDouble(Prices.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
			double temp3=Double.parseDouble(Prices.get(i+1).getText().replaceAll("[^a-zA-Z0-9]", ""));
			if(temp2<temp3)		
			{
				Error="Sorting Failed";
				break;
			}
		}
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(Error, ExtentColor.RED));
		}
	}
	
	// @Test(priority = 10, description = "PLP>>Test No.10 Verify page navigation from PLP to PDP")
     public void Page_Navigation() throws InterruptedException
     {
	  test = extent.createTest("Verify page navigation from PLP to PDP");
	  try {
		 Mouseover(By.xpath(Apparel_Category));
		//Clicking on Dresses
		driver.findElement(By.xpath(PLP_Women_Dresses)).click();
		//Clicking on Product Name
		Mouseover(By.xpath(prd_new));
		WebElement temp=driver.findElement(By.xpath(prd_new));
		Actions action = new Actions(driver);
		action.moveToElement(temp).click(temp).build().perform();
		//Verifying Product Name is displayed on PDP
		wait(By.xpath(prdnamePDP));
		Assert.assertTrue(driver.findElement(By.xpath(prdnamePDP)).isDisplayed());
		
	  }
	catch(AssertionError e)
	{
		test.log(Status.FAIL, MarkupHelper.createLabel("Wishlist Page not displayed for Logged In User", ExtentColor.RED));
	}		
	
	}
	 

}


	

	
	

