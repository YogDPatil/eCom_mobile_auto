package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class CartPage extends AndroidUtils {

	private static final By CART_ITEM_NAME_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/productName");

	public CartPage(AndroidDriver driver) {
		super(driver);
	}

	public String getItemFromCart() {
		return findMobileElement(CART_ITEM_NAME_LOCATOR).getText();
	}

}
