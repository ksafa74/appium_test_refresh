package com.kasim_appium.tests;

import com.kasim_appium.pages.CalculatorPage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorPOMTest {

    CalculatorPage cp = new CalculatorPage();

    @Test
    public void multiplyTest() {


        cp.clickSingleDigit(8);
        cp.multiply.click();
        cp.clickSingleDigit(5);
        cp.equals.click();

        int actualResult = Integer.parseInt(cp.result.getText());
        int expectedResult = 40;

        assertEquals(expectedResult,actualResult);


    }
}
