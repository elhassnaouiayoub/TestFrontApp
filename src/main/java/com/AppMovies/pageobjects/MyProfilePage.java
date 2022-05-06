package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.AppMovies.base.Base.getDriver;

public class MyProfilePage{

    @FindBy(id = "deconnecter")
    WebElement btnDeconnecter ;

    @FindBy(className="mat-card-image")
    WebElement cardImage ;



    public MyProfilePage(){
        PageFactory.initElements(getDriver(),this);
    }


    public LoginPage clickOnBtnDeconnecter() {
        btnDeconnecter.click();
        return new LoginPage();
    }

    public String getCurrURL(){
        return Action.getCurrentURL(getDriver());
    }

    public boolean movieCardDisplayed(){
        Action.fluentWait(getDriver(),cardImage,10);
        return Action.isDisplayed(getDriver(),cardImage);
    }

}
