package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static com.AppMovies.base.Base.getDriver;

public class MyProfilePage {

    @FindBy(id = "deconnecter")
    WebElement btnDeconnecter;

    @FindBy(className = "mat-card-image")
    WebElement cardImage;

    @FindBy(className = "mat-card-title")
    WebElement movieTitle;


    @FindBy(id = "btnRateMovie")
    WebElement removeMovie;

    @FindBy(className = "swal2-confirm")
    WebElement yesDelete;

    @FindBy(className = "swal2-cancel")
    WebElement cancelDelete;


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

}
