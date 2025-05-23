package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public final class CartPage extends AndroidUtils {
	private AndroidDriver driver;

	private static final By CART_ITEM_NAME_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/productName");
	private static final By PRODUCT_PRICE_LIST_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/productPrice");
	private static final By TOTAL_PRICE_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");
	private static final By VISIT_TO_WEBSITE_BTN_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/btnProceed");

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
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

	public void userNavigatesToWebAndHitUrl() {
		clickOnGesture(VISIT_TO_WEBSITE_BTN_LOCATOR);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (String cont : driver.getContextHandles()) {
			System.out.println("Active context :" + cont);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("https://www.medscape.com/");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}

}
