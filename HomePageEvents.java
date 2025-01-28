package pageEvents;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseTest.BaseTest;
import pageObjects.HomePageElements;
import utils.CommonFunctions;

public class HomePageEvents  {
	
	 CommonFunctions cfobj = new  CommonFunctions();

	 public void acceptAgreement() {
		 
		cfobj.getWebElement("ID", HomePageElements.acceptAgreement).click();

		}
	 
	
	 
	 public void clickOpinionSection() {
		 
		 ((CommonFunctions) cfobj).getWebElement("XPATH", HomePageElements.opinionSection).click();

		}
	 
	 
}
