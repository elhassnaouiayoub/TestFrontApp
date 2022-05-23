package com.AppMovies.base;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.automationApplication.MoviesApplication;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static com.AppMovies.base.Base.*;

public class Factory{



    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String username = RandomStringUtils.random(10, true, false);
    String password = RandomStringUtils.random(10, true, true);
    String confirmPassword = password;


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
        driver.get("http://localhost:4200/login");
    }

    public void login() throws InterruptedException {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        String username = configProperties.getPropertyUsername();
        String password = configProperties.getPropertyPassword();
        moviesApplication.loginPage.login(username,password);
        driver.switchTo().alert().accept();
    }

    public void register() throws InterruptedException {
        moviesApplication.loginPage.goToRegister();
        moviesApplication.registerPage.register(username,email,password,confirmPassword);
        moviesApplication.registerPage.clickOnSignup();
        moviesApplication.registerPage.verifyMessageAlert();
        configProperties.setPropertyUsername(username);
        configProperties.setPropertyPassword(password);
    }



}
