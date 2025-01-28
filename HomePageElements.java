package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface HomePageElements {
	

    //Accept agreement
	String acceptAgreement = "didomi-notice-agree-button";
	
	//Home Page Main heading text
	String mainHeading = "//*//a[@class='ep_e _db']";
   
	//Opinion Button 
	String opinionSection = "//a[contains(@href,'opinion')]";
   
}
