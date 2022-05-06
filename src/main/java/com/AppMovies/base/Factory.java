package com.AppMovies.base;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.pageobjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.AppMovies.base.Base.*;

public class Factory{

    LoginPage loginPage;
    MoviesPage moviesPage;


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

    public void login() throws InterruptedException {loginPage = new LoginPage();
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        moviesPage = loginPage.login(username,password);
        getDriver().switchTo().alert().accept();
    }



}
