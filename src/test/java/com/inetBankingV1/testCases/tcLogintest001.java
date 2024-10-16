package com.inetBankingV1.testCases;

import com.inetBankingV1.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tcLogintest001 extends BaseClass {

    @Test
    public void testLogin() {
        driver.get(baseUrl);
        logger.info("URL open");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name entered");
        lp.setPassword(password);

        lp.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
        }else {
            Assert.fail();
        }


    }
}
