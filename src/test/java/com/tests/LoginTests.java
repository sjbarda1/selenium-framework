package com.tests;

import com.pageobjects.DashPageObject;
import com.pageobjects.HomePageObject;
import com.pageobjects.LoginPageObject;
import com.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private HomePageObject wpHomePg;
    private LoginPageObject wploginPg;
    private DashPageObject wpDashPg;

    @BeforeClass
    public void setUp()
    {
            driver = getDriver();
            wpHomePg = new HomePageObject(driver);
            wploginPg = new LoginPageObject(driver);
            wpDashPg = new DashPageObject(driver);
    }


    @Test
    public void logInUserSuccessfully()
    {
        try
        {
            wpHomePg.clickLogInLink();
            wploginPg.EnterUserName("");
            wploginPg.EnterPassword("");
            wploginPg.clickLogInButton();

            String expectedPageHeading = "Dashboard";
            Assert.assertTrue(wpDashPg.IsDashboardHeadingPresent(), "Expected the dash heading to be present");
            String actualPageHeading = wpDashPg.GetDashboardHeading();
            Assert.assertEquals(expectedPageHeading, actualPageHeading);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void logInUserError()
    {
        try
        {
            wpHomePg.clickLogInLink();
            wploginPg.EnterUserName("");
            wploginPg.EnterPassword("");
            wploginPg.clickLogInButton();

            String expectedLoginErrorMessage = "ERROR";
            Assert.assertTrue(wpDashPg.IsDashboardHeadingPresent(), "Expected the log in error message to be present");
            String actualLoginErrorMessage = wploginPg.GetLoginErrorMessage();
            Assert.assertEquals(expectedLoginErrorMessage, actualLoginErrorMessage);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



}
