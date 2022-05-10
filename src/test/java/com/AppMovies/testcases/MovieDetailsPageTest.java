package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.MoviesPage;
import com.AppMovies.utility.Log;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DecimalFormat;


public class MovieDetailsPageTest extends Base {


    /*float trueRating = Float.valueOf(RandomUtils.nextFloat());
    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    String formatted = decimalFormat.format(trueRating);*/


    int length = 2;
    String falseRating = RandomStringUtils.random(length, true, false);


    @BeforeMethod
    public void login() throws InterruptedException {
        factory.login();
    }

    @Test
    public void descDisplayed() {
        moviesPage = new MoviesPage();
        movieDetailsPage = moviesPage.clickMovieCard();
        boolean result = movieDetailsPage.descIsDisplayed();
        Assert.assertTrue(result);
    }


    @Test
    public void clickOnRatingBtn() throws Exception {
        moviesPage = new MoviesPage();
        movieDetailsPage = moviesPage.clickMovieCard();
        movieDetailsPage.clickEnterRating();
        boolean result = movieDetailsPage.titleDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void inputElementEnabled() throws Exception {
        moviesPage = new MoviesPage();
        movieDetailsPage = moviesPage.clickMovieCard();
        movieDetailsPage.clickEnterRating();
        boolean result = movieDetailsPage.inputRatingElementEnabled();
        Assert.assertTrue(result);
    }

    @Test
    public void sendRatingSucces() throws Exception {
        moviesPage = new MoviesPage();
        movieDetailsPage = moviesPage.clickMovieCard();
        movieDetailsPage.clickEnterRating();
        movieDetailsPage.setEnterRating(5.5F);
        boolean result = movieDetailsPage.successElemIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void sendEmptyRatingorInvalid() throws Exception {
        moviesPage = new MoviesPage();
        movieDetailsPage = moviesPage.clickMovieCard();
        movieDetailsPage.clickEnterRating();
        movieDetailsPage.setEmptyRating(falseRating);
        boolean result = movieDetailsPage.errorElemIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void backToAllMovies(){
        moviesPage = new MoviesPage();
        movieDetailsPage = moviesPage.clickMovieCard();
        moviesPage = movieDetailsPage.goToAllMovies();
        String actualURL = moviesPage.getCurrURL();
        String expectedURL = "http://localhost:4200/movies";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void goToMyProfile(){
        Log.startTestCase("goToMyProfile");
        moviesPage = new MoviesPage();
        Log.info("Login Success");
        movieDetailsPage = moviesPage.clickMovieCard();
        Log.info("Go to movie's details");
        myProfilePage = movieDetailsPage.clickMyProfile();
        String actualURL = myProfilePage.getCurrURL();
        String expectedURL = "http://localhost:4200/myprofile";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
