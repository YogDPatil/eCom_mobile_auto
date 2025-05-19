package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class CartPage extends AndroidUtils {

	private static final By CART_ITEM_NAME_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/productName");
	private static final By PRODUCT_PRICE_LIST_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/productPrice");
	private static final By TOTAL_PRICE_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");

	public CartPage(AndroidDriver driver) {
		super(driver);
	}

	public String getItemFromCart() {
		return findMobileElement(CART_ITEM_NAME_LOCATOR).getText();
	}

	public double sumOfAddedItemPrice() {
		scrollUptoTheBottomOfPage();
		double sum = 0.0;
		for (WebElement ele : findListOfMobileElement(PRODUCT_PRICE_LIST_LOCATOR)) {
			sum = sum + Double.parseDouble(ele.getText().substring(1));
		}
		System.out.println("Total calculated amount :" + sum);
		return sum;
	}

	public double getTotalPriceOfCartItems() {
		System.out.println("Total amount :" + findMobileElement(TOTAL_PRICE_LOCATOR).getText().substring(2));
		return Double.parseDouble(findMobileElement(TOTAL_PRICE_LOCATOR).getText().substring(2));
	}

}
