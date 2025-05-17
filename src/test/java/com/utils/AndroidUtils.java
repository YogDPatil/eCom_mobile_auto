package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public abstract class AndroidUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;

	public AndroidUtils(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickOn(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickOnGesture(By locator) {
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(locator))).getId()));
	}

	public WebElement findMobileElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void enterText(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}
}
