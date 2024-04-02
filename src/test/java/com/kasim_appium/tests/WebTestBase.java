package com.kasim_appium.tests;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class WebTestBase {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {


        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(PLATFORM_NAME, Platform.ANDROID);
        caps.setCapability(PLATFORM_VERSION,"10.0");
        caps.setCapability(DEVICE_NAME,"Pixel 3");
        caps.setCapability(BROWSER_NAME,"Chrome");

        URL url = new URL("http://localhost:4723/wd/hub");

        driver = new RemoteWebDriver(url,caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    @AfterEach
    public void tearDown(){
        driver.quit();

    }
}
