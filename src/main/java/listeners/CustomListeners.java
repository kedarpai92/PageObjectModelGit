package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.IReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Page;
import utilities.Utilities;

import org.testng.Assert;
import org.testng.Reporter;



import com.relevantcodes.extentreports.LogStatus;




public class CustomListeners extends Page implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		//The test has to be started first. Extent has to know which tests to start first
		test=rep.startTest(result.getName().toUpperCase());
		
		//Setup run modes
//		if (!Utilities.isTestRunnable(result.getName())) {
//			throw new SkipException("Test "+ result.getName() +" as the runMode is N");
//		}
	}

	public void onTestSuccess(ITestResult result) {

		test.log(LogStatus.PASS, result.getName().toUpperCase() + "Passed");

		// Once the tests are completed the test has to be ended in extent
		// Also flush the report

		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "\nFailed with Exception " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
		
		
		Reporter.log("Click to see screenshot>>");
		Reporter.log("<a target=\"_blank\"href=" + Utilities.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName + " height=300 width=200</img></a>");

		// Once the tests are completed the test has to be ended in extent
		// Also flush the report

		rep.endTest(test);
		rep.flush();

	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, "Skipped the testcase "+ result.getName().toUpperCase()+ "as the run mode is set to NO");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
