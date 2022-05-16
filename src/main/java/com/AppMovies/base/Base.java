package com.AppMovies.base;

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


    public static Properties prop;
    public static WebDriver driver;
    protected Factory factory = new Factory();

    public static MoviesApplication moviesApplication;


    @BeforeSuite
    public void loadConfig(){
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
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
