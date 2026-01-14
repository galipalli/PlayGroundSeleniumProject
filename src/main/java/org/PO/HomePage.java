package org.PO;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "#cookie_action_close_header")
    WebElement modalCookies;
    @FindBy(xpath = "//a[contains(text(),'Sliders')]")
    WebElement btn_Sliders;




    public HomePage(WebDriver driver){
        super(driver);
    }


    public void selectHover(){
        //btn_Hover.click();
    }

    public void selectAds(){
       // waitForClickable(btn_Ads).click();

    }

    public void selectGestures(){
       //waitForClickable(btn_Gestures).click();

    }







}


