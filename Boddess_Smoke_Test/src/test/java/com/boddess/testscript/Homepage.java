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
	
	
	//@Test(priority = 5, description = "Homepage>>Test Case No.5 Verify Search by Keywords Suggestion")
	public void Searchbox_sugg() throws InterruptedException
	{
		String error=null;
		test = extent.createTest("Verify Search by Keywords Suggestion");
		try
		{
		//Navigating to Homepage again
		navHomepage();
		//Verifying Search icon is displayed
		error=SearchIcon;
		wait(By.xpath(SearchIcon));
		WebElement Enter = driver.findElement(By.xpath(SearchIcon));	    
	    Enter.click();
	    //Entering Keyword
		Enter.sendKeys("Shoes");
		//Clicking on auto suggested
		error=SearchSugg;
		WebElement res= driver.findElement(By.xpath(SearchSugg));
		wait(By.xpath(SearchSugg));
		wait(By.xpath(SearchIcon));
		res.click();
		error=SearchBar;
		//Comparing the entered text to the displayed text
		WebElement restext= driver.findElement(By.xpath(SearchBar));
		//Extracting value of Entered keyword from Search Bar
		String temp=restext.getAttribute("value");
		//Extracting Keyword for which results are displayed
		error=Keywrd;
		wait(By.xpath(Keywrd));
		String temp1= driver.findElement(By.xpath(Keywrd)).getText();
		//Comparing both
		error="Keyword expected";
		Assert.assertEquals(temp.replaceAll("[^a-zA-Z0-9]", ""), temp1.replaceAll("[^a-zA-Z0-9]", ""));
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
		}
		
	}
	
	
	
	  //@Test(priority =9, description = "Homepage>>Test Case No.9>>Verify User Navigation to wishlist as Guest")
			public void wishlist_Guest_User() throws InterruptedException
			{
				test = extent.createTest("Verify User Navigation to wishlist as Guest");
				try {
					//Navigating to Homepage
					navHomepage();
					WebDriverWait wait=new WebDriverWait(driver, 120);
					wait(By.xpath(homepage_Wishlist_Guest));
					//Verifying on clicking Wishlist Login form is displayed
					WebElement wishlogo= driver.findElement(By.xpath(homepage_Wishlist_Guest));
					Actions act=new Actions(driver);
					act.moveToElement(wishlogo).click().build().perform();
					wait(By.xpath(LoginPopup));
					//Closing the login pop-up
					WebElement close=driver.findElement(By.xpath(LoginPopupClose));
					close.click();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LoginPopupClose)));
				}
				catch(AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel("Login pop-up not displayed on clicking Wishlist as Guest", ExtentColor.RED));
				}		
				
			}	
		
		//@Test(priority = 10, description = "Homepage>>Test Case No.10>>Verify User Navigation to wishlist as Logged In")
		public void wishlist_loggedIn() throws InterruptedException
		{
			test = extent.createTest("Verify User Navigation to wishlist as Logged In");
			try {
				//Calling Login Function
				login();
				//Verifying Wishlist icon/Navigation
				wait(By.xpath(homepage_Wishlist_logged));
				WebElement wishlogo= driver.findElement(By.xpath(homepage_Wishlist_logged));
				Actions act=new Actions(driver);
				act.moveToElement(wishlogo).click().build().perform();
				Assert.assertTrue(driver.findElement(By.xpath(wishlistEmpty)).isDisplayed());
				//Mousehover on My Account Icon
				Mouseover(By.xpath(MyAccountIconXpath));
				//Sign Out
				driver.findElement(By.xpath(SignOut)).click();
				//Closing newsletter pop-up
				close_newsletter();
					
			}
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel("Wishlist Page not displayed for Logged In User", ExtentColor.RED));
			}		
			
		}
		
		//@Test(priority = 11, description="Homepage>>Test Case No.11>>Verifying Best Selling Products")
		public void best_seller() throws InterruptedException
		{
			test=extent.createTest("Verifying Best Selling Products");
			String error = null;
			try
			{
				navHomepage();
				//Verifying Best Selling Products Name is displayed
				error=BestSellingPrdName;
				wait(By.xpath(BestSellingPrdName));
				//Verifying Best Selling Product Price is displayed
				error=BestSellingPrdPrice;
				wait(By.xpath(BestSellingPrdPrice));
			}
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
			}	
		}
		
		//@Test(priority = 12, description="Homepage>>Test Case No.12>> Verify Curated For you")
		public void Spotlight_Carousel()
		{
			//Navigating to Homepage
			navHomepage();
			test=extent.createTest("Verify Curated For you");
			try
			{
				//Verifying Curated for You Heading
				wait(By.xpath(CurText));
				//Verifying Curated Categories
				wait(By.xpath(CurCat));
				//Verifying Curated For you is displayed
				wait(By.xpath(Curated));
			}
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel("In the spotlight Carosuel is not displayed", ExtentColor.RED));
			}
		}
		
		//@Test(priority = 13, description="Homepage>>Test Case No.13>> Verify Trending Now Products")
		public void trendingnow()
		{
			test=extent.createTest("Verify Trending Now Products");
			try {
				//Verifying Trending Now section Heading
				wait(By.xpath(TrenHead));
				//Verifying Image of Trending Now Products
				wait(By.xpath(TrenImg));
				//Verifying Trending Now Section
				wait(By.xpath(trending));
				Assert.assertTrue(driver.findElement(By.xpath(trending)).isDisplayed());
				//Verifying Navigation to PDP page
				Mouseover(By.xpath(Trenpd1));
				driver.findElement(By.xpath(Trenpd1)).click();
				//Verifying heading of Product 1
				wait(By.xpath(trendHead));
			}
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel("Handpicked Section is not displayed", ExtentColor.RED));
			}
		}
	
	
	//@Test(priority = 14, description ="Homepage>>Test Case No. 14>>Verify footer links on Homepage") 
	  public void Footer() 
	  {
		  test = extent.createTest("Verify footer links on Homepage");
		  String error = null;
		  try  {
				// Verifying footer layer links are showing
			  	// Verifying Footer Logo
			  error=FooterBoddessLogo;
				Assert.assertTrue(driver.findElement(By.xpath(FooterBoddessLogo)).isEnabled());
				//Verifying static text displayed below Boddess logo
				error=BoddessDesription;
				Assert.assertTrue(driver.findElement(By.xpath(BoddessDesription)).isEnabled());
				// Verifying Footer About Us is showing
				error=FooterAboutUs;
				Assert.assertTrue(driver.findElement(By.xpath(FooterAboutUs)).isEnabled());
				// Verifying Footer Career is showing
				error=FooterCareers;
				Assert.assertTrue(driver.findElement(By.xpath(FooterCareers)).isEnabled());
				// Verifying Footer Stores is showing
				error=FooterStores;
				Assert.assertTrue(driver.findElement(By.xpath(FooterStores)).isEnabled());
				// Verifying Footer Quick Order is showing
				error=FooterQuickOrder;
				Assert.assertTrue(driver.findElement(By.xpath(FooterQuickOrder)).isEnabled());
				// Verifying Footer QCS is showing
				error=FooterQCS;
				Assert.assertTrue(driver.findElement(By.xpath(FooterQCS)).isEnabled());
				// Verifying Footer CS is showing
				error=FooterCS;
				Assert.assertTrue(driver.findElement(By.xpath(FooterCS)).isEnabled());
				// Verifying Footer Privacy is showing
				error=FooterPrivacy;
				Assert.assertTrue(driver.findElement(By.xpath(FooterPrivacy)).isEnabled());
				// Verifying Footer FAQ is showing
				error=FooterFAQ;
				Assert.assertTrue(driver.findElement(By.xpath(FooterFAQ)).isEnabled());
				// Verifying Footer Payment is showing
				error=FooterPayment;
				Assert.assertTrue(driver.findElement(By.xpath(FooterPayment)).isEnabled());
				// Verifying Footer T&S is showing
				error=FooterTnS;
				Assert.assertTrue(driver.findElement(By.xpath(FooterTnS)).isEnabled());
				// Verifying Footer Contact Us label is showing
				error=FooterContactUs;
				Assert.assertTrue(driver.findElement(By.xpath(FooterContactUs)).isEnabled());
				// Verifying Footer copy right label is showing
				error=CopyRight;
				Assert.assertTrue(driver.findElement(By.xpath(CopyRight)).isEnabled());
								
			  } 
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
			}
	  }
	
	//@Test(priority = 15, description ="Homepage>>Test Case No.15>>Verify newsletter subscription in footer")
	  public void news()
	  {
		  test = extent.createTest("Verify newsletter subscription in footer");
		  try {
			  //Clicking on Newsletter
			  WebElement temp=driver.findElement(By.xpath(Boddessnews));
			  Actions act=new Actions(driver);
			  act.moveToElement(temp).click().build().perform();
			  temp.sendKeys("samplenews@email.com");
			  //Clicking on submit button
			  Mouseover(By.xpath(NewsClickButton));
			  WebElement button=driver.findElement(By.xpath(NewsClickButton));
			  button.click();
			  //Verifying message is displayed
			  wait(By.xpath(NewsSuccessMsg));
		  }
		  catch(AssertionError e)
		  {
				test.log(Status.FAIL, MarkupHelper.createLabel("Success Message is not displayed", ExtentColor.RED));
			}
		  
	  }
	  

	  //@Test(priority = 16, description ="Homepage>>Test Case No.16>>Verify Social sites icons and links")
		  public void SocialLinks()
		  {
			  test = extent.createTest("Verify Social site links in footer");
			//  driver.findElement(By.xpath(OurStoryinFooterXpath)).click();
			  String error = null;
			  try  {
					// Verifying footer Twitter social site links are showing
				  	error=TwitterIcon;
					Assert.assertTrue(driver.findElement(By.xpath(TwitterIcon)).isEnabled());
					// Verifying footer FB social site links are showing
				  	error=FacebookIcon;
					Assert.assertTrue(driver.findElement(By.xpath(FacebookIcon)).isEnabled());
					// Verifying footer Insta social site links are showing
				  	error=FacebookIcon;
					Assert.assertTrue(driver.findElement(By.xpath(FacebookIcon)).isEnabled());		
					// Verifying footer LinkedIn social site links are showing
				  	error=LinkedInIcon;
					Assert.assertTrue(driver.findElement(By.xpath(LinkedInIcon)).isEnabled());
				  } 
				catch(AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
				}
		}
	
	
	
	//@Test(priority =17, description ="Homepage>>Test Case No. 17>>Verify Live Chat icon displayed on Homepage")
	public void liveChat() throws InterruptedException
	{
		//newsletter_Cookie_policy();
		String error = null;
		test=extent.createTest("Verify Live Chat icon displayed on Homepage");
		WebDriverWait wait=new WebDriverWait(driver, 60);
		try {
			//Verify live chat icon display
			error=Chat_Icon;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Chat_Icon)));
			Assert.assertTrue(driver.findElement(By.xpath(Chat_Icon)).isDisplayed());
			//Navigate to open live chat icon
			WebElement chat= driver.findElement(By.xpath(Chat_Icon));
			chat.click();
			//Verify chat text title "Questions? Chat with us!" when open the chat box
			error=Chat_text_Title;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Chat_text_Title)));
			Assert.assertTrue(driver.findElement(By.xpath(Chat_text_Title)).isDisplayed());
			//Verify to close live chat box
			driver.findElement(By.xpath(Chat_close)).click();
		}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
		}
	}
	
	//@Test(priority =18, description ="Homepage>>Test Case No. 18>>Verify Banner and Carousal Dots displayed on Homepage")
	public void banner() throws InterruptedException
	{
		String error = null;
		test=extent.createTest("Verify Banner and Carousal Dots displayed on Homepage");
		try
		{
			//Verifying Banner on Home page
			error="banner";
			wait(By.xpath(banner));
			//Verifying Banner Carousal on Home page
			error="Banner Carousal";
			wait(By.xpath(bannerCar));
		}
		catch (AssertionError e) {
			test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
		}
	}
}
	

