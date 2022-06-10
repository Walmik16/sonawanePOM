package mainjava;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testjava.BaseTest;

public class DashBoardPage extends BaseTest {

	//fist step find all the  locator which is required for testing this DashBoardPage 
	
	//All locators
		@FindBy(xpath="//h1[text()='Dashboard']")
		WebElement titleOfDashboardEle;
		
		@FindBy(id="welcome")
		WebElement welComeDropDown;
		
		@FindBy(xpath="//a[text()='Logout']")
		WebElement logoutOption;
		
		@FindBy(xpath="//*[@data-icon='bell']")
		WebElement iconBell;
		
		//initialization 
		public DashBoardPage(WebDriver driver) {   //by constructor
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		//steps or method related to current page
		
		public boolean titleOfDashBoard() {
			String titleDash=titleOfDashboardEle.getText();
			if(titleDash.equals("Dashboard"))
				return true;
			else
				return false;
		}
		
		public boolean bellIConDisplayed() {
			boolean status = iconBell.isDisplayed();
			return status;
		}
		
		public void logOutProcess() {
			welComeDropDown.click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(logoutOption));
			logoutOption.click();
					
		}
}
