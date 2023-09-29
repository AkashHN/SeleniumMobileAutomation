package com.page.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChromePage {
	private final By withOutAccountBtn = By.id("com.android.chrome:id/signin_fre_dismiss_button");
	private final By notNowButton = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button[1]");
	private final By search = By.id("com.android.chrome:id/search_box_text");
	private final By searchInput = By.id("com.android.chrome:id/url_bar");

	private final By searchClick = By.id("com.android.chrome:id/line_2");
	private final AppiumDriver driver;

	public ChromePage(AppiumDriver driver) {
		this.driver = driver;
	}

	public void beforeLogin() {
		WebElement withOutBtn = driver.findElement(withOutAccountBtn);
		withOutBtn.click();
		WebElement enterBtn = driver.findElement(notNowButton);
		enterBtn.click();
		WebElement searchBtn = driver.findElement(search);
		searchBtn.click();
		WebElement searchInputBtn = driver.findElement(searchInput);
		searchInputBtn.sendKeys("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement searchClickBtn = driver.findElement(searchClick);
		searchClickBtn.click();
	}
}
