package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.AppMovies.base.Base.getDriver;

public class MyProfilePage {

    @FindBy(id = "deconnecter")
    WebElement btnDeconnecter;

    @FindBy(className = "mat-card-image")
    WebElement cardImage;

    @FindBy(className = "mat-card-title")
    WebElement movieTitle;

    @FindBy(className = "rating-text")
    WebElement userRating;

    @FindBy(id = "btnRateMovie")
    WebElement removeMovie;

    @FindBy(className = "swal2-confirm")
    WebElement yesDelete;

    @FindBy(className = "swal2-cancel")
    WebElement cancelDelete;

    @FindBy(id = "movies")
    WebElement AllMovies;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement inputSearch;

    @FindBy(id = "button-search")
    WebElement btnSearch;

    @FindBy(id = "cardMovie")
    WebElement cardMovie;

    @FindBy(id = "btnRateMovie")
    WebElement btnRating;

    @FindBy(className = "swal2-input")
    WebElement enterRating;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement btnOK;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement closeBtn;

    @FindBy (id = "myprofile")
    WebElement btnMyProfile;

    @FindBy(id = "btnStartRating")
    WebElement btnStartRating;

    public MyProfilePage() {
        PageFactory.initElements(getDriver(), this);
    }


    public LoginPage clickOnBtnDeconnecter() {
        btnDeconnecter.click();
        return new LoginPage();
    }

    public String getCurrURL() {
        return Action.getCurrentURL(getDriver());
    }

    public boolean movieCardDisplayed() {
        Action.fluentWait(getDriver(), cardImage, 10);
        return Action.isDisplayed(getDriver(), cardImage);
    }

    public boolean removeMovieFromMyProfile() {
        int size = getDriver().findElements(By.className("mat-card-title")).size();
        if(size>1) {
            String title = movieTitle.getText();
            Action.click(getDriver(), removeMovie);
            Action.click(getDriver(), yesDelete);
            getDriver().navigate().refresh();
            Action.fluentWait(getDriver(), movieTitle, 10);
            if (movieTitle.getText().equalsIgnoreCase(title)) {
                return false;
            } else
                return true;
        }
        else if (size == 1){
            Action.click(getDriver(), removeMovie);
            Action.click(getDriver(), yesDelete);
            return true;
        }
        else
            return true;
    }


    public boolean cancelRemoveMovieFromMyProfile() {
        int size = getDriver().findElements(By.className("mat-card-title")).size();
        if(size>=1) {
            String title = movieTitle.getText();
            Action.click(getDriver(), removeMovie);
            Action.click(getDriver(), cancelDelete);
            getDriver().navigate().refresh();
            if (movieTitle.getText().equalsIgnoreCase(title)) {
                return true;
            } else
                return false;
        }
        else
            return true;

    }

    public boolean imgMovieIsDisplayed(){
        Action.fluentWait(getDriver(),cardImage,10);
        return Action.isDisplayed(getDriver(),cardImage);
    }

    public boolean titleMovieIsDisplayed(){
        return Action.isDisplayed(getDriver(),movieTitle);
    }

    public boolean userRatingMovieIsDisplayed(){
        return Action.isDisplayed(getDriver(),userRating);
    }

    public String getTitleMovie(){
        return movieTitle.getText();
    }

    public String getUserRatingMovie(){
        return userRating.getText();
    }

    public MoviesPage goToAllmovies(){
        Action.click(getDriver(),AllMovies);
        return new MoviesPage();
    }

    public boolean updateUserRatingMovie(String rating)  {
        if(userRating.getText().equalsIgnoreCase(rating)){
            return false;
        }
        else
            return true;
    }

    public boolean startRatingIsDisplayed(boolean res){
        if(res == false){
            return Action.isDisplayed(getDriver(),btnStartRating);
        }
        Log.info("User have a movie rating");
        return false;

    }

}
