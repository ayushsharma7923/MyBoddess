package com.boddess.testscript;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

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
	public void closeHomepgaePopUp(By by)
	{
		String NoThanksId = PropReader.getProp("NoThanksId");
		String SitelogoXpath = PropReader.getProp("SitelogoXpath");
		wait(By.id(NoThanksId));
		driver.findElement(By.id(NoThanksId)).click();
	
	}
	
	@Test(priority = 1, description="Homepage>> Test Case No.1>> Verify Boddess logo on Homepage")
	public void Header_Links()
	{
		test=extent.createTest("Verify Boddess Logo is displaying");
		String error = null;
		try {
		String NoThanksId = PropReader.getProp("NoThanksId");
		String SitelogoXpath = PropReader.getProp("SitelogoXpath");
		wait(By.id(NoThanksId));
		driver.findElement(By.id(NoThanksId)).click();
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
	
	
		
		@Test(priority = 3, description="Homepage>>Test Case No.3>> Verify category navigations")
		public void cat_Navigation() throws InterruptedException
		{
			String error=null;
			
			//closeHomepgaePopUp(null);
			test = extent.createTest("Verify category navigations");
			try
			{   
				String CategoriesTopMenu = PropReader.getProp("CategoriesTopMenu");
				String SkinCategory = PropReader.getProp("SkinCategory");
				String Skinhead= PropReader.getProp("Skinhead");
				String MakeupCategory= PropReader.getProp("MakeupCategory");
				String Makeuphead= PropReader.getProp("Makeuphead");
				String HairCategory= PropReader.getProp("HairCategory");
				String HairHead= PropReader.getProp("HairHead");
				String BathBodyCategory = PropReader.getProp("BathBodyCategory");
				String BathBodyhead= PropReader.getProp("BathBodyhead");
				String EssentialsCategory = PropReader.getProp("EssentialsCategory");
				String Essentialshead= PropReader.getProp("Essentialshead");
				String FragranceCategory= PropReader.getProp("FragranceCategory");
				String Fragrancehead= PropReader.getProp("Fragrancehead");
				String ToolsAccessoriesCategory = PropReader.getProp("ToolsAccessoriesCategory");
				String ToolsAccessorieshead = PropReader.getProp("ToolsAccessorieshead");
				String GiftsCategory = PropReader.getProp("GiftsCategory");
				String Giftshead = PropReader.getProp("Giftshead");
				
			
				
				//Mouse hover on Apparel Category
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
				
				Thread.sleep(2000);
				error=CategoriesTopMenu;
				Mouseover(By.xpath(CategoriesTopMenu));
				error=MakeupCategory;
				wait(By.xpath(MakeupCategory));
				//Navigation to Makeup PLP page
				driver.findElement(By.xpath(MakeupCategory)).click();
				//Verifying user is on Makeup CLP page
				wait(By.xpath(Makeuphead));
				
				Thread.sleep(2000);
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
				
				Thread.sleep(2000);
				error=CategoriesTopMenu;
				Mouseover(By.xpath(CategoriesTopMenu));
				error=BathBodyCategory;
				wait(By.xpath(BathBodyCategory));
				//Navigating to Skirts PLP on Products Category
				driver.findElement(By.xpath(BathBodyCategory)).click();
				//Verifying User is on Skirts PLP
				error=BathBodyhead;
				wait(By.xpath(BathBodyhead));
				//Verifying Tops category are displayed
				
				Thread.sleep(2000);
				error=CategoriesTopMenu;
				Mouseover(By.xpath(CategoriesTopMenu));
				error=EssentialsCategory;
				wait(By.xpath(EssentialsCategory));
				//Navigating to Essentials PLP
				driver.findElement(By.xpath(EssentialsCategory)).click();
				//Verifying User is on Essentials PLP page
				wait(By.xpath(Essentialshead));
				//Verifying Fragrance Category  is displayed
				
				Thread.sleep(2000);
				error=CategoriesTopMenu;
				Mouseover(By.xpath(CategoriesTopMenu));
				error=FragranceCategory;
				wait(By.xpath(FragranceCategory));
				//Navigating to Boys PLP page 
				driver.findElement(By.xpath(FragranceCategory)).click();
				//Verifying Boys PLP page
				wait(By.xpath(Fragrancehead));
				// Verifying Tools Accessories Category  is displayed
				
				Thread.sleep(2000);
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
				Thread.sleep(2000);
				error=CategoriesTopMenu;
				Mouseover(By.xpath(CategoriesTopMenu));
				error=GiftsCategory;
				wait(By.xpath(GiftsCategory));
				//Navigating to Gifts Category PLP
				driver.findElement(By.xpath(GiftsCategory)).click();
				//Verifying Gifts Category PLP page
				error=Giftshead;
				wait(By.xpath(Giftshead));	
				Thread.sleep(2000);	
			
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
				//navHomepage();
				
				String SearchIcon = PropReader.getProp("SearchIcon");
				String searchText= PropReader.getProp("searchText");
				String placeText= PropReader.getProp("placeText");
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
			String SearchIcon =PropReader.getProp("SearchIcon");;
			//Navigating to Homepage again
			//navHomepage();
			//Verifying Search icon is displayed
			error=SearchIcon;
			wait(By.xpath(SearchIcon));
			WebElement Enter = driver.findElement(By.xpath(SearchIcon));	    
		    Enter.click();
		    //Entering Keyword
			Enter.sendKeys("Shoes");
			String SearchSugg = null;
			//Clicking on auto suggested
			error=SearchSugg;
			WebElement res= driver.findElement(By.xpath(SearchSugg));
			wait(By.xpath(SearchSugg));
			wait(By.xpath(SearchIcon));
			res.click();
			String SearchBar = null;
			error=SearchBar;
			//Comparing the entered text to the displayed text
			WebElement restext= driver.findElement(By.xpath(SearchBar));
			//Extracting value of Entered keyword from Search Bar
			String temp=restext.getAttribute("value");
			String Keywrd = null;
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
		
		//@Test(priority = 6, description = "Homepage>>Test Case No.6>>Verify the sorting Options from Low to High on Search Page")
		public void search_sort()
		{
			test = extent.createTest("Verify the sorting Options from Low to High on Search Page");
			String Error=null;
			try
			{
			String SearchSort = null;
			//Clicking on Sort option
			WebElement sort=driver.findElement(By.xpath(SearchSort));
			sort.click();
			String sortltoHX = null;
			//Clicking on Sort Low to High
			WebElement sort1=driver.findElement(By.xpath(sortltoHX));
			sort1.click();
			String sortopt = null;
			//Verifying Sort Option got selected
			String temp=driver.findElement(By.xpath(sortopt)).getText();
			Assert.assertEquals(temp, "Price Low to High");
			String prices = null;
			//Verifying Prices
			ArrayList<WebElement> Prices = (ArrayList<WebElement>)driver.findElements(By.xpath(prices));
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
		
		//@Test(priority = 7, description = "Homepage>>Test Case No.7>> Verify the sorting Options from High to Low on Search Page")
		public void search_sortHtoL()
		{
			test = extent.createTest("Verify the sorting Options from High to Low on Search Page");
			String Error=null;
			try
			{
				String SearchSort = null;
				Error=SearchSort;
			String sortltoHX = null;
			//Clicking on Sort option
			WebElement sort=driver.findElement(By.xpath(sortltoHX));
			sort.click();
			String sortHtol = null;
			//Clicking on Sort Low to High
			Error=sortHtol;
			WebElement sort1=driver.findElement(By.xpath(sortHtol));
			sort1.click();
			String sortopt = null;
			//Verifying Sort Option got selected
			Error=sortopt;
			String temp=driver.findElement(By.xpath(sortopt)).getText();
			Assert.assertEquals(temp, "Price High to Low");
			String prices = null;
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
		
		//@Test(priority = 8, description = "Homepage>>Test Case No.8>>Verify the filter options displayed")
		public void search_filter()
		{
			String error=null;
			test = extent.createTest("Verify the filter options displayed");
			try {
				String colorfilter = null;
				//Selecting on Mayflower filter
				error=colorfilter;
				WebElement fil=driver.findElement(By.xpath(colorfilter));
				fil.click();
				String applybtn = null;
				//Clicking on Apply Button
				error=applybtn;
				//Clicking on Save button
				wait(By.xpath(applybtn));
				driver.findElement(By.xpath(applybtn)).click();
				String prd1 = null;
				//Verifying Product after filter is applied
				wait(By.xpath(prd1));
				String icon = null;
				//Navigating to Homepage again
				error=icon;
				WebElement ico=driver.findElement(By.xpath(icon));
				ico.click();
			}
			catch(AssertionError e)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			}		
			
		}
		
		  //@Test(priority =9, description = "Homepage>>Test Case No.9>>Verify User Navigation to wishlist as Guest")
				public void wishlist_Guest_User() throws InterruptedException
				{
					test = extent.createTest("Verify User Navigation to wishlist as Guest");
					try {
										
						String Homepage_Wishlist_Guest = PropReader.getProp("Homepage_Wishlist_Guest");
						String wishlistEmpty = PropReader.getProp("wishlistEmpty");

						
						//Navigating to Homepage
						//navHomepage();
						WebDriverWait wait=new WebDriverWait(driver, 120);
						
						wait(By.xpath(Homepage_Wishlist_Guest));
						
						Assert.assertTrue(driver.findElement(By.xpath(wishlistEmpty)).isDisplayed());
						
						
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
					//login();
					//Verifying Wishlist icon/Navigation
					
					String homepage_Wishlist_logged = PropReader.getProp("homepage_Wishlist_logged");
					String wishlistEmpty = PropReader.getProp("wishlistEmpty");
					String MyAccountIconXpath = PropReader.getProp("MyAccountIconXpath");
					String SignOut = PropReader.getProp("SignOut");

					wait(By.xpath(homepage_Wishlist_logged));
					WebElement wishlogo= driver.findElement(By.xpath(homepage_Wishlist_logged));
					Actions act=new Actions(driver);
					act.moveToElement(wishlogo).click().build().perform();
					Assert.assertTrue(driver.findElement(By.xpath(wishlistEmpty)).isDisplayed());
					//Mousehover on My Account Icon
					
					driver.findElement(By.xpath(MyAccountIconXpath)).click();
					//Sign Out
					driver.findElement(By.xpath(SignOut)).click();
					
						
				}
				catch(AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel("Wishlist Page not displayed for Logged In User", ExtentColor.RED));
				}		
				
			}
			
			//@Test(priority = 11, description="Homepage>>Test Case No.11>>Verifying Top Brands")
			public void topBrands() throws InterruptedException
			{
				test=extent.createTest("Verifying Top brands heading");
				String error = null;
				try
				{
				
					String TopbrandsHeading = PropReader.getProp("TopbrandsHeading");
					
					//navHomepage();
					
					error=TopbrandsHeading;
					wait(By.xpath(TopbrandsHeading));
					//Verifying Top brands heading is being displayed
					
					Assert.assertTrue(driver.findElement(By.xpath(TopbrandsHeading)).isDisplayed());

					
				}
				catch(AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel(error + "  is not displayed", ExtentColor.RED));
				}	
			}
			
			//@Test(priority = 12, description="Homepage>>Test Case No.12>> Verify Editor's Pick")
			public void EditorsPick()
			{
				
				test=extent.createTest("Verify Editor's pick");
				String error = null;
				try
				{
					
					String EditorspickHeading = PropReader.getProp("EditorspickHeading");
				
					//navHomepage();
					
					//Verifying editor's pick  Heading
					wait(By.xpath(EditorspickHeading));
					
					error=EditorspickHeading;		
					Assert.assertTrue(driver.findElement(By.xpath(EditorspickHeading)).isDisplayed());
					
				}
				catch(AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel("In the spotlight Carosuel is not displayed", ExtentColor.RED));
				}
			}
			
			//@Test(priority = 13, description="Homepage>>Test Case No.13>> Verify Bestseller section")
			public void Bestseller()
			{
				test=extent.createTest("Verify Bestseller section");
				String error = null;
				try {
					
					String BestsellerHeading = PropReader.getProp("BestsellerHeading");

					//navHomepage();
					
					//Verifying Bestseller section Heading
					wait(By.xpath(BestsellerHeading));
					
					error=BestsellerHeading;
					Assert.assertTrue(driver.findElement(By.xpath(BestsellerHeading)).isDisplayed());
					
				}
				catch(AssertionError e)
				{
					test.log(Status.FAIL, MarkupHelper.createLabel("Handpicked Section is not displayed", ExtentColor.RED));
				}
			}
		
		
		// @Test(priority = 14, description ="Homepage>>Test Case No. 14>>Verify footer links on Homepage") 
		  public void Footer() throws InterruptedException 
		  {
			  test = extent.createTest("Verify footer links on Homepage");
			  String error = null;
			  
			  try  {
				  
					String FooterBoddessLogo = PropReader.getProp("FooterBoddessLogo");				

					//navHomepage();
					
					wait(By.xpath(FooterBoddessLogo));
				  
				
				  	// Verifying Footer Logo
				  
					error=FooterBoddessLogo;
					Assert.assertTrue(driver.findElement(By.xpath(FooterBoddessLogo)).isEnabled());
					WebElement footer= driver.findElement(By.xpath("//body/div[1]/footer[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
					
					
				int footerlinksCount =	footer.findElements(By.tagName("a")).size(); //getting total links in footer

					//Assert.assertTrue(footerlinksCount==17);
				
				for(int i=1; i<footerlinksCount; i++)
				{
					
					String clickonTab = Keys.chord(Keys.CONTROL,Keys.ENTER); //opening each link in new tab
					footer.findElements(By.tagName("a")).get(i).sendKeys(clickonTab);
					 
				} // open all links in new tab
				
				Set<String> abc= driver.getWindowHandles();
				Iterator<String> it=abc.iterator(); 
				
					while (it.hasNext())
					{
						
						driver.switchTo().window(it.next());
						System.out.println(driver.getTitle());
						
					}
					
					
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
				 
					String Boddessnews = PropReader.getProp("Boddessnews");
					String NewsClickButton = PropReader.getProp("NewsClickButton");
					String NewsSuccessMsg = PropReader.getProp("NewsSuccessMsg");

					
					//navHomepage();
				  
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
		  

		 // @Test(priority = 16, description ="Homepage>>Test Case No.16>>Verify Social sites icons and links")
			  public void SocialLinks()
			  {
				  test = extent.createTest("Verify Social site links in footer");
				  //driver.findElement(By.xpath(OurStoryinFooterXpath)).click();
				  String error = null;
				  try  {
					  
					  	String TwitterIcon = PropReader.getProp("TwitterIcon");
						String FacebookIcon = PropReader.getProp("FacebookIcon");
						String InstagramIcon = PropReader.getProp("InstagramIcon");
						String PinterestIcon = PropReader.getProp("PinterestIcon");
						
						//navHomepage();
						
						// Verifying footer Twitter social site links are showing
					  	error=TwitterIcon;
						Assert.assertTrue(driver.findElement(By.xpath(TwitterIcon)).isEnabled());
						// Verifying footer FB social site links are showing
					  	error=FacebookIcon;
						Assert.assertTrue(driver.findElement(By.xpath(FacebookIcon)).isEnabled());
						// Verifying footer Insta social site links are showing
					  	error=InstagramIcon;
						Assert.assertTrue(driver.findElement(By.xpath(InstagramIcon)).isEnabled());		
						// Verifying footer LinkedIn social site links are showing
					  	error=PinterestIcon;
						Assert.assertTrue(driver.findElement(By.xpath(PinterestIcon)).isEnabled());
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
				
				String ChatIconXpath = PropReader.getProp("ChatIconXpath");
				String Chat_text_Title = PropReader.getProp("Chat_text_Title");
				String Chat_close = PropReader.getProp("Chat_close");

				//navHomepage();
				
				//Verify live chat icon display
				error=ChatIconXpath;
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ChatIconXpath)));
				Assert.assertTrue(driver.findElement(By.xpath(ChatIconXpath)).isDisplayed());
				//Navigate to open live chat icon
				 driver.findElement(By.xpath(ChatIconXpath)).click();
				
				//Verify chat text title "Questions? Chat with us!" when open the chat box
				 driver.switchTo().frame("webWidget");		
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
		
		//@Test(priority =18, description ="Homepage>>Test Case No. 18>>Verify Image Slider and Carousal Dots displayed on Homepage")
		public void banner() throws InterruptedException
		{
			String error = null;
			test=extent.createTest("Verify Banner and Carousal Dots displayed on Homepage");
			WebDriverWait wait=new WebDriverWait(driver, 60);
			try
			{				
				String ImageSliderXpath = PropReader.getProp("ImageSliderXpath");
				String BannerCarXpath = PropReader.getProp("BannerCarXpath");

				//navHomepage();
				
				//Verify image slider is present on the homescreen
				error="Image Slider";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ImageSliderXpath)));
				Assert.assertTrue(driver.findElement(By.xpath(ImageSliderXpath)).isDisplayed());
				
				error="Banner Carousal";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BannerCarXpath)));
				Assert.assertTrue(driver.findElement(By.xpath(BannerCarXpath)).isDisplayed());
				
			}
			catch (AssertionError e) { 
				test.log(Status.FAIL, MarkupHelper.createLabel(error+" is not displayed", ExtentColor.RED));
			}
		}
	}

