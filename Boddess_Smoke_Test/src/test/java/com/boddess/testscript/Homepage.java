package com.boddess.testscript;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.boddess.reporting.Reporting;

@SuppressWarnings("unused")
public class Homepage extends Reporting

{	
	
	@Test(priority = 1, description="Homepage>> Test Case No.1>> Verify Boddess logo on Homepage")
	public void Header_Links()
	{
		test=extent.createTest("Verify Boddess Logo is displaying");
		String error = null;
		try {
		String NoThanksId = PropReader.getProp("NoThanksId");
		String SiteloadPopupCloseButtonXpath = PropReader.getProp("SiteloadPopupCloseButtonXpath");
		String SitelogoXpath = PropReader.getProp("SitelogoXpath");
		wait(By.id(NoThanksId));
		driver.findElement(By.id(NoThanksId)).click();
		wait(By.xpath(SiteloadPopupCloseButtonXpath));
		driver.findElement(By.xpath(SiteloadPopupCloseButtonXpath)).click();
		wait(By.xpath(SitelogoXpath));
		error = "Site logo";
		Assert.assertTrue(driver.findElement(By.xpath(SitelogoXpath)).isDisplayed());
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "is not displayed", ExtentColor.RED));
		}
	}
	
	@Test(priority = 2, description="Homepage>>Test Case No.2>> Verify Boddess categories on Homepage")
	public void Header_Links1() throws InterruptedException
	{
		test=extent.createTest("Verify Boddess categories on Homepage");
	    String error = null;
	    //Sticky Header Links
		try  {
			String SitelogoXpath = PropReader.getProp("SitelogoXpath");
			String CategoriesTopMenu = PropReader.getProp("CategoriesTopMenu");
			String BrandsMenu = PropReader.getProp("BrandsMenu");
			String OffersMenu= PropReader.getProp("OffersMenu");
			String VirtualMenu= PropReader.getProp("VirtualMenu");
			String RewardsMenu= PropReader.getProp("RewardsMenu");
			String BoddessEditMenu= PropReader.getProp("BoddessEditMenu");
			String SearchBar = PropReader.getProp("SearchBar");
			String WishlistIcon= PropReader.getProp("WishlistIcon");
			String CartIcon = PropReader.getProp("CartIcon");
			String SignInIcon = PropReader.getProp("SignInIcon");
			
		// Verifying Boddess Icons
		error="Boddess Logo";
		Assert.assertTrue(driver.findElement(By.xpath(SitelogoXpath)).isDisplayed());
		// Verifying Categories Top Menu is showing
		error="Categories Top Menu";
		Assert.assertTrue(driver.findElement(By.xpath(CategoriesTopMenu)).isDisplayed());
		// Verifying Brands Category is showing
		error="Brands Menu";
		Assert.assertTrue(driver.findElement(By.xpath(BrandsMenu)).isDisplayed());
		// Verifying Offers Category is showing
		error="Offers Menu";
		Assert.assertTrue(driver.findElement(By.xpath(OffersMenu)).isDisplayed());
		// Verifying Virtual Pro Menu is showing
		error="Virtual Pro Menu";
		Assert.assertTrue(driver.findElement(By.xpath(VirtualMenu)).isDisplayed());
		// Verifying Rewards Menu is showing
		error="Rewards Menu";
		Assert.assertTrue(driver.findElement(By.xpath(RewardsMenu)).isDisplayed());
		// Verifying Boddess Edit Menu is showing
		error="Boddess Edit Menu";
		Assert.assertTrue(driver.findElement(By.xpath(BoddessEditMenu)).isDisplayed());
		//Verifying Search box on header
		error="Search Bar";
		Assert.assertTrue(driver.findElement(By.xpath(SearchBar)).isDisplayed());
		//Verifying Wishlist icon
		error="Wishlist Icon";
		Assert.assertTrue(driver.findElement(By.xpath(WishlistIcon)).isDisplayed());
		//Verifying Cart icon
		error="CartIcon";
		Assert.assertTrue(driver.findElement(By.xpath(CartIcon)).isDisplayed());
		//Verifying My Account icon
		error="My Account Icon";
		Assert.assertTrue(driver.findElement(By.xpath(SignInIcon)).isDisplayed());
		} 
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
		}
	}	
	
	
	//@Test(priority = 3, description="Homepage>>Test Case No.3>> Verify category navigations")
	public void cat_Navigation()
	{
		String error=null;
		test = extent.createTest("Verify category navigations");
		try
		{   
			String CategoriesTopMenu = PropReader.getProp("CategoriesTopMenu");
			String SkinCategory = PropReader.getProp("SkinCategory");
			String  Skinhead= PropReader.getProp("Skinhead");
			String MakeupCategory= PropReader.getProp("MakeupCategory");
			String Makeuphead= PropReader.getProp("Makeuphead");
			String HairCategory= PropReader.getProp("HairCategory");
			String HairHead= PropReader.getProp("HairHead");
			String BathBodyCategory = PropReader.getProp("Bath&BodyCategory");
			String BathBodyhead= PropReader.getProp("Bath&Bodyhead");
			String EssentialsCategory = PropReader.getProp("EssentialsCategory");
			String Essentialshead= PropReader.getProp("Essentialshead");
			String FragranceCategory= PropReader.getProp("FragranceCategory");
			String Fragrancehead= PropReader.getProp("Fragrancehead");
			String ToolsAccessoriesCategory = PropReader.getProp("ToolsAccessoriesCategory");
			String ToolsAccessorieshead = PropReader.getProp("ToolsAccessorieshead");
			String GiftsCategory = PropReader.getProp("GiftsCategory");
			String Giftshead = PropReader.getProp("Giftshead");
			
			//Mouse hover on Categories Top  Category
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			//Verifying Skin category is displayed
			error=SkinCategory;
			wait(By.xpath(SkinCategory));
			//Navigation to Skin CLP page
			driver.findElement(By.xpath(SkinCategory)).click();
			//Verifying user is on Skin CLP page
			wait(By.xpath(Skinhead));
			//Verifying Makeup category is displayed 
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			error=MakeupCategory;
			wait(By.xpath(MakeupCategory));
			//Navigation to Makeup PLP page
			driver.findElement(By.xpath(MakeupCategory)).click();
			//Verifying user is on Makeup CLP page
			wait(By.xpath(Makeuphead));
			//Verifying Hair Category link is displayed 
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			error=HairCategory;
			wait(By.xpath(HairCategory));
			//Navigating to Hair PLP link is displayed
			driver.findElement(By.xpath(HairCategory)).click();
			error=HairHead;
			//Verifying user in on Hair PLP page
			wait(By.xpath(HairHead));
			//Verifying Bath & Body link is displayed
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			error=BathBodyCategory;
			wait(By.xpath(BathBodyCategory));
			//Navigating to BathBodyCategory PLP on Products Category
			driver.findElement(By.xpath(BathBodyCategory)).click();
			//Verifying User is on BathBodyCategory PLP
			error=BathBodyhead;
			wait(By.xpath(BathBodyhead));
			//Verifying EssentialsCategory category are displayed
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			error=EssentialsCategory;
			wait(By.xpath(EssentialsCategory));
			//Navigating to Essentials PLP
			driver.findElement(By.xpath(EssentialsCategory)).click();
			//Verifying User is on Essentials PLP page
			wait(By.xpath(Essentialshead));
			//Verifying Fragrance Category  is displayed
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			error=FragranceCategory;
			wait(By.xpath(FragranceCategory));
			//Navigating to FragranceCategory PLP page 
			driver.findElement(By.xpath(FragranceCategory)).click();
			//Verifying FragranceCategory PLP page
			wait(By.xpath(Fragrancehead));
			// Verifying Tools Accessories Category  is displayed
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			error=ToolsAccessoriesCategory;
			wait(By.xpath(ToolsAccessoriesCategory));
			//Navigating to Tools Accessories Category
			driver.findElement(By.xpath(ToolsAccessoriesCategory)).click();
			//Verifying user is on Tools Accessories Category PLP page 
			error=ToolsAccessorieshead;
			wait(By.xpath(ToolsAccessorieshead));
			//Verifying Gifts Category is displayed
			error=CategoriesTopMenu;
			Mouseover(By.xpath(CategoriesTopMenu));
			error=GiftsCategory;
			wait(By.xpath(GiftsCategory));
			//Navigating to Gifts Category PLP
			driver.findElement(By.xpath(GiftsCategory)).click();
			//Verifying Gifts Category PLP page
			error=Giftshead;
			wait(By.xpath(Giftshead));	
		}
		catch(AssertionError e)
		{
		test.log(Status.FAIL, MarkupHelper.createLabel(error+"  is not displayed", ExtentColor.RED));
		}
	}
	
	//@Test(priority = 4, description = "Homepage>>Test Case No.4>> Verify search by user entered keyword")	
	public void Searchbox() throws InterruptedException
	{
		String error=null;
		test = extent.createTest("Verify search by user entered keyword");
		try 
		{
			String SearchIcon = PropReader.getProp("SearchIcon");
			String searchText= PropReader.getProp("searchText");
			String  placeText= PropReader.getProp("placeText");
			String SearchResult= PropReader.getProp("SearchResult");
			
		error=SearchIcon;
		//Verifying the Search bar placeholder text
		String placeholderText=driver.findElement(By.xpath(searchText)).getAttribute("placeholder");
		Assert.assertEquals(placeholderText, placeText);
		//Clicking on Search field
		wait(By.xpath(SearchIcon));
		WebElement Enter = driver.findElement(By.xpath(SearchIcon));	    
	    Enter.click();
	    Thread.sleep(5000);
	    //Entering keyword
		Enter.sendKeys("Cream");
		Thread.sleep(5000);
		Enter.sendKeys(Keys.ENTER);
		//Verifying Search results displayed
		error=SearchResult;
		wait(By.xpath(SearchResult));
		} 
		catch(AssertionError e)
		{
		test.log(Status.FAIL, MarkupHelper.createLabel(error+"  is not displayed", ExtentColor.RED));
		}	
	}
	
	
	
	
	
	
	 
		
		
		
		
		
		
	
	
	//@Test(priority = 14, description ="Homepage>>Test Case No. 14>>Verify footer links on Homepage") 
	  public void Footer() 
	  {
		  test = extent.createTest("Verify footer links on Homepage");
		  String error = null;
		  try  {
			  String FooterAboutBodess = PropReader.getProp("FooterAboutBodess");
			  String FooterCareers = PropReader.getProp("FooterCareers");
			  String FooterStores = PropReader.getProp("FooterStores");
			  
				// Verifying footer layer links are showing
			  	// Verifying Footer Logo
			   // error=FooterBoddessLogo;
				//Assert.assertTrue(driver.findElement(By.xpath(FooterBoddessLogo)).isEnabled());
				//Verifying static text displayed below Boddess logo
				//error=BoddessDesription;
				//Assert.assertTrue(driver.findElement(By.xpath(BoddessDesription)).isEnabled());
				// Verifying Footer About Us is showing
				error=FooterAboutBodess;
				Assert.assertTrue(driver.findElement(By.xpath(FooterAboutBodess)).isEnabled());
				// Verifying Footer Career is showing
				error=FooterCareers;
				Assert.assertTrue(driver.findElement(By.xpath(FooterCareers)).isEnabled());
				// Verifying Footer Stores is showing
				error=FooterStores;
				Assert.assertTrue(driver.findElement(By.xpath(FooterStores)).isEnabled());
				
								
			  } 
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
			}
	  }
	
	
	
	
}
	

