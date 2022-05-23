package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class RegisterPageTest extends Base {



    String username = RandomStringUtils.random(10, true, false);
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = RandomStringUtils.random(10, true, true);
    String confirmPassword = password;



   /* @Test
    public void addUser() throws InterruptedException {
        moviesApplication.loginPage.goToRegister();
        moviesApplication.registerPage.register(username,email,password,confirmPassword);
        moviesApplication.registerPage.clickOnSignup();
        moviesApplication.registerPage.verifyMessageAlert();
        boolean result = moviesApplication.loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);

    }*/

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
        moviesApplication.registerPage.register(username,email,password, RandomStringUtils.random(10, true, true));
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