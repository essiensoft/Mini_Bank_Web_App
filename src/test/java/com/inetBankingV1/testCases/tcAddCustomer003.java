package com.inetBankingV1.testCases;

import com.inetBankingV1.pageObjects.AddCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class tcAddCustomer003 extends BaseClass{
    @Test
    public void AddCustomer() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name entered");
        lp.setPassword(password);
        logger.info("User name entered");
        lp.clickSubmit();

        Thread.sleep(3000);
        logger.info("Providing user details");
        AddCustomerPage  addCust = new AddCustomerPage(driver);
        addCust.clickAddCustomer();
        addCust.CustomerName("Felix");
        addCust.CustomerGender("Male");
        addCust.CustomerDOB("10", "22", "2024");
        Thread.sleep(5000);
        addCust.CustomerAddress("Accra Street");
        addCust.CustomerCity("London");
        addCust.CustomerState("NY");
        Thread.sleep(3000);
        addCust.CustomerPin(3232342);
        addCust.CustomerTelephone(123456789);

        String email = randomString()+"@gmail.com";
        addCust.CustomerEmail(email);
        addCust.CustomerPassword("123456");

        addCust.CustomerSubmit();

        boolean result = driver.getPageSource().contains("Customer Registered Successfully");

        if(result==true){
            captureScreen(driver, "AddCustomerSuccess");
            Assert.assertTrue(true);
        }else
        {
            captureScreen(driver, "AddCustomerFail");
            Assert.assertTrue(false);
        }

    }

//    public String randomPass(){
//        return RandomStringUtils.randomAlphanumeric(10);
//
//    }

//    method to generate random emails
    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphanumeric(8);
        return generatedString;
    }
}
