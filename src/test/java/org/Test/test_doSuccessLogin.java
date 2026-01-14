package org.Test;

import Base.TestBase;
import org.PO.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class test_doSuccessLogin extends TestBase {

    MyAccountPage map;
    @Test
    public void doSuccessLogin() throws InterruptedException, IOException {

        map = loginAsDefaultUser();
        Assert.assertEquals(map.getMyAccountTitle(), "My Account");
        Thread.sleep(6000);

    }
}
