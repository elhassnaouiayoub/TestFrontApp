package com.AppMovies.testcases;

import com.AppMovies.base.Base;
import com.AppMovies.pageobjects.LoginPage;
import com.AppMovies.pageobjects.MoviesPage;
import com.AppMovies.pageobjects.MyProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfilePageTest extends Base {

    LoginPage loginPage;
    MoviesPage moviesPage;
    MyProfilePage myProfile;

    @Test
    public void pageProfileDisplayed() throws Exception {
        moviesPage = new MoviesPage();
        myProfile = moviesPage.goToProfile();
        String actualResult = myProfile.getCurrProfilePage();
        String expectedResult = "http://localhost:4200/myprofile";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void goToLoginFromProfile() throws Exception {
        moviesPage = new MoviesPage();
        Thread.sleep(200);
        myProfile = moviesPage.goToProfile();
        loginPage = myProfile.clickDeconnecter();
        boolean result = loginPage.logintextIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void movieCardIsDisplayed() throws Exception {
        moviesPage = new MoviesPage();
        myProfile = moviesPage.goToProfile();
        Thread.sleep(3000);
        boolean result = myProfile.cardIsDisplayed();
        Assert.assertTrue(result);
    }
}
