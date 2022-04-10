package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;

public class LoginPage extends Page{
	
	////renamed the return type from void to the next object Class
	public ZohoAppPage doLogin(String email, String password) {
		
		type("loginID_CSS", email);
		click("loginBtnForID_CSS");
		type("password_CSS", password);
		click("loginBtnForPass_CSS");
		
		return new ZohoAppPage();
		
		
	}

}
