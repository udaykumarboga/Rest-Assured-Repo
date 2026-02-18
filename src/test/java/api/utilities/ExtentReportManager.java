package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.markuputils.ExtentColor;
import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
//	public ExtentReports extent;
	public static ExtentTest test;
	String repName;
	private ExtentReports extent;

	public void onStart(ITestContext testContext){


		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());//time stamp
		String dateStamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		repName="Extent-Report-"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\extent-reports\\" + dateStamp + "\\"+ repName);//specify location of the report

		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); // Title of report
		sparkReporter.config().setReportName("Swagger API"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "swagger video game");
		extent.setSystemInfo("user","Quality Matrix");
	}

	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS,repName);
		test.log(Status.PASS, "Test Passed");
		test.info(result.getName()+" is Passed successfully");
		test.generateLog(Status.PASS,result.getName());
	}

	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
