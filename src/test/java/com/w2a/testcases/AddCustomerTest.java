package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtils;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass = TestUtils.class, dataProvider = "getData" )
	public void addCustomerTest(String firstName, String lastName, String postCode, String alertText, String runmode)
			throws InterruptedException {
		if(runmode.equalsIgnoreCase("N"))
		{
			throw new SkipException("Skipped");
		}
		
		click("addCustBtn");
		text("firstname", firstName);
		text("lastname", lastName);
		text("postcode", postCode);
		click("addbtn");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		Assert.assertTrue(alert.getText().contains(alertText));
		// Thread.sleep(2000);
		alert.accept();
		// Thread.sleep(2000);

		// Assert.fail();

	}

}
