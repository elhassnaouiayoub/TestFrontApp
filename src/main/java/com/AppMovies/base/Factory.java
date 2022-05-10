package com.AppMovies.base;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.pageobjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.AppMovies.base.Base.*;

public class Factory{

    LoginPage loginPage;
    MoviesPage moviesPage;


    public void launchApp(String browserName){
        WebDriverManager.firefoxdriver().setup();
        //String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }
        else if(browserName.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }

        Action.implicitWait(getDriver(),10);
        Action.pageLoadTimeOut(getDriver(),20);
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
    }

    public void login() throws InterruptedException {loginPage = new LoginPage();
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        moviesPage = loginPage.login(username,password);
        getDriver().switchTo().alert().accept();
    }



}
