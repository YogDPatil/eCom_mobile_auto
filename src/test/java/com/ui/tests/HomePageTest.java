package com.ui.tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public final class HomePageTest extends TestBase {

	@Test
	public void validateUserNavigatesToProductsPage() {
		startPage.verifyUserNavigatesToProductsPage();
	}

}
