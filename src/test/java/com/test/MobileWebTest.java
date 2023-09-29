package com.test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.page.web.AdminPage;
import com.page.web.ChromePage;
import com.page.web.DashboardPage;
import com.page.web.HRMLoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MobileWebTest extends Base {
    private static final Logger logger = LogManager.getLogger(MobileWebTest.class);
    private HRMLoginPage loginPage;
    private ChromePage chromePage;
    private DashboardPage dashboardPage;
    private AdminPage adminPage;

    @BeforeTest
    public void beforeConditions() {
        loginPage = new HRMLoginPage(driver);
        chromePage = new ChromePage(driver);
        dashboardPage = new DashboardPage(driver);
        adminPage = new AdminPage(driver);
        chromePage.beforeLogin();
    }

    @Test(priority = 1)
    public void loginTest() {
        logger.info("loginTest has Started");
        test = extent.createTest("Login", "login testcase1").assignAuthor("karthik").assignCategory("functional Test Cases").assignDevice("Android");
        // Assertion 1
        boolean isLogoDisplayed = loginPage.getLogo().isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "logo image should be displayed");
        test.log(isLogoDisplayed ? Status.PASS : Status.FAIL, isLogoDisplayed ? "logo image is displayed" : "logo image is not displayed");
        String userName = jsonUserData.get("userName").getAsString();
        String password = jsonUserData.get("password").getAsString();
        test.log(Status.INFO, "valid details to login");
        loginPage.hrmLogin(userName, password, true);
        // Assertion 2
        test.log(Status.INFO, "Verifying if Dashboard Title is displayed");
        boolean isTileDisplayed = dashboardPage.getTile().isDisplayed();
        Assert.assertTrue(isTileDisplayed, "Dashboard Title should be displayed");
        test.log(isTileDisplayed ? Status.PASS : Status.FAIL, isTileDisplayed ? "Dashboard Title is displayed" : "Dashboard Title is not displayed");
        test.log(Status.INFO, "login is successfully done");
    }

    @Test(priority = 2)
    public void deleteEmployeeTest() {
        logger.info("deleteEmployeeTest has Started");
        test = extent.createTest("DeleteEmployee", "delete emp").assignAuthor("karthik").assignCategory("functional Test Cases").assignDevice("Android");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Assertion 1
        boolean isLogoDisplayed = loginPage.getLogo().isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "logo image should be displayed");
        test.log(isLogoDisplayed ? Status.PASS : Status.FAIL, isLogoDisplayed ? "logo image is displayed" : "logo image is not displayed");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String userName = jsonUserData.get("userName").getAsString();
        String password = jsonUserData.get("password").getAsString();
        test.log(Status.INFO, "valid details to login");
        loginPage.hrmLogin(userName, password, false);
        // Assertion 2
        test.log(Status.INFO, "Verifying if Dashboard Title is displayed");
        boolean isTileDisplayed = dashboardPage.getTile().isDisplayed();
        Assert.assertTrue(isTileDisplayed, "Dashboard Title should be displayed");
        test.log(isTileDisplayed ? Status.PASS : Status.FAIL, isTileDisplayed ? "Dashboard Title is displayed" : "Dashboard Title is not displayed");
        test.log(Status.INFO, "login is successfully done");
        test.log(Status.INFO, "succesful login click on dashBoard");
        dashboardPage.adminOperations();
        adminPage.deleteEmployee();
    }

    @Test(priority = 3)
    public void buzzBlogsTest() {
        logger.info("BuzzBlogsTest has Started");
        test = extent.createTest("Blog", "add blog").assignAuthor("Ramesh").assignCategory("functional Test Cases").assignDevice("Android");
        // Assertion 1
        boolean isLogoDisplayed = loginPage.getLogo().isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "logo image should be displayed");
        test.log(isLogoDisplayed ? Status.PASS : Status.FAIL, isLogoDisplayed ? "logo image is displayed" : "logo image is not displayed");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String userName = jsonUserData.get("userName").getAsString();
        String password = jsonUserData.get("password").getAsString();
        test.log(Status.INFO, "valid details to login");
        loginPage.hrmLogin(userName, password, false);
        // Assertion 2
        test.log(Status.INFO, "Verifying if Dashboard Title is displayed");
        boolean isTileDisplayed = dashboardPage.getTile().isDisplayed();
        Assert.assertTrue(isTileDisplayed, "Dashboard Title should be displayed");
        test.log(isTileDisplayed ? Status.PASS : Status.FAIL, isTileDisplayed ? "Dashboard Title is displayed" : "Dashboard Title is not displayed");
        test.log(Status.INFO, "login is successfully done");
        test.log(Status.INFO, "succesful login click on dashBoard");
        String UserThoughts = jsonUserData.get("thoughts").getAsString();
        dashboardPage.buzzOperations(UserThoughts);
    }

    @AfterMethod
    public void afterConditions() {
        dashboardPage.hrmLogOut();
    }

}
