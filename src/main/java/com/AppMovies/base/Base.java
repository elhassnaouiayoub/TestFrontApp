package com.AppMovies.base;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.pageobjects.LoginPage;
import com.AppMovies.pageobjects.MoviesPage;
import com.AppMovies.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.w3c.dom.DOMConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static Properties prop;
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    LoginPage loginPage;
    MoviesPage moviesPage;


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
        launchApp();
        login();
    }

    @AfterMethod
    public void teardown(){
        getDriver().quit();
    }

    public void launchApp(){
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("Chrome")){
            driver.set(new ChromeDriver());
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            driver.set(new EdgeDriver());
        }

        Action.implicitWait(getDriver(),10);
        Action.pageLoadTimeOut(getDriver(),20);
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
    }

    public void login() throws InterruptedException {
        loginPage = new LoginPage();
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        moviesPage = loginPage.login(username,password);
        getDriver().switchTo().alert().accept();
    }


    @AfterSuite
    public void afterSuite(){
        ExtentManager.endReport();
    }



}
