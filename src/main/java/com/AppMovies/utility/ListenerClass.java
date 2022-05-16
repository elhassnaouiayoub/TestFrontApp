package com.AppMovies.utility;
import java.io.IOException;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static com.AppMovies.actiondriver.Action.driver;


public class ListenerClass extends ExtentManager implements ITestListener{

    Action action= new Action(driver);


    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            try {
                test.assignCategory(result.getTestClass().getName());
                test.log(Status.PASS,
                        MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));

                String imgPath = action.screenShot(driver, result.getName());

                test.pass("ScreenShot is attached",MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                test.assignCategory(result.getTestClass().getName());
                test.log(Status.FAIL,
                        MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
                test.log(Status.FAIL,
                        MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

                String imgPath = action.screenShot(driver, result.getName());

                test.fail("ScreenShot is attached",MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }
}
