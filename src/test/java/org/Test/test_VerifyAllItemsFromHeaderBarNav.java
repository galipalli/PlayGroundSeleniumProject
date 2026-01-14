package org.Test;

import Base.TestBase;
import org.PO.HeaderBarNav;
import org.PO.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class test_VerifyAllItemsFromHeaderBarNav extends TestBase {

    MyAccountPage map;
    HeaderBarNav hbn;

    @Test
    public void verifyAllItemsFromHeaderBarNav() throws InterruptedException, IOException {

        hbn = new HeaderBarNav(driver);
        List<String> headerTitles  = hbn.getAllItemsFromHeader();
        Assert.assertEquals(headerTitles.size(), 6, "La cantidad de items en el Header no coincide");
        List<String> expectedHeadersTitles = Arrays.asList("Home","Special Hot","Blog","Mega Menu","AddOns Featured","My account");
        // Verificar que todos los títulos coinciden en orden
        Assert.assertEquals(headerTitles,  expectedHeadersTitles);
        Thread.sleep(1000);

    }
}
