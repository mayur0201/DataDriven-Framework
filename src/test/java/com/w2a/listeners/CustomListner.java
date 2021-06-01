package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtils;

public class CustomListner extends TestBase implements ITestListener {

	public void onTestSuccess(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtils.captureScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // Codes
		}

		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + "PASS");
		test.log(LogStatus.PASS, test.addScreenCapture(TestUtils.screenshotname));

		report.endTest(test);
		report.flush();

	}

	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtils.captureScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // Codes
		}

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtils.screenshotname + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtils.screenshotname + "><img src=" + TestUtils.screenshotname
				+ " height=200 width=200></img></a>");

		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + "Failed with exception" + arg0.getThrowable());
		report.endTest(test);
		report.flush();

	}

	public void onTestStart(ITestResult arg0) {
		test = report.startTest(arg0.getName().toUpperCase());

	}
}
