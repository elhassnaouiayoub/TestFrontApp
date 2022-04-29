package com.AppMovies.utility;
import com.AppMovies.base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class ExtentManager extends Base {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "ApplicationMovies");
        extent.setSystemInfo("Tester", "Ayoub-Meryem");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }
    public static void endReport() {
        extent.flush();
    }
}