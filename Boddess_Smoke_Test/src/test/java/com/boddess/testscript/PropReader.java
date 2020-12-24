package com.boddess.testscript;
import java.io.*;
import java.util.*;

public class PropReader {
	static Properties prop=null;
	  public static String getProp(String args)  
	  {
	      if(prop==null)
	      {
	    	 prop = readPropertiesFile(System.getProperty(args));
	      }
	      return prop.getProperty(args);
	   }
	  
	   public static Properties readPropertiesFile(String fileName) 
	   {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream("solveda.boddess.properties");
	         prop = new Properties();
	         prop.load(fis);
	      }
	      catch(FileNotFoundException fnfe) 
	      {
	         fnfe.printStackTrace();
	      }
	      catch(IOException ioe) 
	      {
	         ioe.printStackTrace();
	      }
	      finally {
	    	  try {
	         fis.close();
	    	  }
	    	  catch(IOException e)
	    	  {}  
	      }
	      return prop;
	   }
	}
