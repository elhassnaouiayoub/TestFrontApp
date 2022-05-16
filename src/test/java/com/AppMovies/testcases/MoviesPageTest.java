package com.AppMovies.testcases;

import com.AppMovies.automationApplication.MoviesApplication;
import com.AppMovies.base.Base;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class MoviesPageTest extends Base {

    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = false;
    String movieName = RandomStringUtils.random(length, useLetters, useNumbers);


    @BeforeMethod
    public void login() throws InterruptedException {
        factory.login();
    }

    @Test
    public void movieCardIsDisplayed(){
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        boolean result = moviesApplication.moviesPage.movieCardDisplayed();
        assertTrue(result);
    }

    @Test
    public void clickOnMovieCard() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.clickMovieCard();
        String actualURL = moviesApplication.movieDetailsPage.getCurrURL();
        String expectedURl = "http://localhost:4200/movies/";
        assertTrue(actualURL.contains(expectedURl));
    }

    @Test
    public void searchInvalaibleMovie() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        boolean result = moviesApplication.moviesPage.searchMovie(movieName);
        Assert.assertFalse(result);

    }

    @Test
    public void searchAvalaibleMovie() {
        String movieName = "Amb";
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.searchMovie(movieName);
        String title = moviesApplication.moviesPage.getMovieTitle();
        assertTrue(title.contains(movieName));

    }

    @Test
    public void imageCardMovieIsDispalyed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        boolean result = moviesApplication.moviesPage.imgMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void titleCardMovieIsDispalyed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        boolean result = moviesApplication.moviesPage.titleMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void officialRatingMovieIsDispalyed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        boolean result = moviesApplication.moviesPage.officialRatingMovieIsDisplayed();
        Assert.assertTrue(result);
    }

}
