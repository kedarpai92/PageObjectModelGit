package pages;

import org.openqa.selenium.By;

import base.Page;

public class HomePage extends Page{
	//Page Object Model Design: In Page Object Model all the elements of a page are defined in a single class and each element is defined in a method inside the class. 
	//For a new Page, create a new class.
	//

	public void goToSupport() {
		//Temporary definition. Hardcoding will be removed later.. 
		//OR properties file will be used for xpath and css. findelement and click etc
		
		driver.findElement(By.cssSelector(".zh-support")).click();

	}

	public void goToCustomers() {
		
		driver.findElement(By.cssSelector(".zh-customers")).click();
		

	}
	public void goToSignUP() {
		
		driver.findElement(By.cssSelector(".zh-signup")).click();

	}
	//renamed the return type from void to the next object Class
	public LoginPage goToLogin() {
		
		click("goToLogin_CSS");	
		return new LoginPage();
	}
	
	public void validateFooterLinks() {
		
		
	}
}
