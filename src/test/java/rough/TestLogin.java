package rough;

import base.Page;
import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;
import pages.crm.accountspage.AccountsPage;
import pages.crm.accountspage.AddAccounts;

public class TestLogin {

	public static void main(String[] args) {
		
// Code block moved to Page class.. Page Constructor.. Inheritance used for all the pages from Page class		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.zoho.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
// 	OLD Structure before the Page Object Model implementation. Now, Every method returns the object of the page it is navigating to
//	Similarly the object creation is also chained together
//
//		HomePage home=new HomePage();
//		home.goToLogin();
//		
//		LoginPage login = new LoginPage();
//		login.doLogin("kedarpai92@yahoo.co.in","Selenium@123");
//		
//		//Password : Selenium@123
//		
//		ZohoAppPage zp= new ZohoAppPage();
//		zp.goToCRM();
//		Page.menu.goToAccounts();
//		AccountsPage acp=new AccountsPage();
//		acp.goToCreateAccountsPage();
//		AddAccounts aac= new AddAccounts();
//		aac.createAccounts("Kedar");
		
// 	New type >> After implementing the Page Object Model..Chaining of objects created and the methods return the class(PAGE) it is navigating to
// Avoid returning straight forwward objects and implement PageObjects
		
		HomePage home=new HomePage();
		LoginPage login = home.goToLogin();
			 
		ZohoAppPage zp= login.doLogin("kedarpai92@yahoo.co.in","Selenium@123");
		//Password : Selenium@123
		zp.goToCRM();
		AccountsPage acp= Page.menu.goToAccounts();
		AddAccounts aac= acp.goToCreateAccountsPage();
		aac.createAccounts("Kedar");

	}

}
