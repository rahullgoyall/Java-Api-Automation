package utility;

import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportsBase {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ThreadLocal<ExtentTest> logger = new ThreadLocal<ExtentTest>();
	//public ExtentTest logger;

	@BeforeTest(alwaysRun=true)
	public void startReport() {
		System.out.println("ss");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extentReports/ExtentReport.html");
		// Create an object of Extent Reports
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		// Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		// Dark Theme
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "Rajkumar SM");


	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.get().log(Status.FAIL, "Test Case failed is:"+result.getMethod());
			logger.get().log(Status.FAIL, "Test Case failed is:"+result.getThrowable());

			
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.get().log(Status.SKIP, "Test Case skipped is:"+result.getMethod());
			
		}else if(result.getStatus() == ITestResult.SUCCESS){
			logger.get().log(Status.PASS, "Test Case passed is:"+result.getMethod());
			
		}
		
	}

	@AfterTest(alwaysRun=true)
	public void endReport() {
		extent.flush();
	}

}
