package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

import static java.sql.DriverManager.getDriver;

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

    public void Empty() throws InterruptedException {
        Action.click(getDriver(),login);
        Thread.sleep(500);
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


    public boolean alertDisplayed(String uname, String pass){
        Action.type(userName, uname);
        Action.type(password, pass);
        Action.click(getDriver(), login);
        return Action.isAlertPresent(getDriver());
    }

    public RegisterPage goToRegister(){
        Action.click(getDriver(),toRegister);
        return new RegisterPage();
    }



}