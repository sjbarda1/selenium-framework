package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }


    /*
    Makes sure the webelement is not stale, it is accessible
     */
    public WebElement GetFreshElementByWebElement(WebElement webEl, int waitInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30 );
        return  wait.until(ExpectedConditions.elementToBeClickable(webEl));
    }


    /*
    Makes sure the webelement is present on the page
     */
    public boolean IsElementPresentByWebElement(WebElement webEl, int waitInSeconds)  // was - by locator
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(webEl)); // ElementIsVisible()
            return true;
        }
        catch (TimeoutException e)
        {
            System.out.println("Printing e.getMessage: " + e.getMessage());
            return false;
        }
    }


    /*
    Enters the webelement into a field
     */
    public void EnterElementValueByWebElement(WebElement webEl, String textToEnter, int waitInSeconds)
    {
        try
        {
            WebElement el = GetFreshElementByWebElement(webEl, waitInSeconds);
            el.clear();
            el.sendKeys(textToEnter);
        }
        catch (TimeoutException e)
        {
            System.out.println("Printing e.getMessage: " + e.getMessage());
        }
    }
}

