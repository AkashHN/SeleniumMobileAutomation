package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.page.AccountPage;
import com.page.GoToStorePage;
import com.page.HomePage;
import com.page.LanguageSelectPage;
import com.page.LoginPage;
import com.page.WelcomePage;

public class LetyShopsTest extends Base {

	private LoginPage loginPage;
	private WelcomePage welcomePage;
	private LanguageSelectPage languageSelectPage;
	private HomePage homePage;
	private GoToStorePage goToStorePage;
	private AccountPage accountPage;
	private static final Logger logger = LogManager.getLogger(LetyShopsTest.class);

	@BeforeTest
	public void setUpTest() throws Exception {
		loginPage = new LoginPage(driver);
		welcomePage = new WelcomePage(driver);
		languageSelectPage = new LanguageSelectPage(driver);
		homePage = new HomePage(driver);
		goToStorePage = new GoToStorePage(driver);
		accountPage = new AccountPage(driver);
	}

	/**
	 * This test case is implemented with the the Assertion for welcome page Then
	 * click event for logIn page with
	 */
	@Test(priority = 1)
	public void welcomePage() {
		try {
			logger.info("Welcome Page Test Started");
			test = extent.createTest("Welcome page Test").assignAuthor("Renuka").assignDevice("Android");
			// Assertion 1
			test.log(Status.INFO, "Verifying if letyshops is displayed");
			boolean isTitleDisplayed = welcomePage.getTitle().isDisplayed();
			Assert.assertTrue(isTitleDisplayed, "letyshops should be displayed");
			test.log(isTitleDisplayed ? Status.PASS : Status.FAIL,
					isTitleDisplayed ? "letyshops is displayed" : "letyshops is not displayed");
			// Assertion 2
			test.log(Status.INFO, "Verifying if LettyShops logo is displayed");
			boolean isLogoDisplayed = welcomePage.getLogo().isDisplayed();
			Assert.assertTrue(isLogoDisplayed, "LettyShops logo should be displayed");
			test.log(isLogoDisplayed ? Status.PASS : Status.FAIL,
					isLogoDisplayed ? "LettyShops logo is displayed" : "LettyShops logo is not displayed");
			// Assertion 3
			test.log(Status.INFO, "Verifying if Welcome Text is displayed as expected");
			String welcomeMessage = welcomePage.getWelcomeText().getText().replaceAll("\\s+", " ").trim();
			String expectedMessage = jsonUserData.get("welcomePageHeadingMsg").getAsString();
			boolean isMessageDisplayed = welcomeMessage.equals(expectedMessage);
			Assert.assertEquals(welcomeMessage, expectedMessage, "Welcome Message is displayed as expected");
			test.log(isMessageDisplayed ? Status.PASS : Status.FAIL,
					isMessageDisplayed ? "Welcome Message is displayed as expected"
							: "Welcome Message is not displayed as expected");
			// Assertion 4
			test.log(Status.INFO, "Verifying if Register button is displayed");
			boolean isButtonDisplayed = welcomePage.getRegisterButton().isDisplayed();
			Assert.assertTrue(isButtonDisplayed, "Register button should be displayed");
			test.log(isTitleDisplayed ? Status.PASS : Status.FAIL,
					isTitleDisplayed ? "Register button is displayed" : "Register button is not displayed");
			welcomePage.clickEnterToAccountButton();
			logger.info("Welcome Page Test Ended");
		} catch (Exception e) {
			logger.info("Welcome Page failed : " + e.getMessage());
		}
	}

	/**
	 * This test case is Implemented with the logIn page Using the correct user
	 * credentials(userName & Password) for the successful logIn
	 */
	@Test(priority = 2)
	public void loginWithoutCredentials() {
		logger.info("LogIn Page Test without credentials Started");
		try {
			test = extent.createTest("LogIn Page Test without Credentials").assignAuthor("Renuka").assignDevice("Android");
			String errorMessage = jsonUserData.get("textInputError").getAsString();
			loginPage.clickLoginButton();
			test.log(Status.PASS, "Clicking login button without entering credentials");
			String textError = loginPage.getErrorMessage().getText().replaceAll("\\s+", " ").trim();
			boolean isMessageDisplayed = textError.equals(errorMessage);
			Assert.assertEquals(textError, errorMessage, "Error Message is displayed as expected");
			test.log(isMessageDisplayed ? Status.PASS : Status.FAIL,
					isMessageDisplayed ? "Error Message is displayed as expected"
							: "Error Message is not displayed as expected");
			logger.info("LogIn Page Test Ended");
		} catch (Exception e) {
			logger.info("Test Page failed : " + e.getMessage());
		}
	}
	
