package com.AppMovies.base;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.pageobjects.*;
import com.AppMovies.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static Properties prop;
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    protected Factory factory = new Factory();
    protected LoginPage loginPage;
    protected MoviesPage moviesPage;
    protected RegisterPage registerPage;
    protected MovieDetailsPage movieDetailsPage;
    protected MyProfilePage myProfilePage;


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

    public static WebDriver getDriver(){
        return driver.get();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        factory.launchApp();
        factory.login();
    }

    @AfterMethod
    public void teardown(){
        getDriver().quit();
    }



    @AfterSuite
    public void afterSuite(){
        ExtentManager.endReport();
    }



}
