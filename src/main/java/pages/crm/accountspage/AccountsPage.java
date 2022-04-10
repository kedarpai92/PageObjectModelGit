package pages.crm.accountspage;

import org.openqa.selenium.By;

import base.Page;

public class AccountsPage extends Page{
	
	public AddAccounts goToCreateAccountsPage(){
		
		click("createaccountbtn_CSS");
	
		return new AddAccounts();
	}


	public void goToImportAccountsPage(){
		
		
	}

}