	@Test(priority = 3)
	public void validateForgotPassword() {
		logger.info("validating forgot password");
		try {
			test = extent.createTest("Forgot password validation").assignAuthor("Renuka").assignDevice("Android");
			String forgotPassword = jsonUserData.get("textForgotPassword").getAsString();
			String textElement = loginPage.getForgotPassword().getText().replaceAll("\\s+", " ").trim();
			boolean isMessageDisplayed = textElement.equals(forgotPassword);
			Assert.assertEquals(textElement, forgotPassword, "Forgot Password text is displayed as expected");
			test.log(isMessageDisplayed ? Status.PASS : Status.FAIL,
					isMessageDisplayed ? "Forgot Password text is displayed as expected"
							: "Forgot Password text is not displayed as expected");
			loginPage.clickForgotPassword();
			boolean isTitleDisplayed = loginPage.getTitlePasswordRecovery().isDisplayed();
			Assert.assertTrue(isTitleDisplayed, "Password recovery title should be displayed");
			test.log(isTitleDisplayed ? Status.PASS : Status.FAIL,
					isTitleDisplayed ? "Password recovery title is displayed" : "Password recovery title is not displayed");
			loginPage.clickNavigateButton();
			logger.info("validating forgot password Ended");
		} catch (Exception e) {
			logger.info("Test Page failed : " + e.getMessage());
		}
	}
//	
//	@Test(priority = 4)
//	public void invalidLoginWithIncorrectPassword() {
//		logger.info("LogIn Page Test with invalid password Started");
//		try {
//			test = extent.createTest("LogIn Page Test with invalid password").assignAuthor("Renuka").assignDevice("Android");
//			String userName = jsonUserData.get("correctUserName").getAsString();
//			String password = jsonUserData.get("inValidPassword").getAsString();
////			welcomePage.clickEnterToAccountButton();
//			loginPage.enterLoginCredentials(userName, password);
//			test.log(Status.PASS, "Entering invalid login credentials with incorrect password ");
//			test.log(Status.PASS, "Clicking login button");
//			test.log(Status.INFO, "Verifying if user logged into the account");
//			boolean isButtonDisplayed = loginPage.getLogInTitle().isDisplayed();
//			Assert.assertTrue(isButtonDisplayed, "Login button is displayed");
//			test.log(isButtonDisplayed ? Status.PASS : Status.FAIL,
//					isButtonDisplayed ? "Invalid login with incorrect password" : "valid login");
////			loginPage.clickNavigateButton();
//			logger.info("LogIn Page Test with invalid password Ended");
//		} catch (Exception e) {
//			logger.info("Test Page failed : " + e.getMessage());
//		}
//	}
//	
//	@Test(priority = 5)
//	public void invalidLoginWithIncorrectUsername() {
//		logger.info("LogIn Page Test with invalid username Started");
//		try {
//			test = extent.createTest("LogIn Page Test with invalid username").assignAuthor("Renuka").assignDevice("Android");
//			String userName = jsonUserData.get("inValidUserName").getAsString();
//			String password = jsonUserData.get("correctPassword").getAsString();
////			welcomePage.clickEnterToAccountButton();
//			loginPage.enterLoginCredentials(userName, password);
//			test.log(Status.PASS, "Entering invalid login credentials with incorrect username ");
//			test.log(Status.PASS, "Clicking login button");
//			test.log(Status.INFO, "Verifying if user logged into the account");
//			boolean isButtonDisplayed = loginPage.getLogInTitle().isDisplayed();
//			Assert.assertTrue(isButtonDisplayed, "Login button is displayed");
//			test.log(isButtonDisplayed ? Status.PASS : Status.FAIL,
//					isButtonDisplayed ? "Invalid login with incorrect username" : "valid login");
////			loginPage.clickNavigateButton();
//			logger.info("LogIn Page Test with invalid username Ended");
//		} catch (Exception e) {
//			logger.info("Test Page failed : " + e.getMessage());
//		}
//	}
	
