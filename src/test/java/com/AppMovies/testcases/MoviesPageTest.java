package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.MovieDetailsPage;
import com.AppMovies.pageobjects.MoviesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MoviesPageTest extends Base {

    MoviesPage moviesPage;
    MovieDetailsPage movieDetails;


    @Test
    public void movieCardIsDisplayed() throws Exception {
        moviesPage = new MoviesPage();
        boolean result = moviesPage.movieCardDisplayed();
        assertTrue(result);
    }

    @Test
    public void clickOnMovieCard() throws Exception {
        moviesPage = new MoviesPage();
        movieDetails = moviesPage.clickMovieCard();
        String actualURL = movieDetails.getCurrURL();
        String expectedURl = "http://localhost:4200/movies/";
        assertTrue(actualURL.contains(expectedURl));
    }

}
