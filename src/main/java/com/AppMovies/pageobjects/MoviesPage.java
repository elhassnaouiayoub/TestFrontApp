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

    @FindBy(className = "mat-card-image")
    WebElement cardImage;

    @FindBy(className = "rating-text")
    WebElement officialRating;

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

    public MovieDetailsPage searchMovieAndClick(String title) throws Exception {
        Action.fluentWait(getDriver(),moviecard,10);
        Action.type(inputSearch,title);
        Action.click(getDriver(),btnSearch);
        if(movieTitle.getText().equalsIgnoreCase(title)){
            Action.fluentWait(getDriver(),moviecard,20);
            Action.click(getDriver(),moviecard);
        }
        return new MovieDetailsPage();
    }

    public boolean imgMovieIsDisplayed(){
        Action.fluentWait(getDriver(),cardImage,10);
        return Action.isDisplayed(getDriver(),cardImage);
    }

    public boolean titleMovieIsDisplayed(){
        return Action.isDisplayed(getDriver(),movieTitle);
    }

    public boolean officialRatingMovieIsDisplayed(){
        return Action.isDisplayed(getDriver(),officialRating);
    }

}


