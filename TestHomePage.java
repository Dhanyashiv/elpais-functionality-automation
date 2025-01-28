package com.elpais.testfunctionality;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.google.cloud.translate.*;
import com.google.cloud.translate.Translate.TranslateOption;

import baseTest.*;
import pageEvents.HomePageEvents;
import pageEvents.OpinionPageEvents;
import utils.*;

public class TestHomePage extends BaseTest  {


    static BaseTest btobj = new BaseTest();
    static CommonFunctions cfobj = new CommonFunctions();
    static HomePageEvents hpobj = new HomePageEvents();
    static OpinionPageEvents opobj = new OpinionPageEvents();
	
	public TestHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void main(String[] args) throws InterruptedException
     {
		String  translatedHeading = null;
		String[] headingWords ;
		int countOfWords = 0; 
		LinkedList<String> actualHeadings = new LinkedList<String>();
		LinkedList<String> translatedHeadings = new LinkedList<String>();
		LinkedList<String> allHeadingWordsList = new LinkedList<String>();
		HashMap<String , Integer> allHeadingWordsMap = new LinkedHashMap<String,Integer>();
        
		//Opening browser and accessing the url 
		btobj.beforeTest("chrome");
		
		//Accept the agreement 
		 try {
                 hpobj.acceptAgreement();
		      }   
		 catch(Exception e){
			     System.out.print("Exception caught");
			  }
		
		 Thread.sleep(2000);
	
	     //	Verify that url home page is loaded 
	       String actualTitle = driver.getTitle();
	       System.out.print("Actual Title : " + actualTitle);
	       String expectedTitle = "EL PAÍS: el periódico global";
           assertTrue("Title is same as expected",actualTitle.contains(expectedTitle));
	       
	 		//Navigate to the Opinion section of the website.
	        hpobj.clickOpinionSection();
	        //Scroll down to the article section 
	  	    cfobj.scrolldown();
			 
	    //	Fetch the first five articles in this section  and print the title and content of each article
	  	  actualHeadings = opobj.getArticleHeadingsANDContent();
	  	 
	  //  Translate Article Headers:Translate the title of each article to English and print the translated Headers 
		  try {
			      for(String actualHeading :actualHeadings ) {	
				   translatedHeading = cfobj.translate(actualHeading);
                   System.out.println("Translated Heading is " + translatedHeading );
                   translatedHeadings.add(translatedHeading);
                 }
			    }
					 catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		  //  Analyze Translated Headers:
	      //From the translated headers, identify any words that are repeated more than twice across all headers combined.
		   //Print each repeated word along with the count of its occurrences.  
			for(String translatedHeading1 :translatedHeadings ) {	
				    headingWords = translatedHeading1.split("\\W");
				        for(String headingWord: headingWords){
				        	if(allHeadingWordsMap.containsKey(headingWord)) {
				        		allHeadingWordsMap.put(headingWord, allHeadingWordsMap.get(headingWord)+1);
				        	}
				        else
				        	{
				        		allHeadingWordsMap.put(headingWord, 1);
				        	}
				        	allHeadingWordsList.add(headingWord);
				        }
				
				}
	    
         System.out.println("All word in  Headings are " + allHeadingWordsMap );
         for(Map.Entry<String,Integer> entry :allHeadingWordsMap.entrySet() ) {
	     if(entry.getValue()>2) {
	    		System.out.println("Words that are repeated more than twice are:" + entry.getKey());
	    		countOfWords = countOfWords+1;
	    	}
	     }
	     if(countOfWords==0) {
	    	 System.out.println("No words  are repeated more than twice" );
	     }
	        btobj.afterTest();
       }

	

}
