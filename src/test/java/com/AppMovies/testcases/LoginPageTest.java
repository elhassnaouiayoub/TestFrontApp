package com.AppMovies.testcases;

import com.AppMovies.automationApplication.MoviesApplication;
import com.AppMovies.base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {


    @Test
    public void loginTextDisplayed(){
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        boolean result = moviesApplication.loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);
    }


    @Test
    public void toRegister(){
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.loginPage.goToRegister();
        boolean result = moviesApplication.registerPage.registerTextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void login() throws InterruptedException {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        moviesApplication.loginPage.login(username,password);
        driver.switchTo().alert().accept();
        boolean result = moviesApplication.moviesPage.btnIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void emptyLogin() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.loginPage.Empty();
        String actualURL = moviesApplication.loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void invalidEnter() throws InterruptedException {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        String username = prop.getProperty("username");
        String password = "";
        moviesApplication.loginPage.login(username,password);
        String actualURL = moviesApplication.loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);
    }





}
