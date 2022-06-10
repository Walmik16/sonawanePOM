package testjava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseClass;
import mainjava.DashBoardPage;
import mainjava.LoginPage;

public class BaseTest extends BaseClass {

	
	@BeforeClass
	public void WebBrowserLaunching() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOpt=new ChromeOptions();
		chromeOpt.addArguments("--start-maximized");
		chromeOpt.addArguments("--incognito");
	//	chromeOpt.addArguments("--headless");      //browser will not launch but run it like 
		chromeOpt.addArguments("--disable-extensions");  //
		chromeOpt.addArguments("--disable-popup-blocking");  //
		driver=new ChromeDriver(chromeOpt);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.manage().window().maximize();

	}
	
	@BeforeMethod                   //@BeforeClass bhi likh sakte hai but not beforeTest-1.03video
	public void allPageObjects() { //@BeforeMethod har meth ke execution pahle obj crete hoga us meth ke liye
//		loginPage LoginP=new LoginPage(driver);
//		DashBoardPage dashBoardP=new DashBoardPage(driver);
		
		loginP=new LoginPage(driver);
		dashBoardP=new DashBoardPage(driver);
	}

	
	@AfterClass
	public void tearDownBrowser() {
		driver.quit();
	}

	
}
