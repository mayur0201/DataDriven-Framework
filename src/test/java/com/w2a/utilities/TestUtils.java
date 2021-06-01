package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtils extends TestBase {

	public static String screenshotpath;
	public static String screenshotname;

	public static void captureScreenShot() throws IOException {

		Date d = new Date();
		File srfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		screenshotname = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(srfile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotname));

	}
	
	@DataProvider(name = "getData")
	public Object[][] getData(Method m) throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx";
		String sheetName=m.getName();
        System.out.println("OpenAccountTest");
		int rowcount = XlUtils.getRowCount(path, sheetName);
		int colcount = XlUtils.getCellCount(path, sheetName, 1);

		Object data[][] = new Object[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {

				data[i - 1][j] = XlUtils.getCellData(path, sheetName, i, j);
			}

		}
		return (data);
	}
	
	

}
