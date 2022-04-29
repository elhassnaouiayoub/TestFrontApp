package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends Base {

    @FindBy(id = "nameProfile")
    WebElement name;

    @FindBy(id = "emailProfile")
    WebElement email;

    @FindBy(id = "profilepage")
    WebElement profileText;

    @FindBy(id = "deconnecter")
    WebElement btnDeconnecter;

    @FindBy(id = "moviecard")
    WebElement moviecard;



    public void MyProfile(){
        PageFactory.initElements(getDriver(),this);
    }


    public String getCurrURL(){
        return Action.getCurrentURL(getDriver());
    }

    public boolean cardIsDisplayed(){
        return Action.isDisplayed(getDriver(),moviecard);
    }


    public boolean movieCardDisplayed(){
        return Action.isDisplayed(getDriver(),moviecard);
    }

    public boolean nameIsDisplayed(){
        return Action.isDisplayed(getDriver(),name);
    }

    public boolean emailIsDisplayed(){
        return Action.isDisplayed(getDriver(),email);
    }

    public String getCurrProfilePage(){
        return Action.getCurrentURL(getDriver());
    }


    public LoginPage clickDeconnecter() throws Exception {
        //Action.mouseover(getDriver(),btnDeconnecter);
        Action.fluentWait(getDriver(),btnDeconnecter,2000);
        Action.JSClick(getDriver(),btnDeconnecter);
        /*Action.moveToElement(getDriver(),btnDeconnecter);*/
        //Action.click(getDriver(),btnDeconnecter);
        return new LoginPage();
    }

}
