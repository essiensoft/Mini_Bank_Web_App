package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @CacheLookup
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
    WebElement inkNewCustomer;

    @CacheLookup
    @FindBy(how = How.NAME, using = "name")
    WebElement inkCustomerName;

    @CacheLookup
    @FindBy(how = How.NAME, using = "rad1")
    WebElement inkCustomerGender;

    @CacheLookup
    @FindBy(how = How.ID_OR_NAME, using = "dob")
    WebElement inkCustomerDOB;

    @CacheLookup
    @FindBy(how = How.NAME, using ="addr" )
    WebElement inkCustomerAddress;

    @CacheLookup
    @FindBy(how = How.NAME, using ="city" )
    WebElement inkCustomerCity;

    @CacheLookup
    @FindBy(how = How.NAME, using ="state" )
    WebElement inkCustomerState;

    @CacheLookup
    @FindBy(how = How.NAME, using ="pinno" )
    WebElement inkCustomerPIN;

    @CacheLookup
    @FindBy(how = How.NAME, using ="telephoneno" )
    WebElement inkCustomerTelephone;

    @CacheLookup
    @FindBy(how = How.NAME, using ="emailid" )
    WebElement inkCustomerEmail;

    @CacheLookup
    @FindBy(how = How.NAME, using ="password" )
    WebElement inkCustomerPassword;

    @CacheLookup
    @FindBy(how = How.NAME, using ="sub" )
    WebElement inkCustomerSubmit;


    public void clickAddCustomer(){
        inkNewCustomer.click();
    }

    public void CustomerName(String cname){
        inkCustomerName.sendKeys(cname);
    }

    public void CustomerGender(String gender){
        inkCustomerGender.sendKeys(gender);
    }

    public void CustomerDOB(String mm, String dd, String yyyy){
        inkCustomerDOB.sendKeys(mm);
        inkCustomerDOB.sendKeys(dd);
        inkCustomerDOB.sendKeys(yyyy);

    }
    public void CustomerAddress(String address){
        inkCustomerAddress.sendKeys(address);
    }

    public void CustomerCity(String city){
        inkCustomerCity.sendKeys(city);
    }

    public void CustomerState(String state){
        inkCustomerState.sendKeys(state);
    }
    public void CustomerPin(int pin){
        inkCustomerPIN.sendKeys(String.valueOf(pin));
    }
    public void CustomerTelephone(int telephone){
        inkCustomerTelephone.sendKeys(String.valueOf(telephone));
    }
    public void CustomerEmail(String email){
        inkCustomerEmail.sendKeys(email);
    }
    public void CustomerPassword(String password){
        inkCustomerPassword.sendKeys(password);
    }

    public void CustomerSubmit( ){
        inkCustomerSubmit.click();
    }



}
