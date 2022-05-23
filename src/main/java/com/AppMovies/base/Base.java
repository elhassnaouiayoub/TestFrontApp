package com.AppMovies.base;

import com.AppMovies.actiondriver.ConfigProperties;
import com.AppMovies.actiondriver.MyScreenRecorder;
import com.AppMovies.automationApplication.MoviesApplication;
import com.AppMovies.pageobjects.*;
import com.AppMovies.utility.ExtentManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Base{


    public static WebDriver driver;
    protected Factory factory = new Factory();

    public static ConfigProperties configProperties = new ConfigProperties();
    public static MoviesApplication moviesApplication;



    @BeforeSuite
    public void loadConfig() {
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");
    }

    @Parameters("browser")
    @BeforeTest
    public void register(String browser) throws InterruptedException {
        factory.launchApp(browser);
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        factory.register();
        driver.quit();
    }


/*
    public static WebDriver getDriver(){
        return driver.get();
    }
*/

    @Parameters("browser")
    @BeforeMethod
    public void setup(Method method, String browser) throws Exception {
        factory.launchApp(browser);
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        MyScreenRecorder.startRecording(method.getName());
    }

    @AfterMethod
    public void teardown() throws Exception {
        driver.quit();
        MyScreenRecorder.stopRecording();
    }



    @AfterSuite
    public void afterSuite(){
        ExtentManager.endReport();
    }



}
