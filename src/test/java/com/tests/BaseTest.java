package com.tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest {

    protected WebDriver driver;


    /*
    Returns the driver to the test
     */
    public WebDriver getDriver()
    {
        return driver;
    }


    /*
    Creates the Firefox driver
     */
    public void setUpDriver(String appURL)
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
    }


    /*
    Initializes the driver and grabs the URL from the TestNG.xml
     */
    @Parameters({ "appURL" })
    @BeforeClass
    public void initBaseTest(String appURL)
    {
        try {
            setUpDriver(appURL);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Simply printing the Exception e: "  + e);
            System.out.println("Printing e.getStackTrace: " + e.getStackTrace());
            System.out.println("Printing e.getMessage: " + e.getMessage());
        }
    }


    /*
    Quits the driver to cleanly stop the test
     */
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
