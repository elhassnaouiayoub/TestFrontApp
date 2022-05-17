package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;


public class MoviesPage extends Action {
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

    @FindBy(id = "sorting")
    WebElement sorting;

    public MoviesPage(WebDriver driver){
        super(driver);
    }


    public String getCurrURL(){
        return Action.getCurrentURL(driver);
    }

    public String getMovieTitle(){
        return movieTitle.getText();
    }


    public void clickMovieCard(){
        Action.click(driver,cardMovie);
    }

    public boolean btnIsDisplayed(){
        return Action.isDisplayed(driver,btnMovies);
    }

    public void goToProfile() {
        Action.click(driver,btnMyProfile);
    }

    public boolean movieCardDisplayed(){
        return Action.isDisplayed(driver,moviecard);
    }

    public boolean searchMovie(String movieName) {
        Action.fluentWait(driver,moviecard,10);
        inputSearch.sendKeys(movieName);
        Action.click(driver,btnSearch);
        return Action.isDisplayed(driver,moviecard);
    }

    public void searchMovieAndClick(String title) throws Exception {
        Action.fluentWait(driver,moviecard,10);
        Action.type(inputSearch,title);
        Action.click(driver,btnSearch);
        if(movieTitle.getText().equalsIgnoreCase(title)){
            Action.fluentWait(driver,moviecard,10);
            Action.click(driver,moviecard);
        }
    }

    public boolean imgMovieIsDisplayed(){
        Action.fluentWait(driver,cardImage,10);
        return Action.isDisplayed(driver,cardImage);
    }

    public boolean titleMovieIsDisplayed(){
        return Action.isDisplayed(driver,movieTitle);
    }

    public boolean officialRatingMovieIsDisplayed(){
        return Action.isDisplayed(driver,officialRating);
    }


    public boolean ascendingRating(){
        Action.fluentWait(driver,moviecard,20);
        Select select = new Select(sorting);
        select.selectByVisibleText("Ascending");
        int size = driver.findElements(By.className("rating-text")).size();
        List<WebElement> list = driver.findElements(By.className("rating-text"));
        if(parseDouble(list.get(0).getText()) < parseDouble(list.get(size-1).getText())
                && parseDouble(list.get(0).getText()) < parseDouble(list.get((size-1)/2).getText())
                && parseDouble(list.get((size-1)/2).getText()) < parseDouble(list.get((size-1)).getText()) ){
            return true;
        }
        else
            return false;

    }

    public boolean descendingRating(){
        Action.fluentWait(driver,moviecard,20);
        Select select = new Select(sorting);
        select.selectByVisibleText("Descending");
        int size = driver.findElements(By.className("rating-text")).size();
        List<WebElement> list = driver.findElements(By.className("rating-text"));
        if(parseDouble(list.get(0).getText()) > parseDouble(list.get(size-1).getText())
                && parseDouble(list.get(0).getText()) > parseDouble(list.get((size-1)/2).getText())
                && parseDouble(list.get((size-1)/2).getText()) > parseDouble(list.get((size-1)).getText()) ){
            return true;
        }
        else
            return false;

    }
}


