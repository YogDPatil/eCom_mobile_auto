package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.utils.AndroidUtils;

import io.appium.java_client.android.AndroidDriver;

public final class MobileBrowserPage extends AndroidUtils {

	private AndroidDriver driver;

	private static final By SEARCH_BOX_LOCATOR = By.name("q");

	public MobileBrowserPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUrl(String url) {
		driver.get(url);
//		findMobileElement(SEARCH_BOX_LOCATOR).sendKeys(url);
//		findMobileElement(SEARCH_BOX_LOCATOR).sendKeys(Keys.ENTER);
	}

}
