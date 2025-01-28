package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.Translate.TranslateOption;

import baseTest.BaseTest;

public class CommonFunctions extends BaseTest implements CommonFunc {
	
	
	//scroll down window screen
	
     public void scrolldown() {
    JavascriptExecutor jse = (JavascriptExecutor)driver;
	 jse.executeScript("window.scrollBy(0,250)"); 
	
     }
	//Google translator function 
     public String translate(String text) {
      String key = "not using the key here ";
 	//Initialize translation service
     @SuppressWarnings("deprecation")
	Translate translate = TranslateOptions.newBuilder().setApiKey(key).build().getService();
     Translation translation = translate.translate(text, TranslateOption.sourceLanguage("es"), TranslateOption.targetLanguage("en"));
     String translatedText = translation.getTranslatedText();
     return translatedText ;
     }
     
     public WebElement getWebElement(String identifierType , String identifiervalue)
     {
       switch(identifierType) {
       
       case "XPATH":
    	   return driver.findElement(By.xpath(identifiervalue));
       case "ID":
             return driver.findElement(By.id(identifiervalue));
       default:
    	     return null ;
    
          }
     
     }
     
     public List<WebElement> getWebElements(String identifierType , String identifiervalue)
     {
       switch(identifierType) {
       
       case "XPATH":
    	   return driver.findElements(By.xpath(identifiervalue));
       case "ID":
             return driver.findElements(By.id(identifiervalue));
       default:
    	     return null ;
    
          }
     
     }

}
