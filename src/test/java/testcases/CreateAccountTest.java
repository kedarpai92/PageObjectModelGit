package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Page;
import pages.ZohoAppPage;
import pages.crm.accountspage.AccountsPage;
import pages.crm.accountspage.AddAccounts;
import utilities.Utilities;

public class CreateAccountTest {
	
	@Test(dataProviderClass= Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) {
		
		ZohoAppPage zp= new ZohoAppPage();
		zp.goToCRM();
		AccountsPage acp= Page.menu.goToAccounts();
		AddAccounts aac= acp.goToCreateAccountsPage();
		aac.createAccounts(data.get("accountname"));
		
		Assert.fail("CreateAccountTest forcefully failed");
		
		
	}

}
