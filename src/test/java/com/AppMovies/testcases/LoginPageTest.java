package com.AppMovies.testcases;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.LoginPage;
import com.AppMovies.pageobjects.MoviesPage;
import com.AppMovies.pageobjects.RegisterPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {

    LoginPage loginPage;
    RegisterPage registerPage;
    MoviesPage moviesPage;


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
    public void emptyLogin() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.Empty();
        Alert alert = getDriver().switchTo().alert();
        String actuelResult = alert.getText();
        String expectedResult = "Username Or Password invalid!!";
        Assert.assertEquals(actuelResult,expectedResult);
    }

    @Test
    public void invalidEnter() throws InterruptedException {
        loginPage = new LoginPage();
        String username = prop.getProperty("username");
        String password = "";
        loginPage.login(username,password);
        Alert alert = getDriver().switchTo().alert();
        String actuelResult = alert.getText();
        String expectedResult = "Username Or Password invalid!!";
        Assert.assertEquals(actuelResult,expectedResult);
    }




}
