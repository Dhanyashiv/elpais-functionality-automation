package baseTest;
import  utils.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;

import utils.Constants;

public class BaseTest extends BrowserFactory {
	
	BrowserFactory bfobj = new BrowserFactory();
	
	@Before
	
	public static void beforeTest(String browser)
	{
		
		BrowserFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		
	}
	
	@After
	public static void afterTest()
	{
		driver.quit();
	}




	
	
}
