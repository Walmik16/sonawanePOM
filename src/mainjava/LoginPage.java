package mainjava;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



import testjava.BaseTest;

public class LoginPage extends BaseTest{

	//fist step find all the  locator which is required for testing this login page 
	
	@FindBy(id ="txtUsername")   //@findBy used for
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	@FindBy(id="spanMessage")
	WebElement invalidMsg;
	
	//initialization of variables of page (locators)    //by using constructor
		public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);          //@beforemethod we write  all object in that meth 
		}   //so before our meth run our obj get create for that meth so inthis class then constructor get call (bz after obj creation constructor get calleed)
	 //so in thas obj we mention driver in arg so this driver comes here 
		//
		
		//steps or method related to current page
public void loginMethod(String userNameTestData, String passwordTestData) {
			
			username.sendKeys(userNameTestData);
			password.sendKeys(passwordTestData);
			btnLogin.click();
		}
		
		public String pageTitle(String expectedTitle) {
			String title=driver.getTitle();
			Assert.assertEquals(title, expectedTitle);
			return title;
		}
		
		public String pageUrl (String expectedUrl) {
			String Url=driver.getCurrentUrl();
			Assert.assertEquals(Url,expectedUrl);
			return Url;
		}
		
		public void InvalidMsgAfterIncorrectCredLogin(String expectedInvmsg) {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String invmsg=invalidMsg.getText();
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(invmsg, expectedInvmsg);
			soft.assertAll();	
		}
		

		public boolean verifyBtnLoginIsDisplayed() {
			return btnLogin.isDisplayed();
//			boolean result=btnLogin.isDisplayed();
//			return result;
		}
		
		
}
