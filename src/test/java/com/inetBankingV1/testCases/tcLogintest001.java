package com.inetBankingV1.testCases;

import com.inetBankingV1.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class tcLogintest001 extends BaseClass {

    @Test
    public void testLogin() throws IOException {
        driver.get(baseUrl);
        logger.info("URL open");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name entered");
        lp.setPassword(password);

        lp.clickSubmit();

        if (driver.getTitle().equals("Guru99 Baank Manager HomePage")){
            Assert.assertTrue(true);
        }else {
           captureScreen(driver, "testLogin");
            Assert.fail();
        }


    }
}
