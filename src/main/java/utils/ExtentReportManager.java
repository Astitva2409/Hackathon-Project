package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report;

    public static ExtentReports getReportInstance() {
        if (htmlReporter == null && report == null) {
            String reportName = DateUtils.getTime() + ".html";
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/" + reportName);
            report = new ExtentReports();
            report.attachReporter(htmlReporter);
        }
        return report;
    }
}
