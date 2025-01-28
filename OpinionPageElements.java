package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface OpinionPageElements {
	
	String articleHeadings = 	"//h2[contains(@class,'c_t c_t-i')]";
    String articleContent  = "(//article//p[contains(@class,'c_d')])[@ROW]";
	
   
	

}
