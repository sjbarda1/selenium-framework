package com.pageobjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class DashPageObject extends BasePageObject {


    public DashPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//h1")
    public  WebElement dashHeadingXpath;


    /*
    Determines if the dashboard heading text is present
     */
    public boolean IsDashboardHeadingPresent()
    {
        return IsElementPresentByWebElement(dashHeadingXpath, 5);

        /*
        String dashHeadingXpath = "//h1";
        By locator = By.xpath(dashHeadingXpath);
        return IsElementPresentByWebElement(locator, 5); */
    }


    /*
    Gets the dashboard heading and returns it to the test
     */
    public String GetDashboardHeading()
    {
        try {
            //String dashHeadingXpath = "//h1";
            //By locator = By.xpath(dashHeadingXpath);
            //WebElement el = GetFreshElementByWebElement(locator, 5);

            WebElement el = GetFreshElementByWebElement(dashHeadingXpath, 5);
            return el.getText();
            }
        catch (TimeoutException e)
        {
            StringBuilder exceptionMessage = new StringBuilder("Unable to locate the dashboard heading. ").append(e.getMessage().toString());
            return exceptionMessage.toString();
        }
    }

}

