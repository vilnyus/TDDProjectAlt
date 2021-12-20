package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginTests {
    BaseTest base;

    //Declare LoginPage and ProductsPage
    LoginPage loginPage;
    ProductsPage productsPage;

    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeClass
    public void beforeClass(String platformName, String platformVersion, String deviceName) throws IOException {
        base = new BaseTest();
        base.initializeDriver(platformName, platformVersion, deviceName);
    }

    @AfterClass
    public void afterClass() {
        base.quitDriver();
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        loginPage = new LoginPage();
        //Printing name of function run the method
        System.out.println("\n" + "******** ******** ******** starting method " + m.getName() + "******** ******** ********");
    }

    //Test for invalid username login
    @Test
    public void invalidUsernameTest() {
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword("secret_sauce");
        loginPage.pressLoginButton();

        String actualErrText = loginPage.getErrorText();
        String expectedErrText = "Username and password do not match any user in this service.";
        System.out.println("actual error message is: " + actualErrText + "\n" + "expected error message is: " + expectedErrText);

        Assert.assertEquals(expectedErrText, actualErrText);
    }

    //Test for invalid password login
    @Test
    public void invalidPasswordTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("invalidPassword");
        loginPage.pressLoginButton();

        String actualErrText = loginPage.getErrorText();
        String expectedErrText = "Username and password do not match any user in this service.";
        System.out.println("actual error message is: " + actualErrText + "\n" + "expected error message is: " + expectedErrText);

        Assert.assertEquals(expectedErrText, actualErrText);
    }

    //Tets for successful login
    @Test
    public void successfulnessTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        productsPage = loginPage.pressLoginButton();

        String actualProductsTitle = productsPage.getTitle();
        String expectedProductsTitle = "PRODUCTS";
        System.out.println("actual page title is: " + actualProductsTitle + "\n" + "expected page title is: " + expectedProductsTitle);

        Assert.assertEquals(expectedProductsTitle, actualProductsTitle);
    }

}
