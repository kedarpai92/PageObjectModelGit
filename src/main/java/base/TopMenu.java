package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.crm.accountspage.AccountsPage;

/*
 * TopMenu ISA Page>> No.. Top Menu is inside all pages. Independently not a page.. 
 * So TopMenu extends Page is wrong!!
 * 
 * Two Ways to use TopMenu class
 * 1. Page.menu.method()
 * 2. Create Constructor for TopMenu and initialise the globaldriver reference to the local one.
 * 
 * HomePage HASA TopMenu
 * CRMHomePage HASA TopMenu
 * 
 * HASA relationship >> Encapsulation
 * 
 * TopMenu will be encapsulated inside all the 1.Pages that have TopMenu OR 2.Inside the base class Page.
 * 
 * ISA relationship>> Inheritance
 * 
 */

public class TopMenu {
	
//	WebDriver driver;
//	public TopMenu(WebDriver driver) {
//		
//		this.driver = driver;
//	}
//

	public void goToHome() {

	}

	public void goToFeeds() {

	}

	public void goToLeads() {

	}

	public AccountsPage goToAccounts() {
		Page.click("accounttabbtn_CSS");
		return new AccountsPage();
	}

	public void goToContacts() {

	}

	public void goToDeals() {

	}

	public void goToSignOut() {

	}

}
