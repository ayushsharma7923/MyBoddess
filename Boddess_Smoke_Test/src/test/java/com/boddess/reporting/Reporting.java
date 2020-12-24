package com.boddess.reporting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.boddess.utilities.Setup;


public class Reporting extends Setup {
	
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static File rootFolder = new File(System.getProperty("user.dir"));
	
	
	@BeforeSuite
	public void report() throws IOException
	{
		
		  htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"./test-output/Boddess_Test_Report.html"); 
		  extent = new ExtentReports(); 
		  extent.attachReporter(htmlreporter);
		  extent.setSystemInfo("Application", reader("application"));
		  extent.setSystemInfo("Environment", reader("environment"));
		  extent.setSystemInfo("QA", reader("qa")); extent.setSystemInfo("Browser", reader("browser"));
		  htmlreporter.config().setDocumentTitle("Smoke Test Report");
		  htmlreporter.config().setReportName("Smoke Test");
		  htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		  htmlreporter.config().setTheme(Theme.DARK);
		 
		Start();
		
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getDescription(), ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getDescription(), ExtentColor.GREEN));
		}
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getDescription(), ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
				
	}
	
	
	@AfterSuite
	public void endReport()
	{
		extent.flush();
		Stop();
	}
	
	public String reader(String in) throws IOException
	{
	Properties obj = new Properties();
	FileInputStream objFile;
	objFile = new FileInputStream(System.getProperty("user.dir")+"./solveda.configuration.properties");
	obj.load(objFile);
	String out = obj.getProperty(in);
	return out;
	}
	
}
