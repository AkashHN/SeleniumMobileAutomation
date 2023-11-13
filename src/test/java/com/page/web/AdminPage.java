package com.page.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AdminPage {
    private final AppiumDriver driver;
    private final By editEmpBtn = By.xpath("(//android.widget.Button[@class=\"android.widget.Button\"])[5]");
    private final By editNameFeild = By.xpath("(//android.widget.EditText[@class=\"android.widget.EditText\"])[1]");
    private final By deleteEmployeeFirst = By.xpath("(//android.widget.Button[@class=\"android.widget.Button\"])[4]");
    private final By errorPopup = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView[1]");
    private final By notDeleteBtn = By.xpath("(//android.widget.Button[@class=\"android.widget.Button\"])[11]");
//    private final By DeleteBtnConfirm = By.xpath("(//android.widget.Button[@class=\"android.widget.Button\"])[12]");
    private final By confirmPopup = By.xpath("(//android.view.View[@class=\"android.view.View\"])[34]");
    
public AdminPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public void deleteEmployee() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement deleteEmpFirst = driver.findElement(deleteEmployeeFirst);
        Assert.assertTrue(deleteEmpFirst.isDisplayed(), "Element is not displayed on the page.");
        deleteEmpFirst.click();
        if (driver.findElement(confirmPopup).isDisplayed()) {
            WebElement notDeleteConfirmBtn = driver.findElement(notDeleteBtn);
            notDeleteConfirmBtn.click();
        } else {
            WebElement errorPopUpCheck = driver.findElement(errorPopup);
            Assert.assertTrue(errorPopUpCheck.isDisplayed(), "error is displayed");
        }
    }

    public void editEmployee(String name) {
        WebElement editEmpButton = driver.findElement(editEmpBtn);
        editEmpButton.click();
        WebElement editEmpNameInput = driver.findElement(editNameFeild);
        editEmpNameInput.sendKeys(name);

    }
}
