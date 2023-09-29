package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class WelcomePage {

	private final By enterToAccountButton = By.xpath("//android.widget.Button[@resource-id='com.letyshops:id/login_btn']");
	private final By titleLetyshops = By.xpath("//android.widget.ImageView[@resource-id='com.letyshops:id/logo']");
	private final By logoLetyshops = By.xpath("//android.widget.ImageView[@resource-id='com.letyshops:id/image']");
	private final By welcomeText = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/title_text']");
	private final By registerButton = By.xpath("//android.widget.Button[@resource-id='com.letyshops:id/registration_btn']");
	private AppiumDriver driver;

	public WelcomePage(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getRegisterButton() {
		WebElement buttonRegister = driver.findElement(registerButton);
		return buttonRegister;
	}

	public void clickEnterToAccountButton() {
    WebElement enterBtn = driver.findElement(enterToAccountButton);
    enterBtn.click();
	}
	
	public WebElement getTitle() {
		WebElement title = driver.findElement(titleLetyshops);
		return title;
	}
	
	public WebElement getLogo() {
		WebElement  logo= driver.findElement(logoLetyshops);
		return logo;
	}
	
	public WebElement getWelcomeText() {
		WebElement  text= driver.findElement(welcomeText);
		return text;
	}
}