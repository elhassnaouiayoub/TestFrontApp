package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.LoginPage;
import com.AppMovies.pageobjects.MoviesPage;
import com.AppMovies.pageobjects.MyProfilePage;
import com.AppMovies.utility.Log;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfilePageTest extends Base {

    LoginPage loginPage;
    MoviesPage moviesPage;
    MyProfilePage myProfile;

    @Test
    public void pageProfileDisplayed() throws Exception {
        moviesPage = new MoviesPage();
        ;
        myProfile = moviesPage.goToProfile();
        String actualResult = myProfile.getCurrURL();
        String expectedResult = "http://localhost:4200/myprofile";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void goToLoginPage() throws Exception {
        moviesPage = new MoviesPage();
        myProfile = moviesPage.goToProfile();
        loginPage = myProfile.clickOnBtnDeconnecter();
        Thread.sleep(2000);
        String actualURL = loginPage.getCurrURL();
        String expectedURL = "http://localhost:4200/login";
        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void isMovieCardDsiplayed() throws Exception {
        moviesPage = new MoviesPage();
        myProfile = moviesPage.goToProfile();
        Thread.sleep(3000);

        System.out.println(myProfile.movieCardDisplayed());
        /*boolean result = myProfile.movieCardDisplayed();
        Assert.assertTrue(result);*/

    }

}
