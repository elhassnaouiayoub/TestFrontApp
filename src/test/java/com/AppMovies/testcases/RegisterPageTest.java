package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.LoginPage;
import com.AppMovies.pageobjects.RegisterPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class RegisterPageTest extends Base {

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = false;
    String username = RandomStringUtils.random(length, useLetters, useNumbers);
    String email = randomEmail();
    String password = RandomStringUtils.random(length, useLetters, useNumbers);
    String confirmPassword = password;

    @Test
    public void addUser() throws InterruptedException {
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        registerPage = new RegisterPage();
        loginPage = registerPage.register(username,email,password,confirmPassword);
        getDriver().switchTo().alert().accept();
        boolean result = loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void InvaliedRegister() throws InterruptedException {
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        registerPage = new RegisterPage();
        loginPage = registerPage.register(username,"",password,confirmPassword);
        boolean result = registerPage.registerTextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void confirmPassword() throws InterruptedException {
        loginPage = new LoginPage();
        registerPage = loginPage.goToRegister();
        registerPage = new RegisterPage();
        loginPage = registerPage.register(username,email,password, RandomStringUtils.random(length, useLetters, useNumbers));
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
