package pageEvents;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.HomePageElements;
import pageObjects.OpinionPageElements;
import utils.CommonFunctions;

public class OpinionPageEvents {
	
	 CommonFunctions cfobj = new  CommonFunctions();
	 LinkedList<String> actualHeadings = new LinkedList<String>();

	 public  LinkedList<String> getArticleHeadingsANDContent() {
		 
		 List<WebElement> articleHeadings = ((CommonFunctions) cfobj).getWebElements("XPATH", OpinionPageElements.articleHeadings);
		 int i = 0;
		
	     for(WebElement heading:articleHeadings) {	
	    	
	    	 i = i+1;
	         String articleContent = OpinionPageElements.articleContent.replaceFirst("@ROW", Integer.toString(i));
	         WebElement Content = ((CommonFunctions) cfobj).getWebElement("XPATH",articleContent);
	         String  articleHeading = heading.getText();
	         String  contentOfThisArticle = Content.getText();
	         actualHeadings.add(articleHeading);
	         System.out.println(i+": Heading  is: "+articleHeading);
	         System.out.println(i+": Content is: "+contentOfThisArticle);
	         if(i>4)
	        	{
	        		break;
	        	}
	        }
	        
	     return actualHeadings ;
	        

		}
	 
	 

}
