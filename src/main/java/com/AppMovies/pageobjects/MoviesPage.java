package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.AppMovies.base.Base.getDriver;

public class MoviesPage {
    @FindBy(id = "movies")
    WebElement btnMovies;

    @FindBy (id = "myprofile")
    WebElement btnMyProfile;

    @FindBy(id = "cardMovie")
    WebElement cardMovie;

    @FindBy(id = "moviecard")
    WebElement moviecard;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement inputSearch;

    @FindBy(id = "button-search")
    WebElement btnSearch;

    @FindBy(className = "mat-card-title")
    WebElement movieTitle;


    public MoviesPage(){
        PageFactory.initElements(getDriver(),this);
    }


    public String getCurrURL(){
        return Action.getCurrentURL(getDriver());
    }

    public String getMovieTitle(){
        return movieTitle.getText();
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

    public boolean searchMovie(String movieName) {
        Action.fluentWait(getDriver(),moviecard,10);
        inputSearch.sendKeys(movieName);
        Action.click(getDriver(),btnSearch);
        return Action.isDisplayed(getDriver(),moviecard);
    }

}


