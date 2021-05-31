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
import com.w2a.utilities.XlUtils;


public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText)
			throws InterruptedException {
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn_CSS"))).click();

		driver.findElement(By.cssSelector(OR.getProperty("firstname_CSS"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastname_XPATH"))).sendKeys(lastName);
		// Thread.sleep(2000);
		driver.findElement(By.cssSelector(OR.getProperty("postcode_CSS"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn_CSS"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		Assert.assertTrue(alert.getText().contains(alertText));
		// Thread.sleep(2000);
		alert.accept();
		// Thread.sleep(2000);

	}

	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx";

		System.out.println("AddCustomerTest");
		int rowcount = XlUtils.getRowCount(path, "AddCustomerTest");
		int colcount = XlUtils.getCellCount(path, "AddCustomerTest", 1);

		Object data[][] = new Object[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {

				data[i - 1][j] = XlUtils.getCellData(path, "AddCustomerTest", i, j);
			}

		}
		return (data);
	}

}
