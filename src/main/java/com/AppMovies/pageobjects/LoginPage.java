package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Action {
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


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Empty() {
        Action.click(driver,login);
    }

    public boolean logintextIsDisplayed(){
        return Action.isDisplayed(driver,loginText);
    }

    public void login(String uname, String pass) throws InterruptedException {
        Action.type(userName, uname);
        Action.type(password, pass);
        Action.click(driver, login);
        Thread.sleep(100);
    }

    public String getCurrURL(){
        return Action.getCurrentURL(driver);
    }

    public void goToRegister(){
        Action.click(driver,toRegister);
    }



}
