package org.sayem.webdriver.basics.webdriver.examples;

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AndroidDriverTest {

    private AppiumDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // Create a new instance of the Android driver
//		driver = new AndroidDriver();
        driver.get("http://dl.dropbox.com/u/55228056/mobilebmicalculator.html");
    }

    @Test
    public void testBMICalculator() throws Exception {
        try {
            WebElement height = driver.findElement(By.name("heightCMS"));
            height.sendKeys("181");

            WebElement weight = driver.findElement(By.name("weightKg"));
            weight.sendKeys("80");

            WebElement calculateButton = driver.findElement(By.id("Calculate"));
            calculateButton.click();

            WebElement bmi = driver.findElement(By.name("bmi"));
            assertEquals("24.4", bmi.getAttribute("value"));

            WebElement bmi_category = driver.findElement(By.name("bmi_category"));
            assertEquals("Normal", bmi_category.getAttribute("value"));

        } catch (Error e) {
            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        // Close the browser
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
