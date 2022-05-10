package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.AppMovies.base.Base.getDriver;

public class MovieDetailsPage  {

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

    public MovieDetailsPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean descIsDisplayed(){
        return Action.isDisplayed(getDriver(),desciprtion);
    }

    public MyProfilePage clickMyProfile(){
        Action.click(getDriver(),btnMyProfile);
        return new MyProfilePage();
    }

    public MoviesPage goToAllMovies(){
        Action.click(getDriver(),allMovies);
        return new MoviesPage();
    }

    public boolean successElemIsDisplayed() throws Exception {
        Action.JSClick(getDriver(),btnOK);
        return Action.isDisplayed(getDriver(),elmSuccess);
    }

    public boolean errorElemIsDisplayed() throws Exception {
        Action.JSClick(getDriver(),btnOK);
        return Action.isDisplayed(getDriver(),elmError);
    }

    public boolean inputRatingElementEnabled(){
        return Action.isEnabled(getDriver(),enterRating);
    }

    public void setEnterRating(float rating){
        enterRating.sendKeys(Float.toString(rating));
    }

    public void setEmptyRating(String rating){
        enterRating.sendKeys(rating);
    }


    public boolean titleDisplayed(){
        return Action.isDisplayed(getDriver(),titleBtnRating);
    }


    public String getCurrURL(){
        return Action.getCurrentURL(getDriver());
    }

    public void clickEnterRating() throws Exception {
        Action.JSClick(getDriver(),btnRating);
    }

    public MyProfilePage addRatingAndGoToMyprofile(String rating) throws Exception {
        Action.fluentWait(getDriver(),btnRating,10);
        Action.JSClick(getDriver(),btnRating);
        Action.type(enterRating,rating);
        Action.click(getDriver(),btnOK);
        Action.JSClick(getDriver(),closeBtn);
        Action.fluentWait(getDriver(),btnMyProfile,10);
        Action.JSClick(getDriver(),btnMyProfile);
        return new MyProfilePage();

    }
}
