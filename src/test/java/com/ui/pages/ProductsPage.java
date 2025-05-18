package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidUtils;

import io.appium.java_client.android.AndroidDriver;

public final class ProductsPage extends AndroidUtils {

	private static final By PRODUCTS_PAGE_TITLE_LOCATOR = By.id("com.androidsample.generalstore:id/toolbar_title");

	public ProductsPage(AndroidDriver driver) {
		super(driver);
	}

	public String getProductPageTitle() {
		return findMobileElement(PRODUCTS_PAGE_TITLE_LOCATOR).getText();
	}

}
