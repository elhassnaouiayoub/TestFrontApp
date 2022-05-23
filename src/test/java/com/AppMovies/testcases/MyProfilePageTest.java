package com.AppMovies.testcases;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.AppMovies.utility.ExtentManager.test;


public class MyProfilePageTest extends Base {



    @BeforeMethod
    public void login() throws InterruptedException {
        factory.login();
    }

    @Test()
    public void startRatingIsDisplayed() {
        moviesApplication.moviesPage.goToProfile();
        Assert.assertTrue(moviesApplication.myProfilePage.startRatingIsDisplayed());
    }

    @Test(dependsOnMethods = "startRatingIsDisplayed")
    public void addMovieToMyCatalog() throws Exception {
        moviesApplication.moviesPage.goToProfile();
        moviesApplication.myProfilePage.clickOnStartRatingAndSelectMovie();
        moviesApplication.movieDetailsPage.clickEnterRating();
        moviesApplication.movieDetailsPage.setEnterRating();
        moviesApplication.myProfilePage.clickMyProfile();
        Assert.assertTrue(moviesApplication.myProfilePage.titleMovieIsDisplayed());
    }



    @Test
    public void pageProfileDisplayed() {
        moviesApplication.moviesPage.goToProfile();
        String actualResult = moviesApplication.myProfilePage.getCurrURL();
        String expectedResult = "http://localhost:4200/myprofile";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void goToLoginPage()  {
        moviesApplication.moviesPage.goToProfile();
        moviesApplication.myProfilePage.clickOnBtnDeconnecter();
        String actualURL = moviesApplication.loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(dependsOnMethods = "addMovieToMyCatalog")
    public void isMovieCardDsiplayed(){
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.movieCardDisplayed();
        Assert.assertTrue(result);
    }


    @Test(dependsOnMethods = "cancelRemoveMovie")
    public void removeMovieSuccess() throws Exception {
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.removeMovieFromMyProfile();
        Assert.assertTrue(result);

    }

    @Test(dependsOnMethods = "addMovieToMyCatalog")
    public void cancelRemoveMovie() {
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.cancelRemoveMovieFromMyProfile();
        Assert.assertTrue(result);
    }

    @Test(dependsOnMethods = "addMovieToMyCatalog")
    public void imageMovieIsDisplayed() {
        moviesApplication.moviesPage.goToProfile();
        boolean result = moviesApplication.myProfilePage.imgMovieIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test(dependsOnMethods = "addMovieToMyCatalog")
    public void titleMovieIsDisplayed() {
        moviesApplication.moviesPage.goToProfile();
       boolean result = moviesApplication.myProfilePage.titleMovieIsDisplayed();
       Assert.assertTrue(result);
    }

    @Test(dependsOnMethods = "addMovieToMyCatalog")
    public void userRatingIsDisplayed() {
        moviesApplication.moviesPage.goToProfile();
        Assert.assertTrue(moviesApplication.myProfilePage.userRatingMovieIsDisplayed());
    }

    @Test(dependsOnMethods = "addMovieToMyCatalog")
    public void updateUserRating() throws Exception {
        moviesApplication.moviesPage.goToProfile();
        if(moviesApplication.myProfilePage.imgMovieIsDisplayed()){
            String rating = moviesApplication.myProfilePage.getUserRatingMovie();
            String newRating = Action.getFloatNumber();
            moviesApplication.myProfilePage.goToMovieDetails();
            moviesApplication.movieDetailsPage.addRatingAndGoToMyprofile(newRating);
            //String newRating = moviesApplication.myProfilePage.getUserRatingMovie();
            test.info("old rating:" + rating + "     ||     new rating:" + newRating);
            Assert.assertTrue(moviesApplication.myProfilePage.updateUserRatingMovie("My rating: "+newRating));
        }
        else {
            test.warning("user doesn't have movie to update");
        }
    }





}
