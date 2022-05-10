package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.MoviesPage;
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
        moviesPage = new MoviesPage();
        boolean result = moviesPage.movieCardDisplayed();
        assertTrue(result);
    }

    @Test
    public void clickOnMovieCard() {
        moviesPage = new MoviesPage();
        movieDetailsPage = moviesPage.clickMovieCard();
        String actualURL = movieDetailsPage.getCurrURL();
        String expectedURl = "http://localhost:4200/movies/";
        assertTrue(actualURL.contains(expectedURl));
    }

    @Test
    public void searchInvalaibleMovie() throws InterruptedException {
        moviesPage = new MoviesPage();
        boolean result = moviesPage.searchMovie(movieName);
        Assert.assertFalse(result);

    }

    @Test
    public void searchAvalaibleMovie() {
        String movieName = "Amb";
        moviesPage = new MoviesPage();
        moviesPage.searchMovie(movieName);
        String title = moviesPage.getMovieTitle();
        assertTrue(title.contains(movieName));

    }

    @Test
    public void imageCardMovieIsDispalyed() {
        moviesPage = new MoviesPage();
        boolean result = moviesPage.imgMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void titleCardMovieIsDispalyed() {
        moviesPage = new MoviesPage();
        boolean result = moviesPage.titleMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void officialRatingMovieIsDispalyed() {
        moviesPage = new MoviesPage();
        boolean result = moviesPage.officialRatingMovieIsDisplayed();
        Assert.assertTrue(result);
    }

}
