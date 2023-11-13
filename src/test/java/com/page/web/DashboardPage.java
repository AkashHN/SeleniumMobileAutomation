package com.page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class DashboardPage {

    private final By titleDashboard = By.xpath("(//android.widget.TextView[@class=\"android.widget.TextView\"])[2]");
    private final By timeButton = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[3]/android.view.View[1]/android.widget.Button");
    private final By logOutProfile = By.xpath("(//android.widget.Image[@class=\"android.widget.Image\"])[1]");
    private final By logOutButton = By.xpath("(//android.view.MenuItem[@class=\"android.view.MenuItem\"])[4]");
    private final By dashBoardButton = By.xpath("(//android.widget.TextView)[1]");
    private final By AdminPannel = By.xpath("//android.view.View[@content-desc=\"Admin\"]");
    private final By Buzz = By.xpath("//android.view.View[@content-desc=\"Buzz\"]");
    private final By shareTheThoughts = By.xpath("(//android.widget.EditText)[1]");
    private final By Post = By.xpath("(//android.widget.Button)[2]");
    private final AppiumDriver driver;

    public DashboardPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement getTile() {
        WebElement title = driver.findElement(titleDashboard);
        return title;
    }

    public void timeButtonClick() {
        WebElement timeBtn = driver.findElement(timeButton);
        timeBtn.click();
    }

    public void hrmLogOut() {
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement viewProfileBtn = driver.findElement(logOutProfile);
        viewProfileBtn.click();
        WebElement logOutBtn = driver.findElement(logOutButton);
        logOutBtn.click();
    }
    public void dashboardOpen(){
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement menuBarBtn = driver.findElement(dashBoardButton);
        Assert.assertTrue(menuBarBtn.isDisplayed(), "Element is not displayed on the page.");
        menuBarBtn.click();
    }

    public void adminOperations() {
        dashboardOpen();
        WebElement adminSelect = driver.findElement(AdminPannel);
        Assert.assertTrue(adminSelect.isDisplayed(), "Element is not displayed on the page.");
        adminSelect.click();
    }

    public void buzzOperations(String usermind){
        dashboardOpen();
        WebElement BuzzBtn=driver.findElement(Buzz);
        BuzzBtn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement ShareThoughts=driver.findElement(shareTheThoughts);
        ShareThoughts.sendKeys(usermind);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement ShareThoughtsOfMind=driver.findElement(shareTheThoughts);
        ShareThoughtsOfMind.sendKeys(usermind);
        WebElement PostBtn=driver.findElement(Post);
        PostBtn.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
