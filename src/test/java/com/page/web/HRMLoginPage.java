package com.page.web;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class HRMLoginPage{
    private static final Logger logger = LogManager.getLogger(HRMLoginPage.class);
    private final By loginHeadingImg = By.xpath("(//android.widget.Image[@class=\"android.widget.Image\"])[2]");
    private final By usernameField = By.xpath("(//android.widget.EditText[@class=\"android.widget.EditText\"])[1]");
    private final By passwordField = By.xpath("(//android.widget.EditText[@class=\"android.widget.EditText\"])[2]");
    private final By loginButton = By.xpath("//*[@class=\"android.widget.Button\"]");
    private final By invalidCredentials = By.xpath("(//android.widget.TextView[@class=\"android.widget.TextView\"])[3]");
    private final By neverSavePassword=By.id("com.android.chrome:id/message_secondary_button");
	private final By neverForSite=By.xpath("//android.widget.TextView[@content-desc=\"Never save passwords for this site\"]");
    private final AppiumDriver driver;
   
    public HRMLoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void hrmLogin(String username, String password,boolean popUpDisable) {
        WebElement usernameInput = driver.findElement(usernameField);
        Assert.assertTrue(usernameInput.isDisplayed(), "Element is not displayed on the page.");
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordField);
        Assert.assertTrue(passwordInput.isDisplayed(), "Element is not displayed on the page.");
        passwordInput.sendKeys(password);
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        if(popUpDisable) {
            WebElement neverSavePasswordBtn=driver.findElement(neverSavePassword);
            neverSavePasswordBtn.click();
            WebElement neverForSiteBtn=driver.findElement(neverForSite);
            neverForSiteBtn.click();}
    }

    public void hrmInValidLogin(String username, String password,boolean popUpDisable){
        WebElement usernameInput = driver.findElement(usernameField);
        Assert.assertTrue(usernameInput.isDisplayed(), "Element is not displayed on the page.");
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordField);
        Assert.assertTrue(passwordInput.isDisplayed(), "Element is not displayed on the page.");
        passwordInput.sendKeys(password);
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        if(popUpDisable) {
        WebElement neverSavePasswordBtn=driver.findElement(neverSavePassword);
		neverSavePasswordBtn.click();
		WebElement neverForSiteBtn=driver.findElement(neverForSite);
		neverForSiteBtn.click();}
        WebElement invalidCredentialsCheck = driver.findElement(invalidCredentials);
        Assert.assertTrue(invalidCredentialsCheck.isDisplayed(), "Header is not visible in next page");
        
    }
    public WebElement getLogo() {
    	WebElement loginHeadingVisible=driver.findElement(loginHeadingImg);
    	return loginHeadingVisible;
	}
}
