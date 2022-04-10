package pages.crm.accountspage;

import org.openqa.selenium.By;

import base.Page;

public class AddAccounts extends Page {
	
	public void createAccounts(String userName) {
		
		//driver.findElement(By.cssSelector("#Crm_Accounts_ACCOUNTNAME_LInput")).sendKeys(userName);
		type("addaccountnamefield_CSS", userName);
		
	}

}
