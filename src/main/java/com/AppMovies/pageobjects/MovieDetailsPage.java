package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MovieDetailsPage extends Action {

    @FindBy(id = "btnRateMovie")
    WebElement btnRating;

    @FindBy(id = "swal2-title")
    WebElement titleBtnRating;

    @FindBy(className = "paragraph")
    WebElement desciprtion;

    @FindBy(className = "swal2-input")
    WebElement enterRating;

    @FindBy(xpath = "//*[text()='Success!']")
    WebElement elmSuccess;

    @FindBy(xpath = "//*[text()='Error!']")
    WebElement elmError;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement btnOK;

    @FindBy(id = "movies")
    WebElement allMovies;

    @FindBy (id = "myprofile")
    WebElement btnMyProfile;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement closeBtn;

    public MovieDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean descIsDisplayed(){
        return Action.isDisplayed(driver,desciprtion);
    }

    public void clickMyProfile(){
        Action.click(driver,btnMyProfile);
    }

    public void goToAllMovies(){
        Action.click(driver,allMovies);
    }

    public boolean successElemIsDisplayed() throws Exception {
        Action.JSClick(driver,btnOK);
        Action.fluentWait(driver,elmSuccess,5);
        return Action.isDisplayed(driver,elmSuccess);
    }

    public boolean errorElemIsDisplayed() throws Exception {
        Action.JSClick(driver,btnOK);
        return Action.isDisplayed(driver,elmError);
    }

    public boolean inputRatingElementEnabled(){
        return Action.isEnabled(driver,enterRating);
    }

    public void setEnterRating(float rating){
        Action.type(enterRating, String.valueOf(rating));
    }

    public void setEmptyRating(String rating){
        enterRating.sendKeys(rating);
    }


    public boolean titleDisplayed(){
        return Action.isDisplayed(driver,titleBtnRating);
    }


    public String getCurrURL(){
        return Action.getCurrentURL(driver);
    }

    public void clickEnterRating() throws Exception {
        Action.fluentWait(driver,btnRating,4);
        Action.moveToElement(driver,btnRating);
        Action.JSClick(driver,btnRating);
    }

    public void addRatingAndGoToMyprofile(String rating) throws Exception {
        Action.fluentWait(driver,btnRating,5);
        Action.JSClick(driver,btnRating);
        Action.type(enterRating,rating);
        Action.JSClick(driver,btnOK);
        Action.JSClick(driver,closeBtn);
        Action.fluentWait(driver,btnMyProfile,5);
        Action.JSClick(driver,btnMyProfile);
    }
}
