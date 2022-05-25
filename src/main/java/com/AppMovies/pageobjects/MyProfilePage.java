package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Rule;

import static com.AppMovies.utility.ExtentManager.test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class MyProfilePage extends Action {

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

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }


    public void clickOnBtnDeconnecter() {
        btnDeconnecter.click();
    }

    public String getCurrURL() {
        return Action.getCurrentURL(driver);
    }

    public boolean movieCardDisplayed() {
        Action.fluentWait(driver, cardImage, 10);
        if(!(Action.isDisplayed(driver, cardImage))){
            test.warning("user doesn't have a movie !!");
            return false;
        }
        else return true;
    }

    public boolean removeMovieFromMyProfile() throws Exception {
        int size = driver.findElements(By.className("mat-card-title")).size();
        if(size>1) {
            String title = movieTitle.getText();
            Action.click(driver, removeMovie);
            Action.JSClick(driver, yesDelete);
            Action.fluentWait(driver, cardMovie, 5);
            driver.navigate().refresh();
            Action.fluentWait(driver, movieTitle, 5);
            if (movieTitle.getText().equalsIgnoreCase(title)) {
                return false;
            } else
                return true;
        }
        else if (size == 1){
            Action.click(driver, removeMovie);
            Action.JSClick(driver, yesDelete);
            return true;
        }
            test.warning("user doesn't have movie to update");
            return false;
    }


    public boolean cancelRemoveMovieFromMyProfile() {
        int size = driver.findElements(By.className("mat-card-title")).size();
        if(size>=1) {
            String title = movieTitle.getText();
            Action.click(driver, removeMovie);
            Action.click(driver, cancelDelete);
            driver.navigate().refresh();
            if (movieTitle.getText().equalsIgnoreCase(title)) {
                return true;
            } else
                return false;
        }
        else
            test.warning("user doesn't have movie");
            return true;

    }

    public boolean imgMovieIsDisplayed(){
        Action.fluentWait(driver,cardImage,5);
        if( Action.isDisplayed(driver,cardImage))
        return true;
        else{
            test.warning("user doesn't have movie");
            return false;
        }
    }

    public boolean titleMovieIsDisplayed(){
       if(Action.isDisplayed(driver,movieTitle))
            return true;
       else{
            test.warning("user doesn't have movie");
            return false;
        }
    }

    public boolean userRatingMovieIsDisplayed(){
        if(Action.isDisplayed(driver,userRating))
            return true;
        else{
            test.warning("user doesn't have movie");
            return false;
        }
    }


    public String getUserRatingMovie(){
        return userRating.getText();
    }

    public void goToMovieDetails(){
        Action.click(driver,movieTitle);
    }

    public boolean updateUserRatingMovie(String rating)  {
        Action.fluentWait(driver,userRating,5);
        if((userRating.getText()).equalsIgnoreCase(rating)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean startRatingIsDisplayed(){
       return Action.isDisplayed(driver,btnStartRating);

    }

    public boolean mockStartRatingIsDisplayed(){
        if(Action.isDisplayed(driver,btnStartRating)){
            return true;
        }
        else {
            test.warning("User have a movie");
            return true;
        }

    }

    public void clickOnStartRatingAndSelectMovie(){
        Action.click(driver,AllMovies);
        Action.click(driver,movieTitle);

    }

    public void clickMyProfile() throws Exception {
        Action.click(driver,closeBtn);
        Action.fluentWait(driver,btnMyProfile,5);
        Action.JSClick(driver,btnMyProfile);
    }



}
