package com.AppMovies.pageobjects;

import com.AppMovies.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends Action {

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

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    public boolean registerTextIsDisplayed(){
        return Action.isDisplayed(driver,registerText);
    }

    public void register(String uname, String mail, String pass, String confirmPass) {
        Action.type(userName,uname);
        Action.type(email,mail);
        Action.type(password,pass);
        Action.type(confirmPassword,confirmPass);
    }

    public void clickOnSignup() throws InterruptedException {
        Action.click(driver,signup);
        Thread.sleep(100);
    }

    public void verifyMessageAlert(){
        driver.switchTo().alert().accept();
        //return driver.switchTo().alert().getText();
    }

    public void goToLogin(){
        Action.click(driver,gotoLogin);
    }

}