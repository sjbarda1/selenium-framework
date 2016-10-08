package com.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageObject {

    public HomePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.LINK_TEXT, using = "Log in")
    public  WebElement loginLinkText;


    /**
     *  Clicks the log in link on the home page
     */
    public void clickLogInLink()
    {
        try
        {
            //String loginLinkText = "Log in";
            //By locator = By.linkText(loginLinkText);
            //WebElement el = GetFreshElementByWebElement(locator, 5);
            //el.click();
            WebElement el = GetFreshElementByWebElement(loginLinkText, 5);
            el.click();

        }
        catch (TimeoutException e)
        {
            StringBuilder exceptionMessage = new StringBuilder("Unable to locate the log in link. ").append(e.getMessage().toString());
            System.out.println(exceptionMessage.toString());
        }
    }

}



