package com.AppMovies.testcases;

import com.AppMovies.automationApplication.MoviesApplication;
import com.AppMovies.base.Base;
import com.AppMovies.utility.Log;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DecimalFormat;


public class MovieDetailsPageTest extends Base {





    int length = 2;
    String falseRating = RandomStringUtils.random(length, true, false);


    @BeforeMethod
    public void login() throws InterruptedException {
        factory.login();
    }

    @Test
    public void descDisplayed() {
        moviesApplication.moviesPage.clickMovieCard();
        boolean result = moviesApplication.movieDetailsPage.descIsDisplayed();
        Assert.assertTrue(result);
    }


    @Test
    public void clickOnRatingBtn() throws Exception {
        moviesApplication.moviesPage.clickMovieCard();
        moviesApplication.movieDetailsPage.clickEnterRating();
        boolean result = moviesApplication.movieDetailsPage.titleDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void inputElementEnabled() throws Exception {
        moviesApplication.moviesPage.clickMovieCard();
        moviesApplication.movieDetailsPage.clickEnterRating();
        boolean result = moviesApplication.movieDetailsPage.inputRatingElementEnabled();
        Assert.assertTrue(result);
    }

    @Test
    public void sendRatingSucces() throws Exception {
        moviesApplication.moviesPage.clickMovieCard();
        moviesApplication.movieDetailsPage.clickEnterRating();
        moviesApplication.movieDetailsPage.setEnterRating();
        boolean result = moviesApplication.movieDetailsPage.successElemIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void sendEmptyRatingorInvalid() throws Exception {
        moviesApplication.moviesPage.clickMovieCard();
        moviesApplication.movieDetailsPage.clickEnterRating();
        moviesApplication.movieDetailsPage.setEmptyRating(falseRating);
        boolean result = moviesApplication.movieDetailsPage.errorElemIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void backToAllMovies(){
        moviesApplication.moviesPage.clickMovieCard();
        moviesApplication.movieDetailsPage.goToAllMovies();
        String actualURL = moviesApplication.moviesPage.getCurrURL();
        String expectedURL = "http://localhost:4200/movies";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void goToMyProfile(){
        moviesApplication.moviesPage.clickMovieCard();
        moviesApplication.movieDetailsPage.clickMyProfile();
        String actualURL = moviesApplication.myProfilePage.getCurrURL();
        String expectedURL = "http://localhost:4200/myprofile";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