	/**
	 * This test case is Implemented with the logIn page Using the correct user
	 * credentials(userName & Password) for the successful logIn
	 */
	@Test(priority = 6)
	public void testLoginWithValidCredentials() {
		logger.info("LogIn Page Test with valid  Started");
		try {
			test = extent.createTest("LogIn Page Test with Valid credentials").assignAuthor("Akash")
					.assignDevice("Android");
			String userName = jsonUserData.get("correctUserName").getAsString();
			String password = jsonUserData.get("correctPassword").getAsString();
//			welcomePage.clickEnterToAccountButton();
			loginPage.enterLoginCredentials(userName, password);
			test.log(Status.PASS, "Entering valid login credentials ");
			test.log(Status.PASS, "Clicking login button");
			logger.info("LogIn Page Test Ended");
		} catch (Exception e) {
			logger.info("Test Page failed : " + e.getMessage());
		}
	}

	/**
	 * This test case is Implemented with the Language page Here we are selecting
	 * the application language
	 */
	@Test(priority = 7)
	public void selectLanguage() {
		try {
			logger.info("Select Language Page Test Started");
			if (languageSelectPage.getHeading().isDisplayed()) {
				test = extent.createTest("Select Language Page Test").assignAuthor("Akash").assignDevice("Android");
				test.log(Status.INFO, "Verifying if Heading is displayed as expected");
				String headingMessage = languageSelectPage.getHeading().getText().replaceAll("\\s+", " ").trim();
				String expectedMessage = jsonUserData.get("languageHeadingMsg").getAsString();
				boolean isMessageDisplayed = headingMessage.equals(expectedMessage);
				Assert.assertEquals(headingMessage, expectedMessage, "Heading Message is displayed as expected");
				test.log(isMessageDisplayed ? Status.PASS : Status.FAIL,
						isMessageDisplayed ? "Heading Message is displayed as expected"
								: "Heading Message is not displayed as expected");
				languageSelectPage.clickSelectLanguage();
				languageSelectPage.clickApplyButton();
			}
		} catch (Exception e) {
			logger.info("Select Language Page failed : " + e.getMessage());
		}
	}

	@Test(priority = 8)
	public void checkNotification() {
		try {
			logger.info("Notification check page Started");
			test = extent.createTest("Notification Page Test").assignAuthor("Akash").assignDevice("Android");
			homePage.clickNotification();
			test.log(Status.INFO, "Verifying if Notification Heading is displayed as expected");
			String headingMessage = homePage.getNotificationHeading().getText().replaceAll("\\s+", " ").trim();
			String expectedMessage = jsonUserData.get("notificationHeadingMsg").getAsString();
			boolean isMessageDisplayed = headingMessage.equals(expectedMessage);
			Assert.assertEquals(headingMessage, expectedMessage, "Heading Message is displayed as expected");
			test.log(isMessageDisplayed ? Status.PASS : Status.FAIL,
					isMessageDisplayed ? "Heading Message is displayed as expected"
							: "Heading Message is not displayed as expected");
			homePage.clickNotificationBack();
		} catch (Exception e) {
			homePage.clickNotificationBack();
			logger.info("Select Language Page failed : " + e.getMessage());
			logger.info("Notification Page failed : " + e.getMessage());
		}
	}

	@Test(priority = 9)
	public void searchItem() {
		try {
			logger.info("Search Item Test Started");
			test = extent.createTest("Search Item test").assignAuthor("Akash").assignDevice("Android");
			homePage.searchItem(jsonUserData.get("searchItem").getAsString());
			test.log(Status.INFO, "Item as been searched");
		} catch (Exception e) {
			logger.info("Search Item failed : " + e.getMessage());
		}
	}

