package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.MoviesPage;
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

    @Test
    public void imageMovieIsDisplayed() {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        boolean result = myProfilePage.imgMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void titleMovieIsDisplayed() {
       moviesPage = new MoviesPage();
       myProfilePage = moviesPage.goToProfile();
       boolean result = myProfilePage.titleMovieIsDisplayed();
       Assert.assertTrue(result);
    }

    @Test
    public void userRatingIsDisplayed() {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        boolean result = myProfilePage.userRatingMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void updateUserRating() throws Exception {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        if(myProfilePage.imgMovieIsDisplayed()){
            String title = myProfilePage.getTitleMovie();
            String rating = myProfilePage.getUserRatingMovie();
            moviesPage = myProfilePage.goToAllmovies();
            movieDetailsPage = moviesPage.searchMovieAndClick(title);
            movieDetailsPage.addRatingAndGoToMyprofile(formatted);
            String newRating = myProfilePage.getUserRatingMovie();
            test.info("old rating:" + rating + "     ||     new rating:" + newRating);
            Assert.assertTrue(myProfilePage.updateUserRatingMovie("My rating: "+formatted));
        }
        else {
            test.info("user don't have movie to update");
        }


    }


    @Test
    public void startRatingIsDisplayed() {
        moviesPage = new MoviesPage();
        myProfilePage = moviesPage.goToProfile();
        boolean res = myProfilePage.titleMovieIsDisplayed();
        boolean result = myProfilePage.startRatingIsDisplayed(res);
        Assert.assertTrue(result);
    }


}
