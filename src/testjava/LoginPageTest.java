package testjava;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import mainjava.DashBoardPage;
import mainjava.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test(priority = 0)
	public void verifyUrlOfLoginPage() {
		// LoginPage loginP=new LoginPage(driver);

		loginP.pageUrl("https://opensource-demo.orangehrmlive.com/");

		Reporter.log(loginP.pageUrl("https://opensource-demo.orangehrmlive.com/"), true); // url current
	}

	@Test(priority = 1)
	public void verifyTitleOfLoginPage() {
		loginP.pageTitle("OrangeHRM");
		Reporter.log(loginP.pageTitle("OrangeHRM"), true); // OrangeHRM
	}

	@Test(priority = 2)
	public void verifyLoginPageWithCorrectCredentials() {
		loginP.loginMethod("Admin", "admin123");
		
	//	DashBoardPage dashBoardP =new DashBoardPage(driver);
		boolean verifyLoginSuccesfull=dashBoardP.titleOfDashBoard();
		Assert.assertEquals(verifyLoginSuccesfull, true);
		// dashBoardP.logoutMethod();
	}

	
	
}
