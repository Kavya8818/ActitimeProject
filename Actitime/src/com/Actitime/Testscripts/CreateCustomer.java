package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.objrepostpom.Homepage;
import com.Actitime.objrepostpom.TaskPage;
@Listeners(com.Actitime.GenericLibrary.ListenerImplementation.class)
public class CreateCustomer extends BaseClass{
	
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.Tasklnk();
		
		TaskPage tp=new TaskPage(driver);
		tp.clickOnAdd();
		
				
		
	}
}


	
	

