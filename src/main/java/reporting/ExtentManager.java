package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			String reportPath = System.getProperty("user.dir") + "/reports/extent-report.html";

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			spark.config().setReportName("Automation Report");
			spark.config().setDocumentTitle("Test Results");

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}

		return extent;
	}
}