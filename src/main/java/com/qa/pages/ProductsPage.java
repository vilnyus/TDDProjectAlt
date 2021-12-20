package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    BaseTest base;

    public ProductsPage() {
        base = new BaseTest();
        PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
    }

    //Products page title mobile element
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView") private MobileElement ProductTitleText;

    //Getting Products page title
    public String getTitle() {
        return base.getAttribute(ProductTitleText, "text");
    }
}
