package testcases;

import java.util.Hashtable;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.Utilities;

public class LoginTest extends BaseTest {
	@Test(dataProviderClass= Utilities.class, dataProvider = "dp")
	public void LoginTest(Hashtable<String, String> data) {

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();
		
		//No need of ZohoAppPage zp object as its not used here... keeping it creates no harm.. Kept it as it is for now
		login.doLogin(data.get("username"), data.get("password"));
		// Password : Selenium@123
		
		//Assert.fail("LoginTest Forcefully failed");

	}
}
