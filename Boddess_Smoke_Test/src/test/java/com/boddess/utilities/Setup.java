package com.boddess.utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.boddess.testscript.PropReader;

public class Setup {

	public static WebDriver driver;

	public void Start() {

		
		 /* System.setProperty("webdriver.chrome.driver", "Inputs/chromedriver.exe");
		  driver = new ChromeDriver(); */
		 

		System.setProperty("webdriver.gecko.driver", "Inputs/geckodriver.exe");
		driver = new FirefoxDriver(); 

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(PropReader.getProp("url"));

	}

	public void Mouseover(By by) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(by)).perform();

	}

	public void Stop() {
		driver.close();
	}

	public void wait(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void clickablewait(By by) {
		WebDriverWait clickablewait = new WebDriverWait(driver, 240);
		clickablewait.until(ExpectedConditions.elementToBeClickable(by));
	}

}
