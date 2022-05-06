package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviesPage extends Base {

    @FindBy(id = "movies")
    WebElement btnMovies;

    @FindBy (id = "myprofile")
    WebElement btnMyProfile;

    @FindBy(id = "cardMovie")
    WebElement cardMovie;

    @FindBy(id = "moviecard")
    WebElement moviecard;


    public MoviesPage(){
        PageFactory.initElements(getDriver(),this);
    }


    public String getCurrURL(){
        return Action.getCurrentURL(getDriver());
    }



    public MovieDetailsPage clickMovieCard(){
        Action.click(getDriver(),cardMovie);
        return new MovieDetailsPage();
    }

    public boolean btnIsDisplayed(){
        return Action.isDisplayed(getDriver(),btnMovies);
    }

    public MyProfilePage goToProfile() {
        Action.click(getDriver(),btnMyProfile);
        return new MyProfilePage();
    }

    public boolean movieCardDisplayed(){
        return Action.isDisplayed(getDriver(),moviecard);
    }
}


