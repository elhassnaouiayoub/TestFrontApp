package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import com.AppMovies.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.AppMovies.base.Base.getDriver;

public class RegisterPage {

    @FindBy (id = "username")
    WebElement userName;

    @FindBy (id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "confirmpassword")
    WebElement confirmPassword;

    @FindBy(id = "signup")
    WebElement signup;

    @FindBy(id = "gotologin")
    WebElement gotoLogin;

    @FindBy(id = "createaccount")
    WebElement registerText;

    public RegisterPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean registerTextIsDisplayed(){
        return Action.isDisplayed(getDriver(),registerText);
    }

    public LoginPage register(String uname, String mail, String pass, String confirmPass) throws InterruptedException {
        Action.type(userName,uname);
        Action.type(email,mail);
        Action.type(password,pass);
        Action.type(confirmPassword,confirmPass);
        Action.click(getDriver(),signup);
        Thread.sleep(1000);
        return new LoginPage();
    }

    public LoginPage goToLogin(){
        Action.click(getDriver(),gotoLogin);
        return new LoginPage();
    }
}
