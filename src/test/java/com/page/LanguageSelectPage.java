package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class LanguageSelectPage {
	
	private final By languageRadioButton = By.xpath("//android.widget.RadioButton[@resource-id='com.letyshops:id/radio_button']");
	private final By selectLanguageHeading = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/tv_choose_country_title']");
	private final By applyButton = By.xpath("//android.widget.Button[@resource-id='com.letyshops:id/btn_apply']");
	private AppiumDriver driver;
	
	public LanguageSelectPage(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void clickSelectLanguage() {
		WebElement selectButton = driver.findElement(languageRadioButton);
		selectButton.click();
	}
	
	public WebElement getHeading() {
		WebElement headingElement = driver.findElement(selectLanguageHeading);
		return headingElement;
	}
	
	public void clickApplyButton() {
		WebElement applyElement = driver.findElement(applyButton);
		applyElement.click();
	}
}
