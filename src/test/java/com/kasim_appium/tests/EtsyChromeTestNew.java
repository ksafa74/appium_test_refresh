package com.kasim_appium.tests;

import com.kasim_appium.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyChromeTestNew extends WebTestBase {

    @Test
    public void etsyTest(){
        driver.get("https://www.etsy.com");

        driver.findElement(By.name("search_query")).sendKeys("Wooden Spoon"+ Keys.ENTER);

        String text = driver.findElement(By.xpath("//span[contains(text(),'results,')]")).getText();



        System.out.println("text = " + text);
    }

    @Test
    public void etsyLogin() throws InterruptedException {

        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");

        driver.get("https://www.etsy.com");

        driver.findElement(By.xpath("//a[contains(normalize-space(),'Sign in')]")).click();

        driver.findElement(By.id("join_neu_email_field")).sendKeys(email+Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.id("join_neu_password_field")).sendKeys(password);

        driver.findElement(By.xpath("//button[contains(normalize-space(),'Sign in')]")).click();

        Thread.sleep(5000);





    }
}
