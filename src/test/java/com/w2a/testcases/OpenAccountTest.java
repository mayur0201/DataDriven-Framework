package com.w2a.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtils;
import com.w2a.utilities.XlUtils;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass = TestUtils.class, dataProvider = "getData")
	public void openAccountTest(String customer, String currency) throws InterruptedException {

		click("openAccBtn");
		selectValue("customerId", customer);
		selectValue("currencyId", currency);
		click("process");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		// Thread.sleep(2000);
		alert.accept();

	}

}
