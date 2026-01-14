package org.PO;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath="//h2[contains(text(),'My Account')]")
    WebElement myAccountTitle;


    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    public String getMyAccountTitle(){
        return myAccountTitle.getText();
    }

}
