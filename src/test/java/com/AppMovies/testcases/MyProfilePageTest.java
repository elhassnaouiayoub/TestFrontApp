package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.MoviesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyProfilePageTest extends Base {

    @BeforeMethod
    public void login() throws InterruptedException {
        factory.login();
    }

    @Test
    public void pageProfileDisplayed() throws Exception {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        String actualResult = myProfilePage.getCurrURL();
        String expectedResult = "http://localhost:4200/myprofile";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void goToLoginPage()  {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        loginPage = myProfilePage.clickOnBtnDeconnecter();
        String actualURL = loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void isMovieCardDsiplayed(){
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        boolean result = myProfilePage.movieCardDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void removeMovieSuccess() {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        boolean result = myProfilePage.removeMovieFromMyProfile();
        Assert.assertTrue(result);
    }

    @Test
    public void cancelRemoveMovie() {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        boolean result = myProfilePage.cancelRemoveMovieFromMyProfile();
        Assert.assertTrue(result);
    }

}
