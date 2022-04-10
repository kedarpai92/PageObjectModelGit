package pages;

import org.openqa.selenium.By;

import base.Page;
import pages.crm.CRMHomePage;

public class ZohoAppPage extends Page{

	public CRMHomePage goToCRM() {

		click("goToCRMPage_CSS");
		return new CRMHomePage();
		
	}
	public void goToSalesIQ() {

		driver.findElement(By.cssSelector("#zl-category-3 > div > ul > li:nth-child(6) > div > a > p")).click();
	}
	
	public void goToSocial() {

		driver.findElement(By.cssSelector("#zl-category-3 > div > ul > li:nth-child(7) > div > a > p")).click();
	}

}
