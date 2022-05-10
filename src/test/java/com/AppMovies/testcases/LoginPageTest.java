package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {


    @Test
    public void loginTextDisplayed(){
        loginPage = new LoginPage();
        boolean result = loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void toRegister(){
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        boolean result = registerPage.registerTextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void login() throws InterruptedException {
        loginPage = new LoginPage();
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        moviesPage = loginPage.login(username,password);
        getDriver().switchTo().alert().accept();
        boolean result = moviesPage.btnIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void emptyLogin() {
        loginPage = new LoginPage();
        loginPage.Empty();
        String actualURL = loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void invalidEnter() throws InterruptedException {
        loginPage = new LoginPage();
        String username = prop.getProperty("username");
        String password = "";
        loginPage.login(username,password);
        String actualURL = loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);
    }




}