	@Test(priority = 10)
	public void storePage() {
		try {
			logger.info("Search Item Test Started");
			test = extent.createTest("Store Page test").assignAuthor("Akash").assignDevice("Android");
			// Assertion 1
			test.log(Status.INFO, "Verifying if Conditions is displayed");
			boolean isConditionsDisplayed = goToStorePage.getConditionTxt().isDisplayed();
			Assert.assertTrue(isConditionsDisplayed, "Conditions should be displayed");
			test.log(isConditionsDisplayed ? Status.PASS : Status.FAIL,
					isConditionsDisplayed ? "Conditions are displayed" : "Conditions are not displayed");
			// Assertion 2
			test.log(Status.INFO, "Verifying if Reviews are displayed");
			boolean isReviewDisplayed = goToStorePage.getreviewTxt().isDisplayed();
			Assert.assertTrue(isReviewDisplayed, "Username field should be displayed");
			test.log(isReviewDisplayed ? Status.PASS : Status.FAIL,
					isReviewDisplayed ? "Reviews are displayed" : "Reviews are not displayed");
			goToStorePage.clickFavIcon();
			test.log(Status.PASS, "Added to Favourite");
			goToStorePage.clickStoreBtn();
			test.log(Status.PASS, "Store Button was clicked");
			// Assertion 3
			test.log(Status.INFO, "Verifying if CashBack status is displayed");
			boolean isCashBackStatusDisplayed = goToStorePage.getCashBackStatusTxt().isDisplayed();
			Assert.assertTrue(isCashBackStatusDisplayed, "CashBack status should be displayed");
			test.log(isCashBackStatusDisplayed ? Status.PASS : Status.FAIL,
					isCashBackStatusDisplayed ? "CashBack status is displayed" : "CashBack status is not displayed");
			Thread.sleep(10000);
			goToStorePage.closeWebBtn();
			// Assertion 4
			test.log(Status.INFO, "Verifying if close web confirm text is displayed as expected");
			String headingMessage = goToStorePage.getCloseWebConfirmTxt().getText().replaceAll("\\s+", " ").trim();
			String expectedMessage = jsonUserData.get("closeWebConfirmTxt").getAsString();
			boolean isMessageDisplayed = headingMessage.equals(expectedMessage);
			Assert.assertEquals(headingMessage, expectedMessage, "Message is displayed as expected");
			test.log(isMessageDisplayed ? Status.PASS : Status.FAIL,
					isMessageDisplayed ? "Message is displayed as expected" : "Message is not displayed as expected");
			goToStorePage.closeWebConfirmBtn();
			test.log(Status.PASS, "Web App closed successfully");
			goToStorePage.closeStoreBtn();
			goToStorePage.closeStoreBtn();
			test.log(Status.PASS, "Store closed successfully");
		} catch (Exception e) {
			logger.info("Store Page failed : " + e.getMessage());
		}
	}

	@Test(priority = 11)
	public void testProfile() {
		logger.info("Profile page test has Started");
		try {
			test = extent.createTest("Validating Profile Page").assignAuthor("Renuka").assignDevice("Android");
			test.log(Status.INFO, "Clicking Accounts icon");
			accountPage.clickAccountIcon();
			test.log(Status.INFO, "Selecting Settings option");
			accountPage.clickSettings();
			test.log(Status.INFO, "Verifying if Edit Profile is displayed");
			boolean isTitleDisplayed = accountPage.getTitleEditProfile().isDisplayed();
			Assert.assertTrue(isTitleDisplayed, "Title should be displayed");
			test.log(isTitleDisplayed ? Status.PASS : Status.FAIL,
					isTitleDisplayed ? "Edit Profile Title is displayed" : "Edit Profile Title is not displayed");
			test.log(Status.INFO, "Verifying if username is displayed");
			String userMail = jsonUserData.get("correctUserName").getAsString();
			String userName = accountPage.getUserId().getText().replaceAll("\\s+", " ").trim();
			String userId = userMail.substring(0, Math.min(userMail.length(), 8));
			boolean isUsernameDisplayed = userName.equals(userId);
			Assert.assertEquals(userName, userId, "Username is displayed as expected");
			test.log(isUsernameDisplayed ? Status.PASS : Status.FAIL,
					isUsernameDisplayed ? "Username is displayed as expected"
							: "Username is not displayed as expected");
			test.log(Status.INFO, "Verifying if user mail-id is displayed");
			String mailId = accountPage.getUserMailId().getText().replaceAll("\\s+", " ").trim();
			boolean isUserMailDisplayed = mailId.equals(userMail);
			Assert.assertEquals(mailId, userMail, "User mail is displayed as expected");
			test.log(isUserMailDisplayed ? Status.PASS : Status.FAIL,
					isUserMailDisplayed ? "User mail is displayed as expected"
							: "User mail is not displayed as expected");
			test.log(Status.INFO, "Selecting gender");
			accountPage.chooseGender();
			test.log(Status.INFO, "Closing Edit Profile page");
			accountPage.closeEditingProfile();
			accountPage.logOut();
			test.log(Status.PASS, "Logged out from the account successfully");
			Thread.sleep(5000);
			logger.info("Profile Page Test Ended");
		} catch (Exception e) {
			logger.info("Test Page failed : " + e.getMessage());
		}
	}
}
