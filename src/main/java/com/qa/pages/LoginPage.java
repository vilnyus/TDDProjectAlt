package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //Application mobile elements
    @AndroidFindBy (accessibility = "test-Username") private MobileElement usernameTxtField;
    @AndroidFindBy (accessibility = "test-Password") private MobileElement passwordTxtField;
    @AndroidFindBy (accessibility = "test-LOGIN") private MobileElement loginButton;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") private MobileElement errorText;

    BaseTest base;

    public LoginPage() {
        base = new BaseTest();
        PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
    }

    //Enter username function
    public LoginPage enterUsername(String username) {
        base.sendKeys(usernameTxtField, username);
        return this;
    }

    //Enter password function
    public LoginPage enterPassword(String password) {
        base.sendKeys(passwordTxtField, password);
        return this;
    }

    //Login to Products page
    public ProductsPage pressLoginButton() {
        base.click(loginButton);
        return new ProductsPage();
    }

    //Get error text field attribute
    public String getErrorText() {
        return base.getAttribute(errorText, "text");
    }
}
