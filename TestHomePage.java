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

//	static WebDriver driver;
//	static String url = "https://elpais.com/";
	
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
	         
	        
       //	Ensure that the website's text is displayed in Spanish.
	        Thread.sleep(2000);
	        
	 		//Navigate to the Opinion section of the website.
	        hpobj.clickOpinionSection();
	        //Scroll down to the article section 
	  	    cfobj.scrolldown();
			 
	    	//	Fetch the first five articles in this section  and print the title and content 
	  	  actualHeadings = opobj.getArticleHeadingsANDContent();
			
	      //  List<WebElement> articleHeadings =  driver.findElements(By.xpath("//h2[contains(@class,'c_t c_t-i')]"));
	       // List<WebElement> articleContent = driver.findElements(By.xpath("//article//p[contains(@class,'c_d')]"));
	      //  WebElement articleContent =  driver.findElement(By.xpath("(//article//p[contains(@class,'c_d')])[@ROW]"));
	    //  int i = 0;
	     //   for(WebElement heading:articleHeadings) {	
	      //  	i = i+1;
	      //      actualHeading = heading.getText();
	     //       System.out.println("Actual Heading  is: "+actualHeading);
	           
	          //  Translate Article Headers:Translate the title of each article to English. 
					//Translation translation = translate.translate(actualHeading, TranslateOption.sourceLanguage("es"), TranslateOption.targetLanguage("en"));
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
					
					
					//
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
				
				  //  translatedHeadings.add(translatedHeading);

	
	        
	       
					}
	        
	       
	     
   //	 System.out.println("Translated Headings are " + translatedHeadings );
         System.out.println("All word in  Headings are " + allHeadingWordsMap );
   	 
   	
	        
	        //  Analyze Translated Headers:
	       //From the translated headers, identify any words that are repeated more than twice across all headers combined.
		   //Print each repeated word along with the count of its occurrences.  
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
        
		
			//	If available, download and save the cover image of each article to your local machine.

		
	//	Cross-Browser Testing:
	//	Once validated, execute the solution on BrowserStack across 5 parallel threads, testing across a combination of desktop and mobile browsers.*/
		
	   }

	

}
