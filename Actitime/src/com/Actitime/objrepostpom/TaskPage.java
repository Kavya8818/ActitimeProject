package com.Actitime.objrepostpom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Actitime.GenericLibrary.ReadDataFromExcel;

public class TaskPage {
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnew;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcustomer;
	
	@FindBy(xpath ="(//input[@placeholder='Enter Customer Name'])[2]" )
	private WebElement custname;
	
	@FindBy(xpath ="(//div[@class='dropdownbutton'])[15]")
	private WebElement dropdown;
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	public WebElement getCustname() {
		return custname;
	}

	public WebElement getNewcustomer() {
		return newcustomer;
	}
	
	public WebElement getAddnew() {
		return addnew;
		
	}
	
	public void clickOnAdd() throws EncryptedDocumentException, IOException {
		ReadDataFromExcel r=new ReadDataFromExcel();
		String custname1 = r.readDataFromExcelFile("Sheet1", 1, 1);
		addnew.click();
		newcustomer.click();
		custname.sendKeys(custname1);
	}
}
