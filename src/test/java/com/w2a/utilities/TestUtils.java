package com.w2a.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.base.TestBase;

public class TestUtils extends TestBase {

	public static void captureScreenShot() throws IOException {

		File srfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srfile, new File(System.getProperty("user.dir") + "\\target\\error.jpj"));

	}
}
