package com.kasim_appium.tests;

import com.kasim_appium.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class Calculator {

    @Test
    public void calculatorAdd() throws MalformedURLException, InterruptedException {

        // desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Pixel 3");
        //caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel3");

        caps.setCapability(PLATFORM_NAME, "Android");
        caps.setCapability(PLATFORM_VERSION, "10.0");
        caps.setCapability(APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        // set URL appium server

        URL url = new URL("http://localhost:4723/wd/hub");

        // launch appium
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);

        //System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());

        Assertions.assertEquals("android",driver.getPlatformName());

        MobileElement clearElement = driver.findElement(MobileBy.AccessibilityId("clear"));

        driver.findElement(MobileBy.AccessibilityId("No formula"));

        System.out.println("clearElement.getText() = " + clearElement.getText());

        Assertions.assertTrue(clearElement.isDisplayed());

        // close app

        Thread.sleep(4000);

        driver.closeApp();


    }

    @Test
    public void test2() throws MalformedURLException {


        // desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Pixel 3");
        //caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel3");

        caps.setCapability(PLATFORM_NAME, "Android");
        caps.setCapability(PLATFORM_VERSION, "10.0");
        caps.setCapability(APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        // set URL appium server

        URL url = new URL("http://localhost:4723/wd/hub");

        // launch appium
        AppiumDriver driver = new AndroidDriver(url, caps);
        WebElement el1 = Driver.getDriver().findElementById("com.google.android.calculator:id/digit_9");
        el1.click();
        WebElement el2 = Driver.getDriver().findElementByAccessibilityId("plus");
        el2.click();
        WebElement el3 = Driver.getDriver().findElementById("com.google.android.calculator:id/digit_6");
        el3.click();

    }
}
