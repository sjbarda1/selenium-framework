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

public class ContentTests extends BaseTest {

    private HomePageObject wpHomePg;
    private LoginPageObject wploginPg;
    private DashPageObject wpDashPg;


    /*
    Gets the driver and it's URL from the BaseTest
     */
    @BeforeClass
    public void setUp()
    {
        driver = getDriver();
        wpHomePg = new HomePageObject(driver);
        wploginPg = new LoginPageObject(driver);
        wpDashPg = new DashPageObject(driver);
    }


    @Test
    public void logInUserSuccessfullyFromArticle()
    {
        try
        {
            wpHomePg.clickLogInLink();
            wploginPg.EnterUserName("sjbarda");
            wploginPg.EnterPassword("!Se@Meetup");
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


}

