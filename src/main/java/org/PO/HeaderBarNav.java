package org.PO;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HeaderBarNav extends BasePage {

    @FindBy(css="summary.wp-block-coblocks-accordion-item__title")
    WebElement iconAccordion;
    @FindBy(xpath="//p[normalize-space()='This is an accordion item.']")
    WebElement textFromAccordion;
    @FindBy(xpath = "//a[contains(@class,'dropdown-toggle') and .//span[normalize-space()='My account']]")
    WebElement btn_MyAccount;
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginOption;
    @FindBy(xpath = "//span[contains(text(),'Register')]")
    WebElement registerOption;
    @FindBy(css = "ul.navbar-nav.horizontal>li.nav-item")
    List<WebElement> allItemsFromHeader;

    public HeaderBarNav(WebDriver driver){
        super(driver);
    }

    public LoginPage selectOptionFromMyAccount(String nameOption){
        WebElement myAccount = waitForVisibility(btn_MyAccount);
        Actions actions = new Actions(driver);
        actions.moveToElement(btn_MyAccount).perform();
        By option = By.xpath("//span[contains(text(),'" + nameOption + "')]");
        waitForClickable(driver.findElement(option)).click();
        return new LoginPage(driver);
    }

    public String getTextFromAccordionComponent(){
        return waitForVisibility(textFromAccordion).getText();
    }

    public List<String> getAllItemsFromHeader() {
        List<String> titlesFromHeader = new ArrayList<>();
        for (WebElement item : allItemsFromHeader) {
            String text = item.getText().trim().replace("\n", " ");
            titlesFromHeader.add(text);
        }
        return titlesFromHeader;
    }

}
