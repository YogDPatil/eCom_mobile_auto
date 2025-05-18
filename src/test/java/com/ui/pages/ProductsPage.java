package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class ProductsPage extends AndroidUtils {

	private static final By PRODUCTS_PAGE_TITLE_LOCATOR = AppiumBy
			.id("com.androidsample.generalstore:id/toolbar_title");
	private static final By PRODUCT_NAMES_LIST_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/productName");
	private static final By ADD_TO_CART_BUTTON_LIST_LOCATOR = AppiumBy
			.id("com.androidsample.generalstore:id/productAddCart");

	public ProductsPage(AndroidDriver driver) {
		super(driver);
	}

	public String getProductPageTitle() {
		return findMobileElement(PRODUCTS_PAGE_TITLE_LOCATOR).getText();
	}

	public void verifyUserAddsProductToCart(String text) {
		scrollingUptoElement(text);
		for (int i = 0; i < findListOfMobileElement(PRODUCT_NAMES_LIST_LOCATOR).size(); i++) {
			if (findListOfMobileElement(PRODUCT_NAMES_LIST_LOCATOR).get(i).getText().equals(text)) {
				findListOfMobileElement(ADD_TO_CART_BUTTON_LIST_LOCATOR).get(i).click();
			}
		}

	}

}
