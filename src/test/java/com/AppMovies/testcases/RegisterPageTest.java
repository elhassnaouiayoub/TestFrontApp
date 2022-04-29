package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.LoginPage;
import com.AppMovies.pageobjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends Base {
    RegisterPage registerPage;
    LoginPage loginPage;


    @Test
    public void addUser() throws InterruptedException {
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        registerPage = new RegisterPage();
        loginPage = registerPage.register("hbklh","kjhh","jhl","jhl");
        getDriver().switchTo().alert().accept();
        boolean result = loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void InvaliedRegister() throws InterruptedException {
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        registerPage = new RegisterPage();
        loginPage = registerPage.register("hbklh","","jhl","jhl");
        boolean result = registerPage.registerTextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void confirmPassword() throws InterruptedException {
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        registerPage = new RegisterPage();
        loginPage = registerPage.register("hbklh","njh","jhl","kjkm");
        boolean result = registerPage.registerTextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void goToLogin() {
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        loginPage = registerPage.goToLogin();
        boolean result = loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);
    }


}
