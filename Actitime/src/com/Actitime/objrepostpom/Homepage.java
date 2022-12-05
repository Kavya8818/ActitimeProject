package com.Actitime.objrepostpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	@FindBy(xpath="//a[.=Logout ']")
	private WebElement lgoutlnk;
	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasklnk;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}

	public WebElement getLgoutlnk() {
		return lgoutlnk;
	}

	public WebElement getTasklnk() {
		return tasklnk;
	}
	
	public void Tasklnk() {
		tasklnk.click();
	}
	
	public void logout() {
		lgoutlnk.click();
	}
}
