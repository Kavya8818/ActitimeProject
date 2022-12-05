package com.Actitime.GenericLibrary;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Actitime.objrepostpom.Homepage;
import com.Actitime.objrepostpom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected",true);
	}
	
	@BeforeTest
	public void launchbrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@AfterTest
	public void closebrowser() {
		driver.close();
	}
	
	@BeforeMethod
	public void login() throws IOException {
		readDataFromPropertyFile data=new readDataFromPropertyFile();
		String Url = data.readDataFromProperty("url");
		String un = data.readDataFromProperty("username");
		String pw = data.readDataFromProperty("password");

		driver.get(Url);
		LoginPage lp=new LoginPage(driver);
		lp.loginToActitime(un, pw);
		Reporter.log("Login to application",true);
		/*loginTo Actitime method get data from login page
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.xpath("//div[.='Login ']")).click();*/  
	}	
	@AfterMethod
	public void logout() {
		/*driver.findElement(By.id("logoutLink")).click();*/
		Homepage hp=new Homepage(driver);
		hp.logout();
				
	}
	
}
