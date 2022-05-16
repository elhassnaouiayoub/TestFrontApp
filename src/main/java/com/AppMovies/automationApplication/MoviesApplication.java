package com.AppMovies.automationApplication;

import com.AppMovies.pageobjects.*;
import org.openqa.selenium.WebDriver;



public class MoviesApplication {
    public WebDriver driver;

    public LoginPage loginPage;
    public RegisterPage registerPage;
    public MyProfilePage myProfilePage;
    public MoviesPage moviesPage;
    public MovieDetailsPage movieDetailsPage;

    private static MoviesApplication moviesApplication;

    private MoviesApplication(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        myProfilePage = new MyProfilePage(driver);
        moviesPage = new MoviesPage(driver);
        movieDetailsPage= new MovieDetailsPage(driver);
    }

    public static MoviesApplication getMoviesApplication(WebDriver driver){
        return moviesApplication = new MoviesApplication(driver);
    }



}
