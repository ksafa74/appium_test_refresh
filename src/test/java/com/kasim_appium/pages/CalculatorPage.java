package com.kasim_appium.pages;

import com.kasim_appium.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public CalculatorPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);

    }

    @AndroidFindBy(accessibility = "multiply")
    public MobileElement multiply;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public MobileElement result;

    @AndroidFindBy(accessibility = "equals")
    public MobileElement equals;


    public void clickSingleDigit(int num){

        MobileElement numElement = Driver.getDriver().findElement(MobileBy.id("com.google.android.calculator:id/digit_" + num));
        numElement.click();
    }

}
