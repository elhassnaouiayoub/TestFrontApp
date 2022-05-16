package com.AppMovies.testcases;

import com.AppMovies.automationApplication.MoviesApplication;
import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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


    @BeforeMethod
    public void init(){
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
    }


    @Test
    public void addUser() throws InterruptedException {
        moviesApplication.loginPage.goToRegister();
        moviesApplication.registerPage.register(username,email,password,confirmPassword);
        moviesApplication.registerPage.clickOnSignup();
        moviesApplication.registerPage.verifyMessageAlert();
        /*String alertMSG = moviesApplication.registerPage.verifyMessageAlert();
        String expectedMSG = "Signup Successfull";
        Assert.assertEquals(alertMSG,expectedMSG);*/
        boolean result = moviesApplication.loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);

    }

   @Test
    public void InvaliedRegister() throws InterruptedException {
       moviesApplication.loginPage.goToRegister();
       moviesApplication.registerPage.register(username,"",password,confirmPassword);
       moviesApplication.registerPage.clickOnSignup();
       boolean result = moviesApplication.registerPage.registerTextIsDisplayed();
       Assert.assertTrue(result);
    }

    @Test
    public void confirmPassword() throws InterruptedException {
        moviesApplication.loginPage.goToRegister();
        moviesApplication.registerPage.register(username,email,password, RandomStringUtils.random(length, useLetters, useNumbers));
        moviesApplication.registerPage.clickOnSignup();
        boolean result = moviesApplication.registerPage.registerTextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void goToLogin() {
        moviesApplication.loginPage.goToRegister();
        moviesApplication.registerPage.goToLogin();
        boolean result = moviesApplication.loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);
    }


}