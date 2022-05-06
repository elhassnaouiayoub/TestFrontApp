package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  extends Base {
    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(xpath = "//a[@id='toRegister']")
    WebElement toRegister;

    @FindBy(id = "logintext")
    WebElement loginText;


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void Empty() {
        Action.click(getDriver(),login);
    }

    public boolean logintextIsDisplayed(){
        return Action.isDisplayed(getDriver(),loginText);
    }

    public MoviesPage login(String uname, String pass) throws InterruptedException {
        Action.type(userName, uname);
        Action.type(password, pass);
        Action.click(getDriver(), login);
        Thread.sleep(500);
        return new MoviesPage();
    }


    public String getCurrURL(){
        return Action.getCurrentURL(getDriver());
    }

    public RegisterPage goToRegister(){
        Action.click(getDriver(),toRegister);
        return new RegisterPage();
    }



}
