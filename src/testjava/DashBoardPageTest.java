package testjava;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBoardPageTest extends BaseTest{

	@Test(priority=5)
	public void verifyLogOutOption() {
		//loginP.loginMethod("Admin","admin123");
		dashBoardP.logOutProcess();
		
		boolean btnsisplayed=loginP.verifyBtnLoginIsDisplayed();
		AssertJUnit.assertEquals(btnsisplayed, true);
		
	}
	
	@Test(priority=4)
	public void verifyBellIConIsDisplayed() {
		loginP.loginMethod("Admin","admin123");
		boolean result=dashBoardP.bellIConDisplayed();
		System.out.println(result);
		
	}
}

