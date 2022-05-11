package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.AppMovies.base.Base.getDriver;
import static com.AppMovies.utility.ExtentManager.test;

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
        if(!(Action.isDisplayed(getDriver(), cardImage))){
            test.warning("user don't have a movie !!");
            return false;
        }
        else return true;
    }

    public boolean removeMovieFromMyProfile() {
        int size = getDriver().findElements(By.className("mat-card-title")).size();
        if(size>1) {
            String title = movieTitle.getText();
            Action.click(getDriver(), removeMovie);
            Action.click(getDriver(), yesDelete);
            Action.fluentWait(getDriver(), cardMovie, 5);
            getDriver().navigate().refresh();
            Action.fluentWait(getDriver(), movieTitle, 5);
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
            test.warning("Movie don't exist");
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
        Action.fluentWait(getDriver(),cardImage,5);
        if(!(Action.isDisplayed(getDriver(),cardImage))){
            test.warning("user don't have a movie");
            return false;
        }
        else return true;
    }

    public boolean titleMovieIsDisplayed(){
        if(!(Action.isDisplayed(getDriver(),movieTitle))){
            test.warning("user don't have a movie");
            return false;
        }
        else return true;
    }

    public boolean userRatingMovieIsDisplayed(){
        if(!(Action.isDisplayed(getDriver(),userRating))){
            test.warning("user don't have a movie");
            return false;
        }
        else return true;
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
        Action.fluentWait(getDriver(),userRating,5);
        if((userRating.getText()).equalsIgnoreCase(rating)){
            return true;
        }
        else
            return false;
    }

    public boolean startRatingIsDisplayed(boolean res){
        if(!(res)){
            return Action.isDisplayed(getDriver(),btnStartRating);
        }
        test.warning("User have a movie");
        return false;

    }



}
