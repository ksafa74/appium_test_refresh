package com.kasim_appium.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class CalculatorOperationsTest {

    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {

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
        driver = new AndroidDriver<MobileElement>(url, caps);

    }
    /**
     * 4 + 5 = 9
     */

    @Test
    public void test1Add() {

        MobileElement four = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_4"));
        MobileElement five = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_5"));
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));

        four.click();
        plus.click();
        five.click();
        equals.click();
        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        int actualResult = Integer.parseInt(result.getText());
        int expectedResult = 9;

        Assertions.assertEquals(expectedResult,actualResult);

    }

    /**
     * 15 / 5 = 3
     */

    @Test
    public void test2Divide() {

        MobileElement one = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_1"));
        MobileElement five = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_5"));
        MobileElement divideBy = driver.findElement(MobileBy.AccessibilityId("divide"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));

        one.click();
        five.click();
        divideBy.click();
        five.click();
        equals.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        int actualResult = Integer.parseInt(result.getText());
        int expectedResult = 3;

        Assertions.assertEquals(expectedResult,actualResult);


    }







    @AfterEach
    public void tearDown(){

        driver.closeApp();




    }
}
