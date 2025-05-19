package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class ProductsPage extends AndroidUtils {

	private AndroidDriver driver;

	private static final By PRODUCTS_PAGE_TITLE_LOCATOR = AppiumBy
			.id("com.androidsample.generalstore:id/toolbar_title");
	private static final By PRODUCT_NAMES_LIST_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/productName");
	private static final By ADD_TO_CART_BUTTON_LIST_LOCATOR = AppiumBy
			.id("com.androidsample.generalstore:id/productAddCart");
	private static final By CART_ICON_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
	private static final By ADD_TO_CART_BUTTON_LIST_LOCATOR_By_Text = AppiumBy
			.xpath("//android.widget.TextView[@text='ADD TO CART']");

	public ProductsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getProductPageTitle() {
		return findMobileElement(PRODUCTS_PAGE_TITLE_LOCATOR).getText();
	}

	public CartPage userAddsProductToCart(String text) {
		scrollingUptoElement(text);
		for (int i = 0; i < findListOfMobileElement(PRODUCT_NAMES_LIST_LOCATOR).size(); i++) {
			if (findListOfMobileElement(PRODUCT_NAMES_LIST_LOCATOR).get(i).getText().equals(text)) {
				findListOfMobileElement(ADD_TO_CART_BUTTON_LIST_LOCATOR).get(i).click();
			}
		}
		clickOnGesture(CART_ICON_LOCATOR);
		return new CartPage(driver);
	}

	public CartPage userAddsMultipleProducts(String text) {
		scrollingUptoElement(text);
		for (int i = 0; i < findListOfMobileElement(PRODUCT_NAMES_LIST_LOCATOR).size(); i++) {
			findListOfMobileElement(ADD_TO_CART_BUTTON_LIST_LOCATOR_By_Text).get(0).click();
		}
		clickOnGesture(CART_ICON_LOCATOR);
		return new CartPage(driver);
	}

}
