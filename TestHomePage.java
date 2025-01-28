package com.elpais.testfunctionality;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;

//import com.google.api.*;
//import com.google.api.translate.Language;
//import com.google.api.translate.Translate;

public class TestHomePage {
	
	static WebDriver driver;
	 
	public TestHomePage(WebDriver driver){
	this.driver=driver;
	}
    static String url = "https://elpais.com/";

	public static void main(String[] args) throws InterruptedException 
		 {	 
		
		GoogleAPI.setHttpReferrer(url);
		String key="AIzaSyDkxFruPC58b0S9D07bB9Y3FJ2quEFLEAI";
     //   GoogleAPI.validateReferrer();
	    
		
		// See: http://code.google.com/apis/language/translate/v2/getting_started.html

		   
           System.setProperty("webdriver.chrome.driver","C:\\Users\\Dhanya\\eclipse-workspace\\testelpaisfunctionality\\chromedriver.exe");
		 
		   ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-cache");
		//	options.addArguments("--lang=es");
			  WebDriver  driver  =  new ChromeDriver(options) ;
		    driver.manage().window().maximize();
		    driver.get(url);
             //Accept the agreement 
		      WebElement accept = driver.findElement(By.id("didomi-notice-agree-button")) ;
			    accept.click();
			    
			 
			//	Ensure that the website's text is displayed in Spanish.
	        WebElement title = driver.findElement(By.xpath("//*//a[@class='ep_e _db']")) ;
	        try {
		    title.click();
	        String actualTitleText = title.getText();
	        System.out.print("Actual Text : " + actualTitleText);
	        String expectedTitleText = "EL PAÍS";
	        assertTrue(actualTitleText.contains(expectedTitleText));
	        }
	        catch(StaleElementReferenceException s) {
	        	System.out.print("Exception caught");
	        }
	        
	        
	        Thread.sleep(2000);
	 		//Navigate to the Opinion section of the website.
	         WebElement opinionSection = driver.findElement(By.xpath("//a[contains(@href,'opinion')]"));
	         opinionSection.click();
	      
	    	//	Fetch the first five articles in this section  	
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,500)"); 
	        List<WebElement> articleHeadings =  driver.findElements(By.xpath("//h2[contains(@class,'c_t c_t-i')]"));
	        int i = 0;
	        for(WebElement heading:articleHeadings) {
	        	
	        	i = i+1;
	        	String actualHeading = heading.getText();
	        	System.out.println("Actual Heading  is: "+actualHeading);
	        	try {
					String translatedHeading = Translate.translate(actualHeading,Language.SPANISH,Language.ENGLISH);
				    System.out.println("Translated Heading is " + translatedHeading);
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	if(i>5)
	        	{
	        		break;
	        	}
	        }
	        
	
	   
	    	//	If available, download and save the cover image of each article to your local machine.
	        
	     //  Translate Article Headers:Translate the title of each article to English.
	    	
	    		
	    
	        driver.quit();
		/*
          
		
		
		Print the translated headers.
		Analyze Translated Headers:
		From the translated headers, identify any words that are repeated more than twice across all headers combined.
		Print each repeated word along with the count of its occurrences.
		Cross-Browser Testing:
		Run the solution locally to verify functionality.
		Once validated, execute the solution on BrowserStack across 5 parallel threads, testing across a combination of desktop and mobile browsers.*/
		
	   }

	

}
