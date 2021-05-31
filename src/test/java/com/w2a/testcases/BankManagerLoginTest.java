package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	@Test
	public void loginBankManager() throws InterruptedException
	{
		log.info("Inside login test");
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		
		log.debug("Login Successfully Executed");
	}
	

}
