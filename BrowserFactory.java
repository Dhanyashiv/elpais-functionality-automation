package baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	 
	public BrowserFactory(){
	 
	}
	 
	public static WebDriver getDriver(){
	if(driver==null){
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
//	options.addArguments("--lang=es");
	options.setPageLoadStrategy(PageLoadStrategy.NONE);
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhanya\\eclipse-workspace\\testelpaisfunctionality\\chromedriver.exe");
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//	driver.manage().timeouts().wait(10);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	return driver;
	}
	 
	public static WebDriver getDriver(String browserName){
	if(driver==null){
	if(browserName.equalsIgnoreCase("firefox")){
	//System.setProperty("webdriver.gecko.driver", ""D:Softwaresjarsgeckodriver-v0.23.0-win64geckodriver.exe"");
	//driver=new FirefoxDriver();
	//driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	//driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	//driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}else if(browserName.equalsIgnoreCase("chrome")){
	System.out.println("in chrome");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	//options.addArguments("--lang=es");
	options.setPageLoadStrategy(PageLoadStrategy.NONE);
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhanya\\eclipse-workspace\\testelpaisfunctionality\\chromedriver.exe");
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}else if(browserName.equalsIgnoreCase("IE")){
     System.out.println("in chrome");
	 System.setProperty("webdriver.ie.driver", "D:SoftwaresjarsIEDriverServer_Win32_3.14.0IEDriverServer.exe");
	 driver=new InternetExplorerDriver();
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	
	}
	}
	return driver;
	}
	}


