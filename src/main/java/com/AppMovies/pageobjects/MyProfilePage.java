package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends Base {

    /*@FindBy(id = "deconnecter")
    WebElement btnDeconnecter;*/
    WebElement btnDeconnecter =getDriver().findElement(By.id("deconnecter"));

    @FindBy(id = "moviecard")
    WebElement moviecard;



    public void MyProfile(){
        PageFactory.initElements(getDriver(),this);
    }


    public LoginPage clickOnBtnDeconnecter() throws Exception {
        Action.fluentWait(getDriver(),btnDeconnecter,1000);
        btnDeconnecter.click();
        return new LoginPage();
    }

    public String getCurrURL(){
        return Action.getCurrentURL(getDriver());
    }

    public boolean movieCardDisplayed(){

        return Action.findElement(getDriver(),moviecard);
    }

}
