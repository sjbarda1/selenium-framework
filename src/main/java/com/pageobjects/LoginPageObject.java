package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageObject{

    public LoginPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy (how = How.ID, using = "user_login")
    public  WebElement userlogin;

    @FindBy (how = How.ID, using = "user_pass")
    public WebElement userpass;

    @FindBy(how = How.ID, using = "wp-submit")
    public   WebElement loginId;

    @FindBy (how = How.XPATH, using = "//div[@id='login_error']/strong[1]")
    public WebElement errorXpath;

    /**
     * Enters the user name in it's field
     * @param userName
     */
    public void EnterUserName(String userName){

        EnterElementValueByWebElement(userlogin, userName, 5);

        /* try
        {
            WebElement el = GetFreshElementByWebElement(userlogin, 5);
            el.sendKeys(userName);
        }
        catch (TimeoutException e)
        {
            StringBuilder exceptionMessage = new StringBuilder("Unable to locate the username field. ").append(e.getMessage().toString());
            System.out.println(exceptionMessage.toString());
        }  */
    }

    /**
     * Enters the password in it's field
     * @param password
     */
    public void EnterPassword(String password){

        EnterElementValueByWebElement(userpass, password, 5);

       /* try
        {
            WebElement el = GetFreshElementByWebElement(userpass, 5);
            el.sendKeys(password);
        }
        catch (TimeoutException e)
        {
            StringBuilder exceptionMessage = new StringBuilder("Unable to locate the password field. ").append(e.getMessage().toString());
            System.out.println(exceptionMessage.toString());
        } */
    }


    /**
     *  Clicks the log in button
     */
    public void clickLogInButton()
    {
        try
        {
            //String loginBtnId = "wp-submit";
            //By locator = By.id(loginBtnId);
            //WebElement el = GetFreshElementByWebElement(locator, 5);
            //el.click();

            WebElement el = GetFreshElementByWebElement(loginId, 5);
            el.click();
        }
        catch (TimeoutException e)
        {
            StringBuilder exceptionMessage = new StringBuilder("Unable to locate the log in button. ").append(e.getMessage().toString());
            System.out.println(exceptionMessage.toString());
        }
    }


    /*
    Determines if the error message is present
     */
    public boolean IsErrorMessagePresent()
    {
        return IsElementPresentByWebElement(errorXpath, 5);

        /*
        String dashHeadingXpath = "//h1";
        By locator = By.xpath(dashHeadingXpath);
        return IsElementPresentByWebElement(locator, 5); */
    }


    /*
    Gets the error message and returns it to the test
     */
    public String GetLoginErrorMessage()
    {
        try {
            //String dashHeadingXpath = "//h1";
            //By locator = By.xpath(dashHeadingXpath);
            //WebElement el = GetFreshElementByWebElement(locator, 5);

            WebElement el = GetFreshElementByWebElement(errorXpath, 5);
            return el.getText();
        }
        catch (TimeoutException e)
        {
            StringBuilder exceptionMessage = new StringBuilder("Unable to locate the log in page error message. ").append(e.getMessage().toString());
            return exceptionMessage.toString();
        }
    }


}
