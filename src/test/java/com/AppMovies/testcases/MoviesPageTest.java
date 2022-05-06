package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.MovieDetailsPage;
import com.AppMovies.pageobjects.MoviesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MoviesPageTest extends Base {

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

}
