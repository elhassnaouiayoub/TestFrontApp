package com.AppMovies.testcases;

import com.AppMovies.automationApplication.MoviesApplication;
import com.AppMovies.base.Base;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

import static com.AppMovies.utility.ExtentManager.test;

public class MyProfilePageTest extends Base {

    float trueRating = Float.valueOf(RandomUtils.nextFloat(0,10));
    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    String formatted = decimalFormat.format(trueRating).replaceAll(",", ".");


    @BeforeMethod
    public void login() throws InterruptedException {
        factory.login();
    }



    @Test
    public void pageProfileDisplayed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        String actualResult = moviesApplication.myProfilePage.getCurrURL();
        String expectedResult = "http://localhost:4200/myprofile";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void goToLoginPage()  {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        moviesApplication.myProfilePage.clickOnBtnDeconnecter();
        String actualURL = moviesApplication.loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void isMovieCardDsiplayed(){
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.movieCardDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void removeMovieSuccess() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.removeMovieFromMyProfile();
        Assert.assertTrue(result);
    }

    @Test
    public void cancelRemoveMovie() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.cancelRemoveMovieFromMyProfile();
        Assert.assertTrue(result);
    }

    @Test
    public void imageMovieIsDisplayed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.imgMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void titleMovieIsDisplayed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
       boolean result = moviesApplication.myProfilePage.titleMovieIsDisplayed();
       Assert.assertTrue(result);
    }

    @Test
    public void userRatingIsDisplayed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.userRatingMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void updateUserRating() throws Exception {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        if(moviesApplication.myProfilePage.imgMovieIsDisplayed()){
            String rating = moviesApplication.myProfilePage.getUserRatingMovie();
            moviesApplication.myProfilePage.goToAllmovies();
            moviesApplication.movieDetailsPage.addRatingAndGoToMyprofile(formatted);
            String newRating = moviesApplication.myProfilePage.getUserRatingMovie();
            test.info("old rating:" + rating + "     ||     new rating:" + newRating);
            Assert.assertTrue(moviesApplication.myProfilePage.updateUserRatingMovie("My rating: "+formatted));
        }
        else {
            test.warning("user don't have movie to update");
        }


    }


    @Test
    public void startRatingIsDisplayed() {
        moviesApplication = MoviesApplication.getMoviesApplication(driver);
        moviesApplication.moviesPage.goToProfile();
        boolean res = moviesApplication.myProfilePage.titleMovieIsDisplayed();
        boolean result = moviesApplication.myProfilePage.startRatingIsDisplayed(res);
        Assert.assertTrue(result);
    }


}
