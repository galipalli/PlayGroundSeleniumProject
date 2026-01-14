package org.PO;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightSideBarNav extends BasePage {
    @FindBy(css="summary.wp-block-coblocks-accordion-item__title")
    WebElement iconAccordion;


    public RightSideBarNav(WebDriver driver){
        super(driver);
    }
}
