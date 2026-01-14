package org.Test;

import Base.TestBase;
import Utilities.JsonDataReader;
import org.PO.HeaderBarNav;
import org.PO.HomePage;
import org.PO.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;


public class test_doLogin extends TestBase {

    HeaderBarNav hbn;
    LoginPage lp;

    @Test
    public void doLoginSection() throws InterruptedException, IOException {

        hbn = new HeaderBarNav(driver);
        lp = hbn.selectOptionFromMyAccount("Login");
        String jsonPath = System.getProperty("user.dir") + "/src/test/resources/testData/user.json";
        JsonDataReader data = new JsonDataReader(jsonPath);
        String username = data.getUsername(0);
        String password = data.getPassword(0);
        lp.doLoginSuccess(username, password);
        Thread.sleep(6000);

    }
}
