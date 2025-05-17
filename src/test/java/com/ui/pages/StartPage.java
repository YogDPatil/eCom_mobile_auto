package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class StartPage extends AndroidUtils {

	private static final By NAME_FIELD_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/nameField");
	private static final By NOTIFICATION_PERMISSION_DENY_LOCATOR = AppiumBy
			.id("com.android.permissioncontroller:id/permission_deny_button");
	private static final By USERNAME_HEADER_LOCATOR = AppiumBy.id("com.meesho.supply:id/usernameTxt");
	private static final By WELCOME_HEADER_LOCATOR = AppiumBy
			.xpath("//android.widget.TextView[@resource-id='com.meesho.supply:id/title']");

	public StartPage(AndroidDriver driver) {
		super(driver);
	}

	public void verifyUserNavigatesToProductsPage() {
		enterText(NAME_FIELD_LOCATOR, "Yogesh");
//		clickOnGesture(NOTIFICATION_PERMISSION_DENY_LOCATOR);
//		if (findMobileElement(USERNAME_HEADER_LOCATOR).isDisplayed()
//				&& findMobileElement(WELCOME_HEADER_LOCATOR).isDisplayed()) {
//			System.out.println(findMobileElement(WELCOME_HEADER_LOCATOR).getText() + ", "
//					+ findMobileElement(USERNAME_HEADER_LOCATOR).getText() + " is on home page.");
//		}
	}

}
