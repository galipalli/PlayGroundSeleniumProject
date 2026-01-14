package org.PO;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id="input-email")
    WebElement txtEmail;
    @FindBy(id="input-password")
    WebElement txtPassword;
    @FindBy(css="input[type='submit']")
    WebElement loginBtn;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public HomePage doLoginSuccess(String username, String password){
        waitForVisibility(txtEmail).sendKeys(username);
        waitForVisibility(txtPassword).sendKeys(password);
        waitForClickable(loginBtn).click();
        return new HomePage(driver);
    }

}
