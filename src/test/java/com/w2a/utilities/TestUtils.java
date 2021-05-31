package com.w2a.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.base.TestBase;

public class TestUtils extends TestBase {

	public static String screenshotpath;
	public static String screenshotname;

	public static void captureScreenShot() throws IOException {

		File srfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		screenshotname = "error.jpg";

		FileUtils.copyFile(srfile, new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\"+screenshotname));

	}
}
