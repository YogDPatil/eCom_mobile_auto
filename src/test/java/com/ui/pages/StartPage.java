package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public final class StartPage extends AndroidUtils {

	private AndroidDriver driver;

	private static final By NAME_FIELD_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/nameField");
	private static final By COUNTRY_DROPDOWN_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
	private static final By LETS_SHOP_BUTTON_LOCATOR = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
	private static final By GENDER_RADIO_BUTTONS = AppiumBy.xpath("//android.widget.RadioButton");
	private static final By COUNTRY_LIST_LOCATOR = AppiumBy.id("android:id/text1");

	public StartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public ProductsPage goToProductsPage() {
		enterText(NAME_FIELD_LOCATOR, "Yogesh");
		clickOnElementFromListOfMobileElement(GENDER_RADIO_BUTTONS, "Male");
		clickOnGesture(COUNTRY_DROPDOWN_LOCATOR);
		scrollUptoElementAndSelectTheElement("India", COUNTRY_LIST_LOCATOR);
		clickOnGesture(LETS_SHOP_BUTTON_LOCATOR);
		return new ProductsPage(driver);
	}

}
