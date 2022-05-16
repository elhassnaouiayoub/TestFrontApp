package com.AppMovies.base;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.automationApplication.MoviesApplication;
import com.AppMovies.pageobjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.AppMovies.base.Base.*;

public class Factory{


    public void launchApp(String browserName){
        //String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(browserName.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        Action.implicitWait(driver,10);
        Action.pageLoadTimeOut(driver,20);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    public void login() throws InterruptedException {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        moviesApplication.loginPage.login(username,password);
        driver.switchTo().alert().accept();
    }



}
